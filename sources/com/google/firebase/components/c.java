package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import java.util.Map;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map.Entry f47325b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Event f47326c;

    public /* synthetic */ c(Map.Entry entry, Event event) {
        this.f47325b = entry;
        this.f47326c = event;
    }

    public final void run() {
        ((EventHandler) this.f47325b.getKey()).handle(this.f47326c);
    }
}
