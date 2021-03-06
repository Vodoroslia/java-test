package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Untitled2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled2() throws Exception {
    driver.get(baseUrl + "/addressbookv4.1.4/");
    driver.findElement(By.linkText("home")).click();
    driver.findElement(By.linkText("add new")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys("First name");
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("Last name");
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys("Address");
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys("Home");
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys("Mobile");
    driver.findElement(By.name("work")).clear();
    driver.findElement(By.name("work")).sendKeys("Work");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("E-mail:");
    driver.findElement(By.name("email2")).clear();
    driver.findElement(By.name("email2")).sendKeys("E-mail2:");
    new Select(driver.findElement(By.name("bday"))).selectByVisibleText("1");
    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("January");
    driver.findElement(By.name("byear")).clear();
    driver.findElement(By.name("byear")).sendKeys("2000");
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys("Address");
    driver.findElement(By.name("phone2")).clear();
    driver.findElement(By.name("phone2")).sendKeys("Home:");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("home page")).click();
    driver.findElement(By.id("id1")).click();
    driver.findElement(By.id("id1")).click();
    driver.findElement(By.cssSelector("img[alt=\"Edit\"]")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
