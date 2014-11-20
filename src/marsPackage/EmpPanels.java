package marsPackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.Border;

public class EmpPanels extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1844833381827797972L;

	private JPanel newEmpPanel;
	private JPanel statusPanel1;
	private JPanel personalInfoPanel;
	private JPanel contactInfoPanel;
	private JPanel resumeInfoPanel;
	private JPanel statusDrop;
	private JLabel personalTitle;
	private JLabel contactTitle;
	private JLabel resumeTitle;
	private JLabel fNameLabel;
	private JLabel mNameLabel;
	private JLabel lNameLabel;
	private JLabel dOBLabel;
	private JTextField fNameField;
	private JTextField mNameField;
	private JTextField lNameField;
	private JTextField dOBField;
	private JLabel emailLabel;
	private JTextField emailField;
    private JLabel homePhoneLabel;
    private JTextField homePhoneField;
    private JLabel cellPhoneLabel;
    private JTextField cellPhoneField;
    private JLabel addressLabel;
    private JTextField addressField;
	private JLabel cityLabel;
	private JComboBox cityField;
	private JLabel stateLabel;
	private JComboBox stateField;
	private JLabel zipLabel;
	private JTextField zipField;
	private JLabel industryLabel;
	private JComboBox statusList;
	private JComboBox industryList;
	private JLabel skillLabel;
	private JComboBox skillList;
	private JLabel certLabel;
	private JComboBox certList;
	private JScrollPane scrollPane;
	
	
	// View Employee variables
	private JPanel viewEmpPanel;
	private JPanel statusPanel2;
	private JPanel vpersonalInfoPanel;
	private JPanel vcontactInfoPanel;
	private JPanel vresumeInfoPanel;
	private JPanel vstatusDrop;
	private JLabel vpersonalTitle;
	private JLabel vcontactTitle;
	private JLabel vresumeTitle;
	private JLabel vfNameLabel;
	private JLabel vmNameLabel;
	private JLabel vlNameLabel;
	private JLabel vdOBLabel;
	private JTextField vfNameField;
	private JTextField vmNameField;
	private JTextField vlNameField;
	private JTextField vdOBField;
	private JLabel vemailLabel;
	private JTextField vemailField;
    private JLabel vhomePhoneLabel;
    private JTextField vhomePhoneField;
    private JLabel vcellPhoneLabel;
    private JTextField vcellPhoneField;
    private JLabel vaddressLabel;
    private JTextField vaddressField;
	private JLabel vcityLabel;
	private JComboBox vcityField;
	private JLabel vstateLabel;
	private JComboBox vstateField;
	private JLabel vzipLabel;
	private JTextField vzipField;
	private JLabel vindustryLabel;
	private JComboBox vstatusList;
	private JComboBox vindustryList;
	private JLabel vskillLabel;
	private JComboBox vskillList;
	private JLabel vcertLabel;
	private JComboBox vcertList;
	
	private JScrollPane vscrollPane;

	
	public EmpPanels(){
		//EmpPanel will hold all new Employee panels
		newEmpPanel = new JPanel();
		newEmpPanel.setBackground(Color.WHITE);
		newEmpPanel.setLayout(new BorderLayout());
	    newEmpPanel.setPreferredSize(new Dimension(857,595));
	
			//StatusPanel1 holds J elements that are related to employees status
			Border empPanelTitle = BorderFactory.createTitledBorder("Status");
			statusPanel1 = new JPanel();
			statusPanel1.setBorder(empPanelTitle);
			statusPanel1.setBackground(Color.WHITE);
				
			//stausDrop holds the status dropbox
			statusDrop = new JPanel(new FlowLayout());
			statusDrop.setBackground(Color.WHITE);
			
			DB db = new DB();
			try {
				
				String sql = "SELECT EMPLOYEE_STATUS.EMP_STATUS"
						+ " FROM EMPLOYEE_STATUS";
						
						
				PreparedStatement Stmt = db.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = Stmt.executeQuery();
				ResultSetMetaData meta = Stmt.getMetaData();
				statusList = new JComboBox();
				
				while (rs.next()) 
	            {
	                statusList.addItem(rs.getString("EMP_STATUS"));
	            }
				
			
				
				statusDrop.add(statusList);
			statusPanel1.add(statusDrop);
		newEmpPanel.add(statusPanel1, BorderLayout.CENTER);

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.err.println("Something wrong with loading data to the project table in the GUI");
				e1.printStackTrace();
			}
			
			
			
			//personalInfoPanel contains J elements for personal info
			Border personalTitle = BorderFactory.createTitledBorder("Personal Information");
			personalInfoPanel = new JPanel();
			personalInfoPanel.setBorder(personalTitle);
			personalInfoPanel.setPreferredSize(new Dimension(450, 250));
			personalInfoPanel.setLayout(new GridBagLayout());
			GridBagConstraints g = new GridBagConstraints();
			g.insets = new Insets(20,0,0,0);
			personalInfoPanel.setBackground(Color.WHITE);
			
				fNameLabel = new JLabel("First Name ");
				g.gridx = 0;
				g.gridy = 0;
		    personalInfoPanel.add(fNameLabel, g);
		    	fNameField = new JTextField("", 17);
		    	g.gridx = 1;
		    	g.gridy = 0;
		    personalInfoPanel.add(fNameField, g);
				mNameLabel = new JLabel("M.I ");
				g.gridx = 0;
				g.gridy = 1;
		    personalInfoPanel.add(mNameLabel, g);
		    	mNameField = new JTextField("", 17);
		    	g.gridx = 1;
		    	g.gridy = 1;
		    personalInfoPanel.add(mNameField, g);
				lNameLabel = new JLabel("Last Name ");
				g.gridx = 0;
				g.gridy = 2;
		    personalInfoPanel.add(lNameLabel, g);
		    	lNameField = new JTextField("", 17);
		    	g.gridx = 1;
		    	g.gridy = 2;
		    personalInfoPanel.add(lNameField, g);
				dOBLabel = new JLabel("DOB ");
				g.gridx = 0;
				g.gridy = 3;
		    personalInfoPanel.add(dOBLabel, g);
				dOBField = new JTextField("", 17);
				g.gridx = 1;
				g.gridy = 3;
		    personalInfoPanel.add(dOBField, g);
			
		newEmpPanel.add(personalInfoPanel);
					
			Border contactTitle = BorderFactory.createTitledBorder("Contact Information");
			contactInfoPanel = new JPanel();
			contactInfoPanel.setBorder(contactTitle);
			contactInfoPanel.setPreferredSize(new Dimension(450, 450));
			contactInfoPanel.setLayout(new GridBagLayout());
			GridBagConstraints f = new GridBagConstraints();
			f.insets = new Insets(20,0,0,0);
			contactInfoPanel.setBackground(Color.WHITE);
			
				emailLabel = new JLabel("E-Mail ");
				g.gridx = 0;
				g.gridy = 0;
		    contactInfoPanel.add(emailLabel, g);
		    	emailField = new JTextField("", 17);
		    	g.gridx = 1;
		    	g.gridy = 0;
		    contactInfoPanel.add(emailField, g);
			homePhoneLabel = new JLabel("Home Phone ");
				g.gridx = 0;
				g.gridy = 1;
		    contactInfoPanel.add(homePhoneLabel, g);
		    	homePhoneField = new JTextField("", 17);
		    	g.gridx = 1;
		    	g.gridy = 1;
		    contactInfoPanel.add(homePhoneField, g);
				cellPhoneLabel = new JLabel("Cell Phone ");
				g.gridx = 0;
				g.gridy = 2;
		    contactInfoPanel.add(cellPhoneLabel, g);
		    	cellPhoneField = new JTextField("", 17);
		    	g.gridx = 1;
		    	g.gridy = 2;
		    contactInfoPanel.add(cellPhoneField, g);
				addressLabel = new JLabel("Address line ");
				g.gridx = 0;
				g.gridy = 3;
		    contactInfoPanel.add(addressLabel, g);
				addressField = new JTextField("", 17);
				g.gridx = 1;
				g.gridy = 3;
		    contactInfoPanel.add(addressField, g);
		    	cityLabel = new JLabel("Country");
				g.gridx = 0;
		    	g.gridy = 4;
		    contactInfoPanel.add(cityLabel, g);
				cityField = new JComboBox();
				try {
					
					String sql = "SELECT COUNTRY.COUNTRY_NAME"
							+ " FROM COUNTRY";
							
							
					PreparedStatement Stmt = db.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					ResultSet rs = Stmt.executeQuery();
					ResultSetMetaData meta = Stmt.getMetaData();
					
					while (rs.next()) 
		            {
		                cityField.addItem(rs.getString("COUNTRY_NAME"));
		            }
					
					
					g.gridx = 1;
			    	g.gridy = 4;
			    contactInfoPanel.add(cityField, g);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.err.println("Something wrong with loading data to the project table in the GUI");
					e1.printStackTrace();
				}
				
		    	stateLabel = new JLabel("State ");
		    	g.gridx = 0;
		    	g.gridy = 5;
		    contactInfoPanel.add(stateLabel, g);
				stateField = new JComboBox();
				try {
					
					String sql = "SELECT STATE_PROVINCE.ST_PROVIN_NAME"
							+ " FROM STATE_PROVINCE";
							
							
					PreparedStatement Stmt = db.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					ResultSet rs = Stmt.executeQuery();
					ResultSetMetaData meta = Stmt.getMetaData();
					
					while (rs.next()) 
		            {
		                stateField.addItem(rs.getString("ST_PROVIN_NAME"));
		            }
					g.gridx = 1;
					g.gridy = 5;
					contactInfoPanel.add(stateField, g);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.err.println("Something wrong with loading data to the project table in the GUI");
					e1.printStackTrace();
				}
		    	zipLabel = new JLabel("Zip ");
		    	g.gridx = 0;
		    	g.gridy = 6;
		    contactInfoPanel.add(zipLabel, g);
				zipField = new JTextField("", 17);
				g.gridx = 1;
				g.gridy = 6;
		    contactInfoPanel.add(zipField, g);
		    
		    Border resumeTitle = BorderFactory.createTitledBorder("Resume Information");
			resumeInfoPanel = new JPanel();
			resumeInfoPanel.setBorder(resumeTitle);
			resumeInfoPanel.setPreferredSize(new Dimension(450, 200));
			resumeInfoPanel.setLayout(new GridBagLayout());
			GridBagConstraints r = new GridBagConstraints();
			r.insets = new Insets(20,0,0,0);
			resumeInfoPanel.setBackground(Color.WHITE);
			
			
				industryLabel = new JLabel("Industry ");
				r.gridx = 0;
				r.gridy = 0;
			resumeInfoPanel.add(industryLabel, r);
			industryList = new JComboBox();
			try {
				
				String sql = "SELECT INDUSTRY.INDUSTRY_NAME"
						+ " FROM INDUSTRY";
						
						
				PreparedStatement Stmt = db.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = Stmt.executeQuery();
				ResultSetMetaData meta = Stmt.getMetaData();
				
				
				while (rs.next()) 
	            {
	                industryList.addItem(rs.getString("INDUSTRY_NAME"));
	            }
				
				
				r.gridx = 1;
				r.gridy = 0;
			
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.err.println("Something wrong with loading data to the project table in the GUI");
				e1.printStackTrace();
			}
			resumeInfoPanel.add(industryList, r);
		
			skillLabel = new JLabel("Skill ");
			r.gridx = 0;
			r.gridy = 1;
		resumeInfoPanel.add(skillLabel, r);
		skillList = new JComboBox();
			r.gridx = 1;
			r.gridy = 1;
			resumeInfoPanel.add(skillList, r);
			try {
			
					String sql = "SELECT SKILL.SKILL_NAME"
							+ " FROM SKILL;";
					
					
					PreparedStatement Stmt = db.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					ResultSet rs = Stmt.executeQuery();
					ResultSetMetaData meta = Stmt.getMetaData();
					
			
					while (rs.next()) 
					{
						skillList.addItem(rs.getString("SKILL_NAME"));
					}
			
			
					
			
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.err.println("Something wrong with loading data to the project table in the GUI");
					e1.printStackTrace();
				}
		
			certLabel = new JLabel("Certification ");
			r.gridx = 0;
			r.gridy = 2;
			resumeInfoPanel.add(certLabel, r);

			try {
		
					String sql = "SELECT CERTIFICATION.CERT_NAME"
							+ " FROM CERTIFICATION";
				
				
					PreparedStatement Stmt = db.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					ResultSet rs = Stmt.executeQuery();
					ResultSetMetaData meta = Stmt.getMetaData();
					certList = new JComboBox();
		
					while (rs.next()) 
					{
						certList.addItem(rs.getString("CERT_NAME"));
					}
		
		
					r.gridx = 1;
					r.gridy = 2;
					resumeInfoPanel.add(certList, r);
		
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.err.println("Something wrong with loading data to the project table in the GUI");
						e1.printStackTrace();
					}
				
			// View Employee panels
			//EmpPanel will hold all new Employee panels
			viewEmpPanel = new JPanel();
			viewEmpPanel.setBackground(Color.WHITE);
			viewEmpPanel.setLayout(new BorderLayout());
		    viewEmpPanel.setPreferredSize(new Dimension(857,595));
		
				//StatusPanel1 holds J elements that are related to employees status
				Border vempPanelTitle = BorderFactory.createTitledBorder("Status");
				statusPanel2 = new JPanel();
				statusPanel2.setBorder(vempPanelTitle);
				statusPanel2.setBackground(Color.WHITE);
					
				//stausDrop holds the status dropbox
				vstatusDrop = new JPanel(new FlowLayout());
				vstatusDrop.setBackground(Color.WHITE);
				/*
				try {
					
					String sql = "SELECT EMPLOYEE_STATUS.EMP_STATUS"
							+ " FROM EMPLOYEE_STATUS";
							
							
					PreparedStatement Stmt = db.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					ResultSet rs = Stmt.executeQuery();
					ResultSetMetaData meta = Stmt.getMetaData();
					*/
					vstatusList = new JComboBox();
					/*
					while (rs.next()) 
		            {
		                statusList.addItem(rs.getString("EMP_STATUS"));
		            }
					
				
					*/
					vstatusDrop.add(vstatusList);
				statusPanel2.add(vstatusDrop);
			viewEmpPanel.add(statusPanel2, BorderLayout.CENTER);
			/*
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.err.println("Something wrong with loading data to the project table in the GUI");
					e1.printStackTrace();
				}
				
				
				*/
				//personalInfoPanel contains J elements for personal info
				Border vpersonalTitle = BorderFactory.createTitledBorder("Personal Information");
				vpersonalInfoPanel = new JPanel();
				vpersonalInfoPanel.setBorder(personalTitle);
				vpersonalInfoPanel.setPreferredSize(new Dimension(450, 250));
				vpersonalInfoPanel.setLayout(new GridBagLayout());
				GridBagConstraints s = new GridBagConstraints();
				s.insets = new Insets(20,0,0,0);
				vpersonalInfoPanel.setBackground(Color.WHITE);
				
					vfNameLabel = new JLabel("First Name ");
					s.gridx = 0;
					s.gridy = 0;
			    vpersonalInfoPanel.add(vfNameLabel, s);
			    	vfNameField = new JTextField("", 17);
			    	/*try {
						
						String sql = "SELECT EMPLOYEE.EMP_FIRST_NAME"
								+ " FROM EMPLOYEE"
								+ "WHERE EMP_FIRST_NAME = 'Abel';";
								
								
						PreparedStatement Stmt = db.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						ResultSet rs = Stmt.executeQuery();
	
						while (rs.next()) 
			            {
							vfNameField.setText(rs.getString("EMP_FIRST_NAME"));
			            }
						
				
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.err.println("Something wrong with loading data to the project table in the GUI");
						e1.printStackTrace();
					}
			    	*/
			    	s.gridx = 1;
			    	s.gridy = 0;
			    vpersonalInfoPanel.add(vfNameField, s);
					vmNameLabel = new JLabel("M.I ");
					s.gridx = 0;
					s.gridy = 1;
			    vpersonalInfoPanel.add(vmNameLabel, s);
			    	vmNameField = new JTextField("", 17);
			    	s.gridx = 1;
			    	s.gridy = 1;
			    vpersonalInfoPanel.add(vmNameField, s);
					vlNameLabel = new JLabel("Last Name ");
					s.gridx = 0;
					s.gridy = 2;
			    vpersonalInfoPanel.add(vlNameLabel, s);
			    	vlNameField = new JTextField("", 17);
			    	s.gridx = 1;
			    	s.gridy = 2;
			    vpersonalInfoPanel.add(vlNameField, s);
					vdOBLabel = new JLabel("DOB ");
					s.gridx = 0;
					s.gridy = 3;
			    vpersonalInfoPanel.add(vdOBLabel, s);
					vdOBField = new JTextField("", 17);
					s.gridx = 1;
					s.gridy = 3;
			    vpersonalInfoPanel.add(vdOBField, s);
				
			viewEmpPanel.add(vpersonalInfoPanel);
						
				Border vcontactTitle = BorderFactory.createTitledBorder("Contact Information");
				vcontactInfoPanel = new JPanel();
				vcontactInfoPanel.setBorder(vcontactTitle);
				vcontactInfoPanel.setPreferredSize(new Dimension(450, 450));
				vcontactInfoPanel.setLayout(new GridBagLayout());
				GridBagConstraints e = new GridBagConstraints();
				e.insets = new Insets(20,0,0,0);
				vcontactInfoPanel.setBackground(Color.WHITE);
				
					vemailLabel = new JLabel("E-Mail ");
					s.gridx = 0;
					s.gridy = 0;
			    vcontactInfoPanel.add(vemailLabel, s);
			    	vemailField = new JTextField("", 17);
			    	s.gridx = 1;
			    	s.gridy = 0;
			    vcontactInfoPanel.add(vemailField, s);
				vhomePhoneLabel = new JLabel("Home Phone ");
					s.gridx = 0;
					s.gridy = 1;
			    vcontactInfoPanel.add(vhomePhoneLabel, s);
			    	vhomePhoneField = new JTextField("", 17);
			    	s.gridx = 1;
			    	s.gridy = 1;
			    vcontactInfoPanel.add(vhomePhoneField, s);
					vcellPhoneLabel = new JLabel("Cell Phone ");
					s.gridx = 0;
					s.gridy = 2;
			    vcontactInfoPanel.add(vcellPhoneLabel, s);
			    	vcellPhoneField = new JTextField("", 17);
			    	s.gridx = 1;
			    	s.gridy = 2;
			    vcontactInfoPanel.add(vcellPhoneField, s);
					vaddressLabel = new JLabel("Address line ");
					s.gridx = 0;
					s.gridy = 3;
			    vcontactInfoPanel.add(vaddressLabel, s);
					vaddressField = new JTextField("", 17);
					s.gridx = 1;
					s.gridy = 3;
			    vcontactInfoPanel.add(vaddressField, s);
			    	vcityLabel = new JLabel("Country");
					s.gridx = 0;
			    	s.gridy = 4;
			    vcontactInfoPanel.add(vcityLabel, s);
					vcityField = new JComboBox();
					/*try {
						
						String sql = "SELECT COUNTRY.COUNTRY_NAME"
								+ " FROM COUNTRY";
								
								
						PreparedStatement Stmt = db.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						ResultSet rs = Stmt.executeQuery();
						ResultSetMetaData meta = Stmt.getMetaData();
						
						while (rs.next()) 
			            {
			                cityField.addItem(rs.getString("COUNTRY_NAME"));
			            }
						
						*/
						s.gridx = 1;
				    	s.gridy = 4;
				    vcontactInfoPanel.add(vcityField, s);
						/*
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.err.println("Something wrong with loading data to the project table in the GUI");
						e1.printStackTrace();
					}
					*/
			    	vstateLabel = new JLabel("State ");
			    	s.gridx = 0;
			    	s.gridy = 5;
			    vcontactInfoPanel.add(vstateLabel, s);
					vstateField = new JComboBox();
					/*try {
						
						String sql = "SELECT STATE_PROVINCE.ST_PROVIN_NAME"
								+ " FROM STATE_PROVINCE";
								
								
						PreparedStatement Stmt = db.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						ResultSet rs = Stmt.executeQuery();
						ResultSetMetaData meta = Stmt.getMetaData();
						
						while (rs.next()) 
			            {
			                stateField.addItem(rs.getString("ST_PROVIN_NAME"));
			            }*/
						s.gridx = 1;
						s.gridy = 5;
						vcontactInfoPanel.add(vstateField, s);
						/*
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.err.println("Something wrong with loading data to the project table in the GUI");
						e1.printStackTrace();
					}*/
			    	vzipLabel = new JLabel("Zip ");
			    	s.gridx = 0;
			    	s.gridy = 6;
			    vcontactInfoPanel.add(vzipLabel, s);
					vzipField = new JTextField("", 17);
					s.gridx = 1;
					s.gridy = 6;
			    vcontactInfoPanel.add(vzipField, s);
			    
			    Border vresumeTitle = BorderFactory.createTitledBorder("Resume Information");
				vresumeInfoPanel = new JPanel();
				vresumeInfoPanel.setBorder(vresumeTitle);
				vresumeInfoPanel.setPreferredSize(new Dimension(350, 200));
				vresumeInfoPanel.setLayout(new GridBagLayout());
				GridBagConstraints t = new GridBagConstraints();
				t.insets = new Insets(20,0,0,0);
				vresumeInfoPanel.setBackground(Color.WHITE);
				
					vindustryLabel = new JLabel("Industry ");
					t.gridx = 0;
					t.gridy = 0;
				vresumeInfoPanel.add(vindustryLabel, t);
				/*
				try {
					
					String sql = "SELECT INDUSTRY.INDUSTRY_NAME"
							+ " FROM INDUSTRY";
							
							
					PreparedStatement Stmt = db.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					ResultSet rs = Stmt.executeQuery();
					ResultSetMetaData meta = Stmt.getMetaData();
					*/
					vindustryList = new JComboBox();
					/*
					while (rs.next()) 
		            {
		                industryList.addItem(rs.getString("INDUSTRY_NAME"));
		            }
					
				*/	
					t.gridx = 1;
					t.gridy = 0;
					vresumeInfoPanel.add(vindustryList, t);
				
				vskillLabel = new JLabel("Skill ");
				t.gridx = 0;
				t.gridy = 1;
				vresumeInfoPanel.add(vskillLabel, t);
				vskillList = new JComboBox();
				t.gridx = 1;
				t.gridy = 1;
				vresumeInfoPanel.add(vskillList, t);
				vcertLabel = new JLabel("Certification ");
				t.gridx = 0;
				t.gridy = 2;
				vresumeInfoPanel.add(vcertLabel, t);
				vcertList = new JComboBox();
				t.gridx = 1;
				t.gridy = 2;
				vresumeInfoPanel.add(vcertList, t);
				
					/*
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.err.println("Something wrong with loading data to the project table in the GUI");
					e1.printStackTrace();
				}*/
				db.close();
					
			
	}
	
	/**
	 * The getNewEmpPanel method will return a panel containing
	 * all new employee panels.
	 * @return a newEmpPanel object.
	 */
	public JPanel getNewEmpPanel(){
		return newEmpPanel;
	}
	
	/**
	 * getStatusPanel holds J elements that are related to employees and customers assignment to a project.
	 * @return a addEmpPanel object
	 */
	public JPanel getStatusPanel1(){
		return statusPanel1;
	}
	
	public JPanel personalInfoPanel(){
		return personalInfoPanel;
	}
	
	public JPanel contactInfoPanel(){
		return contactInfoPanel;
	}
	
	public JPanel resumeInfoPanel(){
		return resumeInfoPanel;
	}
	
	public String getFirstName(){
		String str = fNameField.getText();
		return str;
	}
	
	public String getLastName(){
		String str = lNameField.getText();
		return str;
	}
	
	public String getMiddleName(){
		String str = mNameField.getText();
		return str;
	}
	
	public String getDOB(){
		String str = dOBField.getText();
		return str;
	}
	
	public String getEmail(){
		String str = emailField.getText();
		return str;
	}
	
	public String getHomePhone(){
		String str = homePhoneField.getText();
		return str;
	}
	
	public String getCellPhone(){
		String str = cellPhoneField.getText();
		return str;
	}
	
	public String getAddress(){
		String str = addressField.getText();
		return str;
	}
	
	public String getCity(){
		String str = cityField.getSelectedItem().toString();
		return str;
	}
	
	public String getState(){
		String str = stateField.getSelectedItem().toString();
		return str;
	}
	
	public String getZip(){
		String str = zipField.getText();
		return str;
	}
	
	public String getIndustry(){
		String str = industryList.getSelectedItem().toString();
		return str;
	}
	
	public String getStatus(){
		String str = statusList.getSelectedItem().toString();
		return str;
	}
	
	public JPanel getviewEmpPanel(){
		return viewEmpPanel;
	}
	
	/**
	 * getStatusPanel holds J elements that are related to employees and customers assignment to a project.
	 * @return a addEmpPanel object
	 */
	public JPanel getStatusPanel2(){
		return statusPanel2;
	}
	
	public JPanel vpersonalInfoPanel(){
		return vpersonalInfoPanel;
	}
	
	public JPanel vcontactInfoPanel(){
		return vcontactInfoPanel;
	}
	
	public JPanel vresumeInfoPanel(){
		return vresumeInfoPanel;
	}

}
