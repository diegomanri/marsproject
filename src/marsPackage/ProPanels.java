package marsPackage;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

public class ProPanels extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7113372122151966873L;
	private JPanel newProPanel;
	private JPanel addEmpPanel;
	private JPanel addEmpPanel2;
	private JPanel custDropBox;
	private JPanel empAssignP;
	private JPanel proNamePanel;
	private JScrollPane empAssignSP;
	private JLabel custRequestBy;
	private JLabel proNameLabel;
	private JLabel proStatusLabel;
	private JComboBox custList;
	private JComboBox proStatus;
	private JTextField proNameField;

	
	public ProPanels(){
		//proPanel will hold all new project panels
		newProPanel = new JPanel();
		newProPanel.setBackground(Color.WHITE);
		newProPanel.setLayout(new BorderLayout());
		
			//addEmpPanel holds J elements that are related to employees and customers assignment to a project.
			Border empPanelTitle = BorderFactory.createTitledBorder("Assign Customer and Employee to Project");
			addEmpPanel = new JPanel();
			addEmpPanel.setBorder(empPanelTitle);
			addEmpPanel.setBackground(Color.WHITE);
			
				//addEmpPanel2 contains J elements within addEmpPanel
				addEmpPanel2 = new JPanel();
				addEmpPanel2.setBorder(null);
				addEmpPanel2.setLayout(new BorderLayout());
				addEmpPanel2.setBackground(Color.WHITE);
				
					//custDropBox holds the assign customer to project drop down menu
					custDropBox = new JPanel(new FlowLayout());
					custRequestBy = new JLabel("Project requested by: ");
					custDropBox.setBackground(Color.WHITE);
					custDropBox.add(custRequestBy);
					
					//Test data for the customer drop down menu
					String[] testCustomers = {
							"Shell",
							"Exxon Mobil",
							"Valerus",
							"BP Oil"
					};
					custList = new JComboBox(testCustomers);
					custList.setEditable(true);
					custDropBox.add(custList);
					
				addEmpPanel2.add(custDropBox, BorderLayout.NORTH);
				
					//empAssignP panel will hold employee assignment forms.
					Border empPanelTitle2 = BorderFactory.createTitledBorder("Assign Employee(s) to Project");
					empAssignP = new JPanel(new FlowLayout());
					empAssignP.setBorder(empPanelTitle2);
					empAssignP.setBackground(Color.WHITE);
					empAssignSP = new JScrollPane(empAssignP);
					empAssignSP.setPreferredSize(new Dimension(400, 100));
					empAssignSP.setBorder(null);
					empAssignSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
					empAssignSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
					empAssignSP.setBackground(Color.WHITE);
					
			    addEmpPanel2.add(empAssignSP, BorderLayout.CENTER);
		
		addEmpPanel.add(addEmpPanel2, BorderLayout.CENTER);
		newProPanel.add(addEmpPanel, BorderLayout.NORTH);
		
		
		proNamePanel = new JPanel(new FlowLayout());
		proNameLabel = new JLabel("Project Name:");
		proNameField = new JTextField("Enter Project Name", 20);
		proStatusLabel = new JLabel("  Project Status:");
		proStatus = new JComboBox();
		
		proNamePanel.add(proNameLabel);
		proNamePanel.add(proStatusLabel);
	}
	
	/**
	 * The getNewProPanel method will return a panel containing
	 * all new project panels.
	 * @return a newProPanel object.
	 */
	public JPanel getNewProPanel(){
		return newProPanel;
	}
	
	/**
	 * addEmpPanel holds J elements that are related to employees and customers assignment to a project.
	 * @return a addEmpPanel object
	 */
	public JPanel getAddEmpPanel(){
		return addEmpPanel;
	}
	
	/**
	 * getProNamePanel returns a proNamePanel object.
	 * @return a proNamePanel object.
	 */
	
	public JPanel getProNamePanel(){
		return proNamePanel;
	}

}
