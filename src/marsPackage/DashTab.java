package marsPackage;

import java.awt.*;
import javax.swing.*;

public class DashTab{

        private JLabel testLabel;
        private JLabel testLabel2;
        private JLabel testLabel3;
        private JLabel testLabel4;
        private JPanel dashPanel;
        private JPanel contentPane;
        private JScrollPane scrollPane;
        
        /*
         * Constructor
         * All of your GUI components should be added to
         * contentPane using the gridBagLayout.
         */
        
        public DashTab(){
        //Creating the dashpanel that holds everything
        dashPanel = new JPanel();
        dashPanel.setBackground(Color.WHITE);
        
        //Creating the contentPane that holds all GUI components and
        //uses vertical/horizontal sidebards as needed
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        
        //Giving the contentPane the GridBagLayout
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        //contentPane.setPreferredSize(new Dimension(857, 725));
        
        //Adding scrollPane to Content Pane and adding those two to dashPanel
        scrollPane = new JScrollPane(contentPane);
        scrollPane.setPreferredSize(new Dimension(875, 550));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBackground(Color.WHITE);
        dashPanel.add(scrollPane);
        
        /*
         * You may begin adding your GUI components from this point forward.
         * Remember to only use GridBagLayout with GridBagConstraints using the
         * g variable.
         */
                
        testLabel = new JLabel("Testing Here 1");
        testLabel.setPreferredSize(new Dimension(500, 500));
        testLabel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
        g.gridx = 0;
        g.gridy = 0;
        contentPane.add(testLabel, g);
        
        testLabel2 = new JLabel("Testing Here 2");
        testLabel2.setPreferredSize(new Dimension(250, 200));
        testLabel2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
        g.gridx = 1;
        g.gridy = 0;
        contentPane.add(testLabel2, g);
                
        testLabel3 = new JLabel("Testing Here 3");
        testLabel3.setPreferredSize(new Dimension(200, 200)); 
        testLabel3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
        g.gridx = 1;
        g.gridy = 1;
        contentPane.add(testLabel3, g);
        
        testLabel4 = new JLabel("Testing Here 4");
        testLabel4.setPreferredSize(new Dimension(200, 200)); 
        testLabel4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
        g.gridx = 2;
        g.gridy = 2;
        contentPane.add(testLabel4, g);
        }
        
        /**
         * The getDashTab method returns a DashTab object.
         * @return a DashTab panel object.
         */
        
        public JPanel getDashTab(){
                return dashPanel;
        }
}
