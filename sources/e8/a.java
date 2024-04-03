package e8;

import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HlsSampleStreamWrapper.Callback f35180b;

    public /* synthetic */ a(HlsSampleStreamWrapper.Callback callback) {
        this.f35180b = callback;
    }

    public final void run() {
        this.f35180b.onPrepared();
    }
}
