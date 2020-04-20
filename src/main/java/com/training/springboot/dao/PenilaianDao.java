package com.training.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.springboot.model.Penilaian;

public interface PenilaianDao extends JpaRepository<Penilaian, Integer>{
	
}
