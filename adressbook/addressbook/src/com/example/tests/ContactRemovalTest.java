package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTest extends TestBase {

	@Test
	public void deleteSomeContact() {

	

		// save old state сохранить старый список
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		// actions
		app.getContactHelper().deleteContact(index);
		// save new state сохранить новый список
		SortedListOf<ContactData> newList = app.getContactHelper()
				.getContacts();

		assertThat(newList, equalTo(oldList.without(index)));
	}
}
