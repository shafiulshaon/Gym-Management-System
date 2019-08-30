import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class ChangePassAdmin extends JFrame implements ActionListener, MouseListener

{


	private JLabel LabelCurrentPass, LabelNewtPass,LabelBackGroundImage;
	private JPasswordField CurrentPassPF, NewtPassPF;
	private JButton buttonPassChange, buttonBack;
	private JPanel panel;
	private String OldPassword, NewPassword;
	private int AdminId;
	private boolean flagPass;

	public ChangePassAdmin(int AdminId)
	{
	super("Admin - Password Change Page");
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
	
	this.AdminId=AdminId;

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
		AdminHome home = new AdminHome(AdminId);
		try{
		this.setVisible(false);
		home.setVisible(true);
		}catch(Exception ex){}
		}
	}
	
	
	public void Check()
	{
		System.out.println("Changing Pass for AdminId: "+AdminId);
		String queryPassCheck = "SELECT `Password` FROM accounts WHERE UserId ="+ AdminId+";";   
     
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
			String queryForUpdate = "UPDATE accounts SET Password= '"+NewPassword+"' where UserId="+AdminId;
	
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
			JOptionPane.showMessageDialog(this,"Password Must Less Than 11 Character"); 
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public void Back()
	{    
	    flagPass=false;
		JOptionPane.showMessageDialog(this,"Password Changed Success"); 
		
		AdminHome home = new AdminHome(AdminId);
		try{
		this.setVisible(false);
		home.setVisible(true);
		}catch(Exception ex){}

	}
	
	
	
	
	
}
