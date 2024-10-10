package com.tadashboard.tests;

import com.tadashboard.dataprovider.UserDataProviderFactory;
import com.tadashboard.enums.Repository;
import com.tadashboard.model.user.User;
import com.tadashboard.pages.DataProfilesPage;
import com.tadashboard.pages.HomePage;
import com.tadashboard.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.FileUtils;
import utilities.JsonUtils;

import java.util.List;

import static com.tadashboard.constants.Constants.PRE_SET_DATA_PROFILES_DATA_PATH;

public class TestCaseTC065 extends BaseTest{
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    DataProfilesPage dataProfilesPage = new DataProfilesPage();

    @DataProvider
    public static Object[][] DA_DP_TC067() {
        String presetDataProfilesJSONPath = FileUtils.getCurrentDir() + PRE_SET_DATA_PROFILES_DATA_PATH;

        User validUser = (User) UserDataProviderFactory.validUser()[0][0];
        List<String> listDataProfiles = JsonUtils.toStringList(presetDataProfilesJSONPath);
        return new Object[][]{
                {validUser, listDataProfiles}
        };
    }

    @Test(testName = "DA_DP_TC065: Verify that all Pre-set Data Profiles are populated correctly", dataProvider = "DA_DP_TC067", groups = {"dadpGroup"})
    public void DA_DP_TC067(User validUser, List<String> listDataProfiles) {

        loginPage.login(Repository.SAMPLE_REPOSITORY.getValue(), validUser);

        homePage.openDataProfile();

        Assert.assertEquals(dataProfilesPage.getListDataProfile(),listDataProfiles, "Pre-set Data Profile are not populated correctly in profiles page");

    }
}
