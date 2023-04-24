package com.example.FootballDiary.domain;





import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Football {
	//LUODAAN ID
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String date;
	private String duration;
	private String description;
	
	
	
	
	public Football() {}
	
	public Football(String date, String duration, String description) {
		super();
		this.date = date;
		this.duration = duration;
		this.description = description;
		
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Football [id=" + id + ", date=" + date + ", duration=" + duration + ", description=" + description + "]";
	}
}
