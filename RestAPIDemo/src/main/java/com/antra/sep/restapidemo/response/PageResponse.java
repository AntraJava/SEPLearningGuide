package com.antra.sep.restapidemo.response;

import lombok.Data;

import java.util.List;

@Data
public class PageResponse<T> {
    private int totalRow;
    private int totalPage;
    private int currentPage;
    private List<T> data;
}
