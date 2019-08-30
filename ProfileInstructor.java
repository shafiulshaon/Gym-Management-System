import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import javax.swing.table.TableCellRenderer;
import java.util.*;
//import PWeightGain.*;

public class ProfileInstructor extends JFrame implements ActionListener, MouseListener
{
	
	private JLabel LabelTitle, WorkoutTitle, MealTitle, Warning;
	private JLabel LabelMemberName, LabelMemberId, LabelMemberDOB, LabelMemberJoindate, LabelPhoto;
	private JTextField drawline1, drawline2, drawline3;
	private JButton ButtonHome, ButtonProfile, ButtonNotice,ButtonLogout, ButtonBill;
	private JPanel panel;
	private JTable jt;
	private String TransactionDate, TransactionNo, ReceivedBy, MemberBill , Photo;
	private boolean flagWG, flagBB,flagFL;
		
	
	private String Mname;
	private int InstructorId;
	private String DOB;
	private String JoinD, Gender;
	
	public ProfileInstructor(int InstructorId)
	{
	super("Instructor Profile");
	this.InstructorId = InstructorId;
	this.getMemberPayment();
	this.getMemberData();

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
		
		LabelTitle = new JLabel();
		LabelTitle.setBounds(0,0, 600,70);
        ImageIcon imgThisImg = new ImageIcon("title.jpg");
		LabelTitle.setIcon(imgThisImg);
		panel.add(LabelTitle);
		
		ButtonHome = new JButton("Home");
		ButtonHome.setBounds(15,71,108,30);
		ButtonHome.setFont(new Font("Ariel", Font.PLAIN, 16));	
		ButtonHome.setForeground(Color.BLACK);
		ButtonHome.setBackground(lightButton);
		ButtonHome.addMouseListener(this);
		panel.add(ButtonHome);
		
		ButtonProfile = new JButton("Profile");
		ButtonProfile.setBounds(126,71,108,30);
		ButtonProfile.setFont(new Font("Ariel", Font.PLAIN, 16));	
		ButtonProfile.setForeground(Color.BLACK);
		ButtonProfile.setBackground(lightButton);
		ButtonProfile.addMouseListener(this);
		panel.add(ButtonProfile);
		
		ButtonNotice = new JButton("Rules");
		ButtonNotice.setBounds(237,71,108,30);
		ButtonNotice.setFont(new Font("Ariel", Font.PLAIN, 16));	
		ButtonNotice.setForeground(Color.BLACK);
		ButtonNotice.setBackground(lightButton);
		ButtonNotice.addMouseListener(this);
		panel.add(ButtonNotice);
		
		ButtonBill = new JButton("Update");
		ButtonBill.setBounds(348,71,108,30);
		ButtonBill.setFont(new Font("Ariel", Font.PLAIN, 16));	
		ButtonBill.setForeground(Color.BLACK);
		ButtonBill.setBackground(lightButton);
		ButtonBill.addMouseListener(this);
		panel.add(ButtonBill);
		
		ButtonLogout = new JButton("Logout");
		ButtonLogout.setBounds(459,71,108,30);
		ButtonLogout.setFont(new Font("Ariel", Font.PLAIN, 16));	
		ButtonLogout.setForeground(Color.BLACK);
		ButtonLogout.setBackground(lightButton);
		ButtonLogout.addMouseListener(this);
		panel.add(ButtonLogout);
		
		drawline1 = new JTextField();
		drawline1.setBounds(15,107,552,1);
		drawline1.setBackground(Color.BLACK);
		panel.add(drawline1);		
		
		WorkoutTitle = new JLabel("Instructor Profile");
		WorkoutTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		WorkoutTitle.setForeground(Color.BLACK);
		WorkoutTitle.setBounds(220, 120, 400, 30);
		panel.add(WorkoutTitle);
		
		LabelPhoto = new JLabel();
		LabelPhoto.setBounds(415, 175, 120, 120);
        ImageIcon imginThisImg = new ImageIcon(Photo);
		LabelPhoto.setBorder(BorderFactory.createLineBorder(Color.black));
		LabelPhoto.setIcon(imginThisImg);
		panel.add(LabelPhoto);
		
		LabelMemberName = new JLabel("Name           : "+Mname);
		LabelMemberName.setBounds(15, 175, 320, 25);
		LabelMemberName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelMemberName.setForeground(Color.BLACK);
		panel.add(LabelMemberName);
		
		LabelMemberId = new JLabel("ID                : "+InstructorId);
		LabelMemberId.setBounds(15, 220, 320, 25);
		LabelMemberId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelMemberId.setForeground(Color.BLACK);
		panel.add(LabelMemberId);
		
		LabelMemberDOB = new JLabel("Date of Birth : "+DOB);
		LabelMemberDOB.setBounds(15, 265, 320, 25);
		LabelMemberDOB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelMemberDOB.setForeground(Color.BLACK);
		panel.add(LabelMemberDOB);
		
		LabelMemberJoindate = new JLabel("Join Date      : "+JoinD);
		LabelMemberJoindate.setBounds(15, 310, 320, 25);
		LabelMemberJoindate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LabelMemberJoindate.setForeground(Color.BLACK);
		panel.add(LabelMemberJoindate);
		
		drawline2 = new JTextField();
		drawline2.setBounds(15,400,552,1);
		drawline2.setBackground(Color.BLACK);
		panel.add(drawline2);
		
		MealTitle = new JLabel("Transaction");
		MealTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MealTitle.setForeground(Color.BLACK);
		MealTitle.setBounds(240, 415, 400, 30);
		panel.add(MealTitle);
		
		
		String[] columns = {"Transaction No","Salary( Tk.)","Date","Received By"};
		String[][] data = {{"",   "",   "",    ""},
						   {TransactionNo,   MemberBill,   TransactionDate,    ReceivedBy},
						   {"",   "",   "",    ""}};
					   
		jt = new JTable(data, columns)
		{
			public boolean isCellEditable(int data, int columns)
			{
			return false;
			}       
			public Component prepareRenderer(TableCellRenderer r, int data, int columns)
			{
				Component c = super.prepareRenderer(r, data, columns);            
				if (data % 2 == 0)
				c.setBackground(lightBlue);  
				else
				c.setBackground(Color.WHITE);   
				return c;
			}
		};
		JScrollPane jps = new JScrollPane(jt);
		jps.setBounds(15, 455, 553, 72);
		panel.add(jps);
		
		Warning = new JLabel(" NB : Showing Transection for the last month.");
		Warning.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Warning.setForeground(Color.BLACK);
		Warning.setBounds(15, 535, 500, 20);
		panel.add(Warning);
		
		/*drawline3 = new JTextField();
		drawline3.setBounds(15,545,552,1);
		drawline3.setBackground(Color.BLACK);
		panel.add(drawline3)	*/
		
		this.add(panel);	
		
	}
	
	
	public void mouseClicked(MouseEvent me)
	{
		
		
		JButton b = (JButton) me.getComponent();
		if(b==ButtonHome)
		{
			InstructorHome pro = new InstructorHome(InstructorId);
			try{
			this.setVisible(false);
			pro.setVisible(true); 	
			}catch(Exception ex){}

			
		}
		
		else if(b==ButtonBill)
		{
			ChangePassInstructor cp = new ChangePassInstructor(InstructorId);
			try{
			this.setVisible(false);
			cp.setVisible(true); 	
			}catch(Exception ex){}
		}
		
			else if(b==ButtonNotice)
		{
			InstructorRules ir = new InstructorRules(InstructorId);
			try{
			this.setVisible(false);
			ir.setVisible(true); 	
			}catch(Exception ex){}
			
		}
		
		else if(b==ButtonLogout)
		{
			LoginPage log = new LoginPage();
			try{
			this.setVisible(false);
			log.setVisible(true); 	
			}catch(Exception ex){}
			
		}

		
	}
	
