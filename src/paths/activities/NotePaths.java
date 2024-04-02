package paths.activities;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;

public class NotePaths {
    //menubar
    public static By menu = By.xpath("//span[contains(@class,'icons-activity')]");
    public static By module = By.xpath("//span[contains(text(),'Note')]/../..");
    public static By list = By.xpath("//a[contains(@href,'/notes')]");
    public static By addNew = By.xpath("//a[contains(@href,'/notes/create')]");

    //listingpage
    public static By interferingElement = By.xpath("//simple-snack-bar");
    public static By cancelPopup = By.xpath("//span[contains(@class,'mat-button-wrapper') and contains(text(),'x')]");
    public static By newBtn = By.xpath("//a[contains(@class,'pink-button')]/span[contains(text(),'New')]");
    public static By rowSetting = By.xpath("//tbody/tr[1]/td//div[contains(@class,'row-setting')]");
    public static By details = By.xpath("//a[contains(text(),'Details')]");
    public static By edit = By.xpath("//a[contains(text(),'Edit')]");
    public static By delete = By.xpath("//a[contains(text(),'Delete')]");
    public static By yesBtn = By.xpath("//span[contains(text(),'Yes')]");

    //createpage
    public static By modules = By.xpath("//mat-label[contains(text(),'Modules')]/../../..//mat-select");
    public static By relateTo = By.xpath("//mat-label[contains(text(),'Relate To')]/../../..//input");
    public static By status = By.xpath("//div[contains(text(),'Status')]/following-sibling::*[1]//mat-slide-toggle");
    public static By iframe = By.xpath("//iframe");
    public static By iframeBody = By.xpath("//body/p");
    public static Map<String, By> selectModules = new HashMap<>() {{
        put("User", By.xpath("//span[@class='mat-option-text' and contains(text(),'User')]"));
        put("Menu", By.xpath("//span[@class='mat-option-text' and contains(text(),'Menu')]"));
        put("Contact", By.xpath("//span[@class='mat-option-text' and contains(text(),'Contact')]"));
    }};
    public static Map<String, By> selectRelateTo = new HashMap<>() {{
        put("Rakesh Rana", By.xpath("//span[@class='mat-option-text' and contains(text(),'Rakesh Rana')]"));
        put("Mohammad Shakir", By.xpath("//span[@class='mat-option-text' and contains(text(),'Mohammad Shakir')]"));
    }};

    public static By saveBtn = By.xpath("//button[@type='submit']");
}
