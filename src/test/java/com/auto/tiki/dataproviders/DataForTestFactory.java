package com.auto.tiki.dataproviders;

import com.auto.tiki.enums.Suppliers;
import com.auto.tiki.model.Filter;
import org.testng.annotations.DataProvider;

import java.util.HashSet;
import java.util.List;

public class DataForTestFactory {

    @DataProvider(name = "TestCase001")
    public Object[][] dataTestCase001() {
        String keyword = "Điện thoại";
        String breadcrumb = "Trang chủ >" + " Kết quả tìm kiếm \"Điện thoại\"";
        String pageTitle = "Điện thoại hàng chính hãng, giao nhanh";
        return new Object[][]{{keyword, breadcrumb, pageTitle}};
    }

    @DataProvider(name = "TestCase002")
    public Object[][] dataTestCase002() {
        String pageTitle = "Lò vi sóng";
        String breadcrumb = "Trang chủ > Điện Gia Dụng > Đồ dùng nhà bếp > Lò vi sóng";
        Filter filter = Filter.builder()
                .minimumPrice(1000000)
                .maximumPrice(1700000)
                .suppliers(new HashSet<>(List.of(Suppliers.TIKI_TRADING)))
                .build();
        return new Object[][]{{pageTitle, breadcrumb, filter}};
    }
}
