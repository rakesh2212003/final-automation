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
        testAuth.login("RakeshRana", "123456");
    }

    @Test
    public void TEST_PRODUCT(){
        testProducts.create(
            "ConvergeHub",
            "000001",
            "Product",
            "Software",
            "USD",
            "99999",
            "Ranjan Jana",
            "Ranjan LLC.",
            "YES",
            "ACTIVE",
            "This product is made by team Corelynx"
        );
        testProducts.edit(
            "CLKCLK",
            "000001",
            "Product",
            "Software",
            "INR",
            "8888",
            "MD Shakir",
            "Shakir LLC.",
            "YES",
            "ACTIVE",
            "This product is made by team Corelynx"
        );
        testProducts.delete();
    }

    @Test
    public void TEST_ESTIMATE(){
        testProducts.create(
            "ConvergeHub",
            "000001",
            "Product",
            "Software",
            "USD",
            "99999",
            "Ranjan Jana",
            "Ranjan LLC.",
            "YES",
            "ACTIVE",
            "This product is made by team Corelynx"
        );
        testEstimate.create("USD", "OOO");
        testEstimate.edit("INR", "XXX");
        testEstimate.delete();
    }

    @Test
    public void TEST_INVIOCE(){
        testProducts.create(
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
        testEstimate.create("USD", "CPM");
        testInvoice.create("INR", "CPM");
        testInvoice.edit("USD", "XXX");
        testInvoice.delete();
    }

    @Test
    public void TEST_PAYMENT(){
        testProducts.create(
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
        testEstimate.create("USD", "CPM");
        testInvoice.create("INR", "CPM");
        testPayment.create("1234567890", "INR", "800", "Cash");
        testPayment.edit("9876543210", "INR", "900", "Check");
        testPayment.delete();
    }

    @Test
    public void TEST_NOTES(){
        testNotes.create("User", "Rakesh Rana", "This is my note");
        testNotes.edit("User", "Rakesh Rana", "This is edited note");
        testNotes.delete();
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