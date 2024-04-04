package conditions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Condition {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public Condition(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }
    
    public void clickWhenClickable(By locator) {
        try{
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        }
        catch(ElementClickInterceptedException e){
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        }
        catch (StaleElementReferenceException e) {
            System.out.println("The element is no longer attached to the DOM.");
        }
        catch (TimeoutException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendKeysWhenVisible(By locator, CharSequence... keysToSend) {
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(keysToSend);
        }
        catch (StaleElementReferenceException e) {
            System.out.println("The element is no longer attached to the DOM.");
        }
        catch (TimeoutException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveToElement(By locator){
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            actions.moveToElement(element).perform();
        }
        catch (StaleElementReferenceException e) {
            System.out.println("The element is no longer attached to the DOM.");
        }
        catch (TimeoutException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cancelPopup(By locator){
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            if(element.isDisplayed()){
                element.click();
            }
        }
        catch (StaleElementReferenceException e) {
            System.out.println("The element is no longer attached to the DOM.");
        }
        catch (TimeoutException e) {
            System.out.println("Timeout occurred while waiting for the element to be visible.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilInvisible(By locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void switchToIframe(By locator){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }
    
    public void switchFromIframe(){
        driver.switchTo().defaultContent();
    }
}