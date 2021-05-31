package com.g3.spc.web;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3.spc.dto.ClassDiaryDTO;
import com.g3.spc.entities.Attendance;
import com.g3.spc.entities.ClassDiary;
import com.g3.spc.entities.DiaryNotes;
import com.g3.spc.entities.Student;
import com.g3.spc.entities.Subject;
import com.g3.spc.service.IAttendanceService;
import com.g3.spc.service.IClassDiaryService;
import com.g3.spc.service.IDiaryNotesService;
import com.g3.spc.service.IStudentService;
import com.g3.spc.service.ISubjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Validated
@RestController
@RequestMapping("/api")
@Api(value = "Online Student Portel",description = "Various api works on student details")
public class MyRestController {
	
	Logger log = org.slf4j.LoggerFactory.getLogger(MyRestController.class);
	
	@Autowired
	IDiaryNotesService diarynotes;
	
	@Autowired
	IClassDiaryService classdiary;
	
	@Autowired
	ISubjectService subject;
//	
//	@Autowired
//	private IStudentService students;
//	
//	@Autowired
//	private IAttendanceService attendance;
//	
	public MyRestController() {
		log.info("MyRestController CONSTRUCTOR ");
		System.out.println("------------My rest Controller---------------");
	}
	
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome To SPC Application"+ LocalDateTime.now();
	}
	
	@ApiOperation(value = "DiaryNotes post mapping" , response = DiaryNotes.class)
	@PostMapping("/DiaryNotes")
	public DiaryNotes insertDiaryNotes(@RequestBody  @Valid DiaryNotes dn){
		log.info("Inside insert DiaryNotes");
		diarynotes.addDiaryNotes(dn);
		return dn;
	}
	
	@ApiOperation(value = "ClassDiary post mapping" , response = ClassDiary.class)
	@PostMapping("/ClassDiary")
	public ClassDiaryDTO insertClassDiary(@RequestBody  @Valid ClassDiary cd){
		log.info("Inside insert ClassDiary");
		
		ClassDiary input = classdiary.addClassDiary(cd);
		ClassDiaryDTO output = classdiary.getClassDiaryDetails(input);
		return output;
	}
	
	@ApiOperation(value = "DiaryNotes get mapping to fetch all the notes" , response = List.class)
	@GetMapping("/DiaryNotes")
	public List<DiaryNotes> getAllDiaryNotes(){
		log.info("Inside Get all DiaryNotes");
		return diarynotes.retrieveAllDiaryNotes();
	}
	
	@ApiOperation(value = "DiaryNotes get mapping to delete the notes" , response = DiaryNotes.class)
	@GetMapping("/DiaryNotes/Delete")
	public DiaryNotes deleteDiaryNotes(@RequestBody DiaryNotes dn){
		log.info("Inside delete DiaryNotes");
		return diarynotes.deleteDiaryNotes(dn);
	}
	
	@ApiOperation(value = "DiaryNotes get mapping to fetch notes by subject" , response = DiaryNotes.class)
	@GetMapping("/DiaryNotes/{subject}")
	public List<DiaryNotes> getAllDiaryNotes(@PathVariable String subject){
		log.info("Inside get all DiaryNotes by subject");
		return  diarynotes.retrieveAllDiaryNotes(subject);
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
	
	
	@ApiOperation(value = "DiaryNotes put mapping to update notes" , response = DiaryNotes.class)
	@PutMapping("/DiaryNotes")
	public DiaryNotes doUpdate(@RequestBody DiaryNotes dn) {
		log.info("Inside update DiaryNotes");
		return diarynotes.updateDiaryNotes(dn);
	}
	
	@PostMapping("/subjectdetails")
	public Subject insertSubjectDetails(@RequestBody Subject s){
	    subject.insertSubject(s);
		return s;
	}

//	
//	@PostMapping("/studentdetails")
//	public Student insertStudentDetails(@RequestBody Student s){
//		students.addStudent(s);
//		return s;
//	}
//	
//	@PostMapping("/attendancedetails")
//	public Attendance insertAttendanceDetails(@RequestBody Attendance a){
//		attendance.addAttendance(a);
//		return a;
//	}

}
