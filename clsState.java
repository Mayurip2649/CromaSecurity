import myUtility.*;
import DBManage.*;
import javax.swing.*;
import java.awt.event.*;
class clsState
{
	private int mStateId;
	private int mCountryID;
	private String mStateName;
	clsState()
	{
		mStateId=1;
                mStateName="ABC";
        }
	void setStateId(int value)
	{

		mStateId=value;
	}

	int getStateId()
	{

		return(mStateId);
	}


	void setStateName(String value)
	{

		mStateName=value;
	}
	String getStateName()
	{
		return(mStateName);
	}
	void setCountryID(int value)
		{

			mCountryID=value;
		}
		int  getCountryID()
		{
			return(mCountryID);
		}


	static void showState(clsState temp)
	{
	   System.out.println("State ID    :=> "+temp.getStateId());
           System.out.println("State Name  :=> "+temp.getStateName());
           System.out.println("Country id :=> "+temp.getCountryID());


    }
    static void addNewState(clsState temp)
    {
		dlsState.addNewState(temp);
    }
    static int getAllRecordsCount()
    {
		return(dlsState.getAllRecordsCount());
	}
	static boolean validateState(String Value)
	{
			return(dlsState.validateState(Value));
	}
	static String[] getAllStateNameRecords(int CountryCode)
	{

		return(dlsState.getAllStateNameRecords(CountryCode));

    }
	static int getCodeFromName(String value)
	{
		return(dlsState.getCodeFromName(value));
	}
	static String getNameFromCode(int value)
	{
		return(dlsState.getNameFromCode(value));
	}
	static clsState getState(int StateCode)
	{
		return(dlsState.getState(StateCode));
	}
    static void updateState(clsState T)
	{
		dlsState.updateState(T);
	}
	public static void deleteState(clsState T)
	{
		dlsState.deleteState(T);
	}
	static void addAllStateNameRecords(JComboBox c,int vCountryID)
	{

		String data[]=clsState.getAllStateNameRecords(vCountryID);
		c.removeAllItems();
		c.addItem("Select State ...");
		for(String ele:data)
		{
			c.addItem(ele);
		}

 	}
    public static void main(String args[])
    {
		String s[]=clsState.getAllStateNameRecords(16);
		for(String x:s)
		{
			System.out.println(x);
		}
    }


}