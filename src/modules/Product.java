package modules;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import conditions.Condition;
import paths.menuPaths.BillingPaths;
import paths.modulePaths.ProductPaths;

public class Product {
    WebDriver driver;
    WebDriverWait wait;

    Condition condition;
    BillingPaths billingMenuPaths;
    ProductPaths productsModulePaths;

    public Product(WebDriver driver){
        condition = new Condition(driver);
        billingMenuPaths = new BillingPaths();
        productsModulePaths = new ProductPaths();
    }

    public void createProduct(String productName, String productCode, String productType, String productCategory, String currencyCode, String productPrice, String vendorName, String manufacturer, String isTaxable, String status, String description){
        try{
            goToProductsModule();
            addProduct(productName, productCode, productType, productCategory, currencyCode, productPrice, vendorName, manufacturer, isTaxable, status, description);
        }catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    public void editProduct(String productName, String productCode, String productType, String productCategory, String currencyCode, String productPrice, String vendorName, String manufacturer, String isTaxable, String status, String description){
        try{
            condition.clickWhenClickable(productsModulePaths.actionDrp);
            condition.clickWhenClickable(productsModulePaths.editBtn);
            addProduct(productName, productCode, productType, productCategory, currencyCode, productPrice, vendorName, manufacturer, isTaxable, status, description);
        }catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    public void deleteProduct(){
        try{
            condition.clickWhenClickable(productsModulePaths.actionDrp);
            condition.clickWhenClickable(productsModulePaths.deleteBtn);
            condition.clickWhenClickable(productsModulePaths.yesBtn);
        }catch(TimeoutException e){
            e.getStackTrace();
        }
    }

    private void goToProductsModule(){
        try {
            condition.moveToElement(billingMenuPaths.billingMenu);
            condition.clickWhenClickable(billingMenuPaths.productModule);
            condition.clickWhenClickable(productsModulePaths.list);
            condition.clickWhenClickable(productsModulePaths.newBtn);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    private void addProduct(String productName, String productCode, String productType, String productCategory, String currencyCode, String productPrice, String vendorName, String manufacturer, String isTaxable, String status, String description){
        condition.clearWhenVisible(productsModulePaths.productName);
        condition.sendKeysWhenVisible(productsModulePaths.productName, productName);

        condition.clearWhenVisible(productsModulePaths.productCode);
        condition.sendKeysWhenVisible(productsModulePaths.productCode, productCode);

        condition.clickWhenClickable(productsModulePaths.productType);
        condition.clickWhenClickable(productsModulePaths.selectProductType.get(productType));

        condition.clickWhenClickable(productsModulePaths.productCategory);
        condition.clickWhenClickable(productsModulePaths.selectProductCategory.get(productCategory));

        condition.clickWhenClickable(productsModulePaths.CurrencyCode);
        condition.clickWhenClickable(productsModulePaths.selectCurrencyCode.get(currencyCode));

        condition.clearWhenVisible(productsModulePaths.productPrice);
        condition.sendKeysWhenVisible(productsModulePaths.productPrice, productPrice);

        condition.clearWhenVisible(productsModulePaths.vendorName);
        condition.sendKeysWhenVisible(productsModulePaths.vendorName, vendorName);

        condition.clearWhenVisible(productsModulePaths.manufacturer);
        condition.sendKeysWhenVisible(productsModulePaths.manufacturer, manufacturer);

        if(isTaxable == "NO"){
            condition.clickWhenClickable(productsModulePaths.isTaxable);
        }

        if(status == "INACTIVE"){
            condition.clickWhenClickable(productsModulePaths.status);
        }

        condition.clearWhenVisible(productsModulePaths.description);
        condition.sendKeysWhenVisible(productsModulePaths.description, description);

        condition.clickWhenClickable(productsModulePaths.saveBtn);
    }
}
