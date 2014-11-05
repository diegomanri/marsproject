package marsPackage;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProTab extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel eastPanel;
    private JButton advSbutton;
    private JButton quickSbutton;
    private JButton tNextButton;
    private JButton tPrevButton;
    private JButton viewProjectButton;
    private JButton addProjectButton;
    private JLabel proTableTitle;
    private JTextField quickSfield;
    private JLabel quickSspace;
    private JLabel quickSspace2;
    private JPanel quickSpanel;
    private JPanel proPanel;
    private JPanel contentPane;
    private JPanel tablePanel;
    private JPanel tableNavPanel;
    private JPanel westPanel;
    private JPanel bButtonsPanel;
    private JTable proTable;
    private JScrollPane proTableSP;
    private JScrollPane scrollPane;
    
    //CardLayout variables
    private JPanel cardPanel;
    private static final String CARD_PROJECTTAB = "Card Project Tab";
    private static final String CARD_NEWPROJECT = "Card Add Project";
    private NewProject newProject;
    //private TabPanel tp = new TabPanel();
    
    /*
     * Constructor
     * All of your GUI components should be added to
     * contentPane using the gridBagLayout.
     */
    
    public ProTab(){
    	
    //Create cardPanel the panel that holds all the cards.
    cardPanel = new JPanel();
    cardPanel.setLayout(new CardLayout(0,3));    	
    	
    //Creating the proPanel that holds all other panels (below cardPanel)
    proPanel = new JPanel();
    proPanel.setBackground(new Color(204, 255, 102));

    
    /*
      ==========================
      CardLayout Class Instances
      ==========================
    */

    cardPanel.add(proPanel, CARD_PROJECTTAB);
    newProject = new NewProject();
    cardPanel.add(newProject.getNewProPanel(), CARD_NEWPROJECT);
 
    
    
    //Creating the contentPane that holds all GUI components and
    //uses vertical/horizontal sidebars as needed
    contentPane = new JPanel();
    contentPane.setBackground(Color.WHITE);
   
    //Giving the contentPane the GridBagLayout
    contentPane.setLayout(new GridBagLayout());
    GridBagConstraints g = new GridBagConstraints();
    g.insets = new Insets(20,0,0,0);
    
    //Adding scrollPane to Content Pane and adding those two to proPanel
    scrollPane = new JScrollPane(contentPane);
    scrollPane.setPreferredSize(new Dimension(875, 550));
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBackground(Color.WHITE);
    proPanel.add(scrollPane);
    
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
    
    // Project Table START
    
    // Adding temporary data
    String[] columns = {"Select","Project Name","Customer","Start Date","End Date","Status"};
    Integer[][] data = new Integer[1000][columns.length];
    
        for (int xx=0; xx<data.length; xx++) {
            for (int yy=0; yy<data[0].length; yy++) {
                data[xx][yy] = new Integer((xx+1)*(yy+1));
            }
        }
    
    final int rows = 19;
        
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
    
    proTable = new JTable(
    		new DefaultTableModel(data, columns));
    		
    proTableSP = new JScrollPane(
    		proTable, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    		Dimension d = proTable.getPreferredSize();
    		proTableSP.setPreferredSize(new Dimension(d.width,proTable.getRowHeight()*rows));	
    
    //Panel that contains the table's navigation buttons.
    tableNavPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));		
    
    tNextButton = new JButton(">");
    	tNextButton.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			int height = proTable.getRowHeight()*(rows-1);
    			JScrollBar bar = proTableSP.getVerticalScrollBar();
    			bar.setValue(bar.getValue()+height);
    			}
    	});
    		
    tPrevButton = new JButton("<");
	tPrevButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			int height = proTable.getRowHeight()*(rows-1);
			JScrollBar bar = proTableSP.getVerticalScrollBar();
			bar.setValue(bar.getValue()-height);
			}
    	});
    
	//Adding a title label and append it to the top of the Table panel.
    proTableTitle = new JLabel("KIS PROJECTS");
    proTableTitle.setFont(new Font("Serif", Font.PLAIN, 25));
    tablePanel.add(proTableTitle, BorderLayout.NORTH);
	
	tableNavPanel.add(tPrevButton);
	tableNavPanel.add(tNextButton);
	
	tablePanel.add(proTableSP, BorderLayout.CENTER);
	tablePanel.add(tableNavPanel, BorderLayout.SOUTH);
	
    //Project Table END
	
	//Project bottom buttons START
	
	 bButtonsPanel = new JPanel();
	 bButtonsPanel.setBackground(Color.WHITE);
	 bButtonsPanel.setBorder(BorderFactory.createMatteBorder(0,0,0,0, Color.gray));
	 bButtonsPanel.setLayout(new FlowLayout());
	    g.anchor = GridBagConstraints.PAGE_END;
	    g.gridx = 0;
	    g.gridy = 2;
	    contentPane.add(bButtonsPanel, g);
	    
	viewProjectButton = new JButton("View Selected Project");
	addProjectButton = new JButton ("Add a New Project");
	
	bButtonsPanel.add(viewProjectButton);
	bButtonsPanel.add(addProjectButton);
	
	addProjectButton.addActionListener(new buttonListener());
	
	//Project bottom buttons END
	
    }
    
  //Project bottom buttons ActionListeners
    private class buttonListener implements ActionListener{
  		public void actionPerformed(ActionEvent ae){
  			if (ae.getSource() == addProjectButton){
  			CardLayout cl = (CardLayout) cardPanel.getLayout();
  			cl.show(cardPanel, CARD_NEWPROJECT);
  			}
  		}
    }
    
    
    /**
     * The getProTab method returns a ProTab JPanel object.
     * @return a ProTab panel object.
     */
    
	public JPanel getProTab(){
		return proPanel;
	}
	
    /**
     * The getCardPanel method returns a cardPanel JPanel object.
     * @return a ProTab panel object.
     */
	
	public JPanel getCardPanel(){
		return cardPanel;
	}
	
	/*
	public String getCARD_PROJECTTAB(){
		return CARD_PROJECTTAB;
	}
	*/
}
