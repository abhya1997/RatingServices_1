package com.ratingServices.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Rate")
@Data
public class Rating {
	
	@Id
	@Column(name="rate_id")
	private String  rate_id;
	@Column(name="user_id")
	private String userId;
	@Column(name="hotel_id")
	private String hotelId;
	@Column(name="rate")
	private int rate;
	@Column(name="feedback")
	private String feedback;
	
   // private Hotel hotel;
}
