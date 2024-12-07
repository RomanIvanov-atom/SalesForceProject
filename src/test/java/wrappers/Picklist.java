package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Quotes;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.Constants.TRUE_STATE;

@Log4j2
public class Picklist {

    WebDriver driver;
    String label;
    WebDriverWait wait;
    private static final String PICKLIST_PATTERN = "//label[text()= %s]//ancestor::lightning-picklist";
    private static final String PICKLIST_INPUT = PICKLIST_PATTERN + "//button";
    private static final String LIST_OF_ITEMS_IN_PICKLIST = PICKLIST_PATTERN + "//div[@role='listbox']";
    private static final String SPECIFIC_ITEM_IN_PICKLIST = PICKLIST_PATTERN + "//lightning-base-combobox-item//span[text()= %s]";

    public Picklist(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void selectSpecificOptionFromPicklist(String option) {
        log.info("Selecting '{}' inside picklist '{}'", option, label);
        setDropDownOpen(true);
        driver.findElement(By.xpath(String.format(SPECIFIC_ITEM_IN_PICKLIST, Quotes.escape(label),
                Quotes.escape(option)))).click();
    }

    private boolean isSpecificSelectOpen() {
        return driver.findElement(By.xpath(String.format(PICKLIST_INPUT, Quotes.escape(label))))
                .getAttribute("aria-expanded").contains(TRUE_STATE);
    }

    private void setDropDownOpen(boolean open) {
        if (isSpecificSelectOpen() ^ open) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(PICKLIST_INPUT, Quotes.escape(label)))));
            driver.findElement(By.xpath(String.format(PICKLIST_INPUT, Quotes.escape(label)))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(String.format(LIST_OF_ITEMS_IN_PICKLIST, Quotes.escape(label)))));
        }
    }
}