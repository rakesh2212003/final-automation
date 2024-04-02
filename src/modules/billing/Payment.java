package modules.billing;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import paths.menuPaths.BillingPaths;
import paths.modulePaths.PaymentPaths;

public class Payment {
    WebDriver driver;
    WebDriverWait wait;

    BillingPaths billingMenuPaths;
    PaymentPaths paymentPaths;

    public Payment(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        billingMenuPaths = new BillingPaths();
        paymentPaths = new PaymentPaths();
    }

    public void createPayment(String transactionId, String currencyCode, String amount, String paymentType){
        goToPaymentModule();
        addPayment(transactionId, currencyCode, amount, paymentType);
    }

    public void editPayment(String transactionId, String currencyCode, String amount, String paymentType){
        wait.until(ExpectedConditions.elementToBeClickable(paymentPaths.actionDrp)).click();
        wait.until(ExpectedConditions.elementToBeClickable(paymentPaths.editBtn)).click();
        addPayment(transactionId, currencyCode, amount, paymentType);
    }

    private void goToPaymentModule(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(billingMenuPaths.billingMenu)).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(billingMenuPaths.paymentModule)).click();
            wait.until(ExpectedConditions.elementToBeClickable(paymentPaths.list)).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(paymentPaths.newBtn)).click();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addPayment(String transactionId, String currencyCode, String amount, String paymentType){
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentPaths.transactionId)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentPaths.transactionId)).sendKeys(transactionId);

        wait.until(ExpectedConditions.elementToBeClickable(paymentPaths.CurrencyCode)).click();
        wait.until(ExpectedConditions.elementToBeClickable(paymentPaths.selectCurrencyCode.get(currencyCode))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentPaths.amount)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentPaths.amount)).sendKeys(amount);

        wait.until(ExpectedConditions.elementToBeClickable(paymentPaths.paymentType)).click();
        wait.until(ExpectedConditions.elementToBeClickable(paymentPaths.selectPaymentType.get(paymentType))).click();

        wait.until(ExpectedConditions.elementToBeClickable(paymentPaths.saveBtn)).click();
    }
}
