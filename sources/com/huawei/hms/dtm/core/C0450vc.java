package com.huawei.hms.dtm.core;

/* renamed from: com.huawei.hms.dtm.core.vc  reason: case insensitive filesystem */
public class C0450vc extends Dc<Integer> {
    public C0450vc(Integer num) {
        super(num);
    }

    public boolean b() {
        return (value() == null || ((Integer) value()).intValue() == 0) ? false : true;
    }

    public Double c() {
        return Double.valueOf((double) ((Integer) value()).intValue());
    }
}
