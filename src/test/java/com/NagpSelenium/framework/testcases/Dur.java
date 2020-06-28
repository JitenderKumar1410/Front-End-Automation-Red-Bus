package com.NagpSelenium.framework.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class Dur {
 
    public static void main(String[] args) throws InterruptedException {
   
        System.setProperty("webdriver.chrome.driver", ".//ImportantFiles//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       
        String url = "https://mohmal.com ";
        driver.get(url);
        System.out.println("Successfully opened edhiram");
        // title
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='languages']//a[contains(text(),'English')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='rand']")).click();
        Thread.sleep(50000);
        driver.findElement(By.xpath("//td[1]//a[1]")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        System.out.println();
        driver.switchTo().frame(2);
        System.out.println("Switched succeesful");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='body']//iframe")).click();
       
    }
 
}