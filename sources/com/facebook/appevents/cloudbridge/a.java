package com.facebook.appevents.cloudbridge;

import java.util.List;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Integer f33578b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f33579c;

    public /* synthetic */ a(Integer num, List list) {
        this.f33578b = num;
        this.f33579c = list;
    }

    public final void run() {
        AppEventsConversionsAPITransformerWebRequests$transformGraphRequestAndSendToCAPIGEndPoint$1$1.m8903invoke$lambda0(this.f33578b, this.f33579c);
    }
}
