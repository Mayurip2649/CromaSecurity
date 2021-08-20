import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import myUtility.*;
import BackUI.*;
//import ConfigSetting.*;
import HtmlSetting.*;
import InputRestriction.*;

public class frmResetPassword extends JFrame implements ActionListener
{

	JLabel lblHeading,lblForgotPassword;//,lblWelcome;
	JLabel lblWelcome,lblWelcomeUser,lblYourPassword,lblSelectColorScheme;
	JTextField txtYourPassword,txtUserName,txtSecurityQuestion,txtAnswer;
	JPanel DataPanel,DataPanel1,pnlGetColor;
	JButton AHN[],btnNext,btnProceed;
	JLabel lblUserName,lblPass,lblRepeatPass,lblAnswer;
	JTextField txtPass,txtRepeatPassword;
	JComboBox cmbMonth,cmbGender,cmbCountry,cmbDay,cmbSelectColorScheme;
	EntryPanelGP2 EP;
	JButton btnColorButton[],btnNewScheme,btnApplyNewScheme,btnSave;
	JPanel MainPanel,pnlSecurityQuestion,pnlAnswer,pnlLeftColorBackground,pnlRightColorBackground;
	JLabel lblSecurityQuestion,lblSecurityAnswer,lblLeftColorBackground,lblRightColorBackground;
	JComboBox cmbSecurityQuestion;
	JTextField txtSecurityAnswer;

	int y=5,gap=25,h=25;
	int vSecurityQuestionID,SelectedSchemeCode=0,vCountryID;
	clsNewUserForm obj;
	frmResetPassword(clsNewUserForm temp1)
	{
		this.obj=temp1;
		setLayout(null);
		Dimension s=ScreenSize.getScreenSize();
		Color outer=new Color(117,216,244);

		EP=new EntryPanelGP2();
		add(EP);

		MainPanel = EP.getCoverPanel();

		lblHeading=EP.getHeadingLabel();
		lblHeading.setText("Reset Your Password");
		HtmlStyle.applyH2(lblHeading);

       	DataPanel1=EP.getDataPanel();
		PanelState.visibleComponents(DataPanel1);


		DataPanel=EP.getDataPanel1();
		PanelState.disableComponents(DataPanel);

		pnlLeftColorBackground =new JPanel();
		pnlLeftColorBackground.setLayout(null);
//		pnlLeftColorBackground.setBackground(Color.RED);
		pnlLeftColorBackground.setBounds(0,0,508,866);
		MainPanel.add(pnlLeftColorBackground);

		lblLeftColorBackground=new JLabel(new ImageIcon("ResetBackground.png"));
		pnlLeftColorBackground.add(lblLeftColorBackground);
		lblLeftColorBackground.setBounds(0,0,508,866);

		pnlRightColorBackground =new JPanel();
		pnlRightColorBackground.setLayout(null);
	//	pnlRightColorBackground.setBackground(Color.RED);
		pnlRightColorBackground.setBounds(508,0,508,866);
		MainPanel.add(pnlRightColorBackground);

		lblRightColorBackground=new JLabel(new ImageIcon("ResetBackground.png"));
		pnlRightColorBackground.add(lblRightColorBackground);
		lblRightColorBackground.setBounds(0,0,508,866);

/*
		btnNewScheme= new JButton("Define New Scheme...");
		btnNewScheme.setBounds(20,y,300,h);
		DataPanel1.add(btnNewScheme);
		btnNewScheme.addActionListener(this);
*/
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
		lblUserName.setBounds(20,y+5,100,h);
		DataPanel1.add(lblUserName);

		txtUserName = new JTextField();
		txtUserName.setBounds(160,y+5,120,h);
		DataPanel1.add(txtUserName);
		y=y+h+(gap/2);

		lblPass= new JLabel("Password");
		lblPass.setBounds(20,y+5,100,h);
		DataPanel1.add(lblPass);

		txtPass= new JTextField();
		txtPass.setBounds(160,y+5,120,h);
		DataPanel1.add(txtPass);
		y=y+h+(gap/2);

		lblRepeatPass= new JLabel("Repeat Password");
		lblRepeatPass.setBounds(20,y+5,120,h);
		DataPanel1.add(lblRepeatPass);

		txtRepeatPassword= new JTextField();
		txtRepeatPassword.setBounds(160,y+5,120,h);
		DataPanel1.add(txtRepeatPassword);
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


		btnSave= new JButton("Reset Confirm");
		btnSave.setBounds(20,y,300,h);
		DataPanel1.add(btnSave);
		btnSave.addActionListener(this);

		addColourSchemeRecords(cmbSelectColorScheme);

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

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==cmbSecurityQuestion)
		{
			if(cmbSecurityQuestion.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(null,"Select Proper Security Question ....");
			}
			else
			{
				String sname=(String)cmbSecurityQuestion.getSelectedItem();
				vSecurityQuestionID=clsSecurityQuestion.getCodeFromName(sname);
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
					JOptionPane.showMessageDialog(null,txtUserName.getText());
					JOptionPane.showMessageDialog(null,txtPass.getText());
					txtPass.selectAll();
					txtPass.requestFocus();

				}
				else
				{



						obj.setUserName(txtUserName.getText());
						obj.setUserPassword(txtPass.getText());
						obj.setColorSchemeDataID(SelectedSchemeCode);
						obj.setSecurityQuestionID(vSecurityQuestionID);
						obj.setSecurityAnswer(txtSecurityAnswer.getText());
						dlsNewUserForm.updateNewUser(obj);

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
			txtRepeatPassword.setForeground(test);
			txtUserName.requestFocus();

		}

	}


	public static void main(String args[])
	{
		clsNewUserForm temp= clsNewUserForm.getNewUser(10);
		frmResetPassword F1=new frmResetPassword(temp);

	}

}