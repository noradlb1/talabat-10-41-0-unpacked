package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultDrmSessionManager.PreacquiredSessionReference f34926b;

    public /* synthetic */ c(DefaultDrmSessionManager.PreacquiredSessionReference preacquiredSessionReference) {
        this.f34926b = preacquiredSessionReference;
    }

    public final void run() {
        this.f34926b.lambda$release$1();
    }
}
