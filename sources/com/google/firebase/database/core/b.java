package com.google.firebase.database.core;

import com.google.firebase.database.connection.ConnectionTokenProvider;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ConnectionTokenProvider.GetTokenCallback f47402b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f47403c;

    public /* synthetic */ b(ConnectionTokenProvider.GetTokenCallback getTokenCallback, String str) {
        this.f47402b = getTokenCallback;
        this.f47403c = str;
    }

    public final void run() {
        this.f47402b.onSuccess(this.f47403c);
    }
}
