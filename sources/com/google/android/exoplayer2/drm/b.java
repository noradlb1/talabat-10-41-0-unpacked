package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.util.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Exception f34925a;

    public /* synthetic */ b(Exception exc) {
        this.f34925a = exc;
    }

    public final void accept(Object obj) {
        ((DrmSessionEventListener.EventDispatcher) obj).drmSessionManagerError(this.f34925a);
    }
}
