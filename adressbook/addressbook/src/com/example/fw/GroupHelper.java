package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

import com.example.tests.GroupData;


public class GroupHelper extends HelperBase{

	public GroupHelper(ApplicationManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	public void submitGroupCreation() {
		// submitGroupCreation
		click(By.name("submit"));
	}

	public void fillGroupForm(GroupData group) {
		// fillGroupForm
		type(By.name("group_name"), group.name);
		type(By.name("group_header"), group.header);
		type(By.name("group_footer"), group.footer);
	
	}

	public void initNewGroupCreation() {
		// initNewgroupCreation
		
		click(By.name("new"));
	}

	public void deleteGroup(int index) {
		// TODO Auto-generated method stub
		
		selectGroupByIndex(index);
		click(By.name("delete"));
		
		
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]']["+(index+1)+"]"));
	}

	public void initGroupModification(int index) {
		// TODO Auto-generated method stub
		
		selectGroupByIndex(index);	
		click(By.name("edit"));
		
	}

	public void submitGroupModification() {
		// TODO Auto-generated method stub
		click(By.name("update"));
	}

	public List<GroupData> getGroups() {
		// TODO Auto-generated method stub
		List <GroupData> groups = new ArrayList <GroupData> () ;
		List<WebElement> checkboxes= driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes)  {
		GroupData group = new GroupData();
		String title =checkbox.getAttribute("title");
		group.name = title.substring("Select (".length(),title.length() - ")".length());
		groups.add(group);
		}
		return groups;
	}

}
