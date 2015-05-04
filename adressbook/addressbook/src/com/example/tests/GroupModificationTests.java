package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	
@Test
	
	public void modifySomeGroup() {
		app.getNavigatinHelper().openMainPage();
		app.getNavigatinHelper().gotoGroupPage();
		app.getGroupHelper().initGroupModification(1);
		GroupData group= new GroupData();
		group.name="new name";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getNavigatinHelper().gotoGroupPage();	

}
}
