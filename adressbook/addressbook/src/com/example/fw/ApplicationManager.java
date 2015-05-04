package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {

	public  WebDriver driver;
	public  String baseUrl;
	private  StringBuffer verificationErrors = new StringBuffer();
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	
    public ApplicationManager() {
		driver = new FirefoxDriver();
		// на моей машине wampserver настроен на baseUrl =
		// "http://localhost:8080/";
		baseUrl = "http://localhost:8080";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	
	
		
    }

	public void stop() {
		// TODO Auto-generated method stub
		driver.quit();
		

	}
	
	public NavigationHelper getNavigatinHelper() {
	
		if (navigationHelper == null){
			
			navigationHelper= new NavigationHelper(this);
		}
		
		return navigationHelper;
}
	
	public GroupHelper getGroupHelper() {
		
		if (groupHelper==null){
			
			groupHelper=new GroupHelper(this);
		}
		
		return groupHelper;
}

	
	
	public ContactHelper getContactHelper() {
		
		if (contactHelper== null){
			
			contactHelper= new ContactHelper(this);
		}
		
		return contactHelper;
}
	
	
}


