package com.g3.spc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.action.spi.Executable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.g3.spc.entities.ClassDiary;
import com.g3.spc.entities.DiaryNotes;
import com.g3.spc.repository.IClassDiaryRepository;



@SpringBootTest
public class ClassDiaryServiceImplTest {
	IClassDiaryRepository cdRepo;
	private static IClassDiaryServiceImpl cdService;
	private static AutoCloseable ac;
	
	@BeforeEach
	public void doinit()
	{
	    cdRepo = mock(IClassDiaryRepository.class); 
		cdService = new  IClassDiaryServiceImpl(cdRepo); 	
		ac = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}
	@Test
	//@Disabled
	@DisplayName("Testing  Save ClassDiary")
	void testingSaveClassDiary() {
		Map<String,String> diarynotes = new HashMap<>();
		diarynotes.put("Science", "Do the work");
		DiaryNotes dn = new DiaryNotes(101,diarynotes);
	    Map<LocalDate,DiaryNotes> classdiary = new HashMap<>(); 
	    classdiary.put(LocalDate.of(2021,03,9),dn);
	    ClassDiary inputcd = new ClassDiary(1,classdiary);
	    ClassDiary actualcd = new ClassDiary(1,classdiary);
		when(cdRepo.save(inputcd)).thenReturn(actualcd);
		cdService.addClassDiary(inputcd);
		verify(cdRepo).save(inputcd);
		assertEquals(inputcd,actualcd);
	}
	
	@Test
	@Disabled
	@DisplayName("Testing All ClassDiary")
	void testingRetriveAllClassDiary () {
		
		Map<String,String> diarynotes = new HashMap<>();
		diarynotes.put("Science", "Do the work");
		DiaryNotes dn1 = new DiaryNotes(101,diarynotes);
	    Map<LocalDate,DiaryNotes> classdiary = new HashMap<>(); 
	    classdiary.put(LocalDate.of(2021,03,9),dn1);
	    ClassDiary cd1 = new ClassDiary(1,classdiary);
	    
	    Map<String,String> diarynotes1 = new HashMap<>();
		diarynotes1.put("Social", "Complete the task given");
		diarynotes1.put("Maths", "Do the given problems");
		DiaryNotes dn2 = new DiaryNotes(102,diarynotes1);
	    Map<LocalDate,DiaryNotes> classdiary1 = new HashMap<>(); 
	    classdiary1.put(LocalDate.of(2021,04,7),dn2);
	    ClassDiary cd2 = new ClassDiary(1,classdiary1);
	    
	    List<ClassDiary> classdiaryList = Arrays.asList(cd1,cd2);
		
		when(cdRepo.findAll()).thenReturn(classdiaryList);
		
		List<ClassDiary> classdiaryListOutput = cdService.getAllClassDiary();
		
		
		verify(cdRepo).findAll();
		assertIterableEquals(classdiaryList,classdiaryListOutput);
		
	}
//	
//	@Test
//	//@Disabled
//	@DisplayName("Testing Get ClassDiary by Date")
//	void testingRetriveAllClassDiaryByDate()  {
//		
//		LocalDate date = LocalDate.of(2021, 04, 7);
//		Optional<ClassDiary> cdList = Optional.empty(); 
//		when(cdRepo.retrieveClassDiary(date)).thenReturn(cdList);
//		ClassDiary classdiaryListOutput = cdService.retrieveClassDiary(date);
//		verify(cdRepo).retrieveClassDiary(date);
//				
//	}

}
