package zq;

import com.google.android.gms.maps.GoogleMap;
import com.talabat.gms.maps.data.GoogleFrameworkMap;
import com.talabat.maps.domain.FrameworkMap;

public final /* synthetic */ class b implements GoogleMap.OnCameraIdleListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FrameworkMap.OnCameraIdleListener f63093b;

    public /* synthetic */ b(FrameworkMap.OnCameraIdleListener onCameraIdleListener) {
        this.f63093b = onCameraIdleListener;
    }

    public final void onCameraIdle() {
        GoogleFrameworkMap.m10590setOnCameraIdleListener$lambda3(this.f63093b);
    }
}
