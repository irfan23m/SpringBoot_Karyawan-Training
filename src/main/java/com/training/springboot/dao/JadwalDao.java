package com.training.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.springboot.model.Jadwal;

public interface JadwalDao extends JpaRepository<Jadwal, Integer>{
	
}
