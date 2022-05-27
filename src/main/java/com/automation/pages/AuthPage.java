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

public class AuthPage extends Utility {

    private static final Logger log = LogManager.getLogger(AuthPage.class.getName());
    public AuthPage() {
        PageFactory.initElements(driver, this);
    }


    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Authentication')]")
    WebElement authenticationMessage;

    @CacheLookup
    @FindBy(id = "email")
    WebElement emailAddressField;

    @CacheLookup
    @FindBy(id = "passwd")
    WebElement passwordField;

    @CacheLookup
    @FindBy(id = "SubmitLogin")
    WebElement signInButton;

    @CacheLookup
    @FindBy(id = "SubmitCreate")
    WebElement createAccountButton;

    @CacheLookup
    @FindBy(id = "email_create")
    WebElement createAccountEmail;

    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),'An email address required.')]")
    WebElement emailRequiredError;

    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),'Password is required.')]")
    WebElement passwordRequiredError;

    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),'Invalid email address.')]")
    WebElement invalidEmail;

    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),'Authentication failed.')]")
    WebElement authenticationFailed;

    @CacheLookup
    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement logoutButton;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement signInLink;

    public void verifyAuthenticationMessage(String text) {
        log.info("Verifying Authentication message " + authenticationMessage.toString());
        verifyThatTextIsDisplayed(authenticationMessage, text);
    }

    public void inputEmailAddress(String text) {
        log.info("Entering email address " + emailAddressField.toString());
        doSendTextToElement(emailAddressField, text);
    }

    public void inputPassword(String text) {
        log.info("Entering password " + passwordField.toString());
        doSendTextToElement(passwordField, text);
    }

    public void clickOnSignInButton() {
        log.info("Clicking on signIn Button " + signInButton.toString());
        doClickOnElement(signInButton);
    }

    public void verifySignOutLinkIsVisible() {
        log.info("Verifying Sign Out link is visible " + logoutButton.toString());
        verifyThatElementIsDisplayed(logoutButton);
    }

    public void clickOnSignOutLink() {
        log.info("Clicking on Logout button " + logoutButton.toString());
        doClickOnElement(logoutButton);
    }

    public void verifySignInLinkVisible() {
        log.info("Clicking on SignInLink " + signInLink.toString());
        verifyThatElementIsDisplayed(signInLink);
    }

    public void inputEmailToCreateAccount(String text) {
        log.info("Entering email to create account  " + createAccountEmail.toString());
        doSendTextToElement(createAccountEmail, text);
    }

    public void clickOnCreateAccountButton() {
        log.info("Clicking on Create Account Button  " + createAccountButton.toString());
        doClickOnElement(createAccountButton);
    }

    public void inputCredentials(String username, String password) {
        log.info("Entering email address " + emailAddressField.toString());
        doSendTextToElement(emailAddressField, username);
        log.info("Entering Password " + passwordField.toString());
        doSendTextToElement(passwordField, password);

    }

    // This method will get error message
    public void verifyErrorMessage(String errorMessage) {
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//body/div[@id='page']/div[@class='columns-container']/div[@id='columns']/div[@class='row']/div[@id='center_column']/div[1]"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(errorMessage)) {
                break;
            }
        }
    }

}
