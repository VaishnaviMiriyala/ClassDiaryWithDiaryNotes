package com.g3.spc.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.g3.spc.entities.ClassDiary;

public interface IClassDiaryRepository extends JpaRepository<ClassDiary,Integer>{
	/*public ClassDiary addClassDiary(ClassDiary classDiary);
	public ClassDiary retrieveClassDiary(LocalDate date);*/
	
}
