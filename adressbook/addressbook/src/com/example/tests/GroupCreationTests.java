package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupsForDataProvider(
				loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	}

	@Test(dataProvider = "groupsFromFile")
	// @Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group)
			throws Exception {

		// ��������� ������ ������
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
		app.getGroupHelper().createGroup(group);

		// ��������� ����� ������
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

		// ��������� ����� �������

		oldList.add(group);
		AssertJUnit.assertEquals(newList, oldList);
	}

}
