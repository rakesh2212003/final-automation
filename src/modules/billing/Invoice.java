package modules.billing;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import paths.menuPaths.BillingPaths;
import paths.modulePaths.InvoicePaths;

public class Invoice {
    WebDriver driver;
    WebDriverWait wait;

    BillingPaths billingMenuPaths;
    InvoicePaths invoicePaths;

    public Invoice(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        billingMenuPaths = new BillingPaths();
        invoicePaths = new InvoicePaths();
    }

    public void createInvoice(String currencyCode, String product){
        goToInvoiceModule();
        addInvoice(currencyCode, product);
    }

    public void editInvoice(String currencyCode, String product){
        wait.until(ExpectedConditions.elementToBeClickable(invoicePaths.actionDrp)).click();
        wait.until(ExpectedConditions.elementToBeClickable(invoicePaths.editBtn)).click();
        addInvoice(currencyCode, product);
    }

    private void goToInvoiceModule(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(billingMenuPaths.billingMenu)).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(billingMenuPaths.invoiceModule)).click();
            wait.until(ExpectedConditions.elementToBeClickable(invoicePaths.list)).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(invoicePaths.newBtn)).click();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addInvoice(String currencyCode, String product){
        wait.until(ExpectedConditions.elementToBeClickable(invoicePaths.currencyCode)).click();
        wait.until(ExpectedConditions.elementToBeClickable(invoicePaths.selectCurrencyCode.get(currencyCode))).click();

        wait.until(ExpectedConditions.elementToBeClickable(invoicePaths.invoiceItems)).click();

        wait.until(ExpectedConditions.elementToBeClickable(invoicePaths.product)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(invoicePaths.product)).click();
        wait.until(ExpectedConditions.elementToBeClickable(invoicePaths.selectProduct.get(product))).click();

        wait.until(ExpectedConditions.elementToBeClickable(invoicePaths.saveBtn)).click();
    }

}