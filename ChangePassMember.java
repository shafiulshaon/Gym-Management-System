import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class ChangePassMember extends JFrame implements ActionListener, MouseListener{
	
	/*public static void main(String args[])
	{
		ChangePassMember obj =new ChangePassMember(1001);
		obj.setVisible(true);
	}*/

	private JLabel LabelCurrentPass, LabelNewtPass,LabelBackGroundImage;
	private JPasswordField CurrentPassPF, NewtPassPF;
	private JButton buttonPassChange, buttonBack;
	private JPanel panel;
	private String OldPassword, NewPassword;
	private int MemberId;
	private boolean flagPass, flagWG, flagBB,flagFL;

	public ChangePassMember(int MemberId)
	{
	super("MEMBER - Password Change Page");
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
	LabelBackGroundImage.setBounds(0,0, 600,200);
    ImageIcon imgThisImg = new ImageIcon("logInBackground.JPG");
	LabelBackGroundImage.setIcon(imgThisImg);
	panel.add(LabelBackGroundImage);
	
	this.MemberId=MemberId;

	LabelCurrentPass = new JLabel("Enter Current Password    :");
	LabelCurrentPass.setBounds(110, 200, 180, 25);
	LabelCurrentPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
	LabelCurrentPass.setForeground(Color.BLACK);
	panel.add(LabelCurrentPass);

	LabelNewtPass = new JLabel("Enter New Password        :");
	LabelNewtPass.setBounds(110, 240, 180, 25);
	LabelNewtPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
	LabelNewtPass.setForeground(Color.BLACK);
	panel.add(LabelNewtPass);
	
	CurrentPassPF = new JPasswordField();
	CurrentPassPF.setBounds(320, 200, 135, 25);
	panel.add(CurrentPassPF);

	NewtPassPF = new JPasswordField();
	NewtPassPF.setBounds(320, 240, 135, 25);
	panel.add(NewtPassPF);
	
	buttonPassChange = new JButton("Change");
	buttonPassChange.setBounds(150,300,120,30);
	buttonPassChange.setFont(new Font("Ariel", Font.PLAIN, 15));	
	buttonPassChange.setForeground(Color.BLACK);
	buttonPassChange.setBackground(lightButton);
    buttonPassChange.addActionListener(this);
	buttonPassChange.addMouseListener(this);
	panel.add(buttonPassChange);
	
	
	buttonBack = new JButton("Back");
	buttonBack.setBounds(295,300,120,30);
	buttonBack.setFont(new Font("Ariel", Font.PLAIN, 15));	
	buttonBack.setForeground(Color.BLACK);
	buttonBack.setBackground(lightButton);
    buttonBack.addActionListener(this);
	buttonBack.addMouseListener(this);
	panel.add(buttonBack);

	this.add(panel);

}

    public void actionPerformed(ActionEvent ae){}
    public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}

	public void mouseClicked(MouseEvent me)
	{
	JButton b = (JButton) me.getComponent();

		if(b==buttonPassChange)
		{		
		OldPassword=CurrentPassPF.getText();
		System.out.println(OldPassword);
		NewPassword=NewtPassPF.getText();		
		Check();

		if(flagPass)
		{
			UpdatePass();
		}
		else
		{
		JOptionPane.showMessageDialog(this,"Current Password Wrong!!"+"\n"+"       Try Again"); 
		}
		
		}

	    else if(b==buttonBack)
		{
		CheckCourse();	
				if(flagWG)
		{
			MemberHomeWG wg = new MemberHomeWG(MemberId);
			try{
			this.setVisible(false);
			wg.setVisible(true); 	
			}catch(Exception ex){}
		}
		else if(flagBB)
		{
			MemberHomeBB bb = new MemberHomeBB(MemberId);
			try{
			this.setVisible(false);
			bb.setVisible(true); 	
			}catch(Exception ex){}
		}
		else if(flagFL)
		{
			MemberHomeFL fl = new MemberHomeFL(MemberId);
			try{
			this.setVisible(false);
			fl.setVisible(true); 	
			}catch(Exception ex){}
		}
		}
		
		
		
		
	}
	
	
	
	
	public void Check()
	{
		System.out.println("Changing Pass for MemberID: "+MemberId);
		String queryPassCheck = "SELECT `Password` FROM accounts WHERE UserId ="+ MemberId+";";   
     
        Connection con=null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(queryPassCheck);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Group8F","root","");
			System.out.println("connection done");
			st = con.createStatement();
			System.out.println("statement created");
			rs = st.executeQuery(queryPassCheck);
			System.out.println("results received");
					
			while(rs.next())
			{
                String CurrentPass = rs.getString("Password");;
				
				System.out.println("Old pass: "+CurrentPass +"  type Old pass: "+OldPassword);
				if(OldPassword.equals(CurrentPass))
				{
				flagPass=true;
				System.out.println("Pass Match");
				}
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		     
		}
	}
	
	
	
	public void UpdatePass()
	{
	        Connection con =null;
            Statement st = null;
			String queryForUpdate = "UPDATE accounts SET Password= '"+NewPassword+"' where UserId="+MemberId;
	
		try
		{
		    Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Group8F","root","");
			System.out.println("connection done");
			st = con.createStatement();
			System.out.println("statement created");			
			st.executeUpdate(queryForUpdate);
			st.close();
			con.close();
			Back();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this,"Password Must Less Than 11 Character"); 
		}
	}
	
	public void CheckCourse()
	{
		System.out.println("Checking Course for Member: "+MemberId);
		String queryPassCheck = "SELECT `Course` FROM memberacc WHERE UserId ="+ MemberId+";";   
     
        Connection con=null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(queryPassCheck);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Group8F","root","");
			System.out.println("connection done");
			st = con.createStatement();
			System.out.println("statement created");
			rs = st.executeQuery(queryPassCheck);
			System.out.println("results received");
					
			while(rs.next())
			{
                String CourseName = rs.getString("Course");;
				
				if (CourseName.equals("Fat Lose "))
				{
                flagFL=true;
				}
				else if (CourseName.equals("Weight Gain "))
				{
                 flagWG=true;
				}
				else if (CourseName.equals("Build Body "))
				{
                  flagBB=true;
				}
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
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
	{   flagPass=false;
		JOptionPane.showMessageDialog(this,"Password Changed Success"); 
		
		CheckCourse();
				if(flagWG)
		{
			MemberHomeWG wg = new MemberHomeWG(MemberId);
			try{
			this.setVisible(false);
			wg.setVisible(true); 	
			}catch(Exception ex){}
		}
		else if(flagBB)
		{
			MemberHomeBB bb = new MemberHomeBB(MemberId);
			try{
			this.setVisible(false);
			bb.setVisible(true); 	
			}catch(Exception ex){}
		}
		else if(flagFL)
		{
			MemberHomeFL fl = new MemberHomeFL(MemberId);
			try{
			this.setVisible(false);
			fl.setVisible(true); 	
			}catch(Exception ex){}
		}
		}

	}
	
	
	

