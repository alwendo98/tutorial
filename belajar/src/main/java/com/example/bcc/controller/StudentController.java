package com.example.bcc.controller;

import java.io.IOException;
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


import com.example.bcc.model.Student;
import com.example.bcc.service.StudentService;

import net.sf.jasperreports.engine.JRException;
import oracle.jdbc.proxy.annotation.Post;

@RestController
@RequestMapping("api/bcc/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping()
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}
	
	@PostMapping()
	public String regisStudent(@RequestBody Student student) {
		return studentService.regisStudent(student);
	}
	
	@PutMapping()
	public String updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("{nim}")
	public String expelStudent(@PathVariable String nim) {
		return studentService.expelStudent(nim);
	}
	
	@GetMapping("/showReport")
	public byte[] export() throws JRException, IOException{
		return studentService.exportReport();
	}
	
	@GetMapping("/createLetter")
	public byte[] createLetter() throws JRException, IOException{
		return studentService.createLetter();
	}

	@PostMapping("/generateKode")
		public String kodeUnik(@RequestBody String nim) {
			return studentService.kodeUnik(nim);
		}

    
	@PostMapping("/searchBy")
	public List<Student> findByName(@RequestBody String name) {
		return studentService.findByNameContainingIgnoreCase(name);
	}
	@PutMapping("/changePass")
	public String changePass(@RequestBody Student student) {
		return studentService.changePass(student);
		
	}
	

		
	}
	

