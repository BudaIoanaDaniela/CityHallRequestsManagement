package Service;

import entity.Adress;
import entity.Document;
import entity.Request;
import entity.User;
import repository.RequestRepo;

//import java.util.Calendar;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class RequestService {


    Date date ;
    Calendar calendar = Calendar.getInstance();

    RequestRepo requestRepo = new RequestRepo();

    public void updateAproval(Request req,boolean maybe)
    {
       requestRepo.updateAproval(req,maybe);
    }

    public void updateAprovalById(String id,boolean maybe)
    {
        requestRepo.updateAprovalById(id,maybe);
    }
     public void deleteById(String id)
     {
         requestRepo.deleteRequestById(id);
     }

    public List<Request> getAllRequest()
    {
        return  requestRepo.getAllRequest();
    }


    public void  insertNewRequest(Request request)
    {
        requestRepo.insertNewRequest(request);
    }

    public boolean isRequestPosible(User user, Adress adr, Document doc) {
        Calendar calendarAcum = Calendar.getInstance();
        calendarAcum.setTime(new Date());
        int count = 0;
        for (Request req :getAllRequestByUser(user) ){
            System.out.println("Avem req=" + req.getRequestDate());
            System.out.println("Avem req adress1=" + req.getAdress());
            if (req.getDocumentType().getType().equals(doc.getType()) ){
                System.out.println("Avem doc=" + req.getDocumentType().getType());
                System.out.println("Avem req adress2=" + req.getAdress());
                System.out.println("Avem req adress3=" + adr);
                if (req.getAdress().getStreet().equals(adr.getStreet())&& req.getAdress().getNumber().equals(req.getAdress().getNumber())) {
                    System.out.println("Avem adr=" + req.getAdress().getStreet());
                    calendar.setTime(req.getRequestDate());
                    if (calendar.get(Calendar.YEAR) == calendarAcum.get(Calendar.YEAR)) {
                        count = count + 1;
                    }
                }

            }
            System.out.println("" + count);



        }
        if (count >=3) {
            return false;
        }

        return true;
    }
    public Request findRequestById(String id)
    {
        return requestRepo.findRequestById(id);
    }
    public List<Request> getAllRequestByUser(User id)
    {
        return  requestRepo.getAllRequestByUser(id);
    }



    public void CountReq(User user, Document doc,Adress add)
    {
        requestRepo.countReuquest(user,doc,add);
    }

    public void updateRequest (Request req)
    {
          requestRepo.updateRequest(req);
    }
    public List<Request> getAllRequestsOrderby()
        {
            return requestRepo.getAllRequestOrderBy();
        }


   public List<Request>    sortByDocumentType()
   {
        List<Request> lista = getAllRequest();

       List<Request> sortedList = lista.stream()
               .sorted(Comparator.comparing(Request::getDocumentTypeString))
               .collect(Collectors.toList());
       return sortedList;
   }
   public List<Request> sortByDate()
   {
       List<Request> lista = getAllRequest();

       List<Request> sortedList = lista.stream()
               .sorted(Comparator.comparing(Request::getRequestDate))
               .collect(Collectors.toList());
       return sortedList;
   }

   public List<Request> sortByAdress()
   {
       List<Request> lista = getAllRequest();

       List<Request> sortedList = lista.stream()
               .sorted(Comparator.comparing(Request::getAdressAsString))
               .collect(Collectors.toList());
       return sortedList;
   }
    public List<Request> sortByUser()
    {

        return requestRepo.getAllRequestOrderBy();
    }
   public List<Request> filterByDate(Date date)
   {
       List<Request> lista = getAllRequest();
       List<Request> filtered = lista.stream()
               .filter(a->a.getRequestDate().equals(date))
               .collect(Collectors.toList());
       return filtered;
   }
    public List<Request> filterByDocumentType(Document doc)
    {
        List<Request> lista = getAllRequest();
        List<Request> filtered = lista.stream()
                .filter(a->a.getDocumentType().getId().equals(doc.getId()))
                .collect(Collectors.toList());
        return filtered;
    }
    public List<Request> filterByDocumentAdress(Adress adress)
    {
        List<Request> lista = getAllRequest();
        List<Request> filtered = lista.stream()
                .filter(a->a.getAdress().getId().equals(adress.getId()))
                .collect(Collectors.toList());
        System.out.println("\n"+adress.toString());

        return filtered;
    }
    public List<Request> filterByUser(User user)
    {

        return requestRepo.getAllRequestByUser(user);
    }


}
