package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.base.BasePage;

import static constants.Constants.Urls.LOGIN_URL;

@Log4j2
public class LoginPage extends BasePage {

    private static final By LOGIN_INPUT = By.xpath("//input[@id='username']");
    private static final By PASSWORD_INPUT = By.xpath("//input[@id='password']");
    private static final By LOGIN_BUTTON = By.xpath("//input[@id='Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Login page don't open");
        }
        return this;
    }

    @Override
    public LoginPage open() {
        log.info("Open LoginPage");
        driver.get(LOGIN_URL);
        return this;
    }

    private LoginPage enterLogin(String login) {
        driver.findElement(LOGIN_INPUT).sendKeys(login);
        return this;
    }

    private LoginPage enterPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    private LoginPage clickLogIn() {
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public HomePage doLogin(String login, String password) {
        log.info("Login using credentials: '{}', '{}'", login, password);
        enterLogin(login)
                .enterPassword(password)
                .clickLogIn();
        return new HomePage(driver);
    }
}
