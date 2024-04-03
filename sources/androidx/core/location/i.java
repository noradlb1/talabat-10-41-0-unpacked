package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f11342b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f11343c;

    public /* synthetic */ i(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str) {
        this.f11342b = locationListenerTransport;
        this.f11343c = str;
    }

    public final void run() {
        this.f11342b.lambda$onProviderEnabled$4(this.f11343c);
    }
}
