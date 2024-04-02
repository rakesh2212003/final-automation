package modules.billing;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import conditions.Condition;
import paths.modulePaths.ProductPaths;

public class Product {
    private Condition condition;

    public Product(WebDriver driver){
        condition = new Condition(driver);
    }

    public void createProduct(String productName, String productCode, String productType, String productCategory, String currencyCode, String productPrice, String vendorName, String manufacturer, String isTaxable, String status, String description){
        goToProductModule();
        addProduct(productName, productCode, productType, productCategory, currencyCode, productPrice, vendorName, manufacturer, isTaxable, status, description);
    }
    
    public void editProduct(String productName, String productCode, String productType, String productCategory, String currencyCode, String productPrice, String vendorName, String manufacturer, String isTaxable, String status, String description){
        try{
            condition.clickWhenClickable(ProductPaths.actionDrp);
            condition.clickWhenClickable(ProductPaths.editBtn);
            addProduct(productName, productCode, productType, productCategory, currencyCode, productPrice, vendorName, manufacturer, isTaxable, status, description);
        }catch (StaleElementReferenceException e) {
            editProduct(productName, productCode, productType, productCategory, currencyCode, productPrice, vendorName, manufacturer, isTaxable, status, description);
        }
        catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    // public void deleteProduct(){
    //     try{
    //         condition.clickWhenClickable(ProductPaths.actionDrp);
    //         condition.clickWhenClickable(ProductPaths.deleteBtn);
    //         condition.clickWhenClickable(ProductPaths.yesBtn);
    //     }catch(TimeoutException e){
    //         e.getStackTrace();
    //     }
    // }

    private void goToProductModule(){
        try {
            condition.clickWhenClickable(ProductPaths.rightArrow);
            condition.clickWhenClickable(ProductPaths.billingMenu);
            condition.clickWhenClickable(ProductPaths.addNewProduct);
        }catch (StaleElementReferenceException e) {
            goToProductModule();
        }
        catch (TimeoutException e) {
            e.printStackTrace();
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

        }catch (StaleElementReferenceException e) {
            addProduct(productName, productCode, productType, productCategory, currencyCode, productPrice, vendorName, manufacturer, isTaxable, status, description);
        }catch (TimeoutException e) {
            e.getStackTrace();
        }
    }
}
