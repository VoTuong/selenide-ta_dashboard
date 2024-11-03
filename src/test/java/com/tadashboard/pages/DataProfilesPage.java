package com.tadashboard.pages;

import com.codeborne.selenide.ElementsCollection;
import com.epam.reportportal.annotations.Step;
import utilities.ListUtils;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class DataProfilesPage extends BasePage{

    private final ElementsCollection listDataProfilesName = $$x("//form[@id='form1']//table//td[2][not(.//a)]");


    @Step("Check Data Profiles are sorted alphabet")
    public boolean areDataProfilesListedAlphabetically() {
        List<String> listPreset = getListDataProfile();
        return ListUtils.isListSorted(listPreset);
    }

    @Step("Get the list of data profiles")
    public List<String> getListDataProfile() {
        List<String> listProfile = new ArrayList<>();
        for (int i = 0; i < listDataProfilesName.size(); i++) {
            listProfile.add(listDataProfilesName.get(i).getText());
        }
        return listProfile;
    }
}
