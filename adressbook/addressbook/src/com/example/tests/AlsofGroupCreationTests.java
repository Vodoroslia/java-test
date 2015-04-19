package com.example.tests;

import org.testng.annotations.Test;

public class AlsofGroupCreationTests extends TestBase {
	@Test
	public void nonEmptyContactCreation() throws Exception {
		openMainPage();
		openContactPage();
		initNewContactCreation();
		ContactData contact = new ContactData();

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
		fillContactForm(contact);
		submitContactCreation();
		returnContactPage();

	}

	@Test
	public void EmptyContactCreation() throws Exception {
		openMainPage();
		openContactPage();
		initNewContactCreation();
		fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-",
				"-", "-", "", ""));
		submitContactCreation();
		returnContactPage();

	}
	
	
	
	

}
