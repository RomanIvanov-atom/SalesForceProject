package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.*;
import static dto.AccountFactory.getFullfilledAccount;

public class AccountsTest extends BaseTest {

    @Test
    public void checkCreateAccount() {
        //logic without steps
        loginPage.open()
                .isPageOpened()
                .doLogin(Credentials.USER_USERNAME, Credentials.USER_PASSWORD)
                .open()
                .isPageOpened()
                .selectAccountsOption()
                .clickOnActionButton(NEW_LABEL)
                .waitForCreateAccountModalIsOpened()
                .createAccountOnlyWithRequiredFields(getFullfilledAccount(HOT_RATING))
                .clickSaveButton();

//        logic with business steps
//        loginStep.login(Credentials.USER_USERNAME, Credentials.USER_PASSWORD);
//        accountStep.create(getFullfilledAccount(HOT_RATING));
    }
}
