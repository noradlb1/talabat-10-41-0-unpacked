package com.google.firebase.database.connection;

import com.google.firebase.database.connection.PersistentConnectionImpl;
import java.util.Map;

public final /* synthetic */ class b implements PersistentConnectionImpl.ConnectionRequestCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PersistentConnectionImpl f47397a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f47398b;

    public /* synthetic */ b(PersistentConnectionImpl persistentConnectionImpl, boolean z11) {
        this.f47397a = persistentConnectionImpl;
        this.f47398b = z11;
    }

    public final void onResponse(Map map) {
        this.f47397a.lambda$sendAppCheckTokenHelper$4(this.f47398b, map);
    }
}
