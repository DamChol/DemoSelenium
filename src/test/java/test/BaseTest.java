package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.DriverFactory;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();;
    }
}


// Three pages of an Enterprise Portal need to be covered with Automation Tests
    
    // Application has a Login page, Products page and Shopping Cart page.
    // Automation Tests should cover:
    // - ability to login
    // - verification that Products page has 6 Products
    // - ability to add the Product with the highest price to the Cart
    // - verification that Product is successfully added to the Cart
    
    // Additional Information:
    // Login page URL: https://www.saucedemo.com/
    // Username: standard_user
    // Password: secret_sauce
    // Swag Labs
    // Sauce Labs Swag Labs app
    
    // here is the chat