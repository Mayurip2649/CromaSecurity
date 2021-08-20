import myUtility.*;
import DBManage.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
class dlsColourSchemedata
{
	public static void addNewSchemeData(clsColourSchemeData temp)
	{
		String str="insert into tblColourSchemeData (PatternName,SchemeR,SchemeG,SchemeB,SchemeID) values("+
   		                        	Symbol.SINGLEQUOTE+temp.getPatternName()+Symbol.SINGLEQUOTE+Symbol.COMMA
   		                        	+String.valueOf(temp.getSchemeR())+Symbol.COMMA
   		                        	+String.valueOf(temp.getSchemeG())+Symbol.COMMA
   		                        	+String.valueOf(temp.getSchemeB())+Symbol.COMMA
   		                        	+String.valueOf(temp.getSchemeID())

		                		+")";
		//JOptionPane.showMessageDialog(null,str);
		DBManager.addNewRecord(str);
		//TableData.saveMessage("Scheme");
	}
	public static int getAllRecordsCount()
	{

			  String str="Select count (*) from tblColourSchemeData";
			  int count=DBManager.getAllRecordsCount(str);
			  return(count);
    }
    static boolean validateScheme(String Value)
	{
			String str="Select count (*) from tblColourSchemeData where SchemeName='"+Value+"'";
			  int count=DBManager.getAllRecordsCount(str);
			if(count ==0)
				return(true);
			else
				return(false);

	}

    public static String[] getAllSchemeNameRecords()
	{

			  String str="Select SchemeName from tblColourSchemeData";
			  int Count=getAllRecordsCount();
			  return(DBManager.getAllRecords(str,Count));
			 // return(count);
     }

	static int getCodeFromName(String value)
	{
		String query="select schemeDataID from tblColourSchemeData where PatternName='"+value+"'";
		//JOptionPane.showMessageDialog(null,query);
		return(DBManager.getCode(query));
	}
	static String getNameFromCode(int value)
	{
			String query="select SchemeName from tblColourSchemeData where SchemeId="+String.valueOf(value);
			return(DBManager.getName(query));
	}

	static clsColourSchemeData getScheme(int SchemeCodee)
	{
		clsColourSchemeData temp=new clsColourSchemeData();
		String query="select * from tblColourSchemeData where schemeDataID="+String.valueOf(SchemeCodee);
		String values[]=DBManager.getFullRow(query,6);
		temp.setschemeDataID(Integer.parseInt(values[0]));
		temp.setPatternName(values[1]);
		temp.setSchemeR(Integer.parseInt(values[2]));
		temp.setSchemeG(Integer.parseInt(values[3]));
		temp.setSchemeB(Integer.parseInt(values[4]));
		temp.setSchemeID(Integer.parseInt(values[5]));
		return(temp);
	}

	static Color getSelectedSchemeColor(int code)
	{
		clsColourSchemeData temp=getScheme(code);
		int R1=temp.getSchemeR();
		int G1=temp.getSchemeG();
		int B1=temp.getSchemeB();

		return(new Color(R1,G1,B1));
	}


	static clsColourSchemeData[] getAllSchemes(int ColourSchemeCode)
	{
		clsColourSchemeData temp[]=new clsColourSchemeData[6];
		String query="select * from tblColourSchemeData where SchemeId="+String.valueOf(ColourSchemeCode);
		String values[][]=DBManager.getAllFullRow(query,6,6);

		for(int i=0;i<6;i++)
		{
			temp[i]=new clsColourSchemeData();
			temp[i].setschemeDataID(Integer.parseInt(values[i][0]));
			temp[i].setPatternName(values[i][1]);
			temp[i].setSchemeR(Integer.parseInt(values[i][2]));
			temp[i].setSchemeG(Integer.parseInt(values[i][3]));
			temp[i].setSchemeB(Integer.parseInt(values[i][4]));
			temp[i].setSchemeID(Integer.parseInt(values[i][5]));
		}
		return(temp);
	}

	public static void updateScheme(clsColourSchemeData T)
	{
	       String s="update tblColourSchemeData set SchemeName="+
	       Symbol.SINGLEQUOTE+T.getPatternName()+Symbol.SINGLEQUOTE+" where schemeDataID="+String.valueOf(T.getschemeDataID());

	       JOptionPane.showMessageDialog(null,s);
	       DBManager.addNewRecord(s);
	}

	    /*  public static void deleteScheme(clsColourScheme T)
	      {
	       String s="delete * from tblColourSchemeData where SchemeID="+String.valueOf(T.getschemeDataID());

	       JOptionPane.showMessageDialog(null,s);
	       DBManager.addNewRecord(s);
	      }*/



	public static void main(String args[])
	{
				int SelectedSchemeCode=clsColourSchemeData.getCodeFromName("S1Set-3");
				JOptionPane.showMessageDialog(null,"Nitin shah Button Selected"+String.valueOf(SelectedSchemeCode));
	}
}
