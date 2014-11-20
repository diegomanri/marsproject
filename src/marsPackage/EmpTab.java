package marsPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class EmpTab extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9202509927813635761L;
	/*
	 * EmpTab main page variables
	 */
	private JPanel eastPanel;
    private JButton advSbutton;
    private JButton quickSbutton;
    private JButton tNextButton;
    private JButton tPrevButton;
    private JButton viewEmployeeButton;
    private JButton addEmployeeButton;
    private JLabel empTableTitle;
    private JTextField quickSfield;
    private JLabel quickSspace;
    private JLabel quickSspace2;
    private JPanel quickSpanel;
    private JPanel tablePanel;
    private JPanel tableNavPanel;
    private JPanel westPanel;
    private JPanel bButtonsPanel;
    private JScrollPane empTableSP;
    private JPanel empPanel;
    private JPanel contentPane;
    private JPanel advSearch;
    private JTable empTable;
    private JScrollPane scrollPane;
 
    /*
     * View Employee page
     */
    private JPanel viewEmpPanel;
	private JPanel vcontentPane;
	private JPanel vButtonsPanel;
    private JScrollPane vscrollPane;
	private JLabel viewTableTitle;
	private JButton backEmpTabButton2;
	private JButton viewResumeButton;
	private JButton saveEmpButton;
	private EmpPanels viewEmp;
    
    /*
     * New Employee page variables
     */
    private JPanel newEmpPanel;
	private JPanel ncontentPane;
	private JPanel tButtonsPanel;
    private JScrollPane nscrollPane;
    private JButton backEmpTabButton;
	private JButton upResumeButton;
	private JButton saveNewEmpButton;
	private JLabel buttonPanelSpace;
	private JLabel newTableTitle;
	private EmpPanels newEmp;
	private JButton backEmpTabButton3;
	
	/*
	 * CardLayout Variables
	 */
    private JPanel cardPanel;
    private static final String CARD_EMPLOYEETAB = "Card Employee Tab";
    private static final String CARD_NEWEMPLOYEE = "Card Add Employee";
    private static final String CARD_VIEWEMPLOYEE = "Card View Employee";
    private static final String CARD_EMP_ADV_SEARCH = "Card Employee Advanced Search";
    
    /*
     * Constructor
     * 
     */
    
    public EmpTab(){
    
    //Create cardPanel the panel that holds all the cards.
    cardPanel = new JPanel();
    cardPanel.setLayout(new CardLayout(0,4));    
    	
    //Creating the empPanel that holds main panels
    empPanel = new JPanel();
    empPanel.setBackground(new Color(255, 204, 153));
    
    //Creating advance search panel
    advSearch = new JPanel();
    
    //Creating view employee panel
    viewEmpPanel = new JPanel();
    
    //Creating the card newEmpPanel that holds the New Employee screen items
    newEmpPanel = new JPanel();
    newEmpPanel.setBackground(new Color(255, 205, 153));
    
    /*
    ==========================
    CardLayout Class Instances
    ==========================
     */
    cardPanel.add(empPanel, CARD_EMPLOYEETAB);
    cardPanel.add(advSearch, CARD_EMP_ADV_SEARCH);
    cardPanel.add(viewEmpPanel, CARD_VIEWEMPLOYEE);
    cardPanel.add(newEmpPanel, CARD_NEWEMPLOYEE);
    
    
    /*
	======================
	EmpTab main page START
	======================
     */
    
    //Creating the contentPane that holds all GUI components and
    //uses vertical/horizontal sidebars as needed
    contentPane = new JPanel();
    contentPane.setBackground(Color.WHITE);
    contentPane.setPreferredSize(new Dimension(857,595));
    
    //Giving the contentPane the GridBagLayout
    contentPane.setLayout(new GridBagLayout());
    GridBagConstraints g = new GridBagConstraints();
    g.insets = new Insets(20,0,0,0);
    
    //Adding scrollPane to Content Pane and adding those two to empPanel
    scrollPane = new JScrollPane(contentPane);
    scrollPane.setPreferredSize(new Dimension(875, 595));
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBackground(Color.WHITE);
    empPanel.add(scrollPane);
    
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
    contentPane.add(quickSpanel, g);
    
    	eastPanel = new JPanel();
    	eastPanel.setBackground(Color.WHITE);
    	eastPanel.setLayout(new FlowLayout());
    	quickSpanel.add(eastPanel, BorderLayout.EAST);
    
    		advSbutton = new JButton("Advanced Search");
    		eastPanel.add(advSbutton);
    
    	westPanel = new JPanel();
    	westPanel.setBackground(Color.WHITE);
    	westPanel.setLayout(new FlowLayout());
    	quickSpanel.add(westPanel, BorderLayout.WEST);
    
    		quickSfield = new JTextField("QuickSearch - Enter Name", 17);
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
    
    // Employee Table Start
    	
    
    //tablePanel contains the table and the panel that contains the table's navigation items (tableNavPanel)
    //And table Title panel as well!
	//Adding Table related panels to contentPane
    tablePanel = new JPanel(new BorderLayout(3,3));
    tablePanel.setBackground(Color.WHITE);
    tablePanel.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
    g.fill = GridBagConstraints.HORIZONTAL;
    g.insets = new Insets(20,0,0,0);
    g.gridx = 0;
    g.gridy = 1;
    contentPane.add(tablePanel, g);
    
    final int rows = 19;
	
	DB db = new DB();
	try {
		
		String sql = "SELECT EMPLOYEE.EMP_FIRST_NAME AS 'First Name'\n"
					+"	 , EMPLOYEE.EMP_LAST_NAME AS 'Last Name'\n"
					+"	 , EMPLOYEE.EMP_MIDDLE_INITIAL AS 'M.I.'\n"
					+"	 , EMPLOYEE_STATUS.EMP_STATUS AS 'Status'\n"
					+"	 , EMPLOYEE.EMP_EMAIL AS 'Email'\n"
				+"	FROM EMPLOYEE\n"
				+"	INNER JOIN EMPLOYEE_STATUS ON EMPLOYEE.EMP_STATUS_ID = EMPLOYEE_STATUS.EMP_STATUS_ID\n"
				+"	ORDER BY EMP_FIRST_NAME ASC;";
				
				
		PreparedStatement Stmt = db.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = Stmt.executeQuery();
		ResultSetMetaData meta = Stmt.getMetaData();
		
		int colCount = meta.getColumnCount();
		String[] colNames = new String[colCount];
		
		rs.last();
		int numRows = rs.getRow();
		rs.first();
		
		String[][] data = new String[numRows][colCount];
		
		for(int i2 = 0; i2 < numRows; i2++){
			for(int j2 = 0; j2 < colCount; j2++){
				data[i2][j2] = rs.getString(j2 + 1);
			}
			rs.next();
		}
		
		for(int i2 = 0; i2 < colCount; i2++){
			colNames[i2] = meta.getColumnLabel(i2 + 1);
		}
    
		empTable = new JTable(data, colNames);

	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		System.err.println("Something wrong with loading data to the project table in the GUI");
		e1.printStackTrace();
	}
	db.close();
    		
    		
    empTableSP = new JScrollPane(
    		empTable, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    		Dimension d = empTable.getPreferredSize();
    		empTableSP.setPreferredSize(new Dimension(d.width,empTable.getRowHeight()*rows));	    
    	    
    //Panel that contains the table's navigation buttons.
    tableNavPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));		
    	    
    tNextButton = new JButton(">");
    	tNextButton.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    	    	int height = empTable.getRowHeight()*(rows-1);
    	   		JScrollBar bar = empTableSP.getVerticalScrollBar();
    	 		bar.setValue(bar.getValue()+height);
    	    	}
    	 });
    	    		
    tPrevButton = new JButton("<");
   	tPrevButton.addActionListener(new ActionListener(){
   		public void actionPerformed(ActionEvent e){
   			int height = empTable.getRowHeight()*(rows-1);
   			JScrollBar bar = empTableSP.getVerticalScrollBar();
   			bar.setValue(bar.getValue()-height);
    		}
    	});
    	    
    //Adding a title label and append it to the top of the Table panel.
    empTableTitle = new JLabel("KIS Employees");
    empTableTitle.setFont(new Font("Serif", Font.PLAIN, 25));
    tablePanel.add(empTableTitle, BorderLayout.NORTH);
    		
    tableNavPanel.add(tPrevButton);
    tableNavPanel.add(tNextButton);
    		
    tablePanel.add(empTableSP, BorderLayout.CENTER);
    tablePanel.add(tableNavPanel, BorderLayout.SOUTH);
    		
    //Employee Table END
    
    //Employee bottom buttons START
	
  	 bButtonsPanel = new JPanel();
  	 bButtonsPanel.setBackground(Color.WHITE);
  	 bButtonsPanel.setBorder(BorderFactory.createMatteBorder(0,0,0,0, Color.gray));
  	 bButtonsPanel.setLayout(new FlowLayout());
  	    g.anchor = GridBagConstraints.PAGE_END;
  	    g.gridx = 0;
  	    g.gridy = 2;
  	    contentPane.add(bButtonsPanel, g);
  	    
  	viewEmployeeButton = new JButton("View Selected Employee");
  	addEmployeeButton = new JButton ("Add a New Employee");
  	
  	bButtonsPanel.add(viewEmployeeButton);
  	bButtonsPanel.add(addEmployeeButton);
  	
  	viewEmployeeButton.addActionListener(new viewEmpButtonListener());
  	addEmployeeButton.addActionListener(new newEmpButtonListener());
  	advSbutton.addActionListener(new empAdvSearch());

  	
  	
  	//Employee bottom buttons END
  	
  	/*
	====================
	EmpTab main page END
	====================
  	 */
  	
  	/*
	======================
	View Employee page START
	======================
  	 */
    	
  	//contentPane Panel holds all other panels together in this class.
    vcontentPane = new JPanel();
    vcontentPane.setBackground(Color.WHITE);
    //vcontentPane.setPreferredSize(new Dimension(857,595));
    
    //Giving the contentPane the GridBagLayout
    vcontentPane.setLayout(new GridBagLayout());
    GridBagConstraints v = new GridBagConstraints();
    v.insets = new Insets(20,0,0,0);
    
	//Adding scrollPane to Content Pane and adding those two to newEmpPanel
	vscrollPane = new JScrollPane(vcontentPane);
	vscrollPane.setPreferredSize(new Dimension(875, 595));
	vscrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	vscrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	vscrollPane.setBackground(Color.WHITE);
	viewEmpPanel.add(vscrollPane);
    
    /*
     * You may begin adding your GUI components from this point forward.
     * Remember to only use GridBagLayout with GridBagConstraints using the
     * f variable.
     */
	//New Table title
	viewTableTitle = new JLabel("Victor Martinez");
	viewTableTitle.setFont(new Font("Serif", Font.PLAIN, 25));
		v.anchor = GridBagConstraints.LINE_START;
		v.gridx = 0;
		v.gridy = 0;
		vcontentPane.add(viewTableTitle, v);
		
	//New Employee top buttons START
		
	vButtonsPanel = new JPanel();
	vButtonsPanel.setBackground(Color.WHITE);
	vButtonsPanel.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
	vButtonsPanel.setLayout(new FlowLayout());
		v.anchor = GridBagConstraints.PAGE_END;
		v.gridx = 0;
		v.gridy = 5;
		vcontentPane.add(vButtonsPanel, v);
		    
	backEmpTabButton2 = new JButton("Go Back");
	backEmpTabButton2.addActionListener(new mainEmp2ButtonListener());
		
	upResumeButton = new JButton("Upload Resume");
	upResumeButton.addActionListener(new uploadButtonListener());
	
	viewResumeButton = new JButton("View Resume");
	
		
	saveEmpButton = new JButton("Save Changes");
	saveEmpButton.setBackground(Color.GREEN);
		
	buttonPanelSpace = new JLabel();
	buttonPanelSpace.setPreferredSize(new Dimension(475, 0));
		
	vButtonsPanel.add(backEmpTabButton2);
	vButtonsPanel.add(upResumeButton);
	vButtonsPanel.add(viewResumeButton);
	vButtonsPanel.add(saveEmpButton);
	vButtonsPanel.add(buttonPanelSpace);
		
	//New Employee top buttons END
		
	//Status START
	viewEmp = new EmpPanels();
	JPanel tempPane = viewEmp.getStatusPanel1();
	v.anchor = GridBagConstraints.WEST;
	v.gridx = 0;
	v.gridy = 1;
	vcontentPane.add(tempPane, v);
		
		
	//Status END
	
	//Personal info START
	JPanel tempPane1 = viewEmp.personalInfoPanel(); 
	v.gridx = 0;
	v.gridy = 2;
	vcontentPane.add(tempPane1, v);
	
	//Personal info END
	
	//Contact info START
	JPanel tempPane2 = viewEmp.contactInfoPanel();
	v.gridx = 0;
	v.gridy = 3;
	vcontentPane.add(tempPane2, v);
	
	//Contact info END
	
	//Resume info START
	JPanel tempPane3 = viewEmp.resumeInfoPanel();
	v.gridx = 0;
	v.gridy = 4;
	vcontentPane.add(tempPane3, v);	
		
	/*
	 	====================
		Employee page END
		====================
	*/

  	/*
	======================
	New Employee page START
	======================
  	 */
    	
  	//contentPane Panel holds all other panels together in this class.
    ncontentPane = new JPanel();
    ncontentPane.setBackground(Color.WHITE);
    ncontentPane.setPreferredSize(new Dimension(857,595));
    
    //Giving the contentPane the GridBagLayout
    ncontentPane.setLayout(new GridBagLayout());
    GridBagConstraints f = new GridBagConstraints();
    f.insets = new Insets(20,0,0,0);
    
	//Adding scrollPane to Content Pane and adding those two to newEmpPanel
	nscrollPane = new JScrollPane(ncontentPane);
	nscrollPane.setPreferredSize(new Dimension(875, 595));
	nscrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	nscrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	nscrollPane.setBackground(Color.WHITE);
	newEmpPanel.add(nscrollPane);
    
    /*
     * You may begin adding your GUI components from this point forward.
     * Remember to only use GridBagLayout with GridBagConstraints using the
     * f variable.
     */
	//New Table title
	newTableTitle = new JLabel("New Employee");
	newTableTitle.setFont(new Font("Serif", Font.PLAIN, 25));
		f.anchor = GridBagConstraints.LINE_START;
		f.gridx = 0;
		f.gridy = 0;
		ncontentPane.add(newTableTitle, f);
		
	//New Employee top buttons START
		
	tButtonsPanel = new JPanel();
	tButtonsPanel.setBackground(Color.WHITE);
	tButtonsPanel.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
	tButtonsPanel.setLayout(new FlowLayout());
		f.anchor = GridBagConstraints.PAGE_END;
		f.gridx = 0;
		f.gridy = 1;
		ncontentPane.add(tButtonsPanel, f);
		    
	backEmpTabButton = new JButton("Go Back");
	backEmpTabButton.addActionListener(new mainEmpButtonListener());
		
	upResumeButton = new JButton("Upload Resume");
	upResumeButton.addActionListener(new uploadButtonListener());
		
	saveNewEmpButton = new JButton("Save New Employee");
	saveNewEmpButton.setBackground(Color.GREEN);
		
	buttonPanelSpace = new JLabel();
	buttonPanelSpace.setPreferredSize(new Dimension(475, 0));
		
	tButtonsPanel.add(backEmpTabButton);
	tButtonsPanel.add(upResumeButton);
	tButtonsPanel.add(saveNewEmpButton);
	tButtonsPanel.add(buttonPanelSpace);
		
	//New Employee top buttons END
		
	//Status START
	newEmp = new EmpPanels();
	JPanel newTempPane = newEmp.getStatusPanel1();
	f.gridx = 0;
	f.gridy = 2;
	ncontentPane.add(newTempPane, f);
		
		
	//Status END
		
	//Personal info START
	JPanel newTempPane1 = newEmp.personalInfoPanel();
	f.gridx = 0;
	f.gridy = 3;
	ncontentPane.add(newTempPane1, f);
	
	//Personal info END
	
	//Contact info START
	JPanel newTempPane2 = newEmp.contactInfoPanel();
	f.gridx = 0;
	f.gridy = 4;
	ncontentPane.add(newTempPane2, f);
		
	/*
	 	====================
		New Employee page END
		====================
	*/
	
	//contentPane Panel holds all other panels together in this class.
    JPanel advcontentPane = new JPanel();
    advcontentPane.setBackground(Color.WHITE);
	
	//Adding scrollpane for advSearch
	JScrollPane advscrollPane = new JScrollPane(advcontentPane);
	advscrollPane.setPreferredSize(new Dimension(875, 595));
	advscrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	advscrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	advscrollPane.setBackground(Color.WHITE);
	advSearch.add(advscrollPane);
	
	EmpAdvSearch advPanel = new EmpAdvSearch();
	JPanel advPanel1 = advPanel.getEmpAdvSearch();
	
    backEmpTabButton3 = new JButton("Go Back");
	backEmpTabButton3.addActionListener(new mainEmp2ButtonListener());
	advPanel1.add(backEmpTabButton3);

	advPanel1.setLayout(new GridBagLayout());
	GridBagConstraints x = new GridBagConstraints();
	x.gridx=0;
	x.gridy=0;
	
	advPanel1.add(backEmpTabButton3, x);
	x.gridx=1;
	x.gridy=1;
	advcontentPane.add(advPanel1, x);
    }
	
    
	 /*
    ======================
    Button ActionListeners
    ======================
    */
    
    private class newEmpButtonListener implements ActionListener{
  		public void actionPerformed(ActionEvent ae){
  			if (ae.getSource() == addEmployeeButton){
  			CardLayout cl = (CardLayout) cardPanel.getLayout();
  			cl.show(cardPanel, CARD_NEWEMPLOYEE);
  			}
  		}
    }
    
    public class viewEmpButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent ae){
    		if (ae.getSource() == viewEmployeeButton){
    			CardLayout c1 = (CardLayout) cardPanel.getLayout();
    			c1.show(cardPanel, CARD_VIEWEMPLOYEE);
    		}
    	}
    }
    
    public class uploadButtonListener implements ActionListener{
    	public void  actionPerformed(ActionEvent ae){
  			if (ae.getSource() == upResumeButton){
  			CardLayout cl = (CardLayout) cardPanel.getLayout();
  			//cl.show(cardPanel, CARD_NEWEMPLOYEE);
  			}
    	}
    }

    private class mainEmpButtonListener implements ActionListener{
  		public void actionPerformed(ActionEvent ae){
  			if (ae.getSource() == backEmpTabButton){
  			CardLayout cl = (CardLayout) cardPanel.getLayout();
  			cl.show(cardPanel, CARD_EMPLOYEETAB);
  			}
  		}
    }
    
    private class mainEmp2ButtonListener implements ActionListener{
  		public void actionPerformed(ActionEvent ae){
  			if (ae.getSource() == backEmpTabButton2){
  			CardLayout cl = (CardLayout) cardPanel.getLayout();
  			cl.show(cardPanel, CARD_EMPLOYEETAB);
  			}
  		}
    }
    
    private class empAdvSearch implements ActionListener{
  		public void actionPerformed(ActionEvent ae){
  			if (ae.getSource() == advSbutton){
  			CardLayout cl = (CardLayout) cardPanel.getLayout();
  			cl.show(cardPanel, CARD_EMP_ADV_SEARCH);
  			}
  		}
    }
    
    
    /*
    ==============
    EmpTab Methods
    ==============
    */
    
    
    /**
     * The getEmpTab method returns a EmpTab JPanel object.
     * @return a EmpTab panel object.
     */
    
	public JPanel getEmpTab(){
		return empPanel;
	}
	
    /**
     * The getCardPanel method returns a cardPanel JPanel object.
     * @return a ProTab panel object.
     */
	
	public JPanel getCardPanel(){
		return cardPanel;
	}
	
}