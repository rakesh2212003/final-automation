package modules.billing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import conditions.Condition;
import paths.menuPaths.BillingPaths;
import paths.modulePaths.EstimatePaths;


public class Estimate {
    WebDriver driver;

    Condition condition;
    BillingPaths billingMenuPaths;
    EstimatePaths estimatePaths;

    public Estimate(WebDriver driver){
        this.driver = driver;

        condition = new Condition(driver);
        billingMenuPaths = new BillingPaths();
        estimatePaths = new EstimatePaths();
    }

    public void createEstimate(String currencyCode, String product){
        goToEstimateModule();
        addEstimate(currencyCode, product);
    }

    public void editEstimate(String currencyCode, String product){
        condition.clickWhenClickable(estimatePaths.actionDrp);
        condition.clickWhenClickable(estimatePaths.editBtn);
        addEstimate(currencyCode, product);
    }

    private void goToEstimateModule(){
        try {
            condition.clickWhenClickable(billingMenuPaths.billingMenu);
            condition.clickWhenClickable(billingMenuPaths.billingMenu);
            condition.clickWhenClickable(billingMenuPaths.estimateModule);
            condition.clickWhenClickable(estimatePaths.list);
            condition.clickWhenClickable(estimatePaths.newBtn);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    private void addEstimate(String currencyCode, String product){
        try{
            condition.clickWhenClickable(estimatePaths.currencyCode);
            condition.clickWhenClickable(estimatePaths.selectCurrencyCode.get(currencyCode));
            condition.clickWhenClickable(estimatePaths.estimateItems);
            condition.clickWhenClickable(estimatePaths.product);
            condition.clickWhenClickable(estimatePaths.selectProduct.get(product));
            condition.clickWhenClickable(estimatePaths.saveBtn);
        }catch(TimeoutException e){
            e.printStackTrace();
        }
    }
}