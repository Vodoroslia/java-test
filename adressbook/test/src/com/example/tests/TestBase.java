package com.example.tests;
import static org.junit.Assert.fail;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;

public class TestBase {

	public static String firstWindow;
	public static String secondWindow;
	protected WebDriver driver;
	protected StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	protected WebElement clickAvtoTesting() {
		// open perf avto testing
		WebElement tagAvt = driver.findElement(By
				.linkText("Автоматизация тестирования"));
		return tagAvt;
	}

	protected void moveToPerfTesting(Actions builder) {
		// select perf testing
		WebElement tagTest = driver.findElement(By.linkText("Тестирование"));
		builder.moveToElement(tagTest).perform();
	}

	protected void clickPerfUslugi(Actions builder) {
		// select perf uslugi
		WebElement tagUslugi = driver.findElement(By.linkText("Услуги"));
		builder.moveToElement(tagUslugi).click().perform();
	}

	protected Actions gotoPerfWindow() {
		// select perf window
		driver.close();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			// In case title change with new window name new title name can be
			// known with below statement
			System.out.println("Title of the page after - switchingTo: "
					+ driver.getTitle());
		}
		Actions builder = new Actions(driver);
		return builder;
	}

	protected void clickPerfPage() {
		// click perf page
		driver.findElement(
				By.partialLinkText("Перфоманс Лаб — тестирование и обеспечение"))
				.click();
	}

	protected void clickSearchOnGoogle() {
		// click search on button google
		driver.findElement(By.name("btnG")).click();
	}

	protected void inputTextOnGoogle() {
		// input parameters on google
		driver.findElement(By.id("lst-ib")).clear();
		String text = "перфоманс лаб";
		driver.findElement(By.id("lst-ib")).sendKeys(text);
	}

	protected void openGoogle() {
		// open search page google
		driver.get("https://www.google.ru/");
	}

	protected void clickSearhOnYandex() {
		// click search button on yandex
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	protected void inputTextOnYandex() {
		// input parameters on yandex
		driver.findElement(By.id("text")).clear();
		String text = "перфоманс лаб";
		driver.findElement(By.id("text")).sendKeys(text);
	}

	protected void openYandex() {
		// open search page yandex
		driver.get("https://www.yandex.ru");
	}

	protected void clickSearchOnRambler() {
		// clickSearchOnRambler
		driver.findElement(By.name("btnG")).click();
	}

	protected void inputTextOnRambler() {
		// inputTextOnRambler
		driver.findElement(By.id("search_query")).clear();
		driver.findElement(By.id("search_query")).sendKeys("перфоманс лаб");
	}

	protected void openRambler() {
		// openRambler
		driver.get("http://www.rambler.ru/");
	}

	protected void quitPages() {

		driver.quit();
	}

	protected void testPerfPage() {
		// go to perf page
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			// In case title change with new window name new title name can be
			// known with below statement
			System.out.println("Title of the page - " + driver.getTitle());
		}
		Actions builder = new Actions(driver);
		// go to uslugi link
		WebElement tagUslugi = driver.findElement(By.linkText("Услуги"));
		builder.moveToElement(tagUslugi).click().perform();
		// go to testing link
		WebElement tagTest = driver.findElement(By.linkText("Тестирование"));
		builder.moveToElement(tagTest).perform();
		// go to auto testing link
		WebElement tagAvt = driver.findElement(By
				.linkText("Автоматизация тестирования"));
		builder.moveToElement(tagAvt).click().perform();
	}

	protected void savePage(String filename) throws FileNotFoundException {
		String path = "//div[@class='content-holder']";

		String Text = driver.findElement(By.xpath(path)).getText();

		// вставить проверку на наличие файла

		PrintWriter out = new PrintWriter(filename);
		out.print(Text);
		out.close();
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
