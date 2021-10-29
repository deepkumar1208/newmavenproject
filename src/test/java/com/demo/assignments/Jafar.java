package com.demo.assignments;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Sleeper;

public class Jafar {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Deepak.9.kumar\\eclipse-workspace\\DemoQA\\src\\Driver\\chromedriver.exe");
	      ChromeDriver d= new ChromeDriver();
	      d.get("https://demoqa.com/automation-practice-form");
	     d.manage().window().maximize();
	    // JavascriptExecutor js=(JavascriptExecutor)d;
	    d.findElement(By.id("firstName")).sendKeys("JAFAR");
	    d.findElement(By.id("lastName")).sendKeys("HUSSAIN");
	    d.findElement(By.id("userEmail")).sendKeys("jafarhussain@coforge.com");
	   
	  //  d.findElement(By.id("dateOfBirthInput")).sendKeys("28 Mar 1994");
	    d.findElement(By.xpath(".//input[@placeholder='Mobile Number']")).sendKeys("1234556789");
	    WebElement element = d.findElement(By.xpath(".//label[contains(text(),'Male')]"));
	    d.findElement(By.xpath("//label[contains(text(),'Sports')]")).click();
	    d.findElement(By.id("dateOfBirthInput")).click();
		selectDate(d, "28/March/1994");
	    element.click();
	    WebElement sub = d.findElement(By.cssSelector(".subjects-auto-complete__value-container"));
		Actions actions = new Actions(d);
		actions.moveToElement(sub).click().sendKeys("Maths").build().perform();
		actions.sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		actions.moveToElement(sub).click().sendKeys("Hindi").build().perform();
		actions.sendKeys(Keys.RETURN);
		d.findElement(By.cssSelector("input#uploadPicture")).sendKeys("C:\\Users\\Deepak.9.kumar\\eclipse-workspace\\DemoQA\\src\\Driver\\aman.png");
		System.out.println("File is uploaded Successfully");
		d.findElement(By.cssSelector("#currentAddress")).sendKeys("MP");
		System.out.println("Current address added");
		
		d.findElement(By.xpath("//div[@id='state']")).click();
		WebElement state = d.findElement(By.xpath("//div[@id='state']//div[contains(text(),'NCR')]"));
		state.click();
		Thread.sleep(1000);
		d.findElement(By.xpath("//div[@id='city']")).click();
		WebElement city = d.findElement(By.xpath("//div[@id='city']//div[contains(text(),'Delhi')]"));
		city.click();
		d.findElement(By.xpath("//button[@id='submit']")).click();
		
	  //  WebElement element = d.findElement(By.xpath(".//input[@value='Male']"));
	    //js.executeScript("window.scrollBy(300)");
	  
	 //   d.findElement(By.className("form-control react-datepicker-ignore-onclickoutside")).sendKeys("28-03-1994");
	    // d.findElement(By.cssSelector("//input[@id='userNumber']")).sendKeys("9424518611");
	   
	   
	    
	  //  d.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys("9424518611");
	    

	}

	public static void selectDate(ChromeDriver d, String date) throws Exception {
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

		String currentDate = d.findElement(By.xpath("//div[(contains(@class,'react-datepicker__current-month--hasMonthDropdown'))]")).getText();
		calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentDate));
		int currentMonth = calendar.get(Calendar.MONTH);
		int currentYear = calendar.get(Calendar.YEAR);

		

		while(currentMonth < targetMonth || currentYear < targetYear) {
			d.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--next']")).click();
			currentDate = d.findElement(By.xpath("//div[(contains(@class,'react-datepicker__current-month--hasMonthDropdown'))]")).getText();
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentDate));
			currentMonth = calendar.get(Calendar.MONTH);
			currentYear = calendar.get(Calendar.YEAR);

		}

		while(currentMonth > targetMonth || currentYear > targetYear) {
			d.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
			currentDate = d.findElement(By.xpath("//div[(contains(@class,'react-datepicker__current-month--hasMonthDropdown'))]")).getText();
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentDate));
			currentMonth = calendar.get(Calendar.MONTH);
			currentYear = calendar.get(Calendar.YEAR);

		}

		if(currentMonth == targetMonth && currentYear == targetYear) {
			
			d.findElement(By.xpath("//div[@class='react-datepicker-popper']//div[not(contains(@class,'react-datepicker__day--outside-month'))]/div[text()="+targetDay+"]")).click();
		     System.out.println("The required date is clicked");
		}
		else
			throw new Exception("unable to select the date because of current and target dates mismatch");
	}

}
