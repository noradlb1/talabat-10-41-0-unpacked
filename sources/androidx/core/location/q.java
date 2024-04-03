package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f11361b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f11362c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f11363d;

    public /* synthetic */ q(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, int i11) {
        this.f11361b = preRGnssStatusTransport;
        this.f11362c = executor;
        this.f11363d = i11;
    }

    public final void run() {
        this.f11361b.lambda$onFirstFix$2(this.f11362c, this.f11363d);
    }
}
