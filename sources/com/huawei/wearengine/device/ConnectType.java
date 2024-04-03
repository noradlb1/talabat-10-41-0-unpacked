package com.huawei.wearengine.device;

public enum ConnectType {
    CONNECT_TYPE_GENERAL(0),
    CONNECT_TYPE_SIMPLE(1),
    CONNECT_TYPE_TRANSPARENT(2);
    
    private int mType;

    private ConnectType(int i11) {
        this.mType = i11;
    }

    public int value() {
        return this.mType;
    }
}
