import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class AdminHome extends JFrame implements ActionListener, MouseListener 
{
	private JLabel WelcomeLabel,LabelBackGroundImage;
	private JTextField userNameTF;
	private JButton buttonLogout, buttonDeleteAcc, buttonCreateAcc, buttonBill, buttonChangePass;
	private int AdminId;
	private JPanel panel;
	
	public AdminHome(int AdminId)
	{
		
	super("Admin - Welcome Page");
	
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
	
	this.AdminId =AdminId;
		
	buttonCreateAcc = new JButton("Create Account");
	buttonCreateAcc.setBounds(208,200,162,30);
	buttonCreateAcc.setFont(new Font("Ariel", Font.PLAIN, 16));	
	buttonCreateAcc.setForeground(Color.BLACK);
	buttonCreateAcc.setBackground(lightButton);
	buttonCreateAcc.addMouseListener(this);
	panel.add(buttonCreateAcc);
	
	buttonDeleteAcc = new JButton("Delete Account");
	buttonDeleteAcc.setBounds(208,240,164,30);
	buttonDeleteAcc.setFont(new Font("Ariel", Font.PLAIN, 16));	
	buttonDeleteAcc.setForeground(Color.BLACK);
	buttonDeleteAcc.setBackground(lightButton);
	buttonDeleteAcc.addMouseListener(this);
	panel.add(buttonDeleteAcc);
	
	buttonBill = new JButton("Bill Management");
	buttonBill.setBounds(208,280,164,30);
	buttonBill.setFont(new Font("Ariel", Font.PLAIN, 16));	
	buttonBill.setForeground(Color.BLACK);
	buttonBill.setBackground(lightButton);
	buttonBill.addMouseListener(this);
	panel.add(buttonBill);
	
	buttonChangePass = new JButton("Change Password");
	buttonChangePass.setBounds(208,320,164,30);
	buttonChangePass.setFont(new Font("Ariel", Font.PLAIN, 16));	
	buttonChangePass.setForeground(Color.BLACK);
	buttonChangePass.setBackground(lightButton);
	buttonChangePass.addMouseListener(this);
	panel.add(buttonChangePass);
	
	buttonLogout = new JButton("Logout");
	buttonLogout.setBounds(208,360,164,30);
	buttonLogout.setFont(new Font("Ariel", Font.PLAIN, 16));	
	buttonLogout.setForeground(Color.BLACK);
	buttonLogout.setBackground(lightButton);
	buttonLogout.addMouseListener(this);
	panel.add(buttonLogout);
	
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
		if(b==buttonCreateAcc)
		{
			System.out.println("buttonCreateAcc");
			CreateAccount CreateMemberAcc = new CreateAccount(AdminId);
			try{
			this.setVisible(false);
			CreateMemberAcc.setVisible(true);
			}catch(Exception ex){}
		
		}
		else if(b==buttonChangePass)
		{
			System.out.println("buttonChangePass");
			ChangePassAdmin ChangePass = new ChangePassAdmin(AdminId);
			try{
			this.setVisible(false);
			ChangePass.setVisible(true);
			}catch(Exception ex){}
		}
		else if(b==buttonBill)
		{
			System.out.println("buttonFinancial");
			AdminFinancialManage fin = new AdminFinancialManage(AdminId);
			try{
			this.setVisible(false);
			fin.setVisible(true);
			}catch(Exception ex){}
		}
		
		else if(b==buttonLogout)
		{
			System.out.println("Log out");
			LoginPage log = new LoginPage();
			try{
			this.setVisible(false);
			log.setVisible(true);
			}catch(Exception ex){}
		
		}
		else if(b==buttonDeleteAcc)
		{
			System.out.println("buttonDeleteAcc");
			DeleteAccount DeleteAcc = new DeleteAccount(AdminId);
			try{
			this.setVisible(false);
			DeleteAcc.setVisible(true);
			}catch(Exception ex){}
		}
	}
	
	
}