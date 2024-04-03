package com.google.android.exoplayer2.mediacodec;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AsynchronousMediaCodecCallback f34959b;

    public /* synthetic */ b(AsynchronousMediaCodecCallback asynchronousMediaCodecCallback) {
        this.f34959b = asynchronousMediaCodecCallback;
    }

    public final void run() {
        this.f34959b.onFlushCompleted();
    }
}
