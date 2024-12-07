package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.base.BasePage;

import static constants.Constants.URLS.ACCOUNTS_URL;

@Log4j2
public class AccountsPage extends BasePage {

    private static final String ACTION_BUTTON_PATTERN = "//ul[contains(@class,'branding-actions')]//div[@title='%s']";
    private static final By LOAD_ACCOUNTS_PAGE_INDICATOR = By.xpath("//ul[contains(@class,'branding-actions')]");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOAD_ACCOUNTS_PAGE_INDICATOR));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Accounts page don't open");
        }
        return this;
    }

    public AccountsPage open() {
        log.info("Open AccountsPage");
        driver.get(ACCOUNTS_URL);
        return this;
    }

    public NewAccountModal clickOnActionButton(String buttonName) {
        log.info("Clicking on '" + buttonName + "' button");
        driver.findElement(By.xpath(String.format(ACTION_BUTTON_PATTERN, buttonName))).click();
        return new NewAccountModal(driver);
    }
}
