package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.tests.GroupData;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	public void returnContactPage() {
		click(By.linkText("home page"));
	}

	public void submitContactCreation() {
		// submit contact creation
		click(By.name("submit"));
		
	}

	public void fillContactForm(ContactData contact) {
		// fill contact form
		
		type(By.name("firstname"), contact.firstname);
		type(By.name("lastname"), contact.lastname);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.home);
		type(By.name("mobile"), contact.mobile);
		type(By.name("work"), contact.work);
		type(By.name("email"), contact.email);
		type(By.name("email2"), contact.email2);
		if (contact.bday !=null ){
		selectByText(By.name("bday"), contact.bday);}
		if (contact.bday !=null ){
		selectByText(By.name("bmonth"), contact.bmonth);}
		type(By.name("byear"), contact.byear);
		type(By.name("address2"), contact.address2);
		type(By.name("phone2"), contact.phone2);
	}

	

	public void initNewContactCreation() {
		// init new contact creation
		click(By.linkText("add new"));
	}

	public void deleteContact(int index) {
		// TODO Auto-generated method stub	
		selectContactByIndex(index);
		click(By.xpath("//*[@id='maintable']//img[@title='Edit']"));
		click(By.xpath("//input[@value='Delete']"));
	}

	private void selectContactByIndex(int index) {
		click(By.xpath("//input[@name='selected[]']["+index+"]"));
	}

	public void initContactModification(int index) {
		// TODO Auto-generated method stub
		selectContactByIndex(index);	
		click(By.xpath("//*[@id='maintable']//img[@title='Edit']"));
	}




	public void submitContactModification() {
		// TODO Auto-generated method stub
		click(By.xpath("//input[@value='Update']"));
	}

	public List<ContactData> getContacts() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				List <ContactData> contacts = new ArrayList <ContactData> () ;
				List<WebElement> checkboxes= driver.findElements(By.name("selected[]"));
				for (WebElement checkbox : checkboxes)  {
				ContactData contact = new ContactData();
				String title =checkbox.getAttribute("title");
				contact.firstname = title.substring("Select (".length(),title.length() - ")".length());
				contacts.add(contact);
				}
				return contacts;
	
	}
}
