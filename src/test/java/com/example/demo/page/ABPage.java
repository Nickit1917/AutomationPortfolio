package com.example.demo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ABPage {


    //Locators
       @FindBy(tagName = "h3")
       private WebElement header;
       @FindBy(tagName = "p")
       private WebElement content;

    //Methods

        //Checks for text "A/B" at the xpath of the header element to verify it loads
        public boolean headerPresent(){
            if(header.isDisplayed()){
                return true;
            } else {
                return false;
            }
        }

        //Checks for text "Also known as split testing" at the xpath of the content element to verify it loads
        public boolean contentPresent(){
            if(content.isDisplayed()){
                return true;
            } else {
                return false;
            }
        }

}
