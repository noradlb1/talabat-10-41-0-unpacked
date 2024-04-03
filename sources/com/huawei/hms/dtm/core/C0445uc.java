package com.huawei.hms.dtm.core;

/* renamed from: com.huawei.hms.dtm.core.uc  reason: case insensitive filesystem */
public class C0445uc implements C0435sc<C0435sc<?>> {

    /* renamed from: a  reason: collision with root package name */
    public static final C0445uc f48607a = new C0445uc("BREAK");

    /* renamed from: b  reason: collision with root package name */
    public static final C0445uc f48608b = new C0445uc("CONTINUE");

    /* renamed from: c  reason: collision with root package name */
    private String f48609c;

    /* renamed from: d  reason: collision with root package name */
    private C0435sc<?> f48610d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f48611e;

    public C0445uc(C0435sc<?> scVar) {
        this.f48609c = "return";
        this.f48610d = scVar;
        this.f48611e = true;
    }

    public C0445uc(String str) {
        this.f48609c = str;
        this.f48610d = null;
        this.f48611e = false;
    }

    public String a() {
        throw new V("target to json");
    }

    public boolean b() {
        return true;
    }

    public Double c() {
        double d11;
        if (this.f48609c.equals("NULL")) {
            d11 = 0.0d;
        } else if (this.f48609c.equals("UNDEFINED")) {
            d11 = Double.NaN;
        } else {
            throw new V("target to double");
        }
        return Double.valueOf(d11);
    }

    public C0435sc<?> d() {
        return this.f48610d;
    }

    public boolean e() {
        return this.f48611e;
    }

    public String toString() {
        return this.f48609c;
    }

    public C0435sc<?> value() {
        return this.f48610d;
    }
}
