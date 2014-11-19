package marsPackage;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Test extends JFrame {
	
	private static JScrollPane scrollPane;
	private static JTable table;
	
	public Test()
	{
		add(scrollPane, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		try {
			
			
			String url = "jdbc:sqlserver://ANTHONY-PC\\MSSQLSERVER;databaseName=KIS_DB;integratedSecurity=true";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url);
            System.out.println("connection created");
            Statement st= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            String sql="SELECT * FROM EMPLOYEE";
            ResultSet rs=st.executeQuery(sql);
            
            ResultSetMetaData meta = rs.getMetaData();
            
            int colCount = meta.getColumnCount();
            String[] colNames = new String[colCount];
            
            rs.last();
            int numRows = rs.getRow();
            rs.first();
            
            String[][] data = new String[numRows][colCount];
            
            for(int i = 0; i < numRows; i++)
            {
            	for(int j = 0; j < colCount; j++)
            		data[i][j] = rs.getString(j + 1);
            	rs.next();
            }
            
            for(int i = 0; i < colCount; i++)
            {
            	colNames[i] = meta.getColumnLabel(i + 1);
            }
            
            table = new JTable(data, colNames);
            scrollPane = new JScrollPane(table);

	}
		catch(Exception e){
		;
		}
		
}
}

