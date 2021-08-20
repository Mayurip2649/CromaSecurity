import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import myUtility.*;
import ConfigSetting.*;
import HtmlSetting.*;
import javax.swing.*;

public class frmMainUI extends JFrame implements ActionListener
{
	JButton btnSignUp,btnSignIn;
	JPanel pnlBackground;
	JLabel lblBackground;

	frmMainUI()
	{

		setLayout(null);
		Dimension s=ScreenSize.getScreenSize();

		EntryPanel ep=new EntryPanel(Color.white);
		add(ep);

		btnSignUp=ep.getSignUP();
		btnSignUp.addActionListener(this);

		btnSignIn=ep.getSignIn();
		btnSignIn.addActionListener(this);

		pnlBackground =new JPanel();
		pnlBackground.setLayout(null);
		pnlBackground.setBackground(Color.RED);
		pnlBackground.setBounds(0,106,1020,582);
		ep.add(pnlBackground);

		lblBackground=new JLabel(new ImageIcon("Background.png"));
		pnlBackground.add(lblBackground);
		lblBackground.setBounds(0,0,1020,582);


		setSize(s.width,s.height);
		setTitle("Chroma Security");
		setVisible(true);


	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnSignUp)
		{
			//frmMainEntryForm obj = new frmMainEntryForm();
			frmNewUserForm obj = new frmNewUserForm ();


			//add(new frmNewUserForm());
			//nu.setVisible(true);

		}
		else if(ae.getSource()==btnSignIn)
		{
			frmSignIn obj = new frmSignIn ();

		}
	}
	public static void main(String args[])
	{
		frmMainUI A=new frmMainUI();

	}

}