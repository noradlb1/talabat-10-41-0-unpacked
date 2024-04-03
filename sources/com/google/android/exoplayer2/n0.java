package com.google.android.exoplayer2;

public final /* synthetic */ class n0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImplInternal f34968b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PlayerMessage f34969c;

    public /* synthetic */ n0(ExoPlayerImplInternal exoPlayerImplInternal, PlayerMessage playerMessage) {
        this.f34968b = exoPlayerImplInternal;
        this.f34969c = playerMessage;
    }

    public final void run() {
        this.f34968b.lambda$sendMessageToTargetThread$1(this.f34969c);
    }
}
