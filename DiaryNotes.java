package com.g3.spc.entities;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "DiaryNotes Bean")
@Validated
public class DiaryNotes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(name = "DiaryNotesId",value = "Holds the Id of the DiaryNotes")
	private int diaryNotesId;
	@ApiModelProperty(name = "SubjectNotes",value = "Holds the map of subjects and their diary notes")
	@ElementCollection
	@CollectionTable(name = "SubjectNotesInfo", 
    joinColumns = {@JoinColumn(name = "DiaryNotesId", referencedColumnName = "diaryNotesId")})
	@MapKeyColumn(name = "SubjectName")
    @Column(name = "Notes")
	@NotEmpty(message = "Notes cannot be Empty")
	@Valid private Map<@NotBlank(message ="The Subject cannot be Blank or null") String,@NotBlank(message ="The Notes of the subject cannot be null")String> notes;

	public DiaryNotes() {
		super();
	}

	public DiaryNotes(int diaryNotesId, Map< String,String> notes) {
		super();
		this.diaryNotesId = diaryNotesId;
		this.notes = notes;
	}


	public int getDiaryNotesId() {
		return diaryNotesId;
	}
	public void setDiaryNotesId(int diaryNotesId) {
		this.diaryNotesId = diaryNotesId;
	}
	


	public Map<String, String> getNotes() {
		return notes;
	}


	public void setNotes(Map<String, String> notes) {
		this.notes = notes;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + diaryNotesId;
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
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
		DiaryNotes other = (DiaryNotes) obj;
		if (diaryNotesId != other.diaryNotesId)
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "DiaryNotes [diaryNotesId=" + diaryNotesId + ", notes=" + notes + "]";
	}

}
