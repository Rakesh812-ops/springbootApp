package com.neosoft.entity;


import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "User")
public class User{
	
	/**
	 * 
	 */

	@Id
	@GeneratedValue
	private Integer userId;
	private String userName;
	private String password;
	private String address;
	private Date dob;
	private String email;
	private long mobileNo;
	
   @JsonIgnore
    private boolean status;
	
	//@Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @CreatedDate
    @JsonIgnore
    public LocalDateTime created;

//    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @JsonIgnore
    public LocalDateTime modified;
    public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        if (created == null) {
            this.created = LocalDateTime.now();
            this.modified = LocalDateTime.now();
        } else
            this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified() {
        this.modified = LocalDateTime.now();
    }
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + userId + ", userName=" + userName + ", password=" + password + ", address=" + address
				+ ", dob=" + dob + ", email=" + email + ", mobileNo=" + mobileNo + "]";
	}
	
	
	
	

}
