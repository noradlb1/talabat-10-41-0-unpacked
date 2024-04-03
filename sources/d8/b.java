package d8;

import com.google.android.exoplayer2.source.dash.DashMediaSource;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DashMediaSource f35178b;

    public /* synthetic */ b(DashMediaSource dashMediaSource) {
        this.f35178b = dashMediaSource;
    }

    public final void run() {
        this.f35178b.startLoadingManifest();
    }
}
