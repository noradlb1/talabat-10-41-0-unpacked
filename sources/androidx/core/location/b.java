package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import androidx.core.os.CancellationSignal;

public final /* synthetic */ class b implements CancellationSignal.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.CancellableLocationListener f11328a;

    public /* synthetic */ b(LocationManagerCompat.CancellableLocationListener cancellableLocationListener) {
        this.f11328a = cancellableLocationListener;
    }

    public final void onCancel() {
        this.f11328a.cancel();
    }
}
