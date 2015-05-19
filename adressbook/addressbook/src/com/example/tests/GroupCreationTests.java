package com.example.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group)
			throws Exception {

		app.getNavigatinHelper().openMainPage();
		app.getNavigatinHelper().gotoGroupPage();
		// save old state сохранить старый список
		List<GroupData> oldList = app.getGroupHelper().getGroups();

		app.getGroupHelper().initNewGroupCreation();

		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupCreation();
		app.getNavigatinHelper().gotoGroupPage();

		// save new state сохранить новый список
		List<GroupData> newList = app.getGroupHelper().getGroups();

		// compare state сравнение длины списков
		// assertEquals(newList.size(), oldList.size() + 1);

		oldList.add(group);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}

}
