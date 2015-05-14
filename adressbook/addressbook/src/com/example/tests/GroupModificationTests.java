package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

	@Test
	public void modifySomeGroup() {
		app.getNavigatinHelper().openMainPage();
		app.getNavigatinHelper().gotoGroupPage();
		// save old state сохранить старый список
		List<GroupData> oldList = app.getGroupHelper().getGroups();
		// actions
		GroupData group = new GroupData();
		app.getGroupHelper().initGroupModification(0);
		group.name = "new name";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getNavigatinHelper().gotoGroupPage();
		// save new state сохранить новый список
		List<GroupData> newList = app.getGroupHelper().getGroups();
		// compare state сравнение длины списков
		// assertEquals(newList.size(), oldList.size() - 1);
		oldList.remove(0);
		oldList.add(group);
		Collections.sort(oldList);
		Collections.sort(newList);
		assertEquals(newList, oldList);

	}
}
