package book;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

@SuppressWarnings("serial")
public class AddBookDialog extends JDialog implements ActionListener{
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
	public AddBookDialog(Frame owner,String title,boolean model){
		//父窗口,窗口名,是否是模式窗口
		super(owner,title,model);
		bookNumLabel=new JLabel("书    号:");
		bookNameLabel=new JLabel("书    名:");
		bookWriterLabel=new JLabel("作    者:");
		bookPublishLabel=new JLabel("出版社:");
		bookSumLabel=new JLabel("数   量:");
		bookTimeLabel=new JLabel("出版时间:");
		
		bookNumText=new JTextField(10);
		bookNameText=new JTextField(10);
		bookWriterText=new JTextField(10);
		bookPublishText=new JTextField(10);
		bookSumText=new JTextField(10);
		bookTimeText=new JTextField(9);
		
		submitBut=new JButton("确认");
		cancelBut=new JButton("取消");
		submitBut.addActionListener(this);
		cancelBut.addActionListener(this);
		this.setBounds(350,150,400,260);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		initLayout();
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==submitBut){
			if(bookNumText.getText().equals("")||bookNameText.getText().equals("")||
					bookWriterText.getText().equals("")||bookPublishText.getText().equals("")||
					bookSumText.getText().equals("")||bookTimeText.getText().equals("")){
				//System.out.println("输入失败");
			    JOptionPane.showMessageDialog(this,"输入不能有空", "提示",JOptionPane.PLAIN_MESSAGE);
			}
			else{
				//System.out.println("输入成功");
				String sql="insert into "
						+ "book_info(book_num,book_name,book_writer,publish_house,book_sum,publish_time)"
						+ "values('"+bookNumText.getText()+"','"+bookNameText.getText()+"','"+bookWriterText.getText()+"','"+bookPublishText.getText()+"','"+bookSumText.getText()+"','"+bookTimeText.getText()+"')";
				try {
					BookTableModel book=new BookTableModel();
					book.addBook(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(this,"添加成功", "提示",JOptionPane.PLAIN_MESSAGE);
			    this.setVisible(false);
			}
		}
		if(e.getSource()==cancelBut){
			this.setVisible(false);
		}
	}
}
