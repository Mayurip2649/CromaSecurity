import DBManage.*;
import myUtility.*;
import javax.swing.*;
public class dlsSecurityQuestion
{
	public static void addNewSecurityQuestion(clsSecurityQuestion temp)
	{
		String query="insert into tblSecurityQuestion (SecurityQuestionName) values("+
				Symbol.SINGLEQUOTE+temp.getQuestion()+Symbol.SINGLEQUOTE+
				")";


		DBManager.addNewRecord(query);
		JOptionPane.showMessageDialog(null,query);
	}
	public static int getRecordsCount()
	{

		String str="select count (*) from tblSecurityQuestion";
		//JOptionPane.showMessageDialog(null,str);
        int count=DBManager.getAllRecordsCount(str);
		return(count);
	}
	public static String[] getAllSecurityQuestionRecords()
	{

		int rec=getRecordsCount();
		String query="select SecurityQuestionName from tblSecurityQuestion";
		return(DBManager.getAllRecords(query,rec));
	}

    static int getCodeFromName(String value)
    {
		String query="select SecurityQuestionID from tblSecurityQuestion where SecurityQuestionName='"+value+"'";
		return(DBManager.getCode(query));
	}
	static String getNameFromCode(int value)
	{
			String query="select SecurityQuestionName from tblSecurityQuestion where SecurityQuestionID="+String.valueOf(value);
			return(DBManager.getName(query));
	}

	public static void deleteSecurityQuestion(clsSecurityQuestion temp)
    {

    	String query="delete * from tblSecurityQuestion "+
    	"where SecurityQuestionID="+String.valueOf(temp.getID());
	    JOptionPane.showMessageDialog(null,query);
		DBManager.addNewRecord(query);

	}

	/*static clsSecurityQuestion getSecurityQuestion(int value)
	{
		clsSecurityQuestion obj=new clsSecurityQuestion();
		String x="select * from tblSecurityQuestion where SecurityQuestionID="+String.valueOf(value);
		String values[]=DBManager.getFullRow(x,2);
		obj.setID(Integer.parseInt(values[0]));
		obj.setQuestion(values[1]);
		return(obj);
	}*/

	static clsSecurityQuestion getSecurityQuestion()
	{
		clsSecurityQuestion obj=new clsSecurityQuestion();
		String x="select * from tblSecurityQuestion";
		String values[]=DBManager.getFullRow(x,2);
		obj.setID(Integer.parseInt(values[0]));
		obj.setQuestion(values[1]);
		return(obj);
	}

	static clsSecurityQuestion[] getAllSecurityQuestion()
	{
		int rec=getRecordsCount();
		clsSecurityQuestion obj[]=new clsSecurityQuestion[rec];
		String q="select * from tblSecurityQuestion";
		String Value[][]=DBManager.getAllFullRow(q,rec,2);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new clsSecurityQuestion();
			obj[i].setID(Integer.parseInt(Value[i][0]));
			obj[i].setQuestion(Value[i][1]);
		}
		return(obj);
	}
	static boolean validateSecurityQuestion(String Value)
	{
		String str="Select count (*) from tblSecurityQuestion where Question='"+Value+"'";
		int count=DBManager.getAllRecordsCount(str);
		if(count ==0)
		return(true);
		else
		return(false);
	}
	public static void main(String args[])
	{
		  //clsSecurityQuestion ref=getSecurityQuestion(1);
		  //clsSecurityQuestion.showSecurityQuestion(ref);
		  System.out.println(getRecordsCount());
    }

}