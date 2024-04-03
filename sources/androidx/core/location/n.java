package androidx.core.location;

import android.os.Bundle;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f11352b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f11353c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f11354d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Bundle f11355e;

    public /* synthetic */ n(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str, int i11, Bundle bundle) {
        this.f11352b = locationListenerTransport;
        this.f11353c = str;
        this.f11354d = i11;
        this.f11355e = bundle;
    }

    public final void run() {
        this.f11352b.lambda$onStatusChanged$3(this.f11353c, this.f11354d, this.f11355e);
    }
}
