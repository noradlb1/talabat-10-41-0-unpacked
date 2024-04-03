package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f11344b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f11345c;

    public /* synthetic */ j(LocationManagerCompat.LocationListenerTransport locationListenerTransport, int i11) {
        this.f11344b = locationListenerTransport;
        this.f11345c = i11;
    }

    public final void run() {
        this.f11344b.lambda$onFlushComplete$2(this.f11345c);
    }
}
