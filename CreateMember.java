import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


public class CreateMember extends JFrame implements ActionListener, MouseListener 
{
	
	private JButton buttonSubmit, buttonExit,buttonUpload, buttonBack;
	private JTextField UserIdTF, NameTF, BloodGroupTF, EmailTF, PhoneTF, GurdianPhoneTF, FeeTF, WeightTF ;
	private JTextArea AddressTF;
	private JLabel LabelTitle, LabelPic, LabelName, LabelAddress, LabelGender, LabelBirthday, LabelUserID, LabelMaritalstatus, LabelHeight, LabelWeight, LabelBloodGroup, LabelEmail, LabelPhone, LabelPhoto, LabelAdmissionDate, LabelPaidDate, LabelFee , LabelGuardianContact, LabelCourse, LabelBatch;
	private JLabel LabelDD, LabelMM, LabelYYYY, LabelFeet, LabelInch, LabelADD, LabelAMM, LabelAYYYY, LabelPDD, LabelPMM, LabelPYYYY;
	private JSpinner spinnerDD, spinnerMM, spinnerYYYY, spinnerFt, spinnerIn, spinnerADD, spinnerAMM, spinnerAYYYY, spinnerPDD, spinnerPMM, spinnerPYYYY;
	private SpinnerModel valueDD, valueMM, valueYYYY,valueADD, valueAMM, valueAYYYY,valuePDD, valuePMM, valuePYYYY, valueFt , valueIn;
	private JRadioButton RadioMale, RadioFemale, RadioOther, RadioB1, RadioB2, RadioB3;
	private JComboBox combo, courseCombo;
	private ButtonGroup bgGender, bgBatch;
	private JFileChooser chooser;
	private FileNameExtensionFilter filter;
	private JPanel panel;
	private String queryTransaction, choosertitle, Convert;
	private String Name,Height,Gender,Batch,BloodGroup,Email,Phone,GuardianPhone,MaritalStatus,Address,Course,picPath;
	private double Weight, Fee, Salary;
	private boolean flagName,flagtransaction, flagacc, flagDB, flagGender, flagUserId, flagBatch,flagBloodGroup, flagEmail, flagPhone, flagGuardianPhone, flagMaritalStatus, flagAddress, flagWeight, flagCourse, flagFee, flagPicPath;
	private String DOB, AddmissionDate, PaidDate, Password, Status, Validity;
	private int Pass, UserID, AdminId,Month, Year,transactionNo=100;
	
	
	public CreateMember(int AdminId)
	{
	
	super("Create Member Account");
	
	Color lightButton = new Color(71, 92, 150);
	Color lightBlue = new Color(172, 166, 255);
		
	this.setSize(545, 650);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	
	panel = new JPanel();
    panel.setLayout(null);
	
	panel.setBackground(Color.WHITE);
	ImageIcon img = new ImageIcon("icon.jpg");
    this.setIconImage(img.getImage());	
	
    Status="Member";
    this.AdminId = AdminId;	
	 
	buttonSubmit = new JButton("Submit");
	buttonSubmit.setBounds(120,550,130,28);
	buttonSubmit.setFont(new Font("Ariel", Font.PLAIN, 16));	
	buttonSubmit.setForeground(Color.BLACK);
	buttonSubmit.setBackground(lightButton);
	buttonSubmit.addActionListener(this);
	panel.add(buttonSubmit);
		
	buttonBack = new JButton("Back");
	buttonBack.setBounds(290,550,130,28);
	buttonBack.setFont(new Font("Ariel", Font.PLAIN, 16));	
	buttonBack.setForeground(Color.BLACK);
	buttonBack.setBackground(lightButton);
	buttonBack.addActionListener(this);
	panel.add(buttonBack);
		
	buttonUpload = new JButton("Load");
	buttonUpload.setBounds(152, 510, 65, 20);
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

    valueYYYY =  new SpinnerNumberModel(1900, //initial value  
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

	
    valueFt =  new SpinnerNumberModel(1, //initial value  
                1, //minimum value  
                20, //maximum value  
                1); //step 	

    valueIn =  new SpinnerNumberModel(0, //initial value  
                0, //minimum value  
                12, //maximum value  
                1); //step 					
	
	
	
	UserIdTF = new JTextField();
	UserIdTF.setBounds(152, 60, 150, 20);
	panel.add(UserIdTF);

	NameTF = new JTextField();
	NameTF.setBounds(152, 90, 150, 20);
	panel.add(NameTF);
	
	WeightTF = new JTextField("");
	WeightTF.setBounds(400, 180, 60, 20);
	panel.add(WeightTF);
	
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
	
	FeeTF = new JTextField();
	FeeTF.setBounds(152, 480, 66, 20);
	panel.add(FeeTF);
	
	LabelTitle = new JLabel(" Member Account Form");
	LabelTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
	LabelTitle.setForeground(Color.BLACK);
	LabelTitle.setBounds(170, 10, 500, 30);
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
	//LabelBirthday.setForeground(Color.GRAY);
	LabelBirthday.setBounds(30, 150, 120, 20);
	panel.add(LabelBirthday);
	
	spinnerDD = new JSpinner(valueDD);   
    spinnerDD.setBounds(175,152,35,20);
	spinnerDD.addMouseListener(this);
    JFormattedTextField tfd = ((JSpinner.DefaultEditor)spinnerDD.getEditor()).getTextField();			
    tfd.setEditable(false);			
    panel.add(spinnerDD);    
	
	
	spinnerMM = new JSpinner(valueMM);   
    spinnerMM.setBounds(248,152,35,20);  
	spinnerMM.addMouseListener(this);
    JFormattedTextField tfm = ((JSpinner.DefaultEditor)spinnerMM.getEditor()).getTextField();			
    tfm.setEditable(false);			
    panel.add(spinnerMM);  
	
	
	spinnerYYYY = new JSpinner(valueYYYY);   
    spinnerYYYY.setBounds(330,152,50,20);  
	spinnerYYYY.addMouseListener(this);
    JFormattedTextField tfy = ((JSpinner.DefaultEditor)spinnerYYYY.getEditor()).getTextField();			
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
	LabelMM.setBounds(222, 150, 20, 20);
	panel.add(LabelMM);

	LabelYYYY = new JLabel("YYYY");
	LabelYYYY.setFont(new Font("Tahoma", Font.PLAIN, 12));
	//LabelYYYY.setForeground(Color.GRAY);
	LabelYYYY.setBounds(292, 150, 40, 20);
	panel.add(LabelYYYY);	
	
	
	LabelBloodGroup = new JLabel("Blood Group      :");
	LabelBloodGroup.setFont(new Font("Tahoma", Font.PLAIN, 15));
	//LabelBloodGroup.setForeground(Color.GRAY);
	LabelBloodGroup.setBounds(30, 210, 120, 20);
	panel.add(LabelBloodGroup);

	
	LabelMaritalstatus = new JLabel("Marital Status :");
	LabelMaritalstatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
	//LabelMaritalstatus.setForeground(Color.GRAY);
	LabelMaritalstatus.setBounds(292, 210, 120, 20);
	panel.add(LabelMaritalstatus);
	
	
	
	LabelHeight = new JLabel("Height              :");
	LabelHeight.setFont(new Font("Tahoma", Font.PLAIN, 15));
	//LabelHeight.setForeground(Color.GRAY);
	LabelHeight.setBounds(30, 180, 120, 20);
	panel.add(LabelHeight);
	
	spinnerFt = new JSpinner(valueFt);   
    spinnerFt.setBounds(175,182,35,20);  
	spinnerFt.addMouseListener(this);
    JFormattedTextField tff = ((JSpinner.DefaultEditor)spinnerFt.getEditor()).getTextField();			
    tff.setEditable(false);			
    panel.add(spinnerFt); 
	
	spinnerIn = new JSpinner(valueIn);   
    spinnerIn.setBounds(248,182,35,20);
	spinnerIn.addMouseListener(this);
    JFormattedTextField tfi = ((JSpinner.DefaultEditor)spinnerIn.getEditor()).getTextField();			
    tfi.setEditable(false);			
    panel.add(spinnerIn); 
	
	LabelFeet = new JLabel("Ft");
	LabelFeet.setFont(new Font("Tahoma", Font.PLAIN, 12));
	//LabelFeet.setForeground(Color.GRAY);
	LabelFeet.setBounds(152, 180, 20, 20);
	panel.add(LabelFeet);
	
	LabelInch = new JLabel("In");
	LabelInch.setFont(new Font("Tahoma", Font.PLAIN, 12));
	//LabelInch.setForeground(Color.GRAY);
	LabelInch.setBounds(220, 180, 20, 20);
	panel.add(LabelInch);
	
	
	LabelWeight = new JLabel("Weight         :");
	LabelWeight.setFont(new Font("Tahoma", Font.PLAIN, 15));
	//LabelWeight.setForeground(Color.GRAY);
	LabelWeight.setBounds(292, 180, 120, 20);
	panel.add(LabelWeight);

	
	
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
	
	LabelGuardianContact = new JLabel("Guardian Phone :");
	LabelGuardianContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
	//LabelGuardianContact.setForeground(Color.GRAY);
	LabelGuardianContact.setBounds(30, 300, 120, 20);
	panel.add(LabelGuardianContact);
	
	LabelAddress = new JLabel("Address           :");
	LabelAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
	//LabelAddress.setForeground(Color.GRAY);
	LabelAddress.setBounds(30, 330, 120, 20);
	panel.add(LabelAddress);
	
	
	LabelCourse = new JLabel("Course  :");
	LabelCourse.setFont(new Font("Tahoma", Font.PLAIN, 15));
	//LabelCourse.setForeground(Color.GRAY);
	LabelCourse.setBounds(310, 390, 60, 20);
	panel.add(LabelCourse);
	
	LabelBatch = new JLabel("Batch              :");
	LabelBatch.setFont(new Font("Tahoma", Font.PLAIN, 15));
	//LabelBatch.setForeground(Color.GRAY);
	LabelBatch.setBounds(30, 390, 120, 20);
	panel.add(LabelBatch);
	
	LabelAdmissionDate = new JLabel("Admission Date :");
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
	LabelAMM.setBounds(222, 420, 20, 20);
	panel.add(LabelAMM);

	LabelAYYYY = new JLabel("YYYY");
	LabelAYYYY.setFont(new Font("Tahoma", Font.PLAIN, 12));
	//LabelAYYYY.setForeground(Color.GRAY);
	LabelAYYYY.setBounds(292, 420, 40, 20);
	panel.add(LabelAYYYY);	
	
	spinnerADD = new JSpinner(valueADD);   
    spinnerADD.setBounds(175,422,35,20);  
	spinnerADD.addMouseListener(this);
    JFormattedTextField tfad = ((JSpinner.DefaultEditor)spinnerADD.getEditor()).getTextField();			
    tfad.setEditable(false);			
    panel.add(spinnerADD);    
	
	
	spinnerAMM = new JSpinner(valueAMM);   
    spinnerAMM.setBounds(248,422,35,20);  
	spinnerAMM.addMouseListener(this);
    JFormattedTextField tfam = ((JSpinner.DefaultEditor)spinnerAMM.getEditor()).getTextField();			
    tfam.setEditable(false);			
    panel.add(spinnerAMM);  
	
	
	spinnerAYYYY = new JSpinner(valueAYYYY);   
    spinnerAYYYY.setBounds(330,422,50,20);  
	spinnerAYYYY.addMouseListener(this);
    JFormattedTextField tfay = ((JSpinner.DefaultEditor)spinnerAYYYY.getEditor()).getTextField();			
    tfay.setEditable(false);			
    panel.add(spinnerAYYYY);  
	
	LabelPaidDate = new JLabel("Paid Date         :");
	LabelPaidDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
	//LabelPaidDate.setForeground(Color.GRAY);
	LabelPaidDate.setBounds(30, 450, 120, 20);
	panel.add(LabelPaidDate);
	
	LabelPDD = new JLabel("DD");
	LabelPDD.setFont(new Font("Tahoma", Font.PLAIN, 12));
	//LabelPDD.setForeground(Color.GRAY);
	LabelPDD.setBounds(152, 450, 20, 20);
	panel.add(LabelPDD);

	LabelPMM = new JLabel("MM");
	LabelPMM.setFont(new Font("Tahoma", Font.PLAIN, 12));
	//LabelPMM.setForeground(Color.GRAY);
	LabelPMM.setBounds(222, 450, 20, 20);
	panel.add(LabelPMM);

	LabelPYYYY = new JLabel("YYYY");
	LabelPYYYY.setFont(new Font("Tahoma", Font.PLAIN, 12));
	//LabelPYYYY.setForeground(Color.GRAY);
	LabelPYYYY.setBounds(292, 450, 40, 20);
	panel.add(LabelPYYYY);	
	
	spinnerPDD = new JSpinner(valuePDD);   
    spinnerPDD.setBounds(175,452,35,20); 
    spinnerPDD.addMouseListener(this);	
    JFormattedTextField tfpd = ((JSpinner.DefaultEditor)spinnerPDD.getEditor()).getTextField();			
    tfpd.setEditable(false);			
    panel.add(spinnerPDD);    
	
	
	spinnerPMM = new JSpinner(valuePMM);   
    spinnerPMM.setBounds(248,452,35,20); 
    spinnerPMM.addMouseListener(this);	
    JFormattedTextField tfpm = ((JSpinner.DefaultEditor)spinnerPMM.getEditor()).getTextField();			
    tfpm.setEditable(false);			
    panel.add(spinnerPMM);  
	
	
	spinnerPYYYY = new JSpinner(valuePYYYY);   
    spinnerPYYYY.setBounds(330,452,50,20);  
	spinnerPYYYY.addMouseListener(this);
    JFormattedTextField tfpy = ((JSpinner.DefaultEditor)spinnerPYYYY.getEditor()).getTextField();			
    tfpy.setEditable(false);			
    panel.add(spinnerPYYYY);
	
	LabelFee = new JLabel("Fee (Tk.)         :");
	LabelFee.setFont(new Font("Tahoma", Font.PLAIN, 15));
	//LabelFee.setForeground(Color.GRAY);
	LabelFee.setBounds(30, 480, 120, 20);
	panel.add(LabelFee);
	
	LabelPhoto = new JLabel("Select Photo     :");
	LabelPhoto.setFont(new Font("Tahoma", Font.PLAIN, 15));
	//LabelPhoto.setForeground(Color.GRAY);
	LabelPhoto.setBounds(30, 510, 120, 20);
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
	
	RadioOther = new JRadioButton("Other");
	RadioOther.setBounds(280, 120, 60, 20);
	RadioOther.setBackground(Color.WHITE);
	RadioOther.addActionListener(this);
	panel.add(RadioOther);
		
	bgGender= new ButtonGroup();
	bgGender.add(RadioMale);
	bgGender.add(RadioFemale);	
	bgGender.add(RadioOther);
	
	RadioB1 = new JRadioButton("B1");
	RadioB1.setBounds(150, 390, 40, 20);
	RadioB1.setBackground(Color.WHITE);
	RadioB1.addActionListener(this);
	panel.add(RadioB1);
	
	RadioB2 = new JRadioButton("B2");
	RadioB2.setBounds(200, 390, 40, 20);
	RadioB2.setBackground(Color.WHITE);
	RadioB2.addActionListener(this);
	panel.add(RadioB2);
	
	RadioB3 = new JRadioButton("B3");
	RadioB3.setBounds(250, 390, 40, 20);
	RadioB3.setBackground(Color.WHITE);
	RadioB3.addActionListener(this);
	panel.add(RadioB3);
	
	bgBatch= new ButtonGroup();
	bgBatch.add(RadioB1);
	bgBatch.add(RadioB2);	
	bgBatch.add(RadioB3);
	
	
	String s[] = {"Select", "Single ", "Married", "Devorce"};
	combo = new JComboBox(s);
	combo.setBounds(400, 210, 75, 20);
	combo.setBackground(Color.WHITE);
	combo.addActionListener(this);
	panel.add(combo);
	
	
	String c[] = {"Select", "Fat Lose ", "Weight Gain ", "Build Body "};
	courseCombo = new JComboBox(c);
	courseCombo.setBounds(380, 390, 95, 20);
	courseCombo.setBackground(Color.WHITE);
	courseCombo.addActionListener(this);
	panel.add(courseCombo);

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
	if(WeightTF.getText().isEmpty())
	{
	JOptionPane.showMessageDialog(this, "Please Enter Weight");
	}
		else 
	{
	flagWeight=true;
   try{	
	Weight=Double.parseDouble(WeightTF.getText());  
    }catch(NumberFormatException ew)
	{   flagWeight=false; 
	    JOptionPane.showMessageDialog(this, "Invalid Char in Weight :"+ew.getMessage());
		System.out.println("Number Format execption caught: "+ew.getMessage());
	}
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

	if(GurdianPhoneTF.getText().isEmpty())
	{
    JOptionPane.showMessageDialog(this, "Please Enter Phone");
	}
		else 
	{
	flagGuardianPhone=true;
	GuardianPhone=GurdianPhoneTF.getText();
	}
	
	if(flagCourse==false)
	{
	JOptionPane.showMessageDialog(this, "Please Select Course");
	}
	if(flagBatch==false)
	{
	JOptionPane.showMessageDialog(this, "Please Select Batch");	
	}
	if(flagMaritalStatus==false)
	{
	JOptionPane.showMessageDialog(this, "Please Select Marital Status");	
	}
	if(flagGender==false)
	{
	JOptionPane.showMessageDialog(this, "Please Select Gender");	
	}

	if(AddressTF.getText().isEmpty())
	{
 	JOptionPane.showMessageDialog(this, "Please Select Address");
	}
		else 
	{
	flagAddress=true;
	Address=AddressTF.getText();
	}

	if(FeeTF.getText().isEmpty())
	{
	
	}
		else 
	{
	flagFee=true;
    try{
	Fee=Double.parseDouble(FeeTF.getText()); 
	}catch(NumberFormatException ef)
	{   flagFee=false; 
	    JOptionPane.showMessageDialog(this, "Invalid Char in Fee (Tk.) :"+ef.getMessage());
		System.out.println("Number Format execption caught: "+ef.getMessage());
	}
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
	
	if(flagName && flagGender && flagUserId && flagBatch && flagBloodGroup && flagEmail && flagPhone && flagGuardianPhone && flagMaritalStatus && flagAddress && flagWeight && flagCourse && flagFee && flagPicPath)
	{

	
	getDOB();
	getAddmissionDate();
	getPaidDate();
	getMHeight();
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
	System.out.println(flagBatch);
	System.out.println(flagBloodGroup);
	System.out.println(flagEmail);
	System.out.println(flagPhone);
	System.out.println(flagGuardianPhone);
	System.out.println(flagMaritalStatus);
	System.out.println(flagAddress);
	System.out.println(flagWeight);
	System.out.println(flagCourse);
	System.out.println(flagFee);
	System.out.println(flagPicPath);
	System.out.println(flagDB);
	//JOptionPane.showMessageDialog(this, "Please Complete From");	
	}

	}
		
	if(ae.getSource()==RadioMale || ae.getSource()==RadioFemale|| ae.getSource()==RadioOther)
	{
	flagGender=true;				
	Gender=ae.getActionCommand();
	}
	
	if(ae.getSource()==RadioB1 || ae.getSource()==RadioB2|| ae.getSource()==RadioB3)
	{
	flagBatch=true;
    Batch=ae.getActionCommand();
	}
	
	if(ae.getSource()==combo)
	{
	flagMaritalStatus=true;	
	MaritalStatus=combo.getSelectedItem().toString();;
	}
	
	if(ae.getSource()==courseCombo)
	{
	flagCourse=true;	
	Course=courseCombo.getSelectedItem().toString();;		
    System.out.println("Course selected: "+ Course);				
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
	public void getPaidDate()
	{
	Integer PDD = (Integer)spinnerPDD.getValue();		
	String ConvertPDD = Integer.toString(PDD);
	
	Integer PMM = (Integer)spinnerPMM.getValue();
    Month = PMM;	
	String ConvertPMM = Integer.toString(PMM);
	
	Integer PYYYY = (Integer)spinnerPYYYY.getValue();
    Year = PYYYY;	
	String ConvertPYYYY = Integer.toString(PYYYY);
	
	PaidDate = ConvertPDD+"/"+ConvertPMM+"/"+ConvertPYYYY ;
	}
	
	public void getMHeight()
	{
	Integer ft = (Integer)spinnerFt.getValue();		
	String Convertft = Integer.toString(ft);
	
	Integer in = (Integer)spinnerIn.getValue();		
	String Convertin = Integer.toString(in);
	
	Height = Convertft+"ft"+Convertin+"in";
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
		String queryMember = "INSERT INTO memberacc VALUES ("+UserID+",'"+Name+"','"+Gender+"','"+DOB+"','"+MaritalStatus+"','"+Height+"',"+Weight+",'"+ BloodGroup+"','"+ Email+"','"+ Phone+"','"+ Address+"','"+ picPath+"','"+ AddmissionDate+"','"+ PaidDate+"','"+ GuardianPhone+"','"+ Course+"','"+ Batch+"');";
		 
		System.out.println(queryAccounts);
		System.out.println(queryMember);
		//System.out.println(queryTransaction);

		
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group8f", "root", "");
			Statement stm = con.createStatement();

			CheckTransactionNo();
			
			if(flagtransaction)
			{
			stm.execute(queryAccounts);
			flagacc=true;
			}
			if(flagacc){
			stm.execute(queryMember);		
			System.out.println("transactionNo: "+transactionNo);
			stm.execute(queryTransaction);
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
	
	
	public void CheckTransactionNo()
	{   
	    String queryTransactionNo = "SELECT `TransactionNo` FROM transaction ORDER BY `TransactionNo` DESC LIMIT 1;"; 
	    Connection con=null;
        Statement st = null;
		ResultSet rs = null;		
			
			try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Group8F","root","");
			System.out.println("connection done");
			st = con.createStatement();
			System.out.println("statement created");
			rs = st.executeQuery(queryTransactionNo);
			System.out.println("results received");	

			if(rs.next()){
            int t =  rs.getInt("TransactionNo");
			transactionNo=t+1;
             } 
			
			System.out.println("TransactionNo: "+ transactionNo);
			queryTransaction = "INSERT INTO transaction VALUES ("+transactionNo+","+UserID+",'"+Status+"',"+Fee+","+Salary+","+Month+","+Year+",'"+PaidDate+"',"+AdminId+");"; 
			flagtransaction=true;
			}
			catch(Exception ex)
			{
			flagtransaction=true;
			System.out.println("Error:xxx "+ ex.getMessage());
			queryTransaction = "INSERT INTO transaction VALUES ("+transactionNo+","+UserID+",'"+Status+"',"+Fee+","+Salary+","+Month+","+Year+",'"+PaidDate+"',"+AdminId+");"; 
			System.out.println("TransactionNo:xxx "+ transactionNo);
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
	
	public void Back()
	{
    JOptionPane.showMessageDialog(this, "Succesfully Sumbited");
	JOptionPane.showMessageDialog(this, "USer Id : "+UserIdTF.getText() +"& Default Password : " +String.valueOf(Password));
	
	flagDB=true;
	
	CreateAccount acc = new CreateAccount(AdminId);  
	try{
	this.setVisible(false);
	acc.setVisible(true);
	}catch(Exception ex){}
	}


}