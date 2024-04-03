package h8;

import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SsMediaSource f35454b;

    public /* synthetic */ a(SsMediaSource ssMediaSource) {
        this.f35454b = ssMediaSource;
    }

    public final void run() {
        this.f35454b.startLoadingManifest();
    }
}
