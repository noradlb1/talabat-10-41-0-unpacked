package com.huawei.hms.dtm;

import java.util.Map;

public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f48657a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f48658b;

    public k(l lVar, Map map) {
        this.f48658b = lVar;
        this.f48657a = map;
    }

    public void run() {
        this.f48658b.f48660b.setParameter(this.f48657a);
    }
}
