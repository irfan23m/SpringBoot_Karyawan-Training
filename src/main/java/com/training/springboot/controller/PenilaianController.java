package com.training.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.springboot.model.Jadwal;
import com.training.springboot.model.Karyawan;
import com.training.springboot.model.Penilaian;
import com.training.springboot.services.JadwalManagerImpl;
import com.training.springboot.services.KaryawanManagerImpl;
import com.training.springboot.services.PenilaianManagerImpl;

@Controller
public class PenilaianController {
	
	private final PenilaianManagerImpl penilaianManager;
	private final KaryawanManagerImpl karyawanManager;
	private final JadwalManagerImpl jadwalManager;

	@Autowired
	public PenilaianController(PenilaianManagerImpl penilaianManager, KaryawanManagerImpl karyawanManager,
			JadwalManagerImpl jadwalManager) {
		super();
		this.penilaianManager = penilaianManager;
		this.karyawanManager = karyawanManager;
		this.jadwalManager = jadwalManager;
	}
	
	@RequestMapping("index_penilaian")
	public String dashboardPage(Model model){ 
		List<Penilaian> listAllPenilaian = penilaianManager.getListPenilaian();
		model.addAttribute("listAllPenilaian", listAllPenilaian);
		return "indexPenilaian";
	}

	@RequestMapping("new_penilaian")
	public String formTambahDataPenilaian(Model model) {
		Penilaian Penilaian = new Penilaian();
		List<Karyawan> listAllKaryawan = karyawanManager.getListKaryawan();
		List<Jadwal> listAllJadwal = jadwalManager.getListJadwal();
		model.addAttribute("dataPenilaian", Penilaian);
		model.addAttribute("listAllKaryawan",listAllKaryawan);
		model.addAttribute("listAllJadwal",listAllJadwal);
		return "formTambahPenilaian";
	}
	
	@RequestMapping(value = "savePenilaian", method = RequestMethod.POST)
	public String addDataPenilaian(@ModelAttribute("dataPenilaian") Penilaian Penilaian) {
		penilaianManager.insertPenilaian(Penilaian);
		return "redirect:/index_penilaian";
	}
	
	@RequestMapping("edit_penilaian/{id}")
	public ModelAndView formEditPenilaian(@PathVariable(name="id") int id) {
		List<Karyawan> listAllKaryawan = karyawanManager.getListKaryawan();
		List<Jadwal> listAllJadwal = jadwalManager.getListJadwal();
		ModelAndView model = new ModelAndView("formEditPenilaian");
		Penilaian Penilaian = penilaianManager.getPenilaianById(id);
		model.addObject("dataPenilaian", Penilaian);
		model.addObject("listAllKaryawan",listAllKaryawan);
		model.addObject("listAllJadwal",listAllJadwal);
		return model;
	}
	
	@RequestMapping("delete_penilaian/{id}")
	public String deletePenilaian(@PathVariable(name = "id")int id) {
		penilaianManager.deletePenilaianById(id);
		return "redirect:/index_penilaian";
	}

}
