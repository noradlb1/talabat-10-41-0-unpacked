package com.google.common.eventbus;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Subscriber f44650b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f44651c;

    public /* synthetic */ a(Subscriber subscriber, Object obj) {
        this.f44650b = subscriber;
        this.f44651c = obj;
    }

    public final void run() {
        this.f44650b.lambda$dispatchEvent$0(this.f44651c);
    }
}
