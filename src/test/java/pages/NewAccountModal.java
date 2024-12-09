package pages;

import dto.Account;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.base.BasePage;
import wrappers.Input;
import wrappers.Picklist;
import wrappers.TextArea;

import static constants.Constants.Urls.NEW_ACCOUNT_MODAL_URL;

@Log4j2
public class NewAccountModal extends BasePage {

    private static final String NEW_ACCOUNT_MODAL_WRAPPER = "//div[@class='actionBody']";
    private static final By SAVE_BUTTON = By.xpath(NEW_ACCOUNT_MODAL_WRAPPER + "//*[@name = 'SaveEdit']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewAccountModal isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_BUTTON));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("New account modal don't open");
        }
        return this;
    }

    @Override
    public NewAccountModal open() {
        log.info("Opening new account modal");
        driver.get(NEW_ACCOUNT_MODAL_URL);
        return this;
    }

    public NewAccountModal createAccountOnlyWithRequiredFields(Account account) {
        log.info("Creating account '{}' with only required fields", account.getName());
        new Input(driver, "Account Name").write(account.getName());
        new Picklist(driver, "Rating").selectSpecificOptionFromPicklist(account.getRating());
        new Input(driver, "Phone").write(account.getPhoneNumber());
        new Input(driver, "Fax").write(account.getFax());
        return this;
    }

    public NewAccountModal createFulfilledAccount(Account account) {
        log.info("Creating account '{}' with all fields", account.getName());
        new Input(driver, "Account Name").write(account.getName());
        new Picklist(driver, "Rating").selectSpecificOptionFromPicklist(account.getRating());
        new Input(driver, "Phone").write(account.getPhoneNumber());
        new Input(driver, "Fax").write(account.getFax());
        new Input(driver, "Account Number").write(account.getAccountNumber());
        new Input(driver, "Website").write(account.getAccountSite());
        new Input(driver, "Account Site").write(account.getAccountSite());
        new Input(driver, "Ticker Symbol").write(account.getTickerSymbol());
        new Picklist(driver, "Type").selectSpecificOptionFromPicklist(account.getType());
        new Picklist(driver, "Ownership").selectSpecificOptionFromPicklist(account.getOwnership());
        new TextArea(driver, "Description").write(account.getDescription());
        return this;
    }

    public NewAccountModal waitForCreateAccountModalIsOpened() {
        BasePage.waitForElementToBeVisible(By.xpath(NEW_ACCOUNT_MODAL_WRAPPER));
        return this;
    }

    public AccountsPage clickSaveButton() {
        log.info("Clicking Save button");
        driver.findElement(SAVE_BUTTON).click();
        return new AccountsPage(driver);
    }
}
