package com.automation.pages;

import com.automation.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummerDressesPage extends Utility {

    private static final Logger log = LogManager.getLogger(SummerDressesPage.class.getName());

    public SummerDressesPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (xpath = "//span[@class='cat-name']")
    WebElement summerDressesText;

    @CacheLookup
    @FindBy (xpath = "//div[@id='left_column']//a[2]")
    WebElement slider;

    public void verifySummserDressesText(String message){
        log.info("Verifying Summer Dresses text " + summerDressesText.toString());
        verifyThatTextIsDisplayed(summerDressesText, message);
    }

    public void moveSlider() throws InterruptedException {
        log.info("Moving Slider " + slider.toString());
        Actions action= new Actions(driver);
        action.click(slider).build().perform();
        Thread.sleep(1000);
        for (int i = 0; i < 75; i++)
        {
            action.sendKeys(Keys.ARROW_LEFT).build().perform();
        }
    }

}
