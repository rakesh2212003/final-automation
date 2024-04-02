package modules.billing;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import conditions.Condition;
import paths.modulePaths.EstimatePaths;

public class Estimate {
    private Condition condition;

    public Estimate(WebDriver driver){
        condition = new Condition(driver);
    }

    public void createEstimate(String currencyCode, String product){
        goToEstimateModule();
        addEstimate(currencyCode, product);
    }

    // public void editEstimate(String currencyCode, String product){
    //     condition.clickWhenClickable(EstimatePaths.actionDrp);
    //     condition.clickWhenClickable(EstimatePaths.editBtn);
    //     addEstimate(currencyCode, product);
    // }

    private void goToEstimateModule(){
        try {
            condition.clickWhenClickable(EstimatePaths.rightArrow);
            condition.clickWhenClickable(EstimatePaths.billingMenu);
            condition.clickWhenClickable(EstimatePaths.estimateModule);
            condition.clickWhenClickable(EstimatePaths.addNewEstimate);
        }catch(ElementClickInterceptedException e){
            condition.waitUntilInvisible(EstimatePaths.interferingElement);
            condition.clickWhenClickable(EstimatePaths.estimateModule);
            condition.clickWhenClickable(EstimatePaths.addNewEstimate);
        }catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    private void addEstimate(String currencyCode, String product){
        try{
            condition.clickWhenClickable(EstimatePaths.currencyCode);
            condition.clickWhenClickable(EstimatePaths.selectCurrencyCode.get(currencyCode));
            condition.clickWhenClickable(EstimatePaths.estimateItems);
            condition.sendKeysWhenVisible(EstimatePaths.product, product, Keys.ENTER);
            condition.clickWhenClickable(EstimatePaths.saveBtn);
        }catch (StaleElementReferenceException e) {
            goToEstimateModule();
        }
        catch(TimeoutException e){
            e.printStackTrace();
        }
    }
}