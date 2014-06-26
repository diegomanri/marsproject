package marsPackage;

import javax.swing.*;

import java.awt.*;

/*
 * The TabPanel class holds the vertical tabbed menu
 */

public class TabPanel extends JPanel {

	private JTabbedPane tabPane;
	private GridBagLayout g;
	private DashTab dt;
	private EmpTab et;
	private ProTab pt;
	private CusTab ct;
	private RepTab rt;
	private ResTab rst;
	
	/*
	 * Constructor
	 */
	
	public TabPanel(){
		tabPane = new JTabbedPane();
		tabPane.setPreferredSize(new Dimension(963, 753));
		tabPane.setTabPlacement(SwingConstants.LEFT);
		setVisible(true);
		
		dt = new DashTab();
		tabPane.addTab("Dashboard", dt.getDashTab());
		
		et = new EmpTab();
		tabPane.addTab("Employees", et.getEmpTab());
	
		pt = new ProTab();
		tabPane.addTab("Projects", pt.getProTab());
		
		ct = new CusTab();
		tabPane.addTab("Customers", ct.getCusTab());

		rt = new RepTab();
		tabPane.addTab("Reports", rt.getRepTab());

		rst = new ResTab();
		tabPane.addTab("Resume", rst.getResTab());
		
		//Customizing the panel and adding the tabbed pane to this panel.
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
		add(tabPane);
		
		//Enabling the use of scrolling tabs if there are so many tabs
		//that you need to scroll.
		tabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

	}
}
