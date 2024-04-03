package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.CancellableLocationListener f11329b;

    public /* synthetic */ c(LocationManagerCompat.CancellableLocationListener cancellableLocationListener) {
        this.f11329b = cancellableLocationListener;
    }

    public final void run() {
        this.f11329b.lambda$startTimeout$0();
    }
}
