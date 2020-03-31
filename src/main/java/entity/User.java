package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	private String id;
	
	@Column
	private String name;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;

	public User(String name) {
		this.name = name;
	}
	
	public User() {}
	public User(String name,String password)
	{
		this.name=name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	@OneToMany(mappedBy ="user",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
	private Set<Request> requests ;


	public Set<Request> getRequests() {
		return requests;
	}

	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}



	@OneToMany(mappedBy ="user_id",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
	private Set<Adress> adresses;
	public Set<Adress> getAdresses() {
		return adresses;
	}

	public void setAdresses(Set<Adress> adresses) {
		this.adresses = adresses;
	}


}
