package com.ngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngo.dto.LoginDto;
import com.ngo.model.Donar;

public interface DonarRepository  extends JpaRepository<Donar, Long> {
	
	Donar findByLogin(LoginDto loginDto);

}
