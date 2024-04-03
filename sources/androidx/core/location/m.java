package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f11350b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Location f11351c;

    public /* synthetic */ m(LocationManagerCompat.LocationListenerTransport locationListenerTransport, Location location) {
        this.f11350b = locationListenerTransport;
        this.f11351c = location;
    }

    public final void run() {
        this.f11350b.lambda$onLocationChanged$0(this.f11351c);
    }
}
