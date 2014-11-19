package marsPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;

import javax.swing.*;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;



public class DashTab extends JPanel{


        private JPanel dashPanel;
        private JPanel contentPane;
        private JScrollPane scrollPane;
        private JPanel dashCardLayout;
        private ChartPanel chartPanel;
        private ChartPanel chartPanel2;
        private JTable proTable;
        private JScrollPane proTableSP;
        
        /*
         * Constructor
         * All of your GUI components should be added to
         * contentPane using the gridBagLayout.
         */
        
        private static final String CARD_DASHTAB = "Card Dash Tab";
		private static final String Connection = null;
        

        
        public DashTab(){
        	
      
        
        /*
        ==========================
        CardLayout Class Instances
        ==========================
      */

       dashCardLayout = new JPanel();
       dashCardLayout.setLayout(new CardLayout(0, 3));
       dashPanel = new JPanel(); 	
       dashPanel.setBackground(Color.white);
       dashCardLayout.add(dashPanel, CARD_DASHTAB);
        	
        
        
        //Creating the contentPane that holds all GUI components and
        //uses vertical/horizontal sidebars as needed
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        
        
        //Giving the contentPane the GridBagLayout
        contentPane.setLayout(new GridBagLayout());
        
        //empty gridbags
        GridBagConstraints a = new GridBagConstraints();
        GridBagConstraints b = new GridBagConstraints();
        
        //filled gridbags
        GridBagConstraints g = new GridBagConstraints();
        GridBagConstraints h = new GridBagConstraints();
        GridBagConstraints i = new GridBagConstraints();
        GridBagConstraints j = new GridBagConstraints();
        contentPane.setPreferredSize(new Dimension(857, 595));
        dashPanel.add(contentPane);
        
        //Adding scrollPane to Content Pane and adding those two to dashPanel
        scrollPane = new JScrollPane(contentPane);
        scrollPane.setPreferredSize(new Dimension(875, 600));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBackground(Color.WHITE);
        dashPanel.add(scrollPane);
        
        /*
         * You may begin adding your GUI components from this point forward.
         * Remember to only use GridBagLayout with GridBagConstraints using the
         * g variable.
         */
        
        ///// EMPTY PANELS //////

  			     
  	     	 JPanel panelA = new JPanel();
   	     	panelA.setPreferredSize( new java.awt.Dimension( 50 , 15 ) );
  	    	 
  	          
  	      	JPanel panelB = new JPanel();
  	     	panelB.setPreferredSize( new java.awt.Dimension( 50 , 15 ) );
  	     	 
  	     	panelA.setBackground(Color.white);
  	     	panelB.setBackground(Color.white);

  	     	 //////////////////////
        
        
		JFreeChart lineChart = ChartFactory.createLineChart3D(
   	         "Yearly Revenue Comparison",
   	         "Month","Revenue Amount ($)",
   	         createDataset(),
   	         PlotOrientation.VERTICAL,
   	         true,true,false);
		
		 CategoryPlot p = lineChart.getCategoryPlot(); 
		 ValueAxis yaxis = p.getRangeAxis();
	
		 CategoryPlot x = lineChart.getCategoryPlot(); 
		 CategoryAxis xaxis = x.getDomainAxis();

		 Font font = new Font("Dialog", Font.PLAIN, 10);
		 yaxis.setTickLabelFont(font);
		 
		 Font font2 = new Font("Dialog1", Font.PLAIN, 8);
		 xaxis.setTickLabelFont(font);
		 
		 //ChartPanel(JFreeChart lineChart); 
		 ChartPanel chartPanel = new ChartPanel(lineChart);
   	     chartPanel.setPreferredSize( new java.awt.Dimension( 300 , 265 ) );

			/**String url = "jdbc:sqlserver://ANTHONY-PC\\MSSQLSERVER;databaseName=KIS_DB;integratedSecurity=true";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url);
            String pieQuery = "SELECT * FROM EMPLOYEE_STATUS";
            */
            // Create Pie Chart
   	     JFreeChart pieChart = ChartFactory.createPieChart3D(
              "Staff Status",  // chart title
              createPieDataset(),             // data
              false,               // include legend
              true,
              false);
		   	 PiePlot plot = (PiePlot) pieChart.getPlot();
		     plot.setLabelFont(new Font("Arial", Font.PLAIN, 11));
		     plot.setNoDataMessage("No data available");
		     plot.setCircular(true);
		     plot.setLabelGap(0.02);
		     
        
    	  
     	 ChartPanel chartPanel2 = new ChartPanel(pieChart);
    	 chartPanel2.setPreferredSize( new java.awt.Dimension( 370 , 265 ) );
   	   
    	 // Create 3-D Bar Graph
    	 JFreeChart barChart = ChartFactory.createBarChart3D("Monthly Revenue Comparison", // chart title
                    "Years", // domain axis label
                    "Revenue Amount ($)", // range axis label
                    createBarDataset(), // data
                    PlotOrientation.VERTICAL, // orientation
                    true, // include legend
                    false, // tooltips
                    true);
    	 
     	 ChartPanel chartPanel3 = new ChartPanel(barChart);
    	 chartPanel3.setPreferredSize( new java.awt.Dimension( 350 , 300 ) );
    	 
    	 
    /////////////////////////////////////////////////////////////////////////////

    	    final int rows = 10;
    	      
    	    //tablePanel contains the table and the panel that contains the table's navigation items (tableNavPanel)
    	    //And table Title panel as well!
    		//Adding Table related panels to contentPane
    	    Container tablePanel = new JPanel(new BorderLayout(3,3));
    	    tablePanel.setBackground(Color.WHITE);
    	    //tablePanel.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
    	    g.fill = GridBagConstraints.HORIZONTAL;
    	    g.insets = new Insets(20,0,0,0);
    	    g.gridx = 0;
    	    g.gridy = 1;
    	    contentPane.add(tablePanel, g);
    	    
    	    
    	    DB db = new DB();
    		try {
    			
    			String sql = "SELECT PROJECT.PROJECT_ID AS 'Project ID'\n"
							+"	 , PROJECT.PROJECT_NAME AS 'Project Name'\n"
							+"	 , PROJECT_STATUS.PRO_STATUS_NAME AS 'Status'\n"
							+"	 , EMPLOYEE.EMP_FIRST_NAME AS 'F. Name'\n"
							+"	 , EMPLOYEE.EMP_LAST_NAME AS 'L. Name'\n"
						+"	FROM PROJECT_STATUS\n"
						+"	INNER JOIN PROJECT ON PROJECT_STATUS.PRO_STATUS_ID = PROJECT.PRO_STATUS_ID\n"
						+"	INNER JOIN EMP_PAY_PRO_ASSIGN ON EMP_PAY_PRO_ASSIGN.PROJECT_ID = PROJECT.PROJECT_ID\n"
						+"	INNER JOIN EMPLOYEE ON EMPLOYEE.EMPLOYEE_ID = EMP_PAY_PRO_ASSIGN.EMPLOYEE_ID\n"
						+"	WHERE PROJECT_STATUS.PRO_STATUS_ID = 1\n"
						+"	ORDER BY 'Project ID' DESC;";
    					
    					
    			PreparedStatement Stmt = db.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    			ResultSet rs = Stmt.executeQuery();
    			ResultSetMetaData meta = Stmt.getMetaData();
    			
    			int colCount = meta.getColumnCount();
    			String[] colNames = new String[colCount];
    			
    			rs.last();
    			int numRows = rs.getRow();
    			rs.first();
    			
    			String[][] data = new String[numRows][colCount];
    			
    			for(int i2 = 0; i2 < numRows; i2++){
    				for(int j2 = 0; j2 < colCount; j2++){
    					data[i2][j2] = rs.getString(j2 + 1);
    				}
    				rs.next();
    			}
    			
    			for(int i2 = 0; i2 < colCount; i2++){
    				colNames[i2] = meta.getColumnLabel(i2 + 1);
    			}
    			
    		/*DB connection to table TEST*/
    		
    	    proTable = new JTable(data, colNames);

    		} catch (SQLException e1) {
    			// TODO Auto-generated catch block
    			System.err.println("Something wrong with loading data to the project table in the GUI");
    			e1.printStackTrace();
    		}
    		db.close();
    	    
    	    
    	    
    	   
    	    
    	     proTableSP = new JScrollPane(
    	    		proTable, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	    		Dimension d = proTable.getPreferredSize();
    	    		proTableSP.setPreferredSize(new Dimension(d.width,proTable.getRowHeight()*rows));	
    	    
    	    //Panel that contains the table's navigation buttons.
    	    JPanel tableNavPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));		
    	    
