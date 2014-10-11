package marsPackage;

import java.awt.*;

import javax.swing.*;

public class MarsMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2953240271672230799L;
	private JLayeredPane panelHolder;
	private AppLogoPanel applogo;
	private TabPanel tabpanel;
	//private GridBagConstraints gbc;
	
	
	public MarsMain(){
		
		//Setting up the JFrame
		setTitle("MARS 1.0");
		setPreferredSize(new Dimension(1000, 710));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * Layered panes do not have a layout manager which means
		 * I have to write the code that positions an sizes components
		 * within it.
		 */
		
		
		//Creating the panel holder
		panelHolder = new JLayeredPane();
		panelHolder.setPreferredSize(new Dimension(1000, 710));
		setLayout(new BorderLayout());
		add(panelHolder, BorderLayout.NORTH);
		panelHolder.setBounds(0, 0, 600, 400);
		
		//adding Application logo panel to panelHolder
		applogo = new AppLogoPanel();
		applogo.setBounds(-3, -5, 1000, 300);
		applogo.setBackground(Color.WHITE);
		panelHolder.add(applogo, new Integer(0));

		//adding the tabpanel panel to the panelHolder
		tabpanel = new TabPanel();
		tabpanel.setBounds(0, 110, 965, 761);
		panelHolder.add(tabpanel, new Integer(1));
		pack();
	}
	
	
	public static void main(String[] args) {
		

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thread.sleep(1);
					MarsMain frame = new MarsMain();
					frame.getContentPane().setBackground(Color.WHITE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
}
