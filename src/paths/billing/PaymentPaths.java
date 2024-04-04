package paths.billing;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;

public interface PaymentPaths {
    //Popup
    // public static By popup = By.xpath("//simple-snack-bar");
    public static By popup = By.xpath("//span[contains(@class,'mat-button-wrapper') and contains(text(),'x')]");
    
    //Menu
    public static By menu = By.xpath("//span[contains(@class,'ico_billing')]");
    public static By module = By.xpath("//span[contains(text(),'Payment')]/../..");
    public static By list = By.xpath("//a[contains(@href,'/payments')]");
    public static By addNew = By.xpath("//a[contains(@href,'/payments/create')]");

    //Listing Page
    public static By newBtn = By.xpath("//a[contains(@class,'pink-button')]/span[contains(text(),'New')]");
    public static By rowSetting = By.xpath("//tbody/tr[1]/td//div[contains(@class,'row-setting')]");
    public static By details = By.xpath("//a[contains(text(),'Details')]");
    public static By edit = By.xpath("//a[contains(text(),'Edit')]");
    public static By delete = By.xpath("//a[contains(text(),'Delete')]");
    public static By yesBtn = By.xpath("//span[contains(text(),'Yes')]");
    public static By topRow = By.xpath("//mat-option[1]/span[contains(@class,'mat-option-text')]");

    //Details Page Action
    public static By actionDrp = By.xpath("//div[contains(@class,'actionDropdown-list-box')]");
    public static By editBtn = By.xpath("//a[contains(text(),'Edit')]");
    public static By deleteBtn = By.xpath("//a[contains(text(),'Delete')]");
    
    //Inputs
    public static By transactionIdInput = By.xpath("//mat-label[contains(text(),'Transaction ID')]/../../..//input");
    public static By amountInput = By.xpath("//mat-label[contains(text(),'Amount')]/../../..//input");
    public static By saveBtn = By.xpath("//button[@type='submit']");
    
    //Dropdowns
    public static By currencyCodeDrp = By.xpath("//mat-label[contains(text(),'Currency Code')]/../../..//mat-select");
    public static By paymentTypeDrp = By.xpath("//mat-label[contains(text(),'Payment Type')]/../../..//mat-select");
    public static Map<String, By> selectCurrencyCodeDrp = new HashMap<>(){{
        put("INR", By.xpath("//span[@class='mat-option-text' and contains(text(),'Indian Rupee')]"));
        put("USD", By.xpath("//span[@class='mat-option-text' and contains(text(),'US Dollar')]"));
    }};
    public static Map<String, By> selectPaymentTypeDrp = new HashMap<>(){{
        put("Cash", By.xpath("//span[@class='mat-option-text' and contains(text(),'Cash')]"));
        put("Check", By.xpath("//span[@class='mat-option-text' and contains(text(),'Check')]"));
    }};
}