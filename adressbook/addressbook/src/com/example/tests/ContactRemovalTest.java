package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTest extends TestBase {

@Test
	public void deleteSomeContact() {
	app.getNavigatinHelper().openMainPage();
	app.getNavigatinHelper().openContactPage();
	
	// save old state ��������� ������ ������
	List<ContactData> oldList = app.getContactHelper().getContacts();
	
	//actions
	app.getContactHelper().deleteContact(0);
	app.getContactHelper().returnContactPage();
	// save new state ��������� ����� ������
	List<ContactData> newList = app.getContactHelper().getContacts();

			// compare state ��������� ����� �������
			// assertEquals(newList.size(), oldList.size() - 1);
			oldList.remove(0);
			Collections.sort(oldList);
			Collections.sort(newList);
			assertEquals(newList, oldList);

	
	
}
}
