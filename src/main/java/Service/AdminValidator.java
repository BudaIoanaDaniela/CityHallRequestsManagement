package Service;

import entity.Administrator;
import repository.AdministratorRepo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminValidator {

    AdministratorService adminService= new AdministratorService();

    public static boolean isAccountInfoValid(String username, String password)
    {


        if(username!=null && password !=null)
        {
            if(username.length() >5 && password.length()>
                    5)

                return true;


        }

        return false;
    }

    public boolean isUsernameValid(String username)
    {
        Pattern pattern = Pattern.compile("^.+@.+\\..+$");
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }


    public  boolean isAdminExistent(String username,String password)
    {
        return adminService.isAdminExistent(username,password);
    }

}
