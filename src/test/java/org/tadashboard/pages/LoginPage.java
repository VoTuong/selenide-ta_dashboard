package org.tadashboard.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    // Define Selenide elements using locators
    private final SelenideElement repositoryDropdown = $("#repository");
    private final SelenideElement usernameInput = $("#username");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement loginButton = $x("//div[@class='btn-login']");

    // Method to select a repository from the dropdown
    public LoginPage selectRepository(String repository) {
        repositoryDropdown.selectOption(repository);
        return this;
    }

    // Method to enter username
    public LoginPage enterUsername(String username) {
        usernameInput.setValue(username);
        return this;
    }

    // Method to enter password
    public LoginPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    // Method to click the login button
    public HomePage clickLoginButton() {
        loginButton.click();
        return new HomePage();
    }

    // Method to perform the full login action
    public HomePage login(String repository, String username, String password) {
        return selectRepository(repository)
                .enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();
    }
}
