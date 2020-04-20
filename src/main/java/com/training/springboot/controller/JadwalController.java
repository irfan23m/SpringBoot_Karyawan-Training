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
import com.training.springboot.services.JadwalManagerImpl;

@Controller
public class JadwalController {
	
	private final JadwalManagerImpl jadwalManager;

	@Autowired
	public JadwalController(JadwalManagerImpl jadwalManager) {
		super();
		this.jadwalManager = jadwalManager;
	}
	
	@RequestMapping("index_jadwal")
	public String dashboardPage(Model model){ 
		List<Jadwal> listAllJadwal = jadwalManager.getListJadwal();
		model.addAttribute("listAllJadwal", listAllJadwal);
		return "indexJadwal";
	}
	
	@RequestMapping("new_jadwal")
	public String formTambahDataJadwal(Model model) {
		Jadwal jadwal = new Jadwal();
		model.addAttribute("dataJadwal", jadwal);
		return "formTambahJadwal";
	}
	
	@RequestMapping(value = "saveJadwal", method = RequestMethod.POST)
	public String addDataJadwal(@ModelAttribute("dataJadwal") Jadwal jadwal) {
		jadwalManager.insertJadwal(jadwal);
		return "redirect:/index_jadwal";
	}
	
	@RequestMapping("edit_jadwal/{id}")
	public ModelAndView formEditJadwal(@PathVariable(name="id") int id) {
		ModelAndView model = new ModelAndView("formEditJadwal");
		Jadwal jadwal = jadwalManager.getJadwalById(id);
		model.addObject("dataJadwal", jadwal);
		return model;
	}
	
	@RequestMapping("delete_jadwal/{id}")
	public String deleteJadwal(@PathVariable(name = "id")int id) {
		jadwalManager.deleteJadwalById(id);
		return "redirect:/index_jadwal";
	}

}
