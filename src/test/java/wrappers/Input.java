package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Quotes;

public class Input {

    WebDriver driver;
    String label;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }
    public <T> void write(T text) {
        driver.findElement(By.xpath(String.format("//label[text() = %s]//ancestor::lightning-input//input",
                        Quotes.escape(label)))).sendKeys(text.toString());
    }
}
