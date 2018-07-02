package book;
import java.sql.*;
import java.util.*;

/*
 * 图书表模型
 * */
import javax.swing.table.*;
@SuppressWarnings("serial")
public class BookTableModel extends AbstractTableModel{
	//表的元素
	private Vector<Vector<String>> rowData;
	private Vector<String> colName;
    // 数据库
    private PreparedStatement stmt;
    private ResultSet result;
	public BookTableModel(String sql) throws SQLException{
		this.initData(sql);
	}
	public BookTableModel() throws SQLException{
		this.initData("SELECT * FROM book_info");
	}
	public void initData(String sql) throws SQLException{
		setRowData(new Vector<Vector<String>>());
		setColName(new Vector<String>());
		getColName().add("书号");
		getColName().add("书名");
		getColName().add("作者");
		getColName().add("出版社");
		getColName().add("出版时间");
		getColName().add("数量");
		/*
		 * 数据库的连接
		 * */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url= "jdbc:mysql://localhost:3306/book";
		String user="root";
		String password="123456";
		Connection con=DriverManager.getConnection(url,user,password);
	    stmt = con.prepareStatement(sql);
	    result=stmt.executeQuery();
	    importSQL();
	}
	void importSQL() throws SQLException{
		@SuppressWarnings("unused")
		boolean signNull=true;
		while(result.next()){
			Vector<String> item=new Vector<String>();
			for(int i=1;i<7;i++){
				item.add(result.getString(i));
			}
			getRowData().add(item);
			signNull=false;
		}
		result.close();
	}
	@Override
	public int getColumnCount() {//得到列数
		// TODO Auto-generated method stub
		return this.colName.size();
	}

	@Override
	public int getRowCount() {//得到行数
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	@Override
	public Object getValueAt(int row, int col) {//得到某行某列的数据
		// TODO Auto-generated method stub
		return (this.rowData.get(row)).get(col);
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return this.colName.get(column);
	}
	
	public Vector<Vector<String>> getRowData() {
		return rowData;
	}
	public void setRowData(Vector<Vector<String>> rowData) {
		this.rowData = rowData;
	}
	public Vector<String> getColName() {
		return colName;
	}
	public void setColName(Vector<String> colName) {
		this.colName = colName;
	}
	public void addBook(String sql){
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		initData("SELECT * FROM book_info");
	}
	public void deleteBook(String sql){
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
