package Presentation;


import Service.*;
import entity.*;

import javax.swing.*;
import java.util.Date;
import java.util.UUID;

public class MainController {



    LoginView view;


    AdministratorService adminService = new AdministratorService();
    AdminValidator adminValidator = new AdminValidator();
    UserService userService = new UserService();
    AdminView adminView = new AdminView();
    UserViewByAdmin userViewByAdmin = new UserViewByAdmin();
    UserRegistrationView userRegistrationView = new UserRegistrationView();
    UserValidator userValidator = new UserValidator();
    UserAdressView userAdressView = new UserAdressView();
    User user = new User();
    String msgErrorNull ="Requiered fields cannot be left blank";
    String msgUsernameOrPasswordInvalid="Username or password invalid";
    String msgUsernameExistent = "Username existent";
    String msgAccountNotExistent = "Account not existent";
    String msgSuccesLogin ="Succefully logeed in";
    Date date = new Date();

   // UserService userService = new UserService();
    public MainController()
    {

        view = new LoginView();
        view.setVisible(true);
        initializeButtonListeners();


    }
    private void initializeButtonListeners()
    {

        view.adminButton.addActionListener(e->
        {
          //  Administrator admin= new Administrator(view.getUsername(),view.getPassword());
           // admin.setId(UUID.randomUUID().toString());
            //AdministratorRepo admin2 = new AdministratorRepo();
           // admin2.insertNewAdministrator(admin);
            if(AdminValidator.isAccountInfoValid(view.getUsername(),view.getPassword()) && adminValidator.isUsernameValid(view.getUsername()))
            {

                              if(adminValidator.isAdminExistent(view.getUsername(),view.getPassword()))
                              {
                                  JOptionPane.showMessageDialog(adminView,msgSuccesLogin);
                                  Administrator admin = adminService.findAdminByName(view.getUsername());
                                  AdministratorController adminController = new AdministratorController(admin);
                                  //adminView.setVisible(true);

                              }
                              else
                                {
                                    JOptionPane.showMessageDialog(adminView,msgAccountNotExistent);
                                }

            }
            else{
                JOptionPane.showMessageDialog(adminView,msgUsernameOrPasswordInvalid);
            }

        });

        view.buttonUserLogin(e->{
            if(UserValidator.isAccountInfoValid(view.getUsername(),view.getPassword())&&userValidator.isUsernameValid(view.getUsername()))
            {

                if(userValidator.isUserExistent(view.getUsername(),view.getPassword()))
                { User user = userService.findUserByUsername(view.getUsername());
                    UserController userController = new UserController(user);
                    JOptionPane.showMessageDialog(view,msgSuccesLogin);
                }
                else{
                    JOptionPane.showMessageDialog(view,msgAccountNotExistent);
                }

            }
            else
            {
                JOptionPane.showMessageDialog(view,msgUsernameOrPasswordInvalid);
            }
    });


       view.buttonRegistrationL(e-> {
                   userRegistrationView.setVisible(true);

               });
       userRegistrationView.btnRegisterActionListener(e->{
           if (UserValidator.isAccountInfoValid(userRegistrationView.getUsername(), userRegistrationView.getPassword()) && userValidator.isUsernameValid(userRegistrationView.getUsername())) {

               if (!userValidator.isUsernameExistent(userRegistrationView.getUsername())) {
                   JOptionPane.showMessageDialog(userRegistrationView,msgSuccesLogin);
                   User user = new User(userRegistrationView.getUsername(), userRegistrationView.getPassword());
                   user.setId(UUID.randomUUID().toString());
                   userService.insertNewUser(user);

               }
                  else {
                  JOptionPane.showMessageDialog(userRegistrationView,msgUsernameExistent);


               }
           }

       });








    }

}

