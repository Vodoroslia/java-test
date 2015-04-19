package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

	@Test
	public void testEmptyGroupCreation() throws Exception {
		openMainPage();
		gotoGroupPage();
		initNewGroupCreation();
		fillGroupForm(new GroupData("", "", ""));
		submitGroupCreation();
		gotoGroupPage();
	}
}
