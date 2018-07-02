package book;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

@SuppressWarnings("serial")
public class ModifyBook extends JDialog implements ActionListener{
	private JLabel bookNumLabel;
	private JLabel bookNameLabel;
	private JLabel bookWriterLabel;
	private JLabel bookPublishLabel;
	private JLabel bookSumLabel;
	private JLabel bookTimeLabel;
	private JTextField bookNumText;
	private JTextField bookNameText;
	private JTextField bookWriterText;
	private JTextField bookPublishText;
	private JTextField bookSumText;
	private JTextField bookTimeText;
	private JButton submitBut;
	private JButton cancelBut;
	private BookTableModel bookModel;
	private int rowNum;
	public ModifyBook(Frame owner,String title,boolean type,BookTableModel model,int row){
		super(owner,title,type);
		bookModel=model;
		rowNum=row;
		bookNumLabel=new JLabel("书    号:");
		bookNameLabel=new JLabel("书    名:");
		bookWriterLabel=new JLabel("作    者:");
		bookPublishLabel=new JLabel("出版社:");
		bookSumLabel=new JLabel("数    量:");
		bookTimeLabel=new JLabel("出版时间:");
		
		bookNumText=new JTextField(10);
		bookNameText=new JTextField(10);
		bookWriterText=new JTextField(10);
		bookPublishText=new JTextField(10);
		bookSumText=new JTextField(10);
		bookTimeText=new JTextField(9);
		
		submitBut=new JButton("确认修改");
		cancelBut=new JButton("取消");
		submitBut.addActionListener(this);
		cancelBut.addActionListener(this);
		this.setBounds(350,150,400,260);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.setValue();
		this.initLayout();
		
	}
	public void initLayout(){
		Container[] con1=new Container[6];
		for(int i=0;i<6;i++) con1[i]=new Container();
		con1[0].setLayout(new FlowLayout());
		con1[0].add(bookNumLabel);
		con1[0].add(bookNumText);
		
		con1[1].setLayout(new FlowLayout());
		con1[1].add(bookNameLabel);
		con1[1].add(bookNameText);
		
		con1[2].setLayout(new FlowLayout());
		con1[2].add(bookWriterLabel);
		con1[2].add(bookWriterText);
		
		con1[3].setLayout(new FlowLayout());
		con1[3].add(bookPublishLabel);
		con1[3].add(bookPublishText);
		
		con1[4].setLayout(new FlowLayout());
		con1[4].add(bookSumLabel);
		con1[4].add(bookSumText);
		
		con1[5].setLayout(new FlowLayout());
		con1[5].add(bookTimeLabel);
		con1[5].add(bookTimeText);
		
		Container con2=new Container();
		con2.setLayout(new BorderLayout());
		con2.add(con1[0],BorderLayout.NORTH);
		con2.add(con1[1],BorderLayout.CENTER);
		con2.add(con1[2],BorderLayout.SOUTH);
		
		Container con3=new Container();
		con3.setLayout(new BorderLayout());
		con3.add(con1[3],BorderLayout.NORTH);
		con3.add(con1[4],BorderLayout.CENTER);
		con3.add(con1[5],BorderLayout.SOUTH);
		
		Container con4=new Container();
		con4.setLayout(new FlowLayout());
		con4.add(submitBut);
		con4.add(cancelBut);
		Container con5=new Container();
		con5.setLayout(new BorderLayout());
		con5.add(con2,BorderLayout.NORTH);
		con5.add(con3,BorderLayout.CENTER);
		con5.add(con4,BorderLayout.SOUTH);
		this.add(con5,BorderLayout.CENTER);
		this.validate();
		this.setVisible(true);
	}
	public void setValue(){
		this.bookNumText.setText((String) bookModel.getValueAt(rowNum, 0));
		this.bookNumText.setEditable(false);//设置书号为不可更改项
		
		this.bookNameText.setText((String) bookModel.getValueAt(rowNum, 1));
		this.bookWriterText.setText((String) bookModel.getValueAt(rowNum, 2));
		this.bookPublishText.setText((String) bookModel.getValueAt(rowNum, 3));
		this.bookTimeText.setText((String) bookModel.getValueAt(rowNum, 4));
		this.bookSumText.setText((String) bookModel.getValueAt(rowNum, 5));
		this.validate();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	//	System.out.println(bookPriceText.getText());
		// TODO Auto-generated method stub
		if(e.getSource()==submitBut){
			if(bookNumText.getText().equals("")||bookNameText.getText().equals("")||
					bookWriterText.getText().equals("")||bookPublishText.getText().equals("")||
					bookSumText.getText().equals("")||bookTimeText.getText().equals("")){
				//System.out.println("输入失败");
			    JOptionPane.showMessageDialog(this,"修改不能有空", "提示",JOptionPane.PLAIN_MESSAGE);
			}
			else{
				int n = JOptionPane.showConfirmDialog(null, "确认修改吗?", "确认修改框", JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION) {
					String sql="UPDATE book_info SET book_name ='"+bookNameText.getText()+"', book_writer= '"+bookWriterText.getText()+"',publish_house='"+bookPublishText.getText()+"',book_sum='"+bookSumText.getText()+"',publish_time='"+bookTimeText.getText()+"' WHERE book_num = '"+bookNumText.getText()+"' ";
					try {
						BookTableModel book=new BookTableModel();
						book.addBook(sql);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(this,"修改成功", "提示",JOptionPane.PLAIN_MESSAGE);
				    this.setVisible(false);
				} else if (n == JOptionPane.NO_OPTION) {
					return;
				}
			}
		}
		if(e.getSource()==cancelBut){
			this.setVisible(false);
		}
	}	
}
