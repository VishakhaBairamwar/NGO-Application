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
import com.ngo.dto.PartnerDto;
import com.ngo.exception.ResourceNotFoundException;
import com.ngo.model.Partner;
import com.ngo.repository.PartnerRepository;
import com.ngo.service.PartnerService;
@Service
public class PartnerServiceImpl implements PartnerService{
	Logger logger=LoggerFactory.getLogger(PartnerServiceImpl.class);

	@Autowired
	private PartnerRepository partnerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public PartnerDto savePartner(PartnerDto partnerDto) {
		logger.info("Initiating dao call for the Partner  details ");
		Partner partner = this.modelMapper.map(partnerDto, Partner.class);
		Partner savePartner = this.partnerRepository.save(partner);
		logger.info("Completed dao call for the Save Partner details ");
		return this.modelMapper.map(savePartner, PartnerDto.class);
	}

	@Override
	public PartnerDto updatePartner(PartnerDto partnerDto, Long partnerId) {
		logger.info("Initiating dao call for the find partnerId details with ",partnerId);
		Partner partner = this.partnerRepository.findById(partnerId)
				.orElseThrow(()-> new ResourceNotFoundException(AppConstants.NOT_FOUND +partnerId));
		partner.setPartnerContact(partnerDto.getPartnerContact());
		partner.setPartnerOrganisation(partnerDto.getPartnerOrganisation());
		partner.setPartnerWebsite(partnerDto.getPartnerWebsite());
		Partner updatePartner = this.partnerRepository.save(partner);
		logger.info("Completed dao call for the Update the Partner details with  ",partnerId);
		return this.modelMapper.map(updatePartner, PartnerDto.class);
	}

	@Override
	public List<PartnerDto> getAllPartner() {
		logger.info("Initiating dao call for the get all the Details");
		List<Partner> list = this.partnerRepository.findAll();
		List<PartnerDto> listPartner = list.stream().map((partner)-> this.modelMapper.map(partner,PartnerDto.class )).collect(Collectors.toList());
		logger.info("Completed dao call for the get all the Details");
		return listPartner;
	}

	@Override
	public void deletePartner(Long partnerId) {
		logger.info("Initiating dao call for the login the Partner");
		Partner partner = this.partnerRepository.findById(partnerId).orElseThrow(()-> new ResourceNotFoundException(AppConstants.NOT_FOUND +partnerId));
		logger.info("Completed dao call for the login the Partner");
		this.partnerRepository.delete(partner);
	}

	@Override
	public PartnerDto getByPartnerLogin(LoginDto loginDto) {
		logger.info("Initiating dao call for the login the Partner");
	Partner partner = this.partnerRepository.findByLogin(loginDto);
	logger.info("Completed dao call for the login the Partner");
		return this.modelMapper.map(partner, PartnerDto.class);
	}

}
