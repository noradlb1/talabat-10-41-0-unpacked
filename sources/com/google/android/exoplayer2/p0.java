package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;

public final /* synthetic */ class p0 implements MediaSource.MediaSourceCaller {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList f34983b;

    public /* synthetic */ p0(MediaSourceList mediaSourceList) {
        this.f34983b = mediaSourceList;
    }

    public final void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline) {
        this.f34983b.lambda$prepareChildSource$0(mediaSource, timeline);
    }
}
