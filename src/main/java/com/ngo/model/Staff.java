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
@Table(name="STAFF_DETAILS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="staff_id")
	private Long staffId;
	
	@Column(name="staff_name")
	private String staffName;
	
	@Column(name="staff_contact")
	private String staffContact;
	
	@Column(name="staff_aadhar")
	private String staffAadhar;
	
	@Column(name="staff_designation")
	private String staffDesignation;
	
	@Column(name="staff_department")
	private String staffDepartment;
	
	@Column(name="staff_gender")
	private String staffGender;
	
	@Column(name="staff_DOB")
	private String staffDOB;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="login_Id")
	private Login login;
	
	@Embedded
    private  Address address;

}
