package com.example.demo.test;

import com.example.demo.page.BasicAuthPage;
import com.example.demo.utils.BrowserManager;
import com.example.demo.utils.CredentialGenerator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class NegativeAuthTest {
    public WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void init(String browser){
        //Driver management
        driver = BrowserManager.getDriver(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(dataProvider = "invalidCreds", dataProviderClass = CredentialGenerator.class, groups = {"basicAuth"})
    public void Test(String username, String password) {
        //Constructs page object
        BasicAuthPage basicAuthPage = PageFactory.initElements(driver, BasicAuthPage.class);

        //Pass in credentials while loading page
        driver.get("https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        //Test if login was successful
       try{
            basicAuthPage.successTextPresent();
            Assert.fail("Test failed because login was completed with invalid creds");
        } catch (NoSuchElementException e){
           //Test passes because it should not load with invalid credentials
            } catch (UnhandledAlertException e){
           //Exception thrown when testing against FireFox
           }
    }

    @AfterTest
    public void Shutdown(){
        driver.quit();
    }
}
