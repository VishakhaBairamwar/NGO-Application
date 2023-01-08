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
import com.ngo.dto.DonarDto;
import com.ngo.payload.ApiResponce;
import com.ngo.service.DonarService;



@RestController
@RequestMapping("/donarapi")
public class DonarController {
	
	Logger logger = LoggerFactory.getLogger(DonarController.class);
	
	@Autowired
	private DonarService donarService ;
	
	@PostMapping("/savedonar")
	public ResponseEntity<DonarDto>saveDonar(@Valid @RequestBody DonarDto donarDto){
		logger.info("Initiated request For save the Donar details ");
		DonarDto saveDonar = this.donarService.saveDonar(donarDto);
		logger.info("Completed request For save the Donar details ");
		return new ResponseEntity<DonarDto>(saveDonar,HttpStatus.CREATED);
		}
	
	
	@PutMapping("/updatedonar/{donarId}")
	public ResponseEntity<DonarDto> updateDonar(@Valid @RequestBody DonarDto donarDto,@PathVariable Long donarId){
		logger.info("Initiated request For update the Donar details ");
		DonarDto updateDonar = this.donarService.updateDonar(donarDto, donarId);
		logger.info("Completed request For update the Donar details ");
		return new ResponseEntity<DonarDto>(updateDonar,HttpStatus.CREATED);
		}
	
	@GetMapping("/getalldonar")
	public ResponseEntity<List<DonarDto>>getAllDonar(){
		logger.info("Initiated request For getall the Donar details ");
		List<DonarDto> allDonar = this.donarService.getAllDonar();
		logger.info("Completed request For getall the Donar details ");
		return new ResponseEntity<List<DonarDto>>(allDonar,HttpStatus.OK);
		}
	
	@DeleteMapping("/delatedonar/{donarId}")
	public ResponseEntity<ApiResponce>deleteDonar(@PathVariable Long donarId){
		logger.info("Initiated request For delete the Donar details ");
		this.donarService.deleteDonar(donarId);
		logger.info("Completed request For delete the Donar details ");
		return new ResponseEntity<ApiResponce>(new ApiResponce(AppConstants.DONAR_DELETE, false),HttpStatus.OK);
		}
	
	
	
	

}
