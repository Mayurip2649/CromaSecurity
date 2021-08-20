import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import BackUI.*;
import myUtility.*;
import ConfigSetting.*;
import HtmlSetting.*;

public class frmForgotPassword extends JFrame implements ActionListener
{

	JLabel lblHeading,lblForgotPassword,lblLeftColorBackground,lblRightColorBackground;//,lblWelcome;
	JLabel lblSecurityQuestion,lblAnswer;
	JLabel lblProgramHeading;
	JTextField txtYourPassword,txtAnswer,txtSecurityQuestion;
	JButton btnReset;
	JPanel DataPanel,DataPanel1,DataPanel2,pnlSecurityQuestion,pnlAnswer,pnlLeftColorBackground,pnlRightColorBackground;
	JButton AHN[],btnNext;

	JPanel MainPanel;
	JPanel BasePanel;
	clsNewUserForm temp1;
	frmForgotPassword(clsNewUserForm temp1)
	{
		this.temp1=temp1;
		int y=5,h=25,gap=10;


		EntryPanelGP EP=new EntryPanelGP();
		setTitle("Graphics Password Management...");
		setLayout(null);


		Dimension s=ScreenSize.getScreenSize();
		setSize(s.width,s.height);

		add(EP);

		MainPanel = EP.getCoverPanel();

		DataPanel=EP.getDataPanel();
		PanelState.visibleComponents(DataPanel);

		pnlLeftColorBackground =new JPanel();
		pnlLeftColorBackground.setLayout(null);
//		pnlLeftColorBackground.setBackground(Color.RED);
		pnlLeftColorBackground.setBounds(0,0,508,866);
		MainPanel.add(pnlLeftColorBackground);

		lblLeftColorBackground=new JLabel(new ImageIcon("ColorBackground.png"));
		pnlLeftColorBackground.add(lblLeftColorBackground);
		lblLeftColorBackground.setBounds(0,0,508,866);

		pnlRightColorBackground =new JPanel();
		pnlRightColorBackground.setLayout(null);
	//	pnlRightColorBackground.setBackground(Color.RED);
		pnlRightColorBackground.setBounds(508,0,508,866);
		MainPanel.add(pnlRightColorBackground);

		lblRightColorBackground=new JLabel(new ImageIcon("ColorBackground.png"));
		pnlRightColorBackground.add(lblRightColorBackground);
		lblRightColorBackground.setBounds(0,0,508,866);


		lblProgramHeading=EP.getHeadingLabel();
		lblProgramHeading.setText("Reset Your Password");
		HtmlStyle.applyH2(lblProgramHeading);


		lblSecurityQuestion=new JLabel("<html><h3>Security Question</h3></html>");
		lblSecurityQuestion.setBounds(20,y,200,h);
		DataPanel.add(lblSecurityQuestion);
		y=y+gap+h;

		String Sname=clsSecurityQuestion.getNameFromCode(temp1.getSecurityQuestionID());
		txtSecurityQuestion=new JTextField(Sname);
		txtSecurityQuestion.setEditable(false);
		txtSecurityQuestion.setBounds(20,y+10,300,h);
		txtSecurityQuestion.setBackground(new Color(214,240,245));
		txtSecurityQuestion.setBorder(null);
		txtSecurityQuestion.setForeground(Color.red);
		DataPanel.add(txtSecurityQuestion);
        y=y+gap+h;

		pnlSecurityQuestion=new JPanel();
		pnlSecurityQuestion.setLayout(null);
		pnlSecurityQuestion.setBackground(new Color(117,216,244));
		pnlSecurityQuestion.setBounds(20,90,300,2);
		DataPanel.add(pnlSecurityQuestion);
		y=y+gap+h;

		lblAnswer=new JLabel("<html><h3>Answer</h3></html>");
		lblAnswer.setBounds(20,y,100,h);
		DataPanel.add(lblAnswer);
		y=y+h;

		txtAnswer=new JTextField();
		txtAnswer.setBounds(20,y,300,h);
		txtAnswer.setBorder(null);
		txtAnswer.setBackground(new Color(214,240,245));
		DataPanel.add(txtAnswer);
		y=y+h+gap;


		pnlAnswer=new JPanel();
		pnlAnswer.setLayout(null);
		pnlAnswer.setBackground(new Color(117,216,244));
		pnlAnswer.setBounds(20,y,300,2);
		DataPanel.add(pnlAnswer);
		y=y+h+gap;

		btnReset=new JButton("<html><h3>Verify Answer</h3></html>");
		DataPanel.add(btnReset);
		btnReset.setBounds(180,y,140,h+10);
		//btnLogin.setBackground(new Color(214,240,245));
		btnReset.setBorder(null);
		btnReset.addActionListener(this);
		btnReset.setBackground(new Color(112,146,190));
		btnReset.setForeground(Color.white);



		setVisible(true);


	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnReset)
		{
			if(txtAnswer.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"Please Enter Your Answer ... ");
				txtAnswer.requestFocus();
			}
			else
			{
				if(txtAnswer.getText().equals(temp1.getSecurityAnswer()))
				{
					JOptionPane.showMessageDialog(null,"Croma Password Allow To Reset The Password... ");
					frmResetPassword F1=new frmResetPassword(temp1);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Security Answer Provided By You is Wrong... ");
					JOptionPane.showMessageDialog(null,"Please Try Again... ");
					txtAnswer.selectAll();
					txtAnswer.requestFocus();
				}
			}

		}
	}

	public static void main(String args[])
	{
		clsNewUserForm temp=clsNewUserForm.getNewUser(9);
		frmForgotPassword A = new frmForgotPassword(temp);

	}
}