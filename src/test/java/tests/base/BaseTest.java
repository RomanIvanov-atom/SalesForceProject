package tests.base;

import pages.LoginPage;
import pages.NewAccountModal;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import tests.TestListener;
import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected NewAccountModal newAccountModal;
    protected LoginPage loginPage;

    @Parameters({"browser"})
    @BeforeMethod
    @Description("Открытие браузера")
    public void setup(@Optional("chrome") String browser, ITestContext context) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        loginPage = new LoginPage(driver);
        newAccountModal = new NewAccountModal(driver);
    }

    @AfterMethod(alwaysRun = true)
    @Description("Закрытие бразуера")
    public void tearDown(ITestResult result) {
        driver.quit();
    }
}
