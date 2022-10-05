package com.example.bcc.serviceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.example.bcc.model.Student;
import com.example.bcc.repository.StudentRepository;
import com.example.bcc.service.StudentService;

import ch.qos.logback.core.boolex.Matcher;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import oracle.jdbc.logging.annotations.StringBlinder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepo;

	
	@Override
	public List<Student> getAllStudent() {
		return studentRepo.findAll();
	}

	@Override
	public String regisStudent(Student student) {
		String result = "Register Student Failed";

		if (student != null) {
			studentRepo.save(student);
			result = "Register Student Success";
		}

		return result;
	}

	@Override
	public String updateStudent(Student student) {
		String result = "Update Student Failed";

		Optional<Student> extStudent = studentRepo.findById(student.getNim());

		if (extStudent.isPresent()) {
		
			studentRepo.save(student);
			result = "Update Student Success";
		}

		return result;
	}

	@Override
	public String expelStudent(String nim) {
		String result = "Delete Student Failed";

		Optional<Student> extStudent = studentRepo.findById(nim);

		if (extStudent.isPresent()) {
			studentRepo.deleteById(nim);
			result = "Delete Student Success";
		}

		return result;
	}

	
	@Override
	public byte[] exportReport() throws JRException, IOException {
	InputStream filePath = new ClassPathResource("/template/Surat Lamaran.jrxml").getInputStream();	
		
		List<Student> dsStudent = getAllStudent();
		
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(dsStudent);
		
		JasperReport report = JasperCompileManager.compileReport(filePath);
		
		JasperPrint print = JasperFillManager.fillReport(report, null,ds);
		
		byte[]  byteArr = JasperExportManager.exportReportToPdf(print);
		
		return byteArr;
		
	}

	@Override
	public byte[] createLetter() throws JRException, IOException {
		InputStream filePath = new ClassPathResource("/template/Surat Lamaran2.jrxml").getInputStream();	
		
		List<Student> dsStudent = getAllStudent();
		
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(dsStudent);
		
		JasperReport report = JasperCompileManager.compileReport(filePath);
		
		JasperPrint print = JasperFillManager.fillReport(report, null,ds);
		
		byte[]  byteArr = JasperExportManager.exportReportToPdf(print);
		
		return byteArr;
	}

	@Override
	public String kodeUnik(String nim) {
		String result=nim.substring(2,5);
		
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy");
		String str = formatter.format(date);
		String a= result+"/"+str;
		
		
		int nilai = (int)(Math.random()*1000);
		String b =String.valueOf(nilai);
		
		int panjang = b.length();
		
		if(panjang==1) {
			b="000"+b;
		}else if(panjang==2) {
			b="00"+b;
		}else if(panjang==3) {
			b="0"+b;
		}else if(panjang==4) {
			b+=b;
		}
		
		String maka = a+"/"+b;
		return maka;
	}

     @Override
	public String addPass(String pass) {
		String result = "Add Pass Failed";
		if(pass != null) {
			BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
			result = passEncoder.encode(pass);
		}
		return result;
	}

     @Override
 	public List<Student> findByNameContainingIgnoreCase(String name) {
 		return studentRepo.findByNameContainingIgnoreCase(name);
 	
 	}

     
     private static int latestId = 0;
 	@Override
 	public String noSurat(String jabatan) {
 		String result="Nomor surat gagal dibuat";
 		
 		++latestId;
 		String inRandom = String.format ("%04d",latestId);
 		result =inRandom;
 		
 		if(jabatan.equals("Mahasiswa")) {
 			result +="/MHS";
 		}else if (jabatan.equals("Dosen")) {
 			result +="/LEC";
 		}
 		
 		Date date = new Date();
 		SimpleDateFormat formatter = new SimpleDateFormat("M");
 		String strDate = formatter.format(date);
 		int bulan = Integer.parseInt(strDate);
 		
 		String roman ="";
 		
 	     while(bulan>=10){
              if (bulan>=40){
                  roman="XL";
                  bulan = bulan - 40;
              }
              else{
                  roman="X";
                  bulan = bulan - 10;
              }
          }
          if (bulan >=5){
              if (bulan == 9){
                  roman="IX";
                  bulan = bulan - 9;
              }
              else
                  roman="V";
                  bulan = bulan - 5;
          }
      
          while(bulan>=1){
          if (bulan == 4){
              roman="IV";
              bulan = bulan - 4;
          }
          else
              roman="I";
              bulan = bulan - 1;
          }
 		result +="/"+roman;
 		
 		SimpleDateFormat formatter2 = new SimpleDateFormat("yy");
 		String strDate2 = formatter2.format(date);
 		
 		result +="/"+strDate2;
 				
 		return result;
 	}

	@Override
	public String changePass(Student student) {
		// TODO Auto-generated method stub
		return null;
	}


	}

	

	

	
	

	

	

		
		
		
	
	
	


