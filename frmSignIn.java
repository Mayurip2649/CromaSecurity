import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import BackUI.*;
import myUtility.*;
import ConfigSetting.*;
import HtmlSetting.*;

public class frmSignIn extends JFrame implements ActionListener
{

	JLabel lblHeading,lblForgotPassword;//,lblWelcome;
	JLabel lblSignIn,lblToContinueToYourAccount,lblSelectColorScheme,lblUserName,lblPassword;
	JLabel lblProgramHeading,lblLeftColorBackground,lblRightColorBackground;
	JTextField txtUserName;
	JPasswordField txtPassword;
	JComboBox cmbSelectColorScheme;
	JPanel MainPanel,DataPanel,StatusPanel,StatusPanel1,DataPanel1,DataPanel2,pnlUserName,pnlGetColor,pnlPassword;
	JPanel pnlLeftColorBackground,pnlRightColorBackground;
	JButton btnLogin,btnForgotPassword;
	JButton btnColorButton[];
	int SelectedSchemeCode=0;

	frmSignIn()
	{
		SelectedSchemeCode=0;
		int y=20,gap=10,h=25;
		EntryPanelGP EP=new EntryPanelGP();
		setTitle("Graphics Password Management...");
		setLayout(null);


		Dimension s=ScreenSize.getScreenSize();
		setSize(s.width,s.height);

		add(EP);

		lblHeading=EP.getHeadingLabel();
		lblHeading.setText("Welcome User");
		HtmlStyle.applyH2(lblHeading);



		MainPanel = EP.getCoverPanel();

		DataPanel=EP.getDataPanel();
		StatusPanel=EP.getStatusPanel();
		StatusPanel1=EP.getStatusPanel();

		PanelState.visibleComponents(DataPanel);
		PanelState.disableComponents(StatusPanel);
		PanelState.disableComponents(StatusPanel1);
		//PanelState.visibleComponents(MainPanel);

        lblSignIn = new JLabel("<html><h2>Sign In</h2></html>");
		lblSignIn.setBounds(20,y,80,h);
		DataPanel.add(lblSignIn);
		y=y+gap+h;

		lblToContinueToYourAccount = new JLabel("To Continue To Your Account");
		lblToContinueToYourAccount.setBounds(20,y-5,200,h);
		DataPanel.add(lblToContinueToYourAccount);
		y=y+30+h;

		pnlLeftColorBackground =new JPanel();
		pnlLeftColorBackground.setLayout(null);
//		pnlLeftColorBackground.setBackground(Color.RED);
		pnlLeftColorBackground.setBounds(0,0,508,866);
		MainPanel.add(pnlLeftColorBackground);

		lblLeftColorBackground=new JLabel(new ImageIcon("SignInBackground.png"));
		pnlLeftColorBackground.add(lblLeftColorBackground);
		lblLeftColorBackground.setBounds(0,0,508,866);

		pnlRightColorBackground =new JPanel();
		pnlRightColorBackground.setLayout(null);
	//	pnlRightColorBackground.setBackground(Color.RED);
		pnlRightColorBackground.setBounds(508,0,508,866);
		MainPanel.add(pnlRightColorBackground);

		lblRightColorBackground=new JLabel(new ImageIcon("SignInBackground.png"));
		pnlRightColorBackground.add(lblRightColorBackground);
		lblRightColorBackground.setBounds(0,0,508,866);


		lblSelectColorScheme= new JLabel("Select Scheme");
		lblSelectColorScheme.setBounds(20,y,120,h+5);

		DataPanel.add(lblSelectColorScheme);

		cmbSelectColorScheme = new JComboBox();
		cmbSelectColorScheme.setBounds(130,y,120,h);
		DataPanel.add(cmbSelectColorScheme);
		cmbSelectColorScheme.addActionListener(this);
		y=y+30+h;

		pnlGetColor=new JPanel();
		pnlGetColor.setLayout(new GridLayout(1,6,5,5));
	//	pnlGetColor.setBackground(Color.YELLOW);
		pnlGetColor.setBackground(new Color(214,240,245));
		pnlGetColor.setBounds(20,150,265,50);
		DataPanel.add(pnlGetColor);

		btnColorButton= new JButton[6];
		for(int i=0;i<6;i++)
		{
			btnColorButton[i]=new JButton();
			btnColorButton[i].setBackground(new Color(214,240,245));
			btnColorButton[i].addActionListener(this);
			pnlGetColor.add(btnColorButton[i]);
		}

		lblUserName = new JLabel("<html><h3>Username:</h3></html>");
		lblUserName.setBounds(20,230,200,h);
		DataPanel.add(lblUserName);
		y=y+30+h;

		pnlUserName=new JPanel();
		pnlUserName.setLayout(null);
		pnlUserName.setBackground(new Color(117,216,244));
		pnlUserName.setBounds(20,293,300,2);
		DataPanel.add(pnlUserName);
		y=y+30+h;

		txtUserName = new JTextField();
		txtUserName.setBounds(20,257,300,h+10);
		txtUserName.setBorder(null);
		txtUserName.setBackground(new Color(214,240,245));
		DataPanel.add(txtUserName);
		y=y+gap+h;

		lblPassword = new JLabel("<html><h3>Password:</h3></html>");
		lblPassword.setBounds(20,310,200,h);
		DataPanel.add(lblPassword);
		y=y+30+h;

		pnlPassword=new JPanel();
		pnlPassword.setLayout(null);
		pnlPassword.setBackground(new Color(117,216,244));
		pnlPassword.setBounds(20,376,300,2);
		DataPanel.add(pnlPassword);
		y=y+30+h;

		txtPassword = new JPasswordField();
		txtPassword.setBounds(20,340,300,h+10);
		txtPassword.setBorder(null);
		txtPassword.setBackground(new Color(214,240,245));
		DataPanel.add(txtPassword);
		y=y+gap+h;

		btnForgotPassword=new JButton("<html><h3>Forgot CromaPassword?</h3></html>");
		DataPanel.add(btnForgotPassword);
		btnForgotPassword.setBounds(10,420,200,h+10);//385
		//btnForgotPassword.setBackground(new Color(214,240,245));
		btnForgotPassword.setBackground(new Color(112,146,190));
		btnForgotPassword.setForeground(Color.white);

		btnForgotPassword.setBorder(null);
		btnForgotPassword.addActionListener(this);

		btnLogin=new JButton("<html><h3>LogIn</h3></html>");

		DataPanel.add(btnLogin);
		btnLogin.setBounds(230,420,90,h+10);
//		btnLogin.setBackground(new Color(214,240,245));
		btnLogin.setBackground(new Color(112,146,190));
		btnLogin.setForeground(Color.white);

		btnLogin.setBorder(null);
		btnLogin.addActionListener(this);

		setVisible(true);
		addColourSchemeRecords(cmbSelectColorScheme);

	}

