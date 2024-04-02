import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import modules.activities.Notes;
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
    private Notes testNotes;

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
        testInvoice = new Invoice(driver);
        testPayment = new Payment(driver);
        testNotes = new Notes(driver);
    }

    @BeforeClass
    public void TEST_AUTH(){
        testAuth.performLogin("RakeshRana", "123456");
    }

    @Test
    public void TEST_PRODUCT(){
        testProducts.createProduct(
            "FFF",
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
            "SSS",
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
        testProducts.deleteProduct();
    }

    @Test
    public void TEST_ESTIMATE(){
        testProducts.createProduct(
            "OOO",
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
        testEstimate.createEstimate("USD", "OOO");
        testEstimate.editEstimate("INR", "XXX");
        testEstimate.deleteEstimate();
        testProducts.deleteProduct();
    }

    @Test
    public void TEST_INVIOCE(){
        testProducts.createProduct(
            "CPM",
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
        testEstimate.createEstimate("USD", "CPM");
        testInvoice.createInvoice("INR", "CPM");
        testInvoice.editInvoice("USD", "XXX");
        testInvoice.deleteInvoice();
        testProducts.deleteProduct();
        testEstimate.deleteEstimate();
    }

    @Test
    public void TEST_PAYMENT(){
        testProducts.createProduct(
            "CPM",
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
        testEstimate.createEstimate("USD", "CPM");
        testInvoice.createInvoice("INR", "CPM");
        testPayment.create("1234567890", "INR", "800", "Cash");
        testPayment.edit("9876543210", "INR", "900", "Check");
        
        testPayment.delete();
        testProducts.deleteProduct();
        testEstimate.deleteEstimate();
        testInvoice.deleteInvoice();
    }

    @Test
    public void TEST_NOTES(){
        testNotes.createNote("User", "Rakesh Rana", "This is my note");
        testNotes.editNote("User", "Rakesh Rana", "This is edited note");
        testNotes.deleteNote();
    }

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