package com.example.tests;

import static com.example.tests.GroupDataGenerator.generaiteRandomGroups;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
public class TestBase {
	protected ApplicationManager app;
	

	@BeforeMethod

	public void setUp() throws Exception {
		String configFile= System.getProperty("configFile","application.properties");
Properties properties=new Properties();
properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);

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
		return wrapGroupsForDataProvider(generaiteRandomGroups(5)).iterator();
	}


	public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group:groups){
			list.add(new Object[]{group});
		}
	
		return list;
	}

	private static String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}

}
