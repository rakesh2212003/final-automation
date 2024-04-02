package modules.auth;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import conditions.Condition;
import paths.auth.AuthPaths;

public class Auth{
    Condition condition;

    public Auth(WebDriver driver){
        condition = new Condition(driver);
    }

    public void login(String username, String password){
        handleLogin(username, password);
        handleProceed();
    }
    public void logout(){
        try{
            condition.clickWhenClickable(AuthPaths.profilePic);
            condition.clickWhenClickable(AuthPaths.logoutBtn);
        }catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    private void handleLogin(String username, String password){
        try{
            condition.sendKeysWhenVisible(AuthPaths.username, username, Keys.ENTER);
            condition.sendKeysWhenVisible(AuthPaths.password, password, Keys.ENTER);
        }catch(TimeoutException e){
            e.getStackTrace();
        }
    }
    private void handleProceed(){
        try{
            condition.clickWhenClickable(AuthPaths.proceed);
        }catch(TimeoutException e){
            e.getStackTrace();
        }
    }
}