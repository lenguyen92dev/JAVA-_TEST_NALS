package com.nals.java.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "work")
public class Work {
	private long id;
    private String workName;
    private Date startingDate;
    private Date endingDate;
//    private Status status;
    private long status;
    
    public Work() {
    	  
    }
    
    
    public Work(String workName, Date startingDate, Date endingDate, long status) {
        this.workName = workName;
        this.startingDate = startingDate;
        this.status = status;
   }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "work_name", nullable = false)
	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}
	@Column(name = "starting_date", nullable = false)
	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	@Column(name = "ending_date", nullable = false)
	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}
	@Column(name = "status", nullable = false)
	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}
    
}
