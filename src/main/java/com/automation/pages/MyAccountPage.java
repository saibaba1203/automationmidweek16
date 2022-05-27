package com.automation.pages;


import com.automation.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyAccountPage extends Utility {

    private static final Logger log = LogManager.getLogger(MyAccountPage.class.getName());
    public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (xpath = "//span[contains(text(),'My addresses')]")
    WebElement myAddresses;

    @CacheLookup
    @FindBy (xpath = "//ul[@class='last_item item box']")
    WebElement addressBox;

    public void clickOnMyAddressesTab(){
        doClickOnElement(myAddresses);
    }

    public void verifyMyAddress(String address, String address1){
        Assert.assertTrue(addressBox.getText().contains(address));
        Assert.assertTrue(addressBox.getText().contains(address1));
        System.out.println(addressBox.getText());
        log.info("Verify My Address  : " + address + addressBox.toString()+ "<br>");
    }
}
