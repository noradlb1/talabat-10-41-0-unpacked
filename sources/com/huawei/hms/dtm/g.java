package com.huawei.hms.dtm;

public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f48647a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f48648b;

    public g(l lVar, String str) {
        this.f48648b = lVar;
        this.f48647a = str;
    }

    public void run() {
        this.f48648b.f48660b.startVisualTrace(this.f48647a);
    }
}
