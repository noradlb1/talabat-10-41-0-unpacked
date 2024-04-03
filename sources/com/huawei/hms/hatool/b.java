package com.huawei.hms.hatool;

import android.content.Context;

public class b {

    /* renamed from: a  reason: collision with root package name */
    s0 f48966a;

    /* renamed from: b  reason: collision with root package name */
    s0 f48967b;

    /* renamed from: c  reason: collision with root package name */
    Context f48968c;

    /* renamed from: d  reason: collision with root package name */
    String f48969d;

    public b(Context context) {
        if (context != null) {
            this.f48968c = context.getApplicationContext();
        }
        this.f48966a = new s0();
        this.f48967b = new s0();
    }

    public b a(int i11, String str) {
        s0 s0Var;
        v.c("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + i11);
        if (!p1.b(str)) {
            str = "";
        }
        if (i11 == 0) {
            s0Var = this.f48966a;
        } else if (i11 != 1) {
            v.f("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
            return this;
        } else {
            s0Var = this.f48967b;
        }
        s0Var.b(str);
        return this;
    }

    public b a(String str) {
        v.c("hmsSdk", "Builder.setAppID is execute");
        this.f48969d = str;
        return this;
    }

    @Deprecated
    public b a(boolean z11) {
        v.c("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
        this.f48966a.j().a(z11);
        this.f48967b.j().a(z11);
        return this;
    }

    public void a() {
        if (this.f48968c == null) {
            v.b("hmsSdk", "analyticsConf create(): context is null,create failed!");
            return;
        }
        v.c("hmsSdk", "Builder.create() is execute.");
        z0 z0Var = new z0("_hms_config_tag");
        z0Var.b(new s0(this.f48966a));
        z0Var.a(new s0(this.f48967b));
        m.a().a(this.f48968c);
        g0.a().a(this.f48968c);
        q.c().a(z0Var);
        m.a().a(this.f48969d);
    }

    @Deprecated
    public b b(boolean z11) {
        v.c("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
        this.f48966a.j().b(z11);
        this.f48967b.j().b(z11);
        return this;
    }

    @Deprecated
    public b c(boolean z11) {
        v.c("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
        this.f48966a.j().c(z11);
        this.f48967b.j().c(z11);
        return this;
    }
}
