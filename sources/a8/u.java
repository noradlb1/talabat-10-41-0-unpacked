package a8;

import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f34893b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f34894c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaSource.MediaPeriodId f34895d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f34896e;

    public /* synthetic */ u(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        this.f34893b = eventDispatcher;
        this.f34894c = mediaSourceEventListener;
        this.f34895d = mediaPeriodId;
        this.f34896e = mediaLoadData;
    }

    public final void run() {
        this.f34893b.lambda$upstreamDiscarded$4(this.f34894c, this.f34895d, this.f34896e);
    }
}
