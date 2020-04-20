package com.training.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springboot.dao.KaryawanDao;
import com.training.springboot.model.Karyawan;


@Service
public class KaryawanManagerImpl implements KaryawanManager {

	private KaryawanDao karyawanRepository;
	
	@Autowired
	public KaryawanManagerImpl(KaryawanDao karyawanRepository) {
		super();
		this.karyawanRepository = karyawanRepository;
	}

	@Override
	public List<Karyawan> getListKaryawan() {
		return karyawanRepository.findAll();
	}

	@Override
	public void insertKaryawan(Karyawan karyawan) {
		karyawanRepository.save(karyawan);
	}

	@Override
	public Karyawan getKaryawanByKode(String kode_karyawan) {
		return karyawanRepository.findById(kode_karyawan).get();
	}

	@Override
	public void deleteKaryawanByKode(String kode_karyawan) {
		karyawanRepository.deleteById(kode_karyawan);
	}

}
