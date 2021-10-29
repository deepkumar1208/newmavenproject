package com.demo.assignments;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationForm_sateesh {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Deepak.9.kumar\\eclipse-workspace\\DemoQA\\src\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://demoqa.com/automation-practice-form");
		System.out.println("The web site is opened");
		Thread.sleep(1000);
		WebElement fn = driver.findElement(By.cssSelector("SateeshKumar"));
		fn.sendKeys("hi");
		System.out.println("First name is entered");
		Thread.sleep(1000);
		WebElement ln = driver.findElement(By.cssSelector("Majjari"));
		ln.sendKeys("hello");
		System.out.println("Last name is entered");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("123@coforgetech.com");
		System.out.println("Email is entered");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
		System.out.println("radio button clicked");	
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("1234567890");
		System.out.println("mobile number is entered");	
		Thread.sleep(1000);
		driver.findElement(By.id("dateOfBirthInput")).click();
		selectDate(driver, "20/March/1995");
		Thread.sleep(1000);
		WebElement sub = driver.findElement(By.cssSelector(".subjects-auto-complete__value-container"));
		Actions actions = new Actions(driver);
		actions.moveToElement(sub).click().sendKeys("JAVA").build().perform();
		actions.sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		actions.moveToElement(sub).click().sendKeys("PYTHON").build().perform();
		actions.sendKeys(Keys.RETURN);
		Thread.sleep(1000);	
		System.out.println("subjects are entered");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		WebElement sports = driver.findElement(By.xpath("//label[contains(text(),'Sports')]"));
		Actions actions2= new Actions(driver);
		actions2.moveToElement(sports).click().build().perform();
		actions2.sendKeys(Keys.RETURN);
		sports.click();
		Thread.sleep(1000);
		System.out.println("hobbies is clicked");
		
		WebElement upload=driver.findElement(By.xpath("//input[@id='uploadPicture']"));
		upload.sendKeys("C:\\Users\\Deepak.9.kumar\\eclipse-workspace\\DemoQA\\src\\Driver\\aman.png");
		Thread.sleep(1000);
		System.out.println("Resume is upload");
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("hi");
		Thread.sleep(1000);
		System.out.println("address is entered");
		driver.findElement(By.xpath("//div[@id='state']")).click();
		WebElement state = driver.findElement(By.xpath("//div[@id='state']//div[contains(text(),'NCR')]"));
		state.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='city']")).click();
		WebElement city = driver.findElement(By.xpath("//div[@id='city']//div[contains(text(),'DELHI')]"));
		city.click();
		
		System.out.println("The state and city is clicked");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		Thread.sleep(2000);
		new Actions(driver).moveByOffset(800, 300).click().perform();
		Thread.sleep(1000);
	}
	public static void selectDate(WebDriver driver, String date) throws Exception {
		Calendar calendar = Calendar.getInstance();
		try {
			SimpleDateFormat targetDateFormat = new SimpleDateFormat("dd/MMM/yyyy");
			targetDateFormat.setLenient(false);
			java.util.Date formattedTargetDate = targetDateFormat.parse(date);
			calendar.setTime(formattedTargetDate);
		} catch (Exception e) {
			throw new Exception("Invalid date is provided, please check the input date!!");
		}

		int targetMonth = calendar.get(Calendar.MONTH);
		int targetYear = calendar.get(Calendar.YEAR);
		int targetDay = calendar.get(Calendar.DAY_OF_MONTH);

		String currentDate = driver.findElement(By.xpath("//div[(contains(@class,'react-datepicker__current-month--hasMonthDropdown'))]")).getText();
		calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentDate));
		int currentMonth = calendar.get(Calendar.MONTH);
		int currentYear = calendar.get(Calendar.YEAR);

		

		while(currentMonth < targetMonth || currentYear < targetYear) {
			driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--next']")).click();
			currentDate = driver.findElement(By.xpath("//div[(contains(@class,'react-datepicker__current-month--hasMonthDropdown'))]")).getText();
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentDate));
			currentMonth = calendar.get(Calendar.MONTH);
			currentYear = calendar.get(Calendar.YEAR);

		}

		while(currentMonth > targetMonth || currentYear > targetYear) {
			driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
			currentDate = driver.findElement(By.xpath("//div[(contains(@class,'react-datepicker__current-month--hasMonthDropdown'))]")).getText();
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentDate));
			currentMonth = calendar.get(Calendar.MONTH);
			currentYear = calendar.get(Calendar.YEAR);

		}

		if(currentMonth == targetMonth && currentYear == targetYear) {
			
			driver.findElement(By.xpath("//div[@class='react-datepicker-popper']//div[not(contains(@class,'react-datepicker__day--outside-month'))]/div[text()="+targetDay+"]")).click();
		     System.out.println("The required date is clicked");
		}
		else
			throw new Exception("unable to select the date because of current and target dates mismatch");
	}

}
