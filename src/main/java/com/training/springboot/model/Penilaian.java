package com.training.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="penilaian")
@EntityListeners(AuditingEntityListener.class)
public class Penilaian {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "kode_karyawan")
	private String kode_karyawan;
	@Column(name = "materi")
	private String materi;
	@Column(name = "nilai")
	private int nilai;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKode_karyawan() {
		return kode_karyawan;
	}
	public void setKode_karyawan(String kode_karyawan) {
		this.kode_karyawan = kode_karyawan;
	}
	public String getMateri() {
		return materi;
	}
	public void setMateri(String materi) {
		this.materi = materi;
	}
	public int getNilai() {
		return nilai;
	}
	public void setNilai(int nilai) {
		this.nilai = nilai;
	}
	
}
