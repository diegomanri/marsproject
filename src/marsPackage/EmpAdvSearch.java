package marsPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.*;

public class EmpAdvSearch extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3591111934738695424L;
	
	private JPanel advSearchPanel;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel41;
	private JPanel panel42;
	private JPanel panel43;
	private JPanel panel44;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JScrollPane sp;
	private JPanel cardPanel;
	private JPanel empPanel;
	 private static final String CARD_EMPLOYEETAB = "Card Employee Tab";
	    private static final String CARD_NEWEMPLOYEE = "Card Add Employee";
	    private static final String CARD_VIEWEMPLOYEE = "Card View Employee";
	    private static final String CARD_EMP_ADV_SEARCH = "Card Employee Advanced Search";
	private JButton backEmpTabButton2;
	
	
	
	public EmpAdvSearch(){
	    empPanel = new JPanel();

		//cardPanel.add(empPanel, CARD_EMPLOYEETAB);

		advSearchPanel = new JPanel();
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		    
		 //Giving the contentPane the GridBagLayout
		 contentPane.setLayout(new GridBagLayout());
		 GridBagConstraints g = new GridBagConstraints();
		 g.insets = new Insets(20,0,0,0);
		    
		 //Adding scrollPane to Content Pane and adding those two to cusPanel
	     sp = new JScrollPane(contentPane);
		 sp.setPreferredSize(new Dimension(875, 550));
		 sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		 sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		 sp.setBackground(Color.WHITE);
		 advSearchPanel.add(sp);
		
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints f = new GridBagConstraints();
		f.insets = new Insets(20,0,0,0);
		g.anchor = GridBagConstraints.NORTH;
	    g.gridx = 0;
	    g.gridy = 0;
	  contentPane.add(panel, g);
		
		contentPane.add(panel);
		
			panel_2 = new JPanel();
			panel_2.setBorder(BorderFactory.createTitledBorder("Personal Information"));
			panel_2.setBackground(Color.white);
			panel_2.setBounds(10, 27, 474, 55);
		    f.gridx = 0;
		    f.gridy = 1;
		  contentPane.add(panel_2, f);
		//panel.add(panel_2);
		
			JLabel label = new JLabel("First Name: ");
			panel_2.add(label);
			
			textField = new JTextField();
			textField.setColumns(10);
			panel_2.add(textField);
			
			JLabel label2 = new JLabel("Last Name: ");
			panel_2.add(label2);
			
			JTextField textField2 = new JTextField();
			textField2.setColumns(10);
			panel_2.add(textField2);

		panel_3 = new JPanel();
		//panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createTitledBorder("Project"));
		panel_3.setPreferredSize(new Dimension(400, 100));
		panel_3.setBackground(Color.white);
		panel_3.setBounds(10, 80, 474, 99);
	    f.gridx = 0;
	    f.gridy = 2;
	  contentPane.add(panel_3, f);
		//panel.add(panel_3);
		
		JLabel label_1 = new JLabel("Assigned to Project?");
		label_1.setBounds(16, 24, 49, 14);
		panel_3.add(label_1);
		
		JCheckBox YES = new JCheckBox("YES");
		YES.setBounds(190, 21, 78, 23);
		YES.setBackground(Color.WHITE);
		panel_3.add(YES);
		
		JCheckBox NO = new JCheckBox("NO");
		NO.setBounds(190, 21, 78, 23);
		NO.setBackground(Color.WHITE);
		panel_3.add(NO);
		
		JLabel label_CUST = new JLabel("Customer: ");
		label_CUST.setBounds(16, 24, 49, 14);
		
		JPanel panel_7 = new JPanel((new BorderLayout()));
		panel_7.add(label_CUST, BorderLayout.WEST);

		JComboBox custName = new JComboBox();
		f.gridx=2;
		f.gridy=2;
		panel_7.add(custName);
		panel_3.add(panel_7);
		DB db = new DB();
		
		//panel_7.setBorder(BorderFactory.createTitledBorder());
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(10, 178, 474, 173);
		f.gridx = 0;
		f.gridy = 3;
try {
			
    	String sql="SELECT CUST_NAME FROM CUSTOMER";

		PreparedStatement Stmt = db.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = Stmt.executeQuery();
		ResultSetMetaData meta = Stmt.getMetaData();
          while (rs.next())
          {
        	  custName.addItem(rs.getString("CUST_NAME"));
          }
            
            

}
		catch(Exception e){
		e.printStackTrace();
		}
		

		/*textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(63, 21, 86, 20);
		panel_3.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(63, 46, 86, 20);
		panel_3.add(textField_2);
		
		JLabel label_2 = new JLabel("Email");
		label_2.setBounds(16, 49, 49, 14);
		panel_3.add(label_2);
		*/
		panel_4 = new JPanel((new BorderLayout()));
		panel_4.setBorder(BorderFactory.createTitledBorder("Resume Information"));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(10, 178, 474, 173);
	    f.gridx = 0;
	    f.gridy = 3;
	    contentPane.add(panel_4, f);
		
	    panel41 = new JPanel();
	    panel41.setBackground(Color.WHITE);
		JLabel label_3 = new JLabel("Are you looking for a non-employee candidate?");
		label_3.setBounds(10, 25, 175, 14);
		panel41.add(label_3);
		panel_4.add(panel41, BorderLayout.NORTH);
	
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("YES");
		chckbxNewCheckBox_2.setBounds(270, 21, 96, 23);
		chckbxNewCheckBox_2.setBackground(Color.WHITE);
		panel41.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("NO");
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setBounds(368, 21, 86, 23);
		panel41.add(chckbxNewCheckBox);
		
		panel42 = new JPanel(new BorderLayout());
		panel42.setBackground(Color.WHITE);
		JLabel lblIndustry = new JLabel("Industry: ");
		lblIndustry.setBounds(51, 57, 129, 14);
		//panel42.add(lblIndustry, BorderLayout.NORTH);
		panel_4.add(lblIndustry, BorderLayout.WEST);
		
		JComboBox industryName = new JComboBox();
		f.gridx=0;
		f.gridy=0;
		panel_4.add(industryName);
		
		//panel_4.add(skillTable);
		//DB db = new DB();
try {
			
    	String sql="SELECT INDUSTRY_NAME FROM INDUSTRY";

		PreparedStatement Stmt = db.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = Stmt.executeQuery();
		ResultSetMetaData meta = Stmt.getMetaData();
          while (rs.next())
          {
        	  industryName.addItem(rs.getString("INDUSTRY_NAME"));
          }
            
            

}
		catch(Exception e){
		e.printStackTrace();
		}
		
		////// SKILL TABLE
		JPanel panel_6 = new JPanel((new BorderLayout()));
		panel_6.setBorder(BorderFactory.createTitledBorder("Skills"));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(10, 178, 474, 173);
		f.gridx = 0;
		f.gridy = 3;

		
		JComboBox skillName = new JComboBox();
		f.gridx=0;
		f.gridy=0;
		panel_6.add(skillName);
		panel_4.add(panel_6, BorderLayout.SOUTH);
		
		JLabel lblAdvancedSearchFor = new JLabel("ADVANCED SEARCH FOR EMPLOYEES");
		lblAdvancedSearchFor.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdvancedSearchFor.setForeground(Color.BLACK);
		lblAdvancedSearchFor.setBackground(Color.RED);
		lblAdvancedSearchFor.setBounds(10, 11, 469, 14);
	    f.gridx = 0;
	    f.gridy = 0;
	    contentPane.add(lblAdvancedSearchFor, f);
	    
	    JButton clear = new JButton("Clear");
	    JButton search = new JButton("Search");
	    f.gridx = 1;
	    f.gridy = 5;
	    contentPane.add(clear, f);

	    f.gridx = 3;
	    f.gridy = 5;
	    contentPane.add(search, f);

	    backEmpTabButton2 = new JButton("Go Back");
		backEmpTabButton2.addActionListener(new mainEmp2ButtonListener());


try {
	
	String sql="SELECT SKILL_NAME FROM SKILL";

	PreparedStatement Stmt = db.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	ResultSet rs = Stmt.executeQuery();
	ResultSetMetaData meta = Stmt.getMetaData();
      while (rs.next())
      {
    	  skillName.addItem(rs.getString("SKILL_NAME"));
      }
        
        

}
	catch(Exception e){
	e.printStackTrace();
	}
	    
	  
	}
	
	



	/**
	 * The getCusAdvSearch method returns an advSearchPanel object. 
	 * @return an advSearchPanel object from the CusAdvSearch class
	 */
	public JPanel getEmpAdvSearch(){
		return advSearchPanel;
	}

	    
	    private class mainEmp2ButtonListener implements ActionListener{
	  		public void actionPerformed(ActionEvent ae){
	  			if (ae.getSource() == backEmpTabButton2){
	  			CardLayout cl = (CardLayout) cardPanel.getLayout();
	  			cl.show(cardPanel, CARD_EMPLOYEETAB);
	  			}
	  		}
	    }
}

