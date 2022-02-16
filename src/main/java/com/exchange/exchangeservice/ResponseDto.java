package com.exchange.exchangeservice;

import java.util.List;

public class ResponseDto {
    private List<TestBeen> result;

    public ResponseDto() {
    }

    public List<TestBeen> getResult() {
        return result;
    }

    public void setResult(List<TestBeen> result) {
        this.result = result;
    }
}
