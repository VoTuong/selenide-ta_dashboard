package com.tadashboard.tests;

import com.tadashboard.dataprovider.DA_LOGIN_DataProviderFactory;
import com.tadashboard.enums.Repository;
import com.tadashboard.model.user.UserModel;
import com.tadashboard.pages.DataProfilesPage;
import com.tadashboard.pages.HomePage;
import com.tadashboard.pages.LoginPage;
import org.testng.annotations.Test;

public class TestCaseTC067 extends BaseTest{
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    DataProfilesPage dataProfilesPage = new DataProfilesPage();


    @Test(retryAnalyzer = utilities.RetryAnalyzer.class,
            testName = "DA_DP_TC067: Verify that all Pre-set Data Profiles are populated correctly",
            dataProvider = "validUser", dataProviderClass = DA_LOGIN_DataProviderFactory.class, groups = {"dadpGroup"})
    public void DA_DP_TC067(UserModel validUser) {

        loginPage.login(Repository.SAMPLE_REPOSITORY.getValue(), validUser);

//        dataProfilesPage.deleteAllCreatedProfiles();

//        Log.step("Go to Administer  -> Data Profiles");
        homePage.clickDataProfile();
        dataProfilesPage.areDataProfilesListedAlphabetically();

    }
}
