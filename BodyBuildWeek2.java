//package PBodyBuild;

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


public class BodyBuildWeek2 extends JFrame implements ActionListener, MouseListener, Runnable
{
	
	private JLabel LabelTitle, WorkoutTitle, DayTitle, OFFDay, RulesLabel1,RulesLabel2,RulesLabel3;
	private JTextField drawline1, drawline2, drawline3;
	private JButton ButtonHome, ButtonProfile, ButtonNotice,ButtonLogout, ButtonBill;
	private JButton ButtonWeek1, ButtonWeek2, ButtonWeek3, ButtonWeek4;
	private JButton ButtonDay1, ButtonDay2, ButtonDay3, ButtonDay4,ButtonDay5,ButtonDay6,ButtonDay7;
	private JPanel panel;
	private JTable jt;
	private JLabel Quote1,Quote2,Quote3,Quote4,Quote5;
	private Thread t;
	private JScrollPane jps;
	private int MemberId;
	
	public BodyBuildWeek2(int MemberId)
	{
		
	super("Weight Gain Workout");
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
		
		ButtonDay1 = new JButton("Day 1");
		ButtonDay1.setBounds(15,113,77,20);
		ButtonDay1.setFont(new Font("Ariel", Font.PLAIN, 13));	
		ButtonDay1.setForeground(Color.BLACK);
		ButtonDay1.setBackground(lightBlue);
		ButtonDay1.addMouseListener(this);
		panel.add(ButtonDay1);
		
		ButtonDay2 = new JButton("Day 2");
		ButtonDay2.setBounds(94,113,77,20);
		ButtonDay2.setFont(new Font("Ariel", Font.PLAIN, 13));	
		ButtonDay2.setForeground(Color.BLACK);
		ButtonDay2.setBackground(lightBlue);
		ButtonDay2.addMouseListener(this);
		panel.add(ButtonDay2);
		
		ButtonDay3 = new JButton("Day 3");
		ButtonDay3.setBounds(173,113,77,20);
		ButtonDay3.setFont(new Font("Ariel", Font.PLAIN, 13));	
		ButtonDay3.setForeground(Color.BLACK);
		ButtonDay3.setBackground(lightBlue);
		ButtonDay3.addMouseListener(this);
		panel.add(ButtonDay3);
		
		ButtonDay4 = new JButton("Day 4");
		ButtonDay4.setBounds(252,113,77,20);
		ButtonDay4.setFont(new Font("Ariel", Font.PLAIN, 13));	
		ButtonDay4.setForeground(Color.BLACK);
		ButtonDay4.setBackground(lightBlue);
		ButtonDay4.addMouseListener(this);
		panel.add(ButtonDay4);
		
		ButtonDay5 = new JButton("Day 5");
		ButtonDay5.setBounds(331,113,77,20);
		ButtonDay5.setFont(new Font("Ariel", Font.PLAIN, 13));	
		ButtonDay5.setForeground(Color.BLACK);
		ButtonDay5.setBackground(lightBlue);
		ButtonDay5.addMouseListener(this);
		panel.add(ButtonDay5);
		
		ButtonDay6 = new JButton("Day 6");
		ButtonDay6.setBounds(410,113,77,20);
		ButtonDay6.setFont(new Font("Ariel", Font.PLAIN, 13));	
		ButtonDay6.setForeground(Color.BLACK);
		ButtonDay6.setBackground(lightBlue);
		ButtonDay6.addMouseListener(this);
		panel.add(ButtonDay6);
		
		ButtonDay7 = new JButton("Day 7");
		ButtonDay7.setBounds(489,113,77,20);
		ButtonDay7.setFont(new Font("Ariel", Font.PLAIN, 13));	
		ButtonDay7.setForeground(Color.BLACK);
		ButtonDay7.setBackground(lightBlue);
		ButtonDay7.addMouseListener(this);
		panel.add(ButtonDay7);
		
		WorkoutTitle = new JLabel("       WEEK 2 : UPPER BODY"); 
		WorkoutTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		WorkoutTitle.setForeground(Color.BLACK);
		WorkoutTitle.setBounds(155, 135, 400, 30);
		panel.add(WorkoutTitle);
		
		DayTitle = new JLabel("(DAY 1)"); 
		DayTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		DayTitle.setForeground(Color.BLACK);
		DayTitle.setBounds(255, 157, 200, 30);
		panel.add(DayTitle);
			
	    String[] columns = {"Name","Required   Instrument"};
		String[][] data = {
						   {" Ex  1 :  BARBELL BENCH PRESS          ",             "   Bench, Barbell"},
						   {" Ex  2 :  LAP PULLDOWN                           ",   "   Adjustable Cable Machine, Lat Pulldown Bar"},
						   {" Ex  3 :  LYING EZ-BAR TRICEPS EXTENSION ",           "   EZ-Bar, Bench"},
						   {" Ex  4 :  DUMBBELL FLYE                            ", "   Bench, Dumbbells"},
						   {" Ex  5 :  BARBELL BENT-OVER ROW           ",          "   Barbell"},
						   {" Ex  6 :  OVERHEAD DUMBBELL PRESS          ",         "   Dumbbells"},
						   {" Ex  7 :  DUMBBELL LATERAL RAISE       ",             "   Dumbbells"},
						   {" Ex  8 :  BARBELL BICEPS CURL             ",          "   Barbell"},
						   {" Ex  9 :  MACHINE PREACHER CURL            ",         "   N/A"},
						   {" Ex  10 :  ROPE PRESSDOWN             ",               "   Adjustable Cable Machine, Rope Attachment"},
						   {" Ex  11 :  CRUNCH              ",                      "   N/A"},
						  };
						   
					   
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
		jt.setGridColor(Color.black);
		jt.setShowHorizontalLines(false);
		jt.setShowVerticalLines(false);
		jps = new JScrollPane(jt);
		jt.setFillsViewportHeight(true);
		jps.setBounds(15, 195, 553, 182);
		panel.add(jps);
		
		RulesLabel1 = new JLabel(" NB : Exercise 1 to 10 requires 10 to 15 reps (Repeatations)");
		RulesLabel1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		RulesLabel1.setForeground(Color.BLACK);
		RulesLabel1.setBounds(15, 387, 550, 15);
		panel.add(RulesLabel1);
		
		RulesLabel2 = new JLabel(" NB : Exercise 11 requires 15 to 20 reps (Repeatations)");
		RulesLabel2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		RulesLabel2.setForeground(Color.BLACK);
		RulesLabel2.setBounds(15, 405, 550, 15);
		panel.add(RulesLabel2);
		
		RulesLabel3 = new JLabel(" NB : Every Exercise requires 3 sets. 3 Group of reps = 1 set");
		RulesLabel3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		RulesLabel3.setForeground(Color.BLACK);
		RulesLabel3.setBounds(15, 423, 550, 15);
		panel.add(RulesLabel3);
		
		drawline3 = new JTextField();
		drawline3.setBounds(15,448,552,1);
		drawline3.setBackground(Color.BLACK);
		panel.add(drawline3);
		
		Quote1 = new JLabel("<html>“ The last three or four reps is what makes the muscle grow.   This area of pain divides the champion from someone else who is not a champion. ”<br><br>  -  Arnold Schwarzenegger,  seven-time Mr. Olympia</html>");
		Quote1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Quote1.setForeground(Color.BLACK);
		Quote1.setBounds(75, 460, 450, 120);
		panel.add(Quote1);
		
		Quote2 = new JLabel("<html>“ If you ain’t pissed off for greatness, that just means you’re okay with being mediocre. ”<br><br>  -  Ray Lewis, two-time Super Bowl Champion</html>");
		Quote2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Quote2.setForeground(Color.BLACK);
		Quote2.setBounds(75, 460, 450, 120);
		panel.add(Quote2);
		
		Quote3 = new JLabel("<html>“ Your health account, your bank account, they’re the same thing. The more you put in, the more you can take out. Exercise is king and nutrition is queen. Together you have a kingdom. ”<br><br>  -  Jack LaLanne, bodybuilder AKA “Godfather of Fitness”</html>");
		Quote3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Quote3.setForeground(Color.BLACK);
		Quote3.setBounds(75, 460, 450, 120);
		panel.add(Quote3);
		
		Quote4 = new JLabel("<html>“ There’s no secret formula. I lift heavy, work hard, and aim to be the best. ”<br><br>  -  Ronnie Coleman, eight-time Mr. Olympia</html>");
		Quote4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Quote4.setForeground(Color.BLACK);
		Quote4.setBounds(75, 460, 450, 120);
		panel.add(Quote4);
		
		Quote5 = new JLabel("<html>“ If you always put limit on everything you do, physical or anything else, it will spread into your work and into your life. There are no limits. There are only plateaus, and you must not stay there, you must go beyond them ” <br><br> - Bruce Lee, Martial artist, Actor, Philosopher</html>");
		Quote5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Quote5.setForeground(Color.BLACK);
		Quote5.setBounds(75, 460, 450, 120);
		panel.add(Quote5);
		
		OFFDay = new JLabel("");
		OFFDay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		OFFDay.setForeground(Color.BLACK);
		OFFDay.setBounds(140, 180, 450, 182);
		panel.add(OFFDay);
	
	 this.add(panel);	
	
	}
	
