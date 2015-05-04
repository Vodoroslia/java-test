package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTest extends TestBase {

@Test
	public void deleteSomeContact() {
	app.getNavigatinHelper().openMainPage();
	app.getNavigatinHelper().openContactPage();
	app.getContactHelper().deleteContact(1);
	app.getContactHelper().returnContactPage();
	
}
}
