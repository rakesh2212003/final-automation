package paths.auth;

import org.openqa.selenium.By;

public class AuthPaths{
    //login
    public static By username = By.xpath("//input[@id='mat-input-0']");
    public static By password = By.xpath("//input[@id='mat-input-1']");
    public static By proceed = By.xpath("//a[contains(text(),'Proceed')]");

    //logout
    public static By profilePic = By.xpath("//div[contains(@class,'header-profileimg')]");
    public static By logoutBtn = By.xpath("//span[contains(@class,'logout')]");
}