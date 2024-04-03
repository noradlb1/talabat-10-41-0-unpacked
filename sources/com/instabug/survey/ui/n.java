package com.instabug.survey.ui;

public enum n {
    PARTIAL,
    SECONDARY,
    PRIMARY;

    public static n a(int i11, n nVar) {
        return (i11 <= 0 || i11 >= values().length) ? nVar : values()[i11];
    }

    public int a() {
        return ordinal();
    }
}
