import myUtility.*;
import DBManage.*;
import javax.swing.*;
class clsTaluka
{
	private int mTalukaId,mCountryID,mStateId,mDistrictId;
	private String mTalukaName;

	clsTaluka()
	{
		mTalukaId=1;
        mTalukaName="ABC";
    }
	void setTalukaId(int value)
	{

		mTalukaId=value;
	}

	int getTalukaId()
	{

		return(mTalukaId);
	}


	void setTalukaName(String value)
	{
		mTalukaName=value;
	}
	String getTalukaName()
	{
		return(mTalukaName);
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

		mStateId=value;
	}

	int getStateId()
	{

		return(mStateId);
	}

	void setDistrictId(int value)
	{

		mDistrictId=value;
	}

	int getDistrictId()
	{
		return(mDistrictId);
	}
	static void showclsTaluka(clsTaluka temp)
	{
	   System.out.println("Taluka ID    :=> "+temp.getTalukaId());
       System.out.println("Taluka Name  :=> "+temp.getTalukaName());

    }
    static void addNewTaluka(clsTaluka temp)
    {
		dlsTaluka.addNewTaluka(temp);
    }
    static int getAllRecordsCount()
    {
		return(dlsTaluka.getAllRecordsCount());
	}
	static boolean validateTaluka(String Value)
	{
				return(dlsTaluka.validateTaluka(Value));
	}
	static String[] getAllTalukaNameRecords()
	{
		return(dlsTaluka.getAllTalukaNameRecords());
	}
	static String[] getAllTalukaNameRecords(int vDistrictCode)
		{
			return(dlsTaluka.getAllTalukaNameRecords(vDistrictCode));
	}
	static int getCodeFromName(String value)
	{
			return(dlsTaluka.getCodeFromName(value));
	}
	static String getNameFromCode(int value)
	{
			return(dlsTaluka.getNameFromCode(value));
	}
	static clsTaluka getTaluka(int TalukaCode)
	{
			return(dlsTaluka.getTaluka(TalukaCode));
	}
	static void updateTaluka(clsTaluka T)
	{
			dlsTaluka.updateTaluka(T);
	}
	public static void deleteTaluka(clsTaluka T)
	{
			dlsTaluka.deleteTaluka(T);
	}
	static void addAllTalukaNameRecords(JComboBox c,int vDistrictID)
	{
					String data[]=clsTaluka.getAllTalukaNameRecords(vDistrictID);

					c.removeAllItems();
					c.addItem("Select Taluka...");
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