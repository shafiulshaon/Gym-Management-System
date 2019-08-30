
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
//import PBodyBuild.*;

public class MemberHomeBB extends JFrame implements ActionListener, MouseListener, Runnable
{
	
		/*public static void main(String args[])
	{
		MemberHomeBB obj = new MemberHomeBB(1001);
		obj.setVisible(true);
		obj.run();
	}
	*/
	private JLabel LabelTitle, WorkoutTitle, MealTitle, Warning;
	private JTextField drawline1, drawline2, drawline3;
	private JButton ButtonHome, ButtonProfile, ButtonNotice,ButtonLogout, ButtonBill;
	private JButton ButtonWeek1, ButtonWeek2, ButtonWeek3, ButtonWeek4;
	private JPanel panel;
	private JTable jt;
	private Thread t;
	private int MemberId;
	
	public MemberHomeBB(int MemberId)
	{

	super("Body Building Workout");
		this.MemberId = MemberId;	
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
		
		WorkoutTitle = new JLabel("Monthly Workout Routine (Build Body)");
		WorkoutTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		WorkoutTitle.setForeground(Color.BLACK);
		WorkoutTitle.setBounds(135, 112, 400, 30);
		panel.add(WorkoutTitle);
		
		ButtonWeek1 = new JButton("WEEK 1");
		ButtonWeek1.setBounds(70,160,180,30);
		ButtonWeek1.setFont(new Font("Ariel", Font.PLAIN, 16));	
		ButtonWeek1.setForeground(Color.BLACK);
		ButtonWeek1.setBackground(lightButton);
		ButtonWeek1.addMouseListener(this);
		panel.add(ButtonWeek1);
		
		ButtonWeek2 = new JButton("WEEK 2");
		ButtonWeek2.setBounds(330,160,180,30);
		ButtonWeek2.setFont(new Font("Ariel", Font.PLAIN, 16));	
		ButtonWeek2.setForeground(Color.BLACK);
		ButtonWeek2.setBackground(lightButton);
		ButtonWeek2.addMouseListener(this);
		panel.add(ButtonWeek2);
		
		ButtonWeek3 = new JButton("WEEK 3");
		ButtonWeek3.setBounds(70,205,180,30);
		ButtonWeek3.setFont(new Font("Ariel", Font.PLAIN, 16));	
		ButtonWeek3.setForeground(Color.BLACK);
		ButtonWeek3.setBackground(lightButton);
		ButtonWeek3.addMouseListener(this);
		panel.add(ButtonWeek3);
		
		ButtonWeek4 = new JButton("WEEK 4");
		ButtonWeek4.setBounds(330,205,180,30);
		ButtonWeek4.setFont(new Font("Ariel", Font.PLAIN, 16));	
		ButtonWeek4.setForeground(Color.BLACK);
		ButtonWeek4.setBackground(lightButton);
		ButtonWeek4.addMouseListener(this);
		panel.add(ButtonWeek4);
		
		drawline2 = new JTextField();
		drawline2.setBounds(15,271,552,1);
		drawline2.setBackground(Color.BLACK);
		panel.add(drawline2);		
		
		MealTitle = new JLabel("Daily Meal");
		MealTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MealTitle.setForeground(Color.BLACK);
		MealTitle.setBounds(240, 276, 400, 30);
		panel.add(MealTitle);
		
		String[] columns = {"Breakfast","Lunch","Evening","Dinner"};
		String[][] data = {
						   {"7 am-", "1.30 pm-", "5 pm-","8.30 pm-"},
                           {"     Hot water", "     Brown rice 1 cup", "     Fruit","     Mixed Vegetables"},
					       {"     Lemon", "     Vegetables", "     Nut","     Beaf/Chicken"},
                           {"     Cinnamon", "     Sea Fish / Chicken", "","     Egg 2 pcs(without yolk)"},
						   {"", "     Dal", "","     Dal"},
						   {"7.30 am-", "     Salad", "","     Fruits"},
						   {"     Brown Bread", "     Lemon", "","     Curd 1 cup"},
						   {"     Vegetable", "", "",""},
						   {"     Egg 2(without yolk)", "", "",""},
						   {"     ginger tea", "", "",""},
						   {"     Lemon", "", "",""},
						   {"", "", "",""},
						   {"10.30 am-", "", "",""},
						   {"     Sup/cofee", "", "",""},
						   {"     Sundaes/Fruits", "", "",""}};
					   
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
		jps.setBounds(15, 324, 553, 200);
		panel.add(jps);
		
		Warning = new JLabel("NB : Must be avoided extra sugar, salt and oil. Try to take more water.");
		Warning.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Warning.setForeground(Color.BLACK);
		Warning.setBounds(15, 535, 500, 20);
		panel.add(Warning);
		
		/*drawline3 = new JTextField();
		drawline3.setBounds(15,107,552,1);
		drawline3.setBackground(Color.BLACK);
		panel.add(drawline3);	*/	
		
		this.add(panel);	
		
	}
	
