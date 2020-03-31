package Presentation;

import Service.*;
import entity.*;

import javax.swing.*;
import java.util.Date;

public class AdministratorController {

    Administrator admin = new Administrator();
    UserService userService = new UserService();
    AdministratorService adminService = new AdministratorService();
    AdminValidator adminValidator = new AdminValidator();
    DocumentView docView = new DocumentView();
    RequestView requestView = new RequestView();
    DocumentService docService = new DocumentService();
    RequestService requestService = new RequestService();
    AdminView adminView = new AdminView();
    UserViewByAdmin userViewByAdmin = new UserViewByAdmin();
    String msgSucces = "Succesfully done";
    String msgObjSelection ="Please choose a record";

    public AdministratorController( Administrator admin)
    {
        this.admin = admin;
        adminView.setVisible(true);
        intializeButtonListeners(admin);
    }
    public void intializeButtonListeners(Administrator admin)
    {

        adminView.btnAccessUsers(e->{
                    userViewByAdmin.setVisible(true);
                    userViewByAdmin.setTable(userService.getAllUsers(),new User());
                }
        );
        adminView.btnAccessDocuments(e->{
            docView.setVisible(true);
            docView.setTable(docService.getAllDocuments(),new Document());
        });
        adminView.btnAccessrRequests(e->{
            requestView.setVisible(true);
          //  requestView.setTable(requestService.getAllRequest(),new Request());
            requestView.setTable(requestService.sortByDate(),new Request());
        });

        docView.setBtnAdd(e->{
            try {
                if(docView.getId()!=null && docView.getNewType()!=null) {
                    docService.insertNewDocumentById(docView.getId(), docView.getNewType());
                    docView.setTable(docService.getAllDocuments(), new Document());
                    JOptionPane.showMessageDialog(docView,msgSucces);

                }
                else{
                    JOptionPane.showMessageDialog(docView,"Invalid Document Type or Id");
                }

            }
            catch(Exception exc)
            {
                JOptionPane.showMessageDialog(docView,"Invalid Document Type or Id");
            }



        });

        docView.setBtnDelete(e->{
           try {
               docService.deleteByiD(docView.getSelectedItem());
               docView.setTable(docService.getAllDocuments(), new Document());
           }
           catch( Exception ex)
           {
               JOptionPane.showMessageDialog(docView,msgObjSelection);
           }

        });

        requestView.setBtnDelete(e->{
            try {
                requestService.deleteById(requestView.getSelectedItem());
                requestView.setTable(requestService.getAllRequest(), new Request());
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(docView,msgObjSelection);
            }


        });
        requestView.setbtnAproval(e->{
            try {

                requestService.updateAprovalById(requestView.getSelectedItem(), true);

                requestView.setTable(requestService.getAllRequest(), new Request());
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(requestView,msgObjSelection);
            }

        });
        requestView.btnSortByActionListener(e->{
            try {
                if (requestView.getSelectedValue().toString().equals("Adress")) {
                    System.out.print("yes " + requestView.getSelectedValue().toString());
                    requestView.setTable(requestService.sortByAdress(), new Request());
                }
                if (requestView.getSelectedValue().toString().equals("Date")) {
                    System.out.print("yes " + requestView.getSelectedValue().toString());
                    requestView.setTable(requestService.sortByDate(), new Request());
                }
                if (requestView.getSelectedValue().toString().equals("Document")) {
                    System.out.print("yes " + requestView.getSelectedValue().toString());
                    requestView.setTable(requestService.sortByDocumentType(), new Request());
                }
                if (requestView.getSelectedValue().toString().equals("User")) {
                    System.out.print("yes " + requestView.getSelectedValue().toString());
                    requestView.setTable(requestService.sortByUser(), new Request());
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(requestView,msgObjSelection);
            }


        });

        requestView.btnFilterByActionListener(e->
        {
            try {
                if (requestView.getSelectedValue().toString().equals("Adress")) {


                    Adress adress = requestService.findRequestById(requestView.getSelectedItem()).getAdress();
                    JOptionPane.showMessageDialog(requestView, adress.getStreet());
                    requestView.setTable(requestService.filterByDocumentAdress(adress), new Request());
                }
                if (requestView.getSelectedValue().toString().equals("Date")) {
                    Date date = requestService.findRequestById(requestView.getSelectedItem()).getRequestDate();

                    requestView.setTable(requestService.filterByDate(date), new Request());
                }
                if (requestView.getSelectedValue().toString().equals("Document")) {
                    Document doc = requestService.findRequestById(requestView.getSelectedItem()).getDocumentType();
                    requestView.setTable(requestService.filterByDocumentType(doc), new Request());
                }
                if (requestView.getSelectedValue().toString().equals("User")) {
                    User user = requestService.findRequestById(requestView.getSelectedItem()).getUser();
                    requestView.setTable(requestService.filterByUser(user), new Request());
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(requestView,msgObjSelection);
            }
        });

    }
    
}
