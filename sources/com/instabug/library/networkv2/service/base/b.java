package com.instabug.library.networkv2.service.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.request.Request;

public abstract class b {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final NetworkManager f51665a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Request.Callbacks f51666b;

    public b(@NonNull NetworkManager networkManager, @NonNull a aVar, @Nullable Request.Callbacks callbacks) {
        this.f51665a = networkManager;
        this.f51666b = callbacks;
    }

    @Nullable
    public Request.Callbacks a() {
        return this.f51666b;
    }

    @NonNull
    public NetworkManager b() {
        return this.f51665a;
    }
}
