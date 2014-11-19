package marsPackage;

import javax.swing.*;

import java.awt.*;

/*
 * The TabPanel class holds the vertical tabbed menu
 */

public class TabPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8707505020077303802L;
	private JTabbedPane tabPane;
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
		
		tabPane.setBackground(Color.WHITE);
		
		dt = new DashTab();
		tabPane.addTab("Dashboard", dt.getDashCardLayout());
		tabPane.setBackgroundAt(0, (new Color(255, 255, 255)));
		
		et = new EmpTab();
		tabPane.addTab("Employees", et.getEmpTab());
		tabPane.setBackgroundAt(1, (new Color(255, 204, 153)));
		
		pt = new ProTab();
		tabPane.addTab("Projects", pt.getCardPanel());
		tabPane.setBackgroundAt(2, (new Color(204, 255, 102)));
		
		ct = new CusTab();
		tabPane.addTab("Customers", ct.getCusCardHolder());
		tabPane.setBackgroundAt(3, (new Color(153, 204, 255)));

		rt = new RepTab();
		tabPane.addTab("Reports", rt.getRepTab());
		tabPane.setBackgroundAt(4, (new Color(204, 153, 255)));

		rst = new ResTab();
		tabPane.addTab("Resume", rst.getResTab());
		tabPane.setBackgroundAt(5, (new Color(255, 153, 204)));
		
		//Customizing the panel and adding the tabbed pane to this panel.
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
		add(tabPane);
	}
}
