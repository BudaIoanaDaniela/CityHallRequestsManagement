package repository;

import entity.Administrator;
import entity.User;

import javax.persistence.*;
import java.util.UUID;


public class AdministratorRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewAdministrator(Administrator administrator) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(administrator);
        em.getTransaction().commit();
        em.close();
    }

    public Administrator insertNewAdministratorByName(String username,String password) {
        Administrator admin = new Administrator(username,password);
        admin.setId(UUID.randomUUID().toString());
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(admin);
        em.getTransaction().commit();
        em.close();
        return admin;
    }
    public void  deleteAdministrator(Administrator admin)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.find(Administrator.class,admin.getId());

        em.getTransaction().begin();
        if(em.contains(admin)) {

            em.remove(em.contains(admin));
        }
        else
        {

            em.remove( em.merge(admin));
        }
        em.getTransaction().commit();


    }







    public void updateUsername( Administrator admin,String newUsername)
    {   EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        admin =em.find(Administrator.class,admin.getId());

        admin.setUsername(newUsername);
        System.out.println(admin.getUsername());
        em.getTransaction().commit();
        em.close();

    }

    public void updatePassword( Administrator admin,String newPassword)
    {   EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        admin =em.find(Administrator.class,admin.getId());
        admin.setPassword(newPassword);
        em.getTransaction().commit();

    }

    public Administrator findById( String id)
    {  EntityManager em = entityManagerFactory.createEntityManager();
        Administrator admin = em.find(Administrator.class,id);
       System.out.println(admin.getUsername());
        return admin;
    }

    public Administrator getAdminByUsername( String username)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        TypedQuery<Administrator>  query = em.createQuery("SELECT a FROM Administrator a WHERE a.username = ?1",Administrator.class );
        return query.setParameter(1,username).getSingleResult();
    }

    public boolean isUsernameUsed( String username)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        TypedQuery<Administrator>  query = em.createQuery("SELECT a FROM Administrator a WHERE a.username = ?1",Administrator.class );
         try{
        query.setParameter(1,username).getSingleResult();
         }
         catch (NoResultException e)
        {
            return true;
        }
        return false;
    }
    public boolean isAdminCorrect(String username,String password)
    {

        EntityManager em = entityManagerFactory.createEntityManager();
        TypedQuery<Administrator>  query = em.createQuery("SELECT a FROM Administrator a WHERE a.username = ?1",Administrator.class );
        try{
           Administrator admin= query.setParameter(1,username).getSingleResult();
           if( admin.getPassword().equals(password))
           {
               return true;
           }
        }
        catch (Exception e)
        {
            return false;
        }
        return false;

    }




}

