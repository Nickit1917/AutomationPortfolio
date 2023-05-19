package com.example.demo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasicAuthPage {

        //Locators
        @FindBy(css = "#content > div > p")
        private WebElement successText;

        //Methods

        public boolean successTextPresent() {
            if (successText.isDisplayed()) {
                return true;
            } else {
                return false;
            }
        }

}

