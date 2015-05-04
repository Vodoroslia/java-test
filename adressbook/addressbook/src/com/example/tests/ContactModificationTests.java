package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

	
	
	@Test 
	public void modifySomeContact() {
		app.getNavigatinHelper().openMainPage();
		app.getNavigatinHelper().openContactPage();
		app.getContactHelper().initContactModification(1);
		ContactData contact= new ContactData ();
		contact.firstname="new firstname";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();



		
		
}
	
}
