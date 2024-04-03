package com.google.firebase.perf.transport;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportManager f47453b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PendingPerfEvent f47454c;

    public /* synthetic */ a(TransportManager transportManager, PendingPerfEvent pendingPerfEvent) {
        this.f47453b = transportManager;
        this.f47454c = pendingPerfEvent;
    }

    public final void run() {
        this.f47453b.lambda$finishInitialization$0(this.f47454c);
    }
}
