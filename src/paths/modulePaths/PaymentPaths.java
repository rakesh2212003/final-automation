package paths.modulePaths;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;

public class PaymentPaths {
    public By list = By.xpath("//a[@href='/payments']//span[contains(text(),'List')]");
    public By newBtn = By.xpath("//a[contains(@class,'pink-button')]");
    public By transactionId = By.xpath("//mat-label[contains(text(),'Transaction ID')]/../../..//input");

    public By CurrencyCode = By.xpath("//mat-label[contains(text(),'Currency Code')]/../../..//mat-select");
    public Map<String, By> selectCurrencyCode = new HashMap<>(){{
        put("INR", By.xpath("//span[@class='mat-option-text' and contains(text(),'Indian Rupee')]"));
        put("USD", By.xpath("//span[@class='mat-option-text' and contains(text(),'US Dollar')]"));
    }};

    public By amount = By.xpath("//mat-label[contains(text(),'Amount')]/../../..//input");

    public By paymentType = By.xpath("//mat-label[contains(text(),'Payment Type')]/../../..//mat-select");
    public Map<String, By> selectPaymentType = new HashMap<>(){{
        put("cash", By.xpath("//span[@class='mat-option-text' and contains(text(),'Cash')]"));
        put("check", By.xpath("//span[@class='mat-option-text' and contains(text(),'Check')]"));
    }};

    public By saveBtn = By.xpath("//button[@type='submit']");

    //Actions
    public By actionDrp = By.xpath("//div[contains(@class,'actionDropdown-list-box')]");
    public By editBtn = By.xpath("//a[contains(text(),'Edit')]");
    public By deleteBtn = By.xpath("//a[contains(text(),'Delete')]");
    public By yesBtn = By.xpath("//span[contains(text(),'Yes')]");
}
