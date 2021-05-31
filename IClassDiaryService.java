package com.g3.spc.service;

import java.time.LocalDate;
import java.util.List;

import com.g3.spc.dto.ClassDiaryDTO;
import com.g3.spc.entities.ClassDiary;

public interface IClassDiaryService {
	public ClassDiary addClassDiary(ClassDiary classDiary);
	public ClassDiary retrieveClassDiary(LocalDate date);
	public List<ClassDiary> getAllClassDiary();
	public ClassDiaryDTO getClassDiaryDetails(ClassDiary cd) ;
}
