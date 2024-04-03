package as;

import com.huawei.hms.maps.HuaweiMap;
import com.talabat.hms.maps.data.HuaweiFrameworkMap;
import com.talabat.maps.domain.FrameworkMap;

public final /* synthetic */ class b implements HuaweiMap.OnCameraMoveCanceledListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameworkMap.OnCameraMoveCanceledListener f58129a;

    public /* synthetic */ b(FrameworkMap.OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        this.f58129a = onCameraMoveCanceledListener;
    }

    public final void onCameraMoveCanceled() {
        HuaweiFrameworkMap.m10632setOnCameraMoveCanceledListener$lambda2(this.f58129a);
    }
}
