package marsPackage;

import java.awt.*;

import javax.swing.*;

import java.lang.*;

public class ResTab {
	private JLabel testLabel1;
    private JLabel testLabel2;
    private JLabel testLabel3;
    private JLabel testLabel4;
    private JLabel testLabel5;
    private JPanel testPanel1;
    private JPanel testPanel2;
    private JPanel testPanel3;
    private JPanel test;
    private JButton testButton1;
    private JButton testButton2;
    private JButton testButton3;
    private JButton testButton4;
    private JButton testButton5;
    private JButton testButton6;
    private JPanel resPanel;
    private JPanel contentPane;
    private JScrollPane scrollPane;
    private	JList listbox;
    private JLabel title;
    
    /*
     * Constructor
     * All of your GUI components should be added to
     * contentPane using the gridBagLayout.
     */
    
    public ResTab(){
    //Creating the resPanel that holds everything
    resPanel = new JPanel();
    resPanel.setBackground(new Color(255, 153, 204));
    
    //Creating the contentPane that holds all GUI components and
    //uses vertical/horizontal sidebards as needed
    contentPane = new JPanel();
    contentPane.setBackground(Color.WHITE);
    
    //Giving the contentPane the GridBagLayout
    //contentPane.setLayout(new GridBagLayout());
    //GridBagConstraints g = new GridBagConstraints();
    
    FlowLayout f = new FlowLayout();
    contentPane.setLayout(new FlowLayout());
    
    //contentPane.setLayout(new GridBagLayout());
	GridBagConstraints g = new GridBagConstraints();
	//testPanel1.setLayout(new GridBagLayout());
	//testPanel2.setLayout(new GridBagLayout());
	//testPanel3.setLayout(new GridBagLayout());
    //g.anchor = GridBagConstraints.NORTH;
    
    
    //Adding scrollPane to Content Pane and adding those two to resPanel
	//updated dimension and scroll pref.
    scrollPane = new JScrollPane(contentPane);
    scrollPane.setPreferredSize(new Dimension(875, 550));
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBackground(Color.WHITE);
    resPanel.add(scrollPane);
    
    /*
     * You may begin adding your GUI components from this point forward.
     * Remember to only use GridBagLayout with GridBagConstraints using the
     * g variable.
     */        
    
    //JLabel testLabel1 = new JLabel("Industry:");
    //testLabel1.setPreferredSize(new Dimension(100, 20));
    //testLabel1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
    //g.gridx = 1;
    //g.gridy = 0;
    //testLabel1.setHorizontalAlignment(JLabel.LEFT);
    //testLabel1.setVerticalAlignment(JLabel.TOP);
    //contentPane.add(testLabel1, g);
    
    //testLabel3 = new JLabel("Occupation:");
    //testLabel3.setPreferredSize(new Dimension(100, 20));
    //testLabel3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
    //g.gridx = 3;
    //g.gridy = 0;
    //testLabel1.setHorizontalAlignment(JLabel.LEFT);
    //testLabel1.setVerticalAlignment(JLabel.TOP);
    //contentPane.add(testLabel3, g);
            
    //testLabel5 = new JLabel("Skill(s):");
    //testLabel5.setPreferredSize(new Dimension(100, 20)); 
    //testLabel5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
    //g.gridx = 5;
    //g.gridy = 0;
    //testLabel1.setHorizontalAlignment(JLabel.LEFT);
    //testLabel1.setVerticalAlignment(JLabel.TOP);
    //contentPane.add(testLabel5, g);
    
    title = new JLabel("Resume Edit Tab");
    
    testPanel1 = new JPanel(new GridBagLayout());
    testPanel1.setPreferredSize(new Dimension(200,400));
    testPanel1.setBorder(BorderFactory.createTitledBorder("Industry:"));
    //g.gridx = 0;
    //g.gridy = 0;
    contentPane.add(testPanel1);
    
    testLabel2 = new JLabel("");
    testLabel2.setPreferredSize(new Dimension(50, 50));
    testLabel2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
    //g.gridx = 2;
    //g.gridy = 0;
    contentPane.add(testLabel2);
    
    testPanel2 = new JPanel();
    testPanel2.setPreferredSize(new Dimension(200,400));
    testPanel2.setBorder(BorderFactory.createTitledBorder("Occupation:"));
    //g.gridx = 3;
    //g.gridy = 0;
    contentPane.add(testPanel2);
    
    testLabel4 = new JLabel("");
    testLabel4.setPreferredSize(new Dimension(50, 50));
    testLabel4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
    //g.gridx = 4;
    //g.gridy = 0;
    contentPane.add(testLabel4);
    
    testPanel3 = new JPanel();
    testPanel3.setPreferredSize(new Dimension(200,400));
    testPanel3.setBorder(BorderFactory.createTitledBorder("Skill(s):"));
    //g.gridx = 5;
    //g.gridy = 0;
    contentPane.add(testPanel3);
    //..........................................................
    
    String	listData1[] =
		{
    		"Item 01",
			"Item 02",
			"Item 03",
			"Item 04",
			"Item 01",
			"Item 02",
			"Item 03",
			"Item 04",
			"Item 01",
			"Item 02",
			"Item 03"
		};
    
    String	listData2[] =
		{
			"Item 11",
			"Item 12",
			"Item 13",
			"Item 14"
		};
    
    String	listData3[] =
		{
			"Item 21",
			"Item 22",
			"Item 23",
			"Item 24"
		};
    
    listbox = new JList( listData1 );
    listbox.setLayoutOrientation(JList.VERTICAL);
    listbox.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    listbox.setMaximumSize(new Dimension(200, 200));  // this line does not do the job
    listbox.setMinimumSize (new Dimension (200,200));
    listbox.setVisibleRowCount(-1);
    
    g.gridx = 2;
    g.gridy = 1;
    g.weightx = 2;
    g.weighty = 4;
	testPanel1.add(listbox, g);
	
	listbox = new JList( listData2 );
    listbox.setLayoutOrientation(JList.VERTICAL);
    listbox.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    listbox.setVisibleRowCount(20);
    //listbox.setSize(500, 500);
    //JScrollPane scrollPane_1 = new JScrollPane(listbox);
    //testPanel1.add(scrollPane_1 , BorderLayout.CENTER);
	testPanel2.add( listbox,g);
	
	listbox = new JList( listData3 );
    listbox.setLayoutOrientation(JList.VERTICAL);
    listbox.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    listbox.setVisibleRowCount(20);
    listbox.setSize(500, 500);
    //JScrollPane scrollPane_1 = new JScrollPane(listbox);
    //testPanel1.add(scrollPane_1 , BorderLayout.CENTER);
	testPanel3.add(listbox,g);
   
    //..........................................................

    JButton testButton1 = new JButton("Save1");
    //testButton1.setSize(width, height);
    g.gridx = 1;
    g.gridy = 5;
   //testButton1.setVerticalAlignment(SwingConstants.BOTTOM);
   //testButton1.setHorizontalAlignment(SwingConstants.LEFT);
    testPanel1.add(testButton1,g);
    
    JButton testButton2 = new JButton("Delete1");
    //testButton1.setSize(width, height);
    g.gridx = 3;
    g.gridy = 5;
    testPanel1.add(testButton2,g);
    
    JButton testButton3 = new JButton("Save2");
    //testButton1.setSize(width, height);
    //g.gridx = 3;
    //g.gridy = 2;
    testPanel2.add(testButton3,g);
    
    JButton testButton4 = new JButton("Delete2");
    //testButton1.setSize(width, height);
    //g.gridx = 4;
    //g.gridy = 2;
    testPanel2.add(testButton4,g);
    
    JButton testButton5 = new JButton("Save3");
    //testButton1.setSize(width, height);
    //g.gridx = 5;
    //g.gridy = 2;
    testPanel3.add(testButton5,g);
    
    JButton testButton6 = new JButton("Delete3");
    //testButton1.setSize(width, height);
    //g.gridx = 6;
    //g.gridy = 2;
    testPanel3.add(testButton6,g);
    }
    
    /**
     * The getResTab method returns a ResTab object.
     * @return a ResTab panel object.
     */
    
	public JPanel getResTab(){
		return resPanel;
	}
}
