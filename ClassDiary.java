package com.g3.spc.entities;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "ClassDiary Bean")
public class ClassDiary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(name = "ClassDiaryId",value = "Holds the Id of the ClassDiary")
	private int classDiaryId;
	@ApiModelProperty(name = "DiaryNotes",value = "Holds the map of diarynotes of a perticuar date")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="classDiaryId")
	@NotEmpty(message = "ClassDiary cannot be Empty")
	private Map<LocalDate,DiaryNotes> diaryNotes;
	
	public ClassDiary() {
		super();
	}
	
	public ClassDiary(int classDiaryId,Map<LocalDate, DiaryNotes> diaryNotes) {
		super();
		this.classDiaryId = classDiaryId;
		this.diaryNotes = diaryNotes;
	}
	public int getClassDiaryId() {
		return classDiaryId;
	}
	public void setClassDiaryId(int classDiaryId) {
		this.classDiaryId = classDiaryId;
	}
	public Map<LocalDate, DiaryNotes> getDiaryNotes() {
		return diaryNotes;
	}
	public void setDiaryNotes(Map<LocalDate,DiaryNotes> diaryNotes) {
		this.diaryNotes = diaryNotes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classDiaryId;
		result = prime * result + ((diaryNotes == null) ? 0 : diaryNotes.hashCode());
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
		ClassDiary other = (ClassDiary) obj;
		if (classDiaryId != other.classDiaryId)
			return false;
		if (diaryNotes == null) {
			if (other.diaryNotes != null)
				return false;
		} else if (!diaryNotes.equals(other.diaryNotes))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ClassDiary [classDiaryId=" + classDiaryId + ", diaryNotes=" + diaryNotes + "]";
	}
	
}
