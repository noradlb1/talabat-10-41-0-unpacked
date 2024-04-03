package com.huawei.hms.hatool;

import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.ArrayList;
import java.util.UUID;

public class i1 {

    /* renamed from: a  reason: collision with root package name */
    private String f49034a;

    /* renamed from: b  reason: collision with root package name */
    private String f49035b;

    /* renamed from: c  reason: collision with root package name */
    private String f49036c;

    /* renamed from: d  reason: collision with root package name */
    private String f49037d;

    /* renamed from: e  reason: collision with root package name */
    private long f49038e;

    public i1(String str, String str2, String str3, String str4, long j11) {
        this.f49034a = str;
        this.f49035b = str2;
        this.f49036c = str3;
        this.f49037d = str4;
        this.f49038e = j11;
    }

    public void a() {
        v.c("StreamEventHandler", "Begin to handle stream events...");
        b1 b1Var = new b1();
        b1Var.b(this.f49036c);
        b1Var.d(this.f49035b);
        b1Var.a(this.f49037d);
        b1Var.c(String.valueOf(this.f49038e));
        if ("oper".equals(this.f49035b) && z.i(this.f49034a, "oper")) {
            p0 a11 = y.a().a(this.f49034a, this.f49038e);
            String a12 = a11.a();
            Boolean valueOf = Boolean.valueOf(a11.b());
            b1Var.f(a12);
            b1Var.e(String.valueOf(valueOf));
        }
        String replace = UUID.randomUUID().toString().replace(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE, "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(b1Var);
        new l0(this.f49034a, this.f49035b, q0.g(), arrayList, replace).a();
    }
}
