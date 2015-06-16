package com.example.tests;
import org.testng.annotations.Test;
public class GoogleSearch extends TestBase{
	@Test
	public void google() throws Exception {

		openGoogle();
		inputTextOnGoogle();
		clickSearchOnGoogle();
		clickPerfPage();
		testPerfPage();
		savePage("C:\\google.txt");
	quitPages();
	}

}