	public void run()
	{
	 
	try 
	{     
		do
		{
			Quote1.setVisible(false);
			Quote2.setVisible(false);
			Quote3.setVisible(false);
			Quote4.setVisible(false);
			Quote5.setVisible(false);
			Thread.sleep(2000);
			Quote1.setVisible(true);
			Thread.sleep(7000);
			Quote1.setVisible(false);
			Quote2.setVisible(true);
			Thread.sleep(7000);
			Quote2.setVisible(false);
			Quote3.setVisible(true);
			Thread.sleep(7000);
			Quote3.setVisible(false);
			Quote4.setVisible(true);
			Thread.sleep(7000);
			Quote4.setVisible(false);
			Quote5.setVisible(true);
			Thread.sleep(7000);
			
		}while(true);			   
	}
	catch (Exception e) 
	  {
         System.out.println(e.getMessage());
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
	
	public void mouseClicked(MouseEvent me)
	{
		JButton b = (JButton) me.getComponent();
		if(b==ButtonDay1)
		{
			DayTitle.setText("(DAY 1)");
		    jt.setVisible(true);
			jps.setVisible(true);
			OFFDay.setVisible(false);
		}
		else if(b==ButtonDay2)
		{
			DayTitle.setText("(DAY 2)");
			jt.setVisible(false);
			jps.setVisible(false);
			OFFDay.setVisible(true);
			OFFDay.setText("  Take Rest. No Workout Today!");
		}
		else if(b==ButtonDay3)
		{
			DayTitle.setText("(DAY 3)");
		    jt.setVisible(true);
			jps.setVisible(true);
			OFFDay.setVisible(false);
		}
		
		else if(b==ButtonDay4)
		{
			DayTitle.setText("(DAY 4)");
			jt.setVisible(false);
			jps.setVisible(false);
			OFFDay.setVisible(true);
			OFFDay.setText("<html>Rest day once again. Feeling sore? <br>That's why it's important to recover!</html>");
		}
		
		else if(b==ButtonDay5)
		{
			DayTitle.setText("(DAY 5)");
		    jt.setVisible(true);
			jps.setVisible(true);
			OFFDay.setVisible(false);
		}
		
		else if(b==ButtonDay6)
		{
			DayTitle.setText("(DAY 6)");
			jt.setVisible(false);
			jps.setVisible(false);
			OFFDay.setVisible(true);
			OFFDay.setText("<html>Way to go, you've completed two weeks!<br>By now, you should definitely be noticing<br>some results.</html>");
		}
		
		else if(b==ButtonDay7)
		{
			DayTitle.setText("(DAY 7)");
			jt.setVisible(false);
			jps.setVisible(false);
			OFFDay.setVisible(true);
			OFFDay.setText("<html>Enjoy your rest day! Back to work<br>tomorrow for the second half.</html>");
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
	
	public void actionPerformed(ActionEvent ae){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}	
}