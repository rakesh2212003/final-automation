import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import modules.auth.*;
import modules.billing.*;

public class App {
    private ChromeOptions options;
    private WebDriver driver;

    private Auth testAuth;
    private Product testProducts;
    private Estimate testEstimate;
    private Invoice testInvoice;
    private Payment testPayment;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get("https://stage.convergehub.app/auth/login");

        testAuth = new Auth(driver);
        testProducts = new Product(driver);
    }

    @Test
    public void test1(){
        testAuth.performLogin("RakeshRana", "123456");
        // testAuth.performLogout();
    }

    @Test
    public void test2(){
        testProducts.createProduct(
            "abcd",
            "000002",
            "Product",
            "Software",
            "USD",
            "9876",
            "Ranjan Jana",
            "Ranjan LLC.",
            "YES",
            "ACTIVE",
            "This product is made by team Corelynx"
        );
        testProducts.editProduct(
            "xyz",
            "000001",
            "Product",
            "Software",
            "INR",
            "250",
            "Rakesh Jana",
            "Rakesh LLC.",
            "YES",
            "ACTIVE",
            "This product is made by team Corelynx"
        );
    }

    // @Test
    // public void test3(){
    // testEstimate = new Estimate(driver);
    // testEstimate.createEstimate("INR", "www");
    // // testEstimate.editEstimate("USD", "convergehub");
    // }

    // @Test
    // public void test4(){
    // testInvoice = new Invoice(driver);
    // testInvoice.createInvoice("INR", "convergehub");
    // // testInvoice.editInvoice("USD", "convergehub");
    // }

    // @Test
    // public void test5(){
    // testPayment = new Payment(driver);
    // testPayment.createPayment("1234567890", "INR", "9999", "cash");
    // testPayment.editPayment("9876543210", "INR", "8888", "check");
    // }

    @AfterMethod
    public void slepeMethod() throws InterruptedException {
        Thread.sleep(1000);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}