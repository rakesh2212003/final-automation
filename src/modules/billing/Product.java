package modules.billing;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import conditions.Condition;
import paths.billing.ProductPaths;

public class Product {
    private Condition condition;

    public Product(WebDriver driver){
        condition = new Condition(driver);
    }

    //create
    public void createProduct(String productName, String productCode, String productType, String productCategory, String currencyCode, String productPrice, String vendorName, String manufacturer, String isTaxable, String status, String description){
        goToProductModule();
        addNew();
        addProduct(productName, productCode, productType, productCategory, currencyCode, productPrice, vendorName, manufacturer, isTaxable, status, description);
    }

    //view
    public void viewProduct(){
        try{
            goToProductModule();
            condition.clickWhenClickable(ProductPaths.rowSetting);
            condition.clickWhenClickable(ProductPaths.details);
        }
        catch(TimeoutException e){
            e.getStackTrace();
        }
    }
    
    //edit
    public void editProduct(String productName, String productCode, String productType, String productCategory, String currencyCode, String productPrice, String vendorName, String manufacturer, String isTaxable, String status, String description){
        try{
            goToProductModule();
            condition.clickWhenClickable(ProductPaths.rowSetting);
            condition.clickWhenClickable(ProductPaths.edit);
            addProduct(productName, productCode, productType, productCategory, currencyCode, productPrice, vendorName, manufacturer, isTaxable, status, description);
        }
        catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    //delete
    public void deleteProduct(){
        try{
            goToProductModule();
            condition.clickWhenClickable(ProductPaths.rowSetting);
            condition.clickWhenClickable(ProductPaths.delete);
            condition.clickWhenClickable(ProductPaths.yesBtn);
        }
        catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    private void goToProductModule(){
        try {
            Thread.sleep(1000);
            condition.waitUntilInvisible(ProductPaths.interferingElement);
            condition.moveToElement(ProductPaths.billingMenu);
            condition.clickWhenClickable(ProductPaths.list);
        }
        catch (TimeoutException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addNew(){
        try{
            condition.clickWhenClickable(ProductPaths.newBtn);
        }
        catch(ElementClickInterceptedException e){
            addNew();
        }
        catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    private void addProduct(String productName, String productCode, String productType, String productCategory, String currencyCode, String productPrice, String vendorName, String manufacturer, String isTaxable, String status, String description){
        try{
            condition.clearWhenVisible(ProductPaths.productName);
            condition.sendKeysWhenVisible(ProductPaths.productName, productName);
    
            condition.clearWhenVisible(ProductPaths.productCode);
            condition.sendKeysWhenVisible(ProductPaths.productCode, productCode);
    
            condition.clickWhenClickable(ProductPaths.productType);
            condition.clickWhenClickable(ProductPaths.selectProductType.get(productType));
    
            condition.clickWhenClickable(ProductPaths.productCategory);
            condition.clickWhenClickable(ProductPaths.selectProductCategory.get(productCategory));
    
            condition.clickWhenClickable(ProductPaths.CurrencyCode);
            condition.clickWhenClickable(ProductPaths.selectCurrencyCode.get(currencyCode));
    
            condition.clearWhenVisible(ProductPaths.productPrice);
            condition.sendKeysWhenVisible(ProductPaths.productPrice, productPrice);
    
            condition.clearWhenVisible(ProductPaths.vendorName);
            condition.sendKeysWhenVisible(ProductPaths.vendorName, vendorName);
    
            condition.clearWhenVisible(ProductPaths.manufacturer);
            condition.sendKeysWhenVisible(ProductPaths.manufacturer, manufacturer);
    
            if(isTaxable == "NO"){
                condition.clickWhenClickable(ProductPaths.isTaxable);
            }
    
            if(status == "INACTIVE"){
                condition.clickWhenClickable(ProductPaths.status);
            }
    
            condition.clearWhenVisible(ProductPaths.description);
            condition.sendKeysWhenVisible(ProductPaths.description, description);
    
            condition.clickWhenClickable(ProductPaths.saveBtn);

        }catch (TimeoutException e) {
            e.getStackTrace();
        }
    }
}