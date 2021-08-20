import myUtility.*;
import DBManage.*;
import javax.swing.*;
import java.awt.event.*;
class clsCountry
{
	private int mCountryId;
	private String mCountryName;

	clsCountry()
	{
		mCountryId=12;
        mCountryName="Afganistan";
    }
	void setCountryId(int value)
	{

		mCountryId=value;
	}

	int getCountryId()
	{

		return(mCountryId);
	}


	void setCountryName(String value)
	{

		mCountryName=value;
	}
	String getCountryName()
	{
		return(mCountryName);
	}

	static void showCountry(clsCountry temp)
	{
	   System.out.println("Country ID    :=> "+temp.getCountryId());
       System.out.println("Country Name  :=> "+temp.getCountryName());

   }
    static void addNewCountry(clsCountry temp)
    {
		dlsCountry.addNewCountry(temp);
    }
    static int getAllRecordsCount()
    {
		return(dlsCountry.getAllRecordsCount());
	}
	static String[] getAllCountryNameRecords()
	{

		return(dlsCountry.getAllCountryNameRecords());

    }
    static String[] getAllCountryNameRecords(int CountryCode)
	{

			return(dlsCountry.getAllCountryNameRecords(CountryCode));

    }

	static int getCodeFromName(String value)
	{
		return(dlsCountry.getCodeFromName(value));
	}
	static String getNameFromCode(int value)
	{
			return(dlsCountry.getNameFromCode(value));
	}

	static boolean validateCountry(String Value)
	{
		return(dlsCountry.validateCountry(Value));
	}
	static clsCountry getCountry(int CountryCode)
	{
		return(dlsCountry.getCountry(CountryCode));
	}
	static void updateCountry(clsCountry T)
	{
		dlsCountry.updateCountry(T);
	}
	public static void deleteCountry(clsCountry T)
	{
		dlsCountry.deleteCountry(T);
	}
	static void addCountryRecords(JComboBox c)
	{
		String x[]=clsCountry.getAllCountryNameRecords();
		c.removeAllItems();
		c.addItem("Select Country...");
		for(String ele:x)
		c.addItem(ele);
	}

    public static void main(String args[])
    {

		System.out.println(getCodeFromName("India"));


    }


}