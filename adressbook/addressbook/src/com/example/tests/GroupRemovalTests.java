package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {

	@Test
	public void deleteSomeGroup() {
		app.getNavigatinHelper().openMainPage();
		app.getNavigatinHelper().gotoGroupPage();
		
		// save old state сохранить старый список
		List<GroupData> oldList = app.getGroupHelper().getGroups();
		
		//actions
		app.getGroupHelper().deleteGroup(0);
		app.getNavigatinHelper().gotoGroupPage();
		// save new state сохранить новый список
		List<GroupData> newList = app.getGroupHelper().getGroups();

		// compare state сравнение длины списков
		// assertEquals(newList.size(), oldList.size() - 1);
		oldList.remove(0);
		Collections.sort(oldList);
		assertEquals(newList, oldList);

	}

}
