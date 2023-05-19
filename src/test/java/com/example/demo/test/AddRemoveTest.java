package com.example.demo.test;

import com.example.demo.page.AddRemovePage;
import com.example.demo.utils.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddRemoveTest {
    @Test
    @Parameters({"browser"})
    public void Test(String browser){
        //Driver management
        WebDriver driver = BrowserManager.getDriver(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Load page to be tested
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Constructs page object
        AddRemovePage addRemovePage = PageFactory.initElements(driver, AddRemovePage.class);

        //Creates 3 elements
        addRemovePage.clickAddButton();
        addRemovePage.clickAddButton();
        addRemovePage.clickAddButton();
        //Verifies 3 elements were added to the page
        Assert.assertEquals(addRemovePage.numberOfDeleteButtons(), 3);
        //Deletes the first element
        addRemovePage.clickFirstDeleteButton();
        //Verifies one element was deleted from the page
        Assert.assertEquals(addRemovePage.numberOfDeleteButtons(), 2);
        //Deletes all elements
        addRemovePage.clickAllDeleteButton();
        //Verifies all elements have been deleted
        Assert.assertEquals(addRemovePage.numberOfDeleteButtons(), 0);

        //Close Browser
        driver.quit();
    }

}
