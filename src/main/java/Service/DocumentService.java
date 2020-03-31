package Service;

import entity.Document;
import repository.DocumentRepo;

import java.util.List;
import java.util.stream.Collectors;

public class DocumentService {



    private DocumentRepo docRepo = new DocumentRepo();




    public void deleteDocumentType(Document doc)
    {
        docRepo.deleteDocument(doc);
    }
    public void deleteByiD(String id)
    {
        docRepo.deleteDocumentById(id);
    }
    public void insertNewDocument(Document doc)
    {
        docRepo.insertNewDocument(doc);
    }
    public void insertNewDocumentById(String id,String type)
    {
        docRepo.insertNewDocumentById(id,type);
    }
    public List<Document> getAllDocuments()
    {
        return docRepo.getAllDocuments();
    }
    public List<String> getAllDocumentTypes()
    {
        return docRepo.getAllDocumentsTypes();
    }

   public List<String> getAllDocumentTypesAsString()
   {
       List<String>  lista =   (docRepo.getAllDocuments()).stream()
               .map(l->l.getType())
               .collect(Collectors.toList());
       System.out.println(lista);
       return lista;

   }

}
