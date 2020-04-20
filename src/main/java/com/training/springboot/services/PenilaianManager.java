package com.training.springboot.services;

import java.util.List;

import com.training.springboot.model.Penilaian;

public interface PenilaianManager {

	List<Penilaian> getListPenilaian();
	void insertPenilaian(Penilaian penilaian);
	Penilaian getPenilaianById(int id);
	void deletePenilaianById(int id);
	
}
