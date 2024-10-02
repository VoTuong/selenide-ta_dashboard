package com.tadashboard.pages;

import com.codeborne.selenide.SelenideElement;
import com.epam.reportportal.annotations.Step;
import com.tadashboard.enums.GlobalSettingOptions;
import com.tadashboard.model.page.Page;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class PagePrompt extends BasePage {
    HomePage homePage = new HomePage();

    private final SelenideElement textBoxNewPageName = $("#name");
    private final SelenideElement dropdownParentPage = $("#parent");
    private final SelenideElement dropdownColumnsInPage = $("#columnnumber");
    private final SelenideElement dropdownDisplayAfter = $("#afterpage");
    private final SelenideElement checkboxPublic = $("#ispublic");

    public void enterPageName(String pageName) {
        logInfo("Enter pageName: " + pageName);
        textBoxNewPageName.type(pageName);
    }

    public void selectParentPage(Page parentPage) {
        logInfo("Select parent pageName: " + parentPage);
        List<String> options = dropdownParentPage.getOptions().texts();

        int index = -1;
        for (int i = 0; i < options.size(); i++) {
            String option = options.get(i);
            if (option.contains(parentPage.getPageName())) {
                index = i;
                break;
            }
        }
        if (index != -1)
            dropdownParentPage.selectOption(index);
    }

    public void selectNumberOfColumns(String number) {
        logInfo("Select Number Of Columns: " + number);
        dropdownColumnsInPage.selectOption(number);
    }

    public void selectDisplayAfterPage(String pageName) {
        logInfo("Select page to display after: " + pageName);
        dropdownDisplayAfter.selectOption(pageName);
    }

    public void checkBoxPublic(boolean state) {
        logInfo("Select checkbox to public");
        if (checkboxPublic.exists()) {
            checkboxPublic.setSelected(state);
        }
    }

    public void fillPageInfo(Page pageData) {
        logInfo("Fill page info");
        enterPageName(pageData.getPageName());

        if ((pageData.getParentPageValue()) != null && !(pageData.getParentPageValue()).getPageName().isEmpty()) {
            selectParentPage(pageData.getParentPageValue());
        }
        if (!pageData.getNumberOfColumnsValue().isEmpty()) {
            selectNumberOfColumns(pageData.getNumberOfColumnsValue());
        }
        if (!pageData.getDisplayAfterValue().isEmpty()) {
            selectDisplayAfterPage(pageData.getDisplayAfterValue());
        }
        checkBoxPublic(pageData.isPublic());
    }

    @Step
    public void createPage(Page pageData) {
        logInfo("Add a new public page with page name: " + pageData.getPageName());
        homePage.clickGlobalSettingOption(GlobalSettingOptions.ADD_PAGE);
        fillPageInfo(pageData);
        clickPanelOKButton();
    }

//    @Step
//    public void createPage(Page pageData, Page parentPage) {
//        logInfo("Add a new public page with page name: " + pageData.getPageName() + " and is child of " + parentPage.getPageName());
//        homePage.clickGlobalSettingOption(GlobalSettingOptions.ADD_PAGE);
//        pageData.setParentPageValue(parentPage);
//        fillPageInfo(pageData);
//        clickPanelOKButton();
//    }

}
