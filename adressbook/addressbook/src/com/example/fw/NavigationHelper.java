package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	public void GroupPage() {
		// gotoGroupPage
		if(!onGrouspPage()){
			click(By.linkText("groups"));		
		}
	}



	private boolean onGrouspPage() {
		if(driver.getCurrentUrl().contains("/groups.php")
			&& driver.findElements(By.name("new")).size()>0) {
			return true;	
			} else {
		
		return false;
	}
	}
	

	public void MainPage() {
		// open main page
		if(! onMainPage()){
		
		click(By.linkText("home"));
		}
	}

	private boolean onMainPage() {
		// TODO Auto-generated method stub
		return driver.findElements(By.id("maintable")).size()>0;
	}

	public void openContactPage() {
		// open contact page
		click(By.linkText("home page"));
	
	}

}
