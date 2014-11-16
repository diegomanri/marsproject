package marsPackage;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class MarsMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2953240271672230799L;
	private JLayeredPane panelHolder;
	private AppLogoPanel applogo;
	private TabPanel tabpanel;
	//private GridBagConstraints gbc;
	
	
	public MarsMain(){
		
		//Setting up the JFrame
		setTitle("MARS 1.0");
		setPreferredSize(new Dimension(1000, 710));
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * Layered panes do not have a layout manager which means
		 * I have to write the code that positions an sizes components
		 * within it.
		 */
		
		
		//Creating the panel holder
		panelHolder = new JLayeredPane();
		panelHolder.setPreferredSize(new Dimension(1000, 710));
		setLayout(new BorderLayout());
		add(panelHolder, BorderLayout.NORTH);
		panelHolder.setBounds(0, 0, 600, 400);
		
		//adding Application logo panel to panelHolder
		applogo = new AppLogoPanel();
		applogo.setBounds(-3, -5, 1000, 300);
		applogo.setBackground(Color.WHITE);
		panelHolder.add(applogo, new Integer(0));

		//adding the tabpanel panel to the panelHolder
		tabpanel = new TabPanel();
		tabpanel.setBounds(0, 110, 965, 761);
		panelHolder.add(tabpanel, new Integer(1));
		pack();
	}
	
	
	public static void main(String[] args) {
		

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    /*This commented out code is just a DB connection test.
                    String url = "jdbc:sqlserver://CoT-CIS3365-01\\MSSQLSERVER;databaseName=KIS_DB;integratedSecurity=true";
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection conn = DriverManager.getConnection(url);
                    System.out.println("connection created");
                    Statement st=conn.createStatement();
                    String sql="SELECT * FROM COUNTRY;";
                    ResultSet rs=st.executeQuery(sql);
                    while(rs.next()){
                            System.out.println("COUNTRY_ID: "+rs.getString(1));
                            System.out.println("COUNTRY_NAME: "+rs.getString(2));            
                    }
                    */
					//Thread.sleep(1);
					MarsMain frame = new MarsMain();
					frame.getContentPane().setBackground(Color.WHITE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
}
