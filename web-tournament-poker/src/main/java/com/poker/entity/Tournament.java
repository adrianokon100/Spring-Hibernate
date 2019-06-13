package com.poker.entity;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tournament")
public class Tournament {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tournament")
	private int id;
	
	@NotEmpty
	@Size(min = 3, max = 50)
	@Column(name="name")
	private String name;

	@Range(min=1, max=100000)
	@Column(name="max_players")
	private int maxPlayers;
	
	@Range(min = 1, max = 100000)
	@Column(name="min_players")
	private int minPlayers;
	
	//@DateTimeFormat(pattern = "yy-MM-dd") - not working
	//@Future - is not working too
	
	@Column(name="startDate")
	private Date startDate;
	
	@Column(name="startTime")	
	private Time startTime;
	

	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="id_place")
	private Place place;
	
	@ManyToMany
	@JoinTable(
			name="player_tournament",
			joinColumns=@JoinColumn(name="id_tournament"),
			inverseJoinColumns=@JoinColumn(name="id_player")
			)
	private List<Player> players;
	
	// constructors
	
	public Tournament() {
		
	}


	public Tournament(String name, int maxPlayers, int minPlayers, Date startDate, Time startTime) {
		super();
		this.name = name;
		this.maxPlayers = maxPlayers;
		this.minPlayers = minPlayers;
		this.startDate = startDate;
		this.startTime = startTime;
	}

	// getter / setter methods

	
	
	public List<Player> getPlayers() {
		return players;
	}


	public void setPlayers(List<Player> players) {
		this.players = players;
	}


	public Place getPlace() {
		return place;
	}


	public void setPlace(Place place) {
		this.place = place;
	}
	
	public int getId() {
		return id;
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


	public int getMaxPlayers() {
		return maxPlayers;
	}


	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}


	public int getMinPlayers() {
		return minPlayers;
	}


	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Time getStartTime() {
		return startTime;
	}


	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	
/*
	public int getIdPlace() {
		return idPlace;
	}


	public void setIdPlace(int idPlace) {
		this.idPlace = idPlace;
	}
*/

	@Override
	public String toString() {
		return "Tournament [id=" + id + ", name=" + name + ", maxPlayers=" + maxPlayers + ", minPlayers=" + minPlayers
				+ ", startDate=" + startDate + ", startTime=" + startTime + ", idPlace=" + "]";
	}
	
	
	
	
}