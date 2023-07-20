package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.fail;
import static util.Browser.driver;

/**
 * @author jussaragranja
 */
public class BasePage {

    public static void wait(WebElement element){
        try {
            WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(2L));
            driverWait.until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e){
            fail("timeout while waiting for element "+ element +("Exception ")+e.getMessage());
        }
    }

    public void click(WebElement element){
        try {
            wait(element);
            element.click();
        }catch (Exception e){
            fail("element could not be clicked "+ element +("Exception ")+e.getMessage());
        }
    }

    public void writeInField(WebElement element, String wordsKeysToSend){
        try {
            wait(element);
            element.clear();
            element.sendKeys(wordsKeysToSend);
        }catch (WebDriverException e){
            fail("could not find element to write "+element +("Exception ")+e.getMessage());
        }
    }

    public void selectElementByVisibleValue(WebElement element, String value){
        try {
            wait(element);
            new Select(element).selectByValue(value);
        }catch (NoSuchElementException e){
            fail("error selecting element "+element);
        }
    }

}