package repository;

import entity.Document;
import entity.Request;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DocumentRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewDocument(Document doc) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(doc);
        em.getTransaction().commit();
        em.close();
    }

    public void  deleteDocument(Document doc)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        doc=em.find(Document.class,doc.getId());
        em.remove(doc);
        em.getTransaction().commit();


    }
    public void updateDoc( Document doc,String type)
    {   EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        doc.setType(type);
        em.getTransaction().commit();

    }
    public void deleteDocumentById( String id)
    {

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Document doc=em.find(Document.class,id);
        em.remove(doc);
        em.getTransaction().commit();

    }
    public void insertNewDocumentById(String id,String type)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Document doc = new Document(id,type);
        em.persist(doc);
        em.getTransaction().commit();
        em.close();
    }
    public List<Document> getAllDocuments()
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Document > query = em.createQuery("SELECT u FROM Document u",Document.class);
        List<Document> documents = query.getResultList();


        em.getTransaction().commit();
        em.close();
        return documents;

    }
    public List<String> getAllDocumentsTypes()
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<String > query = em.createQuery("SELECT u.type FROM Document u",String.class);
        List<String> documents = query.getResultList();


        em.getTransaction().commit();
        em.close();
        return documents;

    }

}
