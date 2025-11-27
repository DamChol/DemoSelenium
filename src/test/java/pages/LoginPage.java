package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(css = "#login-button")
    private WebElement loginButton;

    @FindBy(css = "[id$='user-name")
    private WebElement userNameInput;

    @FindBy(css = "[id^='password'")
    private WebElement passwordInput;

    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage fillUserData(String userName, String password) {
        // WebDriver Wait wait = new WebDriverWait(driver, 5);
        // wait.until(ExpectedConditions.visibilityOf(loginButton));
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        
        // loginButton.click();
        return this;
    }

    public ProductsPage loginUser(String userName, String password ) {
        loginButton.isDisplayed();
        fillUserData(userName, password);
        loginButton.click();
        return new ProductsPage(driver);
    }

}
