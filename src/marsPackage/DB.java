package marsPackage;

import java.sql.*;

public class DB {

	private Connection dbConn = null;
	
	public Connection getConnection(){
		//This condition will check if the connection is not already open
		if (null == dbConn){
			//Setup a connection to the database
			String url = "jdbc:sqlserver://CoT-CIS3365-01\\MSSQLSERVER;databaseName=KIS_DB;integratedSecurity=true"; 
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				System.err.println("Class.forName thing is not working here");
				e1.printStackTrace();
			}
			try{
				dbConn = DriverManager.getConnection(url);
				
				PreparedStatement useStmt;
				try{
					useStmt = dbConn.prepareStatement("USE KIS_DB");
					//useStmt.executeUpdate();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
			catch(SQLException e){
				System.err.println("There was a problem connecting to the Database");
				e.printStackTrace();
			}
			/*
			finally{
				if (dbConn != null)
					try{dbConn.close();} catch(SQLException e){e.printStackTrace();}
			}*/
		}
		return dbConn;
	}
	
	public void close(){
		try {
			dbConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Could not close the connection");
			e.printStackTrace();
		}
	}
}
