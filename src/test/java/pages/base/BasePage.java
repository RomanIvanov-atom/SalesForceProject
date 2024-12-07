package pages.base;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

@Log4j2
public abstract class BasePage {

    protected WebDriver driver;
    protected static WebDriverWait wait;

    public abstract BasePage isPageOpened();

    public abstract BasePage open();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForPageLoaded() {
        new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return Objects.requireNonNull(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .toString().equals("complete");
            }
        };
    }

    public void clickJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("argument[0].click();", element);
    }

    public void scrollJSBy300Pixels() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300)");
    }

    public void scrollJSElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollIntoView(true);", element);
    }

    public void scroll(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
    }
}