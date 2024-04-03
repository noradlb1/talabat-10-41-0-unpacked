package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f11336b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f11337c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f11338d;

    public /* synthetic */ g(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor, int i11) {
        this.f11336b = gpsStatusTransport;
        this.f11337c = executor;
        this.f11338d = i11;
    }

    public final void run() {
        this.f11336b.lambda$onGpsStatusChanged$2(this.f11337c, this.f11338d);
    }
}
