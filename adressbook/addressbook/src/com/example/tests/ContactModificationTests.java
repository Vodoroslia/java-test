package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

	
	
	@Test (dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) {
		app.getNavigatinHelper().openMainPage();
		app.getNavigatinHelper().openContactPage();
		
		// save old state сохранить старый список
		List<ContactData> oldList = app.getContactHelper().getContacts();
		Random rnd= new Random();
		int index =rnd.nextInt(oldList.size()-1);
		
		app.getContactHelper().initContactModification(index);
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getNavigatinHelper().openContactPage();
		// save new state сохранить новый список
		List<ContactData> newList = app.getContactHelper().getContacts();
			// compare state сравнение длины списков
				// assertEquals(newList.size(), oldList.size() - 1);
				oldList.remove(index);
				oldList.add(contact);
				Collections.sort(oldList);
				Collections.sort(newList);
				assertEquals(newList, oldList);


		
		
}
	
}
