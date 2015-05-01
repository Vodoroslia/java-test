package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

	@Test
	public void testEmptyGroupCreation() throws Exception {
		app.getNavigatinHelper().openMainPage();
		app.getNavigatinHelper().gotoGroupPage();
		app.getGroupHelper().initNewGroupCreation();
		app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
		app.getGroupHelper().submitGroupCreation();
		app.getNavigatinHelper().gotoGroupPage();
	}
	
	@Test
	public void testNonEmptyGroupCreation() throws Exception {
		GroupData group = new GroupData();
		app.getNavigatinHelper().openMainPage();
		app.getNavigatinHelper().gotoGroupPage();
		app.getGroupHelper().initNewGroupCreation();
		
		group.name = "group name 1";
		group.header = "header 1";
		group.footer = "footer 1";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupCreation();
		app.getNavigatinHelper().gotoGroupPage();
	}
}
