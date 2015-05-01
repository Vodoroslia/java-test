package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	public void gotoGroupPage() {
		// gotoGroupPage
		click(By.linkText("groups"));
		
	}

	public void openMainPage() {
		// open main page
		driver.get(manager.baseUrl + "/addressbookv4.1.4/");
	}

	public void openContactPage() {
		// open contact page
		click(By.linkText("home"));
	
	}


}
