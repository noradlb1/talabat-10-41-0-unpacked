package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.List;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f11346b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f11347c;

    public /* synthetic */ k(LocationManagerCompat.LocationListenerTransport locationListenerTransport, List list) {
        this.f11346b = locationListenerTransport;
        this.f11347c = list;
    }

    public final void run() {
        this.f11346b.lambda$onLocationChanged$1(this.f11347c);
    }
}
