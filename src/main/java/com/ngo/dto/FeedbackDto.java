package com.ngo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDto {
	
	private Long feedbackId;
	
	@NotEmpty
	@Size(min = 2,message = "Name must be Atleast 2 chracter !!")
	private String feedbackName;
	
	@Email(message = "Email Should be Proper")
	private String feedbackEmail;
	@NotEmpty
	private String feedbackSuggestion;

}
