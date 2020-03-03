package com.smd.learning.response;

import com.smd.learning.entity.Page;

import java.io.Serializable;
import java.util.List;

public class PagesResp implements Serializable {

    private static final long serialVersionUID = 9025717221306304250L;

    private List<Page> pages;

    public PagesResp(List<Page> pages) {
        this.pages = pages;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }
}
