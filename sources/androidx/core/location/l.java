package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f11348b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f11349c;

    public /* synthetic */ l(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str) {
        this.f11348b = locationListenerTransport;
        this.f11349c = str;
    }

    public final void run() {
        this.f11348b.lambda$onProviderDisabled$5(this.f11349c);
    }
}
