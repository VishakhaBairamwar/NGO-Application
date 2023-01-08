package com.ngo.service;

import java.util.List;

import com.ngo.dto.DonarDto;
import com.ngo.dto.LoginDto;

public interface DonarService {
	
	DonarDto saveDonar (DonarDto donarDto);
	
	DonarDto updateDonar (DonarDto donarDto,Long donarId);
	
	List<DonarDto> getAllDonar ();
	 
	void deleteDonar (Long donarId); 
	
	DonarDto getByDonarLogin(LoginDto loginDto);

}
