package com.demo.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class hsbcAssignmentRahul {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Deepak.9.kumar\\eclipse-workspace\\DemoQA\\src\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
		Thread.sleep(2000);
		driver.findElement(By.id("firstName")).sendKeys("Rahul");
		Thread.sleep(2000);
		driver.findElement(By.id("lastName")).sendKeys("Bolla");
		Thread.sleep(2000);
		driver.findElement(By.id("userEmail")).sendKeys("bollarahul@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#userNumber")).sendKeys("9177581543");
		Thread.sleep(2000);
		WebElement subject = driver.findElement(By.cssSelector(".subjects-auto-complete__value-container"));
		Actions action = new Actions(driver);
		action.moveToElement(subject).click().sendKeys("English").build().perform();
		action.sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		action.moveToElement(subject).click().sendKeys("Physics").build().perform();
		action.sendKeys(Keys.RETURN);
		Thread.sleep(2000);	
		action.moveToElement(subject).click().sendKeys("Computer Science").build().perform();
		action.sendKeys(Keys.RETURN);
		Thread.sleep(2000);			
		JavascriptExecutor jse = (JavascriptExecutor) driver;
	    jse.executeScript("window.scrollBy(0,400);");
		WebElement hobbies = driver.findElement(By.xpath("//label[contains(text(),'Sports')]"));
		Actions action1= new Actions(driver);
		action1.moveToElement(hobbies).click().build().perform();
		action1.sendKeys(Keys.RETURN);
		hobbies.click();
		Thread.sleep(2000);
		
		WebElement selectpicture = driver.findElement(By.id("uploadPicture"));
		selectpicture.sendKeys("C:\\Users\\Deepak.9.kumar\\eclipse-workspace\\DemoQA\\src\\Driver\\aman.png");
		Thread.sleep(2000);
		driver.findElement(By.id("currentAddress")).sendKeys("Hyderabad");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='state']")).click();
		WebElement state = driver.findElement(By.xpath("//div[@id='state']//div[contains(text(),'NCR')]"));
		state.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='city']")).click();
		WebElement city = driver.findElement(By.xpath("//div[@id='city']//div[contains(text(),'Delhi')]"));
		city.click();
		
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		Thread.sleep(2000);
		
	}
}
