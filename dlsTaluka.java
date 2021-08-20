import javax.swing.*;
import java.sql.*;
import myUtility.*;
import DBManage.*;
class dlsTaluka
{
	public static void addNewTaluka(clsTaluka temp)
	{
		String str="insert into tblTaluka (TalukaName,DistrictId) Values("+

   		                        	Symbol.SINGLEQUOTE+temp.getTalukaName()+Symbol.SINGLEQUOTE+Symbol.COMMA+

									String.valueOf(temp.getDistrictId())
                                    +")";
		JOptionPane.showMessageDialog(null,str);
		DBManager.addNewRecord(str);
	}
	public static int getAllRecordsCount()
	{

			  String str="Select count (*) from tblTaluka";
			  int count=DBManager.getAllRecordsCount(str);
			  return(count);
    }
    static boolean validateTaluka(String Value)
	{
					String str="Select count (*) from tblTaluka where TalukaName='"+Value+"'";
					int count=DBManager.getAllRecordsCount(str);
					if(count ==0)
						return(true);
					else
						return(false);

	}
     public static int getAllRecordsCount(int vDistrictCode)
	{

			String str="Select count (*) from tblTaluka where DistrictId="+String.valueOf(vDistrictCode);
			int count=DBManager.getAllRecordsCount(str);
			return(count);
    }
    public static String[] getAllTalukaNameRecords()
	{

			  String str="Select TalukaName from tblTaluka";
			  int Count=getAllRecordsCount();
			  return(DBManager.getAllRecords(str,Count));
			 // return(count);
     }
     public static String[] getAllTalukaNameRecords(int vDistrictCode)
	 	{

	 		String str="Select TalukaName from tblTaluka where DistrictId="+String.valueOf(vDistrictCode);
	 		int Count=getAllRecordsCount(vDistrictCode);
	 		return(DBManager.getAllRecords(str,Count));
	 		// return(count);
    }
    static int getCodeFromName(String value)
		{
			String query="select TalukaId from tblTaluka where TalukaName='"+value+"'";
			return(DBManager.getCode(query));
		}

		static String getNameFromCode(int value)
		{
			String query="select TalukaName from tblTaluka where TalukaId="+String.valueOf(value);
			return(DBManager.getName(query));
		}

	   static clsTaluka getTaluka(int TalukaCodee)
		{
			clsTaluka temp=new clsTaluka();
			String query="select * from tblTaluka where TalukaId="+String.valueOf(TalukaCodee);
			String values[]=DBManager.getFullRow(query,3);
			temp.setTalukaId(Integer.parseInt(values[0]));
			temp.setTalukaName(values[1]);
			temp.setDistrictId(Integer.parseInt(values[2]));
			return(temp);
		}
		public static void updateTaluka(clsTaluka T)
		{
			       String s="update tblTaluka set TalukaName="+
			       Symbol.SINGLEQUOTE+T.getTalukaName()+Symbol.SINGLEQUOTE+Symbol.COMMA+
			       "DistrictId="+T.getDistrictId()+
			       " where TalukaID="+String.valueOf(T.getTalukaId());

			       JOptionPane.showMessageDialog(null,s);
			       DBManager.addNewRecord(s);
		}
		public static void deleteTaluka(clsTaluka T)
		{
			       String s="delete * from tblTaluka where TalukaId="+String.valueOf(T.getTalukaId());

			       JOptionPane.showMessageDialog(null,s);
			       DBManager.addNewRecord(s);
		}


}