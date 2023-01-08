package com.ngo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PARTNER_DETAILS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Partner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="partner_Id")
	private Long partnerId;
	
	@Column(name="partner_organisation")
	private String partnerOrganisation;
	
	@Column(name="partner_contact")
	private String partnerContact;
	
	@Column(name="partner_website")
	private String partnerWebsite;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="login_Id")
	private Login login;
	
	@Embedded
    private  Address address;

}
