package com.example.tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTest extends TestBase {
	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactCreationWithValidData(ContactData contact) 
			throws Exception {

		// save old state ��������� ������ ������
		 SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		app.getContactHelper().createContact(contact);

		

		// save new state ��������� ����� ������
		 SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

		// compare state ��������� ����� �������
		// assertEquals(newList.size(), oldList.size() + 1);

		oldList.add(contact);
	
		AssertJUnit.assertEquals(newList, oldList);
	}

	

}
