package com.magazine.application.common.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ListRequestResult<T> {

    private final Integer total;

    private final List<T> result;

    public ListRequestResult(List<T> result) {
        this.result = result;
        this.total = result.size();
    }
}
