package com.g3.spc.service;

import java.time.LocalDate;
import java.util.List;

import com.g3.spc.entities.DiaryNotes;
import com.g3.spc.entities.Subject;

public interface IDiaryNotesService {
	public DiaryNotes addDiaryNotes(DiaryNotes diaryNotes);
	public DiaryNotes updateDiaryNotes(DiaryNotes diaryNotes);
	public DiaryNotes deleteDiaryNotes(DiaryNotes diaryNotes);
	public List<DiaryNotes> retrieveAllDiaryNotes(LocalDate date);
	public List<DiaryNotes> retrieveAllDiaryNotes(Subject subject);
	public List<DiaryNotes> retrieveAllDiaryNotes(String subject);
	public List<DiaryNotes> retrieveAllDiaryNotes();
	
}
