package com.google.android.exoplayer2;

public final /* synthetic */ class c1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StreamVolumeManager f34921b;

    public /* synthetic */ c1(StreamVolumeManager streamVolumeManager) {
        this.f34921b = streamVolumeManager;
    }

    public final void run() {
        this.f34921b.updateVolumeAndNotifyIfChanged();
    }
}
