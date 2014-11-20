package marsPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class EditPro extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3772461924034467779L;
	private JPanel editProPanel;
	private JPanel editEmpPanel;
	private JPanel addEmpPanel2;
	private JPanel custDropBox;
	private JPanel empAssignP;
	private JPanel proNamePanel;
	private JPanel proInfoPanel;
	private JPanel proDatesPanel;
	private JPanel proBillingPanel;
	private JPanel panelHolder;
	private JScrollPane empAssignSP;
	private JScrollPane textAreaSP;
	private JLabel custRequestBy;
	private JLabel proNameLabel;
	private JLabel proStatusLabel;
	private JLabel empID;
	private JLabel fname;
	private JLabel lname;
	private JLabel hours;
	private JLabel empPayPH;
	private JLabel totalPay;
	private JLabel startDateLabel;
	private JLabel endDateLabel;
	private JLabel cusBillLabel;
	private JLabel kisRevenueLabel;
	private JLabel totalEmpPayLabel;
	private JTextField cusBillField;
	private JTextField kisRevenueField;
	private JTextField totalEmpPayField;
	private JTextField empIDField;
	private JTextField fnameField;
	private JTextField lnameField;
	private JTextField hoursField;
	private JTextField empPayPHField;
	private JTextField totalPayField;
	private JTextField startDateField;
	private JTextField endDateField;
	private JTextArea proDescriptionBox;
	private JComboBox custList;
	private JComboBox proStatus;
	private JTextField proNameField;
	private JButton addEmp;
	private JButton addEmp2;
	private JButton delEmp;
	private JTextField newTextField;
	private final GridBagConstraints g;

	public EditPro(){
		//proPanel will hold all new project panels
		editProPanel = new JPanel();
		editProPanel.setBackground(Color.WHITE);
		editProPanel.setLayout(new BorderLayout());
		
			//addEmpPanel holds J elements that are related to employees and customers assignment to a project.
			Border empPanelTitle = BorderFactory.createTitledBorder("Project Details");
			editEmpPanel = new JPanel();
			editEmpPanel.setBorder(empPanelTitle);
			editEmpPanel.setBackground(Color.WHITE);
			
				//addEmpPanel2 contains J elements within addEmpPanel
				addEmpPanel2 = new JPanel();
				addEmpPanel2.setBorder(null);
				addEmpPanel2.setLayout(new BorderLayout());
				addEmpPanel2.setBackground(Color.WHITE);
				
				
					//proStatus holds the Project Status selection drop box
					//proStatLabel = new JLabel("Project requested by: ");
					proNamePanel = new JPanel(new FlowLayout());
					proNamePanel.setBackground(Color.WHITE);
					proNameLabel = new JLabel("Project Name:");
					proNameField = new JTextField(15);
					proStatusLabel = new JLabel("  Project Status:");
					String[] proStats = {
							"Active",
							"On-hold",
							"Complete",
							"Cancelled"
					};
					proStatus = new JComboBox(proStats);
					proStatus.setBackground(Color.WHITE);
					proNamePanel.add(proNameLabel);
					proNamePanel.add(proNameField);
					proNamePanel.add(proStatusLabel);
					proNamePanel.add(proStatus);
					
				addEmpPanel2.add(proNamePanel, BorderLayout.NORTH);
					
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
					custList.setBackground(Color.WHITE);
					custDropBox.add(custList);
					
				proNamePanel.add(custDropBox);
				
				
					//empAssignP panel will hold employee assignment forms.
					Border empPanelTitle2 = BorderFactory.createTitledBorder("Assign Employee(s) to Project");
					empAssignP = new JPanel(new GridBagLayout());
				    g = new GridBagConstraints();
				    g.insets = new Insets(3,5,3,15);
					empAssignP.setBorder(empPanelTitle2);
					empAssignP.setBackground(Color.WHITE);
					empAssignSP = new JScrollPane(empAssignP);
					empAssignSP.setPreferredSize(new Dimension(850, 120));
					empAssignSP.setBorder(null);
					empAssignSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
					empAssignSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
					empAssignSP.setBackground(Color.WHITE);
					/*
					Adding Labels and Input Fields to Employee Assignment part of the application
					*/
					empID = new JLabel("Employee ID");
					g.gridx = 0;
					g.gridy = 0;
					empAssignP.add(empID, g);
						empIDField = new JTextField(5);
						g.anchor = GridBagConstraints.LINE_START;
						g.gridx = 0;
						g.gridy = 1;
						empAssignP.add(empIDField, g);
					
					fname = new JLabel("First Name");
					g.gridx = 1;
					g.gridy = 0;
					empAssignP.add(fname, g);
						fnameField = new JTextField(10);
						g.anchor = GridBagConstraints.LINE_START;
						g.gridx = 1;
						g.gridy = 1;
						empAssignP.add(fnameField, g);
					
					lname = new JLabel("Last Name");
					g.gridx = 2;
					g.gridy = 0;
					empAssignP.add(lname, g);
						lnameField = new JTextField(10);
						g.anchor = GridBagConstraints.LINE_START;
						g.gridx = 2;
						g.gridy = 1;
						empAssignP.add(lnameField, g);
					
					hours = new JLabel("Hours Assignment");
					g.gridx = 3;
					g.gridy = 0;
					empAssignP.add(hours, g);
						hoursField = new JTextField(3);
						g.anchor = GridBagConstraints.CENTER;
						g.gridx = 3;
						g.gridy = 1;
						empAssignP.add(hoursField, g);
					
					empPayPH = new JLabel("Pay per/hr in USD");
					g.gridx = 4;
					g.gridy = 0;
					empAssignP.add(empPayPH, g);
						empPayPHField = new JTextField(3);
						g.anchor = GridBagConstraints.CENTER;
						g.gridx = 4;
						g.gridy = 1;
						empAssignP.add(empPayPHField, g);
					
					totalPay = new JLabel("Total Pay");
					g.gridx = 5;
					g.gridy = 0;
					empAssignP.add(totalPay, g);
						totalPayField = new JTextField(8);
						g.anchor = GridBagConstraints.LINE_START;
						g.gridx = 5;
						g.gridy = 1;
						empAssignP.add(totalPayField, g);
						addEmp = new JButton("+");
						addEmp.setBackground(Color.GREEN);
						g.anchor = GridBagConstraints.LINE_START;
						g.gridx = 6;
						g.gridy = 1;
						empAssignP.add(addEmp, g);
						addEmp.addActionListener(new addEmpButtonListener());
					
			    addEmpPanel2.add(empAssignSP, BorderLayout.CENTER);
			    
			    
			    //proInfo panel holds the panels that contain project info such as start/end dates, description
			    //and billing
			    proInfoPanel = new JPanel(new BorderLayout());
			    Border proInfoTitle = BorderFactory.createTitledBorder("Project Information");
			    proInfoPanel.setBorder(proInfoTitle);
			    proInfoPanel.setBackground(Color.WHITE);
			    
			    panelHolder = new JPanel(new FlowLayout());
			    panelHolder.setBackground(Color.WHITE);
			    
			    	//Start/End date containing panel
			    	proDatesPanel = new JPanel(new GridBagLayout());
			    	proDatesPanel.setBackground(Color.WHITE);
			    	GridBagConstraints h = new GridBagConstraints();
				    h.insets = new Insets(2,2,2,2);
			    	startDateLabel = new JLabel("Start Date: ");
			    	startDateLabel.setBackground(Color.WHITE);
			    	h.gridx = 0;
			    	h.gridy = 0;
			    	proDatesPanel.add(startDateLabel, h);
			    	startDateField = new JTextField(12);
			    	startDateField.setBackground(Color.WHITE);
			    	h.gridx = 1;
			    	h.gridy = 0;
			    	proDatesPanel.add(startDateField, h);
			    	
			    	endDateLabel = new JLabel("End Date: ");
			    	endDateLabel.setBackground(Color.WHITE);
			    	h.gridx = 0;
			    	h.gridy = 1;
			    	proDatesPanel.add(endDateLabel, h);
			    	endDateField = new JTextField(12);
			    	endDateField.setBackground(Color.WHITE);
			    	h.gridx = 1;
			    	h.gridy = 1;
			    	proDatesPanel.add(endDateField, h);
			    	
			    	String text = "Enter a bried project description...";
			    	proDescriptionBox = new JTextArea(7, 20);
			    	proDescriptionBox.setText(text);
			    	proDescriptionBox.setLineWrap(true);
			    	proDescriptionBox.setWrapStyleWord(true);
			    	textAreaSP = new JScrollPane(proDescriptionBox);
			    	h.gridwidth = 3;
			    	h.gridx = 0;
			    	h.gridy = 3;
			    	textAreaSP.setBackground(Color.WHITE);
			    	textAreaSP.setBorder(new TitledBorder("Project Description"));

			    	proDatesPanel.add(textAreaSP, h);
			    	
			    	panelHolder.add(proDatesPanel);
			    	
			    	//Billing panel
			    	proBillingPanel = new JPanel(new GridBagLayout());
			    	GridBagConstraints j = new GridBagConstraints();
				    j.insets = new Insets(2,2,2,2);
			    	proBillingPanel.setBackground(Color.WHITE);
			    	proBillingPanel.setBorder(new TitledBorder("Project Billing"));
			    	/*
			    		private JLabel cusBillLabel;
						private JLabel kisRevenueLabel;
						private JLabel totalEmpPayLabel;
						private JTextField cusBillField;
						private JTextField kisRevenueField;
						private JTextField totalEmpPayField;
			    	*/
			    	cusBillLabel = new JLabel("Total billed to customer:");
			    	j.gridx = 0;
			    	j.gridy = 0;
			    	proBillingPanel.add(cusBillLabel, j);
			    	cusBillField = new JTextField(8);
			    	j.gridx = 1;
			    	j.gridy = 0;
			    	proBillingPanel.add(cusBillField, j);
			    	
			    	totalEmpPayLabel = new JLabel("Total paid to employees:");
			    	j.gridx = 0;
			    	j.gridy = 1;
			    	proBillingPanel.add(totalEmpPayLabel, j);
			    	totalEmpPayField = new JTextField(8);
			    	j.gridx = 1;
			    	j.gridy = 1;
			    	proBillingPanel.add(totalEmpPayField, j);
			    	
			    	kisRevenueLabel = new JLabel("KIS Earnings in USD:");
			    	j.gridx = 0;
			    	j.gridy = 2;
			    	proBillingPanel.add(kisRevenueLabel, j);
			    	kisRevenueField = new JTextField(8);
			    	j.gridx = 1;
			    	j.gridy = 2;
			    	proBillingPanel.add(kisRevenueField, j);
			    
			    	panelHolder.add(proBillingPanel);
			  
			   proInfoPanel.add(panelHolder, BorderLayout.CENTER);
			    
			    
			  //Adding proInfo panel to addEmpPanel2
			  addEmpPanel2.add(proInfoPanel, BorderLayout.SOUTH);
		
	    editEmpPanel.add(addEmpPanel2, BorderLayout.CENTER);
		editProPanel.add(editEmpPanel, BorderLayout.NORTH);
		
	}
	
	 /*
    ======================
    Button ActionListeners
    ======================
    */
    
    private class addEmpButtonListener implements ActionListener{
  		public void actionPerformed(ActionEvent ae){
  			if (ae.getSource() == addEmp){

  				for (int i = 0; i < 6; i++){
  					int n = 0;  					
  					int x = 0;
  					int y = 0;
  					
  					if (i == 0){
  						n = 5;
  						x = 0;
  						y = 2;
  	  					newTextField = new JTextField(n);
  						g.anchor = GridBagConstraints.LINE_START;
  						g.gridx = x;
  						g.gridy = y;
  						empAssignP.add(newTextField, g);
  					} else if (i == 1){
  						n = 10;
  						x = 1;
  						y = 2;
  	  					newTextField = new JTextField(n);
  						g.anchor = GridBagConstraints.LINE_START;
  						g.gridx = x;
  						g.gridy = y;
  						empAssignP.add(newTextField, g);
  					} else if (i == 2){
  						n = 10;
  						x = 2;
  						y = 2;
  	  					newTextField = new JTextField(n);
  						g.anchor = GridBagConstraints.LINE_START;
  						g.gridx = x;
  						g.gridy = y;
  						empAssignP.add(newTextField, g);
  					} else if (i == 3){
  						n = 3;
  						x = 3;
  						y = 2;
  	  					newTextField = new JTextField(n);
  						g.anchor = GridBagConstraints.CENTER;
  						g.gridx = x;
  						g.gridy = y;
  						empAssignP.add(newTextField, g);
  					} else if (i == 4){
  						n = 3;
  						x = 4;
  						y = 2;
  	  					newTextField = new JTextField(n);
  						g.anchor = GridBagConstraints.CENTER;
  						g.gridx = x;
  						g.gridy = y;
  						empAssignP.add(newTextField, g);
  					} else if (i == 5){
  						n = 8;
  						x = 5;
  						y = 2;
  	  					newTextField = new JTextField(n);
  						g.anchor = GridBagConstraints.LINE_START;
  						g.gridx = x;
  						g.gridy = y;
  						empAssignP.add(newTextField, g);
	  						addEmp2 = new JButton("+");
							addEmp2.setBackground(Color.GREEN);
							g.anchor = GridBagConstraints.LINE_START;
							g.gridx = 6;
							g.gridy = 2;
							empAssignP.add(addEmp2, g);
							
							delEmp = new JButton("-");
							delEmp.setBackground(Color.RED);
							g.anchor = GridBagConstraints.LINE_START;
							g.gridx = 7;
							g.gridy = 2;
							empAssignP.add(delEmp, g);
  					}
					empAssignP.revalidate();
					
  				}
  			}
  		}
    }
	
	/**
	 * editEmpPanel holds J elements that are related to employees and customers assignment to a project.
	 * @return a editEmpPanel object
	 */
	public JPanel getEditEmpPanel(){
		return editEmpPanel;
	}
    
	/**
	 * The getEditProPanel method will return a panel containing
	 * all new project panels.
	 * @return a newProPanel object.
	 */
	public JPanel getEditProPanel(){
		return editProPanel;
	}
}
