package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f11356b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f11357c;

    public /* synthetic */ o(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
        this.f11356b = preRGnssStatusTransport;
        this.f11357c = executor;
    }

    public final void run() {
        this.f11356b.lambda$onStarted$0(this.f11357c);
    }
}
