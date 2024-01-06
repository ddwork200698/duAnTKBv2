package com.doubleD.tkb.models;

public enum Doituong {
    DAIHOC("Đại học cao đẳng"),
    CAP3("Cấp 3, trải nghiệm"),
    GDTX("Giáo dục thường xuyên");
    private final String value;

    Doituong(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
