package zq;

import com.google.android.gms.maps.GoogleMap;
import com.talabat.gms.maps.data.GoogleFrameworkMap;
import com.talabat.maps.domain.FrameworkMap;

public final /* synthetic */ class c implements GoogleMap.OnCameraMoveStartedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FrameworkMap.OnCameraMoveStartedListener f63094b;

    public /* synthetic */ c(FrameworkMap.OnCameraMoveStartedListener onCameraMoveStartedListener) {
        this.f63094b = onCameraMoveStartedListener;
    }

    public final void onCameraMoveStarted(int i11) {
        GoogleFrameworkMap.m10593setOnCameraMoveStartedListener$lambda0(this.f63094b, i11);
    }
}
