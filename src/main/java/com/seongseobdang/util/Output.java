package com.seongseobdang.util;

public enum Output {
    NG(0),
    OK(1),
    ID_DUPLICATE(2);

    private int num;

    Output(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
