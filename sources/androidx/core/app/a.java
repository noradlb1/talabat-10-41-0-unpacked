package androidx.core.app;

import android.app.SharedElementCallback;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;

public final /* synthetic */ class a implements SharedElementCallback.OnSharedElementsReadyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SharedElementCallback.OnSharedElementsReadyListener f11233a;

    public /* synthetic */ a(SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
        this.f11233a = onSharedElementsReadyListener;
    }

    public final void onSharedElementsReady() {
        ActivityCompat.Api23Impl.onSharedElementsReady(this.f11233a);
    }
}
