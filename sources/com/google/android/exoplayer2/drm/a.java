package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.util.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f34924a;

    public /* synthetic */ a(int i11) {
        this.f34924a = i11;
    }

    public final void accept(Object obj) {
        ((DrmSessionEventListener.EventDispatcher) obj).drmSessionAcquired(this.f34924a);
    }
}
