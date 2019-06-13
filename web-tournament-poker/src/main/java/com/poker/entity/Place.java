package com.poker.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="place")
public class Place {
	
	// fields + annotations
	
	@Id
	@Column(name="id_place")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Size(min = 3, max = 50)
	@Column(name="name")
	private String name;
	
	@Size(min = 3, max = 50)
	@Column(name="city")
	private String city;

	@Column(name="description")	
	private String description;

/*	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_place")
	private List<Tournament> tournaments;
*/	
	@OneToMany(mappedBy="place", cascade={CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
	private List<Tournament> tournaments;

	//constructors
	
	public Place() {
		
	}
	
	public Place(String name, String city, String description) {
		this.name = name;
		this.city = city;
		this.description = description;
	}

	
	// getter / setter methods
	
	
	
	public int getId() {
		return id;
	}



	public List<Tournament> getPlaces() {
		return tournaments;
	}

	public void setPlaces(List<Tournament> places) {
		this.tournaments = places;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// add convenience methods for bi-directional relationship
	
	public void add(Tournament tempTournament) {
		
		if(tournaments == null) {
			tournaments = new ArrayList<Tournament>();
		}
		
		tournaments.add(tempTournament);
		//tempTournament.setPlace(this);
		
		
	}
	
	

}







