import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


public class CreateAdmin extends JFrame implements ActionListener, MouseListener 
{
	
	private JButton buttonSubmit, buttonBack, buttonUpload;
	private JTextField UserIdTF, NameTF, BloodGroupTF, EmailTF, PhoneTF, GurdianPhoneTF ;
	private JTextArea AddressTF;
	private JLabel LabelTitle, LabelPic, LabelName, LabelAddress, LabelGender, LabelBirthday, LabelUserID, LabelBloodGroup, LabelEmail, LabelPhone, LabelPhoto, LabelAdmissionDate;
	private JLabel LabelDD, LabelMM, LabelYYYY, LabelADD, LabelAMM, LabelAYYYY;
	private JSpinner spinnerDD, spinnerMM, spinnerYYYY, spinnerADD, spinnerAMM, spinnerAYYYY;
	private SpinnerModel valueDD, valueMM, valueYYYY,valueADD, valueAMM, valueAYYYY,valuePDD, valuePMM, valuePYYYY, valueFt , valueIn;
	private JRadioButton RadioMale, RadioFemale, RadioB1, RadioB2, RadioB3;
	private ButtonGroup bgGender;
	private JFileChooser chooser;
	private FileNameExtensionFilter filter;
	private JPanel panel;
	private String choosertitle, Convert, DOB, AddmissionDate, PaidDate, Password, Status, Validity;
	private String Name,Gender,Batch,BloodGroup,Email,Phone,GuardianPhone,MaritalStatus,Address,Course,picPath;
	private boolean flagName, flagacc, flagDB, flagGender, flagUserId,flagBloodGroup, flagEmail, flagPhone, flagAddress, flagPicPath;
	private int Pass,UserID , AdminId;
	
	
	public CreateAdmin(int AdminId)
	{
	
	super("Create Admin Account");
	Color lightButton = new Color(71, 92, 150);
	Color lightBlue = new Color(172, 166, 255);
		
	this.setSize(550, 650);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	
	panel = new JPanel();
    panel.setLayout(null);
	panel.setBackground(Color.WHITE);
	ImageIcon img = new ImageIcon("icon.jpg");
    this.setIconImage(img.getImage());		
	
    Status="Admin";
    this.AdminId = AdminId;		
	 
	buttonSubmit = new JButton("Submit");
	buttonSubmit.setBounds(110,530,140,30);
	buttonSubmit.setFont(new Font("Ariel", Font.PLAIN, 16));	
	buttonSubmit.setForeground(Color.BLACK);
	buttonSubmit.setBackground(lightButton);
	buttonSubmit.addActionListener(this);
	panel.add(buttonSubmit);
	
	buttonBack = new JButton("Back");
	buttonBack.setBounds(290,530,140,30);
	buttonBack.setFont(new Font("Ariel", Font.PLAIN, 16));	
	buttonBack.setForeground(Color.BLACK);
	buttonBack.setBackground(lightButton);
	buttonBack.addActionListener(this);
	panel.add(buttonBack);
	
	
	buttonUpload = new JButton("Load");
	buttonUpload.setBounds(152, 455, 65, 20);
	buttonUpload.setFont(new Font("Ariel", Font.PLAIN, 12));
	buttonUpload.setForeground(Color.BLACK);
	buttonUpload.setBackground(lightBlue);
	buttonUpload.addActionListener(this);
	panel.add(buttonUpload);
	
	//JfileChooser
	filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
	chooser = new JFileChooser(); 
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle(choosertitle);
    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    chooser.setFileFilter(filter);
    chooser.setAcceptAllFileFilterUsed(false);
	
	
	
	
	///BirthDate
	valueDD =  new SpinnerNumberModel(1, //initial value  
                1, //minimum value  
                31, //maximum value  
                1); //step  

    valueMM =  new SpinnerNumberModel(1, //initial value  
                1, //minimum value  
                12, //maximum value  
                1); //step 

    valueYYYY =  new SpinnerNumberModel(1980, //initial value  
                1900, //minimum value  
                3000, //maximum value  
                1); //step 		

	//AdmissionDate
	valueADD =  new SpinnerNumberModel(1, //initial value  
                1, //minimum value  
                31, //maximum value  
                1); //step  

    valueAMM =  new SpinnerNumberModel(1, //initial value  
                1, //minimum value  
                12, //maximum value  
                1); //step 

    valueAYYYY =  new SpinnerNumberModel(2017, //initial value  
                2017, //minimum value  
                3000, //maximum value  
                1); //step 		

	//PaidDate
	valuePDD =  new SpinnerNumberModel(1, //initial value  
                1, //minimum value  
                31, //maximum value  
                1); //step  

    valuePMM =  new SpinnerNumberModel(1, //initial value  
                1, //minimum value  
                12, //maximum value  
                1); //step 

    valuePYYYY =  new SpinnerNumberModel(2017, //initial value  
                2017, //minimum value  
                3000, //maximum value  
                1); //step 		

	
	
	UserIdTF = new JTextField();
	UserIdTF.setBounds(152, 60, 150, 20);
	UserIdTF.setBackground(Color.WHITE);
	panel.add(UserIdTF);

	NameTF = new JTextField();
	NameTF.setBounds(152, 90, 150, 20);
	NameTF.setBackground(Color.WHITE);
	panel.add(NameTF);
	
	
	BloodGroupTF = new JTextField();
	BloodGroupTF.setBounds(152, 210, 60, 20);
	panel.add(BloodGroupTF);
	
	EmailTF = new JTextField();
	EmailTF.setBounds(152, 240, 150, 20);
	panel.add(EmailTF);
	
	PhoneTF = new JTextField("+880");
	PhoneTF.setBounds(152, 270, 150, 20);
	panel.add(PhoneTF);
	
	GurdianPhoneTF = new JTextField("+880");
	GurdianPhoneTF.setBounds(152, 300, 150, 20);
	panel.add(GurdianPhoneTF);
	
	AddressTF = new JTextArea();
	AddressTF.setBounds(152, 330, 150, 50);
	AddressTF.setBackground(Color.LIGHT_GRAY);
	panel.add(AddressTF);
	
	
	LabelTitle = new JLabel("       Admin Account Form");
	LabelTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
	LabelTitle.setForeground(Color.BLACK);
	LabelTitle.setBounds(130, 10, 500, 30);
	panel.add(LabelTitle);

	
	LabelUserID = new JLabel("User ID            :");
	LabelUserID.setFont(new Font("Tahoma", Font.PLAIN, 15));
	LabelUserID.setBounds(30,60, 120, 20);
	panel.add(LabelUserID);
	

	LabelName = new JLabel("Name              :");
	LabelName.setFont(new Font("Tahoma", Font.PLAIN, 15));
	LabelName.setBounds(30,90, 120, 20);
	panel.add(LabelName);
	
	
	
	LabelGender = new JLabel("Gender            :");
	LabelGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
	LabelGender.setBounds(30, 120, 120, 20);
	panel.add(LabelGender);
	
	LabelBirthday = new JLabel("Date of birth     :");
	LabelBirthday.setFont(new Font("Tahoma", Font.PLAIN, 15));
	LabelBirthday.setBackground(Color.WHITE);
	LabelBirthday.setBounds(30, 150, 120, 20);
	panel.add(LabelBirthday);
	
	spinnerDD = new JSpinner(valueDD);   
    spinnerDD.setBounds(175,152,35,20);
	spinnerDD.addMouseListener(this);
    JFormattedTextField tfd = ((JSpinner.DefaultEditor)spinnerDD.getEditor()).getTextField();
	spinnerDD.setBackground(Color.WHITE);
    tfd.setEditable(false);			
    panel.add(spinnerDD);    
	
	
	spinnerMM = new JSpinner(valueMM);   
    spinnerMM.setBounds(255,152,35,20);  
	spinnerMM.addMouseListener(this);
    JFormattedTextField tfm = ((JSpinner.DefaultEditor)spinnerMM.getEditor()).getTextField();			
    spinnerMM.setBackground(Color.WHITE);
	tfm.setEditable(false);			
    panel.add(spinnerMM);  
	
	
	spinnerYYYY = new JSpinner(valueYYYY);   
    spinnerYYYY.setBounds(336,152,50,20);  
	spinnerYYYY.addMouseListener(this);
    JFormattedTextField tfy = ((JSpinner.DefaultEditor)spinnerYYYY.getEditor()).getTextField();			
    spinnerYYYY.setBackground(Color.WHITE);
	tfy.setEditable(false);			
    panel.add(spinnerYYYY);  

	
	LabelDD = new JLabel("DD");
	LabelDD.setFont(new Font("Tahoma", Font.PLAIN, 12));
	//LabelDD.setForeground(Color.GRAY);
	LabelDD.setBounds(152, 150, 20, 20);
	panel.add(LabelDD);

	LabelMM = new JLabel("MM");
	LabelMM.setFont(new Font("Tahoma", Font.PLAIN, 12));
	//LabelMM.setForeground(Color.GRAY);
	LabelMM.setBounds(228, 150, 20, 20);
	panel.add(LabelMM);

	LabelYYYY = new JLabel("YYYY");
	LabelYYYY.setFont(new Font("Tahoma", Font.PLAIN, 12));
	//LabelYYYY.setForeground(Color.GRAY);
	LabelYYYY.setBounds(298, 150, 40, 20);
	panel.add(LabelYYYY);	
	
	
	LabelBloodGroup = new JLabel("Blood Group      :");
	LabelBloodGroup.setFont(new Font("Tahoma", Font.PLAIN, 15));
	//LabelBloodGroup.setForeground(Color.GRAY);
	LabelBloodGroup.setBounds(30, 210, 120, 20);
	panel.add(LabelBloodGroup);

	
	
	LabelEmail = new JLabel("Email               :");
	LabelEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
	//LabelEmail.setForeground(Color.GRAY);
	LabelEmail.setBounds(30, 240, 120, 20);
	panel.add(LabelEmail);
	
	LabelPhone = new JLabel("Phone No         :");
	LabelPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
	//LabelPhone.setForeground(Color.GRAY);
	LabelPhone.setBounds(30, 270, 120, 20);
	panel.add(LabelPhone);
	
	LabelAddress = new JLabel("Address           :");
	LabelAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
	LabelAddress.setBounds(30, 330, 120, 20);
	panel.add(LabelAddress);
		
	
	LabelAdmissionDate = new JLabel("Joined Date      :");
	LabelAdmissionDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
	//LabelAdmissionDate.setForeground(Color.GRAY);
	LabelAdmissionDate.setBounds(30, 420, 120, 20);
	panel.add(LabelAdmissionDate);
	
	LabelADD = new JLabel("DD");
	LabelADD.setFont(new Font("Tahoma", Font.PLAIN, 12));
	//LabelADD.setForeground(Color.GRAY);
	LabelADD.setBounds(152, 420, 20, 20);
	panel.add(LabelADD);

	LabelAMM = new JLabel("MM");
	LabelAMM.setFont(new Font("Tahoma", Font.PLAIN, 12));
	//LabelAMM.setForeground(Color.GRAY);
	LabelAMM.setBounds(228, 420, 20, 20);
	panel.add(LabelAMM);

	LabelAYYYY = new JLabel("YYYY");
	LabelAYYYY.setFont(new Font("Tahoma", Font.PLAIN, 12));
	//LabelAYYYY.setForeground(Color.GRAY);
	LabelAYYYY.setBounds(298, 420, 40, 20);
	panel.add(LabelAYYYY);	
	
	spinnerADD = new JSpinner(valueADD);   
    spinnerADD.setBounds(175,422,35,20);  
	spinnerADD.addMouseListener(this);
    JFormattedTextField tfad = ((JSpinner.DefaultEditor)spinnerADD.getEditor()).getTextField();			
    spinnerADD.setBackground(Color.WHITE);
	tfad.setEditable(false);			
    panel.add(spinnerADD);    
	
	
	spinnerAMM = new JSpinner(valueAMM);   
    spinnerAMM.setBounds(254,422,35,20);  
	spinnerAMM.addMouseListener(this);
    JFormattedTextField tfam = ((JSpinner.DefaultEditor)spinnerAMM.getEditor()).getTextField();			
    spinnerAMM.setBackground(Color.WHITE);
	tfam.setEditable(false);			
    panel.add(spinnerAMM);  
	
	
	spinnerAYYYY = new JSpinner(valueAYYYY);   
    spinnerAYYYY.setBounds(336,422,50,20);  
	spinnerAYYYY.addMouseListener(this);
    JFormattedTextField tfay = ((JSpinner.DefaultEditor)spinnerAYYYY.getEditor()).getTextField();			
    spinnerAYYYY.setBackground(Color.WHITE);
	tfay.setEditable(false);			
    panel.add(spinnerAYYYY);  
	
	
	
	LabelPhoto = new JLabel("Select Photo     :");
	LabelPhoto.setFont(new Font("Tahoma", Font.PLAIN, 15));
	//LabelPhoto.setForeground(Color.GRAY);
	LabelPhoto.setBounds(30, 453, 120, 20);
	panel.add(LabelPhoto);
	
	RadioMale = new JRadioButton("Male");
	RadioMale.setBounds(150, 120, 60, 20);
	RadioMale.setBackground(Color.WHITE);
	RadioMale.addActionListener(this);
	panel.add(RadioMale);
		
	RadioFemale = new JRadioButton("Female");
	RadioFemale.setBounds(210, 120, 70, 20);
	RadioFemale.setBackground(Color.WHITE);
	RadioFemale.addActionListener(this);
	panel.add(RadioFemale);
	
		
	bgGender= new ButtonGroup();
	bgGender.add(RadioMale);
	bgGender.add(RadioFemale);	
	
	

	this.add(panel);
		
	}
	
