package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f11334b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f11335c;

    public /* synthetic */ f(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor) {
        this.f11334b = gpsStatusTransport;
        this.f11335c = executor;
    }

    public final void run() {
        this.f11334b.lambda$onGpsStatusChanged$1(this.f11335c);
    }
}
