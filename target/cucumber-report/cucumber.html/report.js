$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("onlineshoping.feature");
formatter.feature({
  "line": 1,
  "name": "SignUp Page",
  "description": "",
  "id": "signup-page",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "TC-001 Create New User/SignUp",
  "description": "",
  "id": "signup-page;tc-001-create-new-user/signup",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@Smoke"
    },
    {
      "line": 4,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I am on home page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Navigate to SignUp page",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Create an account with random username",
  "keyword": "And "
});
formatter.match({
  "location": "OnlineShoppingTest.iAmOnHomePage()"
});
formatter.result({
  "duration": 384451200,
  "status": "passed"
});
formatter.match({
  "location": "OnlineShoppingTest.navigateToSignUpPage()"
});
formatter.result({
  "duration": 82313800,
  "error_message": "java.lang.NullPointerException\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:70)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:39)\r\n\tat com.sun.proxy.$Proxy17.toString(Unknown Source)\r\n\tat com.automation.pages.HomePage.clickOnSignInLink(HomePage.java:79)\r\n\tat com.automation.steps.OnlineShoppingTest.navigateToSignUpPage(OnlineShoppingTest.java:41)\r\n\tat ✽.Then Navigate to SignUp page(onlineshoping.feature:7)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "OnlineShoppingTest.createAnAccountWithRandomUsername()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 11,
  "name": "TC-002 Sign In with newly created user credentials",
  "description": "",
  "id": "signup-page;tc-002-sign-in-with-newly-created-user-credentials",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@Sanity"
    },
    {
      "line": 10,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "I am on the Sign In Page",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "Login using newly create credentials",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I shall verify the address information in my address section",
  "keyword": "Then "
});
formatter.match({
  "location": "OnlineShoppingTest.iAmOnTheSignInPage()"
});
formatter.result({
  "duration": 5247700,
  "error_message": "java.lang.NullPointerException\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:70)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:39)\r\n\tat com.sun.proxy.$Proxy17.toString(Unknown Source)\r\n\tat com.automation.pages.HomePage.clickOnSignInLink(HomePage.java:79)\r\n\tat com.automation.steps.OnlineShoppingTest.iAmOnTheSignInPage(OnlineShoppingTest.java:55)\r\n\tat ✽.Given I am on the Sign In Page(onlineshoping.feature:12)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "OnlineShoppingTest.loginUsingNewlyCreateCredentials()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OnlineShoppingTest.iShallVerifyTheAddressInformationInMyAddressSection()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 17,
  "name": "TC-003 Add product to Online Cart and checkout",
  "description": "",
  "id": "signup-page;tc-003-add-product-to-online-cart-and-checkout",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 16,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 18,
  "name": "I am on the Sign In Page",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "Login using newly create credentials",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "I add below product to cart",
  "rows": [
    {
      "cells": [
        "category",
        "subCategory",
        "name",
        "model",
        "quantity"
      ],
      "line": 21
    },
    {
      "cells": [
        "Dresses",
        "CASUAL DRESSES",
        "Printed Dress",
        "demo_3",
        "2"
      ],
      "line": 22
    },
    {
      "cells": [
        "Women",
        "TOPS",
        "Faded Short Sleeve T-shirts",
        "demo_1",
        "3"
      ],
      "line": 23
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "I shall validate shopping cart as below",
  "rows": [
    {
      "cells": [
        "name",
        "model",
        "quantity"
      ],
      "line": 25
    },
    {
      "cells": [
        "Printed Dress",
        "SKU : demo_3",
        "2"
      ],
      "line": 26
    },
    {
      "cells": [
        "Faded Short Sleeve T-shirts",
        "SKU : demo_1",
        "3"
      ],
      "line": 27
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "I shall be able to Buy the product",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "I shall be able to Buy using cheque payment",
  "keyword": "And "
});
formatter.match({
  "location": "OnlineShoppingTest.iAmOnTheSignInPage()"
});
formatter.result({
  "duration": 5169600,
  "error_message": "java.lang.NullPointerException\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:70)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:39)\r\n\tat com.sun.proxy.$Proxy17.toString(Unknown Source)\r\n\tat com.automation.pages.HomePage.clickOnSignInLink(HomePage.java:79)\r\n\tat com.automation.steps.OnlineShoppingTest.iAmOnTheSignInPage(OnlineShoppingTest.java:55)\r\n\tat ✽.Given I am on the Sign In Page(onlineshoping.feature:18)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "OnlineShoppingTest.loginUsingNewlyCreateCredentials()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OnlineShoppingTest.i_add_below_product_to_cart(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OnlineShoppingTest.i_shall_validate_shopping_cart_as_below(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OnlineShoppingTest.i_shall_be_able_to_Buy_the_product()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OnlineShoppingTest.i_shall_be_able_to_Buy_using_cheque_payment()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 32,
  "name": "TC-004 Contact customer service for the previous successful order",
  "description": "",
  "id": "signup-page;tc-004-contact-customer-service-for-the-previous-successful-order",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 31,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 33,
  "name": "I am on the Sign In Page",
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "Login using newly create credentials",
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "I am on the contact page",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I send refund request to customer care for previous order",
  "keyword": "Then "
});
formatter.match({
  "location": "OnlineShoppingTest.iAmOnTheSignInPage()"
});
formatter.result({
  "duration": 8618400,
  "error_message": "java.lang.NullPointerException\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:70)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:39)\r\n\tat com.sun.proxy.$Proxy17.toString(Unknown Source)\r\n\tat com.automation.pages.HomePage.clickOnSignInLink(HomePage.java:79)\r\n\tat com.automation.steps.OnlineShoppingTest.iAmOnTheSignInPage(OnlineShoppingTest.java:55)\r\n\tat ✽.Given I am on the Sign In Page(onlineshoping.feature:33)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "OnlineShoppingTest.loginUsingNewlyCreateCredentials()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OnlineShoppingTest.iAmOnTheContactPage()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OnlineShoppingTest.iSendRefundRequestToCustomerCareForPreviousOrder()"
});
formatter.result({
  "status": "skipped"
});
});