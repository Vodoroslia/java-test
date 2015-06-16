package com.example.tests;
import org.testng.annotations.Test;
public class YandexSearch extends TestBase{
	

	@Test
	public void yandex() throws Exception {

		openYandex();

		inputTextOnYandex();
		clickSearhOnYandex();
		clickPerfPage();
		testPerfPage();
		savePage("C:\\yandex.txt");
 	quitPages();
	}

	



}
