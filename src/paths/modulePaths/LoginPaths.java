package paths.modulePaths;

import org.openqa.selenium.By;

public class LoginPaths{
    public By username = By.xpath("//input[@id='mat-input-0']");
    public By password = By.xpath("//input[@id='mat-input-1']");
    public By proceed = By.xpath("//a[contains(text(),'Proceed')]");
    public By profilePic = By.xpath("//div[contains(@class,'header-profileimg')]");
    public By logoutBtn = By.xpath("//span[contains(@class,'logout')]");
}