import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class SeeDetails extends JFrame implements MouseListener, ActionListener{
	
		public static void main(String args[])
	{
		SeeDetails obj = new SeeDetails(1001);
		obj.setVisible(true);
		//obj.run();
	}
	
	
	private JLabel LabelTitle,WelcomeLabel,LabelBackGroundImage,LabelTotalMember, LabelTotalInstructor, LabelSearchID, LabelDate;
	private JTextField SearchIDTF;
	private JButton buttonSeeDetails, buttonBack;
	private JRadioButton radioMember, radioInstructor;
	private ButtonGroup UserStatusGroup;
	private JPanel panel;
	private JLabel LabelPMM, LabelPYYYY;
	private JSpinner spinnerMM, spinnerYYYY;
	private SpinnerModel valueYYYY, valueMM;
    private boolean	flagUserStatus,flagTransactionDate, flagTransactionDone, flagUserId, flagDBUserID,flagMemberCount, flagInstructorCount, flagMember, flagInstructor,flagCount;
	private String UserStatus;
	private int UserID, AdminId, MM, YYYY;
	
	public SeeDetails(int AdminId)
	{
	super("Check Payment - Page");
	Color lightButton = new Color(71, 92, 150);
	Color lightBlue = new Color(172, 166, 255);
		
	this.setSize(600, 650);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
		
	panel = new JPanel();
	panel.setLayout(null);
	
	panel.setBackground(Color.WHITE);
	ImageIcon img = new ImageIcon("icon.jpg");
    this.setIconImage(img.getImage());
	
	LabelBackGroundImage = new JLabel();
	LabelBackGroundImage.setBounds(0,0, 600,150);
    ImageIcon imgThisImg = new ImageIcon("logInBackground.JPG");
	LabelBackGroundImage.setIcon(imgThisImg);
	panel.add(LabelBackGroundImage);
	
	this.AdminId=AdminId;
	
	LabelTitle = new JLabel("Check Payment");
	LabelTitle.setFont(new Font("Tahoma", Font.PLAIN, 19));
	LabelTitle.setForeground(Color.BLACK);
	LabelTitle.setBounds(212,160,250,30);
	panel.add(LabelTitle);


	LabelTotalMember = new JLabel("  Total Member : ");
	LabelTotalMember.setBounds(135, 210, 150, 25);
	LabelTotalMember.setFont(new Font("Ariel", Font.PLAIN, 15));
	LabelTotalMember.setForeground(Color.BLACK);
	panel.add(LabelTotalMember);
	
	LabelTotalInstructor = new JLabel("Total Instructor : ");
	LabelTotalInstructor.setBounds(320, 210, 150, 25);
	LabelTotalInstructor.setFont(new Font("Ariel", Font.PLAIN, 15));
	LabelTotalInstructor.setForeground(Color.BLACK);
	panel.add(LabelTotalInstructor);
	
	 
	LabelSearchID = new JLabel("Search ID : ");
	LabelSearchID.setBounds(150, 250, 120, 25);
	LabelSearchID.setFont(new Font("Ariel", Font.PLAIN, 15));
	LabelSearchID.setForeground(Color.BLACK);
	panel.add(LabelSearchID);
	
	
	SearchIDTF = new JTextField();
	SearchIDTF.setBounds(290, 250, 130, 25);
	panel.add(SearchIDTF);
	
	
	LabelDate = new JLabel("For Month : ");
	LabelDate.setBounds(150, 285, 120, 25);
	LabelDate.setFont(new Font("Ariel", Font.PLAIN, 15));
	LabelDate.setForeground(Color.BLACK);
	panel.add(LabelDate);
	
		valueMM =  new SpinnerNumberModel(1, //initial value  
                1, //minimum value  
                12, //maximum value  
                1); //step 

    valueYYYY =  new SpinnerNumberModel(2000, //initial value  
                2000, //minimum value  
                3000, //maximum value  
                1); //step
	
	LabelPMM = new JLabel("MM");
	LabelPMM.setFont(new Font("Tahoma", Font.PLAIN, 12));
	//LabelPMM.setForeground(Color.GRAY);
	LabelPMM.setBounds(240, 288, 20, 20);  
	panel.add(LabelPMM); 		

	spinnerMM = new JSpinner(valueMM);   
    spinnerMM.setBounds(270,288,35,20);  
	spinnerMM.addMouseListener(this);
    JFormattedTextField tfm = ((JSpinner.DefaultEditor)spinnerMM.getEditor()).getTextField();			
    tfm.setEditable(false);			
    panel.add(spinnerMM);  
	
	LabelPYYYY = new JLabel("YYYY");
	LabelPYYYY.setFont(new Font("Tahoma", Font.PLAIN, 12));
	//LabelPYYYY.setForeground(Color.GRAY);
	LabelPYYYY.setBounds(325, 288, 40, 20);
	panel.add(LabelPYYYY);	
	
	spinnerYYYY = new JSpinner(valueYYYY);   
    spinnerYYYY.setBounds(368,288,50,20);  
	spinnerYYYY.addMouseListener(this);
    JFormattedTextField tfy = ((JSpinner.DefaultEditor)spinnerYYYY.getEditor()).getTextField();			
    tfy.setEditable(false);			
    panel.add(spinnerYYYY);
	
	
	radioMember = new JRadioButton("Member");
	radioMember.setBounds(190,315,100,30);
	radioMember.setBackground(Color.WHITE);
	radioMember.addActionListener(this);
	panel.add(radioMember);
	
		
	radioInstructor = new JRadioButton("Instructor");
	radioInstructor.setBounds(300,315,100,30);
	radioInstructor.setBackground(Color.WHITE);
	radioInstructor.addActionListener(this);
	panel.add(radioInstructor);
	
	UserStatusGroup= new ButtonGroup();
	UserStatusGroup.add(radioMember);
	UserStatusGroup.add(radioInstructor);
	
	buttonSeeDetails = new JButton("Check");
	buttonSeeDetails.setBounds(155,355,120, 30);
	buttonSeeDetails.setFont(new Font("Ariel", Font.PLAIN, 16));	
	buttonSeeDetails.setForeground(Color.BLACK);
	buttonSeeDetails.setBackground(lightButton);
    buttonSeeDetails.addActionListener(this);
	buttonSeeDetails.addMouseListener(this);
	panel.add(buttonSeeDetails);

	
	buttonBack = new JButton("Back");
	buttonBack.setBounds(295,355,120,30);
	buttonBack.setFont(new Font("Ariel", Font.PLAIN, 16));	
	buttonBack.setForeground(Color.BLACK);
	buttonBack.setBackground(lightButton);
    buttonBack.addActionListener(this);
	buttonBack.addMouseListener(this);
	panel.add(buttonBack);
	
		WelcomeLabel = new JLabel(" Logged in as : Admin");
	WelcomeLabel.setBounds(215, 520, 200, 20);
	WelcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	WelcomeLabel.setForeground(Color.BLACK);	
	panel.add(WelcomeLabel);
	
	WelcomeLabel = new JLabel(" ID : "+AdminId);
	WelcomeLabel.setBounds(255, 550, 200, 20);
	WelcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	WelcomeLabel.setForeground(Color.BLACK);	
	panel.add(WelcomeLabel);
				
	this.add(panel);
		
	}//end of constructor
	
	
	public void actionPerformed(ActionEvent ae) throws NumberFormatException
	{
	System.out.println("action");
	
	if(ae.getSource()==radioMember || ae.getSource()==radioInstructor)
	{
	System.out.println("radio");
	flagUserStatus=true;
    if(ae.getSource()==radioMember)
    {
	UserStatus=ae.getActionCommand();
	flagMember=true;
	flagInstructor=false;
    }
    else if(ae.getSource()==radioInstructor)
	{
	UserStatus=ae.getActionCommand();
    flagInstructor=true;
    flagMember=false;	
	}	
	
	}

	
	
	if(ae.getSource()== buttonSeeDetails)
	{
	
	flagTransactionDate=false;
	flagTransactionDone=false;
	flagUserId=false;
	flagDBUserID=false;
	flagMemberCount=false;
	flagInstructorCount=false;
	flagCount=false;
	
	
		
	if(SearchIDTF.getText().isEmpty())
	{
 	JOptionPane.showMessageDialog(this, "Please Enter ID");
	}
	else 
	{
	try{
	UserID=Integer.parseInt(SearchIDTF.getText());
	}catch(NumberFormatException en){}
	flagUserId=true;
	}
	
	getDate();
	
	if(flagUserStatus==false)
	{
	JOptionPane.showMessageDialog(this, "Please Select User");	
	}
	
	System.out.println("flahUSerID   "+flagUserId+"   FlagStatus  "+flagUserStatus);
	
	if(flagUserId && flagUserStatus)
	{
		CheckUserId();
		CheckPaymentDate();
	}
	
	
	
	
	
	}
	
	}
	
	
	
	
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	
	
	public void mouseClicked(MouseEvent me)
	{
		JButton b = (JButton) me.getComponent();
	
	if(b==buttonBack)
	{
		System.out.println("buttonBack");
		AdminFinancialManage fin = new AdminFinancialManage(1001);
		try{
		this.setVisible(false);
		fin.setVisible(true);
		}catch(Exception ex){}
	}	
	}
	
	public void CheckUserId()
	{
		if(flagMember)
		{
			CheckMemberId();
		}
		else if(flagInstructor)
		{
			CheckInstructorId();
		}
	}
	
	public void CheckPaymentDate()
	{
		if(flagMemberCount)
		{
			CheckMemberTransaction();
		}
		if(flagInstructorCount)
		{
			CheckInstructorTransaction();
		}
	}
	
	public void CheckMemberId()
	{
		
		
		String queryMemberId ="SELECT `UserId` FROM `memberacc` WHERE UserId ="+ UserID+";";
	    Connection con=null;
        Statement st = null;  
		ResultSet rs = null;		
			
			try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Group8F","root","");
			System.out.println("connection done");
			st = con.createStatement();
			System.out.println("statement created");	
			
		    rs = st.executeQuery(queryMemberId);
			System.out.println("results received");	
			
			
			while(rs.next())
			{
			int mID = rs.getInt("UserId");
            if(UserID==mID){
			flagMemberCount=true;	
			}
			}
		

			}   
		catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
			
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
		}
		if(flagMemberCount==false)
		{
			JOptionPane.showMessageDialog(this, "Member Not Found");
		}
	}
	
	
	public void CheckInstructorId()
	{
		
		
		String queryInstructorId ="SELECT `UserId` FROM `instructoracc` WHERE UserId ="+ UserID+";";
	    Connection con=null;
        Statement st = null;  
		ResultSet rs = null;		
			
			try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Group8F","root","");
			System.out.println("connection done");
			st = con.createStatement();
			System.out.println("statement created");	
			
		    rs = st.executeQuery(queryInstructorId);
			System.out.println("results received");	
			
			
			while(rs.next())
			{
			int mID = rs.getInt("UserId");
            if(UserID==mID){
			flagInstructorCount=true;	
			}
			}
			
			

			}   
		catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
			
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
		}
		
		if(flagInstructor==false)
		{
			JOptionPane.showMessageDialog(this, "Instructor Not Found");
		}
		
	}
	
	public void CheckMemberTransaction()
	{   
		String queryTransactionDate ="SELECT `AccountId`,`Month` , `Year` FROM `transaction` WHERE AccountId ="+ UserID+";"; 
	    Connection con=null;
        Statement st = null;
		ResultSet rs = null;		
			
			try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Group8F","root","");
			System.out.println("connection done");
			st = con.createStatement();
			System.out.println("statement created");
			
			
		    rs = st.executeQuery(queryTransactionDate);
			System.out.println("results received");	
			
			
			while(rs.next())
			{
				System.out.println("loop");	
				int m = rs.getInt("Month");
				int y = rs.getInt("Year");
				int id = rs.getInt("AccountId");
				
				System.out.println("SAME     id "+id +"Pmonth"+MM+" m "+m+"Pyear" +YYYY+" yy"+y);
				
				if(UserID==id && MM==m && YYYY==y)
				{   System.out.println("SAME     id "+id +"Pmonth"+MM+" m "+m+"Pyear" +YYYY+" yy"+y);
					JOptionPane.showMessageDialog(this," Payment  Already DOne");
                    flagTransactionDone=true;
					
		
		            AdminFinancialManage fin = new AdminFinancialManage(AdminId);
		            try{
		            this.setVisible(false);
	             	fin.setVisible(true);
	            	}catch(Exception ex){}
					
				}
			}
			if(flagTransactionDone==false)
			{
				JOptionPane.showMessageDialog(this," Member Payment  Not  DOne");
				if (JOptionPane.showConfirmDialog(null, "Want to Invalid Account?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
                  System.out.println("Yes");
				  UpdateAccount();
                } else 
				{
                   // no option
                }
			}
			

			}   
		catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
			
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
		}
			
		

	}
	
	
	public void CheckInstructorTransaction()
	{   
		String queryTransactionDate ="SELECT `AccountId`, `Month` , `Year` FROM `transaction` WHERE AccountId ="+ UserID+";"; 
	    Connection con=null;
        Statement st = null;
		ResultSet rs = null;		
			
			try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Group8F","root","");
			System.out.println("connection done");
			st = con.createStatement();
			System.out.println("statement created");
			
			
		    rs = st.executeQuery(queryTransactionDate);
			System.out.println("results received");	
			
			
			while(rs.next())
			{
				System.out.println("loop");	
				int m = rs.getInt("Month");
				int y = rs.getInt("Year");
				int id = rs.getInt("AccountId");
				
				System.out.println("NOT SAME     id "+id +"Pmonth"+MM+" m "+m+"Pyear" +YYYY+" yy"+y);
				
				if(UserID==id && MM==m && YYYY==y)
				{   System.out.println("SAME     id "+id +"Pmonth"+MM+" m "+m+"Pyear" +YYYY+" yy"+y);
					JOptionPane.showMessageDialog(this,"  Payment Already DOne");
                    flagTransactionDate=true;
					
		
		            AdminFinancialManage fin = new AdminFinancialManage(AdminId);
		            try{
		            this.setVisible(false);
	             	fin.setVisible(true);
	            	}catch(Exception ex){}
					
				}
			}
			if(flagTransactionDate==false)
			{
				JOptionPane.showMessageDialog(this," Instructor Payment  Not  DOne");
				if (JOptionPane.showConfirmDialog(null, "Want to Invalid Account?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
                  System.out.println("Yes");
				  UpdateAccount();
                } else 
				{
                   // no option
                }
			}
			

			}   
		catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
			//flagTransactionDate=false;
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
		}
			
		

	}
	
	public void UpdateAccount()
	{
	        Connection con =null;
            Statement st = null;
			String queryForUpdate = "UPDATE accounts SET Validity= 'Invalid' where UserId="+UserID;
	
		try
		{
		    Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Group8F","root","");
			System.out.println("connection done");
			st = con.createStatement();
			System.out.println("statement created");			
			st.executeUpdate(queryForUpdate);
			JOptionPane.showMessageDialog(this, "Account is Now Invalid"); 
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this, e.getMessage()); 
		}
	}
	
	
	public void getDate()
	{

	MM = (Integer)spinnerMM.getValue();		
	
	YYYY = (Integer)spinnerYYYY.getValue();		
	
	}
	
	
}