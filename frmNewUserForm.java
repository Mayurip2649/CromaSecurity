import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import myUtility.*;
import BackUI.*;
//import ConfigSetting.*;
import HtmlSetting.*;
import InputRestriction.*;

public class frmNewUserForm extends JFrame implements ActionListener
{

	JLabel lblHeading,lblForgotPassword;//,lblWelcome;
	JLabel lblWelcome,lblWelcomeUser,lblYourPassword,lblSelectColorScheme;
	JTextField txtYourPassword;
	JPanel DataPanel,DataPanel1,pnlGetColor;
	JButton AHN[],btnNext,btnProceed;
	JLabel lblName,lblLastName,lblBirthDate,lblGender,lblUserName,lblPass,lblRepeatPass,lblEmailID,lblCountry;
	JTextField txtName,txtLastName,txtUserName,txtEmailID,txtDay,txtYear;
	JPasswordField txtPass,txtRepeatPass;
	JComboBox cmbMonth,cmbGender,cmbCountry,cmbDay,cmbSelectColorScheme;
	EntryPanelGP2 EP;
	JButton btnColorButton[],btnNewScheme,btnApplyNewScheme,btnSave;
	JPanel MainPanel;
	JLabel lblSecurityQuestion,lblSecurityAnswer;
	JComboBox cmbSecurityQuestion;
	JTextField txtSecurityAnswer;

