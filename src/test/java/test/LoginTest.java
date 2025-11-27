package test;

import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginUser() {

        String userName = "standard_user";
        String password = "secret_sauce";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserData(userName, password);
        
    }

}
