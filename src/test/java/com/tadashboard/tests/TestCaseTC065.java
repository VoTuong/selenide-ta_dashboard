package com.tadashboard.tests;

import com.tadashboard.dataprovider.TestDataProviders;
import com.tadashboard.enums.Repository;
import com.tadashboard.model.user.User;
import com.tadashboard.pages.DataProfilesPage;
import com.tadashboard.pages.HomePage;
import com.tadashboard.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCaseTC065 extends BaseTest{
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    DataProfilesPage dataProfilesPage = new DataProfilesPage();

    @Test(testName = "DA_DP_TC065: Verify that all Pre-set Data Profiles are populated correctly",
            dataProvider = "DA_DP_TC065", dataProviderClass = TestDataProviders.class)
    public void DA_DP_TC065(User validUser, List<String> listDataProfiles) {

        loginPage.login(Repository.SAMPLE_REPOSITORY.getValue(), validUser);

        homePage.openDataProfile();

        Assert.assertEquals(dataProfilesPage.getListDataProfile(),listDataProfiles,
                "Pre-set Data Profile are not populated correctly in profiles page");
    }
}
