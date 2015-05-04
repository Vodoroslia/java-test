package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {
	
	@Test
	
	public void deleteSomeGroup() {
		app.getNavigatinHelper().openMainPage();
		app.getNavigatinHelper().gotoGroupPage();
		app.getGroupHelper().deleteGroup(1);
		app.getNavigatinHelper().gotoGroupPage();
		

	

}
	
}
