package com.g3.spc.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.g3.spc.entities.ClassDiary;
import com.g3.spc.repository.IClassDiaryRepository;

@Service
public class IClassDiaryServiceImpl implements IClassDiaryService{
	
	@Autowired
	IClassDiaryRepository classdiaryrepo;
	
	

	public IClassDiaryServiceImpl() {
		super();
	}

	public IClassDiaryServiceImpl(IClassDiaryRepository classdiaryrepo) {
		super();
		this.classdiaryrepo = classdiaryrepo;
	}

	@Override
	@Transactional
	public ClassDiary addClassDiary(ClassDiary classDiary) {
		// TODO Auto-generated method stub
		classdiaryrepo.save(classDiary);
		return classDiary;
	}

	@Override
	public ClassDiary retrieveClassDiary(LocalDate date) {
		// TODO Auto-generated method stub
		List<ClassDiary> AllClassDiary = classdiaryrepo.findAll();
		
		ClassDiary classdiary = AllClassDiary.stream().filter((cd)->(cd.getDiaryNotes().containsKey(date))).findAny().orElse(null);
		return classdiary;
	}
	
	@Override
	public List<ClassDiary> getAllClassDiary() {
		// TODO Auto-generated method stub
		
		return classdiaryrepo.findAll();
	}
    

}
