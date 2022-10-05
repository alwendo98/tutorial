package com.example.bcc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bcc.model.StudyProgram;

@Repository
public interface StudyProgramRepository extends JpaRepository<StudyProgram, Integer> {
	
	Optional<StudyProgram> findByKodePs(String kodePs);
	
}
