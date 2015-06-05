package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {


	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts()  {	
	if (cachedContacts==null) {
	rebuildCache();	
	}
	return cachedContacts;
		
	}
	

	private void rebuildCache() {
		cachedContacts = new SortedListOf<ContactData> () ;
		manager.navigateTo().MainPage();
		List<WebElement> rows = getContactRows();
		for (WebElement row : rows) {
			String firstname = (row.findElement(By.xpath(".//td[2]")).getText());
			ContactData contact = new ContactData().withFirstname(firstname);
			cachedContacts.add(contact);
		}

	

	}
	
	

	public ContactHelper  createContact(ContactData contact) {
		initNewContactCreation();
		fillContactForm(contact);
		submitContactCreation();
		manager.navigateTo().openContactPage();
		rebuildCache();	
		return this;
	}
	public ContactHelper deleteContact(int index) {
		initContactModification(index);
		submitContactDeletion();
		manager.navigateTo().openContactPage();
		rebuildCache();
		return this;
	}
	
	
	public ContactHelper modifyContact(int index, ContactData contact) {
		// TODO Auto-generated method stub
		initContactModification(index);
		fillContactForm(contact);
	submitContactModification();
		return this;
	}
//---------------------------------------------


	public ContactHelper submitContactCreation() {
		// submit contact creation
		click(By.name("submit"));
		cachedContacts=null;
		return this;

	}

	public void fillContactForm(ContactData contact) {
		// fill contact form

		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getHome());
		type(By.name("mobile"), contact.getMobile());
		type(By.name("work"), contact.getWork());
		type(By.name("email"), contact.getEmail());
		type(By.name("email2"), contact.getEmail2());
		selectByText(By.name("bday"), contact.getBday());
		selectByText(By.name("bmonth"), contact.getBmonth());
		type(By.name("byear"), contact.getByear());
		type(By.name("address2"), contact.getAddress2());
		type(By.name("phone2"), contact.getPhone2());
	}

	public ContactHelper initNewContactCreation() {
		// init new contact creation
		manager.navigateTo().MainPage();
		click(By.linkText("add new"));
		return this;
	}

	

	private void selectContactByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index + 1) + "]"));

	}

	public ContactHelper initContactModification(int index) {
		// TODO Auto-generated method stub

		click(By.xpath("(//img[@alt='Edit'])[" + (index + 1) + "]"));
	
		return this;
	}

	public ContactHelper submitContactModification() {
		// TODO Auto-generated method stub
		click(By.xpath("//input[@value='Update']"));
		cachedContacts=null;
		return this;
	}

	private void submitContactDeletion() {
		click(By.xpath("//input[@value='Delete']"));
		cachedContacts=null;
	}

	private List<WebElement> getContactRows() {
		return driver.findElements(By.xpath("//tr[@name='entry']"));
	}
	

}
