package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ExoPlayerImplInternal;

public final /* synthetic */ class z implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl f35084b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImplInternal.PlaybackInfoUpdate f35085c;

    public /* synthetic */ z(ExoPlayerImpl exoPlayerImpl, ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        this.f35084b = exoPlayerImpl;
        this.f35085c = playbackInfoUpdate;
    }

    public final void run() {
        this.f35084b.lambda$new$1(this.f35085c);
    }
}
