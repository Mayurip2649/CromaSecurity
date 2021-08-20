import javax.swing.*;
import java.sql.*;
import myUtility.*;
import DBManage.*;
class dlsDistrict
{
	public static void addNewDistrict(clsDistrict temp)
	{
		String str="insert into tblDistrict (DistrictName,StateID) Values("+

   		                        	Symbol.SINGLEQUOTE+temp.getDistrictName()+Symbol.SINGLEQUOTE+Symbol.COMMA+

   		                        	String.valueOf(temp.getStateId())

		                		+")";
		JOptionPane.showMessageDialog(null,str);
		DBManager.addNewRecord(str);
	}
	public static int getAllRecordsCount()
	{

		String str="Select count (*) from tblDistrict";
		int count=DBManager.getAllRecordsCount(str);
		return(count);
    }
	static boolean validateDistrict(String Value)
	{
				String str="Select count (*) from tblDistrict where DistrictName='"+Value+"'";
				int count=DBManager.getAllRecordsCount(str);
				if(count ==0)
					return(true);
				else
					return(false);

	}
    public static int getAllRecordsCount(int vStateCode)
	{

		String str="Select count (*) from tblDistrict where StateID="+String.valueOf(vStateCode);
		int count=DBManager.getAllRecordsCount(str);
		return(count);
    }

    public static String[] getAllDistrictNameRecords(int vStateCode)
	{

		String str="Select DistrictName from tblDistrict where StateID="+String.valueOf(vStateCode);
		int Count=getAllRecordsCount(vStateCode);
		return(DBManager.getAllRecords(str,Count));
		// return(count);
    }
    static int getCodeFromName(String value)
	{
			String query="select DistrictId from tblDistrict where DistrictName='"+value+"'";
			return(DBManager.getCode(query));
	}
	public static void updateDistrict(clsDistrict T)
	{
			       String s="update tblDistrict set DistrictName="+
			       Symbol.SINGLEQUOTE+T.getDistrictName()+Symbol.SINGLEQUOTE+Symbol.COMMA+
			       "StateId="+T.getStateId()+
			       " where DistrictID="+String.valueOf(T.getDistrictId());

			       JOptionPane.showMessageDialog(null,s);
			       DBManager.addNewRecord(s);
	}
	public static void deleteDistrict(clsDistrict T)
	{
			       String s="delete * from tblDistrict where DistrictId="+String.valueOf(T.getDistrictId());

			       JOptionPane.showMessageDialog(null,s);
			       DBManager.addNewRecord(s);
	}
	static clsDistrict getDistrict(int DistrictCodee)
	{
			clsDistrict temp=new clsDistrict();
			String query="select * from tblDistrict where DistrictId="+String.valueOf(DistrictCodee);
			String values[]=DBManager.getFullRow(query,3);
			temp.setDistrictId(Integer.parseInt(values[0]));
			temp.setDistrictName(values[1]);
			temp.setStateId(Integer.parseInt(values[2]));
			return(temp);
	}
	static String getNameFromCode(int value)
		{
			String query="select DistrictName from tblDistrict where DistrictId="+String.valueOf(value);
		return(DBManager.getName(query));
	}

}
