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
import com.ngo.dto.StaffDto;
import com.ngo.payload.ApiResponce;
import com.ngo.service.StaffService;



@RestController
@RequestMapping("/staffapi")
public class StaffController {
	
	Logger logger =LoggerFactory.getLogger(StaffController.class);
	
	@Autowired
	private StaffService staffService;
	
	@PostMapping("/savestaff")
	public ResponseEntity<StaffDto>saveStaff (@Valid @RequestBody StaffDto staffDto){
		logger.info("Initiated request For save the Staff details ");
		StaffDto saveStaff = this.staffService.saveStaff(staffDto);
		logger.info("Completed request For save the Staff details ");
		return new ResponseEntity<StaffDto>(saveStaff,HttpStatus.CREATED);
		}
	
	@PutMapping("/updatestaff/{staffId}")
	public ResponseEntity<StaffDto>updateStaff(@Valid @RequestBody StaffDto staffDto,@PathVariable Long staffId){
		logger.info("Initiated request For update the Staff details ");
		StaffDto updateStaff = this.staffService.updateStaff(staffDto, staffId);
		logger.info("Completed request For update the Staff details ");
		return new ResponseEntity<StaffDto>(updateStaff,HttpStatus.CREATED);
		}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<StaffDto>>getAllStaff(){
		logger.info("Initiated request For getAll the Staff details ");
		List<StaffDto> allStaff = this.staffService.getAllStaff();
		logger.info("Completed request For getAll the Staff details ");
		return new ResponseEntity<List<StaffDto>>(allStaff,HttpStatus.OK);
		}
	
	@DeleteMapping("/deletestaff/{staffId}")
	public ResponseEntity<ApiResponce>deleteStaff(@PathVariable Long staffId){
		logger.info("Initiated request For delete the Staff details ");
		this.staffService.deleteStaff(staffId);
		logger.info("Completed request For delete the Staff details ");
		return new ResponseEntity<ApiResponce>(new ApiResponce(AppConstants.STAFF_DELETE,false),HttpStatus.OK);
	   }
	

}
