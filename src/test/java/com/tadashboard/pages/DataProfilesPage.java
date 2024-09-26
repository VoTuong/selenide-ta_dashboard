package com.tadashboard.pages;

import com.codeborne.selenide.ElementsCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class DataProfilesPage extends BasePage{
//    private static final Logger LOGGER = LoggerFactory.getLogger(DataProfilesPage.class);


    private final ElementsCollection tableHeaders = $$x("//form//table//tbody//th");
    private final ElementsCollection listDataProfilesName = $$x("//form[@id='form1']//table//tbody//td[2]");


//    public Integer getColumnIndexes(String header) {
//
//        for (int i = 0; i < tableHeaders.size(); i++) {
//            String th = tableHeaders.get(i).getText();
////            System.out.println("Col " + i + " : " + th);
//            if (th.equals(header)) {
//                return i + 1;
//            }
//        }
//        return null;
//    }

    public static boolean isListSortedAlphabetically(List<String> list) {
        // Create a copy of the list and sort it
        List<String> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        // Compare the original list with the sorted list
        return list.equals(sortedList);
    }

    public boolean areDataProfilesListedAlphabetically() {
        List<String> listPreset = getListDataProfile();
        return isListSortedAlphabetically(listPreset);
    }

    public List<String> getListDataProfile() {
//        int ind = getColumnIndexes("Data Profile");
//        listDataProfilesName.get(ind);
        List<String> listProfile = new ArrayList<>();
        for (int i = 0; i < listDataProfilesName.size(); i++) {
            listProfile.add(listDataProfilesName.get(i).getText());
        }
        return listProfile;
    }
}
