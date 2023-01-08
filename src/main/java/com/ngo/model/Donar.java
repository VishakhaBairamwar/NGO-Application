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
@Table(name="DONAR_DETAILS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Donar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long donarId;
	
	@Column(name="donar_name")
	private String donarName;
	
	@Column(name="donar_contact")
	private String doanrContact;
	
	@Column(name="donar_pan")
	private String donarPan;
	
	@Column(name="donar_gender")
	private String donarGender;
	
	@Column(name="donar_DOB")
	private String donarDOB;
	
	@Column(name="donar_amount")
	private Double donarAmount;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="login_Id")
	private Login login;
	
	@Embedded
    private  Address address;

	
	
	

}