	void addColourSchemeRecords(JComboBox c)
	{
		c.removeActionListener(this);
		clsColourScheme.addColourSchemeRecords(c);
		c.addActionListener(this);
	}




	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnForgotPassword)
		{
			if(txtUserName.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"User Name Should Not Blank....");
				txtUserName.requestFocus();
			}
			else if(txtPassword.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"Password Should Not Blank....");
				txtPassword.requestFocus();
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
				int code=clsNewUserForm.getCodeFromUserName(txtUserName.getText());
				if(code==0)
				{
					JOptionPane.showMessageDialog(null,"User Not Exist.....To Reset The Password... ");
				}
				else
				{
					clsNewUserForm temp=clsNewUserForm.getNewUser(code);
					frmForgotPassword obj=new frmForgotPassword (temp);
				}
			}
		}
		else if(ae.getSource()==btnLogin)
		{
			//JOptionPane.showMessageDialog(null,ae.getActionCommand());
//			lblHeading.setText("Login Window");
//			HtmlStyle.applyH1(lblHeading);
//			PanelState.disableComponents(DataPanel);
//			PanelState.visibleComponents(DataPanel1);
//			lblSignIn.setText(ae.getActionCommand());
//			HtmlStyle.applyH2(lblSignIn);
			if(txtUserName.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"User Name Should Not Blank....");
				txtUserName.requestFocus();
			}
			else if(txtPassword.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"Password Should Not Blank....");
				txtPassword.requestFocus();
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

				int code=clsNewUserForm.getCodeFromUserName(txtUserName.getText());
				int code1=clsNewUserForm.getVerification(txtUserName.getText(),txtPassword.getText());
				if(code==0 || code1==0)
					JOptionPane.showMessageDialog(null,"Croma Security Unable To Login ..... ");
				else
				{
					JOptionPane.showMessageDialog(null,"Croma Security Verifies Your Color Scheme..... ");
					int OriginalCode=clsNewUserForm.getColorSchemeCode(code);
					if(OriginalCode==SelectedSchemeCode)
					{
						JOptionPane.showMessageDialog(null,"Congratulations..... You are verified By Croma Security ");
						PanelState.disableComponents(DataPanel);
						PanelState.visibleComponents(StatusPanel);

					}
					else
					{
						JOptionPane.showMessageDialog(null,"Unable To Login.....Because Of Strong Color Security Of Croma ");
						PanelState.disableComponents(DataPanel);
						PanelState.visibleComponents(StatusPanel1);

					}
				}
			}
		}
		else if(ae.getSource()==cmbSelectColorScheme)
		{
			if(cmbSelectColorScheme.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(null,"Select Proper Color Scheme ....");
				SelectedSchemeCode=0;
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
			Color test=clsColourSchemeData.getSelectedSchemeColor(SelectedSchemeCode);
			txtUserName.setForeground(test);
			txtPassword.setForeground(test);
		}
	}

	public static void main(String args[])
	{
		//add(new frmMainEntryForm());
		frmSignIn A = new frmSignIn();

	}
}