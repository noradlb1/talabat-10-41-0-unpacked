package com.huawei.wisesecurity.kfs.ha;

public enum HiAnalyticsType {
    HIANALYTICS_OPERATION(0),
    HIANALYTICS_MAINTENANCE(1),
    HIANALYTICS_DIFF(3);
    
    public final int type;

    /* access modifiers changed from: public */
    HiAnalyticsType(int i11) {
        this.type = i11;
    }

    public int getCode() {
        return this.type;
    }
}
