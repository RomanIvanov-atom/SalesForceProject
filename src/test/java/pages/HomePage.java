package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.base.BasePage;

import static constants.Constants.Urls.HOME_URL;

@Log4j2
public class HomePage extends BasePage {

    private static final By MENU_ACCOUNTS_OPTION = By.xpath("//span[text()='Accounts']" +
            "//ancestor::one-app-nav-bar-item-root[@role='listitem']");
    private static final By LOAD_HOME_PAGE_INDICATOR = By.xpath("//div[contains(@class,'ps-container')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOAD_HOME_PAGE_INDICATOR));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Home page don't open");
        }
        return this;
    }

    public HomePage open() {
        log.info("Open HomePage");
        driver.get(HOME_URL);
        return this;
    }

    public AccountsPage selectAccountsOption() {
        log.info("Select 'Accounts' option");
        driver.findElement(MENU_ACCOUNTS_OPTION).click();
        return new AccountsPage(driver);
    }
}
