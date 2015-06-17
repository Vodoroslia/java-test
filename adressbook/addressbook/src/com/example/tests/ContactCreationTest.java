package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTest extends TestBase {
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(
				loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
	}

	@Test(dataProvider = "contactsFromFile")
	public void testContactCreationWithValidData(ContactData contact)
			throws Exception {

		// save old state сохранить старый список
		SortedListOf<ContactData> oldList = app.getContactHelper()
				.getContacts();
		app.getContactHelper().createContact(contact);

		// save new state сохранить новый список
		SortedListOf<ContactData> newList = app.getContactHelper()
				.getContacts();

		// compare state сравнение длины списков
		// assertEquals(newList.size(), oldList.size() + 1);

		oldList.add(contact);

		AssertJUnit.assertEquals(newList, oldList);
	}

}
