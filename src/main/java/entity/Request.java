package entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "request")



public class Request {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id

    private String id;

    @Column

    private Date  requestDate;
    @ManyToOne
    @JoinColumn (name ="user_id")
    private User user;

    @ManyToOne
    @JoinColumn (name ="adress_id")
    private Adress adress;



    public boolean isAproved() {
        return isAproved;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public void setAproved(boolean aproved) {
        isAproved = aproved;
    }

    private boolean isAproved;

    public Document getDocumentType() {
        return documentType;
    }
    public String getDocumentTypeString()
    {
        return documentType.getType();
    }

    public void setDocumentType(Document documentType) {
        this.documentType = documentType;
    }

    public Adress getAdress() {
        return adress;
    }
    public String getAdressAsString() {
        return adress.getStreet();
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @ManyToOne
    @JoinColumn (name = "documentType")
    private Document documentType;

    public User getUser() {
        return user;
    }
    public String getUserAsString() {
        return user.getName();
    }

    public void setUser(User user) {
        this.user = user;
    }

}
