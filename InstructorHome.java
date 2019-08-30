
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.table.TableCellRenderer;
import java.util.*;
//import PWeightGain.*;

public class InstructorHome extends JFrame implements ActionListener, MouseListener
{
	
	
	private JTextField drawline1, drawline2, drawline3;
	private JButton ButtonHome, ButtonProfile, ButtonNotice,ButtonLogout, ButtonBill;
	private JLabel WelcomeLabel, LabelBackGroundImage;
	private JPanel panel;
	private int InstructorID; 
	
	public InstructorHome(int InstructorID)
	{

	super("Instructor - Home");
	this.InstructorID = InstructorID;	
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
		LabelBackGroundImage.setBounds(150,0, 600,180);
		ImageIcon imgThisImg = new ImageIcon("InstructorLogo.jpg");
		LabelBackGroundImage.setIcon(imgThisImg);
		panel.add(LabelBackGroundImage);
		
		drawline1 = new JTextField();
		drawline1.setBounds(15,142,552,1);
		drawline1.setBackground(Color.BLACK);
		panel.add(drawline1);	
		
		ButtonHome = new JButton("Home");
		ButtonHome.setBounds(208,200,162,30);
		ButtonHome.setFont(new Font("Ariel", Font.PLAIN, 16));	
		ButtonHome.setForeground(Color.BLACK);
		ButtonHome.setBackground(lightButton);
		ButtonHome.addMouseListener(this);
		panel.add(ButtonHome);
		
		ButtonProfile = new JButton("Profile");
		ButtonProfile.setBounds(208,240,164,30);
		ButtonProfile.setFont(new Font("Ariel", Font.PLAIN, 16));	
		ButtonProfile.setForeground(Color.BLACK);
		ButtonProfile.setBackground(lightButton);
		ButtonProfile.addMouseListener(this);
		panel.add(ButtonProfile);
		
		ButtonNotice = new JButton("Rules");
		ButtonNotice.setBounds(208,280,164,30);
		ButtonNotice.setFont(new Font("Ariel", Font.PLAIN, 16));	
		ButtonNotice.setForeground(Color.BLACK);
		ButtonNotice.setBackground(lightButton);
		ButtonNotice.addMouseListener(this);
		panel.add(ButtonNotice);
		
		ButtonBill = new JButton("Update Password");
		ButtonBill.setBounds(208,320,164,30);
		ButtonBill.setFont(new Font("Ariel", Font.PLAIN, 16));	
		ButtonBill.setForeground(Color.BLACK);
		ButtonBill.setBackground(lightButton);
		ButtonBill.addMouseListener(this);
		panel.add(ButtonBill);
		
		ButtonLogout = new JButton("Logout");
		ButtonLogout.setBounds(208,360,164,30);
		ButtonLogout.setFont(new Font("Ariel", Font.PLAIN, 16));	
		ButtonLogout.setForeground(Color.BLACK);
		ButtonLogout.setBackground(lightButton);
		ButtonLogout.addMouseListener(this);
		panel.add(ButtonLogout);
		
		WelcomeLabel = new JLabel(" Logged in as : Instructor");
	WelcomeLabel.setBounds(205, 520, 200, 20);
	WelcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	WelcomeLabel.setForeground(Color.BLACK);	
	panel.add(WelcomeLabel);
	
	WelcomeLabel = new JLabel(" ID : "+InstructorID);
	WelcomeLabel.setBounds(255, 550, 200, 20);
	WelcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	WelcomeLabel.setForeground(Color.BLACK);	
	panel.add(WelcomeLabel);
		
		this.add(panel);	
		
	}
	
	
	public void mouseClicked(MouseEvent me)
	{
		JButton b = (JButton) me.getComponent();
		
		
		if(b==ButtonProfile)
		{
		
			ProfileInstructor R = new ProfileInstructor(InstructorID);
			try{
			this.setVisible(false);
			R.setVisible(true);
			}catch(Exception ex){}
		}
		
		else if(b==ButtonNotice)
		{
			System.out.println("Rules");
			InstructorRules R = new InstructorRules(InstructorID);
			try{
			this.setVisible(false);
			R.setVisible(true);
			}catch(Exception ex){}
		}
		
		else if(b==ButtonBill)
		{
			System.out.println("buttonChangePass");
			ChangePassInstructor ChangePass = new ChangePassInstructor(InstructorID);
			try{
			this.setVisible(false);
			ChangePass.setVisible(true);
			}catch(Exception ex){}
		}
		
		else if(b==ButtonLogout)
		{
			System.out.println("Log out");
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
	
	
}