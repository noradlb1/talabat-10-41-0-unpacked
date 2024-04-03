package a8;

import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f34889b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f34890c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f34891d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f34892e;

    public /* synthetic */ t(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f34889b = eventDispatcher;
        this.f34890c = mediaSourceEventListener;
        this.f34891d = loadEventInfo;
        this.f34892e = mediaLoadData;
    }

    public final void run() {
        this.f34889b.lambda$loadCanceled$2(this.f34890c, this.f34891d, this.f34892e);
    }
}
