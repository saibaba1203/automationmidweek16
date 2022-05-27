package com.automation.pages;

import com.automation.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class ShoppingCartPage extends Utility {
    private static final Logger log = LogManager.getLogger(ShoppingCartPage.class.getName());

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//p[@class='product-name']//a")
    List<WebElement> names;

    @CacheLookup
    @FindBy(css = ".cart_ref")
    List<WebElement> models;

    @CacheLookup
    @FindBy(css = "input.cart_quantity_input.form-control.grey")
    List<WebElement> qtyInputs;

    @CacheLookup
    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    WebElement proceedToCheckout;

    @CacheLookup
    @FindBy(id = "cgv")
    WebElement selectTC;

    @CacheLookup
    @FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckOutShipping;

    @CacheLookup
    @FindBy(xpath = "//a[@title='Pay by check.']")
    WebElement payByCheck;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='I confirm my order']")
    WebElement confirmOrder;

    @CacheLookup
    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement checkPaymentVerification;

    public void verifyShoppingCart(List<String> cells) {
        String name = cells.get(0);
        String model = cells.get(1);
        String quantity = cells.get(2);

        AtomicBoolean nameAsserted = new AtomicBoolean();
        names.stream().map(WebElement::getText).collect(Collectors.toList()).forEach((String s) -> {
            if (s.equalsIgnoreCase(name)) nameAsserted.set(true);
        });
        Assert.assertTrue(nameAsserted.get());

        AtomicBoolean modelAsserted = new AtomicBoolean();
        models.stream().map(WebElement::getText).collect(Collectors.toList()).forEach((String s) -> {
            if (s.equalsIgnoreCase(model)) modelAsserted.set(true);
        });
        Assert.assertTrue(modelAsserted.get());

        AtomicBoolean qtyAsserted = new AtomicBoolean();
        qtyInputs.forEach((WebElement e) -> {
            if (e.getAttribute("value").equalsIgnoreCase(quantity)) qtyAsserted.set(true);
        });
        Assert.assertTrue(qtyAsserted.get());
    }

    public void clickProceedToCheckOut() {
        doClickOnElement(proceedToCheckout);
        log.info("Click Proceed to checkout btn : " + proceedToCheckout.toString() + "<br>");
    }

    public void selectTerms() {
        doClickOnElement(selectTC);
        log.info("Click on Select Terms box : " + selectTC.toString() + "<br>");
    }

    public void clickProceedToCheckoutShippingPage() {
        doClickOnElement(proceedToCheckOutShipping);
        log.info("Click Proceed to checkout btn on Shipping Page: " + proceedToCheckOutShipping.toString() + "<br>");
    }

    public void selectPayByCheck() {
        doClickOnElement(payByCheck);
        log.info("Click on Pay by Check method: " + payByCheck.toString() + "<br>");
    }

    public void iConfirmMyOrder() {
        doClickOnElement(confirmOrder);
        log.info("Click to Confirm Order btn : " + confirmOrder.toString() + "<br>");
    }

    public void clickProceedToCheckOutAddressPage() {
        doClickOnElement(proceedToCheckout);
        log.info("Click Proceed to checkout btn on Address Page: " + proceedToCheckout.toString() + "<br>");
    }

    public void verifyCheckPaymentOptionUsedToCompleteShopping(String text) {
        Assert.assertTrue(checkPaymentVerification.getText().contains(text));
        log.info("verifying Payment Method text : " + text + "<br>");
    }
}
