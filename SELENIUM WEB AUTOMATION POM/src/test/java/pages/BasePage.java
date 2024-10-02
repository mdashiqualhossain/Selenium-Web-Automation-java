package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.DriverSetup.getDriver;

public class BasePage{

    public WebElement getElement(By locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clickOnElement(By locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void loadAWebPage(String url){
        getDriver().get(url);
    }
    public void waitForElementToBeClickable(By locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
    }
    public void inputText(By locator, String text){
        getElement(locator).sendKeys(text);
    }
    public void hoverOnElement(By locator) {
        Actions action = new Actions(getDriver());
        action.clickAndHold(getElement(locator)).build().perform();
    }
    public void hover(By locator) {
        Actions action = new Actions(getDriver());
        action.moveToElement(getElement(locator)).build().perform();
    }


//    public void takeScreenShot(String name){
//        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getLocalDriver()).getScreenshotAs(OutputType.BYTES)));
//    }






}
