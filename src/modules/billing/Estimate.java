package modules.billing;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import conditions.Condition;
import paths.billing.EstimatePaths;

public class Estimate {
    private Condition condition;

    public Estimate(WebDriver driver){
        condition = new Condition(driver);
    }

    //create
    public void create(String currencyCode, String product){
        goToModule();
        addNew();
        add(currencyCode, product);
    }

    //view
    public void view(){
        try{
            goToModule();
            condition.clickWhenClickable(EstimatePaths.rowSetting);
            condition.clickWhenClickable(EstimatePaths.details);
        }
        catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    //edit
    public void edit(String currencyCode, String product){
        try{
            goToModule();
            condition.clickWhenClickable(EstimatePaths.rowSetting);
            condition.clickWhenClickable(EstimatePaths.edit);
            add(currencyCode, product);
        }
        catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    //delete
    public void delete(){
        try{
            goToModule();
            condition.clickWhenClickable(EstimatePaths.rowSetting);
            condition.clickWhenClickable(EstimatePaths.delete);
            condition.clickWhenClickable(EstimatePaths.yesBtn);
        }
        catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    private void goToModule(){
        try {
            Thread.sleep(1000);
            condition.waitUntilInvisible(EstimatePaths.interferingElement);
            condition.moveToElement(EstimatePaths.billingMenu);
            condition.clickWhenClickable(EstimatePaths.estimateModule);
            condition.clickWhenClickable(EstimatePaths.list);
        }
        catch(ElementClickInterceptedException e){
            condition.clickWhenClickable(EstimatePaths.list);
        }
        catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addNew(){
        try{
            condition.clickWhenClickable(EstimatePaths.newBtn);
        }catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    private void add(String currencyCode, String product){
        try{
            condition.clickWhenClickable(EstimatePaths.currencyCode);
            condition.clickWhenClickable(EstimatePaths.selectCurrencyCode.get(currencyCode));

            condition.clickWhenClickable(EstimatePaths.estimateItems);

            condition.clearWhenVisible(EstimatePaths.product);
            condition.sendKeysWhenVisible(EstimatePaths.product, product);
            Thread.sleep(1000);

            condition.clickWhenClickable(EstimatePaths.topProduct);
            condition.clickWhenClickable(EstimatePaths.saveBtn);
        }
        catch(TimeoutException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}