package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Quotes;

@Log4j2
public class Input {

    WebDriver driver;
    String label;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public <T> void write(T text) {
        log.info("Writing '{}' into {}", text, label);
        driver.findElement(By.xpath(String.format("//label[text() = %s]//ancestor::lightning-input//input",
                Quotes.escape(label)))).sendKeys(text.toString());
    }
}
