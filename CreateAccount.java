import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class CreateAccount extends JFrame implements ActionListener, MouseListener {
	
	private JButton buttonMember, buttonAdmin, buttonInstructor, buttonBack;
	private JLabel LabelTitle,WelcomeLabel,LabelBackGroundImage;
	private int AdminId;
	private JPanel panel;
	
	/*public static void main(String args[])
	{
		CreateAccount obj = new CreateAccount(1001);
		obj.setVisible(true);
	}*/
	
	public CreateAccount( int userId)
	{
		
	super("Create Account");
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
	
	this.AdminId = userId;	
	
	LabelTitle = new JLabel("  Create Account");
	LabelTitle.setFont(new Font("Tahoma", Font.PLAIN, 19));
	LabelTitle.setForeground(Color.BLACK);
	LabelTitle.setBounds(212,190,250,30);
	panel.add(LabelTitle);
	
	buttonMember = new JButton("Member Account");
	buttonMember.setBounds(210,250,160,30);
	buttonMember.setFont(new Font("Ariel", Font.PLAIN, 16));	
	buttonMember.setForeground(Color.BLACK);
	buttonMember.setBackground(lightButton);
	buttonMember.addMouseListener(this);
	panel.add(buttonMember);
	
	buttonInstructor = new JButton("Instructor Account");
	buttonInstructor.setBounds(210,290,160,30);
	buttonInstructor.setFont(new Font("Ariel", Font.PLAIN, 16));	
	buttonInstructor.setForeground(Color.BLACK);
	buttonInstructor.setBackground(lightButton);
	buttonInstructor.addMouseListener(this);
	panel.add(buttonInstructor);
	
	buttonAdmin = new JButton("Admin Account");
	buttonAdmin.setBounds(210,330,160,30);
	buttonAdmin.setFont(new Font("Ariel", Font.PLAIN, 16));	
	buttonAdmin.setForeground(Color.BLACK);
	buttonAdmin.setBackground(lightButton);
	buttonAdmin.addMouseListener(this);
	panel.add(buttonAdmin);
	
	buttonBack = new JButton("Back");
	buttonBack.setBounds(210,370,160,30);
	buttonBack.setFont(new Font("Ariel", Font.PLAIN, 16));	
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
		
	}


	public void mouseClicked(MouseEvent me)
	{
		JButton b = (JButton) me.getComponent();
		
		if(b==buttonMember)
		{
			System.out.println("buttonMember");
			CreateMember Memberacc = new CreateMember(AdminId);
			try{
			this.setVisible(false);
			Memberacc.setVisible(true);
			}catch(Exception ex){}
		
		}
		
		else if(b==buttonInstructor)
		{
			System.out.println("buttonInstructor");
			CreateInstructor Instructoracc = new CreateInstructor(AdminId);
			try{
			this.setVisible(false);
			Instructoracc.setVisible(true);
		    }catch(Exception ex){}
		}
		
		else if(b==buttonAdmin)
		{
			System.out.println("buttonAdmin");
			CreateAdmin AdminAcc = new CreateAdmin(AdminId);
			try{
			this.setVisible(false);
			AdminAcc.setVisible(true);
		    }catch(Exception ex){}
		}
			    
		else if(b==buttonBack)
		{
		AdminHome ah = new AdminHome(AdminId);
     	try{
	    this.setVisible(false);
	    ah.setVisible(true); 
	    }catch(Exception ex){}
		}
		
	}
	

	public void actionPerformed(ActionEvent ae){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}	
	
}