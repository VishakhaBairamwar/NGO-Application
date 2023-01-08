package com.ngo.model;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="login_details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loginId;
	
	private String loginUsername;
	
	private String loginPassword;
	
	private String longinType;
	
	
	@OneToOne(mappedBy = "login" ,cascade = CascadeType.ALL )
	private Admin admin;

}
