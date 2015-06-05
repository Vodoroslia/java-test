package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) {
		app.navigateTo().openContactPage();

		// save old state сохранить старый список
		SortedListOf<ContactData> oldList = app.getContactHelper()
				.getContacts();
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		app.getContactHelper().modifyContact(index, contact);

		app.navigateTo().openContactPage();
		// save new state сохранить новый список
		SortedListOf<ContactData> newList = app.getContactHelper()
				.getContacts();
		
		assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));

	}

}
