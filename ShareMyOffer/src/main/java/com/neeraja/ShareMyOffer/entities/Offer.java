package com.neeraja.ShareMyOffer.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "offer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Offer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull(message = "is required")
	@Column(name = "name")
	private String name;
	
	@NotNull(message = "is required")
	@Column(name = "description")
	private String description;
	
	@NotNull(message = "is required")
	@Column(name = "date_of_post")
	private String date;
	
	@NotNull(message = "is required")
	@Column(name = "status")
	private String status;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	

	
	
}
