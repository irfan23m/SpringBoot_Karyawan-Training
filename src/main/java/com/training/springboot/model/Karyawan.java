package com.training.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="karyawan")
@EntityListeners(AuditingEntityListener.class)
public class Karyawan {
	
	@Id
	@Column(name = "kode_karyawan")
	private String kode_karyawan;
	@Column(name = "nama")
	private String nama;
	@Column(name = "alamat")
	private String alamat;
	@Column(name = "phone")
	private String phone;
	
	public String getKode_karyawan() {
		return kode_karyawan;
	}
	public void setKode_karyawan(String kode_karyawan) {
		this.kode_karyawan = kode_karyawan;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
			
}
