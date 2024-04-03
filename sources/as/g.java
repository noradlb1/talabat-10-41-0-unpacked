package as;

import com.huawei.hms.maps.HuaweiMap;
import com.talabat.hms.maps.data.HuaweiFrameworkMap;
import com.talabat.maps.domain.FrameworkMap;

public final /* synthetic */ class g implements HuaweiMap.OnCameraMoveStartedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameworkMap.OnCameraMoveStartedListener f58134a;

    public /* synthetic */ g(FrameworkMap.OnCameraMoveStartedListener onCameraMoveStartedListener) {
        this.f58134a = onCameraMoveStartedListener;
    }

    public final void onCameraMoveStarted(int i11) {
        HuaweiFrameworkMap.m10634setOnCameraMoveStartedListener$lambda0(this.f58134a, i11);
    }
}
