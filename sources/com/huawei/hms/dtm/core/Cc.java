package com.huawei.hms.dtm.core;

public final class Cc extends Dc<String> {

    /* renamed from: b  reason: collision with root package name */
    public static final Cc f48270b = new Cc("");

    public Cc(String str) {
        super(str);
    }

    public boolean b() {
        return value() != null && ((String) value()).length() > 0;
    }

    public Double c() {
        double d11;
        if (value() == null || "".equals(value())) {
            d11 = 0.0d;
        } else {
            try {
                return Double.valueOf(Double.parseDouble((String) value()));
            } catch (NumberFormatException unused) {
                d11 = Double.NaN;
            }
        }
        return Double.valueOf(d11);
    }
}
