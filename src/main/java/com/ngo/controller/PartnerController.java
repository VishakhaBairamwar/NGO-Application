package com.ngo.controller;

import java.util.List;

import javax.validation.Valid;

import org.aspectj.lang.annotation.Pointcut;
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
import com.ngo.dto.PartnerDto;
import com.ngo.payload.ApiResponce;
import com.ngo.service.PartnerService;



@RestController
@RequestMapping("/partnerapi")
public class PartnerController {
	
	 Logger logger = LoggerFactory.getLogger(PartnerController.class);
	
	@Autowired
	private PartnerService partnerService;
	
	@PostMapping("/savepartner")
	public ResponseEntity<PartnerDto>savePartner(@Valid @RequestBody PartnerDto partnerDto){
		logger.info("Initiated request For save the partner details ");
		PartnerDto savePartner = this.partnerService.savePartner(partnerDto);
		logger.info("Completed request For save the partner details ");
		return new ResponseEntity<PartnerDto>(savePartner,HttpStatus.CREATED);
		}
	@PutMapping("/updatepartner/{partnerId}")
	public ResponseEntity<PartnerDto>updatePartner(@Valid @RequestBody PartnerDto partnerDto,@PathVariable Long partnerId){
		logger.info("Initiated request For update the partner details ");
		PartnerDto updatePartner = this.partnerService.updatePartner(partnerDto, partnerId);
		logger.info("Completed request For update the partner details ");
		return new ResponseEntity<PartnerDto>(updatePartner,HttpStatus.CREATED);
		}
	
	@GetMapping("/getAllPartner")
	public ResponseEntity<List<PartnerDto>>getAllPartner(){
		logger.info("Initiated request For getall the partner details ");
		List<PartnerDto> allPartner = this.partnerService.getAllPartner();
		logger.info("Completed request For getall the partner details ");
		return new ResponseEntity<List<PartnerDto>>(allPartner,HttpStatus.OK);
		}
	
	@DeleteMapping("/deletepartner/{partnerId}")
	public ResponseEntity<ApiResponce>deletePartner(@PathVariable Long partnerId){
		logger.info("Initiated request For delete the partner details ");
		this.partnerService.deletePartner(partnerId);
		String mag="Data Deleted Successfully";
		logger.info("Completed request For delete the partner details ");
		return new ResponseEntity<ApiResponce>(new ApiResponce(AppConstants.PARTNER_DELETE, false),HttpStatus.OK);}
	
	
	
	

}
