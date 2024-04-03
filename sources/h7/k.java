package h7;

import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultAnalyticsCollector f35363b;

    public /* synthetic */ k(DefaultAnalyticsCollector defaultAnalyticsCollector) {
        this.f35363b = defaultAnalyticsCollector;
    }

    public final void run() {
        this.f35363b.releaseInternal();
    }
}
