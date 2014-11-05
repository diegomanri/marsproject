package marsPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class NewProject extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel newProPanel;
	private JPanel ncontentPane;
	private JPanel tButtonsPanel;
    private JScrollPane nscrollPane;
    private JButton backProTabButton;
    
    //CardLayout related variables
    //private ProTab pt = new ProTab();
	
    /*
     * Constructor
     * All of your GUI components should be added to
     * contentPane using the gridBagLayout.
     */
	
	public NewProject(){
		
		//newProPanel is used by the CardLayout and holds EVERYTHING here
	    newProPanel = new JPanel();
	    newProPanel.setBackground(new Color(204, 255, 102));
	    
	    //contentPane Panel holds all other panels together in this class.
	    ncontentPane = new JPanel();
	    ncontentPane.setBackground(Color.WHITE);
	    
	    //Giving the contentPane the GridBagLayout
	    ncontentPane.setLayout(new GridBagLayout());
	    GridBagConstraints g = new GridBagConstraints();
	    g.insets = new Insets(20,0,0,0);
	    
		//Adding scrollPane to Content Pane and adding those two to newProPanel
		nscrollPane = new JScrollPane(ncontentPane);
		nscrollPane.setPreferredSize(new Dimension(875, 550));
		nscrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		nscrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		nscrollPane.setBackground(Color.WHITE);
		newProPanel.add(nscrollPane);
	    
	    /*
	     * You may begin adding your GUI components from this point forward.
	     * Remember to only use GridBagLayout with GridBagConstraints using the
	     * g variable.
	     */
		
		//Project bottom buttons START
		
		 tButtonsPanel = new JPanel();
		 tButtonsPanel.setBackground(Color.WHITE);
		 tButtonsPanel.setBorder(BorderFactory.createMatteBorder(0,0,0,0, Color.gray));
		 tButtonsPanel.setLayout(new FlowLayout());
		    g.anchor = GridBagConstraints.PAGE_END;
		    g.gridx = 0;
		    g.gridy = 0;
		    ncontentPane.add(tButtonsPanel, g);
		    
		backProTabButton = new JButton("Go Back");
		//backProTabButton.addActionListener(new buttonListener());
		
		tButtonsPanel.add(backProTabButton);
		
		/*
		//Project bottom buttons ActionListeners
		backProTabButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				CardLayout cl = (CardLayout) ncontentPane.getLayout();
				cl.previous(pt.getProTab());
			}
		});
		*/
		
		//Project bottom buttons END		
		
	}

	/*
	//Project bottom buttons ActionListeners
    private class buttonListener implements ActionListener{
  		public void actionPerformed(ActionEvent ae){
  			if (ae.getSource() == backProTabButton){
  			CardLayout cl = (CardLayout) pt.getCardPanel().getLayout();
  			cl.show(pt.getCardPanel(), pt.getCARD_PROJECTTAB());
  			}
  		}
    }
	*/
	
    /**
     * The getNewProPanel method returns a newProPanel object.
     * @return a newProPanel panel object.
     */
    
	public JPanel getNewProPanel(){
		return newProPanel;
	}
	
}
