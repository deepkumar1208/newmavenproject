package com.demo.assignments;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Nellurisuresh {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Deepak.9.kumar\\eclipse-workspace\\DemoQA\\src\\Driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://demoqa.com/automation-practice-form");
		System.out.println("The web site is opened");
		Thread.sleep(1000);
		WebElement fn = driver.findElement(By.xpath("//input[@id='firstName']"));
		fn.sendKeys("Nelluri");
		System.out.println("First name entry is done");
		Thread.sleep(1000);
		WebElement ln = driver.findElement(By.xpath("//input[@id='lastName']"));
		ln.sendKeys("Kumar");
		System.out.println("Last name entry is done");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("nelluri.kumar@gmail.com");
		System.out.println("Email  entry is done");
		Thread.sleep(1000);
		WebElement gender= driver.findElement(By.xpath("//label[contains(text(),'Male')]"));
		gender.click();
		System.out.println("radio button clicked");	
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("9000000000");
		System.out.println("mobile number entry is done");	
		Thread.sleep(1000);
		WebElement sub = driver.findElement(By.cssSelector(".subjects-auto-complete__input"));
		Actions actions = new Actions(driver);
		actions.moveToElement(sub).click().sendKeys("maths").build().perform();
		actions.sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		actions.moveToElement(sub).click().sendKeys("hindi").build().perform();
		actions.sendKeys(Keys.RETURN);
		Thread.sleep(1000);	
		System.out.println("subjects entries are done");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		WebElement sports = driver.findElement(By.xpath("//label[contains(text(),'Sports')]"));
		Actions actions2= new Actions(driver);
		actions2.moveToElement(sports).click().build().perform();
		actions2.sendKeys(Keys.RETURN);
		sports.click();
		Thread.sleep(1000);
		System.out.println("hobbies is clicked");
		
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("andhra");
		Thread.sleep(1000);
		System.out.println("address is entered");
		driver.findElement(By.xpath("//div[@id='state']")).click();
		WebElement state = driver.findElement(By.xpath("//div[@id='state']//div[contains(text(),'NCR')]"));
		state.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='city']")).click();
		WebElement city = driver.findElement(By.xpath("//div[@id='city']//div[contains(text(),'Delhi')]"));
		city.click();
		
		System.out.println("The state and city is clicked");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(2000);
		new Actions(driver).moveByOffset(800, 300).click().perform();
		Thread.sleep(1000);
	}

}


