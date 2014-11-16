package marsPackage;

import java.awt.*;

import javax.swing.*;

public class CusAdvSearch extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3591111934738695424L;
	
	private JPanel advSearchPanel;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JScrollPane sp;
	
	public CusAdvSearch(){
		
		advSearchPanel = new JPanel();
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		    
		 //Giving the contentPane the GridBagLayout
		 contentPane.setLayout(new GridBagLayout());
		 GridBagConstraints g = new GridBagConstraints();
		 g.insets = new Insets(20,0,0,0);
		    
		 //Adding scrollPane to Content Pane and adding those two to cusPanel
	     sp = new JScrollPane(contentPane);
		 sp.setPreferredSize(new Dimension(875, 550));
		 sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		 sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		 sp.setBackground(Color.WHITE);
		 advSearchPanel.add(sp);
		
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints f = new GridBagConstraints();
		f.insets = new Insets(20,0,0,0);
		g.anchor = GridBagConstraints.NORTH;
	    g.gridx = 0;
	    g.gridy = 0;
	  contentPane.add(panel, g);
		
		contentPane.add(panel);
		
			panel_2 = new JPanel();
			panel_2.setBorder(BorderFactory.createTitledBorder("Customer Information"));
			panel_2.setBackground(Color.white);
			panel_2.setBounds(10, 27, 474, 55);
		    f.gridx = 0;
		    f.gridy = 1;
		  contentPane.add(panel_2, f);
		//panel.add(panel_2);
		
			JLabel label = new JLabel("Customer Code");
			panel_2.add(label);
			
			textField = new JTextField();
			textField.setColumns(10);
			panel_2.add(textField);
		
		panel_3 = new JPanel();
		//panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createTitledBorder("Customer content search"));
		panel_3.setBackground(Color.white);
		panel_3.setBounds(10, 80, 474, 99);
	    f.gridx = 0;
	    f.gridy = 2;
	  contentPane.add(panel_3, f);
		//panel.add(panel_3);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setBounds(16, 24, 49, 14);
		panel_3.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(63, 21, 86, 20);
		panel_3.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(63, 46, 86, 20);
		panel_3.add(textField_2);
		
		JLabel label_2 = new JLabel("Email");
		label_2.setBounds(16, 49, 49, 14);
		panel_3.add(label_2);
		
		panel_4 = new JPanel((new BorderLayout()));
		panel_4.setBorder(BorderFactory.createTitledBorder("Search Customers with certain project characterstics"));
		panel_4.setBackground(Color.white);
		panel_4.setBounds(10, 178, 474, 173);
	    f.gridx = 0;
	    f.gridy = 3;
	    contentPane.add(panel_4, f);
		
		JLabel label_3 = new JLabel("Customer with project that are");
		label_3.setBounds(10, 25, 175, 14);
		panel_4.add(label_3, BorderLayout.NORTH);
		
		JCheckBox ACTIVE = new JCheckBox("ACTIVE");
		ACTIVE.setBounds(190, 21, 78, 23);
		ACTIVE.setBackground(Color.GREEN);
		ACTIVE.setForeground(Color.BLACK);
		panel_4.add(ACTIVE);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("COMPLETE");
		chckbxNewCheckBox_2.setBounds(270, 21, 96, 23);
		chckbxNewCheckBox_2.setBackground(Color.YELLOW);
		panel_4.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("ON HOLD");
		chckbxNewCheckBox.setBounds(368, 21, 86, 23);
		panel_4.add(chckbxNewCheckBox);
		
		JLabel lblTotalAmountPaid = new JLabel("Total Amount Paid");
		lblTotalAmountPaid.setBounds(51, 57, 129, 14);
		panel_4.add(lblTotalAmountPaid);
		
		textField_3 = new JTextField();
		textField_3.setBounds(270, 54, 86, 20);
		panel_4.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(270, 85, 86, 20);
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(270, 116, 86, 20);
		panel_4.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblEqual = new JLabel(" EQUAL TO");
		lblEqual.setBounds(190, 57, 75, 14);
		panel_4.add(lblEqual);
		
		JLabel lblNewLabel = new JLabel(">= TO");
		lblNewLabel.setBounds(190, 88, 46, 14);
		panel_4.add(lblNewLabel);
		
		JLabel label_4 = new JLabel("<=TO");
		label_4.setBounds(190, 119, 46, 14);
		panel_4.add(label_4);
		
		JLabel lblAdvancedSearchFor = new JLabel("             ADVANCED SEARCH FOR CUSTOMERS");
		lblAdvancedSearchFor.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdvancedSearchFor.setForeground(Color.BLACK);
		lblAdvancedSearchFor.setBackground(Color.RED);
		lblAdvancedSearchFor.setBounds(10, 11, 469, 14);
	    f.gridx = 0;
	    f.gridy = 0;
	    contentPane.add(lblAdvancedSearchFor, f);
		//panel.add(lblAdvancedSearchFor);
		
	}

	/**
	 * The getCusAdvSearch method returns an advSearchPanel object. 
	 * @return an advSearchPanel object from the CusAdvSearch class
	 */
	public JPanel getCusAdvSearch(){
		return advSearchPanel;
	}
	
}
