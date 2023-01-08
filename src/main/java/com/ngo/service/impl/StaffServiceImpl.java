package com.ngo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.constants.AppConstants;
import com.ngo.dto.LoginDto;
import com.ngo.dto.StaffDto;
import com.ngo.exception.ResourceNotFoundException;
import com.ngo.model.Staff;
import com.ngo.repository.StaffRepository;
import com.ngo.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService{
	Logger logger= LoggerFactory.getLogger(StaffServiceImpl.class);
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private ModelMapper modelMapper ;

	@Override
	public StaffDto saveStaff(StaffDto staffDto) {
		logger.info("Initiating dao call for the Save Staff details ");
		Staff staff = this.modelMapper.map(staffDto, Staff.class);
		Staff saveStaff = this.staffRepository.save(staff);
		logger.info("Completed dao call for the Save Staff details ");
		return this.modelMapper.map(saveStaff, StaffDto.class);
	}

	@Override
	public StaffDto updateStaff(StaffDto staffDto, Long staffId) {
		logger.info("Initiating dao call for the find staffId details with ",staffId);
		Staff staff = this.staffRepository.findById(staffId)
				.orElseThrow(()-> new ResourceNotFoundException(AppConstants.NOT_FOUND + staffId));
		staff.setStaffName(staffDto.getStaffName());
		staff.setStaffContact(staffDto.getStaffContact());
		staff.setStaffAadhar(staffDto.getStaffAadhar());
		staff.setStaffDesignation(staffDto.getStaffDesignation());
		staff.setStaffDepartment(staffDto.getStaffDepartment());
		staff.setStaffGender(staffDto.getStaffGender());
		staff.setStaffDOB(staffDto.getStaffDOB());
		Staff updateStaff = this.staffRepository.save(staff);
		logger.info("Completed dao call for the Update the Staff details with  ",staffId);
		return this.modelMapper.map(updateStaff, StaffDto.class);
	}

	@Override
	public List<StaffDto> getAllStaff() {
		logger.info("Initiating dao call for the get all the Details");
		List<Staff> list = this.staffRepository.findAll();
		List<StaffDto> dtolist = list.stream().map((staff)-> this.modelMapper.map(staff, StaffDto.class)).collect(Collectors.toList());
		logger.info("Completed dao call for the get all the Details");
		return dtolist;
	}

	@Override
	public void deleteStaff(Long staffId) {
		logger.info("Initiating dao call for the delete Staff details with ",staffId);
		Staff staff = this.staffRepository.findById(staffId).orElseThrow(()-> new ResourceNotFoundException(AppConstants.NOT_FOUND+staffId ));
		logger.info("Completed dao call for the delete Staff details with ",staffId);
		this.staffRepository.delete(staff);
	}

	@Override
	public StaffDto getStaffByLogin(LoginDto loginDto) {
		logger.info("Initiating dao call for the login the Staff");
		Staff staff = this.staffRepository.findByLogin(loginDto);
		logger.info("Completed dao call for the login the Staff");
		return this .modelMapper.map(staff, StaffDto.class);
	}

}
