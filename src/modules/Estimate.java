package modules;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import paths.menuPaths.BillingPaths;
import paths.modulePaths.EstimatePaths;


public class Estimate {
    WebDriver driver;
    // WebDriverWait wait;
    Actions actions;

    BillingPaths billingMenuPaths;
    EstimatePaths estimatePaths;

    public Estimate(WebDriver driver){
        this.driver = driver;

        billingMenuPaths = new BillingPaths();
        estimatePaths = new EstimatePaths();
    }

    public void createEstimate(String currencyCode, String product){
        goToEstimateModule();
        addEstimate(currencyCode, product);
    }

    public void editEstimate(String currencyCode, String product){
        clickWhenClickable(estimatePaths.actionDrp);
        clickWhenClickable(estimatePaths.editBtn);
        addEstimate(currencyCode, product);
    }

    private void goToEstimateModule(){
        try {
            clickWhenClickable(billingMenuPaths.billingMenu);
            clickWhenClickable(billingMenuPaths.billingMenu);
            clickWhenClickable(billingMenuPaths.estimateModule);
            clickWhenClickable(estimatePaths.list);
            clickWhenClickable(estimatePaths.newBtn);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    private void addEstimate(String currencyCode, String product){
        try{
            clickWhenClickable(estimatePaths.currencyCode);
            clickWhenClickable(estimatePaths.selectCurrencyCode.get(currencyCode));
            clickWhenClickable(estimatePaths.estimateItems);
            clickWhenClickable(estimatePaths.product);
            clickWhenClickable(estimatePaths.selectProduct.get(product));
            clickWhenClickable(estimatePaths.saveBtn);
        }catch(TimeoutException e){
            e.printStackTrace();
        }
    }

    private void clickWhenClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    private void sendKeysWhenVisible(By locator, CharSequence... keysToSend) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(keysToSend);
    }
}