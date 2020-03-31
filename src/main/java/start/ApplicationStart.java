package start;

import Presentation.LoginView;
import Presentation.MainController;
import entity.Administrator;
import entity.User;
import repository.AdministratorRepo;
import repository.RequestRepo;
import repository.UserRepo;

import java.lang.reflect.Field;
import java.util.UUID;

public class ApplicationStart {

    private static User user;
    private String name;

    public static void main(String[] args) {
        UserRepo ur = new UserRepo();
        user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("Todoran");

        //ur.insertNewUser(user);

      //  AdministratorRepo  adminRepo = new AdministratorRepo();
      // Administrator admin = adminRepo.findById("55");
     // .. admin.setId("55");


        //adminRepo.updateUsername(admin,"Priscila");
        //System.out.println("admin ="+ adminRepo.getAdminByUsername("Amalia").getUsername());
       // LoginView loginView = new LoginView();
       MainController controler = new MainController();


       // loginView.setVisible(true);



    }
}
