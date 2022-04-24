package com.amt.findvolunteers.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class UserProfile {
	  // -------------------variables-------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
//	 if all the inputs are optional then are validations even needed?
    
	 @Size(min=0, max=100, message="Please provide a street address.")
	 private String userStreetAdd;
	 
	 @Size(min=0, max=30, message="Please provide a city name.")
	 private String userCity;
	 

	 @Size(min=0, max=30, message="Please provide the state.")
	 private String userState;
	 

	 @Min(value=5, message="Please provide a valid zipcode.")
	 private int userZipCode;
	 
	 @Min(value=7, message="Please provide a valid phone number.")
	 private int userPhone;
	 
	 @Size(min=3, max=30, message="Please provide your twitter username.")
	 private String userTwitter;
	 
//	 facebook only link, there is no username.
	 @Size(min=3, max=200, message="Please provide your facebook link.")
	 private String userFacebook;
	 
	 @Size(min=3, max=30, message="Please provide your instagarm username.")
	 private String userInstagram;
	 
//	 there is no way to share a link, only QR code or via their phone app directly.
	 @Min(value=10, message="Please provide your Whatsapp number.")
	 private int userWhatsApp;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    


// For a many to many relationship with Category
//  @ManyToMany
//  @JoinTable(
//      name = "user_interests",
//      joinColumns = @JoinColumn(name = "userProfile_id"),
//      inverseJoinColumns = @JoinColumn(name = "category_id")
//  )
//  private List<<Category>> userInterests;
    
    // -------------------constructors (include an empty one)-------------------
    public UserProfile() {}

    // -------------------methods-------------------
    // These tie to the mandatory variables above:
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserStreetAdd() {
		return userStreetAdd;
	}

	public void setUserStreetAdd(String userStreetAdd) {
		this.userStreetAdd = userStreetAdd;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public int getUserZipCode() {
		return userZipCode;
	}

	public void setUserZipCode(int userZipCode) {
		this.userZipCode = userZipCode;
	}

	public int getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(int userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserTwitter() {
		return userTwitter;
	}

	public void setUserTwitter(String userTwitter) {
		this.userTwitter = userTwitter;
	}

	public String getUserFacebook() {
		return userFacebook;
	}

	public void setUserFacebook(String userFacebook) {
		this.userFacebook = userFacebook;
	}

	public String getUserInstagram() {
		return userInstagram;
	}

	public void setUserInstagram(String userInstagram) {
		this.userInstagram = userInstagram;
	}

	public int getUserWhatsApp() {
		return userWhatsApp;
	}

	public void setUserWhatsApp(int userWhatsApp) {
		this.userWhatsApp = userWhatsApp;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

    
    
}
