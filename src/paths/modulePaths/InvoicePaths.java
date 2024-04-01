package paths.modulePaths;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;

public class InvoicePaths {
    public By list = By.xpath("//a[@href='/invoices']//span[contains(text(),'List')]");
    public By newBtn = By.xpath("//a[contains(@class,'pink-button')]//span[contains(text(),'New')]");
    public By currencyCode = By.xpath("//mat-label[contains(text(),'Currency Code')]/../../..//mat-select");
    public Map<String, By> selectCurrencyCode = new HashMap<>(){{
        put("INR", By.xpath("//span[@class='mat-option-text' and contains(text(),'INR')]"));
        put("USD", By.xpath("//span[@class='mat-option-text' and contains(text(),'USD')]"));
        put("GBP", By.xpath("//span[@class='mat-option-text' and contains(text(),'GBP')]"));
    }};

    public By invoiceItems = By.xpath("//div[contains(text(),'Invoice Items')]");

    public By product = By.xpath("//mat-label[contains(text(),'Select Product')]/../../../input");
    public Map<String, By> selectProduct = new HashMap<>(){{
        put("clk-clk", By.xpath("//span[@class='mat-option-text' and contains(text(),'clk-clk')]"));
        put("convergehub", By.xpath("//span[@class='mat-option-text' and contains(text(),'convergehub')]"));
    }};

    public By saveBtn = By.xpath("//button[@type='submit']");

    //Actions
    public By actionDrp = By.xpath("//div[contains(@class,'actionDropdown-list-box')]");
    public By editBtn = By.xpath("//a[contains(text(),'Edit')]");
    public By deleteBtn = By.xpath("//a[contains(text(),'Delete')]");
    public By yesBtn = By.xpath("//span[contains(text(),'Yes')]");
}
