package com.google.firebase.database.core;

import com.google.firebase.database.connection.ConnectionTokenProvider;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ConnectionTokenProvider.GetTokenCallback f47400b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f47401c;

    public /* synthetic */ a(ConnectionTokenProvider.GetTokenCallback getTokenCallback, String str) {
        this.f47400b = getTokenCallback;
        this.f47401c = str;
    }

    public final void run() {
        this.f47400b.onError(this.f47401c);
    }
}
