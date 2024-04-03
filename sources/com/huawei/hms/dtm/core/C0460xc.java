package com.huawei.hms.dtm.core;

/* renamed from: com.huawei.hms.dtm.core.xc  reason: case insensitive filesystem */
public class C0460xc extends Dc<Long> {
    public C0460xc(Long l11) {
        super(l11);
    }

    public boolean b() {
        return (value() == null || ((Long) value()).longValue() == 0) ? false : true;
    }

    public Double c() {
        return Double.valueOf((double) ((Long) value()).longValue());
    }
}
