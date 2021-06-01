package com.g3.spc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.g3.spc.entities.ClassDiary;
import com.g3.spc.entities.DiaryNotes;
import com.g3.spc.repository.IDiaryNotesRepository;

@SpringBootTest
public class DiaryNotesServiceImplTest {
	IDiaryNotesRepository dnRepo;
	private static IDiaryNotesServiceImpl dnService;
	private static AutoCloseable ac;
	
	@BeforeEach
	public void doinit()
	{
	    dnRepo = mock(IDiaryNotesRepository.class); 
		dnService = new  IDiaryNotesServiceImpl(dnRepo); 	
		ac = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}
	@Test
	//@Disabled
	@DisplayName("Testing  Save DiaryNotes")
	void testingSaveDiaryNotes() {
		Map<String,String> diarynotes = new HashMap<>();
		diarynotes.put("Science", "Do the work");
		DiaryNotes inputdn = new DiaryNotes(101,diarynotes);
		DiaryNotes actualdn = new DiaryNotes(101,diarynotes);
	
		when(dnRepo.save(inputdn)).thenReturn(actualdn);
		dnService.addDiaryNotes(inputdn);
		verify(dnRepo).save(inputdn);
		assertEquals(inputdn,actualdn);
		
	}
	@Test
	//@Disabled
	@DisplayName("Testing All DiaryNotes")
	void testingRetriveAllDiaryNotes () {
		Map<String,String> diarynotes = new HashMap<>();
		diarynotes.put("Science", "Do the work");
		Map<String,String> diarynotes1 = new HashMap<>();
		diarynotes1.put("Social", "Complete the task given");
		diarynotes1.put("Maths", "Do the given problems");
		DiaryNotes dn1 = new DiaryNotes(101,diarynotes);
		DiaryNotes dn2 = new DiaryNotes(102,diarynotes1);
	   
	    
	    List<DiaryNotes> expectedDiaryNotesList = Arrays.asList(dn1,dn2);
	    
	    
		
		when(dnRepo.findAll()).thenReturn(expectedDiaryNotesList);
		
		List<DiaryNotes> actualDiaryNotesList = dnService.retrieveAllDiaryNotes();
		
		
		verify(dnRepo).findAll();
		assertIterableEquals(expectedDiaryNotesList,actualDiaryNotesList);
		
	}
	
	@Test
	//@Disabled
	@DisplayName("Testing Delete DiaryNotes")
	void testingDeleteDiaryNotes() {
		Map<String,String> diarynotes = new HashMap<>();
		diarynotes.put("Science", "Do the work");
	
		DiaryNotes expecteddn = new DiaryNotes(101,diarynotes);
		DiaryNotes actualdn = new DiaryNotes(101,diarynotes);
		
		doNothing().when(dnRepo).delete(expecteddn);
		     dnService.deleteDiaryNotes(expecteddn);

			verify(dnRepo).delete(expecteddn);
			assertEquals(expecteddn,actualdn);
	}
	
	@Test
	//@Disabled
	@DisplayName("Testing Update DiaryNotes")
	void testingUpdateDiaryNotes() {
		Map<String,String> diarynotes = new HashMap<>();
		diarynotes.put("Science", "Complete the given task");
		DiaryNotes inputdn = new DiaryNotes(101,diarynotes);
		DiaryNotes actualdn = new DiaryNotes(101,diarynotes);
		when(dnRepo.save(inputdn)).thenReturn(actualdn);
		dnService.updateDiaryNotes(inputdn);
		assertEquals(inputdn,actualdn);
	}
	
	@Test
	//@Disabled
	@DisplayName("Testing Get DiaryNotes by Subject Name ")
	void testingRetriveAllDiaryNotesBySubject()  {
		
		String subjectName = "Science";
		List<DiaryNotes> output = mock(List.class);
		when(dnRepo.findAll()).thenReturn(output);
		List<DiaryNotes> actualdn = dnService.retrieveAllDiaryNotes(subjectName);
		verify(dnRepo).findAll();
		
		
	}

}
