package com.tadashboard.tests;


import com.tadashboard.dataprovider.UserDataProviderFactory;
import com.tadashboard.enums.Message;
import com.tadashboard.enums.Repository;
import com.tadashboard.model.user.User;
import com.tadashboard.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.AlertHelper;


public class TestCaseTC002 extends BaseTest{
    LoginPage loginPage = new LoginPage();

    @Test(retryAnalyzer = utilities.RetryAnalyzer.class, dataProvider = "invalidUser", dataProviderClass = UserDataProviderFactory.class)
    public void DA_LOGIN_TC002(User invalidUser) {
        loginPage.login(Repository.SAMPLE_REPOSITORY.getValue(), invalidUser);

        Assert.assertEquals(AlertHelper.getTextAlert(), Message.LOGIN_INVALID_INFO_ERROR_MESSAGE.getValue(), "Dashboard Error message " + "\"" + Message.LOGIN_INVALID_INFO_ERROR_MESSAGE + "\"" + " appears");
    }

}
