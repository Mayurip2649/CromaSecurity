import javax.swing.*;
import java.sql.*;
import myUtility.*;
import DBManage.*;
class dlsState
{
	public static void addNewState(clsState temp)
	{
		String str="insert into tblState (StateName,CountryID) Values("+

   		                        	Symbol.SINGLEQUOTE+temp.getStateName()+Symbol.SINGLEQUOTE+Symbol.COMMA+
   		                        	String.valueOf(temp.getCountryID())

		                		+")";
		JOptionPane.showMessageDialog(null,str);
		DBManager.addNewRecord(str);
	}
	public static int getAllRecordsCount()
	{

			  String str="Select count (*) from tblState";
			  int count=DBManager.getAllRecordsCount(str);
			  return(count);
    }
    static boolean validateState(String Value)
	{
				String str="Select count (*) from tblState where StateName='"+Value+"'";
				int count=DBManager.getAllRecordsCount(str);
				if(count ==0)
					return(true);
				else
					return(false);

	}
	public static int getAllRecordsCount(int CountryCode)
	{

			  String str="Select count (*) from tblState where CountryID="+String.valueOf(CountryCode);
			  int count=DBManager.getAllRecordsCount(str);
			  return(count);
    }
    public static String[] getAllStateNameRecords(int CountryCode)
	{

			  String str="Select StateName from tblState where CountryID="+String.valueOf(CountryCode);
			  int Count=getAllRecordsCount(CountryCode);
			  return(DBManager.getAllRecords(str,Count));
			 // return(count);
     }
	static int getCodeFromName(String value)
	{
		String query="select StateId from tblState where StateName='"+value+"'";
		return(DBManager.getCode(query));
	}

	static String getNameFromCode(int value)
	{
		String query="select StateName from tblState where StateId="+String.valueOf(value);
		return(DBManager.getName(query));
	}

   static clsState getState(int StateCode)
	{
		clsState temp=new clsState();
		String query="select * from tblState where StateId="+String.valueOf(StateCode);
		String values[]=DBManager.getFullRow(query,3);
		temp.setStateId(Integer.parseInt(values[0]));
		temp.setStateName(values[1]);
		temp.setCountryID(Integer.parseInt(values[2]));
		return(temp);
	}
	public static void updateState(clsState T)
	{
		       String s="update tblState set StateName="+
		       Symbol.SINGLEQUOTE+T.getStateName()+Symbol.SINGLEQUOTE+Symbol.COMMA+
		       "CountryId="+T.getCountryID()+
		       " where StateID="+String.valueOf(T.getStateId());

		       JOptionPane.showMessageDialog(null,s);
		       DBManager.addNewRecord(s);
	}
	public static void deleteState(clsState T)
	{
		       String s="delete * from tblState where StateId="+String.valueOf(T.getStateId());

		       JOptionPane.showMessageDialog(null,s);
		       DBManager.addNewRecord(s);
	}

}
