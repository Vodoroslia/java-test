package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;


public class GroupHelper extends HelperBase{

	public GroupHelper(ApplicationManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}
	
	private SortedListOf<GroupData> cachedGroups;
	
	public SortedListOf<GroupData> getGroups() {	
	if (cachedGroups==null) {
	rebuildCache();	
	}
	return cachedGroups;
		
	}
	

	private void rebuildCache() {
		cachedGroups = new SortedListOf <GroupData> () ;
		manager.navigateTo().GroupPage();
		List<WebElement> checkboxes= driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes)  {
		String title =checkbox.getAttribute("title");
		String name = title.substring("Select (".length(),title.length() - ")".length());
		cachedGroups.add(new  GroupData().withName(name));
		}

	}


	public GroupHelper createGroup(GroupData group) {
		// TODO Auto-generated method stub
		manager.navigateTo().GroupPage();
		initNewGroupCreation();
		fillGroupForm(group);
		submitGroupCreation();	
		manager.navigateTo().GroupPage();
		rebuildCache();	
		return this;
	}
	
	public GroupHelper modifyGroup(int index, GroupData group) {
		// TODO Auto-generated method stub
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
		manager.navigateTo().GroupPage();
		rebuildCache();	
		return this;	
	}
	
	public GroupHelper deleteGroup(int index) {
		// TODO Auto-generated method stub
		selectGroupByIndex(index);
		submitGroupDeletion();
		manager.navigateTo().GroupPage();
		rebuildCache();	
		return this;
	}
	

	//----------------------------------
	public GroupHelper submitGroupCreation() {
		// submitGroupCreation
		click(By.name("submit"));
		cachedGroups=null;
		return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
		// fillGroupForm
		type(By.name("group_name"), group.getName());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;
	}

	public GroupHelper initNewGroupCreation() {
		// initNewgroupCreation
		manager.navigateTo().GroupPage();
		click(By.name("new"));
		return this;
	}

	
	private GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]']["+(index+1)+"]"));
		return this;
	}

	public GroupHelper initGroupModification(int index) {
		// TODO Auto-generated method stub
		
		selectGroupByIndex(index);	
		click(By.name("edit"));
		return this;
		
	}

	public GroupHelper submitGroupModification() {
		// TODO Auto-generated method stub
		click(By.name("update"));
		cachedGroups=null;
		return this;
	}



	private void submitGroupDeletion() {
		click(By.name("delete"));
		cachedGroups=null;
	}
	

}
