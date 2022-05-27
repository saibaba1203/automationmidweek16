package com.automation.pages;


import com.automation.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends Utility {

    private static final Logger log = LogManager.getLogger(ProductPage.class.getName());
    public ProductPage() {PageFactory.initElements(driver, this);}

    @CacheLookup
    @FindBy(css = "a.product-name")
    List<WebElement> products;

    @CacheLookup
    @FindBy(id = "quantity_wanted")
    WebElement qty;

    @CacheLookup
    @FindBy(id = "group_1")
    WebElement selectSize;

    @CacheLookup
    @FindBy(className = "attribute_list")
    WebElement color;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
    WebElement popUpDisplay;

    @CacheLookup
    @FindBy(xpath = "//span[@title='Close window']")
    WebElement closeButton;

    @CacheLookup
    @FindBy (xpath = "//a[@title='Proceed to checkout']")
    WebElement proceedToCheckoutButton;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//li//a")
    List<WebElement> menuList;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//li//ul//li//a")
    List<WebElement> innerMenuList;

    @CacheLookup
    @FindBy(xpath = "//span[@title='Continue shopping']//span[1]")
    WebElement continueShoppingBtn;

    public void addProductAttribute(String qty1, String size, String colour) {
        log.info("Entering Quantity " + qty.toString());
        doSendTextToElement(qty, Keys.BACK_SPACE + qty1);
        log.info("Selecting Size " + selectSize.toString());
        doSelectByVisibleTextFromDropDown(selectSize, size);
        log.info("Selecting Colour  " + color.toString());
        doClickOnElement(color, colour);
    }

    public void clickOnAddToCartButton(){
        log.info("Clicking on Add To cart button " + addToCartButton.toString());
        doClickOnElement(addToCartButton);
    }

    public void verifyProductAddedToCartMessage(String text){
        log.info("Verify message displayed on Pop Up  " + popUpDisplay.toString());
        verifyThatTextIsDisplayed(popUpDisplay, text);
    }

    public void clickOnCloseButton(){
        log.info("Click on Close button " + closeButton.toString());
        doClickOnElement(closeButton);
    }

    public void clickOnProceedToCheckoutButton(){
        log.info("Clicking on Proceed to Checkout Button " + proceedToCheckoutButton.toString());
        doClickOnElement(proceedToCheckoutButton);
    }

    public void selectFromCategory(String select) {
        for (WebElement menu : menuList) {
            if (menu.getText().equalsIgnoreCase(select)) {
                doMouseHoverTo(menu);
                log.info("Select Item from main menu : " + select + "<br>");
                break;
            }
        }
    }

    public void selectFromSubCategory(String subMenu) {
        for (WebElement item : innerMenuList)
            if (item.getText().equalsIgnoreCase(subMenu)) {
                doMouseHoverAndClick(item);
                log.info("Select Item from sub menu : " + subMenu + "<br>");
                break;
            }
    }

    public void addProductToCart(List<String> data, boolean isLast) {
        String category = data.get(0);
        String subCategory = data.get(1);
        String name = data.get(2);
        String quantity = data.get(4);

        selectFromCategory(category.toUpperCase());
        selectFromSubCategory(subCategory);
        int i = 0;
        while (i < products.size()) {
            WebElement product = products.get(i);
            if (product.getText().equalsIgnoreCase(name)) {
                product.click();
                break;
            }
            i++;
        }
        qty.sendKeys(Keys.BACK_SPACE+quantity);
        addToCartButton.click();
        if (isLast) {
            continueShoppingBtn.click();
        } else {
            proceedToCheckoutButton.click();
        }
    }

}
