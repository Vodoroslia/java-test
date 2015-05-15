package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTest extends TestBase {

@Test
	public void deleteSomeContact() {
	app.getNavigatinHelper().openMainPage();
	app.getNavigatinHelper().openContactPage();
	
	// save old state сохранить старый список
	List<ContactData> oldList = app.getContactHelper().getContacts();
	
	Random rnd= new Random();
	int index =rnd.nextInt(oldList.size()-1);
	
	//actions
	app.getContactHelper().deleteContact(index);
	app.getContactHelper().returnContactPage();
	// save new state сохранить новый список
	List<ContactData> newList = app.getContactHelper().getContacts();

			// compare state сравнение длины списков
			// assertEquals(newList.size(), oldList.size() - 1);
			oldList.remove(index);
			Collections.sort(oldList);
			Collections.sort(newList);
			assertEquals(newList, oldList);
	
}
}
