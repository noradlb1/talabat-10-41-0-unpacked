package com.google.android.exoplayer2.offline;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.offline.DownloadHelper;

public final /* synthetic */ class a implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DownloadHelper.MediaPreparer f34978b;

    public /* synthetic */ a(DownloadHelper.MediaPreparer mediaPreparer) {
        this.f34978b = mediaPreparer;
    }

    public final boolean handleMessage(Message message) {
        return this.f34978b.handleDownloadHelperCallbackMessage(message);
    }
}
