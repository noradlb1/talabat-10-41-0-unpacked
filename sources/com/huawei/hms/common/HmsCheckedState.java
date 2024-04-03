package com.huawei.hms.common;

public enum HmsCheckedState {
    UNCHECKED(0),
    NOT_NEED_UPDATE(1),
    NEED_UPDATE(2);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f48090a;

    private HmsCheckedState(int i11) {
        this.f48090a = i11;
    }

    public int getState() {
        return this.f48090a;
    }
}
