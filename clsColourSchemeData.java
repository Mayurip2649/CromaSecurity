import myUtility.*;
import DBManage.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class clsColourSchemeData
{
	private int mschemeDataID;
	private String mPatternName;
	private int mSchemeR;
	private int mSchemeG;
	private int mSchemeB;
	private int mSchemeID;


	void setschemeDataID(int value)
	{
		mschemeDataID=value;
	}

	int getschemeDataID()
	{
		return(mschemeDataID);
	}


	void setPatternName(String value)
	{

		mPatternName=value;
	}
	String getPatternName()
	{
		return(mPatternName);
	}

	void setSchemeR(int value)
	{
		mSchemeR=value;
	}

	int getSchemeR()
	{
		return(mSchemeR);
	}
	void setSchemeG(int value)
	{
		mSchemeG=value;
	}

	int getSchemeG()
	{
		return(mSchemeG);
	}
	void setSchemeB(int value)
	{
		mSchemeB=value;
	}

	int getSchemeB()
	{
		return(mSchemeB);
	}
	void setSchemeID(int value)
	{
		mSchemeID=value;
	}

	int getSchemeID()
	{
		return(mSchemeID);
	}


    static void showColourScheme(clsColourSchemeData temp)
	{
	   System.out.println("Scheme ID    :=> "+temp.getschemeDataID());
       System.out.println("Scheme Name  :=> "+temp.getPatternName());
       System.out.println("Scheme No   :=> "+temp.getSchemeR());
       System.out.println("Scheme ID    :=> "+temp.getSchemeG());
       System.out.println("Scheme ID    :=> "+temp.getSchemeB());
       System.out.println("Scheme ID    :=> "+temp.getSchemeID());

   }
    static void addNewSchemeData(clsColourSchemeData temp)
    {
		dlsColourSchemedata.addNewSchemeData(temp);
    }
    static int getAllRecordsCount()
    {
		return(dlsColourSchemedata.getAllRecordsCount());
	}
	static String[] getAllSchemeNameRecords()
	{

		return(dlsColourSchemedata.getAllSchemeNameRecords());

    }

	static int getCodeFromName(String value)
	{
		return(dlsColourSchemedata.getCodeFromName(value));
	}
	static String getNameFromCode(int value)
	{
			return(dlsColourSchemedata.getNameFromCode(value));
	}

	static boolean validateColourScheme(String Value)
	{
		return(dlsColourSchemedata.validateScheme(Value));
	}
	static clsColourSchemeData getScheme(int ColourSchemeCode)
	{
		return(dlsColourSchemedata.getScheme(ColourSchemeCode));
	}


	static Color getSelectedSchemeColor(int code)
	{
		return(dlsColourSchemedata.getSelectedSchemeColor(code));
	}
	static clsColourSchemeData[] getAllSchemes(int ColourSchemeCode)
	{
		return(dlsColourSchemedata.getAllSchemes(ColourSchemeCode));
	}

	static void updateScheme(clsColourSchemeData T)
	{
		dlsColourSchemedata.updateScheme(T);
	}
	/*public static void deleteColourScheme(clsColourScheme T)
	{
		dlsColourSchemedata.deleteScheme(T);
	}*/
	static void addColourSchemeRecords(JComboBox c)
	{
		String x[]=clsColourSchemeData.getAllSchemeNameRecords();
		c.removeAllItems();
		c.addItem("Select ColourScheme...");
		for(String ele:x)
		c.addItem(ele);
	}

    public static void main(String args[])
    {
		clsColourSchemeData temp=new clsColourSchemeData();
			   temp.setschemeDataID(0);
		       temp.setPatternName("abc");
		       temp.setSchemeR(2);
		       temp.setSchemeG(3);
		       temp.setSchemeB(4);
		       temp.setSchemeID(5);
clsColourSchemeData.addNewSchemeData(temp);
		//int no=clsColourSchemeData.getCodeFromName("abc");
		//System.out.println(no);

    }


}