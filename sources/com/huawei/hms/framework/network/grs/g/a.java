package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.e.c;
import java.util.concurrent.Callable;

public class a {

    /* renamed from: a  reason: collision with root package name */
    protected d f48873a;

    /* renamed from: b  reason: collision with root package name */
    private final String f48874b;

    /* renamed from: c  reason: collision with root package name */
    private final c f48875c;

    /* renamed from: d  reason: collision with root package name */
    private final int f48876d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f48877e;

    /* renamed from: f  reason: collision with root package name */
    private final String f48878f;

    /* renamed from: g  reason: collision with root package name */
    private final GrsBaseInfo f48879g;

    /* renamed from: h  reason: collision with root package name */
    private final c f48880h;

    public a(String str, int i11, c cVar, Context context, String str2, GrsBaseInfo grsBaseInfo, c cVar2) {
        this.f48874b = str;
        this.f48875c = cVar;
        this.f48876d = i11;
        this.f48877e = context;
        this.f48878f = str2;
        this.f48879g = grsBaseInfo;
        this.f48880h = cVar2;
    }

    public Context a() {
        return this.f48877e;
    }

    public c b() {
        return this.f48875c;
    }

    public String c() {
        return this.f48874b;
    }

    public int d() {
        return this.f48876d;
    }

    public String e() {
        return this.f48878f;
    }

    public c f() {
        return this.f48880h;
    }

    public Callable<d> g() {
        return new f(this.f48874b, this.f48876d, this.f48875c, this.f48877e, this.f48878f, this.f48879g, this.f48880h);
    }
}
