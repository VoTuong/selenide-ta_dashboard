package com.tadashboard.model.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageModel {
    private String pageName;
    private PageModel parentPageValue;
    private String numberOfColumnsValue;
    private String displayAfterValue;
    private boolean isPublic;

}
