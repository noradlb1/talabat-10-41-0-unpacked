package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.DownloadService;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DownloadService.ForegroundNotificationUpdater f34981b;

    public /* synthetic */ d(DownloadService.ForegroundNotificationUpdater foregroundNotificationUpdater) {
        this.f34981b = foregroundNotificationUpdater;
    }

    public final void run() {
        this.f34981b.update();
    }
}
