package a8;

import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import java.io.IOException;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f34879b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener f34880c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f34881d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f34882e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ IOException f34883f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f34884g;

    public /* synthetic */ r(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z11) {
        this.f34879b = eventDispatcher;
        this.f34880c = mediaSourceEventListener;
        this.f34881d = loadEventInfo;
        this.f34882e = mediaLoadData;
        this.f34883f = iOException;
        this.f34884g = z11;
    }

    public final void run() {
        this.f34879b.lambda$loadError$3(this.f34880c, this.f34881d, this.f34882e, this.f34883f, this.f34884g);
    }
}
