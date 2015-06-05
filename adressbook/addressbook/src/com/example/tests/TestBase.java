package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	protected ApplicationManager app;
	private String name;

	@BeforeMethod
	public void setUp() throws Exception {

		app = new ApplicationManager();

	}

	@AfterMethod
	public void tearDown() throws Exception {
		app.stop();

	}

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();

		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData().withName(generateRandomString())
					.withHeader(generateRandomString())
					.withFooter(generateRandomString());

			list.add(new Object[] { group });
		}
		return list.iterator();
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();

		for (int i = 0; i < 5; i++) {
			ContactData contact = new ContactData()
					.withFirstname(generateRandomString())
					.withLastname(generateRandomString())
					.withAddress(generateRandomString())
					.withHome(generateRandomString())
					.withMobile(generateRandomString())
					.withWork(generateRandomString())
					.withEmail(generateRandomString())
					.withEmail2(generateRandomString()).withBday("1")
					.withBmonth("January").withByear("2000")
					.withAddress2(generateRandomString())
					.withPhone2(generateRandomString());
			list.add(new Object[] { contact });
		}
		return list.iterator();
	}

	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}

}
