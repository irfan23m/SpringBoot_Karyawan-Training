package com.training.springboot.services;

import java.util.List;

import com.training.springboot.model.Jadwal;

public interface JadwalManager {

	List<Jadwal> getListJadwal();
	void insertJadwal(Jadwal jadwal);
	Jadwal getJadwalById(int id);
	void deleteJadwalById(int id);
	
}
