package marsPackage;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ProTab {
	private JPanel eastPanel;
    private JButton advSbutton;
    private JButton quickSbutton;
    private JPanel westPanel;
    private JLabel testLabel2;
    private JTextField quickSfield;
    private JLabel quickSspace;
    private JPanel quickSpanel;
    private JPanel proPanel;
    private JPanel contentPane;
    private JScrollPane scrollPane;
    
    /*
     * Constructor
     * All of your GUI components should be added to
     * contentPane using the gridBagLayout.
     */
    
    public ProTab(){
    //Creating the propanel that holds everything
    proPanel = new JPanel();
    proPanel.setBackground(new Color(204, 255, 102));
    
    //Creating the contentPane that holds all GUI components and
    //uses vertical/horizontal sidebars as needed
    contentPane = new JPanel();
    contentPane.setBackground(Color.WHITE);
    
    //Giving the contentPane the GridBagLayout
    contentPane.setLayout(new GridBagLayout());
    GridBagConstraints g = new GridBagConstraints();
    
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
    
    
    //QuickSearch GUI top section END
    
    
    testLabel2 = new JLabel("Testing Here 2");
    testLabel2.setPreferredSize(new Dimension(250, 200));
    testLabel2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
    g.gridx = 0;
    g.gridy = 1;
    contentPane.add(testLabel2, g);
    }
    
    /**
     * The getProTab method returns a ProTab object.
     * @return a ProTab panel object.
     */
	public JPanel getProTab(){
		return proPanel;
	}
}
