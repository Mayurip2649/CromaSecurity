import java.awt.*;
import java.applet.*;
import javax.swing.*;
import myUtility.*;
import DBManage.*;
import java.sql.*;
class clsSecurityQuestion
{
	private int mID;
	private String mQuestion;

	void setID(int value)
	{
		 mID=value;
    }
    int getID()
    {
      	return(mID);
    }

   	 void setQuestion(String value)
	{
		mQuestion=value;
    }
    String getQuestion()
    {
	    return(mQuestion);
    }
    static clsSecurityQuestion[] getAllSecurityQuestion()
	{
		return(dlsSecurityQuestion.getAllSecurityQuestion());
	}

    static String[] getAllSecurityQuestionRecords()
    {
	 	return(dlsSecurityQuestion.getAllSecurityQuestionRecords());

	}
    static void showSecurityQuestion(clsSecurityQuestion temp)
    {
	 	System.out.println("SecurityQuestion ID                 :=>    "+temp.getID());
	 	System.out.println("SecurityQuestion Name               :=>    "+temp.getQuestion());
    }
	static void addNewSecurityQuestion(clsSecurityQuestion temp)
    {
	 		 dlsSecurityQuestion.addNewSecurityQuestion(temp);
	}
	static void updateSecurityQuestion (clsSecurityQuestion temp1)
	{
	     String x="update tblSecurityQuestion set("+
		 "ID="+temp1.getID()+Symbol.COMMA+
	     "Question"+Symbol.SINGLEQUOTE+temp1.getQuestion()+Symbol.SINGLEQUOTE+Symbol.COMMA+

		 ")";
		 System.out.println(x);
	}
	 static void deleteSecurityQuestion(clsSecurityQuestion temp2)
    {
			dlsSecurityQuestion.deleteSecurityQuestion(temp2);

	}
	public static int getRecordsCount()
	{
		return(dlsSecurityQuestion.getRecordsCount());
	}
	/*static clsSecurityQuestion getSecurityQuestion(int value)
	{
		return(dlsSecurityQuestion.getSecurityQuestion(value));
	}*/

	static clsSecurityQuestion getSecurityQuestion()
	{
		return(dlsSecurityQuestion.getSecurityQuestion());
	}

    static int getCodeFromName(String value)
	{

		return(dlsSecurityQuestion.getCodeFromName(value));

	}

	static String getNameFromCode(int value)
	{
			return(dlsSecurityQuestion.getNameFromCode(value));
	}
	static boolean validateSecurityQuestion(String Value)
	{
		return(dlsSecurityQuestion.validateSecurityQuestion(Value));
	}
	static void addSecurityQuestionRecords(JComboBox C)
	{
		String data[]=clsSecurityQuestion.getAllSecurityQuestionRecords();
		C.removeAllItems();
		C.addItem("Select Security Question...");
		for(String ele : data)
		{
			C.addItem(ele);
		}
	}

    public static void main(String args[])
    {
    }
}

