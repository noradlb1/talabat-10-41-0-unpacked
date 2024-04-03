package a8;

import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f34885b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f34886c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f34887d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f34888e;

    public /* synthetic */ s(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f34885b = eventDispatcher;
        this.f34886c = mediaSourceEventListener;
        this.f34887d = loadEventInfo;
        this.f34888e = mediaLoadData;
    }

    public final void run() {
        this.f34885b.lambda$loadCompleted$1(this.f34886c, this.f34887d, this.f34888e);
    }
}
