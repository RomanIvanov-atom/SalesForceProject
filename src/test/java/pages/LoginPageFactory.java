package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class LoginPageFactory extends BasePage {
    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "username")
    WebElement userNameField;

    @FindBy (id = "password")
    WebElement passwordField;

    @FindBy (id = "Login")
    WebElement loginButton;

    //logical AND ( && )
    @FindBys({
            @FindBy(className = "class1"),
            @FindBy(tagName = "tag1")
    })
    WebElement demoFindBys;

    //logical OR ( || )
    @FindAll({
            @FindBy(className = "class2"),
            @FindBy(tagName = "tag2")
    })
    WebElement demoFindAll;

    @Override
    public LoginPageFactory open() {
        driver.get("https://tms9-dev-ed.develop.my.salesforce.com");
        return this;
    }

    @Override
    public LoginPageFactory isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) loginButton));
        return this;
    }

    public void login(String username, String password) {
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
