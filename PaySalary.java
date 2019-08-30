import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class PaySalary extends JFrame implements MouseListener{
	
	public static void main(String args[])
	{
		PaySalary obj = new PaySalary(1001);
		obj.setVisible(true);
	}
	
	private JLabel LabelTitle,WelcomeLabel, LabelInstructorID, LabelBill,LabelBackGroundImage;
	private JLabel LabelPaidDate, LabelPDD, LabelPMM, LabelPYYYY;
	private JTextField InstructorIDTF, InstructorBillTF;
	private JSpinner spinnerPDD, spinnerPMM, spinnerPYYYY;
	private SpinnerModel valuePDD, valuePMM, valuePYYYY;
	private JButton buttonReciveBill, buttonBack;
	private JPanel panel;
	private String PaidDate, Status, queryTransaction;
	private int PMonth, PYear, transactionNo=100;
	private double Salary, Fee;
	private int AdminId, InstructorId, count;
	private boolean flagTransactionDate=true, flagDB,flagCount;
	
	public PaySalary(int AdminId)
	{
	super("Pay Salary");
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
	LabelBackGroundImage.setBounds(0,0, 600,180);
    ImageIcon imgThisImg = new ImageIcon("logInBackground.JPG");
	LabelBackGroundImage.setIcon(imgThisImg);
	panel.add(LabelBackGroundImage);

	this.AdminId=AdminId;
	Status="Instructor";	
	
	
	LabelTitle = new JLabel("Pay Instructor Salary");
	LabelTitle.setFont(new Font("Tahoma", Font.PLAIN, 19));
	LabelTitle.setForeground(Color.BLACK);
	LabelTitle.setBounds(212,190,250,30);
	panel.add(LabelTitle);

	LabelInstructorID = new JLabel("Enter Instructor Id :");
	LabelInstructorID.setBounds(120, 250, 150, 25);
	LabelInstructorID.setFont(new Font("Tahoma", Font.PLAIN, 15));
	LabelInstructorID.setForeground(Color.BLACK);
	panel.add(LabelInstructorID);

	InstructorIDTF = new JTextField();
	InstructorIDTF.setBounds(300, 250, 135, 25);
	panel.add(InstructorIDTF);
	
	LabelInstructorID = new JLabel("Enter Amount       :");
	LabelInstructorID.setBounds(120, 290, 150, 25);
	LabelInstructorID.setFont(new Font("Tahoma", Font.PLAIN, 15));
	LabelInstructorID.setForeground(Color.BLACK);
	panel.add(LabelInstructorID);

	InstructorBillTF = new JTextField();
	InstructorBillTF.setBounds(300, 290, 135, 25);
	panel.add(InstructorBillTF);
	
	LabelPaidDate = new JLabel("Payment Date : ");
	LabelPaidDate.setBounds(120, 330, 125, 25);
	LabelPaidDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
	LabelPaidDate.setForeground(Color.BLACK);
	panel.add(LabelPaidDate);
	
	
	LabelPDD = new JLabel("DD");
	LabelPDD.setFont(new Font("Tahoma", Font.PLAIN, 12));
	//LabelPDD.setForeground(Color.GRAY);
	LabelPDD.setBounds(230, 333, 20, 20);
	panel.add(LabelPDD);

	LabelPMM = new JLabel("MM");
	LabelPMM.setFont(new Font("Tahoma", Font.PLAIN, 12));
	//LabelPMM.setForeground(Color.GRAY);
	LabelPMM.setBounds(300, 333, 20, 20);  
	panel.add(LabelPMM);

	LabelPYYYY = new JLabel("YYYY");
	LabelPYYYY.setFont(new Font("Tahoma", Font.PLAIN, 12));
	//LabelPYYYY.setForeground(Color.GRAY);
	LabelPYYYY.setBounds(370, 333, 40, 20);
	panel.add(LabelPYYYY);	
	
	valuePDD =  new SpinnerNumberModel(1, //initial value  
                1, //minimum value  
                31, //maximum value  
                1); //step  

    valuePMM =  new SpinnerNumberModel(1, //initial value  
                1, //minimum value  
                12, //maximum value  
                1); //step 

    valuePYYYY =  new SpinnerNumberModel(2017, //initial value  
                2017, //minimum value  
                3000, //maximum value  
                1); //step 		
				
				
	spinnerPDD = new JSpinner(valuePDD);   
    spinnerPDD.setBounds(250,333,35,20); 
    spinnerPDD.addMouseListener(this);	
    JFormattedTextField tfpd = ((JSpinner.DefaultEditor)spinnerPDD.getEditor()).getTextField();			
    tfpd.setEditable(false);			
    panel.add(spinnerPDD);    
	
	
	spinnerPMM = new JSpinner(valuePMM);   
    spinnerPMM.setBounds(323,333,35,20); 
    spinnerPMM.addMouseListener(this);	
    JFormattedTextField tfpm = ((JSpinner.DefaultEditor)spinnerPMM.getEditor()).getTextField();			
    tfpm.setEditable(false);			
    panel.add(spinnerPMM);  
	
	
	spinnerPYYYY = new JSpinner(valuePYYYY);   
    spinnerPYYYY.setBounds(413,333,50,20);  
	spinnerPYYYY.addMouseListener(this);
    JFormattedTextField tfpy = ((JSpinner.DefaultEditor)spinnerPYYYY.getEditor()).getTextField();			
    tfpy.setEditable(false);			
    panel.add(spinnerPYYYY);

	
	
	buttonReciveBill = new JButton("Pay Salary");
	buttonReciveBill.setBounds(150,400,120,30);
	buttonReciveBill.setFont(new Font("Ariel", Font.PLAIN, 15));	
	buttonReciveBill.setForeground(Color.BLACK);
	buttonReciveBill.setBackground(lightButton);
	buttonReciveBill.addMouseListener(this);
	panel.add(buttonReciveBill);

	
	buttonBack = new JButton("BACK");
	buttonBack.setBounds(300,400,120,30);
	buttonBack.setFont(new Font("Ariel", Font.PLAIN, 15));	
	buttonBack.setForeground(Color.BLACK);
	buttonBack.setBackground(lightButton);
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


	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}

	public void mouseClicked(MouseEvent me)
	{
		JButton b = (JButton) me.getComponent();
		

		if(b==buttonReciveBill)
		{
		if(InstructorBillTF.getText().isEmpty())
	    {
         JOptionPane.showMessageDialog(this, "Please Enter Amount");
	    }
		
		System.out.println("buttonReciveBill");
		try{
		InstructorId=Integer.parseInt(InstructorIDTF.getText());
        Salary=Double.parseDouble(InstructorBillTF.getText());	
		}catch(Exception ex){}
		
		getPaidDate();
		
		CheckInstructorId();
		
		if(flagCount)
		{
		CheckTransaction();
		CheckTransactionNo();
		
		if(flagTransactionDate)
		{System.out.println("call into db");
		insertIntoDB();
		Back();}
		
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Instructor Not Found");
		}
		
		
		}
		

	    else if(b==buttonBack)
		{
			System.out.println("buttonBack");
			AdminFinancialManage fin = new AdminFinancialManage(1001);
			try{
			this.setVisible(false);
			fin.setVisible(true);
		    }catch(Exception ex){}
		}
		
	}
	
	public void getPaidDate()
	{
	Integer PDD = (Integer)spinnerPDD.getValue();		
	String ConvertPDD = Integer.toString(PDD);
	
	Integer PMM = (Integer)spinnerPMM.getValue();		
	String ConvertPMM = Integer.toString(PMM);
	PMonth=PMM;
	
	Integer PYYYY = (Integer)spinnerPYYYY.getValue();		
	String ConvertPYYYY = Integer.toString(PYYYY);
	PYear=PYYYY;

	
	PaidDate = ConvertPDD+"/"+ConvertPMM+"/"+ConvertPYYYY ;
	}
	
	
	public void insertIntoDB()
	{
		
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group8f", "root", "");
			Statement stm = con.createStatement();

			stm.execute(queryTransaction);
			flagDB=true;

			
			stm.close();
			con.close();
					
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Exception : " +ex.getMessage());
			System.out.println("Exception : " +ex.getMessage());
			flagDB=false;
        }
    }
	
	public void CheckInstructorId()
	{
		
		
		String queryInstructorId ="SELECT `UserId` FROM `instructoracc` WHERE UserId ="+ InstructorId+";";
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
            if(InstructorId==mID){
			flagCount=true;	
			}
			}
			
			System.out.println("Instructor count "+flagCount);

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
	
	
	public void Back()
	{    
	    if(flagDB)
		{
		JOptionPane.showMessageDialog(this,"Payment Success");
		UpdateAccount();
		System.out.println("buttonBack");
		AdminHome admin = new AdminHome(AdminId);
		try{
		this.setVisible(false);
		admin.setVisible(true);
		}catch(Exception ex){}
		
		}
		

	}
	
	public void CheckTransaction()
	{   
		String queryTransactionDate ="SELECT `AccountId`, `Status` ,`Month` , `Year` FROM `transaction` WHERE AccountId ="+ InstructorId+";"; 
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
				
				
				
				if(InstructorId==id && PMonth==m && PYear==y)
				{   System.out.println("SAME     id "+id +"Pmonth"+PMonth+" m "+m+"Pyear" +PYear+" yy"+y);
					JOptionPane.showMessageDialog(this,"   Already DOne");
                    flagTransactionDate=false;
					
		
		            AdminFinancialManage fin = new AdminFinancialManage(AdminId);
		            try{
		            this.setVisible(false);
	             	fin.setVisible(true);
	            	}catch(Exception ex){}
					
				}
			}

			}   
		catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
			flagTransactionDate=false;
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
	
	public void CheckTransactionNo()
	{   
	    String queryTransactionNo = "SELECT `TransactionNo` FROM transaction ORDER BY `TransactionNo` DESC LIMIT 1;"; 
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
			rs = st.executeQuery(queryTransactionNo);
			System.out.println("results received");	

			if(rs.next()){
            int t =  rs.getInt("TransactionNo");
			transactionNo=t+1;
             } 
			
			System.out.println("TransactionNo: "+ transactionNo);
			queryTransaction = "INSERT INTO transaction VALUES ("+transactionNo+","+InstructorId+",'"+Status+"',"+Fee+","+Salary+","+PMonth+","+PYear+",'"+PaidDate+"',"+AdminId+");"; 
		
			}
			catch(Exception ex)
			{
			
			System.out.println("Error:xxx "+ ex.getMessage());
			queryTransaction = "INSERT INTO transaction VALUES ("+transactionNo+","+InstructorId+",'"+Status+"',"+Fee+","+Salary+","+PMonth+","+PYear+",'"+PaidDate+"',"+AdminId+");"; 
			System.out.println("TransactionNo:xxx "+ transactionNo);
			}
	}
	
	public void UpdateAccount()
	{
	        Connection con =null;
            Statement st = null;
			String queryForUpdate = "UPDATE accounts SET Validity= 'Valid' where UserId="+InstructorId;
	
		try
		{
		    Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Group8F","root","");
			System.out.println("connection done");
			st = con.createStatement();
			System.out.println("statement created");			
			st.executeUpdate(queryForUpdate);
			JOptionPane.showMessageDialog(this, "Account Now Valid"); 
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this, e.getMessage()); 
		}
	}


}
