package com.ngo.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
	
	private Long adminId;
	
	@NotEmpty
	@Size(min=3,message = "Name Must be Atleast 3 Character !!")
	private String adminName;
	
	@NotEmpty
	@Size(min=10,max=10 ,message = "Not Valid ADMIN_CONTACT !!")
	private String adminContact;
	
	@NotEmpty
	@Size(min=12,max=12,message="Aadhar_Card No Must Be 12 Digit...!!!")
	private String adminAadhar;
	
	@NotEmpty
	private String adminGender;

}
