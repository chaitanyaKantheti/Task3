package com.ownTask.Task3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestCasesTesting {
	
	@Autowired
	private TestCasesDemo testCasesDemo;
	
	
	public TestCasesTesting(TestCasesDemo testCasesDemo) {
		this.testCasesDemo = testCasesDemo;
	}


	public String getGreeting() {
		return testCasesDemo.getGreeting();
	}
}
