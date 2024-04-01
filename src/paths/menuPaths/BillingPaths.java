package paths.menuPaths;

import org.openqa.selenium.By;

public class BillingPaths {
    public By billingMenu = By.xpath("//span[contains(@class,'ico_billing')]");
    public By productModule = By.xpath("//span[contains(text(),'Product')]");
    public By estimateModule = By.xpath("//span[contains(text(),'Estimate')]");
    public By invoiceModule = By.xpath("//span[contains(text(),'Invoice')]");
    public By paymentModule = By.xpath("//span[contains(text(),'Payment')]");
}
