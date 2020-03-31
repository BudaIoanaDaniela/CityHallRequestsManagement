package Presentation;

import Service.*;
import entity.Adress;
import entity.Document;
import entity.Request;
import entity.User;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UserController {


    UserService userService = new UserService();
    DocumentView docView = new DocumentView();
    RequestView requestView = new RequestView();
    DocumentService docService = new DocumentService();
    RequestService requestService = new RequestService();
    AdminView adminView = new AdminView();
    UserViewByAdmin userViewByAdmin = new UserViewByAdmin();

    UserRegistrationView userRegistrationView = new UserRegistrationView();
    UserValidator userValidator = new UserValidator();
    UserAdressView userAdressView = new UserAdressView();
    UserRequestView userRequestView = new UserRequestView();
    AdressService adressService = new AdressService();
    User user ;
    //Date now = LocalDateTime.now();
    Date date = new Date();
    String msgObjSelection ="Please choose a record";
    String msgSucces = "Succesfully done";

    public UserController(User user)
    {
        this.user = user;

        userAdressView.setVisible(true);
        userAdressView.setTable(adressService.getAdressesByUser(user),new Adress());
        initializeButtonListeners(user);


    }

    public void initializeButtonListeners(User user)
    {

        userAdressView.addAdressActionListener(e->{
            try {
                Adress adress = new Adress(userAdressView.getAdresStreet(), userAdressView.getAdressNr());
                if(userAdressView.getAdressNr().length()!=0 && userAdressView.getAdresStreet().length()!=0) {
                    adress.setId(UUID.randomUUID().toString());
                    adress.setUser_id(user);
                    userService.updateUser(user);
                    adressService.insertAdress(adress);
                    userAdressView.setTable(adressService.getAdressesByUser(user), new Adress());
                }
                else{
                    JOptionPane.showMessageDialog(userAdressView,"Invalid Adress or nr");
                }

            }
            catch( Exception ex)
            {
                JOptionPane.showMessageDialog(userAdressView,"Invalid Adress or nr");
            }
        });


        userAdressView.deleteAdressActionListener(e ->{
             try {
                 adressService.deleteById(userAdressView.getSelectedItem());
                 userAdressView.setTable(adressService.getAdressesByUser(user), new Adress());
             }
             catch(Exception ex)
             {
                 JOptionPane.showMessageDialog(userAdressView,msgObjSelection);
             }
        });

        userAdressView.setBtnAccesRequest(e->{

            userRequestView.setVisible(true);
            userRequestView.setTable(user.getRequests(),new Request());
            userRequestView.addDocuments(docService.getAllDocumentTypesAsString());
            userRequestView.addAdresses(userService.getAdresses(user));
            userRequestView.addRealAdresses(user.getAdresses());
            userRequestView.addDocuments2(docService.getAllDocuments());

        });
        userRequestView.addBtnActionlistener(e-> {
                    userRequestView.addRealAdresses(user.getAdresses());
                    userRequestView.addDocuments2(docService.getAllDocuments());
                    try {
                        Document doc = userRequestView.getSelectedType2();
                        Adress adress = userRequestView.getSelectedAdress();
                        Request request = new Request();
                        request.setAproved(false);
                        request.setAdress(adress);
                        request.setDocumentType(doc);
                        request.setUser(user);
                        request.setRequestDate(new Date());
                        System.out.print(requestService.isRequestPosible(user, adress, doc));
                        request.setId(UUID.randomUUID().toString());

                        //requestService.CountReq(user,doc,adress);

                        if (!requestService.isRequestPosible(user, adress, doc)) {
                            JOptionPane.showMessageDialog(userRequestView, "Numarul maxim de cereri a fost atins");
                        }
                        else {
                            requestService.insertNewRequest(request);
                            JOptionPane.showMessageDialog(userRequestView, "Cererea a fost inregistrata");

                        }
                    }
                        catch (Exception ex) {
                        JOptionPane.showMessageDialog(userRequestView, msgObjSelection);
                    }



            userRequestView.setTable(requestService.getAllRequestByUser(user),new Request());} ) ;



        userRequestView.deleteBtnActionlistener(e->{

            try {
                requestService.deleteById(userRequestView.getSelectedItem());
                // userRequestView.setTable(user.getRequests(),new Request());
                userRequestView.setTable(requestService.getAllRequestByUser(user), new Request());
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(userRequestView, msgObjSelection);
            }



        });

        userRequestView.updateAdress(e->
        {
            try {
                userRequestView.addRealAdresses(user.getAdresses());
                userRequestView.addDocuments2(docService.getAllDocuments());
                Adress adress = userRequestView.getSelectedAdress();
                Request red = requestService.findRequestById(userRequestView.getSelectedItem());
                red.setAdress(adress);
                requestService.updateRequest(red);
                userRequestView.setTable(requestService.getAllRequestByUser(user), new Request());
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(userRequestView,msgObjSelection);
            }


        });

        userRequestView.updateType(e->
        {   userRequestView.addRealAdresses(user.getAdresses());
            userRequestView.addDocuments2(docService.getAllDocuments());
            try {
                Document doc = userRequestView.getSelectedType2();
                Request red = requestService.findRequestById(userRequestView.getSelectedItem());
                red.setDocumentType(doc);
                requestService.updateRequest(red);
                userRequestView.setTable(requestService.getAllRequestByUser(user), new Request());

            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(userRequestView, msgObjSelection);
            }


        });

    }

}
