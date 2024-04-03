package com.google.firebase.messaging;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SharedPreferencesQueue f47437b;

    public /* synthetic */ k(SharedPreferencesQueue sharedPreferencesQueue) {
        this.f47437b = sharedPreferencesQueue;
    }

    public final void run() {
        this.f47437b.syncState();
    }
}
