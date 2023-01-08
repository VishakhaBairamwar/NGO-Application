package com.ngo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngo.constants.AppConstants;
import com.ngo.dto.AdminDto;
import com.ngo.payload.ApiResponce;
import com.ngo.service.AdminService;


@RestController
@RequestMapping ("/adminapi")
public class AdminController {
	
	Logger logger= LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/saveAdmin")
	public ResponseEntity<AdminDto>saveAdmin(@Valid @RequestBody AdminDto adminDto){
		logger.info("Initiated request For save the Admin details ");
		AdminDto saveAdmin = this.adminService.saveAdmin(adminDto);
		logger.info("Completed request For save the Admin details ");
		return new ResponseEntity<AdminDto>(saveAdmin,HttpStatus.CREATED);
		
		}
	
	
	@PutMapping("/updateAdmin/{adminId}")
	public ResponseEntity<AdminDto>updateAdmin (@Valid @RequestBody AdminDto adminDto,@PathVariable Long adminId ){
		logger.info("Initiated request For update the Admin details ");
		AdminDto updateAdmin = this.adminService.updateAdmin(adminDto, adminId);
		logger.info("Completed request For update the Admin details ");
		return new ResponseEntity<AdminDto>(updateAdmin,HttpStatus.CREATED);
		}
	
	@GetMapping("/getadmin")
	public ResponseEntity<List<AdminDto>>getAllAdmindata(){
		logger.info("Initiated request For getAll the Admin details ");
		List<AdminDto> allAdmin = this.adminService.getAllAdmin();
		logger.info("Completed request For getAll the Admin details ");
		return new ResponseEntity<List<AdminDto>>(allAdmin,HttpStatus.OK);
		}
	
	@DeleteMapping("/deleteadmin/{adminId}")
	public ResponseEntity<ApiResponce>deleteAdminData(@PathVariable Long adminId){
		logger.info("Initiated request For delete the Admin details ");
		this.adminService.deleteAdmin(adminId);
		logger.info("Initiated request For delete the Admin details ");
		return new ResponseEntity<ApiResponce>(new ApiResponce(AppConstants.ADMIN_DELETE, false),HttpStatus.OK);
		}
	
	
	
	
	

}
