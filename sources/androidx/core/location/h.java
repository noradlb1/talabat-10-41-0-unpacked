package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f11339b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f11340c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ GnssStatusCompat f11341d;

    public /* synthetic */ h(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor, GnssStatusCompat gnssStatusCompat) {
        this.f11339b = gpsStatusTransport;
        this.f11340c = executor;
        this.f11341d = gnssStatusCompat;
    }

    public final void run() {
        this.f11339b.lambda$onGpsStatusChanged$3(this.f11340c, this.f11341d);
    }
}
