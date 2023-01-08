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
@Table (name="admin_details")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="admin_id")
	private Long adminId;
	
	@Column(name="admin_name")
	private String adminName;
	
	@Column(name="admin_contact")
	private String adminContact;
	
	@Column(name="admin_aadhar")
	private String adminAadhar;
	
	@Column(name="admin_gender")
	private String adminGender;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="login_Id")
	private Login login;
	
	@Embedded
    private  Address address;
	

}
