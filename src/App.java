import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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
        testEstimate = new Estimate(driver);
    }

    @BeforeClass
    public void TEST_AUTH(){
        testAuth.performLogin("RakeshRana", "123456");
    }

    // @Test
    // public void TEST_PRODUCT(){
    //     testProducts.createProduct(
    //         "FFF",
    //         "000002",
    //         "Product",
    //         "Software",
    //         "USD",
    //         "9876",
    //         "Ranjan Jana",
    //         "Ranjan LLC.",
    //         "YES",
    //         "ACTIVE",
    //         "This product is made by team Corelynx"
    //     );
    //     testProducts.editProduct(
    //         "SSS",
    //         "000002",
    //         "Product",
    //         "Software",
    //         "USD",
    //         "9876",
    //         "Ranjan Jana",
    //         "Ranjan LLC.",
    //         "YES",
    //         "ACTIVE",
    //         "This product is made by team Corelynx"
    //     );
    //     testProducts.editProduct(
    //         "DDD",
    //         "000002",
    //         "Product",
    //         "Software",
    //         "USD",
    //         "9876",
    //         "Ranjan Jana",
    //         "Ranjan LLC.",
    //         "YES",
    //         "ACTIVE",
    //         "This product is made by team Corelynx"
    //     );
    //     testProducts.deleteProduct();
    // }

    // @Test
    // public void TEST_ESTIMATE(){
    //     testProducts.createProduct(
    //         "myProduct",
    //         "000001",
    //         "Product",
    //         "Software",
    //         "USD",
    //         "9999",
    //         "Ranjan Jana",
    //         "Ranjan LLC.",
    //         "YES",
    //         "ACTIVE",
    //         "This product is made by team Corelynx"
    //     );
    //     testEstimate.createEstimate("USD", "myProduct");
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
    public void tearDown() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }
}