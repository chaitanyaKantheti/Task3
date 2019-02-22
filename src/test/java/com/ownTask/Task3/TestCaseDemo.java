package com.ownTask.Task3;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//import com.ownTask.Task3.services.TestCasesDemo;
import com.ownTask.Task3.services.TestCasesTesting;



@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCaseDemo {

	//@Autowired
	//private TestCasesDemo testCasesDemo;
	
	@Autowired
	private TestCasesTesting testCasesTesting;
	
	@Test
	public void whenUserIdIsProvided_thenRetrieveNameIsCorrect() {
		Mockito.when(testCasesTesting.getGreeting()).thenReturn("Mock Greeting");
		String testName= testCasesTesting.getGreeting();
		Assert.assertEquals("Mock Greeting", testName);
	}
}
