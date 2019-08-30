import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class AdminLogin extends JFrame implements ActionListener, MouseListener{
	

	private JLabel nameLabel, passLabel,LabelBackGroundImage;
	private JTextField userNameTF;
	private JPasswordField passPF;
	private JButton buttonLogin,buttonBack, buttonExit;
	private JPanel panel;
    private boolean flag;	
	
	public AdminLogin()
	{
	super("ADMIN - Login Page");
		
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
	
	nameLabel = new JLabel("Enter UserId     : ");
	nameLabel.setBounds(150, 200, 125, 25);
	nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	nameLabel.setForeground(Color.BLACK);
	panel.add(nameLabel);
	
	userNameTF = new JTextField();
	userNameTF.setBounds(280, 200, 135, 25);
	panel.add(userNameTF);
		
	passLabel = new JLabel("Enter Password  : ");
	passLabel.setBounds(150, 240, 125, 25);
	passLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	passLabel.setForeground(Color.BLACK);
	panel.add(passLabel);
		
	passPF = new JPasswordField();
	passPF.setBounds(280, 240, 135, 25);
	panel.add(passPF);
		
	buttonLogin = new JButton("Login");
	buttonLogin.setBounds(150,300,120,30);
	buttonLogin.setFont(new Font("Ariel", Font.PLAIN, 15));	
	buttonLogin.setForeground(Color.BLACK);
	buttonLogin.setBackground(lightButton);
    buttonLogin.addActionListener(this);
	buttonLogin.addMouseListener(this);
	panel.add(buttonLogin);
		
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
		
		if(b==buttonLogin)
		{   
			System.out.println("buttonLogin");
			flag=true;
			check();
		}
				
	    else if(b==buttonBack)
		{
		LoginPage log = new LoginPage();
     	try{
	    this.setVisible(false);
	    log.setVisible(true);
	    }catch(Exception ex){}
		}
		
	}

	
	
	public void check()
	{
        String query = "SELECT `UserId`, `Password`,`Status`,`Validity` FROM `accounts`;";   
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("Driver Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Group8F","root","");
			System.out.println("Connection Complete");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("Statement Created");
			rs = st.executeQuery(query);//getting result
			System.out.println("Results received");
					
			while(rs.next())
			{
                int Id = rs.getInt("UserID");
                String password = rs.getString("Password");
				String status = rs.getString("Status");
				String validity = rs.getString("Validity");
				String userId=Integer.toString(Id); 
				
				if(userId.equals(userNameTF.getText()))
				{
					flag=false;
					if(password.equals(passPF.getText()))
					{
						if(status.equals("Admin"))
						{
							if(validity.equals("Valid"))
							{
							AdminHome ah = new AdminHome(Id);
							this.setVisible(false);
							ah.setVisible(true);	
							}
							else
							{
								JOptionPane.showMessageDialog(this,"Access Denied! Contact Admin. ");
							}
							
						}
						else
						{
							JOptionPane.showMessageDialog(this,"Access Denied  ");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Invalid Password"); 
					}
				}			
			}
			if(flag){JOptionPane.showMessageDialog(this,"Invalid UserID"); }
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
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