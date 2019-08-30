import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class LoginPage extends JFrame implements MouseListener{
	
	private JLabel LabelTitle,LabelBackGroundImage;
	private JButton buttonAdmin, buttonInstructor, buttonMember, buttonExit;
	private JPanel panel;	
	
	public LoginPage(){
	super("GYM Management System - Login Page");
		
	this.setSize(600, 650);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	Color lightButton = new Color(71, 92, 150);
	
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
	
	LabelTitle = new JLabel("    GYM MANAGEMENT SYSTEM");
	LabelTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
	LabelTitle.setForeground(Color.BLACK);
	LabelTitle.setBounds(150, 150, 400, 100);
	panel.add(LabelTitle);
	
	buttonAdmin = new JButton("ADMIN LOGIN");
	buttonAdmin.setBounds(190,250,200,50);
	buttonAdmin.setFont(new Font("Ariel", Font.PLAIN, 16));	
	buttonAdmin.setForeground(Color.BLACK);
	buttonAdmin.setBackground(lightButton);
	buttonAdmin.addMouseListener(this);
	panel.add(buttonAdmin);
	
	buttonInstructor = new JButton("INSTRUCTOR LOGIN");
	buttonInstructor.setBounds(190,310,200,50);
	buttonInstructor.setFont(new Font("Ariel", Font.PLAIN, 16));
	buttonInstructor.setForeground(Color.BLACK);
	buttonInstructor.setBackground(lightButton);
	buttonInstructor.addMouseListener(this);
	panel.add(buttonInstructor);
	
	buttonMember = new JButton("MEMBER LOGIN");
	buttonMember.setBounds(190,370,200,50);
	buttonMember.setFont(new Font("Ariel", Font.PLAIN, 16));
	buttonMember.setForeground(Color.BLACK);
	buttonMember.setBackground(lightButton);
	buttonMember.addMouseListener(this);
	panel.add(buttonMember);
	
	buttonExit = new JButton("Exit");
	buttonExit.setBounds(190,430,200,50);
	buttonExit.setFont(new Font("Ariel", Font.PLAIN, 15));
	buttonExit.setForeground(Color.BLACK);
	buttonExit.setBackground(lightButton);
	buttonExit.addMouseListener(this);
	panel.add(buttonExit);
			
	this.add(panel);
		
	}//end of constructor
	
	
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	
	
	public void mouseClicked(MouseEvent me)
	{
		JButton b = (JButton) me.getComponent();
		
		if(b==buttonAdmin)
		{
			System.out.println("buttonAdmin");
			AdminLogin home = new AdminLogin();
			try{
			this.setVisible(false);
			home.setVisible(true);
			}catch(Exception ex){}
		
		}
		
		else if(b==buttonMember)
		{
			System.out.println("buttonMember");
			MemberLogin home = new MemberLogin();
			try{
			this.setVisible(false);
			home.setVisible(true);
		    }catch(Exception ex){}
		}

		else if(b==buttonInstructor)
		{
			System.out.println("buttonInstructor");
			InstructorLogin home = new InstructorLogin();
			try{
			this.setVisible(false);
			home.setVisible(true);
		    }catch(Exception ex){}
		}
		
	    else if(b==buttonExit)
		{
			System.out.println("THANKS!! :)");
			System.exit(0);
		}
		
	}
	
	
}