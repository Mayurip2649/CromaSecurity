import DBManage.*;
import myUtility.*;
import javax.swing.*;
public class dlsNewUserForm
{
	static int getCodeFromUserName(String value)
	{
		String query="select UserID from tblNewUser where UserName='"+value+"'";
		return(DBManager.getCode(query));
	}
	static int getColorSchemeCode(int code)
	{
		String query="select ColorSchemeDataID from tblNewUser where UserID="+String.valueOf(code);
		return(DBManager.getCode(query));

	}

	static int getVerification(String UserName,String Pasword)
	{

		String str="select count (*) from tblNewUser where UserName='"+UserName+"' and UserPassword= '"+Pasword+"'";

		System.out.println(str);

		int count=DBManager.getAllRecordsCount(str);
		return(count);

	}

	public static void addNewUser(clsNewUserForm temp)
	{
		String query="insert into tblNewUser (FirstName,LastName,BirthMonth,BirthDate,BirthYear,Gender,EmailID,CountryID,UserName,UserPassword,ColorSchemeDataID,SecurityQuestionID,SecurityAnswer) values("+
		Symbol.SINGLEQUOTE+temp.getFirstName()+Symbol.SINGLEQUOTE+Symbol.COMMA+
		Symbol.SINGLEQUOTE+temp.getLastName()+Symbol.SINGLEQUOTE+Symbol.COMMA+
		Symbol.SINGLEQUOTE+temp.getBirthMonth()+Symbol.SINGLEQUOTE+Symbol.COMMA+
		String.valueOf(temp.getBirthDate())+Symbol.COMMA+
		String.valueOf(temp.getBirthYear())+Symbol.COMMA+
		String.valueOf(temp.getGender())+Symbol.COMMA+
		Symbol.SINGLEQUOTE+temp.getEmailID()+Symbol.SINGLEQUOTE+Symbol.COMMA+
		String.valueOf(temp.getCountryID())+Symbol.COMMA+
		Symbol.SINGLEQUOTE+temp.getUserName()+Symbol.SINGLEQUOTE+Symbol.COMMA+
		Symbol.SINGLEQUOTE+temp.getUserPassword()+Symbol.SINGLEQUOTE+Symbol.COMMA+
		String.valueOf(temp.getColorSchemeDataID())+Symbol.COMMA+
		String.valueOf(temp.getSecurityQuestionID())+Symbol.COMMA+
		Symbol.SINGLEQUOTE+temp.getSecurityAnswer()+Symbol.SINGLEQUOTE+
		")";

		JOptionPane.showMessageDialog(null,query);
		DBManager.addNewRecord(query);
	}
	public static void updateNewUser(clsNewUserForm temp)
	{
		String query="update tblNewUser set " +
		"FirstName="+Symbol.SINGLEQUOTE+temp.getFirstName()+Symbol.SINGLEQUOTE+Symbol.COMMA+
		"LastName="+Symbol.SINGLEQUOTE+temp.getLastName()+Symbol.SINGLEQUOTE+Symbol.COMMA+
		"BirthMonth="+Symbol.SINGLEQUOTE+temp.getBirthMonth()+Symbol.SINGLEQUOTE+Symbol.COMMA+
		"BirthDate="+String.valueOf(temp.getBirthDate())+Symbol.COMMA+
		"BirthYear="+String.valueOf(temp.getBirthYear())+Symbol.COMMA+
		"Gender="+String.valueOf(temp.getGender())+Symbol.COMMA+
		"EmailID="+Symbol.SINGLEQUOTE+temp.getEmailID()+Symbol.SINGLEQUOTE+Symbol.COMMA+
		"CountryID="+String.valueOf(temp.getCountryID())+Symbol.COMMA+
		"UserName="+Symbol.SINGLEQUOTE+temp.getUserName()+Symbol.SINGLEQUOTE+Symbol.COMMA+
		"UserPassword="+Symbol.SINGLEQUOTE+temp.getUserPassword()+Symbol.SINGLEQUOTE+Symbol.COMMA+
		"ColorSchemeDataID="+String.valueOf(temp.getColorSchemeDataID())+Symbol.COMMA+
	    "SecurityQuestionID="+String.valueOf(temp.getSecurityQuestionID())+Symbol.COMMA+
	    "SecurityAnswer="+Symbol.SINGLEQUOTE+temp.getSecurityAnswer()+Symbol.SINGLEQUOTE+
	    " where UserID="+String.valueOf(temp.getUserID());


		JOptionPane.showMessageDialog(null,query);
		DBManager.addNewRecord(query);
	}

	static clsNewUserForm getNewUser(int Codes)
	{

		clsNewUserForm temp=new clsNewUserForm ();
		String x="select * from tblNewUser where UserID="+String.valueOf(Codes);
		String values[]=DBManager.getFullRow(x,14);

		temp.setUserID(Integer.parseInt(values[0]));
		temp.setFirstName(values[1]);
		temp.setLastName(values[2]);
		temp.setBirthMonth(values[3]);
		temp.setBirthDate(Integer.parseInt(values[4]));
		temp.setBirthYear(Integer.parseInt(values[5]));
		temp.setGender(Integer.parseInt(values[6]));
		temp.setEmailID(values[7]);
		temp.setCountryID(Integer.parseInt(values[8]));
		temp.setUserName(values[9]);
		temp.setUserPassword(values[10]);
		temp.setColorSchemeDataID(Integer.parseInt(values[11]));
		temp.setSecurityQuestionID(Integer.parseInt(values[12]));
		temp.setSecurityAnswer(values[13]);


		return(temp);
	}


	public static void main(String args[])
	{
		int code1=clsNewUserForm.getVerification("kunjesh","kunjesh");
		System.out.println(code1);
	}


}