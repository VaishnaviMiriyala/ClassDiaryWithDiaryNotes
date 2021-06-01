package com.g3.spc.web;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3.spc.entities.ClassDiary;
import com.g3.spc.service.IClassDiaryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/api")
@Api(value = "Online Student Portel",description = "Various api works on student details")
public class ClassDiaryController {
	Logger log = org.slf4j.LoggerFactory.getLogger(ClassDiaryController.class);
	
	@Autowired
	IClassDiaryService classdiary;
	
	@ApiOperation(value = "ClassDiary post mapping" , response = ClassDiary.class)
	@PostMapping("/ClassDiary")
	public ClassDiary insertClassDiary(@RequestBody  @Valid ClassDiary cd){
		log.info("Inside insert ClassDiary");
		
	    classdiary.addClassDiary(cd);	
		return cd;
	}
	

	@ApiOperation(value = "ClassDiary get mapping to fetch all the diarynotes" , response = List.class)
	@GetMapping("/ClassDiary")
	public List<ClassDiary> getAllClassDiary(){
		log.info("Inside Get all ClassDiary");
		return  classdiary.getAllClassDiary();
	}
	
	@ApiOperation(value = "ClassDiary get mapping to fetch all the diarynotes by date" , response = ClassDiary.class)
	@GetMapping("/ClassDiary/{date}")
	public ClassDiary getAllClassDiary(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date){
		log.info("Inside Get ClassDiary by date");
		return  classdiary.retrieveClassDiary(date);
	}
	

}
