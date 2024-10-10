package com.tadashboard.tests;

import com.tadashboard.dataprovider.TestDataProviders;
import com.tadashboard.enums.Repository;
import com.tadashboard.model.user.User;
import com.tadashboard.pages.DataProfilesPage;
import com.tadashboard.pages.HomePage;
import com.tadashboard.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseTC067 extends BaseTest{
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    DataProfilesPage dataProfilesPage = new DataProfilesPage();


    @Test(testName = "DA_DP_TC067: Verify that all Pre-set Data Profiles are populated correctly",
            dataProvider = "validUser", dataProviderClass = TestDataProviders.class)
    public void DA_DP_TC067(User validUser) {

        loginPage.login(Repository.SAMPLE_REPOSITORY.getValue(), validUser);

        homePage.openDataProfile();
        Assert.assertTrue(dataProfilesPage.areDataProfilesListedAlphabetically(),
                "The pre-set data profiles are not listed and sorted correctly");
    }
}
