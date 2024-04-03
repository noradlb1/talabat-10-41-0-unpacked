package com.huawei.agconnect.common.network;

import com.huawei.agconnect.datastore.annotation.SharedPreference;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f47469a = new b();
    @SharedPreference(fileName = "AGConnectAccessNetwork", key = "enableAccessNetwork")
    boolean enableAccessNetwork = false;

    private b() {
    }

    public static b a() {
        return f47469a;
    }

    public void a(boolean z11) {
        this.enableAccessNetwork = z11;
        c.a().a(f47469a);
    }

    public boolean b() {
        c.a().b(f47469a);
        return this.enableAccessNetwork;
    }
}
