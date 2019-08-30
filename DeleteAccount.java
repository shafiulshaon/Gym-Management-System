import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class DeleteAccount extends JFrame implements MouseListener
{
	/*public static void main(String args[])
	{
		DeleteAccount obj = new DeleteAccount(1001);
		obj.setVisible(true);
	}*/
	
	private JLabel LabelTitle,WelcomeLabel,LabelBackGroundImage;
	private JButton buttonInstructor, buttonMember, buttonBack;
	private JPanel panel;
	private int AdminId;

	public DeleteAccount(int userId)
	{
	super("Delete Account - Page");
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
	
	this.AdminId = userId;	
	
	LabelTitle = new JLabel(" Delete Account");
	LabelTitle.setFont(new Font("Tahoma", Font.PLAIN, 19));
	LabelTitle.setForeground(Color.BLACK);
	LabelTitle.setBounds(220,200,250,30);
	panel.add(LabelTitle);

	buttonMember = new JButton("Member Account");
	buttonMember.setBounds(210,260,160,30);
	buttonMember.setFont(new Font("Ariel", Font.PLAIN, 16));	
	buttonMember.setForeground(Color.BLACK);
	buttonMember.setBackground(lightButton);
	buttonMember.addMouseListener(this);
	panel.add(buttonMember);
	
	
	buttonInstructor = new JButton("Instructor Account");
	buttonInstructor.setBounds(210,300,160,30);
	buttonInstructor.setFont(new Font("Ariel", Font.PLAIN, 16));	
	buttonInstructor.setForeground(Color.BLACK);
	buttonInstructor.setBackground(lightButton);
	buttonInstructor.addMouseListener(this);
	panel.add(buttonInstructor);
	

	buttonBack = new JButton("Back");
	buttonBack.setBounds(210,340,160,30);
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

	}//end of constructor


	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}

	public void mouseClicked(MouseEvent me)
	{
		JButton b = (JButton) me.getComponent();

		if(b==buttonMember)
		{
			System.out.println("buttonMember");
			DeleteMemberAccount member = new DeleteMemberAccount(AdminId);
			try{
			this.setVisible(false);
			member.setVisible(true);
		    }catch(Exception ex){}
		}

		else if(b==buttonInstructor)
		{
			System.out.println("buttonInstructor");
			DeleteInstructorAccount instructor = new DeleteInstructorAccount(AdminId);
			try{
			this.setVisible(false);
			instructor.setVisible(true);
		    }catch(Exception ex){}
		}

	    else if(b==buttonBack)
		{
			System.out.println("buttonBack");
			AdminHome admin = new AdminHome(AdminId);
			try{
			this.setVisible(false);
			admin.setVisible(true);
		    }catch(Exception ex){}
		}

	}


}
