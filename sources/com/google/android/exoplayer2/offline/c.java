package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.DownloadService;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DownloadService.DownloadManagerHelper f34979b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DownloadService f34980c;

    public /* synthetic */ c(DownloadService.DownloadManagerHelper downloadManagerHelper, DownloadService downloadService) {
        this.f34979b = downloadManagerHelper;
        this.f34980c = downloadService;
    }

    public final void run() {
        this.f34979b.lambda$attachService$0(this.f34980c);
    }
}
