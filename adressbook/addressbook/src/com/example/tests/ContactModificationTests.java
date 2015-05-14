package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

	
	
	@Test 
	public void modifySomeContact() {
		app.getNavigatinHelper().openMainPage();
		app.getNavigatinHelper().openContactPage();
		
		// save old state сохранить старый список
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		app.getContactHelper().initContactModification(0);
		ContactData contact= new ContactData ();
		contact.firstname="newfirstname";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getNavigatinHelper().openContactPage();
		// save new state сохранить новый список
		List<ContactData> newList = app.getContactHelper().getContacts();
			// compare state сравнение длины списков
				// assertEquals(newList.size(), oldList.size() - 1);
				oldList.remove(0);
				oldList.add(contact);
				Collections.sort(oldList);
				Collections.sort(newList);
				assertEquals(newList, oldList);


		
		
}
	
}
