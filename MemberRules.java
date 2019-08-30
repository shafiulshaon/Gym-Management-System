import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class MemberRules extends JFrame implements MouseListener, ActionListener
{
	

	
	private JLabel LabelTitle,LabelBackGroundImage, rule1, rule2, rule3, rule4, rule5, rule6, rule7, rule8;
	private JButton buttonBack;
	private JPanel panel;
	private int MemberId;
	private boolean flagWG, flagBB,flagFL;
	
	public MemberRules(int MemberId)
	{
	super("Rules");
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
	
	LabelBackGroundImage = new JLabel();
	LabelBackGroundImage.setBounds(0,0, 600,150);
    ImageIcon imgThisImg = new ImageIcon("logInBackground.JPG");
	LabelBackGroundImage.setIcon(imgThisImg);
	panel.add(LabelBackGroundImage);
	
	this.MemberId=MemberId;
	
	LabelTitle = new JLabel("Rules To Keep Things Simple");
	LabelTitle.setFont(new Font("Tahoma", Font.PLAIN, 19));
	LabelTitle.setForeground(Color.BLACK);
	LabelTitle.setBounds(170,160,250,30);
	panel.add(LabelTitle);
	
	rule1 = new JLabel("# 1  Push Hard, But Not Too Hard");
	rule1.setBounds(170, 220, 350, 25);
	rule1.setFont(new Font("Ariel", Font.PLAIN, 15));
	rule1.setForeground(Color.BLACK);
	panel.add(rule1);
	
	rule2 = new JLabel("# 2  Eat Afterward");
	rule2.setBounds(170, 255, 150, 25);
	rule2.setFont(new Font("Ariel", Font.PLAIN, 15));
	rule2.setForeground(Color.BLACK);
	panel.add(rule2);
	
	rule3 = new JLabel("# 3  Hydrate");
	rule3.setBounds(170, 290, 150, 25);
	rule3.setFont(new Font("Ariel", Font.PLAIN, 15));
	rule3.setForeground(Color.BLACK);
	panel.add(rule3);
	
	rule4 = new JLabel("# 4  Avoid Sports Drinks");
	rule4.setBounds(170, 325, 350, 25);
	rule4.setFont(new Font("Ariel", Font.PLAIN, 15));
	rule4.setForeground(Color.BLACK);
	panel.add(rule4);
	
	rule5 = new JLabel("# 5  Track Your Progress");
	rule5.setBounds(170, 360, 350, 25);
	rule5.setFont(new Font("Ariel", Font.PLAIN, 15));
	rule5.setForeground(Color.BLACK);
	panel.add(rule5);
	
	rule6 = new JLabel("# 6  Use Active Recovery");
	rule6.setBounds(170, 395, 350, 25);
	rule6.setFont(new Font("Ariel", Font.PLAIN, 15));
	rule6.setForeground(Color.BLACK);
	panel.add(rule6);
	
	rule7 = new JLabel("# 7  Stretch");
	rule7.setBounds(170, 430, 150, 25);
	rule7.setFont(new Font("Ariel", Font.PLAIN, 15));
	rule7.setForeground(Color.BLACK);
	panel.add(rule7);
	
	rule8 = new JLabel("# 8  Take Time Off");
	rule8.setBounds(170, 465, 350, 25);
	rule8.setFont(new Font("Ariel", Font.PLAIN, 15));
	rule8.setForeground(Color.BLACK);
	panel.add(rule8);
	
	buttonBack = new JButton("Back");
	buttonBack.setBounds(250,525,120,30);
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
		CheckCourse();
		
		JButton b = (JButton) me.getComponent();
		
		if(b==buttonBack)
		{
		if(flagWG)
		{
			MemberHomeWG wg = new MemberHomeWG(MemberId);
			try{
			this.setVisible(false);
			wg.setVisible(true); 	
			}catch(Exception ex){}
		}
		else if(flagBB)
		{
			MemberHomeBB bb = new MemberHomeBB(MemberId);
			try{
			this.setVisible(false);
			bb.setVisible(true); 	
			}catch(Exception ex){}
		}
		else if(flagFL)
		{
			MemberHomeFL fl = new MemberHomeFL(MemberId);
			try{
			this.setVisible(false);
			fl.setVisible(true); 	
			}catch(Exception ex){}
		}
			
		}
	
		
	}
	
	
	
	public void CheckCourse()
	{
		System.out.println("Checking Course for Member: "+MemberId);
		String queryPassCheck = "SELECT `Course` FROM memberacc WHERE UserId ="+ MemberId+";";   
     
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
                String CourseName = rs.getString("Course");;
				
				if (CourseName.equals("Fat Lose "))
				{
                flagFL=true;
				}
				else if (CourseName.equals("Weight Gain "))
				{
                 flagWG=true;
				}
				else if (CourseName.equals("Build Body "))
				{
                  flagBB=true;
				}
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
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