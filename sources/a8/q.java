package a8;

import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f34876b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f34877c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f34878d;

    public /* synthetic */ q(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, MediaLoadData mediaLoadData) {
        this.f34876b = eventDispatcher;
        this.f34877c = mediaSourceEventListener;
        this.f34878d = mediaLoadData;
    }

    public final void run() {
        this.f34876b.lambda$downstreamFormatChanged$5(this.f34877c, this.f34878d);
    }
}
