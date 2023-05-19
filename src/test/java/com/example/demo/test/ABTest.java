package com.example.demo.test;


import com.example.demo.page.ABPage;
import com.example.demo.utils.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ABTest {

   @Test
   @Parameters({"browser"})
   public void Test(String browser){
       //Driver management
       WebDriver driver = BrowserManager.getDriver(browser);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       //Load page to be tested
       driver.get("https://the-internet.herokuapp.com/abtest");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       //Constructs page object
       ABPage ABpage = PageFactory.initElements(driver, ABPage.class);
       //Tests elements loaded
       Assert.assertTrue(ABpage.headerPresent());
       Assert.assertTrue(ABpage.contentPresent());
       //Close Browser
       driver.quit();
   }

}

