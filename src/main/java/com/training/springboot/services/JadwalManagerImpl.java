package com.training.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springboot.dao.JadwalDao;
import com.training.springboot.model.Jadwal;


@Service
public class JadwalManagerImpl implements JadwalManager {

	private JadwalDao jadwalRepository;
	
	@Autowired
	public JadwalManagerImpl(JadwalDao jadwalRepository) {
		super();
		this.jadwalRepository = jadwalRepository;
	}

	@Override
	public List<Jadwal> getListJadwal() {
		return jadwalRepository.findAll();
	}

	@Override
	public void insertJadwal(Jadwal jadwal) {
		jadwalRepository.save(jadwal);
	}

	@Override
	public Jadwal getJadwalById(int id) {
		return jadwalRepository.findById(id).get();
	}

	@Override
	public void deleteJadwalById(int id) {
		jadwalRepository.deleteById(id);
	}

}
