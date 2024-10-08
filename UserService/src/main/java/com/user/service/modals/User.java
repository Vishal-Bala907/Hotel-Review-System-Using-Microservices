package com.user.service.modals;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "hotel_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int uid;

	@Size(min = 5, max = 20, message = "The name should be 5-20 Character long")
	private String userName;

	@Email(message = "Please enter a valid email")
	private String email;

	private String about;

	@Transient
	private List<Rating> ratings = new ArrayList<>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(@Size(min = 5, max = 20, message = "The name should be 5-20 Character long") String userName,
			@Email(message = "Please enter a valid email") String email, String about, List<Rating> ratings) {
		super();
		this.userName = userName;
		this.email = email;
		this.about = about;
		this.ratings = ratings;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", userName=" + userName + ", email=" + email + ", about=" + about + ", ratings="
				+ ratings + "]";
	}

}
