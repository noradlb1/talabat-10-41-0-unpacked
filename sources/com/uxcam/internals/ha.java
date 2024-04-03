package com.uxcam.internals;

import android.content.Context;

public class ha implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f13521a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f13522b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ hb f13523c;

    public ha(hb hbVar, Context context, String str) {
        this.f13523c = hbVar;
        this.f13521a = context;
        this.f13522b = str;
    }

    public void run() {
        this.f13523c.a(this.f13521a, this.f13522b, true);
    }
}
