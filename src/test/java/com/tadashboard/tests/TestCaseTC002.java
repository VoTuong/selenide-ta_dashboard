package com.tadashboard.tests;


import com.tadashboard.enums.Message;
import com.tadashboard.enums.Repository;
import com.tadashboard.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.AlertHelper;


public class TestCaseTC002 extends BaseTest{

    @Test(retryAnalyzer = utilities.RetryAnalyzer.class)
    public void DA_LOGIN_TC002() {
        LoginPage loginPage = new LoginPage();

        loginPage.login(Repository.SAMPLE_REPOSITORY.getValue(), "abc", "password");

        Assert.assertEquals(AlertHelper.getTextAlert(), Message.LOGIN_INVALID_INFO_ERROR_MESSAGE.getValue(), "Dashboard Error message " + "\"" + Message.LOGIN_INVALID_INFO_ERROR_MESSAGE + "\"" + " appears");
    }

}
