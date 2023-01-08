package com.ngo.dto;


import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StaffDto {
	
	private Long staffId;
	@NotEmpty
	@Size(min=3,message = "Name Must be Atleast 3 Character !!")
	private String staffName;
	
	@NotEmpty
	@Size(min=10,max=10 ,message = "Not Valid ADMIN_CONTACT !!")
	private String staffContact;
	
	@NotEmpty
	@Size(min=12,max=12,message="Aadhar_Card No Must Be 12 Digit...!!!")
	private String staffAadhar;
	@NotEmpty
	private String staffDesignation;
	@NotEmpty
	private String staffDepartment;
	@NotEmpty
	private String staffGender;
	@NotEmpty
	private String staffDOB;


}
