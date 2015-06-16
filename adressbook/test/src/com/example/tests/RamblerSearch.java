package com.example.tests;
import org.testng.annotations.Test;
public class RamblerSearch extends TestBase{
	

	
	@Test
	public void rambler() throws Exception {


		openRambler();
		inputTextOnRambler();
	    clickSearchOnRambler();
		clickPerfPage();
		testPerfPage();
		savePage("C:\\rambler.txt");
	quitPages();

	}
	
	

}
