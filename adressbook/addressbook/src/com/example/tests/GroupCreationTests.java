package com.example.tests;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

	@Test
	public void testNonEmptyGroupCreation() throws Exception {

		app.getNavigatinHelper().openMainPage();
		app.getNavigatinHelper().gotoGroupPage();
		// save old state сохранить старый список
		List<GroupData> oldList = app.getGroupHelper().getGroups();

		app.getGroupHelper().initNewGroupCreation();
		GroupData group = new GroupData();
		group.name = "aaa";
		group.header = "header 1";
		group.footer = "footer 1";

		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupCreation();
		app.getNavigatinHelper().gotoGroupPage();

		// save new state сохранить новый список
		List<GroupData> newList = app.getGroupHelper().getGroups();

		// compare state сравнение длины списков
		//assertEquals(newList.size(), oldList.size() + 1);

		oldList.add(group);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
	
	@Test
	public void testEmptyGroupCreation() throws Exception {
		app.getNavigatinHelper().openMainPage();
		app.getNavigatinHelper().gotoGroupPage();
		
		// save old state сохранить старый список
		List<GroupData> oldList = app.getGroupHelper().getGroups();
		
		GroupData group = new GroupData("", "", "");
		app.getGroupHelper().initNewGroupCreation();
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupCreation();
		app.getNavigatinHelper().gotoGroupPage();

		// save new state сохранить новый список
		List<GroupData> newList = app.getGroupHelper().getGroups();
		// compare state сравнение списков
		assertEquals(newList.size(), oldList.size() + 1);

		oldList.add(group);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
	
}
