package modules.activities;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import conditions.Condition;
import paths.activities.NotePaths;

public class Notes{
    private Condition condition;

    public Notes(WebDriver driver){
        condition = new Condition(driver);
    }

    //create
    public void create(String modules, String relateTo, String notes){
        goToModule();
        addNew();
        add(modules, relateTo, notes);
    }

    //view
    public void view(){
        try{
            goToModule();
            condition.clickWhenClickable(NotePaths.rowSetting);
            condition.clickWhenClickable(NotePaths.details);
        }
        catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    //edit
    public void edit(String modules, String relateTo, String notes){
        try{
            goToModule();
            condition.clickWhenClickable(NotePaths.rowSetting);
            condition.clickWhenClickable(NotePaths.edit);

            condition.clickWhenClickable(NotePaths.modules);
            condition.clickWhenClickable(NotePaths.selectModules.get(modules));

            condition.switchToIframe(NotePaths.iframe);
            Thread.sleep(1000);
            condition.sendKeysWhenVisible(NotePaths.iframeBody, notes);
            condition.switchFromIframe();
        }
        catch(TimeoutException | InterruptedException e){
            e.getStackTrace();
        }
    }

    //delete
    public void delete(){
        try{
            goToModule();
            condition.clickWhenClickable(NotePaths.rowSetting);
            condition.clickWhenClickable(NotePaths.delete);
            condition.clickWhenClickable(NotePaths.yesBtn);
        }
        catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    private void goToModule(){
        try {
            Thread.sleep(1000);
            condition.waitUntilInvisible(NotePaths.interferingElement);
            condition.moveToElement(NotePaths.menu);
            Thread.sleep(1000);
            condition.clickWhenClickable(NotePaths.module);
            condition.clickWhenClickable(NotePaths.list);
        }
        catch(ElementClickInterceptedException e){
            condition.clickWhenClickable(NotePaths.module);
            condition.clickWhenClickable(NotePaths.list);
        }
        catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addNew(){
        try{
            condition.clickWhenClickable(NotePaths.newBtn);
        }catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    private void add(String modules, String relateTo, String notes){
        try{
            condition.clickWhenClickable(NotePaths.modules);
            condition.clickWhenClickable(NotePaths.selectModules.get(modules));

            condition.clickWhenClickable(NotePaths.relateTo);
            Thread.sleep(1000);
            condition.clickWhenClickable(NotePaths.selectRelateTo.get(relateTo));

            condition.switchToIframe(NotePaths.iframe);
            condition.sendKeysWhenVisible(NotePaths.iframeBody, notes);
            condition.switchFromIframe();

            condition.clickWhenClickable(NotePaths.saveBtn);
        }
        catch(TimeoutException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
