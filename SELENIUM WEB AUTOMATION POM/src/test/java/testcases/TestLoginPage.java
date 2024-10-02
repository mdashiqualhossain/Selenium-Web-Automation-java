package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.DriverSetup;

public class TestLoginPage extends DriverSetup {


    LoginPage loginPage = new LoginPage();
    

    @BeforeClass
    public void loadPage(){
        loginPage.navigateToLoginPage();
    }

    @Test
    public void test_login_with_valid_credentials() {
        System.out.println("test browser run");

    }
}
