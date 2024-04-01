import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import modules.*;

public class App{
    ChromeOptions options;
    WebDriver driver;

    Auth testAuth;
    Product testProducts;
    Estimate testEstimate;
    Invoice testInvoice;
    Payment testPayment;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get("https://stage.convergehub.app/auth/login");
    }
    
    @Test
    public void test1(){
        testAuth = new Auth(driver);
        testAuth.performLogin("RakeshRana", "123456");
    }
    
    @Test
    public void test2(){
        testProducts = new Product(driver);
        testProducts.createProduct("abcd", "000002", "Product", "Software", "USD", "9876", "Ranjan Jana", "Ranjan LLC.", "YES", "ACTIVE", "This product is made by team Corelynx");
        // testProducts.editProduct("clk-clk", "000001", "Product", "Software", "USD", "9876", "Ranjan Jana", "Ranjan LLC.", "YES", "ACTIVE", "This product is made by team Corelynx");
    }
    
    // @Test
    // public void test3(){
    //     testEstimate = new Estimate(driver);
    //     testEstimate.createEstimate("INR", "clk-clk");
    //     // testEstimate.editEstimate("USD", "convergehub");
    // }

    // @Test
    // public void test4(){
    //     testInvoice = new Invoice(driver);
    //     testInvoice.createInvoice("INR", "convergehub");
    //     // testInvoice.editInvoice("USD", "convergehub");
    // }

    // @Test
    // public void test5(){
    //     testPayment = new Payment(driver);
    //     testPayment.createPayment("1234567890", "INR", "9999", "cash");
    //     testPayment.editPayment("9876543210", "INR", "8888", "check");
    // }


    // @AfterTest
    // public void tearDown() throws InterruptedException{
    //     testAuth.performLogout();
    //     Thread.sleep(3000);
    //     driver.quit();
    // }
}