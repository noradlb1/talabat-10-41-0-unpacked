package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import java.io.IOException;

public final /* synthetic */ class t0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f35041b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Pair f35042c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f35043d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f35044e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ IOException f35045f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f35046g;

    public /* synthetic */ t0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z11) {
        this.f35041b = forwardingEventListener;
        this.f35042c = pair;
        this.f35043d = loadEventInfo;
        this.f35044e = mediaLoadData;
        this.f35045f = iOException;
        this.f35046g = z11;
    }

    public final void run() {
        this.f35041b.lambda$onLoadError$3(this.f35042c, this.f35043d, this.f35044e, this.f35045f, this.f35046g);
    }
}