	public void run()
	{
	 
	try 
	{     
		do
		{
			ButtonWeek1.setVisible(false);
			ButtonWeek2.setVisible(false);
			ButtonWeek3.setVisible(false);
			ButtonWeek4.setVisible(false);
			Thread.sleep(1000);
			ButtonWeek1.setVisible(true);
			Thread.sleep(1000);
			ButtonWeek2.setVisible(true);
			Thread.sleep(1000);
			ButtonWeek3.setVisible(true);
			Thread.sleep(1000);
			ButtonWeek4.setVisible(true);
			Thread.sleep(2000);
		}while(true);			   
	}
	catch (Exception e) 
	  {
         System.out.println(e.getMessage());
      }
 
	}
	public void mouseClicked(MouseEvent me)
	{
		JButton b = (JButton) me.getComponent();
		if(b==ButtonWeek1)
		{
			BodyBuildWeek1 BBWeek1 = new BodyBuildWeek1(MemberId);
			try{
			this.setVisible(false);
			BBWeek1.setVisible(true);
			BBWeek1.start(); 	
			}catch(Exception ex){}			
		}
		
		else if(b==ButtonWeek2)
		{
			BodyBuildWeek2 BBWeek2 = new BodyBuildWeek2(MemberId);
			try{
			this.setVisible(false);
			BBWeek2.setVisible(true);
			BBWeek2.start(); 	
			}catch(Exception ex){}		
		}
		
		else if(b==ButtonWeek3)
		{
			BodyBuildWeek3 BBWeek3 = new BodyBuildWeek3(MemberId);
			try{
			this.setVisible(false);
			BBWeek3.setVisible(true);
			BBWeek3.start(); 	
			}catch(Exception ex){}		
		}
		
		else if(b==ButtonWeek4)
		{
			BodyBuildWeek4 BBWeek4 = new BodyBuildWeek4(1001);
			try{
			this.setVisible(false);
			BBWeek4.setVisible(true);
			BBWeek4.start(); 	
			}catch(Exception ex){}		
		}
		else if(b==ButtonHome)
		{
			System.out.println("ButtonHome");
			MemberHomeWG MHWG = new MemberHomeWG(MemberId);
			try{
			this.setVisible(false);
			MHWG.setVisible(true);
			}catch(Exception ex){}
		}
		
		else if(b==ButtonProfile)
		{
			System.out.println("ButtonProfile");
			ProfileMember PM = new ProfileMember(MemberId);
			try{
			this.setVisible(false);
			PM.setVisible(true);
			}catch(Exception ex){}
		}
		
		else if(b==ButtonNotice)
		{
			System.out.println("Rules");
			MemberRules R = new MemberRules(MemberId);
			try{
			this.setVisible(false);
			R.setVisible(true);
			}catch(Exception ex){}
		}
	
		else if(b==ButtonBill)
		{
			System.out.println("Change Password");
			ChangePassMember CPM = new ChangePassMember(MemberId);
			try{
			this.setVisible(false);
			CPM.setVisible(true);
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
	
	public void start () 
   {
      System.out.println("Starting "  );
      if (t == null)
	  {
         t = new Thread (this);
         t.start();
      }
   }
	public void actionPerformed(ActionEvent ae){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}		
}