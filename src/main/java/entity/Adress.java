package entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Adress")


public class Adress {

    public String getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Adress(String street,String number)
       {
           this.number=number;
           this.street = street;
       }
       public Adress()
       {

       }
    @Id
    private String id;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Column
    private String street;
    private String number;

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    @ManyToOne
    @JoinColumn (name ="user_id")
    private User user_id;

    @OneToMany(mappedBy ="adress",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Set<Request> request;




}
