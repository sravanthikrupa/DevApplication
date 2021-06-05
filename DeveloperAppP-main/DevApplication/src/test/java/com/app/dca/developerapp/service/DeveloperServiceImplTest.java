package com.app.dca.developerapp.service;

import static org.junit.jupiter.api.Assertions.*;



import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.dca.exception.UnknownDeveloperException;
import com.app.dca.entity.Developer;
import com.app.dca.repository.DeveloperRepository;
import com.app.dca.repository.IDeveloperRepository;
import com.app.dca.service.IDeveloperServiceImpl;

@SpringBootTest
class DeveloperServiceImplTest {

	
	DeveloperRepository  developerRepo;
	private static IDeveloperServiceImpl developerService;
	private static AutoCloseable ac;
	
	@BeforeEach
	
	public void doinit()
	{
		
		developerRepo = mock(DeveloperRepository.class); // test through approach 2
		developerService = new  IDeveloperServiceImpl(developerRepo); 	// Approach 2
		ac = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}
	
	@Test
	//@Disabled
	@DisplayName("Test-Save developer")
	void testSaveDeveloper() {
		Developer input = new Developer(3, "abc", "abc@gmail.com", "Medium",LocalDate.of(2020, 05, 29),null,2,11,false,true);
		Developer savedDeveloper = new Developer(3, "abc", "abc@gmail.com", "Medium",LocalDate.of(2020, 05, 29),null,2,11,false,true);
	
		when(developerRepo.save(input)).thenReturn(savedDeveloper);
		developerService.addDeveloper(input);
		verify(developerRepo).save(input);
		
	}
	

	@Test
	//@Disabled
	@DisplayName("Test-Get All Developers")
	void testGetAllDevelopers() {
		
		
		List<Developer> developerList = mock(List.class); 
		//when() and 	//thenReturn()
		when(developerRepo.findAll()).thenReturn(developerList);
		//call the actual method 
		developerService.getAllDevelopers();
		//verify
		verify(developerRepo).findAll();
		
	}
	
	@Test
	//@Disabled
	@DisplayName("Test-Get Devveloper by Id")
	void testViewDeveloperById(){
		
		
		Optional<Developer> s = Optional.empty();
		//when() and 	//thenReturn()
		when(developerRepo.findById(2)).thenReturn(s);
		Executable executable = ()->developerService.getDeveloper(2);
		assertThrows(UnknownDeveloperException.class, executable);
		
	}
	
	
	
	
	@Test
//	@Disabled
	@DisplayName("Test-edit Developer")
	
	void testeditDeveloper() throws UnknownDeveloperException {
		Developer input = new Developer(3, "abc", "abc@gmail.com", "Expert",LocalDate.of(2021, 06, 30),null,2,11,false,true);
		Developer savedDeveloper = new Developer(3, "abc", "abc@gmail.com", "Expert",LocalDate.of(2021, 06, 30),null,2,11,false,true);
	
		when(developerRepo.save(input)).thenReturn(savedDeveloper);
		developerService.editDeveloper(input);
		verify(developerRepo).save(input);
		
		
	}

	
}