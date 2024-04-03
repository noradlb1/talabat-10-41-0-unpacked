package a8;

import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f34872b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f34873c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f34874d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f34875e;

    public /* synthetic */ p(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f34872b = eventDispatcher;
        this.f34873c = mediaSourceEventListener;
        this.f34874d = loadEventInfo;
        this.f34875e = mediaLoadData;
    }

    public final void run() {
        this.f34872b.lambda$loadStarted$0(this.f34873c, this.f34874d, this.f34875e);
    }
}
