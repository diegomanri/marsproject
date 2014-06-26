package marsPackage;

import java.awt.*;
import javax.swing.*;

public class EmpTab {
	private JLabel testLabel;
	private JLabel testLabel2;
	private JLabel testLabel3;
	private JPanel empPanel;
	
	/*
	 * Constructor
	 */
	
	public EmpTab(){
		empPanel = new JPanel();
		empPanel.setBackground(Color.GRAY);
		
		empPanel.setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		
		testLabel = new JLabel("Testing Here 1");
		testLabel.setPreferredSize(new Dimension(150, 150));
		testLabel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
		g.gridx = 0;
		g.gridy = 0;
		empPanel.add(testLabel, g);
		
		testLabel2 = new JLabel("Testing Here 2");
		testLabel2.setPreferredSize(new Dimension(150, 150));
		testLabel2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
		g.gridx = 1;
		g.gridy = 0;
		empPanel.add(testLabel2, g);
		
		testLabel3 = new JLabel("Testing Here 3");
		testLabel3.setPreferredSize(new Dimension(150, 150)); 
		testLabel3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
		g.gridx = 1;
		g.gridy = 1;
		empPanel.add(testLabel3, g);
	}
	
	public JPanel getEmpTab(){
		return empPanel;
	}
}
