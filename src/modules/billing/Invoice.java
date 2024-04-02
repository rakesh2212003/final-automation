package modules.billing;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import conditions.Condition;
import paths.billing.InvoicePaths;

public class Invoice {
    private Condition condition;

    public Invoice(WebDriver driver){
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
            condition.clickWhenClickable(InvoicePaths.rowSetting);
            condition.clickWhenClickable(InvoicePaths.details);
        }
        catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    //edit
    public void edit(String currencyCode, String product){
        try{
            goToModule();
            condition.clickWhenClickable(InvoicePaths.rowSetting);
            condition.clickWhenClickable(InvoicePaths.edit);
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
            condition.clickWhenClickable(InvoicePaths.rowSetting);
            condition.clickWhenClickable(InvoicePaths.delete);
            condition.clickWhenClickable(InvoicePaths.yesBtn);
        }
        catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    private void goToModule(){
        try {
            Thread.sleep(1000);
            condition.waitUntilInvisible(InvoicePaths.interferingElement);
            condition.moveToElement(InvoicePaths.menu);
            condition.clickWhenClickable(InvoicePaths.module);
            Thread.sleep(1000);
            condition.clickWhenClickable(InvoicePaths.list);
        }
        catch(ElementClickInterceptedException e){
            condition.clickWhenClickable(InvoicePaths.list);
        }
        catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addNew(){
        try{
            condition.clickWhenClickable(InvoicePaths.newBtn);
        }catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    private void add(String currencyCode, String product){
        try{
            condition.clickWhenClickable(InvoicePaths.currencyCode);
            condition.clickWhenClickable(InvoicePaths.selectCurrencyCode.get(currencyCode));

            condition.clickWhenClickable(InvoicePaths.invoiceItems);

            condition.clearWhenVisible(InvoicePaths.product);
            condition.sendKeysWhenVisible(InvoicePaths.product, product);
            Thread.sleep(1000);

            condition.clickWhenClickable(InvoicePaths.topProduct);
            condition.clickWhenClickable(InvoicePaths.saveBtn);
        }
        catch(TimeoutException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}