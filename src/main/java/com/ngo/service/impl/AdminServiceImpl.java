package com.ngo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.constants.AppConstants;
import com.ngo.dto.AdminDto;
import com.ngo.dto.LoginDto;
import com.ngo.exception.ResourceNotFoundException;
import com.ngo.model.Admin;
import com.ngo.repository.AdminRepository;
import com.ngo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	Logger logger=LoggerFactory.getLogger(AdminServiceImpl.class);
    
	@Autowired
	private AdminRepository  adminRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public AdminDto saveAdmin(AdminDto adminDto) {
		logger.info("Initiating dao call for the Save Admin details ");
		Admin admin = this.modelMapper.map(adminDto, Admin.class);
		Admin saveAdmin = this.adminRepository.save(admin);
		logger.info("Completed dao call for the Save DoAdminnar details ");
		return this.modelMapper.map(saveAdmin, AdminDto.class);
		
	}

	@Override
	public AdminDto updateAdmin(AdminDto adminDto, Long adminId) {
		logger.info("Initiating dao call for the find adminId details with ",adminId);
		Admin admin = this.adminRepository.findById(adminId)
				.orElseThrow(()->new ResourceNotFoundException(AppConstants.NOT_FOUND +adminId));
		admin.setAdminName(adminDto.getAdminName());
		admin.setAdminContact(adminDto.getAdminContact());
		admin.setAdminAadhar(adminDto.getAdminAadhar());
		admin.setAdminGender(adminDto.getAdminGender());
		Admin updatedAdmin = this.adminRepository.save(admin);
		logger.info("Completed dao call for the Update the Admin details with  ",adminId);
		return this.modelMapper.map(updatedAdmin, AdminDto.class);
	}

	@Override
	public List<AdminDto> getAllAdmin() {
		logger.info("Initiating dao call for the get all the Details");
		List<Admin> adminList = this.adminRepository.findAll();
		List<AdminDto> listDto = adminList.stream().map((admin)->this.modelMapper.map(admin, AdminDto.class))
		.collect(Collectors.toList());
		logger.info("Completed dao call for the get all the Details");
		return listDto;
	}

	@Override
	public void deleteAdmin(Long adminId) {
		logger.info("Initiating dao call for the delete Admin details with ",adminId);
		Admin admin = this.adminRepository.findById(adminId)
				.orElseThrow(()-> new ResourceNotFoundException(AppConstants.NOT_FOUND +adminId));
		logger.info("Completed dao call for the delete donar details with ",adminId);
		this.adminRepository.delete(admin);
	}

	@Override
	public AdminDto getAdminByLogin(LoginDto loginDto) {
		logger.info("Initiating dao call for the login Admin");
		Admin admin = this.adminRepository.findByLogin(loginDto);
		logger.info("Initiating dao call for the login Admin");
		return this.modelMapper.map(admin, AdminDto.class);
	}

	
	
	
	

}
