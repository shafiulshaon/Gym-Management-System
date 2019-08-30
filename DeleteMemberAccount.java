import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class DeleteMemberAccount extends JFrame implements ActionListener, MouseListener
{	
	private JLabel LabelMemberID,WelcomeLabel,LabelBackGroundImage;
	private JTextField MemberIDTF;
	private JButton buttonDelete,buttonBack;
	private JPanel panel;
	private int MemberId;
	private boolean flagDB, flagCount, flagInvalid;
	private int AdminId;

	public DeleteMemberAccount(int AdminId)
	{
	super("Delect Instructor Account Page");
	this.AdminId = AdminId;	
	
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

	LabelMemberID = new JLabel("Enter Member Id  :");
	LabelMemberID.setBounds(150, 210, 150, 25);
	LabelMemberID.setFont(new Font("Tahoma", Font.PLAIN, 15));
	LabelMemberID.setForeground(Color.BLACK);
	panel.add(LabelMemberID);

	MemberIDTF = new JTextField();
	MemberIDTF.setBounds(300, 210, 120, 25);
	panel.add(MemberIDTF);

	buttonDelete = new JButton("Delete");
	buttonDelete.setBounds(150,300,120,30);
	buttonDelete.setFont(new Font("Ariel", Font.PLAIN, 15));	
	buttonDelete.setForeground(Color.BLACK);
	buttonDelete.setBackground(lightButton);
    buttonDelete.addActionListener(this);
	buttonDelete.addMouseListener(this);
	panel.add(buttonDelete);

	buttonBack = new JButton("Back");
	buttonBack.setBounds(300,300,120,30);
	buttonBack.setFont(new Font("Ariel", Font.PLAIN, 15));	
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

}

    public void actionPerformed(ActionEvent ae){}
    public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}

	public void mouseClicked(MouseEvent me)
	{
		JButton b = (JButton) me.getComponent();

		if(b==buttonDelete)
		{
			System.out.println("buttonDelete");
		    if(MemberIDTF.getText().isEmpty())
	        {
 	        JOptionPane.showMessageDialog(this, "Please Enter ID");
	        }
			else
			{
				try{
			MemberId = Integer.parseInt(MemberIDTF.getText());
			flagInvalid=true;
			
			}catch(Exception e)
			{    flagInvalid=false;
				JOptionPane.showMessageDialog(this, "Invalid ID");	
			}
			
			CheckMemberId();
			
			if(flagCount && flagInvalid){
			DelectAcc();
			}
			else 
			{
			JOptionPane.showMessageDialog(this, "ID Not Found");		
			}
			
			
			if(flagDB)
			{
			Back();
			}
			}
		}

	    else if(b==buttonBack)
		{
		DeleteAccount delete = new DeleteAccount(AdminId);
     	try{
	    this.setVisible(false);
	    delete.setVisible(true);
	    }catch(Exception ex){}
		}

	}
	
	
	
	public void DelectAcc()
	{
	        Connection con =null;
            Statement st = null;
			String DeleteFromAccounts = "DELETE FROM accounts WHERE UserId="+MemberId+";";
			String DeleteFromInstructor = "DELETE FROM instructoracc WHERE UserId="+MemberId+";";
	
		try
		{
		    Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Group8F","root","");
			System.out.println("connection done");
			st = con.createStatement();
			System.out.println("statement created");			
			st.executeUpdate(DeleteFromAccounts);
			st.executeUpdate(DeleteFromInstructor);
			st.close();
			con.close();
			flagDB=true;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"No Account Found");
			System.out.println(e.getMessage());
		}
	}
	
		public void Back()
	{
		JOptionPane.showMessageDialog(this,"Account Deletion Success");
		if(flagDB)
		{
		DeleteAccount delete = new DeleteAccount(AdminId);
     	try{
	    this.setVisible(false);
	    delete.setVisible(true);
	    }catch(Exception ex){}	
		}
	}
	
	public void CheckMemberId()
	{
		
		
		String queryMemberId ="SELECT `UserId` FROM `memberacc` WHERE UserId ="+ MemberId+";";
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
            if(MemberId==mID){
			flagCount=true;	
			}
			}
			
			System.out.println("Member count"+flagCount);

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
