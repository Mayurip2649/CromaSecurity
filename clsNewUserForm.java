import java.awt.*;
import javax.swing.*;

public class clsNewUserForm
{
	private int mUserID,mBirthDate,mBirthYear,mGender,mCountryID,mColorSchemeDataID;
	private String mFirstName,mLastName,mBirthMonth,mEmailID,mUserName,mUserPassword;
	private int mSecurityQuestionID;
	private String mSecurityAnswer;

	void setSecurityQuestionID(int value)
	{
		mSecurityQuestionID=value;
	}
	int getSecurityQuestionID()
	{
		return(mSecurityQuestionID);
	}

	void setSecurityAnswer(String value)
	{
		mSecurityAnswer=value;
	}
	String getSecurityAnswer()
	{
		return(mSecurityAnswer);
	}


	void setUserID(int value)
	{
		mUserID=value;
	}
	int getUserID()
	{
		return(mUserID);
	}

	void setBirthDate(int value)
	{
		mBirthDate=value;
	}
	int getBirthDate()
	{
		return(mBirthDate);
	}
	void setBirthYear(int value)
	{
		mBirthYear=value;
	}
	int getBirthYear()
	{
		return(mBirthYear);
	}
	void setGender(int value)
	{
		mGender=value;
	}
	int getGender()
	{
		return(mGender);
	}
	void setCountryID(int value)
	{
		mCountryID=value;
	}
	int getCountryID()
	{
		return(mCountryID);
	}
	void setColorSchemeDataID(int value)
	{
		mColorSchemeDataID=value;
	}
	int getColorSchemeDataID()
	{
		return(mColorSchemeDataID);
	}
	void setFirstName(String value)
	{
		mFirstName=value;
	}
	String getFirstName()
	{
		return(mFirstName);
	}
	void setLastName(String value)
	{
		mLastName=value;
	}
	String getLastName()
	{
		return(mLastName);
	}
	void setBirthMonth(String value)
	{
		mBirthMonth=value;
	}
	String getBirthMonth()
	{
		return(mBirthMonth);
	}
	void setEmailID(String value)
	{
		mEmailID=value;
	}
	String getEmailID()
	{
		return(mEmailID);
	}
	void setUserName(String value)
	{
		mUserName=value;
	}
	String getUserName()
	{
		return(mUserName);
	}
	void setUserPassword(String value)
	{
		mUserPassword=value;
	}
	String getUserPassword()
	{
		return(mUserPassword);
	}

	static int getCodeFromUserName(String value)
	{
		return(dlsNewUserForm.getCodeFromUserName(value));
	}



	static void showNewUserForm(clsNewUserForm temp)
	{
		System.out.println("User ID      		   :=>    "+temp.getUserID());
		System.out.println("First Name   		   :=>    "+temp.getFirstName());
		System.out.println("Last Name    		   :=>    "+temp.getLastName());
		System.out.println("Birth Month  		   :=>    "+temp.getBirthMonth());
		System.out.println("Birth Date  		   :=>    "+temp.getBirthDate());
		System.out.println("Birth Year             :=>    "+temp.getBirthYear());
		System.out.println("Gender                 :=>    "+temp.getGender());
		System.out.println("Email ID               :=>    "+temp.getEmailID());
		System.out.println("Country ID 			   :=>    "+temp.getCountryID());
		System.out.println("User Name   		   :=>    "+temp.getUserName());
		System.out.println("User Password          :=>    "+temp.getUserPassword());
		System.out.println("Color Scheme Data ID   :=>    "+temp.getColorSchemeDataID());
		System.out.println("Security Question      :=>    "+temp.getSecurityQuestionID());
		System.out.println("Security Answer        :=>    "+temp.getSecurityAnswer());
	}

	static void addNewUser(clsNewUserForm temp)
	{
		dlsNewUserForm.addNewUser(temp);
	}
	static int getColorSchemeCode(int code)
	{
		return(dlsNewUserForm.getColorSchemeCode(code));
	}
	static clsNewUserForm getNewUser(int Codes)
	{
		return(dlsNewUserForm.getNewUser(Codes));
	}

	static int getVerification(String UserName,String Pasword)
	{
		return(dlsNewUserForm.getVerification(UserName,Pasword));
	}
	public static void main(String args[])
	{




		/*clsNewUserForm obj=new clsNewUserForm();
		obj.setUserID(0);
		obj.setFirstName("KJ");
		obj.setLastName("SP");
		obj.setBirthMonth("NOV");
		obj.setBirthDate(8);
		obj.setBirthYear(2001);
		obj.setGender(2);
		obj.setEmailID("fjhcg");
		obj.setCountryID(3);
		obj.setUserName("jkl");
		obj.setUserPassword("jh");
		obj.setColorSchemeDataID(12);
		dlsNewUserForm.addNewUser(obj);*/

		//int code=clsNewUserForm.getColorSchemeCode(4);
		//System.out.println(code);

	}

}