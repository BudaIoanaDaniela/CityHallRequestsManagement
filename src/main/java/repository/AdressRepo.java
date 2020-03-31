package repository;

import entity.Administrator;
import entity.Adress;
import entity.Request;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class AdressRepo {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewAdress(Adress adress) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(adress);
        em.getTransaction().commit();
        em.close();
    }


    public void  deleteRequestById(String id)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Adress adress = em.find(Adress.class,id);

        em.remove(adress);
        em.getTransaction().commit();
    }

    public List<Adress> getAllAdresses()
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Adress> query = em.createQuery("SELECT u FROM Adress u",Adress.class);
        List<Adress> users = query.getResultList();


        em.getTransaction().commit();
        em.close();
        return users;

    }
    public List<Adress> getAllAdressesByUser(User user)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();



        TypedQuery<Adress > query = em.createQuery("SELECT u FROM Adress u WHERE u.user_id = ?1",Adress.class);
        query.setParameter(1,user);
        List<Adress> users = query.getResultList();

        em.getTransaction().commit();
        em.close();
        return users;

    }
    public void getUserAdresses(String id)
    {

    }






}
