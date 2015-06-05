package com.example.tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;





public class GroupCreationTests extends TestBase {
	
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group)
			throws Exception {
	

		// save old state сохранить старый список
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
		app.getGroupHelper().createGroup(group);
	
		

		// save new state сохранить новый список
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

		// compare state сравнение длины списков
		// assertEquals(newList.size(), oldList.size() + 1);

		oldList.add(group);
		AssertJUnit.assertEquals(newList, oldList);
	}

}