	public void actionPerformed(ActionEvent ae)	{}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	
	
	
	public void getMemberPayment()
	{
        String query = "SELECT `TransactionNo`, `ReceiveBill`, `TransactionDate`, `AdminId` FROM `transaction`  WHERE AccountId ="+ InstructorId +" ORDER BY TransactionNo DESC LIMIT 1;";      
        Connection con=null; 
        Statement st = null; 
		ResultSet rs = null; 
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Group8F","root","");
			System.out.println("connection done"); 
			st = con.createStatement(); 
			System.out.println("statement created");
			rs = st.executeQuery(query); 
			System.out.println("results received");
					
			while(rs.next())
			{
                int tId = rs.getInt("TransactionNo");
				double bill = rs.getDouble("ReceiveBill");
				String date = rs.getString("TransactionDate");
				int adminid = rs.getInt("AdminId");
				
				TransactionNo=Integer.toString(tId);
				MemberBill=Double.toString(bill);
				ReceivedBy=Integer.toString(tId);
				TransactionDate=date;
				
				
				System.out.println("User: " +tId);
				System.out.println("Bill : " +bill);
				System.out.println("date: " +date);
				System.out.println("adminid: " +adminid);
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
	
	
	public void getMemberData()
	{
        String query = "SELECT `Name`, `Gender` , `DOB`, `Photo`,`JoinDate` FROM `instructoracc` WHERE UserId ="+ InstructorId +";";        
        Connection con=null; 
        Statement st = null; 
		ResultSet rs = null; 
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Group8F","root","");
			System.out.println("connection done"); 
			st = con.createStatement(); 
			System.out.println("statement created");
			rs = st.executeQuery(query); 
			System.out.println("results received");
					
			while(rs.next())
			{
     
				String name = rs.getString("Name");
				String g = rs.getString("Gender");
				String d = rs.getString("DOB");
				String a = rs.getString("JoinDate");
				String p = rs.getString("Photo");
				
				Mname=name;
				Gender=g;
				DOB=d;
			    JoinD=a;
				Photo=p;
	
				
				System.out.println("User: " +name);
				System.out.println("Salary : " +g);
				System.out.println("Date: " +d);
				System.out.println("Adminid: " +a);
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
	
	
	
}