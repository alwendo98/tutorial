package com.example.bcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bcc.model.SubjectClass;

@Repository
public interface SubjectClassRepository extends JpaRepository<SubjectClass, String>{

}
