package com.demo.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Aman_Kumar {

	WebDriver driver;

	@BeforeClass
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		String Url = "https://demoqa.com/automation-practice-form";
		driver.get(Url);
		driver.getCurrentUrl();
		System.out.println("current url is: " + Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
	}

	@Test(priority = 1, description = "Select State")
	public void State() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		WebElement State = driver.findElement(
				By.xpath("//div[@class=' css-yk16xz-control']//div[@class=' css-tlfecz-indicatorContainer']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(State).click().sendKeys("NCR").build().perform();
		actions.sendKeys(Keys.RETURN).build().perform();

		Thread.sleep(3000);

	}

	@Test(priority = 2, description = "Select City")
	public void City() throws Exception {
		WebElement City = driver
				.findElement(By.xpath("//div[@id='city']//div[@class=' css-tlfecz-indicatorContainer']"));

		Actions actions = new Actions(driver);
		actions.moveToElement(City).click().sendKeys("Noida").build().perform();
		actions.sendKeys(Keys.RETURN).build().perform();
		Thread.sleep(3000);
	}

	@Test(priority = 4, description = "Filling the first name, last name and Email-id")
	public void Text_Field() throws Exception {

		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Aman");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Kumar");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("Singhalaman0123@gmail.com");
		driver.findElement(By.xpath("//textarea[@id='currentAddress']"))
				.sendKeys("ITS Engineering College,Greater Noida,201310");
		Thread.sleep(2000);
	}

	@Test(priority = 5, description = "Verify the Radio button")
	public void Radio_btn() throws Exception {
		WebElement Male = driver.findElement(By.cssSelector("[for='gender-radio-1']"));
		WebElement Female = driver.findElement(By.cssSelector("[for='gender-radio-2']"));
		WebElement Others = driver.findElement(By.cssSelector("[for='gender-radio-3']"));
		Male.click();
		Thread.sleep(1000);
		Female.click();
		Thread.sleep(1000);
		Others.click();
		Male.click();

	}

	@Test(priority = 8, description = "Enter Phone Number")
	public void Phone_no() throws Exception {
		WebElement Ph_no = driver.findElement(By.xpath("//input[@id='userNumber']"));
		Ph_no.sendKeys("1234567899");
		Thread.sleep(2000);

	}

	@Test(priority = 9, description = "Select date of Birth")
	public void Date_of_Birth() throws Exception {
		driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
		Thread.sleep(2000);
		WebElement Month = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		Select select = new Select(Month);
		select.selectByVisibleText("August");

		WebElement Year = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Select select1 = new Select(Year);
		select1.selectByVisibleText("1998");
		driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--005']")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 6, description = "Enter Subjects")
	public void Subjects() throws Exception {

		WebElement sub = driver.findElement(By.cssSelector(".subjects-auto-complete__value-container"));
		Actions actions = new Actions(driver);
		actions.moveToElement(sub).click().sendKeys("Maths").build().perform();
		actions.sendKeys(Keys.RETURN);
		Thread.sleep(3000);
		actions.moveToElement(sub).click().sendKeys("English").build().perform();
		actions.sendKeys(Keys.RETURN);
		Thread.sleep(3000);
		actions.moveToElement(sub).click().sendKeys("Hindi").build().perform();
		actions.sendKeys(Keys.RETURN);
		Thread.sleep(2000);

//		removing subjects...
		WebElement remove_Sub = driver.findElement(By.cssSelector(".subjects-auto-complete__indicator > .css-19bqh2r"));

		Actions actions1 = new Actions(driver);
		actions1.moveToElement(remove_Sub).click().build().perform();
		Thread.sleep(3000);
//		Adding subjects again
		actions.moveToElement(sub).click().sendKeys("Physics").build().perform();
		actions.sendKeys(Keys.RETURN);
		Thread.sleep(3000);
		actions.moveToElement(sub).click().sendKeys("Chemistry").build().perform();
		actions.sendKeys(Keys.RETURN);
		Thread.sleep(3000);
	}
//	
//	

	@Test(priority = 3, description = "Select Hobbies")
	public void Hobbies() throws Exception {
		WebElement sports = driver.findElement(By.xpath("//label[.='Sports']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(sports).click().build().perform();
		actions.sendKeys(Keys.RETURN);
	}

	@Test(priority = 7, description = "Choose File to upload")
	public void Choose_file() throws Exception {
		WebElement choose_file = driver.findElement(By.cssSelector("#uploadPicture"));

//		path of the file to be selected......
		choose_file.sendKeys("C:\\Users\\Deepak.9.kumar\\eclipse-workspace\\DemoQA\\src\\Driver\\aman.png");
		Thread.sleep(2000);
	}

	@Test(priority = 10, description = "Submit Button")
	public void Submit() throws Exception {
		WebElement btn = driver.findElement(By.xpath("//button[@id='submit']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(btn).click().build().perform();
		Thread.sleep(2000);
	}

	//@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
