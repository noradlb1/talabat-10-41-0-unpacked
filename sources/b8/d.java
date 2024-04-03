package b8;

import com.google.android.exoplayer2.source.ads.ServerSideAdInsertionMediaSource;
import com.google.common.collect.ImmutableMap;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ServerSideAdInsertionMediaSource f34898b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImmutableMap f34899c;

    public /* synthetic */ d(ServerSideAdInsertionMediaSource serverSideAdInsertionMediaSource, ImmutableMap immutableMap) {
        this.f34898b = serverSideAdInsertionMediaSource;
        this.f34899c = immutableMap;
    }

    public final void run() {
        this.f34898b.lambda$setAdPlaybackStates$0(this.f34899c);
    }
}
