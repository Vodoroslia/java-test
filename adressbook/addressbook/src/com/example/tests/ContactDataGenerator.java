package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			// TODO Auto-generated method stub
			System.out
					.println("Пожалуйста введите параметры <amount of test data> <file> <format>");
			return;
		}
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		if (file.exists()) {
			System.out
					.println("Файл существует, пожалуйста удалите его вручную "
							+ file);
			return;
		}
		List<ContactData> contacts = generaiteRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Неопознанный формат" + format);
			return;
		}
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts,
			File file) throws IOException {

		XStream xstream = new XStream();
		xstream.alias(("contact"), ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();

	}

	public static List<ContactData> loadContactsFromXmlFile(File file)
			throws IOException {
		XStream xstream = new XStream();
		xstream.alias(("contact"), ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);

	}

	private static void saveContactsToCsvFile(List<ContactData> contacts,
			File file)
	// TODO Auto-generated method stub
			throws IOException {
		// TODO Auto-generated method stub
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstname() + "," + contact.getLastname()
					+ "," + contact.getAddress() + "," + contact.getHome()
					+ "," + contact.getMobile() + "," + contact.getWork() + ","
					+ contact.getEmail() + "," + contact.getEmail2() + ","
					+ contact.getBmonth() + "," + contact.getAddress2() + ","
					+ contact.getPhone2() + ",!" + "\n");
		}
		writer.close();
	}

	public static List<ContactData> loadContactsFromCsvFile(File file)
			throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData().withFirstname(part[0])
					.withLastname(part[1]).withAddress(part[2])
					.withHome(part[3]).withMobile(part[4]).withWork(part[5])
					.withEmail(part[6]).withEmail2(part[7]).withBmonth(part[8])
					.withAddress2(part[9]).withPhone2(part[10]);
			line = bufferedReader.readLine();
			list.add(contact);
		}

		bufferedReader.close();
		return list;
	}

	public static List<ContactData> generaiteRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++) {
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
			list.add(contact);
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
