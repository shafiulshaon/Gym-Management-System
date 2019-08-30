import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class AdminFinancialManage extends JFrame implements MouseListener
{
	
	private JLabel LabelTitle,LabelBackGroundImage,WelcomeLabel;
	private JButton buttonReciveBill, buttonPaySalary, buttonSeeDetail, buttonBack;
	private JPanel panel;
	private int AdminId;

	public AdminFinancialManage(int AdminId)
	
	{
	super("Admin Financial Manager");
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

	LabelTitle = new JLabel("Financial Management");
	LabelTitle.setFont(new Font("Tahoma", Font.PLAIN, 19));
	LabelTitle.setForeground(Color.BLACK);
	LabelTitle.setBounds(195,190,250,30);
	panel.add(LabelTitle);

	buttonReciveBill = new JButton("Recive Bill");
	buttonReciveBill.setBounds(210,250,160,30);
	buttonReciveBill.setFont(new Font("Ariel", Font.PLAIN, 16));	
	buttonReciveBill.setForeground(Color.BLACK);
	buttonReciveBill.setBackground(lightButton);
	buttonReciveBill.addMouseListener(this);
	panel.add(buttonReciveBill);
	
	
	buttonPaySalary = new JButton("Pay Salary");
	buttonPaySalary.setBounds(210,290,160,30);
	buttonPaySalary.setFont(new Font("Ariel", Font.PLAIN, 16));	
	buttonPaySalary.setForeground(Color.BLACK);
	buttonPaySalary.setBackground(lightButton);
	buttonPaySalary.addMouseListener(this);
	panel.add(buttonPaySalary);
	
	
	buttonSeeDetail = new JButton("Check Payment");
	buttonSeeDetail.setBounds(210,330,160,30);
	buttonSeeDetail.setFont(new Font("Ariel", Font.PLAIN, 16));	
	buttonSeeDetail.setForeground(Color.BLACK);
	buttonSeeDetail.setBackground(lightButton);
	buttonSeeDetail.addMouseListener(this);
	panel.add(buttonSeeDetail);
	
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
			System.out.println("buttonReciveBill");
			ReceiveBill recBill = new ReceiveBill(AdminId);
			try{
			this.setVisible(false);
			recBill.setVisible(true);
		    }catch(Exception ex){}
		}

		else if(b==buttonPaySalary)
		{
			System.out.println("buttonPaySalary");
			PaySalary instructor = new PaySalary(AdminId);
			try{
			this.setVisible(false);
			instructor.setVisible(true);
		    }catch(Exception ex){}
		}
		
		else if(b==buttonSeeDetail)
		{
			System.out.println("buttonSeeDetail");
			SeeDetails see = new SeeDetails(AdminId);
			try{
			this.setVisible(false);
			see.setVisible(true);
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
