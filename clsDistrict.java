import myUtility.*;
import DBManage.*;
import javax.swing.*;
class clsDistrict
{
	private int mDistrictId,mCountryID,mStateID;
	private String mDistrictName;

	clsDistrict()
	{
		mDistrictId=1;
        mDistrictName="ABC";
    }
	void setDistrictId(int value)
	{

		mDistrictId=value;
	}

	int getDistrictId()
	{

		return(mDistrictId);
	}


	void setDistrictName(String value)
	{

		mDistrictName=value;
	}
	String getDistrictName()
	{
		return(mDistrictName);
	}
	void setCountryID(int value)
	{
		mCountryID=value;
	}
	int  getCountryID()
	{
		return(mCountryID);
	}
	void setStateId(int value)
	{
		mStateID=value;
	}
	int getStateId()
	{
		return(mStateID);
	}
	static void showclsDistrict(clsDistrict temp)
	{
	    System.out.println("District ID    :=> "+temp.getDistrictId());
        System.out.println("District Name  :=> "+temp.getDistrictName());
	}
    static void addNewDistrict(clsDistrict temp)
    {
		dlsDistrict.addNewDistrict(temp);
    }
    static int getAllRecordsCount()
    {
		return(dlsDistrict.getAllRecordsCount());
	}
	static boolean validateDistrict(String Value)
	{
				return(dlsDistrict.validateDistrict(Value));
	}
	static String[] getAllDistrictNameRecords(int vDistrictCode)
	{

		return(dlsDistrict.getAllDistrictNameRecords(vDistrictCode));

    }
    static int getCodeFromName(String value)
	{
			return(dlsDistrict.getCodeFromName(value));
	}
	static String getNameFromCode(int value)
	{
			return(dlsDistrict.getNameFromCode(value));
	}
	static clsDistrict getDistrict(int DistrictCode)
	{
			return(dlsDistrict.getDistrict(DistrictCode));
	}
	 static void updateDistrict(clsDistrict T)
	{
			dlsDistrict.updateDistrict(T);
	}
	public static void deleteDistrict(clsDistrict T)
	{
			dlsDistrict.deleteDistrict(T);
	}
	static void addAllDistrictNameRecords(JComboBox c,int vDistrictID)
	{
		String data[]=clsDistrict.getAllDistrictNameRecords(vDistrictID);
		c.removeAllItems();
		c.addItem("Select District...");
		for(String ele:data)
		{
			c.addItem(ele);
		}

	 }
    public static void main(String args[])
    {
		System.out.println(clsDistrict.getAllDistrictNameRecords(16));

    }


}