	public void actionPerformed(ActionEvent ae) throws NumberFormatException
	{

	if(ae.getSource()==buttonBack)
	{
	CreateAccount acc = new CreateAccount(AdminId);
	try{
	this.setVisible(false);
	acc.setVisible(true);
	}catch(Exception ex){}
	}
	
	if(ae.getSource()==buttonSubmit)
	{
	
	flagacc=true;
	
	if(UserIdTF.getText().isEmpty())
	{
	JOptionPane.showMessageDialog(this, "Please Enter UserID");
	}
	    else 
	{
	flagUserId=true;  
	try{
	UserID=Integer.parseInt(UserIdTF.getText());
	}catch(NumberFormatException en)
	{   flagUserId=false; 
	    JOptionPane.showMessageDialog(this, "Invalid Char in UserID : "+en.getMessage());
		System.out.println("Number Format execption caught: "+en.getMessage());
	}
	}
	if(NameTF.getText().isEmpty())
	{
	//System.out.println(flagName);
	JOptionPane.showMessageDialog(this, "Please Enter Name");
	}
	    else 
	{
	flagName=true;	
	Name=NameTF.getText();	
	}

	if(BloodGroupTF.getText().isEmpty())
	{
    JOptionPane.showMessageDialog(this, "Please Enter Blood Group");
	}
		else 
	{
	flagBloodGroup=true;
	BloodGroup=BloodGroupTF.getText();
	}

	if(EmailTF.getText().isEmpty())
	{
 	JOptionPane.showMessageDialog(this, "Please Enter Email");
	}
		else 
	{
	flagEmail=true;
	Email=EmailTF.getText();
	}

	if(PhoneTF.getText().isEmpty())
	{
 	JOptionPane.showMessageDialog(this, "Please Enter Phone");
	}
		else 
	{
	flagPhone=true;
	Phone=PhoneTF.getText();
	}

	if(AddressTF.getText().isEmpty())
	{
 	JOptionPane.showMessageDialog(this, "Please Enter Address");
	}
		else 
	{
	flagAddress=true;
	Address=AddressTF.getText();
	
	}

	try{
	if(picPath.isEmpty())
	{
	JOptionPane.showMessageDialog(this, "Please Select Pic");
	}
	    else
	{
	flagPicPath=true;
	}}catch(Exception e)
	{
		JOptionPane.showMessageDialog(this, "Please Select Pic");
	}
	
	if(flagName && flagGender && flagUserId && flagBloodGroup && flagEmail && flagPhone && flagAddress && flagPicPath)
	{
     
	getDOB();
	getAddmissionDate();
	createPass();
	Validity="Valid";
	
	insertIntoDB();
    
 	if(flagDB)
	{
	Back();
	}
	
	}
	
	else
	{
	System.out.println(flagUserId);
	System.out.println(flagName);
	System.out.println(flagGender);
	System.out.println(flagBloodGroup);
	System.out.println(flagEmail);
	System.out.println(flagPhone);
	System.out.println(flagAddress);
	System.out.println(flagPicPath);
	System.out.println(flagDB);
	//JOptionPane.showMessageDialog(this, "Please Complete From");	
	}

	}
		
	if(ae.getSource()==RadioMale || ae.getSource()==RadioFemale )
	{
	flagGender=true;				
	Gender=ae.getActionCommand();
	}
	
		
    /// picupload
    if (ae.getSource()==buttonUpload &&chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) 
	{ 
    System.out.println("getCurrentDirectory(): " 
         +  chooser.getCurrentDirectory());
    System.out.println("getSelectedFile() : " 
         +  chooser.getSelectedFile());
		 
	Convert=chooser.getSelectedFile().getPath();
	picPath=Convert.replace('\\', '/');
	System.out.println("PATH FOR SAVE: " +picPath);
	
    JLabelContainer();
	
		 
      }
    /*else
	{
      System.out.println("No Selection ");
    } */
	  
	}
	
