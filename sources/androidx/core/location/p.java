package androidx.core.location;

import android.location.GnssStatus;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f11358b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f11359c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ GnssStatus f11360d;

    public /* synthetic */ p(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, GnssStatus gnssStatus) {
        this.f11358b = preRGnssStatusTransport;
        this.f11359c = executor;
        this.f11360d = gnssStatus;
    }

    public final void run() {
        this.f11358b.lambda$onSatelliteStatusChanged$3(this.f11359c, this.f11360d);
    }
}
