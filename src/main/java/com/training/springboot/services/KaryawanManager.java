package com.training.springboot.services;

import java.util.List;

import com.training.springboot.model.Karyawan;

public interface KaryawanManager {

	List<Karyawan> getListKaryawan();
	void insertKaryawan(Karyawan karyawan);
	Karyawan getKaryawanByKode(String kode_karyawan);
	void deleteKaryawanByKode(String kode_karyawan);
	
}
