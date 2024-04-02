package paths.billing;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;

public class InvoicePaths {
    //menubar
    public static By interferingElement = By.xpath("//simple-snack-bar");
    public static By menu = By.xpath("//span[contains(@class,'ico_billing')]");
    public static By module = By.xpath("//span[contains(text(),'Invoice')]/../..");
    public static By list = By.xpath("//a[contains(@href,'/invoices')]");
    public static By addNew = By.xpath("//a[contains(@href,'/invoices/create')]");

    //listingpage
    public static By newBtn = By.xpath("//a[contains(@class,'pink-button')]/span[contains(text(),'New')]");
    public static By rowSetting = By.xpath("//tbody/tr[1]/td//div[contains(@class,'row-setting')]");
    public static By details = By.xpath("//a[contains(text(),'Details')]");
    public static By edit = By.xpath("//a[contains(text(),'Edit')]");
    public static By delete = By.xpath("//a[contains(text(),'Delete')]");

    //createpage
    public static By currencyCode = By.xpath("//mat-label[contains(text(),'Currency Code')]/../../..//mat-select");
    public static By invoiceItems = By.xpath("//div[contains(text(),'Invoice Items')]");
    public static By product = By.xpath("//mat-label[contains(text(),'Select Product')]/../../../input");
    public static By topProduct = By.xpath("//mat-option[1]/span[contains(@class,'mat-option-text')]");
    public static Map<String, By> selectCurrencyCode = new HashMap<>(){{
        put("INR", By.xpath("//span[@class='mat-option-text' and contains(text(),'INR')]"));
        put("USD", By.xpath("//span[@class='mat-option-text' and contains(text(),'USD')]"));
        put("GBP", By.xpath("//span[@class='mat-option-text' and contains(text(),'GBP')]"));
    }};
    public static Map<String, By> selectProduct = new HashMap<>(){{
        put("clk-clk", By.xpath("//span[@class='mat-option-text' and contains(text(),'clk-clk')]"));
        put("convergehub", By.xpath("//span[@class='mat-option-text' and contains(text(),'convergehub')]"));
    }};
    
    public static By saveBtn = By.xpath("//button[@type='submit']");

    //Actions
    public static By actionDrp = By.xpath("//div[contains(@class,'actionDropdown-list-box')]");
    public static By editBtn = By.xpath("//a[contains(text(),'Edit')]");
    public static By deleteBtn = By.xpath("//a[contains(text(),'Delete')]");
    public static By yesBtn = By.xpath("//span[contains(text(),'Yes')]");
}
