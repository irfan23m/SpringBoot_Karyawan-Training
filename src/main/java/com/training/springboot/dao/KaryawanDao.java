package com.training.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.springboot.model.Karyawan;

public interface KaryawanDao extends JpaRepository<Karyawan, String>{
	
}
