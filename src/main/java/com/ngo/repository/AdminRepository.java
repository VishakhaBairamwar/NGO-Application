package com.ngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ngo.dto.LoginDto;
import com.ngo.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{
	
	Admin findByLogin(LoginDto loginDto);

}
