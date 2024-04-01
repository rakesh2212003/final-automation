package modules;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import conditions.Condition;
import paths.modulePaths.LoginPaths;

public class Auth{
    Condition condition;
    LoginPaths loginPath;

    public Auth(WebDriver driver){
        condition = new Condition(driver);
        loginPath = new LoginPaths();
    }

    public void performLogin(String username, String password){
        handleLogin(username, password);
        handleProceed();
    }

    public void performLogout(){
        try{
            condition.clickWhenClickable(loginPath.profilePic);
            condition.clickWhenClickable(loginPath.logoutBtn);
        }catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    private void handleLogin(String username, String password){
        try{
            condition.sendKeysWhenVisible(loginPath.username, username, Keys.ENTER);
            condition.sendKeysWhenVisible(loginPath.password, password, Keys.ENTER);
        }catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    private void handleProceed(){
        try{
            condition.clickWhenClickable(loginPath.proceed);
        }catch(TimeoutException e){
            e.getStackTrace();
        }
    }
}