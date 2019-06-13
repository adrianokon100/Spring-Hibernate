package com.poker.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity
@Table(name="player")
public class Player {
	
	
	// fields + annotations
	
	@Id
	@Column(name="id_player")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@Size(min = 3, max = 25)
	@Column(name="firstName")
	private String firstName;
	
	@Size(min = 3, max = 25)
	@Column(name="lastName")
	private String lastName;
	
	@Email
	@Pattern(regexp="^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]{1,})*\\.([a-zA-Z]{2,}){1}$")
	@Column(name="email")
	private String email;
	
	@Pattern(regexp="[0-9]{11}")
	@Column(name="pesel")
	private String pesel;
	
	@NotNull
	@Min(value = 18)
	@Column(name="age")
	private int age;
	
	@Size(min = 3, max = 50)
	@Column(name="city")
	private String city;
	
	@ManyToMany
	@JoinTable(
			name="player_tournament",
			joinColumns=@JoinColumn(name="id_player"),
			inverseJoinColumns=@JoinColumn(name="id_tournament")
			)
	private List<Tournament> tournaments;
	
	// constructors
	
	public Player() {
	}


	public Player(String firstName, String lastName, String email, String pesel, int age, String city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pesel = pesel;
		this.age = age;
		this.city = city;
	}


	// getter / setter methods
		
	public List<Tournament> getTournaments() {
		return tournaments;
	}


	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPesel() {
		return pesel;
	}


	public void setPesel(String pesel) {
		this.pesel = pesel;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Player [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", pesel=" + pesel + ", age=" + age + ", city=" + city + "]";
	}
	
	
}
