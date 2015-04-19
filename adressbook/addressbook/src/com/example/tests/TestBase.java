package com.example.tests;



import org.testng.AssertJUnit;

import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

	private static WebDriver driver;
	private static String baseUrl;
	private static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();

	

	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		// �� ���� ������ wampserver �������� �� baseUrl = "http://localhost:8080/";

		baseUrl = "http://localhost:8080/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	protected void submitGroupCreation() {
		// submitGroupCreation
		driver.findElement(By.name("submit")).click();
	}

	protected void fillGroupForm(GroupData parameterObject) {
		// fillGroupForm
		driver.findElement(By.name("group_name")).clear();
		driver.findElement(By.name("group_name"))
				.sendKeys(parameterObject.name);
		driver.findElement(By.name("group_header")).clear();
		driver.findElement(By.name("group_header")).sendKeys(
				parameterObject.header);
		driver.findElement(By.name("group_footer")).clear();
		driver.findElement(By.name("group_footer")).sendKeys(
				parameterObject.footer);
	}

	protected void initNewGroupCreation() {
		// initNewgroupCreation
		driver.findElement(By.name("new")).click();
	}

	protected void gotoGroupPage() {
		// gotoGroupPage
		driver.findElement(By.linkText("groups")).click();
	}

	

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			AssertJUnit.fail(verificationErrorString);
		}
	}

	
	protected void returnContactPage() {
		driver.findElement(By.linkText("home page")).click();
	}

	protected void submitContactCreation() {
		// submit contact creation
		driver.findElement(By.name("submit")).click();
	}

	protected void fillContactForm(ContactData contact) {
		// fill contact form
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys(contact.firstname);
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys(contact.lastname);
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys(contact.address);
		driver.findElement(By.name("home")).clear();
		driver.findElement(By.name("home")).sendKeys(contact.home);
		driver.findElement(By.name("mobile")).clear();
		driver.findElement(By.name("mobile")).sendKeys(contact.mobile);
		driver.findElement(By.name("work")).clear();
		driver.findElement(By.name("work")).sendKeys(contact.work);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(contact.email);
		driver.findElement(By.name("email2")).clear();
		driver.findElement(By.name("email2")).sendKeys(contact.email2);
		new Select(driver.findElement(By.name("bday")))
				.selectByVisibleText(contact.bday);
		new Select(driver.findElement(By.name("bmonth")))
				.selectByVisibleText(contact.bmonth);
		driver.findElement(By.name("byear")).clear();
		driver.findElement(By.name("byear")).sendKeys(contact.byear);
		driver.findElement(By.name("address2")).clear();
		driver.findElement(By.name("address2")).sendKeys(contact.address2);
		driver.findElement(By.name("phone2")).clear();
		driver.findElement(By.name("phone2")).sendKeys(contact.phone2);
	}

	protected void initNewContactCreation() {
		// init new contact creation
		driver.findElement(By.linkText("add new")).click();
	}

	protected void openContactPage() {
		// open contact page
		driver.findElement(By.linkText("home")).click();
	}

	protected void openMainPage() {
		// open main page
		driver.get(baseUrl + "/addressbookv4.1.4/");
	}

}