	int y=50,gap=25,h=25;
	int vSecurityQuestionID,SelectedSchemeCode=0,vCountryID;
	frmNewUserForm()
	{
		setLayout(null);
		Dimension s=ScreenSize.getScreenSize();
		Color outer=new Color(117,216,244);

		EP=new EntryPanelGP2();
		add(EP);

		MainPanel = EP.getCoverPanel();

		lblHeading=EP.getHeadingLabel();
		lblHeading.setText("Create New Account");
		HtmlStyle.applyH2(lblHeading);

       	DataPanel=EP.getDataPanel();
		PanelState.visibleComponents(DataPanel);


		DataPanel1=EP.getDataPanel1();
		PanelState.disableComponents(DataPanel1);

		lblName = new JLabel("Name");
		lblName.setBounds(20,y,80,h);
		DataPanel.add(lblName);

		lblName = new JLabel("Last Name");
		lblName.setBounds(180,y,80,h);
		DataPanel.add(lblName);

		y=y+10+h;
		txtName = new JTextField();
		txtName.addKeyListener(new OnlyText());
		txtName.setBounds(20,y,140,h);
		DataPanel.add(txtName);

		txtLastName = new JTextField();
		txtLastName.setBounds(180,y,140,h);
		DataPanel.add(txtLastName);

		y=y+h+gap;
		lblBirthDate = new JLabel("Birth Date");
		lblBirthDate.setBounds(20,y,60,h);
		DataPanel.add(lblBirthDate);

		cmbMonth = new JComboBox();
		cmbMonth.setBounds(130,y,70,h);
		//cmbMonth.addActionListener(this);
		DataPanel.add(cmbMonth);
		cmbMonth.addItem("Month");
		cmbMonth.addItem("JAN");
		cmbMonth.addItem("FEB");
		cmbMonth.addItem("MARCH");
		cmbMonth.addItem("APRL");
		cmbMonth.addItem("MAY");
		cmbMonth.addItem("JUNE");
		cmbMonth.addItem("JULY");
		cmbMonth.addItem("AUG");
		cmbMonth.addItem("SEP");
		cmbMonth.addItem("OCT");
		cmbMonth.addItem("NOV");
		cmbMonth.addItem("DEC");

		txtDay = new JTextField("DAY");
		txtDay.setBounds(210,y,40,h);
		DataPanel.add(txtDay);

		cmbDay = new JComboBox();
		cmbDay.setBounds(210,y,40,h);
		DataPanel.add(cmbDay);
		for(int i=1;i<=31;i++)
		{
			cmbDay.addItem(i);
		}

		txtYear = new JTextField("YYYY");
		txtYear.setBounds(260,y,60,h);
		DataPanel.add(txtYear);


		y=y+h+gap;
		lblGender = new JLabel("Gender");
		lblGender.setBounds(20,y,80,h);
		DataPanel.add(lblGender);


		cmbGender = new JComboBox();
		cmbGender.setBounds(130,y,120,h);
		DataPanel.add(cmbGender);

		cmbGender.addItem("Select Gender");

		cmbGender.addItem("Male");
		cmbGender.addItem("Female");
		y=y+h+gap;



		//y=y+h+gap;

		lblEmailID= new JLabel("Email ID");
		lblEmailID.setBounds(20,y,100,h);
		DataPanel.add(lblEmailID);

		txtEmailID= new JTextField();
		txtEmailID.setBounds(130,y,190,h);
		DataPanel.add(txtEmailID);

		y=y+h+gap;
		lblCountry= new JLabel("Country");
		lblCountry.setBounds(20,y,120,h);
		DataPanel.add(lblCountry);

		cmbCountry = new JComboBox();
		cmbCountry.setBounds(130,y,120,h);
		DataPanel.add(cmbCountry);
		cmbCountry.addActionListener(this);

		y=y+h+gap;
		btnProceed=new JButton("Proceed To Set Chroma Password");
		btnProceed.setBackground(new Color(112,146,190));
		btnProceed.setForeground(Color.white);
		btnProceed.setBounds(20,y+30,300,h+10);
		DataPanel.add(btnProceed);
		btnProceed.addActionListener(this);

		y=10;

		btnNewScheme= new JButton("Define New Scheme...");
		btnNewScheme.setBounds(20,y,300,h);
		DataPanel1.add(btnNewScheme);
		btnNewScheme.addActionListener(this);

		btnApplyNewScheme= new JButton("Reset Schemes To Apply...");
		btnApplyNewScheme.setBounds(20,y,300,h);
		DataPanel1.add(btnApplyNewScheme);
		btnApplyNewScheme.addActionListener(this);
		btnApplyNewScheme.setVisible(false);



		y=y+gap+h;



		lblSelectColorScheme= new JLabel("Select Scheme");
		lblSelectColorScheme.setBounds(20,y,120,h);

		DataPanel1.add(lblSelectColorScheme);

		cmbSelectColorScheme = new JComboBox();
		cmbSelectColorScheme.setBounds(120,y,200,h);
		DataPanel1.add(cmbSelectColorScheme);
		cmbSelectColorScheme.addActionListener(this);
//Nitin

		y=y+gap+h;

		pnlGetColor=new JPanel();
		pnlGetColor.setLayout(new GridLayout(1,6,5,5));
		//pnlGetColor.setBackground(Color.YELLOW);
		pnlGetColor.setBackground(new Color(214,240,245));
		pnlGetColor.setBounds(35,100,265,50);
		DataPanel1.add(pnlGetColor);

//		clsColourSchemeData[]=clsColourSchemeData.getAllSchemes(1);
		btnColorButton= new JButton[6];
		for(int i=0;i<6;i++)
		{
			btnColorButton[i]=new JButton();
			btnColorButton[i].setBackground(new Color(214,240,245));
			btnColorButton[i].addActionListener(this);
			pnlGetColor.add(btnColorButton[i]);
		}

		y=y+35+h;

		lblUserName= new JLabel("User Name");
		lblUserName.setBounds(20,y,100,h);

		DataPanel1.add(lblUserName);

		txtUserName = new JTextField();
		txtUserName.setBounds(160,y,120,h);

		DataPanel1.add(txtUserName);



		y=y+h+(gap/2);
		lblPass= new JLabel("Password");
		lblPass.setBounds(20,y,100,h);

		DataPanel1.add(lblPass);

		txtPass= new JPasswordField();
		txtPass.setBounds(160,y,120,h);

		DataPanel1.add(txtPass);

		y=y+h+(gap/2);
		lblRepeatPass= new JLabel("Repeat Password");
		lblRepeatPass.setBounds(20,y,120,h);

		DataPanel1.add(lblRepeatPass);

		txtRepeatPass= new JPasswordField();
		txtRepeatPass.setBounds(160,y,120,h);

		DataPanel1.add(txtRepeatPass);

		y=y+h+gap;
		lblSecurityQuestion= new JLabel("Please Select The Security Question");
		lblSecurityQuestion.setBounds(20,y,250,h);
		y=y+h;//+(gap/2);

		DataPanel1.add(lblSecurityQuestion);

		cmbSecurityQuestion= new JComboBox();
		cmbSecurityQuestion.setBounds(20,y,250,h);
		DataPanel1.add(cmbSecurityQuestion);
		addSecurityQuestionRecords(cmbSecurityQuestion);

		y=y+h+(gap/2);
		lblSecurityAnswer= new JLabel("Enter Your Security Answer");
		lblSecurityAnswer.setBounds(20,y,250,h);

		DataPanel1.add(lblSecurityAnswer);
		y=y+h;
		txtSecurityAnswer= new JTextField();
		txtSecurityAnswer.setBounds(20,y,250,h);
		DataPanel1.add(txtSecurityAnswer);


		y=y+h+gap;


		btnSave= new JButton("Save User");
		btnSave.setBounds(20,y,300,h);
		DataPanel1.add(btnSave);
		btnSave.addActionListener(this);


		addCountryRecords(cmbCountry);


/*
		JPanel base=new JPanel();


		DataPanel=EP.getBasePanel();










		add(base);
		*/


		setSize(s.width,s.height);
		setTitle("Chroma Security...");
		setVisible(true);

	}


