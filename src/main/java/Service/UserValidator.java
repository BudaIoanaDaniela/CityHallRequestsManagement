package Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    private UserService userService = new UserService();

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


    public  boolean isUserExistent(String username,String password)
    {
        return userService.isUserExistent(username,password);
    }
    public  boolean isUsernameExistent(String username)
    {
        return userService.isUsernameExistent(username);
    }


}
