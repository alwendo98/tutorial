package com.example.bcc.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mahasiswa", schema = "hr")
public class Student {
	
	@Id
	@Column(name = "nim")
	private String nim;
	
	@Column(name = "nama")
	private String name;
	
	@Column(name = "tgl_lhr")
	private Date dob;
	
	@Column(name = "alamat")
	private String address;
	
	@Column(name = "jns_kelamin")
	private String gender;

	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

	public String getNim() {
		return nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
