package entity;
import javax.persistence.*;

@Entity
@Table (name = "administrator")

public class Administrator {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id

    private String id;


    @Column
    private String username;


    public String getUsername() {
        return username;
    }
     public Administrator()
     {

     }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;


    public Administrator(String username,String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername( String username)
    {
        this.username=username;
    }


}
