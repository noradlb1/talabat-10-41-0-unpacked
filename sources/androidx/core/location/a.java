package androidx.core.location;

import android.location.LocationManager;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationManager f11326b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f11327c;

    public /* synthetic */ a(LocationManager locationManager, LocationManagerCompat.GpsStatusTransport gpsStatusTransport) {
        this.f11326b = locationManager;
        this.f11327c = gpsStatusTransport;
    }

    public final Object call() {
        return Boolean.valueOf(this.f11326b.addGpsStatusListener(this.f11327c));
    }
}
