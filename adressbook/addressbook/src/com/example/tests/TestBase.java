package com.example.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.example.fw.ApplicationManager;

public class TestBase { protected ApplicationManager app;

	@BeforeMethod
	
	public void setUp() throws Exception {
		
		app = new  ApplicationManager () ;
		
	}

	@AfterMethod

	public void tearDown() throws Exception {
		app.stop();
		
		
	}

}
