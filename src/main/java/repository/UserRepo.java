package repository;

import entity.Administrator;
import entity.Request;
import entity.User;

import javax.persistence.*;
import java.util.List;

public class UserRepo {
	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");
	
	public void insertNewUser(User user) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}
    public List<User> getAllUsers()
	{
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		TypedQuery<User > query = em.createQuery("SELECT u FROM User u",User.class);
		List<User> users = query.getResultList();


		em.getTransaction().commit();
		em.close();
		return users;

	}
	public boolean isUserExistent( String username,String password)
	{
		EntityManager em = entityManagerFactory.createEntityManager();
		TypedQuery<User>  query = em.createQuery("SELECT a FROM User a WHERE a.name = ?1",User.class );
		try{
			User user =query.setParameter(1,username).getSingleResult();
			if(user.getPassword().equals(password))
			{
				return true;
			}
		}
		catch (NoResultException e)
		{
			return false;
		}
		return false;
	}
	public boolean isUsernameExistent( String username)
	{
		EntityManager em = entityManagerFactory.createEntityManager();
		TypedQuery<User>  query = em.createQuery("SELECT a FROM User a WHERE a.name = ?1",User.class );
		try{
			query.setParameter(1,username).getSingleResult();
		}
		catch (NoResultException e)
		{
			return false;
		}
		return true;
	}
	public User findUserByName( String username)
	{
		EntityManager em = entityManagerFactory.createEntityManager();
		TypedQuery<User>  query = em.createQuery("SELECT a FROM User a WHERE a.name = ?1",User.class );
		try{
			User user = query.setParameter(1,username).getSingleResult();
			return user;
		}
		catch (NoResultException e)
		{
			return new User();
		}

	}

	public void updateUser(User user) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		em.close();
	}




}
