package com.amt.findvolunteers.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="event_pics")
public class EventPic {

	
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;

	    
	    @Column(length=45, nullable=true)
	    private String pic;
	    
	    @OneToOne(fetch=FetchType.LAZY)
	    @JoinColumn(name="event_id")
	    private Event event;
	    
	    public EventPic() {}
	    
//	    --------------------------
	    @Transient
	    public String getProfileImagePath() {
	    	if (pic == null || id == null) return null;
	    	return "/profile-pics/" + id +"/"+ pic;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public String getPic() {
			return pic;
		}

		public void setPic(String pic) {
			this.pic = pic;
		}

		public Event getEvent() {
			return event;
		}

		public void setEvent(Event event) {
			this.event = event;
		}
	    
}
