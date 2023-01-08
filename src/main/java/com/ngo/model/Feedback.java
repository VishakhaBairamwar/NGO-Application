package com.ngo.model;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="feedback_details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long feedbackId;
	
	@Column(name="feedback_name")
	private String feedbackName;
	
	@Column(name="feedback_email")
	private String feedbackEmail;
	
	@Column(name="feedback_suggestion")
	private String feedbackSuggestion;

}
