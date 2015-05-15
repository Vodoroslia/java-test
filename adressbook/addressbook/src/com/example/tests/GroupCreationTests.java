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
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();

		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData();
			group.name = generateRandomString();
			group.header = generateRandomString();
			group.footer = generateRandomString();
			list.add(new Object[] { group });
		}
		return list.iterator();
	}

	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}

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
