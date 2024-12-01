package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class AccountsTest extends BaseTest {

    @Test
    public void checkCreateAccount() {
        String username = "tborodich@tms.sandbox";
        String password = "Password001";
        String testName = "Roma";
        String testRating = "Hot";
        String testAccountNumber = "12-23-34";
        String testPhoneNumber = "8-800-555-35-35";
        String testFax = "11-22-33";
        String testWebSite = "www.test.website.com";
        String testAccountSite = "www.test.accountSite.com";
        String testTickerSymbol = "abc";
        String testType = "Prospect";
        String testOwnership = "Public";
        String testIndustry = "Agriculture";
        int testEmployees = 12;
        int testAnnualRevenue = 100500;
        String testSicCode = "someSicCode";
        String testBillingStreet = "Kudikino";
        String testShippingStreet = "Kudikino for shipping";
        String testCustomerPriority = "High";
        String testSLA = "Gold";
        String testSLASerialNumber = "1122aabb";
        int testNumberOfLocations = 123456;
        String testUpsellOpportunity = "Yes";
        String testIsActive = "No";
        String testDescription = "Test text for description";

        loginPage.openMainPage();
        loginPage.doLogin(username, password);
        newAccountModal.openCreateAccountModal();
        newAccountModal.waitForCreateAccountModalIsOpened();
        newAccountModal.createAccount(testName, testRating, testPhoneNumber, testFax, testAccountNumber, testWebSite,
                testAccountSite, testTickerSymbol, testType, testOwnership, testIndustry, testEmployees, testAnnualRevenue,
                testSicCode, testBillingStreet, testShippingStreet, testCustomerPriority, testSLA, testSLASerialNumber,
                testNumberOfLocations, testUpsellOpportunity, testIsActive, testDescription);
        newAccountModal.clickSaveButton();
    }
}
