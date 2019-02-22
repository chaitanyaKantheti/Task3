package com.ownTask.Task3.services;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class DemoTestConfiguration {
	@Bean
	@Primary
	public TestCasesDemo  testCasesDemo() {
		return Mockito.mock(TestCasesDemo.class);
	}
}
