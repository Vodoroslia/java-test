package com.example.fw;

import org.openqa.selenium.By;

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
		click(By.xpath("//input[@name='selected[]']["+index+"]"));
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

}
