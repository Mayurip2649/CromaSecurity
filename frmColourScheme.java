import HtmlSetting.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import myUtility.*;
import java.util.Random;
import BackUI.*;

public class frmColourScheme extends JFrame implements ActionListener
{
	JLabel lblColourSetting,lblSetColourDetails,lblCS1R,lblCS1G,lblCS1B;
	//lblCS2No,lblCS3No,lblCS4No,lblCS5No,lblCS1No;
	JPanel MainPanel,DataPanel,ColorSchemePanel;
	JButton btnDefineNewScheme,btnApply,btnSave;
	//JTextField txtCS1R,txtCS1G,txtCS1B,txtCS2R,txtCS2G,txtCS2B,txtCS3R,txtCS3G,txtCS3B,txtCS4R,txtCS5R;
   // ReportTool tool;
	JLabel lblSerial[];
	JTextField txtColorScheme[][];
	JPanel pnlColorDisply[];
	int NewSchemeNo=0,vSchemeID;
	String RecentSchemeName="";

	int width,height;
	EntryPanelGP EP;
	frmColourScheme()
	{
		int h=20,gap=25,y=50;
		setLayout(null);

	    Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension d=tk.getScreenSize();
		setLayout(null);

		width=d.width;
		height=d.height;

		EP=new EntryPanelGP();
		add(EP);





		MainPanel=EP.getCoverPanel();
		DataPanel=EP.getDataPanel();
		//CS1Panel=EP.getCS1Panel();
		//CS1S1Panel=EP.getCS1S1Panel();
		PanelState.visibleComponents(DataPanel);

	    lblColourSetting=EP.getHeadingLabel();
	    lblColourSetting.setText("Colour Scheme");
		HtmlStyle.applyH2(lblColourSetting);


	    btnDefineNewScheme=new JButton("Define new Scheme");
		DataPanel.add(btnDefineNewScheme);
		btnDefineNewScheme.setBounds(50,y,200,h+10);
		btnDefineNewScheme.addActionListener(this);
		y=y+gap+h;

    	lblSetColourDetails=new JLabel("Set Colour Details of -----------");
		lblSetColourDetails.setBounds(50,y,250,h);
		DataPanel.add(lblSetColourDetails);
		y=y+gap+h;

		lblCS1R=new JLabel("R");
		lblCS1R.setBounds(102,y,40,h);
		DataPanel.add(lblCS1R);


		lblCS1G=new JLabel("G");
		lblCS1G.setBounds(157,y,40,h);
		DataPanel.add(lblCS1G);

		lblCS1B=new JLabel("B");
		lblCS1B.setBounds(217,y,80,h);
		DataPanel.add(lblCS1B);
		y=y+gap+h;

		ColorSchemePanel=new JPanel();
		ColorSchemePanel.setLayout(new GridLayout(6,5,5,5));
		ColorSchemePanel.setBounds(20,165,290,200);
		ColorSchemePanel.setBackground(new Color(100,100,100,6));
		DataPanel.add(ColorSchemePanel);

	    btnApply=new JButton("Apply Scheme");
		DataPanel.add(btnApply);
		btnApply.setBounds(50,385,200,h+10);
		btnApply.addActionListener(this);


	    btnSave=new JButton("Save Scheme");
		DataPanel.add(btnSave);
		btnSave.setBounds(50,425,200,h+10);
		btnSave.addActionListener(this);

		lblSerial = new JLabel[6];
		txtColorScheme=new JTextField[6][3];
		pnlColorDisply=new JPanel[6];

		int i,j;

		for(i=0;i<6;i++)
		{
			lblSerial[i]=new JLabel(String.valueOf(i+1));
			ColorSchemePanel.add(lblSerial[i]);
			for(j=0;j<3;j++)
			{

				txtColorScheme[i][j]=new JTextField("0");
				ColorSchemePanel.add(txtColorScheme[i][j]);
			}
			pnlColorDisply[i]=new JPanel();
			ColorSchemePanel.add(pnlColorDisply[i]);
		}

		PanelState.hideComponents(ColorSchemePanel);



		setSize(d.width,d.height);
		setVisible(true);




    }

    public void actionPerformed(ActionEvent ae)
    {
		if(ae.getSource()==btnApply)
		{
			int i,Rvalue,Gvalue,Bvalue;

			for(i=0;i<6;i++)
			{
				Rvalue=Integer.parseInt(txtColorScheme[i][0].getText());
				Gvalue=Integer.parseInt(txtColorScheme[i][1].getText());
				Bvalue=Integer.parseInt(txtColorScheme[i][2].getText());
				pnlColorDisply[i].setBackground(new Color(Rvalue,Gvalue,Bvalue));
			}
		}
		else if(ae.getSource()==btnDefineNewScheme)
		{
			NewSchemeNo=clsColourScheme.getMaximumSchemeNo()+1;

			RecentSchemeName="Scheme-"+String.valueOf(NewSchemeNo);
			lblSetColourDetails.setText("Set Details of Scheme ["+RecentSchemeName+"]");

			PanelState.showComponents(ColorSchemePanel);

			Random randno = new Random();

			int i,j;
			for(i=0;i<6;i++)
			{
				for(j=0;j<3;j++)
				{
					int c1=randno.nextInt(255);
					txtColorScheme[i][j].setText(String.valueOf(c1));
				}
			}
			setSize(width-1,height-1);
			setSize(width+1,height+1);

		}
		else if(ae.getSource()==btnSave)
		{
			clsColourScheme temp=new clsColourScheme();
			temp.setschemeID(0);
			temp.setSchemeName(RecentSchemeName);
			temp.setSchemeNo(NewSchemeNo);

			if(clsColourScheme.isNewScheme(RecentSchemeName))
			{
				clsColourScheme.addNewScheme(temp);
				vSchemeID=clsColourScheme.getCodeFromName(RecentSchemeName);
				clsColourSchemeData temp1=new clsColourSchemeData();
				for(int i=0;i<6;i++)
				{
					temp1.setschemeDataID(0);
					String Subset="S"+String.valueOf(NewSchemeNo)+"Set-"+String.valueOf(i+1);
		    		temp1.setPatternName(Subset);
		    		temp1.setSchemeR(Integer.parseInt(txtColorScheme[i][0].getText()));
		    		temp1.setSchemeG(Integer.parseInt(txtColorScheme[i][1].getText()));
		    		temp1.setSchemeB(Integer.parseInt(txtColorScheme[i][2].getText()));
		    		temp1.setSchemeID(vSchemeID);
					clsColourSchemeData.addNewSchemeData(temp1);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"The Scheme Is Already Define/Created");
			}
		}

	}

    public static void main(String args[])
	{
	    frmColourScheme F1=new frmColourScheme();

	}

}
