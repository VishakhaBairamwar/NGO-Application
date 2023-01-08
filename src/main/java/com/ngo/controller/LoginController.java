package com.ngo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngo.dto.AdminDto;
import com.ngo.dto.DonarDto;
import com.ngo.dto.LoginDto;
import com.ngo.dto.PartnerDto;
import com.ngo.dto.StaffDto;
import com.ngo.service.AdminService;
import com.ngo.service.DonarService;
import com.ngo.service.LoginService;
import com.ngo.service.PartnerService;
import com.ngo.service.StaffService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@AutoConfigureOrder
	private LoginService loginService;
    
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private PartnerService partnerServce;
	
	@Autowired
	private DonarService donarService;
	
	
	public Object getLogin(@PathVariable String loginUsername,@PathVariable String loginPassword) {
		LoginDto login = this.loginService.getLogin(loginUsername, loginPassword);
		
		if(login.getLonginType().equalsIgnoreCase("Staff")) {
			StaffDto staffDto = this.staffService.getStaffByLogin(login);
			return staffDto;
			
		}else if(login.getLonginType().equalsIgnoreCase("Admin")) {
			AdminDto adminLogin = this.adminService.getAdminByLogin(login);
		   return adminLogin;
		   
		}else if(login.getLonginType().equalsIgnoreCase("Partner")) {
			PartnerDto partnerDto = this.partnerServce.getByPartnerLogin(login);
			return partnerDto;
			
		}else if(login.getLonginType().equalsIgnoreCase("Donar")) {
			DonarDto donarLogin = this.donarService.getByDonarLogin(login);
			return donarLogin;
		}
		return login;
		
	}
}
