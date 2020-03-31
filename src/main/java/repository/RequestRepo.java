package repository;

import entity.*;

import javax.persistence.*;
import java.lang.reflect.ReflectPermission;
import java.util.List;

public class RequestRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewRequest(Request request) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(request);
        em.getTransaction().commit();
        em.close();
    }

    public void  deleteRequest(Request request)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        request= em.find(Request.class,request.getId());
        em.remove(request);
        em.getTransaction().commit();


    }
    public void updateAproval( Request request,boolean maybe)
    {   EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        request= em.find(Request.class,request.getId());
        request.setAproved(maybe);
        em.getTransaction().commit();

    }
    public void updateAprovalById( String id,boolean maybe)
    {   EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
       Request request= em.find(Request.class,id);
        request.setAproved(maybe);
        em.getTransaction().commit();

    }

    public Request findRequestById(String req)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Request request= em.find(Request.class, req);

        em.getTransaction().commit();

        return request;
    }
    public void  deleteRequestById(String id)
       {
           EntityManager em = entityManagerFactory.createEntityManager();
           em.getTransaction().begin();
           Request request= em.find(Request.class,id);

           em.remove(request);

           em.flush();
           em.clear();
           em.getEntityManagerFactory().getCache().evictAll();
           em.getTransaction().commit();

       }

    public List<Request> getAllRequest()
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Request > query = em.createQuery("SELECT u FROM Request u",Request.class);
        List<Request> requests = query.getResultList();


        em.getTransaction().commit();
        em.close();
        return requests;

    }
    public List<Request> getAllRequestOrderBy()
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Request > query = em.createQuery("SELECT u FROM Request u order by u.id asc",Request.class);
        List<Request> requests = query.getResultList();


        em.getTransaction().commit();
        em.close();
        return requests;

    }
    public List<Request> getAllRequestByUser(User id)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Request > query = em.createQuery("SELECT u FROM Request u WHERE u.user = ?1",Request.class);
        query.setParameter(1,id);
        List<Request> requests = query.getResultList();

        em.getTransaction().commit();
        em.close();
        return requests;

    }
    public void countReuquest(User user, Document doc, Adress adress)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Request > query = em.createQuery("SELECT u FROM Request u WHERE u.user = ?1 and u.documentType= ?2",Request.class);
        query.setParameter(1,user);
        query.setParameter(2,doc);
        List<Request> requests = query.getResultList();
        for(Request r : requests)
        {
           // System.out.println("rezultatele sunt " +r.getRequestDate());
        }

        em.getTransaction().commit();
        em.close();
    }

    public void updateRequest(Request request) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(request);
        em.getTransaction().commit();
        em.close();
    }




}
