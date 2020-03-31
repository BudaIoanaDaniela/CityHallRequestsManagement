package entity;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table( name = "document")

public class Document   {

    @Id

    private String id;


    public Document(String id,String type) {
        this.id = id;
        this.type = type;
    }
    public Document()
    {

    }
    @Column(nullable = false)
    private String type;

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    @OneToMany(mappedBy = "documentType",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Set<Request> request;



}
