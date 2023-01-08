package com.ngo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginDto {
	
    private Long loginId;
	
	private String loginUsername;
	
	private String loginPassword;
	
	private String longinType;

}
