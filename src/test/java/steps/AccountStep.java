package steps;

import dto.Account;
import org.openqa.selenium.WebDriver;
import pages.AccountsPage;
import pages.HomePage;
import pages.NewAccountModal;

public class AccountStep {
    HomePage homePage;
    AccountsPage accountsPage;
    NewAccountModal newAccountModal;

    public AccountStep(WebDriver driver) {
        homePage = new HomePage(driver);
        accountsPage = new AccountsPage(driver);
        newAccountModal = new NewAccountModal(driver);
    }

    public void create(Account account) {
        homePage.open()
                .isPageOpened()
                .selectAccountsOption()
                .clickOnActionButton("New")
                .waitForCreateAccountModalIsOpened()
                .createFulfilledAccount(account)
                .clickSaveButton();
    }
}
