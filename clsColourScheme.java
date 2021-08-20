import myUtility.*;
import DBManage.*;
import javax.swing.*;
import java.awt.event.*;
class clsColourScheme
{
	private int mschemeID;
	private String mSchemeName;
	private int mSchemeNo;

	void setschemeID(int value)
	{
		mschemeID=value;
	}

	int getschemeID()
	{
		return(mschemeID);
	}


	void setSchemeName(String value)
	{

		mSchemeName=value;
	}
	String getSchemeName()
	{
		return(mSchemeName);
	}

	void setSchemeNo(int value)
	{
		mSchemeNo=value;
	}

	int getSchemeNo()
	{
		return(mSchemeNo);
	}


    static void showColourScheme(clsColourScheme temp)
	{
	   System.out.println("Scheme ID    :=> "+temp.getschemeID());
       System.out.println("Scheme Name  :=> "+temp.getSchemeName());
       System.out.println("Scheme No   :=> "+temp.getSchemeNo());

   }
    static void addNewScheme(clsColourScheme temp)
    {
		dlsColourScheme.addNewScheme(temp);
    }
    static int getAllRecordsCount()
    {
		return(dlsColourScheme.getAllRecordsCount());
	}
	static int getMaximumSchemeNo()
	{
		return(dlsColourScheme.getMaximumSchemeNo());
	}
	static String[] getAllSchemeNameRecords()
	{

		return(dlsColourScheme.getAllSchemeNameRecords());

    }

	static int getCodeFromName(String value)
	{
		return(dlsColourScheme.getCodeFromName(value));
	}
	static String getNameFromCode(int value)
	{
			return(dlsColourScheme.getNameFromCode(value));
	}

	static boolean validateColourScheme(String Value)
	{
		return(dlsColourScheme.validateScheme(Value));
	}

	static boolean isNewScheme(String Value)
	{
		return(dlsColourScheme.isNewScheme(Value));
	}

	static clsColourScheme getScheme(int ColourSchemeCode)
	{
		return(dlsColourScheme.getScheme(ColourSchemeCode));
	}
	static void updateColourScheme(clsColourScheme T)
	{
		dlsColourScheme.updateScheme(T);
	}
	public static void deleteColourScheme(clsColourScheme T)
	{
		dlsColourScheme.deleteScheme(T);
	}
	static void addColourSchemeRecords(JComboBox c)
	{
		String x[]=clsColourScheme.getAllSchemeNameRecords();
		c.removeAllItems();
		c.addItem("Select ColourScheme...");
		for(String ele:x)
		c.addItem(ele);
	}

    public static void main(String args[])
    {
		int NewSchemeNo=clsColourScheme.getMaximumSchemeNo()+1;
		System.out.println(NewSchemeNo);
    }


}