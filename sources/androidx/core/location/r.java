package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f11364b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f11365c;

    public /* synthetic */ r(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
        this.f11364b = preRGnssStatusTransport;
        this.f11365c = executor;
    }

    public final void run() {
        this.f11364b.lambda$onStopped$1(this.f11365c);
    }
}
