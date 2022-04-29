package com.amt.findvolunteers.models;

import java.util.Date;
//import java.util.List;
//import java.util.Locale.Category;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
    // -------------------variables-------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Title can not be empty or blanked.")
    @Size(min=3, max=128, message="Title should be 3 to 128 charcaters long.")
    private String title;
    
    @NotBlank(message="Host can not be empty or blanked.")
    @Size(min=3, max=128, message="Host should be 3 to 128 charcaters long.")
    private String host;
    
    @Size(min=10, max=128, message="Address should be 10 to 128 charcaters long.")
    private String address;
    
    @Size(min=5, max=50, message="Address should be 5 to 50 charcaters long.")
    private String address2;

    @Size(min=3, max=128, message="City should be 3 to 128 charcaters long.")
    private String city;
    
    @Size(min=2, max=12, message="State should be 2 to 12 charcaters long.")
    private String State;
    
    @NotNull(message="Zip Code is a required field.")
    @Size(min=5, max=10, message="Zip Code should be 5 to 10 charaters long.")
    private String zipCode;
    
    @NotBlank()
    private String description;
    
    @NotNull(message="A start date is required.")
    @Future(message="The start date cannot be in the past.")
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm a")
    private Date start;
    
    @NotNull(message="An end date is required.")
    @Future(message="The start date cannot be in the past.") // Going to need a validation check in submit that this date is after start date
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm a")
    private Date end;
    
    @PositiveOrZero(message="Volunteers needed can not be negative.")
    private Integer needed;
    
    @Size(min=10, max=14, message="Phone number should be 10 to 14 characters long.")
    private String contactPhone;
    
    @Email(message="Please enter a valid email address.")
    private String contactEmail;
    
    @Size(min=3, max=15, message="A Twitter handle is between 3 and 15 characters long, do not include the @ symbol.")
    private String contactTwitter;
    
    @Size(min=5, message="A Facebook username should be at least 5 characters long.")
    private String contactFacebook;
    
    @Size(min=3, message="An Instagram username should be at least 3 chracters long.")
    private String contactInstagram;
    
<<<<<<< Updated upstream
    @Size(min=16, message="A WhatsApp contact should be no less than 16 charcaters long including spaces.")
    private String contactWhatsApp;    
    

=======
//    @Size(min=16, message="A WhatsApp contact should be no less than 16 charcaters long including spaces.")
//    private String contactWhatsApp;
    @Column(length=45, nullable=true)
    private String eventPicString;
    
    //	For a one to one relationship
    @OneToOne(mappedBy="event", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private EventPic Eventpic;
    
>>>>>>> Stashed changes
    // For a many to one relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private User poster;

    // For a many to many relationship categories/interests
//    @ManyToMany
//    @JoinTable(
//        name = "eventCategories",
//        joinColumns = @JoinColumn(name = "event_id"),
//        inverseJoinColumns = @JoinColumn(name = "category_id")
//    )
//    private List<Category> categories;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss a")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss a")
    private Date updatedAt;

    // -------------------constructors (include an empty one)-------------------
    public Event() {}

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

    // -------------------getters & setters-------------------
    public Long getId() {
    	return id;
    }
    public void setId(Long id) {
    	this.id = id;
    }
    
    public String getTitle() {
    	return title;
    }
    public void setTitle(String title) {
    	this.title = title;
    }
    
    public String getHost() {
    	return host;
    }
    public void setHost(String host) {
    	this.host = host;
    }
    
    public String getAddress() {
    	return address;
    }
    public void setAddress(String address) {
    	this.address = address;
    }
    
    public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
    	return city;
    }
    public void setCity(String city) {
    	this.city = city;
    }
    
    public String getState() {
    	return State;
    }
    public void setState(String state) {
    	State = state;
    }
    
    public String getZipCode() {
    	return zipCode;
    }
    public void setZipCode(String zipCode) {
    	this.zipCode = zipCode;
    }
    
    public String getDescription() {
    	return description;
    }
    public void setDescription(String description) {
    	this.description = description;
    }
    
    public Date getStart() {
    	return start;
    }
    public void setStart(Date start) {
    	this.start = start;
    }
    
    public Date getEnd() {
    	return end;
    }
    public void setEnd(Date end) {
    	this.end = end;
    }
    
    public Integer getNeeded() {
    	return needed;
    }
    public void setNeeded(Integer needed) {
    	this.needed = needed;
    }
    
    public String getContactPhone() {
    	return contactPhone;
    }
    public void setContactPhone(String contactPhone) {
    	this.contactPhone = contactPhone;
    }
    
    public String getContactEmail() {
    	return contactEmail;
    }
    public void setContactEmail(String contactEmail) {
    	this.contactEmail = contactEmail;
    }
    
    public String getContactTwitter() {
    	return contactTwitter;
    }
    public void setContactTwitter(String contactTwitter) {
    	this.contactTwitter = contactTwitter;
    }
    
    public String getContactFacebook() {
    	return contactFacebook;
    }
    public void setContactFacebook(String contactFacebook) {
    	this.contactFacebook = contactFacebook;
    }
    
    public String getContactInstagram() {
    	return contactInstagram;
    }
    public void setContactInstagram(String contactInstagram) {
    	this.contactInstagram = contactInstagram;
    }
    
<<<<<<< Updated upstream
    public String getContactWhatsApp() {
    	return contactWhatsApp;
    }
    public void setContactWhatsApp(String contactWhatsApp) {
    	this.contactWhatsApp = contactWhatsApp;
=======
//    public String getContactWhatsApp() {
//    	return contactWhatsApp;
//    }
//    public void setContactWhatsApp(String contactWhatsApp) {
//    	this.contactWhatsApp = contactWhatsApp;
//    }
    public void setEventPicString(String eventPicString) {
    	this.eventPicString = eventPicString;
    }
    
    public EventPic getEventpic() {
    	return Eventpic;
    }
    
    public void setEventpic(EventPic eventpic) {
    	Eventpic = eventpic;
>>>>>>> Stashed changes
    }
    
    public User getPoster() {
		return poster;
	}
	public void setPoster(User poster) {
		this.poster = poster;
	}

//	public List<Category> getCategories() {
//    	return categories;
//    }
//    public void setCategories(List<Category> categories) {
//    	this.categories = categories;
//    }
    
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

	public String getEventPicString() {
		return eventPicString;
	}

    
    
}