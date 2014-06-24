package marsPackage;

import javax.swing.*;

import java.awt.*;

/*
 * The TabPanel class holds the vertical tabbed menu
 */

public class TabPanel extends JPanel {

	private JTabbedPane tabPane;
	private GridBagLayout g;
	
	/*
	 * Constructor
	 */
	
	public TabPanel(){
		tabPane = new JTabbedPane();
		tabPane.setPreferredSize(new Dimension(963, 753));
		//tried at first with (new Dimension(985, 605))
		setVisible(true);
		
		JComponent dashboardPanel = makeTextPanel("Dashboard Panel");
		tabPane.addTab("Dashboard", null, dashboardPanel, "Dashboard Content");
		dashboardPanel.setBackground(Color.WHITE);
		
		JComponent employeesPanel = makeTextPanel("Employees Panel");
		tabPane.addTab("Employees", null, employeesPanel, "Employees Content");
		employeesPanel.setBackground(Color.WHITE);
		
		JComponent projectsPanel = makeTextPanel("Projects Panel");
		tabPane.addTab("Projects", null, projectsPanel, "Projects Content");
		projectsPanel.setBackground(Color.WHITE);

		JComponent customersPanel = makeTextPanel("Customers Panel");
		tabPane.addTab("Customers", null, customersPanel, "Customers Content");
		customersPanel.setBackground(Color.WHITE);

		JComponent reportsPanel = makeTextPanel("Reports Panel");
		tabPane.addTab("Reports", null, reportsPanel, "Reports Content");
		reportsPanel.setBackground(Color.WHITE);
		
		JComponent resumePanel = makeTextPanel("Resume Panel");
		tabPane.addTab("Resume", null, resumePanel, "Resume Content");
		resumePanel.setBackground(Color.WHITE);
		
		//Customizing the panel and adding the tabbed pane to this panel.
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
		add(tabPane);
		
		/*
		//Enabling the use of scrolling tabs.
		tabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		g = new GridBagLayout();
		getRootPane().add(tabPane, g);
		g.fill = g.BOTH;
		
		*/
	}
	
	// Method to make the text panel.
	protected JComponent makeTextPanel(String text){
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1,1));
		//setLayout(new FlowLayout());
		panel.add(filler);
		return panel;
	}

}
