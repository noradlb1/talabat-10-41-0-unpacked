package com.huawei.wisesecurity.kfs.interceptors;

import androidx.exifinterface.media.ExifInterface;

public enum TerminalType {
    ANDROID("1"),
    WINDOWS(ExifInterface.GPS_MEASUREMENT_2D),
    IOS(ExifInterface.GPS_MEASUREMENT_3D);
    
    public String value;

    /* access modifiers changed from: public */
    TerminalType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
