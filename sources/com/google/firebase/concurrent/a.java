package com.google.firebase.concurrent;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CustomThreadFactory f47329b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f47330c;

    public /* synthetic */ a(CustomThreadFactory customThreadFactory, Runnable runnable) {
        this.f47329b = customThreadFactory;
        this.f47330c = runnable;
    }

    public final void run() {
        this.f47329b.lambda$newThread$0(this.f47330c);
    }
}
