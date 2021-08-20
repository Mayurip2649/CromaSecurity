import myUtility.*;
import DBManage.*;
import javax.swing.*;
import java.sql.*;
class dlsCountry
{
	public static void addNewCountry(clsCountry temp)
	{
		String str="insert into tblCountry (CountryName) values("+
   		                        	Symbol.SINGLEQUOTE+temp.getCountryName()+Symbol.SINGLEQUOTE
		                		+")";
		JOptionPane.showMessageDialog(null,str);
		DBManager.addNewRecord(str);
		//TableData.saveMessage("Country");
	}
	public static int getAllRecordsCount()
	{

			  String str="Select count (*) from tblCountry";
			  int count=DBManager.getAllRecordsCount(str);
			  return(count);
    }
    static boolean validateCountry(String Value)
	{
			String str="Select count (*) from tblCountry where CountryName='"+Value+"'";
			  int count=DBManager.getAllRecordsCount(str);
			if(count ==0)
				return(true);
			else
				return(false);

	}

    public static String[] getAllCountryNameRecords()
	{

			  String str="Select CountryName from tblCountry";
			  int Count=getAllRecordsCount();
			  return(DBManager.getAllRecords(str,Count));
			 // return(count);
     }
     public static String[] getAllCountryNameRecords(int CountryCode)
	 {

	 			  String str="Select CountryName from tblCountry where CountryId="+CountryCode;
	 			  int Count=getAllRecordsCount();
	 			  return(DBManager.getAllRecords(str,Count));
	 			 // return(count);
     }

	static int getCodeFromName(String value)
	{
		String query="select CountryId from tblCountry where CountryName='"+value+"'";
		JOptionPane.showMessageDialog(null,query);
		return(DBManager.getCode(query));
	}
	static String getNameFromCode(int value)
	{
			String query="select CountryName from tblCountry where CountryId="+String.valueOf(value);
			return(DBManager.getName(query));
	}

	static clsCountry getCountry(int CountryCodee)
	{
		clsCountry temp=new clsCountry();
		String query="select * from tblCountry where CountryId="+String.valueOf(CountryCodee);
		String values[]=DBManager.getFullRow(query,2);
		temp.setCountryId(Integer.parseInt(values[0]));
		temp.setCountryName(values[1]);
		return(temp);
	}
	public static void updateCountry(clsCountry T)
	{
	       String s="update tblCountry set CountryName="+
	       Symbol.SINGLEQUOTE+T.getCountryName()+Symbol.SINGLEQUOTE+" where CountryID="+String.valueOf(T.getCountryId());

	       JOptionPane.showMessageDialog(null,s);
	       DBManager.addNewRecord(s);
	}

	      public static void deleteCountry(clsCountry T)
	      {
	       String s="delete * from tblCountry where CountryID="+String.valueOf(T.getCountryId());

	       JOptionPane.showMessageDialog(null,s);
	       DBManager.addNewRecord(s);
	      }



	public static void main(String args[])
	{
	}
}
