package com.automation.steps;


import com.automation.pages.*;
import com.automation.utility.Utility;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OnlineShoppingTest extends Utility {

    String randomEmail;
    String randomUsername;
    String password = "Abc1234";

    @Given("^I am on home page$")
    public void iAmOnHomePage() throws IOException {
        File file = new File("data.txt"); // References file in root directory called "data.txt", which is where the random email and username are stored
        file.createNewFile(); // Creates the file if it doesn't exist
        FileWriter writer = new FileWriter(file); // Allows writing to file
        randomEmail = doGetRandomEmail();
        randomUsername = doGetRandomUserName();
        writer.write(randomEmail + " & " + randomUsername); // Write new data to file
        writer.close();
    }

    @Then("^Navigate to SignUp page$")
    public void navigateToSignUpPage() {
        new HomePage().clickOnSignInLink();
    }

    @And("^Create an account with random username$")
    public void createAnAccountWithRandomUsername() {
        new AuthPage().inputEmailToCreateAccount(randomEmail);
        new AuthPage().clickOnCreateAccountButton();
        new CreateAccountPage().enterPersonalInformation("Harry", "Potter", "Mr.", password);
        new CreateAccountPage().enterAddressDetails("Harry", "Potter", "10 Downing drive", "London", "California", "36401", "01234789654");
        new CreateAccountPage().clickOnRegisterButton();
    }

    @Given("^I am on the Sign In Page$")
    public void iAmOnTheSignInPage() throws FileNotFoundException {
        new HomePage().clickOnSignInLink();
        File file = new File("data.txt"); // Reference "data.txt", where email and username are stored
        Scanner reader = new Scanner(file); // Scanner class allows for reading the file
        if (reader.hasNextLine()) {
            String data = reader.nextLine(); // Gets data from file
            randomEmail = Arrays.stream(data.split("&")).collect(Collectors.toList()).get(0);
            randomUsername = Arrays.stream(data.split("&")).collect(Collectors.toList()).get(1);
        }
        reader.close();
    }

    @When("^Login using newly create credentials$")
    public void loginUsingNewlyCreateCredentials() {
        new AuthPage().inputEmailAddress(randomEmail);
        new AuthPage().inputPassword(password);
        new AuthPage().clickOnSignInButton();
    }

    @Then("^I shall verify the address information in my address section$")
    public void iShallVerifyTheAddressInformationInMyAddressSection() {
        new MyAccountPage().clickOnMyAddressesTab();
        new MyAccountPage().verifyMyAddress("10 Downing drive", "London");

    }

    @When("^I add below product to cart$")
    public void i_add_below_product_to_cart(DataTable table)  {
        AtomicInteger rowCount = new AtomicInteger(); // AtomicInteger is an integer that is updated atomically, i.e. in one thread instead of two
        table.getGherkinRows().forEach((DataTableRow row) -> {
            rowCount.getAndIncrement(); // Increments rowCount
            if (rowCount.get() != 1) { // Don't want first row, as it is the column headings rather than the column data
                new ProductPage().addProductToCart(row.getCells(), rowCount.get() == table.getGherkinRows().size() - 1);
            }
        });
    }

    @Then("^I shall validate shopping cart as below$")
    public void i_shall_validate_shopping_cart_as_below(DataTable table)  {
        AtomicInteger rowCount = new AtomicInteger(0);
        table.getGherkinRows().forEach((DataTableRow row) -> {
            rowCount.getAndIncrement();
            if (rowCount.get() != 1) {
                new ShoppingCartPage().verifyShoppingCart(row.getCells());
            }
        });
    }

    @Then("^I shall be able to Buy the product$")
    public void i_shall_be_able_to_Buy_the_product()  {
        new ShoppingCartPage().clickProceedToCheckOut();
        new ShoppingCartPage().clickProceedToCheckOutAddressPage();
        new ShoppingCartPage().selectTerms();
        new ShoppingCartPage().clickProceedToCheckoutShippingPage();
        new ShoppingCartPage().selectPayByCheck();
        new ShoppingCartPage().iConfirmMyOrder();
    }

    @Then("^I shall be able to Buy using cheque payment$")
    public void i_shall_be_able_to_Buy_using_cheque_payment()  {
        new ShoppingCartPage().verifyCheckPaymentOptionUsedToCompleteShopping("Your order on My Store is complete.");
    }


    @And("^I am on the contact page$")
    public void iAmOnTheContactPage() {
        new HomePage().clickContactUs();
        new ContactPage().verifyContactPageText("CUSTOMER SERVICE - CONTACT US");
    }

    @Then("^I send refund request to customer care for previous order$")
    public void iSendRefundRequestToCustomerCareForPreviousOrder() {
    }
}
