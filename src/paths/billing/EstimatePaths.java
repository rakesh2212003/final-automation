package paths.billing;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;

public class EstimatePaths {
    //menubar
    public static By interferingElement = By.xpath("//simple-snack-bar");
    public static By billingMenu = By.xpath("//span[contains(@class,'ico_billing')]");
    public static By estimateModule = By.xpath("//span[contains(text(),'Estimate')]");
    public static By list = By.xpath("//a[contains(@href,'/estimates')]");
    public static By addNewEstimate = By.xpath("//a[contains(@href,'/estimates/create')]");

    //listingpage
    public static By newBtn = By.xpath("//a[contains(@class,'pink-button')]/span[contains(text(),'New')]");
    public static By rowSetting = By.xpath("//tbody/tr[1]/td//div[contains(@class,'row-setting')]");
    public static By details = By.xpath("//a[contains(text(),'Details')]");
    public static By edit = By.xpath("//a[contains(text(),'Edit')]");
    public static By delete = By.xpath("//a[contains(text(),'Delete')]");

    //createpage
    public static By currencyCode = By.xpath("//mat-label[contains(text(),'Currency Code')]/../../..//mat-select");
    public static By estimateItems = By.xpath("//div[contains(text(),'Estimate Items')]");
    public static By product = By.xpath("//mat-label[contains(text(),'Select Product')]/../../../input");
    public static By topProduct = By.xpath("//mat-option[1]/span[contains(@class,'mat-option-text')]");
    public static By saveBtn = By.xpath("//button[@type='submit']");
    public static Map<String, By> selectCurrencyCode = new HashMap<>(){{
        put("INR", By.xpath("//span[@class='mat-option-text' and contains(text(),'INR')]"));
        put("USD", By.xpath("//span[@class='mat-option-text' and contains(text(),'USD')]"));
        put("GBP", By.xpath("//span[@class='mat-option-text' and contains(text(),'GBP')]"));
    }};

    //detailspage
    public static By actionDrp = By.xpath("//div[contains(@class,'actionDropdown-list-box')]");
    public static By editBtn = By.xpath("//a[contains(text(),'Edit')]");
    public static By deleteBtn = By.xpath("//a[contains(text(),'Delete')]");
    public static By yesBtn = By.xpath("//span[contains(text(),'Yes')]");

}