	public void  JLabelContainer() {
    
	//LabelPic.setEnabled(false);
	ImageIcon imgThisNEWImg = new ImageIcon(picPath);
	JLabel LabelPic = new JLabel(imgThisNEWImg);
	LabelPic.setIcon(imgThisNEWImg);
	LabelPic.setBounds(360,40, 100, 100);
	panel.add(LabelPic);
    }
	
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}	
	
	
	public void getDOB()
	{
	Integer DD = (Integer)spinnerDD.getValue();		
	String ConvertDD = Integer.toString(DD);
	
	Integer MM = (Integer)spinnerMM.getValue();		
	String ConvertMM = Integer.toString(MM);
	
	Integer YYYY = (Integer)spinnerYYYY.getValue();		
	String ConvertYYYY = Integer.toString(YYYY);
	
	DOB = ConvertDD	+"/"+ConvertMM+"/"+ConvertYYYY ;	
	}
	public void getAddmissionDate()
	{
	
	Integer AAD = (Integer)spinnerADD.getValue();		
	String ConvertAAD = Integer.toString(AAD);
	
	Integer AMM = (Integer)spinnerAMM.getValue();		
	String ConvertAMM = Integer.toString(AMM);
	
	Integer AYYY = (Integer)spinnerAYYYY.getValue();		
	String ConvertAYYY = Integer.toString(AYYY);
	
	AddmissionDate = ConvertAAD+"/"+ConvertAMM+"/"+ConvertAYYY ;
	
	}

	
	public void createPass()
	{
	Random rand1 = new Random();
	Pass = rand1.nextInt(9999) + 1000;
	Password=Integer.toString(Pass);
	}
	
	
	public void insertIntoDB()
	{
		String queryAccounts = "INSERT INTO accounts VALUES ("+UserID+",'"+Password+"','"+Status+"','"+Validity+"');";
		String queryInstructor = "INSERT INTO adminacc VALUES ("+UserID+",'"+Name+"','"+Gender+"','"+DOB+"','"+Address+"','"+ Phone+"','"+ Email+"','"+ picPath+"','"+ AddmissionDate+"','"+ BloodGroup+"');";
		System.out.println(queryAccounts);
		System.out.println(queryInstructor);
		
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group8f", "root", "");
			Statement stm = con.createStatement();
			stm.execute(queryAccounts);	
			if(flagacc)
			{
			stm.execute(queryInstructor);
			flagDB=true;
			}
			
			stm.close();
			con.close();
					
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Already Registered UserId :" +UserIdTF.getText());
			System.out.println("Exception : " +ex.getMessage());
			flagDB=false;
			flagacc=false;
        }
    }
	
	
	public void Back()
	{
	JOptionPane.showMessageDialog(this, "Succesfully Sumbited");
	JOptionPane.showMessageDialog(this, "UserId : "+UserIdTF.getText()+" & Default Pass : "+ String.valueOf(Password));
    System.out.println("Succesfully Filled From");	
	CreateAccount acc = new CreateAccount(AdminId);
	try{
	this.setVisible(false);
	acc.setVisible(true);
	}catch(Exception ex){}
	}


}