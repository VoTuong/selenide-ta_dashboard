package com.tadashboard.pages;

import com.codeborne.selenide.SelenideElement;
import com.epam.reportportal.annotations.Step;
import com.tadashboard.model.user.User;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    private final SelenideElement repositoryDropdown = $("#repository");
    private final SelenideElement usernameInput = $("#username");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement loginButton = $x("//div[@class='btn-login']");

    @Step
    public LoginPage selectRepository(String repository) {
        logInfo("Select repository: " + repository);
        repositoryDropdown.selectOption(repository);
        return this;
    }

    @Step
    public LoginPage enterUsername(String username) {
        logInfo("Enter username: " + username);
        usernameInput.setValue(username);
        return this;
    }

    @Step
    public LoginPage enterPassword(String password) {
        logInfo("Enter password: " + password);
        passwordInput.setValue(password);
        return this;
    }

    @Step
    public void clickLoginButton() {
        logInfo("Click Login button");
        loginButton.click();
        new HomePage();
    }

    @Step("Login with user: {user}")
    public void login(String repository, User user) {
        logInfo("Login with user: " + user.getUsername() + " - " + user.getPassword());
        selectRepository(repository)
                .enterUsername(user.getUsername())
                .enterPassword(user.getPassword())
                .clickLoginButton();
    }
}
