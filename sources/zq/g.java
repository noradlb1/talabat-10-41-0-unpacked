package zq;

import com.google.android.gms.maps.GoogleMap;
import com.talabat.gms.maps.data.GoogleFrameworkMap;
import com.talabat.maps.domain.FrameworkMap;

public final /* synthetic */ class g implements GoogleMap.OnCameraMoveListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FrameworkMap.OnCameraMoveListener f63098b;

    public /* synthetic */ g(FrameworkMap.OnCameraMoveListener onCameraMoveListener) {
        this.f63098b = onCameraMoveListener;
    }

    public final void onCameraMove() {
        GoogleFrameworkMap.m10592setOnCameraMoveListener$lambda1(this.f63098b);
    }
}
