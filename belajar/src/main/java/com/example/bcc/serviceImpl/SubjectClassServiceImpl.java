package com.example.bcc.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bcc.model.SubjectClass;
import com.example.bcc.repository.SubjectClassRepository;
import com.example.bcc.service.SubjectClassService;

@Service
public class SubjectClassServiceImpl implements SubjectClassService {

	@Autowired
	SubjectClassRepository subjectClassRepo;

	@Override
	public List<SubjectClass> getAllSubjectClass() {
		return subjectClassRepo.findAll();
	}

	@Override
	public String addSubjectClass(SubjectClass subjectClass) {
		String result = "Add Subject Class Failed";

		if (subjectClass != null) {
			subjectClassRepo.save(subjectClass);
			result = "Add Subject Class Success";
		}

		return result;
	}

	@Override
	public String updateSubjectClass(SubjectClass subjectClass) {
		String result = "Update Subject Class Failed";

		Optional<SubjectClass> extSubjectClass = subjectClassRepo.findById(subjectClass.getSubjectCode());

		if (extSubjectClass.isPresent()) {
			subjectClassRepo.save(subjectClass);
			result = "Update Subject Class Success";
		}

		return result;
	}

	@Override
	public String removeSubjectClass(String subjectCode) {
		String result = "Delete Subject Class Failed";

		Optional<SubjectClass> extSubjectClass = subjectClassRepo.findById(subjectCode);

		if (extSubjectClass.isPresent()) {
			subjectClassRepo.deleteById(subjectCode);
			result = "Delete Subject Class Success";
		}

		return result;
	}

}
