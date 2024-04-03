package as;

import com.huawei.hms.maps.HuaweiMap;
import com.talabat.hms.maps.data.HuaweiFrameworkMap;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class c implements HuaweiMap.OnMapLoadedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0 f58130a;

    public /* synthetic */ c(Function0 function0) {
        this.f58130a = function0;
    }

    public final void onMapLoaded() {
        HuaweiFrameworkMap.m10636setOnMapLoadedCallback$lambda5(this.f58130a);
    }
}
