package paths.modulePaths;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;

public class ProductPaths {
    public By list = By.xpath("//a[@href='/products']//span[contains(text(),'List')]");
    public By newBtn = By.xpath("//a//span[contains(text(),'New')]");
    public By productName = By.xpath("//mat-label[contains(text(),'Name')]/../../..//input");
    public By productCode = By.xpath("//mat-label[contains(text(),'Product Code')]/../../..//input");

    public By productType = By.xpath("//mat-label[contains(text(),'Type')]/../../..//mat-select");
    public Map<String, By> selectProductType = new HashMap<>() {{
        put("Product", By.xpath("//span[@class='mat-option-text' and contains(text(),'Product')]"));
        put("Service", By.xpath("//span[@class='mat-option-text' and contains(text(),'Service')]"));
    }};

    public By productCategory = By.xpath("//mat-label[contains(text(),'Category')]/../../..//mat-select");
    public Map<String, By> selectProductCategory = new HashMap<>(){{
        put("Hardware", By.xpath("//span[@class='mat-option-text' and contains(text(),'Hardware')]"));
        put("Final Product", By.xpath("//span[@class='mat-option-text' and contains(text(),'Final Product')]"));
        put("Professional Services", By.xpath("//span[@class='mat-option-text' and contains(text(),'Professional Services')]"));
        put("Semi-finished Goods", By.xpath("//span[@class='mat-option-text' and contains(text(),'Semi-finished Goods')]"));
        put("Software", By.xpath("//span[@class='mat-option-text' and contains(text(),'Software')]"));
    }};

    public By CurrencyCode = By.xpath("//mat-label[contains(text(),'Currency Code')]/../../..//mat-select");
    public Map<String, By> selectCurrencyCode = new HashMap<>(){{
        put("INR", By.xpath("//span[@class='mat-option-text' and contains(text(),'Indian Rupee')]"));
        put("USD", By.xpath("//span[@class='mat-option-text' and contains(text(),'US Dollar')]"));
    }};

    public By productPrice = By.xpath("//mat-label[contains(text(),'Standard Price')]/../../..//input");
    public By vendorName = By.xpath("//mat-label[contains(text(),'Vendor')]/../../..//input");
    public By manufacturer = By.xpath("//mat-label[contains(text(),'Manufacturer')]/../../..//input");
    public By isTaxable = By.xpath("//div[contains(text(),'Taxable')]/following-sibling::*[1]//mat-slide-toggle");
    public By status = By.xpath("//div[contains(text(),'Status')]/following-sibling::*[1]//mat-slide-toggle");
    public By description = By.xpath("//mat-label[contains(text(),'Description')]/../../..//textarea");

    public By saveBtn = By.xpath("//button[@type='submit']");

    // Action
    public By actionDrp = By.xpath("//div[contains(@class,'actionDropdown-list-box')]");
    public By editBtn = By.xpath("//a[contains(text(),'Edit')]");
    public By deleteBtn = By.xpath("//a[contains(text(),'Delete')]");
    public By yesBtn = By.xpath("//span[contains(text(),'Yes')]");
}