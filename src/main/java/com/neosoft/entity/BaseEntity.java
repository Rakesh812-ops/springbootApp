package com.neosoft.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class BaseEntity implements Serializable {
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Temporal(TemporalType.TIMESTAMP)
	    @Column(updatable = false)
	    @CreatedDate
	    @JsonIgnore
	    public LocalDateTime created;

	    @Temporal(TemporalType.TIMESTAMP)
	    @LastModifiedDate
	    @JsonIgnore
	    public LocalDateTime modified;

	    @JsonIgnore
	 private boolean status;
	    

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
	}

