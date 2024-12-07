package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class LoginPage extends BasePage {

    private static final String LOGIN_INPUT = "//input[@id='username']";
    private static final String PASSWORD_INPUT = "//input[@id='password']";
    private static final String LOGIN_BUTTON = "//input[@id='Login']";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openMainPage() {
        driver.get("https://tms9-dev-ed.develop.my.salesforce.com");
    }

    private void enterLogin(String login) {
        driver.findElement(By.xpath(LOGIN_INPUT)).sendKeys(login);
    }

    private void enterPassword(String password) {
        driver.findElement(By.xpath(PASSWORD_INPUT)).sendKeys(password);
    }

    private void clickLogIn() {
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }

    public void doLogin(String login, String password) {
        enterLogin(login);
        enterPassword(password);
        clickLogIn();
    }
}
