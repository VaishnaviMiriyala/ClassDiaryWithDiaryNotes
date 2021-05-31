package com.g3.spc.service;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.g3.spc.entities.DiaryNotes;
import com.g3.spc.entities.Subject;
import com.g3.spc.repository.IDiaryNotesRepository;

@Service
public class IDiaryNotesServiceImpl implements IDiaryNotesService{
	
	@Autowired
	IDiaryNotesRepository diarynotesrepo;
	
	

	public IDiaryNotesServiceImpl() {
		super();
	}

	public IDiaryNotesServiceImpl(IDiaryNotesRepository diarynotesrepo) {
		super();
		this.diarynotesrepo = diarynotesrepo;
	}

	@Override
	@Transactional
	public DiaryNotes addDiaryNotes(DiaryNotes diaryNotes) {
		// TODO Auto-generated method stub
		diarynotesrepo.save(diaryNotes);
		return diaryNotes;
	}

	@Override
	@Transactional
	public DiaryNotes updateDiaryNotes(DiaryNotes diaryNotes) {
		
		Optional<DiaryNotes> searchDiarynotes = diarynotesrepo.findById(diaryNotes.getDiaryNotesId());
		DiaryNotes dn = null;
		if(searchDiarynotes.isPresent()) {
			dn = searchDiarynotes.get();
		    dn.setNotes(diaryNotes.getNotes());
		    diarynotesrepo.save(dn);
		}
		return dn;
	}

	@Override
	public DiaryNotes deleteDiaryNotes(DiaryNotes diaryNotes) {
		// TODO Auto-generated method stub
		diarynotesrepo.delete(diaryNotes);
		return diaryNotes;
	}

	@Override
	public List<DiaryNotes> retrieveAllDiaryNotes() {
		// TODO Auto-generated method stub
		return diarynotesrepo.findAll();
	}

	@Override
	public List<DiaryNotes> retrieveAllDiaryNotes(String subject) {
		// TODO Auto-generated method stub
		List<DiaryNotes> AllDiaryNotes = diarynotesrepo.findAll();
		List<DiaryNotes> tempDiaryNotes = new ArrayList<>();
		//Below code need to be changed to stream APi
		for(DiaryNotes dn: AllDiaryNotes) {
			if(dn.getNotes().containsKey(subject))tempDiaryNotes.add(dn);
		}
		return tempDiaryNotes;
	}
	

	@Override
	public List<DiaryNotes> retrieveAllDiaryNotes(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<DiaryNotes> retrieveAllDiaryNotes(Subject subject) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
