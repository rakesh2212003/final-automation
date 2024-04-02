package paths.billing;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;

public class ProductPaths {
    //menubar
    public static By billingMenu = By.xpath("//span[contains(@class,'ico_billing')]");
    public static By productModule = By.xpath("//span[contains(text(),'Product')]");
    public static By list = By.xpath("//a[contains(@href,'/products')]");
    public static By addNewProduct = By.xpath("//a[contains(@href,'/products/create')]");

    //listingpage
    public static By interferingElement = By.xpath("//simple-snack-bar");
    public static By cancelPopup = By.xpath("//span[contains(@class,'mat-button-wrapper') and contains(text(),'x')]");
    public static By newBtn = By.xpath("//a[contains(@class,'pink-button')]/span[contains(text(),'New')]");
    public static By rowSetting = By.xpath("//tbody/tr[1]/td//div[contains(@class,'row-setting')]");
    public static By details = By.xpath("//a[contains(text(),'Details')]");
    public static By edit = By.xpath("//a[contains(text(),'Edit')]");
    public static By delete = By.xpath("//a[contains(text(),'Delete')]");

    //createpage
    public static By productName = By.xpath("//mat-label[contains(text(),'Name')]/../../..//input");
    public static By productCode = By.xpath("//mat-label[contains(text(),'Product Code')]/../../..//input");
    public static By productType = By.xpath("//mat-label[contains(text(),'Type')]/../../..//mat-select");
    public static By productCategory = By.xpath("//mat-label[contains(text(),'Category')]/../../..//mat-select");
    public static By CurrencyCode = By.xpath("//mat-label[contains(text(),'Currency Code')]/../../..//mat-select");
    public static By productPrice = By.xpath("//mat-label[contains(text(),'Standard Price')]/../../..//input");
    public static By vendorName = By.xpath("//mat-label[contains(text(),'Vendor')]/../../..//input");
    public static By manufacturer = By.xpath("//mat-label[contains(text(),'Manufacturer')]/../../..//input");
    public static By isTaxable = By.xpath("//div[contains(text(),'Taxable')]/following-sibling::*[1]//mat-slide-toggle");
    public static By status = By.xpath("//div[contains(text(),'Status')]/following-sibling::*[1]//mat-slide-toggle");
    public static By description = By.xpath("//mat-label[contains(text(),'Description')]/../../..//textarea");
    public static By saveBtn = By.xpath("//button[@type='submit']");
    public static Map<String, By> selectProductType = new HashMap<>() {{
        put("Product", By.xpath("//span[@class='mat-option-text' and contains(text(),'Product')]"));
        put("Service", By.xpath("//span[@class='mat-option-text' and contains(text(),'Service')]"));
    }};
    public static Map<String, By> selectProductCategory = new HashMap<>(){{
        put("Hardware", By.xpath("//span[@class='mat-option-text' and contains(text(),'Hardware')]"));
        put("Final Product", By.xpath("//span[@class='mat-option-text' and contains(text(),'Final Product')]"));
        put("Professional Services", By.xpath("//span[@class='mat-option-text' and contains(text(),'Professional Services')]"));
        put("Semi-finished Goods", By.xpath("//span[@class='mat-option-text' and contains(text(),'Semi-finished Goods')]"));
        put("Software", By.xpath("//span[@class='mat-option-text' and contains(text(),'Software')]"));
    }};
    public static Map<String, By> selectCurrencyCode = new HashMap<>(){{
        put("INR", By.xpath("//span[@class='mat-option-text' and contains(text(),'Indian Rupee')]"));
        put("USD", By.xpath("//span[@class='mat-option-text' and contains(text(),'US Dollar')]"));
    }};

    //detailspage
    public static By actionDrp = By.xpath("//div[contains(@class,'actionDropdown-list-box')]");
    public static By editBtn = By.xpath("//a[contains(text(),'Edit')]");
    public static By deleteBtn = By.xpath("//a[contains(text(),'Delete')]");
    public static By yesBtn = By.xpath("//span[contains(text(),'Yes')]");
}