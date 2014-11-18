package marsPackage;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

public class CusTab {
	 private JPanel cusPanel;
	 private JPanel contentPane;
	 private JPanel cusCardHolder;
	 private JPanel quickSpanel;
	 private JPanel eastPanel;
	 private JPanel westPanel;
	 private JScrollPane scrollPane;
	 private JButton advSbutton;
	 private JButton quickSbutton;
	 private JTextField quickSfield;
	 private JLabel quickSspace;
	 private JLabel quickSspace2;
	 private static final String CARD_CUSTOMER = "Card Customer Tab";
	 private static final String CARD_CUST_ADV_SEARCH = "Card Customer Advanced Search";
	 private static final String CARD_NEWCUSTOMER = "Card Add Customer";
	 private CusAdvSearch advCus;
	    
	 /*
	  * Constructor
	  * All of your GUI components should be added to
	  * contentPane using the gridBagLayout.
	  */
	    
	 public CusTab(){
		 
	 //Creating cusCardHolder panel which holds ALL cards including cusPanel 
     cusCardHolder = new JPanel(new CardLayout(0,3));
     
     //Creating the cusPanel that holds everything except cusCardHolder
	 cusPanel = new JPanel();
	 cusPanel.setBackground(new Color(153, 204, 255));
     
     advCus = new CusAdvSearch();
     
     /*
     ==============================
     Adding cards to the cardholder
     ==============================
     */
     cusCardHolder.add(cusPanel, CARD_CUSTOMER);
     cusCardHolder.add(advCus.getCusAdvSearch(), CARD_CUST_ADV_SEARCH);
	    
	 //Creating the contentPane that holds all GUI components and
	 //uses vertical/horizontal sidebars as needed
	 contentPane = new JPanel();
	 contentPane.setBackground(Color.WHITE);
	    
	 //Giving the contentPane the GridBagLayout
	 contentPane.setLayout(new GridBagLayout());
	 GridBagConstraints g = new GridBagConstraints();
	    
	 //Adding scrollPane to Content Pane and adding those two to cusPanel
     scrollPane = new JScrollPane(contentPane);
	 scrollPane.setPreferredSize(new Dimension(875, 550));
	 scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	 scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	 scrollPane.setBackground(Color.WHITE);
	 cusPanel.add(scrollPane);
	    
	 /*
	  * You may begin adding your GUI components from this point forward.
	  * Remember to only use GridBagLayout with GridBagConstraints using the
	  * g variable.
	  */
	    //QuickSearch GUI top section START
     
	 quickSpanel = new JPanel();
	 
	    quickSpanel.setBackground(Color.WHITE);
	    quickSpanel.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
	    quickSpanel.setLayout(new BorderLayout());
	    g.anchor = GridBagConstraints.NORTH;
	    g.gridx = 0;
	    g.gridy = 0;
	  //Adding the quick search panel to the contentPane that holds GUI elements for the
	  //customers tab.
	  contentPane.add(quickSpanel, g);
	    
	    	eastPanel = new JPanel();
	    	eastPanel.setBackground(Color.WHITE);
	    	eastPanel.setLayout(new FlowLayout());
	    	quickSpanel.add(eastPanel, BorderLayout.EAST);
	    
	    		advSbutton = new JButton("Advanced Search");
	    		advSbutton.addActionListener(new advSearchButtonListener());
	    		eastPanel.add(advSbutton);
	    
	    	westPanel = new JPanel();
	    	westPanel.setBackground(Color.WHITE);
	    	westPanel.setLayout(new FlowLayout());
	    	quickSpanel.add(westPanel, BorderLayout.WEST);
	    
	    		quickSfield = new JTextField("QuickSearch - Enter project code", 17);
	    		westPanel.add(quickSfield);
	    		
	    		quickSfield.addMouseListener(new MouseAdapter(){
	    			public void mouseClicked(MouseEvent e){
	    				quickSfield.setText("");
	    			}
	    		});
	    
	    		quickSbutton = new JButton("Search");
	    		westPanel.add(quickSbutton);
	 
	    	quickSspace = new JLabel();
	    	quickSspace.setPreferredSize(new Dimension(400, 0));
	    	quickSpanel.add(quickSspace, BorderLayout.CENTER);
	    	
	    	quickSspace2 = new JLabel();
	    	quickSspace2.setPreferredSize(new Dimension(0, 20));
	    	quickSpanel.add(quickSspace2, BorderLayout.SOUTH);
	    
	    
	    //QuickSearch GUI top section END
	    	
	    	DB db = new DB();
	    	try {
	    		String sql = "SELECT * FROM PROJECT_STATUS;";
				PreparedStatement Stmt = db.getConnection().prepareStatement(sql);
				ResultSet rs = Stmt.executeQuery();
            while(rs.next()){
                    System.out.println("PRO_STATUS_ID: "+rs.getString(1));
                    System.out.println("PRO_STATUS_NAME: "+rs.getString(2));    
            }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.err.println("Something wrong with prepared statement test");
				e1.printStackTrace();
			}
	    	db.close();
	 }
	 
     /* 
     ======================
     Button ActionListeners
     ======================
   */  
   
 	private class advSearchButtonListener implements ActionListener{
   		public void actionPerformed(ActionEvent ae){
   			if (ae.getSource() == advSbutton){
   			CardLayout cl = (CardLayout) cusCardHolder.getLayout();
   			cl.show(cusCardHolder, CARD_CUST_ADV_SEARCH);
   			}
   		}
     }	    	
 	
 /*
     private class newProButtonListener implements ActionListener{
   		public void actionPerformed(ActionEvent ae){
   			if (ae.getSource() == addProjectButton){
   			CardLayout cl = (CardLayout) cardPanel.getLayout();
   			cl.show(cardPanel, CARD_NEWPROJECT);
   			}
   		}
     }

     private class mainProButtonListener implements ActionListener{
   		public void actionPerformed(ActionEvent ae){
   			if (ae.getSource() == backProTabButton){
   			CardLayout cl = (CardLayout) cardPanel.getLayout();
   			cl.show(cardPanel, CARD_PROJECTTAB);
   			}
   		}
     }
   */	    
	 /*
	 ==============
	 CusTab Methods
	 ==============
	 */
	    
	 /**
	  * The getCusTab method returns a CusTab object.
	  * @return a CusTab panel object.
	  */
	 
	public JPanel getCusTab(){
		return cusPanel;
	}
	
	 /**
	  * The getCusCardHolder method returns a cusCardHolder JPanel object.
	  * @return a cusCardHolder JPanel object.
	  */
	public JPanel getCusCardHolder(){
		return cusCardHolder;
	}
}