	void addColourSchemeRecords(JComboBox c)
	{
		c.removeActionListener(this);
		clsColourScheme.addColourSchemeRecords(c);
		c.addActionListener(this);
	}

	void addSecurityQuestionRecords(JComboBox c)
	{
		c.removeActionListener(this);
		clsSecurityQuestion.addSecurityQuestionRecords(c);
		c.addActionListener(this);
	}



	void addCountryRecords(JComboBox c)
	{
		String data[]=clsCountry.getAllCountryNameRecords();
		c.removeActionListener(this);
		c.removeAllItems();
		c.addItem("select Country ...");
		for(String Item:data)
		{
			c.addItem(Item);

		}
		c.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
			//JOptionPane.showMessageDialog(null,ae.getActionCommand());
			/*lblHeading.setText("Login Window");
			HtmlStyle.applyH1(lblHeading);
			PanelState.disableComponents(DataPanel);
			lblWelcomeUser.setText(ae.getActionCommand());
			HtmlStyle.applyH2(lblWelcomeUser);
*/
			if(ae.getSource()==cmbMonth)
			{
				if(cmbMonth.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(null,"Select Proper Month");
				}
				else
				{

				}
			}
			else if(ae.getSource()==cmbCountry)
			{
				if(cmbCountry.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(null,"Select Proper Month");
				}
				else
				{
					vCountryID=clsCountry.getCodeFromName((String)cmbCountry.getSelectedItem());

				}

			}
			else if(ae.getSource()==cmbSecurityQuestion)
			{
				if(cmbSecurityQuestion.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(null,"Select Proper Security Questions...");
				}
				else
				{
					vSecurityQuestionID=clsSecurityQuestion.getCodeFromName((String)cmbSecurityQuestion.getSelectedItem());

				}

			}


			else if(ae.getSource()==cmbSelectColorScheme)
			{
				if(cmbSelectColorScheme.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(null,"Select Proper Color Scheme ....");
				}
				else
				{
					String sname=(String)cmbSelectColorScheme.getSelectedItem();
					int scode=clsColourScheme.getCodeFromName(sname);
					clsColourSchemeData Cdata[]=clsColourSchemeData.getAllSchemes(scode);

					for(int i=0;i<6;i++)
					{
						int R1=Cdata[i].getSchemeR();
						int G1=Cdata[i].getSchemeG();
						int B1=Cdata[i].getSchemeB();
						btnColorButton[i].setBackground(new Color(R1,G1,B1));
						btnColorButton[i].setActionCommand(Cdata[i].getPatternName());

					}
				}

			}
			else if(ae.getSource()==btnProceed)
			{
				if(txtName.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Name Should Not Blank....");
					txtName.requestFocus();
				}
				else if(txtLastName.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Last Name Should Not Blank....");
					txtLastName.requestFocus();
				}
				else
				{
					PanelState.disableComponents(DataPanel);
					PanelState.visibleComponents(DataPanel1);
					addColourSchemeRecords(cmbSelectColorScheme);
				}
			}
			else if(ae.getSource()==btnNewScheme)
			{
				frmColourScheme obj = new frmColourScheme();
				JOptionPane.showMessageDialog(null,"Please Apply This Scheme...");
				btnApplyNewScheme.setVisible(true);
				btnNewScheme.setVisible(false);
			}
			else if(ae.getSource()==btnSave)
			{
				if(txtUserName.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"User Name Should Not Blank....");
					txtUserName.requestFocus();
				}
				else if(txtPass.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Password Should Not Blank....");
					txtPass.requestFocus();
				}
				else if(cmbSelectColorScheme.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(null,"Please Select The Color Scheme....");
					cmbSelectColorScheme.requestFocus();
				}
				else if(SelectedSchemeCode==0)
				{
					JOptionPane.showMessageDialog(null,"Please Select The Color ....");
				}
				else
				{
					if(!txtUserName.getText().equals(txtPass.getText()))
					{
						JOptionPane.showMessageDialog(null,"Password and Repeate Password are not same");
						txtPass.selectAll();
						txtPass.requestFocus();

					}
					else
					{
						//,,,,,,,
						clsNewUserForm obj=new clsNewUserForm();
						obj.setUserID(0);
						obj.setFirstName(txtName.getText());
						obj.setLastName(txtLastName.getText());
						obj.setBirthMonth((String)cmbMonth.getSelectedItem());
						obj.setBirthDate(Integer.parseInt(txtDay.getText()));
						obj.setBirthYear(Integer.parseInt(txtYear.getText()));
						String g=(String)cmbGender.getSelectedItem();
						if(g.equals("Male"))
							obj.setGender(1);
						else
							obj.setGender(2);
						obj.setEmailID(txtEmailID.getText());
						obj.setCountryID(vCountryID);
						obj.setUserName(txtUserName.getText());
						obj.setUserPassword(txtPass.getText());
						obj.setColorSchemeDataID(SelectedSchemeCode);
						obj.setSecurityQuestionID(vSecurityQuestionID);
						obj.setSecurityAnswer(txtSecurityAnswer.getText());

						if(clsNewUserForm.getVerification(txtName.getText(),txtLastName.getText())==0)
						{
							dlsNewUserForm.addNewUser(obj);
							JOptionPane.showMessageDialog(null,"Wel-Come... "+txtName.getText());
							JOptionPane.showMessageDialog(null,"Now Close This Window"+txtName.getText());
							JOptionPane.showMessageDialog(null,"Sign In Again from Main Window"+txtName.getText());
						}
						else
						{
							JOptionPane.showMessageDialog(null,"User Already Registered ... "+txtName.getText());
						}
					}
				}

			}
			else if(ae.getSource()==btnApplyNewScheme)
			{
				btnApplyNewScheme.setVisible(false);
				btnNewScheme.setVisible(true);
				addColourSchemeRecords(cmbSelectColorScheme);
			}
			else
			{

				String SelectedScheme="";
				for(int i=0;i<6;i++)
				{
					if(ae.getSource()==btnColorButton[i])
					{
						SelectedScheme=btnColorButton[i].getActionCommand();
						break;
					}
				}
				SelectedSchemeCode=clsColourSchemeData.getCodeFromName(SelectedScheme);
				//JOptionPane.showMessageDialog(null,"Nitin shah Button Selected"+String.valueOf(SelectedScheme));
				Color test=clsColourSchemeData.getSelectedSchemeColor(SelectedSchemeCode);

				txtUserName.setForeground(test);
				txtPass.setForeground(test);
				txtRepeatPass.setForeground(test);
				txtUserName.requestFocus();

			}

	}

	public static void main(String args[])
	{
		frmNewUserForm F1=new frmNewUserForm();

	}
}