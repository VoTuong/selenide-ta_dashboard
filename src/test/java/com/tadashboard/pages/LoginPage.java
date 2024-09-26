package com.tadashboard.pages;

import com.codeborne.selenide.SelenideElement;
import com.epam.reportportal.annotations.Step;
import com.tadashboard.model.user.UserModel;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
//    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);


    // Define Selenide elements using locators
    private final SelenideElement repositoryDropdown = $("#repository");
    private final SelenideElement usernameInput = $("#username");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement loginButton = $x("//div[@class='btn-login']");

    // Method to select a repository from the dropdown
    @Step
    public LoginPage selectRepository(String repository) {
        repositoryDropdown.selectOption(repository);
        return this;
    }

    // Method to enter username
    @Step
    public LoginPage enterUsername(String username) {
        usernameInput.setValue(username);
        return this;
    }

    // Method to enter password
    @Step
    public LoginPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    // Method to click the login button
    @Step
    public HomePage clickLoginButton() {
        loginButton.click();
        return new HomePage();
    }

    // Method to perform the full login action
    @Step
    public HomePage login(String repository, String username, String password) {
        return selectRepository(repository)
                .enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();
    }

    @Step
    public void login(String repository, UserModel validUser) {
        selectRepository(repository)
                .enterUsername(validUser.getUsername())
                .enterPassword(validUser.getPassword())
                .clickLoginButton();
    }
}
