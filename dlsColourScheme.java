import myUtility.*;
import DBManage.*;
import javax.swing.*;
import java.sql.*;
class dlsColourScheme
{
	public static void addNewScheme(clsColourScheme temp)
	{
		String str="insert into tblColourScheme (SchemeName,SchemeNo) values("+
   		                        	Symbol.SINGLEQUOTE+temp.getSchemeName()+Symbol.SINGLEQUOTE+Symbol.COMMA
   		                        	+String.valueOf(temp.getSchemeNo())

		                		+")";
		JOptionPane.showMessageDialog(null,str);
		DBManager.addNewRecord(str);
		//TableData.saveMessage("Scheme");
	}
	public static int getAllRecordsCount()
	{
			  String str="Select count (*) from tblColourScheme";
			  int count=DBManager.getAllRecordsCount(str);
			  return(count);
    }
	static int getMaximumSchemeNo()
	{
		String str="Select max(SchemeNo) from tblColourScheme ";
		int count=DBManager.getAllRecordsCount(str);
		JOptionPane.showMessageDialog(null,String.valueOf(count));
		return(count);
	}

    static boolean validateScheme(String Value)
	{
			String str="Select count (*) from tblColourScheme where SchemeName='"+Value+"'";
			  int count=DBManager.getAllRecordsCount(str);
			if(count ==0)
				return(true);
			else
				return(false);

	}

	static boolean isNewScheme(String Value)
	{
			String str="Select count (*) from tblColourScheme where SchemeName='"+Value+"'";
			  int count=DBManager.getAllRecordsCount(str);
			if(count ==0)
				return(true);
			else
				return(false);

	}

    public static String[] getAllSchemeNameRecords()
	{

			  String str="Select SchemeName from tblColourScheme";
			  int Count=getAllRecordsCount();
			  return(DBManager.getAllRecords(str,Count));
			 // return(count);
     }

	static int getCodeFromName(String value)
	{
		String query="select SchemeId from tblColourScheme where SchemeName='"+value+"'";
		//JOptionPane.showMessageDialog(null,query);
		return(DBManager.getCode(query));
	}
	static String getNameFromCode(int value)
	{
			String query="select SchemeName from tblColourScheme where SchemeId="+String.valueOf(value);
			return(DBManager.getName(query));
	}

	static clsColourScheme getScheme(int SchemeCodee)
	{
		clsColourScheme temp=new clsColourScheme();
		String query="select * from tblColourScheme where SchemeId="+String.valueOf(SchemeCodee);
		String values[]=DBManager.getFullRow(query,3);
		temp.setschemeID(Integer.parseInt(values[0]));
		temp.setSchemeName(values[1]);
		temp.setSchemeNo(Integer.parseInt(values[2]));
		return(temp);
	}
	public static void updateScheme(clsColourScheme T)
	{
	       String s="update tblColourScheme set SchemeName="+
	       Symbol.SINGLEQUOTE+T.getSchemeName()+Symbol.SINGLEQUOTE+" where schemeID="+String.valueOf(T.getschemeID());

	       JOptionPane.showMessageDialog(null,s);
	       DBManager.addNewRecord(s);
	}

	      public static void deleteScheme(clsColourScheme T)
	      {
	       String s="delete * from tblColourScheme where SchemeID="+String.valueOf(T.getschemeID());

	       JOptionPane.showMessageDialog(null,s);
	       DBManager.addNewRecord(s);
	      }



	public static void main(String args[])
	{
		int NewSchemeNo=clsColourScheme.getMaximumSchemeNo()+1;
		System.out.println(NewSchemeNo);
	}
}
