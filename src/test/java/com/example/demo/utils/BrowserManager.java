package com.example.demo.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class BrowserManager {

    //Assigns webdriver based on parameter passed in from TestNG XML utilizing dynamic WebDriverManager plugin
    public static WebDriver getDriver(String browser) {
        WebDriver driver = null;

    //Fix for Chrome bug https://github.com/SeleniumHQ/selenium/issues/11750
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        EdgeOptions Eoptions = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");

        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(Eoptions);
        } else {
            Assert.fail("Failed to get driver. Invalid browser identified.");
        }

        return driver;

    }
}
