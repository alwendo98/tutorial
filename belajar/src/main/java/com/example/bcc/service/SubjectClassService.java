package com.example.bcc.service;

import java.util.List;

import com.example.bcc.model.SubjectClass;

public interface SubjectClassService {
	
	public List<SubjectClass> getAllSubjectClass();
	
	public String addSubjectClass(SubjectClass subjectClass);
	
	public String updateSubjectClass(SubjectClass subjectClass);
	
	public String removeSubjectClass(String subjectCode);

}
