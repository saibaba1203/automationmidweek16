package com.automation.pages;


import com.automation.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());
    public HomePage() { PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//a[@title='Women']")
    WebElement women;

    @CacheLookup
    @FindBy (xpath = "(//a[@title='Dresses'])[2]")
    WebElement dresses;

    @CacheLookup
    @FindBy (xpath = "(//a[@title='Casual Dresses'])[2]")
    WebElement casualDresses;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement signInLink;

    @CacheLookup
    @FindBy(xpath = "//img[@alt='My Store']")
    WebElement logoLocator;

    @CacheLookup
    @FindBy (xpath = "//li[@class='sfHover']//a[@title='Summer Dresses'][normalize-space()='Summer Dresses']")
    WebElement summerDresses;

    @CacheLookup
    @FindBy (xpath = "//a[contains(text(),'Our stores')]")
    WebElement ourStoresLink;

    @CacheLookup
    @FindBy(xpath = "//a[@title='Contact Us']")
    WebElement contactUsLink;

    public void clickOnWomenTab(){
        log.info("Entering Quantity " + women.toString());
        doClickOnElement(women);
    }

    public void mouseHoverOnWomenTab(){
        log.info("Mouse hovering on Women Tab " + women.toString());
        doMouseHoverTo(women);
    }

    public void mouseHoverOnDressesTab(){
        log.info("Mouse hovering on Dresses Tab " + dresses.toString());
        doMouseHoverTo(dresses);
    }

    public void clickOnCasualDresses(){
        log.info("Clicking on Casual Dresses Tab " + casualDresses.toString());
        doMouseHoverAndClick(casualDresses);
    }

    public void clickOnSummerDresses(){
        log.info("Clicking on Summer Dresses " + summerDresses.toString());
        doMouseHoverAndClick(summerDresses);
    }

    public void clickOnSignInLink(){
        log.info("Clicking on SignInLink " + signInLink.toString());
        doClickOnElement(signInLink);
    }

    public void verifyLogoisVisible(){
        log.info("Verifying logo is displayed " + logoLocator.toString());
        verifyThatElementIsDisplayed(logoLocator);
    }

    public void clickOnOurStoresLink(){
        log.info("Clicking on Our Strores link  " + ourStoresLink.toString());
        doClickOnElement(ourStoresLink);
    }

    public void clickContactUs() {
        doClickOnElement(contactUsLink);
        log.info("Clicking on ContactUs Link : " + contactUsLink.toString() + "<br>");
    }

    // This method will select top menu categroy
    public void selectMenu(String menu) {
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//div[@id='block_top_menu']//li"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(menu)) {
                names.click();
                break;
            }
        }
    }

}
