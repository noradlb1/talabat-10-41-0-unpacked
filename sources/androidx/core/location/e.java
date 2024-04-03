package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f11332b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f11333c;

    public /* synthetic */ e(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor) {
        this.f11332b = gpsStatusTransport;
        this.f11333c = executor;
    }

    public final void run() {
        this.f11332b.lambda$onGpsStatusChanged$0(this.f11333c);
    }
}
