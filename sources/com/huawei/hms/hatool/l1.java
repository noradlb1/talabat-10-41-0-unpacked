package com.huawei.hms.hatool;

public class l1 {

    /* renamed from: a  reason: collision with root package name */
    private s0 f49071a;

    /* renamed from: b  reason: collision with root package name */
    private s0 f49072b;

    /* renamed from: c  reason: collision with root package name */
    private s0 f49073c;

    /* renamed from: d  reason: collision with root package name */
    private s0 f49074d;

    public l1(String str) {
    }

    public s0 a() {
        return this.f49073c;
    }

    public s0 a(String str) {
        if (str.equals("oper")) {
            return c();
        }
        if (str.equals("maint")) {
            return b();
        }
        if (str.equals("diffprivacy")) {
            return a();
        }
        if (str.equals("preins")) {
            return d();
        }
        v.f("hmsSdk", "HiAnalyticsInstData.getConfig(type): wrong type: " + str);
        return null;
    }

    public void a(s0 s0Var) {
        this.f49071a = s0Var;
    }

    public s0 b() {
        return this.f49071a;
    }

    public void b(s0 s0Var) {
        this.f49072b = s0Var;
    }

    public s0 c() {
        return this.f49072b;
    }

    public s0 d() {
        return this.f49074d;
    }
}
