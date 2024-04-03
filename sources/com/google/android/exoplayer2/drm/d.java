package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultDrmSessionManager.PreacquiredSessionReference f34927b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Format f34928c;

    public /* synthetic */ d(DefaultDrmSessionManager.PreacquiredSessionReference preacquiredSessionReference, Format format) {
        this.f34927b = preacquiredSessionReference;
        this.f34928c = format;
    }

    public final void run() {
        this.f34927b.lambda$acquire$0(this.f34928c);
    }
}
