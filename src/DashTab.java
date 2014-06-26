package marsPackage;

import java.awt.*;

import javax.swing.*;

public class DashTab{

	private JLabel testLabel;
	private JLabel testLabel2;
	private JLabel testLabel3;
	private JPanel dashPanel;
	
	/*
	 * Constructor
	 */
	
	public DashTab(){
		dashPanel = new JPanel();
		dashPanel.setBackground(Color.WHITE);
		
		dashPanel.setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		
		testLabel = new JLabel("Testing Here 1");
		testLabel.setPreferredSize(new Dimension(150, 150));
		testLabel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
		g.gridx = 0;
		g.gridy = 0;
		dashPanel.add(testLabel, g);
		
		testLabel2 = new JLabel("Testing Here 2");
		testLabel2.setPreferredSize(new Dimension(150, 150));
		testLabel2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
		g.gridx = 1;
		g.gridy = 0;
		dashPanel.add(testLabel2, g);
		
		testLabel3 = new JLabel("Testing Here 3");
		testLabel3.setPreferredSize(new Dimension(150, 150)); 
		testLabel3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
		g.gridx = 1;
		g.gridy = 1;
		dashPanel.add(testLabel3, g);
	}
	
	public JPanel getDashTab(){
		return dashPanel;
	}
}
