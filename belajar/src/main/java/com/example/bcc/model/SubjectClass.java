package com.example.bcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "matakuliah", schema = "hr")
public class SubjectClass {
	
	@Id
	@Column(name = "kode_matkul")
	private String subjectCode;
	
	@Column(name = "nama_matkul")
	private String subjectName;
	
	@Column(name = "sks")
	private Integer subjectPoint;

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Integer getSubjectPoint() {
		return subjectPoint;
	}

	public void setSubjectPoint(Integer subjectPoint) {
		this.subjectPoint = subjectPoint;
	}


	
}
