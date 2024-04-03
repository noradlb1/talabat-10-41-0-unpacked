package com.huawei.hms.dtm.core;

/* renamed from: com.huawei.hms.dtm.core.rc  reason: case insensitive filesystem */
public final class C0430rc extends Dc<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    private static final C0430rc f48552b = new C0430rc(Boolean.TRUE);

    /* renamed from: c  reason: collision with root package name */
    private static final C0430rc f48553c = new C0430rc(Boolean.FALSE);

    private C0430rc(Boolean bool) {
        super(bool);
    }

    public static C0430rc a(boolean z11) {
        return z11 ? f48552b : f48553c;
    }

    public boolean b() {
        return value() != null && ((Boolean) value()).booleanValue();
    }

    public Double c() {
        return Double.valueOf(((Boolean) value()).booleanValue() ? 1.0d : 0.0d);
    }
}
