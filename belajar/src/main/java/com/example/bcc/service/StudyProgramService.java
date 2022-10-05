package com.example.bcc.service;

import java.io.IOException;
import java.util.List;
import com.example.bcc.model.StudyProgram;

import net.sf.jasperreports.engine.JRException;


public interface StudyProgramService {
	
	public List<StudyProgram> getAllStudyProgram();
	
	public String addStudyProgram(StudyProgram studyProgram);
	
	public String updateStudyProgram(StudyProgram studyProgram);
	
	public String deleteStudyProgram(Integer kodePs);
	
	public byte[] exportReport()  throws JRException, IOException ;

}
