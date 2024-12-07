package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import wrappers.Input;
import wrappers.Picklist;
import wrappers.TextArea;

public class NewAccountModal extends BasePage {

    private static final String NEW_ACCOUNT_MODAL_WRAPPER = "//div[@class='actionBody']";
    private static final String SAVE_BUTTON = NEW_ACCOUNT_MODAL_WRAPPER + "//*[@name = 'SaveEdit']";

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    public void openCreateAccountModal() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new");
    }

    public void createAccount(String name, String rating, String phone, String fax, String accountNumber, String webSite,
                              String accountSite, String tickerSymbol, String type, String ownership, String industry,
                              int employees, int annualRevenue, String sicCode,
                              String billingStreet, String shippingStreet, String customerPriority, String SLA, String SLASerialNumber,
                              int numberOfLocations, String upsellOpportunity, String isActive, String descriptions) {
        new Input(driver, "Account Name").write(name);
        new Picklist(driver, "Rating").selectSpecificOptionFromPicklist(rating);
        new Input(driver, "Phone").write(phone);
        new Input(driver, "Fax").write(fax);
        new Input(driver, "Account Number").write(accountNumber);
        new Input(driver, "Website").write(webSite);
        new Input(driver, "Account Site").write(accountSite);
        new Input(driver, "Ticker Symbol").write(tickerSymbol);
        new Picklist(driver, "Type").selectSpecificOptionFromPicklist(type);
        new Picklist(driver, "Ownership").selectSpecificOptionFromPicklist(ownership);
        new Picklist(driver, "Industry").selectSpecificOptionFromPicklist(industry);
        new Input(driver, "Employees").write(employees);
        new Input(driver, "Annual Revenue").write(annualRevenue);
        new Input(driver, "SIC Code").write(sicCode);

        new TextArea(driver, "Billing Street").write(billingStreet);
        new TextArea(driver, "Shipping Street").write(shippingStreet);

        new Picklist(driver, "Customer Priority").selectSpecificOptionFromPicklist(customerPriority);
        new Picklist(driver, "SLA").selectSpecificOptionFromPicklist(SLA);
        new Input(driver, "SLA Serial Number").write(SLASerialNumber);
        new Input(driver, "Number of Locations").write(numberOfLocations);
        new Picklist(driver, "Upsell Opportunity").selectSpecificOptionFromPicklist(upsellOpportunity);
        new Picklist(driver, "Active").selectSpecificOptionFromPicklist(isActive);

        new TextArea(driver, "Description").write(descriptions);
    }

    public void waitForCreateAccountModalIsOpened() {
        BasePage.waitForElementToBeVisible(By.xpath(NEW_ACCOUNT_MODAL_WRAPPER));
    }

    public void clickSaveButton() {
        driver.findElement(By.xpath(SAVE_BUTTON)).click();
    }
}
