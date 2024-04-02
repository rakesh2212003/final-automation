package modules.billing;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import conditions.Condition;
import paths.billing.PaymentPaths;

public class Payment {
    private Condition condition;

    public Payment(WebDriver driver){
        condition = new Condition(driver);
    }

    //create
    public void create(String transactionId, String currencyCode, String amount, String paymentType){
        goToModule();
        addNew();
        add(transactionId, currencyCode, amount, paymentType);
    }

    //view
    public void view(){
        try{
            goToModule();
            condition.clickWhenClickable(PaymentPaths.rowSetting);
            condition.clickWhenClickable(PaymentPaths.details);
        }
        catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    //edit
    public void edit(String transactionId, String currencyCode, String amount, String paymentType){
        try{
            goToModule();
            condition.clickWhenClickable(PaymentPaths.rowSetting);
            condition.clickWhenClickable(PaymentPaths.edit);
            add(transactionId, currencyCode, amount, paymentType);
        }
        catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    //delete
    public void delete(){
        try{
            goToModule();
            condition.clickWhenClickable(PaymentPaths.rowSetting);
            condition.clickWhenClickable(PaymentPaths.delete);
            condition.clickWhenClickable(PaymentPaths.yesBtn);
        }
        catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    private void goToModule(){
        try {
            Thread.sleep(1000);
            condition.waitUntilInvisible(PaymentPaths.interferingElement);
            condition.moveToElement(PaymentPaths.menu);
            condition.clickWhenClickable(PaymentPaths.module);
            Thread.sleep(1000);
            condition.clickWhenClickable(PaymentPaths.list);
        }
        catch(ElementClickInterceptedException e){
            condition.clickWhenClickable(PaymentPaths.list);
        }
        catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addNew(){
        try{
            condition.clickWhenClickable(PaymentPaths.newBtn);
        }catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    private void add(String transactionId, String currencyCode, String amount, String paymentType){
        try{
            condition.clearWhenVisible(PaymentPaths.transactionId);
            condition.sendKeysWhenVisible(PaymentPaths.transactionId, transactionId);

            condition.clickWhenClickable(PaymentPaths.CurrencyCode);
            condition.clickWhenClickable(PaymentPaths.selectCurrencyCode.get(currencyCode));

            condition.clearWhenVisible(PaymentPaths.amount);
            condition.sendKeysWhenVisible(PaymentPaths.amount, amount);

            condition.clickWhenClickable(PaymentPaths.paymentType);
            condition.clickWhenClickable(PaymentPaths.selectPaymentType.get(paymentType));

            condition.clickWhenClickable(PaymentPaths.saveBtn);
        }
        catch(TimeoutException e){
            e.printStackTrace();
        }
    }
}
