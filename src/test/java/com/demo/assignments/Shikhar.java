package com.demo.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Shikhar 
{
	public static void main(String[] args) throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Deepak.9.kumar\\eclipse-workspace\\DemoQA\\src\\Driver\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demoqa.com/automation-practice-form");
	driver.findElement(By.id("firstName")).sendKeys("Shikhar");
	driver.findElement(By.id("lastName")).sendKeys("Dubey");
	driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("shikhar7@gmail.com");
	driver.findElement(By.className("custom-control-label")).click();
	driver.findElement(By.id("userNumber")).sendKeys("7787686478");
	Thread.sleep(1000);
	WebElement sub = driver.findElement(By.cssSelector(".subjects-auto-complete__value-container"));
	Actions actions = new Actions(driver);
	actions.moveToElement(sub).click().sendKeys("Physics").build().perform();
	actions.sendKeys(Keys.RETURN);
	Thread.sleep(1000);
	actions.moveToElement(sub).click().sendKeys("Maths").build().perform();
	actions.sendKeys(Keys.RETURN);
	Thread.sleep(1000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	WebElement sports = driver.findElement(By.xpath("//label[contains(text(),'Sports')]"));
	Actions actions2= new Actions(driver);
	actions2.moveToElement(sports).click().build().perform();
	actions2.sendKeys(Keys.RETURN);
	sports.click();
	Thread.sleep(1000);
	WebElement upload=driver.findElement(By.xpath("//input[@id='uploadPicture']"));
	upload.sendKeys("C:\\Users\\Deepak.9.kumar\\eclipse-workspace\\DemoQA\\src\\Driver\\aman.png");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("306,ASHOK VIHAR");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@id='state']")).click();
	WebElement state = driver.findElement(By.xpath("//div[@id='state']//div[contains(text(),'Uttar Pradesh')]"));
	state.click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@id='city']")).click();
	WebElement city = driver.findElement(By.xpath("//div[@id='city']//div[contains(text(),'Lucknow')]"));
	city.click();
	driver.findElement(By.xpath("//button[@id='submit']")).click();
	Thread.sleep(2000);
	} 


}