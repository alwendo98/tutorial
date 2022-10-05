package com.example.bcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bcc.model.SubjectClass;
import com.example.bcc.service.SubjectClassService;

@RestController
@RequestMapping("api/bcc/subjectClass")
public class SubjectClassController {
	
	@Autowired
	SubjectClassService subjectClassService;
	
	@GetMapping
	public List<SubjectClass> getAllSubjectClass(){
		return subjectClassService.getAllSubjectClass();
	}
	
	@PostMapping
	public String addSubjectClass(@RequestBody SubjectClass subjectClass) {
		return subjectClassService.addSubjectClass(subjectClass);
	}
	
	@PutMapping
	public String updateSubjectClass(@RequestBody SubjectClass subjectClass) {
		return subjectClassService.updateSubjectClass(subjectClass);
	}
	
	@DeleteMapping("{subjectCode}")
	public String removeSubjectClass(@PathVariable String subjectCode) {
		return subjectClassService.removeSubjectClass(subjectCode);
	}
}
