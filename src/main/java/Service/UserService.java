package Service;

import entity.Adress;
import entity.Document;
import entity.User;
import repository.UserRepo;

import java.util.ArrayList;
import java.util.List;

public class UserService {


    UserRepo userRepo = new UserRepo();

    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    public boolean isUsernameExistent(String username)
    {
        return userRepo.isUsernameExistent(  username);
    }

    public boolean isUserExistent(String username,String password)
    {
       return  userRepo.isUserExistent(username,password);
    }

    public void insertNewUser(User user)
        {
            userRepo.insertNewUser(user);
        }
        public User findUserByUsername(String username)
        {
            return userRepo.findUserByName(username);
        }

        public List<String> getAdresses(User user)
        {
            List<String> newList= new ArrayList<String>();
            for(Adress a: user.getAdresses())
            {
                newList.add(""+a.getStreet()+" " +a.getNumber());
            }
            return newList;

        }


      public void updateUser(User user)
      {
          userRepo.updateUser( user);
      }




}
