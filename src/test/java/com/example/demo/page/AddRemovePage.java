package com.example.demo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddRemovePage {

        //Locators
        @FindBy(css = "#content > div > button")
        private WebElement addButton;
        @FindBy(css = "#elements > button:nth-child(1)")
        private WebElement firstDeleteButton;
        @FindBy(className = "added-manually")
        private List<WebElement> allDeleteButtons;

        //Methods

        public void clickAddButton(){
            addButton.click();
        }

        public void clickFirstDeleteButton(){
            firstDeleteButton.click();
        }

        public void clickAllDeleteButton(){
                for(WebElement element : allDeleteButtons){
                        element.click();
                }
        }

        public int numberOfDeleteButtons(){
                return allDeleteButtons.size();
        }
}
