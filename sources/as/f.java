package as;

import com.huawei.hms.maps.HuaweiMap;
import com.talabat.hms.maps.data.HuaweiFrameworkMap;
import com.talabat.maps.domain.FrameworkMap;

public final /* synthetic */ class f implements HuaweiMap.OnCameraMoveListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameworkMap.OnCameraMoveListener f58133a;

    public /* synthetic */ f(FrameworkMap.OnCameraMoveListener onCameraMoveListener) {
        this.f58133a = onCameraMoveListener;
    }

    public final void onCameraMove() {
        HuaweiFrameworkMap.m10633setOnCameraMoveListener$lambda1(this.f58133a);
    }
}
