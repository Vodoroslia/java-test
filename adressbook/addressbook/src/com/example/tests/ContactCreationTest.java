package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {
	@Test
	public void nonEmptyContactCreation() throws Exception {
		
		ContactData contact = new ContactData();
		app.getNavigatinHelper().openMainPage();
		app.getNavigatinHelper().openContactPage();
		app.getContactHelper().initNewContactCreation();
	

		contact.firstname = "firstname";
		contact.lastname = "lastname";
		contact.address = "address";
		contact.home = "home";
		contact.mobile = "mobile";
		contact.work = "work";
		contact.email = "email";
		contact.email2 = "email2";
		contact.bday = "1";
		contact.bmonth = "January";
		contact.byear = "2000";
		contact.address2 = "address2";
		contact.phone2 = "phone2";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnContactPage();

	}

	@Test
	public void EmptyContactCreation() throws Exception {
		app.getNavigatinHelper().openMainPage();
		app.getNavigatinHelper().openContactPage();
		app.getContactHelper().initNewContactCreation();
		app.getContactHelper().fillContactForm( new ContactData("", "", "", "", "", "", "", "", "-",
				"-", "-", "", ""));
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnContactPage();

	}
	
	
	
	

}
