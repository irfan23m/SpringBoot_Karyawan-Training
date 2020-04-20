package com.training.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springboot.dao.PenilaianDao;
import com.training.springboot.model.Penilaian;


@Service
public class PenilaianManagerImpl implements PenilaianManager {

	private PenilaianDao penilaianRepository;
	
	@Autowired
	public PenilaianManagerImpl(PenilaianDao penilaianRepository) {
		super();
		this.penilaianRepository = penilaianRepository;
	}

	@Override
	public List<Penilaian> getListPenilaian() {
		return penilaianRepository.findAll();
	}

	@Override
	public void insertPenilaian(Penilaian penilaian) {
		penilaianRepository.save(penilaian);
	}

	@Override
	public Penilaian getPenilaianById(int id) {
		return penilaianRepository.findById(id).get();
	}

	@Override
	public void deletePenilaianById(int id) {
		penilaianRepository.deleteById(id);
	}

}
