package com.g3.spc.dto;

import java.time.LocalDate;
import java.util.Map;

import com.g3.spc.entities.DiaryNotes;

public class ClassDiaryDTO {
     private int classdiaryId;
    
     private Map<LocalDate,DiaryNotes> subjectNotes;
     
     public ClassDiaryDTO() {
 		super();
 	}
     
	

	public ClassDiaryDTO(int classdiaryId, Map<LocalDate, DiaryNotes> subjectNotes) {
		super();
		this.classdiaryId = classdiaryId;
		this.subjectNotes = subjectNotes;
	}



	public int getClassdiaryId() {
		return classdiaryId;
	}

	public void setClassdiaryId(int classdiaryId) {
		this.classdiaryId = classdiaryId;
	}


	public Map<LocalDate, DiaryNotes> getSubjectNotes() {
		return subjectNotes;
	}



	public void setSubjectNotes(Map<LocalDate, DiaryNotes> subjectNotes) {
		this.subjectNotes = subjectNotes;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classdiaryId;
		result = prime * result + ((subjectNotes == null) ? 0 : subjectNotes.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassDiaryDTO other = (ClassDiaryDTO) obj;
		if (classdiaryId != other.classdiaryId)
			return false;
		if (subjectNotes == null) {
			if (other.subjectNotes != null)
				return false;
		} else if (!subjectNotes.equals(other.subjectNotes))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "ClassDiaryDTO [classdiaryId=" + classdiaryId + ", subjectNotes=" + subjectNotes + "]";
	}



     
}
