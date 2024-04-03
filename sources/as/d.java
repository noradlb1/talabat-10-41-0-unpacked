package as;

import com.huawei.hms.maps.HuaweiMap;
import com.talabat.hms.maps.data.HuaweiFrameworkMap;
import com.talabat.maps.domain.FrameworkMap;

public final /* synthetic */ class d implements HuaweiMap.OnCameraIdleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameworkMap.OnCameraIdleListener f58131a;

    public /* synthetic */ d(FrameworkMap.OnCameraIdleListener onCameraIdleListener) {
        this.f58131a = onCameraIdleListener;
    }

    public final void onCameraIdle() {
        HuaweiFrameworkMap.m10631setOnCameraIdleListener$lambda3(this.f58131a);
    }
}
