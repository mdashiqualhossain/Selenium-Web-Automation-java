package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    public String homePageUrl = "https://automationexercise.com/";
    //public String homePageUrl="https://katalon-demo-cura.herokuapp.com/";

    public By Signup_Login_Button = By.xpath("//a[normalize-space()='Signup / Login']");
    //public By Make_Appoinemnt_Button = By.xpath("//a[@id='btn-make-appointment']");

    public void loadHomePage(){
        loadAWebPage(homePageUrl);
    }

}
