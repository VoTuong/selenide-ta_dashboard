package com.auto.tiki.dataproviders;

import com.auto.tiki.enums.Suppliers;
import com.auto.tiki.model.Filter;
import org.testng.annotations.DataProvider;

import java.util.HashSet;
import java.util.List;

public class DataForTestFactory {

    @DataProvider(name = "TestCase001")
    public Object[][] dataTestCase001() {
        String breadcrumb = "Trang chủ > Nhà Sách Tiki";
        Filter filter = Filter.builder()
                .suppliers(new HashSet<>(List.of(Suppliers.SUPPLIERS_FAHASA)))
                .minimumPrice(60000)
                .maximumPrice(140000)
                .build();
        return new Object[][]{{breadcrumb, filter}};
    }
}
