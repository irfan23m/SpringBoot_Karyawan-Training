package com.training.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.springboot.model.Karyawan;
import com.training.springboot.model.Penilaian;
import com.training.springboot.services.KaryawanManagerImpl;
import com.training.springboot.services.PenilaianManagerImpl;

@Controller
public class KaryawanController {
	
	private final KaryawanManagerImpl karyawanManager;
	private final PenilaianManagerImpl penilaianManager;

	@Autowired
	public KaryawanController(KaryawanManagerImpl karyawanManager, PenilaianManagerImpl penilaianManager) {
		super();
		this.karyawanManager = karyawanManager;
		this.penilaianManager = penilaianManager;
	}
	
	@RequestMapping("/")
	public String dashboard() {
		return "index";
	}
	
	@RequestMapping("index_karyawan")
	public String dashboardPage(Model model) {
		List<Karyawan> listAllKaryawan = karyawanManager.getListKaryawan();
		model.addAttribute("listAllKaryawan",listAllKaryawan);
		return "indexKaryawan";
	}

	@RequestMapping("new_karyawan")
	public String formTambahDataKaryawan(Model model) {
		Karyawan karyawan = new Karyawan();
		model.addAttribute("dataKaryawan", karyawan);
		return "formTambahKaryawan";
	}
	
	@RequestMapping(value="saveKaryawan", method=RequestMethod.POST)
	public String addDataKaryawan(@ModelAttribute("dataKaryawan") Karyawan karyawan) {
		karyawanManager.insertKaryawan(karyawan);
		return "redirect:/index_karyawan";
	}
	
	@RequestMapping("edit_karyawan/{kode_karyawan}")
	public ModelAndView formEditKaryawan(@PathVariable(name = "kode_karyawan") String kode_karyawan) {
		ModelAndView model = new ModelAndView("formEditKaryawan");
		Karyawan karyawan = karyawanManager.getKaryawanByKode(kode_karyawan);
		model.addObject("dataKaryawan", karyawan);
		return model;
	}
	
	@RequestMapping("nilai_karyawan/{kode_karyawan}")
	public ModelAndView viewNilaiKaryawan(@PathVariable(name = "kode_karyawan") String kode_karyawan) {
		List<Penilaian> listPenilaian = penilaianManager.getListPenilaian();
		List<Penilaian> newPenilaian = new ArrayList<Penilaian>();
		
		for (Penilaian pen : listPenilaian) {
			Penilaian penilaian = new Penilaian();
			if (pen.getKode_karyawan().equals(kode_karyawan)) {
				penilaian.setId(pen.getId());
				penilaian.setKode_karyawan(pen.getKode_karyawan());
				penilaian.setMateri(pen.getMateri());
				penilaian.setNilai(pen.getNilai());
				newPenilaian.add(penilaian);
			}
		}
		
		ModelAndView model = new ModelAndView("viewNilaiKaryawan");
		Karyawan karyawan = karyawanManager.getKaryawanByKode(kode_karyawan);
		model.addObject("dataKaryawan", karyawan);
		model.addObject("penilaianKaryawan", newPenilaian);
		return model;
	}
	
	@RequestMapping("delete_karyawan/{kode_karyawan}")
	public String deleteKaryawan(@PathVariable(name = "kode_karyawan") String kode_karyawan) {
		karyawanManager.deleteKaryawanByKode(kode_karyawan);
		return "redirect:/index_karyawan";
	}

}