    	    JButton tNextButton = new JButton(">");
    	    	tNextButton.addActionListener(new ActionListener(){
    	    		public void actionPerformed(ActionEvent e){
    	    			int height = proTable.getRowHeight()*(rows-1);
    	    			JScrollBar bar = proTableSP.getVerticalScrollBar();
    	    			bar.setValue(bar.getValue()+height);
    	    			}
    	    	});
    	    		
    	    JButton tPrevButton = new JButton("<");
    		tPrevButton.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    				int height = proTable.getRowHeight()*(rows-1);
    				JScrollBar bar = proTableSP.getVerticalScrollBar();
    				bar.setValue(bar.getValue()-height);
    				}
    	    	});
    	    
    		//Adding a title label and append it to the top of the Table panel.
    	    JLabel proTableTitle = new JLabel("Active Employee Assignment");
    	    proTableTitle.setFont(new Font("Arial", Font.BOLD, 22));
    	    proTableTitle.setForeground(Color.black);

    	    tablePanel.add(proTableTitle, BorderLayout.NORTH);
    		
    		tableNavPanel.add(tPrevButton);
    		tableNavPanel.add(tNextButton);
    		
    		tablePanel.add(proTableSP, BorderLayout.CENTER);
    		tablePanel.add(tableNavPanel, BorderLayout.SOUTH);
    		
    	    //Project Table END
    	    	 
    	

    ///////////////////////////////////////////////////////////////////////////////// 
    	 
    	 
    	g.gridx = 0;
        g.gridy = 0;
        g.insets = new Insets(0,0,0,0);
        g.anchor = GridBagConstraints.PAGE_START;
        h.gridx = 1;
        h.gridy = 0;        
        i.gridx = 1;
        i.gridy = 2;
        j.gridx = 0;
        j.gridy = 2;
        
        //empty
        a.gridx = 0;
        a.gridy = 1;
        b.gridx = 1;
        b.gridy = 1;
        
        //contentPane.setLayout(new GridLayout(1,0));

        contentPane.add(chartPanel,g);
        contentPane.add(chartPanel2,h);
        contentPane.add(chartPanel3,i);
        contentPane.add(tablePanel, j);
        //contentPane.add(panelA, a);
        contentPane.add(panelB, b);
        
        //contentPane.add(tPanel);
        //panel.add(tableContainer, BorderLayout.CENTER);
       
          
        
        contentPane.validate();
	  
        }
        

		/**
         * The getDashTab method returns a DashTab object.
         * @return a DashTab panel object.
         */
        
        public JPanel getDashTab(){

        	return dashPanel;
        }
        
        /**
         * The getCardPanel method returns a cardPanel JPanel object.
         * @return a ProTab panel object.
         */
    	
    	public JPanel getDashCardLayout(){
    		return dashCardLayout;
    	}

 	   
	 	public DefaultCategoryDataset createDataset( )
 	   {
 	      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
 	      dataset.addValue( 1701.45, "Previous Year" , "J" );
 	      dataset.addValue( 73618.47, "Previous Year" , "F" );
 	      dataset.addValue( 62908.97, "Previous Year" ,  "M" );
 	      dataset.addValue( 0, "Previous Year" , "A" );
 	      dataset.addValue( 90286.54, "Previous Year" , "Ma" );
 	      dataset.addValue( 51203.08, "Previous Year" , "Ju" );
 	      dataset.addValue( 136700.09, "Previous Year" , "Jul" );
 	      dataset.addValue( 40015.51, "Previous Year" , "Au" );
 	      dataset.addValue( 96399.24, "Previous Year" ,  "S" );
 	      dataset.addValue( 0, "Previous Year" , "O" );
 	      dataset.addValue( 45035.33, "Previous Year" , "N" );
 	      dataset.addValue( 161364.20, "Previous Year" , "D" );
 	      
 	      dataset.addValue( 25510, "Current Year" , "J" );
 	      dataset.addValue( 66495, "Current Year" , "F" );
 	      dataset.addValue( 73691, "Current Year" ,  "M" );
 	      dataset.addValue( 93036, "Current Year" , "A" );
 	      dataset.addValue( 64027, "Current Year" , "Ma" );
 	      dataset.addValue( 73594, "Current Year" , "Ju" );
 	      dataset.addValue( 112143, "Current Year" , "Jul" );
 	      dataset.addValue( 86767, "Current Year" , "Au" );
 	      dataset.addValue( 0, "Current Year" ,  "S" );
 	      dataset.addValue( 176576, "Current Year" , "O" );
 	      dataset.addValue( 45861, "Current Year" , "N" );
 	      
 	     
 	      return dataset;
 	   }
	 	
	 	public DefaultCategoryDataset createEmptyDataset()
	 	   {
	 	      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	 	      dataset.addValue( 0, " " , " " );
	 	      return dataset;
	 	   }
	 	
	 	
	 	 public static PieDataset createPieDataset() {
	         DefaultPieDataset dataset = new DefaultPieDataset();
	         dataset.setValue("% Available", new Double(40));
	         dataset.setValue("% Candidates", new Double(21.94));
	         dataset.setValue("% on Project", new Double(14.19));
	         dataset.setValue("% on Vacation", new Double(23.87));
	         return dataset;        
	     }
	 	public static DefaultCategoryDataset createBarDataset()
	 	{
	 	      DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	 		  dataset.addValue( 25510, "Previous Year" , "Sept" );
	 	      dataset.addValue( 66495, "Previous Year" , "Oct" );
	 	      dataset.addValue( 73691, "Previous Year" ,  "Nov" );
	 	      
	 	      dataset.addValue( 93036, "Current Year" , "Sept" );
	 	      dataset.addValue( 64027, "Current Year" , "Oct" );
	 	      dataset.addValue( 73594, "Current Year" , "Nov" );
	 	   
	 	      return dataset;
	 	}
	 	
	 	
	    /////////////////////////////////////////////////////////////////////////////////////
	 	// DB connection for Pie Chart
	 	public class JDBCPieDataset extends DefaultPieDataset {

	 	    /** For serialization. */
	 	    static final long serialVersionUID = -8753216855496746108L;

	 	    /** The database connection. */
	 	    private transient Connection connection;

	 	    /**
	 	     * Creates a new JDBCPieDataset using a pre-existing database connection.
	 	     * 

	 	     * The dataset is initially empty, since no query has been supplied yet.
	 	     *
	 	     * @param con  the database connection.
	 	     */
	 	    public JDBCPieDataset(Connection con) {
	 	        if (con == null) {
	 	            throw new NullPointerException("A connection must be supplied.");
	 	        }
	 	        this.connection = con;
	 	    }


	 	    /**
	 	     * Creates a new JDBCPieDataset using a pre-existing database connection.
	 	     * 

	 	     * The dataset is initialised with the supplied query.
	 	     *
	 	     * @param con  the database connection.
	 	     * @param query  the database connection.
	 	     *
	 	     * @throws SQLException if there is a problem executing the query.
	 	     */
	 	    public JDBCPieDataset(Connection con, String query) throws SQLException {
	 	        this(con);
	 	        executeQuery(query);
	 	    }

	 	    /**
	 	     *  ExecuteQuery will attempt execute the query passed to it against the
	 	     *  existing database connection.  If no connection exists then no action
	 	     *  is taken.
	 	     *  The results from the query are extracted and cached locally, thus
	 	     *  applying an upper limit on how many rows can be retrieved successfully.
	 	     *
	 	     * @param  query  the query to be executed.
	 	     *
	 	     * @throws SQLException if there is a problem executing the query.
	 	     */
	 	    public void executeQuery(String query) throws SQLException {
	 	      executeQuery(this.connection, query);
	 	    }

	 	    /**
	 	     *  ExecuteQuery will attempt execute the query passed to it against the
	 	     *  existing database connection.  If no connection exists then no action
	 	     *  is taken.
	 	     *  The results from the query are extracted and cached locally, thus
	 	     *  applying an upper limit on how many rows can be retrieved successfully.
	 	     *
	 	     * @param  query  the query to be executed
	 	     * @param  con  the connection the query is to be executed against
	 	     *
	 	     * @throws SQLException if there is a problem executing the query.
	 	     */
	 	    public void executeQuery(Connection con, String query) throws SQLException {

	 	        Statement statement = null;
	 	        ResultSet resultSet = null;

	 	        try {
	 	            statement = con.createStatement();
	 	            resultSet = statement.executeQuery(query);
	 	            ResultSetMetaData metaData = resultSet.getMetaData();

	 	            int columnCount = metaData.getColumnCount();
	 	            if (columnCount != 2) {
	 	                throw new SQLException(
	 	                    "Invalid sql generated.  PieDataSet requires 2 columns only"
	 	                );
	 	            }

	 	            int columnType = metaData.getColumnType(2);
	 	            double value;
	 	            while (resultSet.next()) {
	 	                Comparable key = resultSet.getString(1);
	 	                switch (columnType) {
	 	                    case Types.NUMERIC:
	 	                    case Types.REAL:
	 	                    case Types.INTEGER:
	 	                    case Types.DOUBLE:
	 	                    case Types.FLOAT:
	 	                    case Types.DECIMAL:
	 	                    case Types.BIGINT:
	 	                        value = resultSet.getDouble(2);
	 	                        setValue(key, value);
	 	                        break;

	 	                    case Types.DATE:
	 	                    case Types.TIME:
	 	                    case Types.TIMESTAMP:
	 	                        Timestamp date = resultSet.getTimestamp(2);
	 	                        value = date.getTime();
	 	                        setValue(key, value);
	 	                        break;

	 	                    default:
	 	                        System.err.println(
	 	                                "JDBCPieDataset - unknown data type");
	 	                        break;
	 	                }
	 	            }

	 	            fireDatasetChanged();

	 	        }
	 	        finally {
	 	            if (resultSet != null) {
	 	                try {
	 	                    resultSet.close();
	 	                }
	 	                catch (Exception e) {
	 	                    System.err.println("JDBCPieDataset: swallowing exception.");
	 	                }
	 	            }
	 	            if (statement != null) {
	 	                try {
	 	                    statement.close();
	 	                }
	 	                catch (Exception e) {
	 	                    System.err.println("JDBCPieDataset: swallowing exception.");
	 	                }
	 	            }
	 	        }
	 	    }


	 	    /**
	 	     * Close the database connection
	 	     */
	 	    public void close() {
	 	        try {
	 	            this.connection.close();
	 	        }
	 	        catch (Exception e) {
	 	            System.err.println("JdbcXYDataset: swallowing exception.");
	 	        }
	 	    }
	 	}	
}


