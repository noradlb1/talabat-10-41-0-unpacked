package sg;

import com.talabat.core.fwf.data.FunWithFlags;
import fwfd.com.fwfsdk.manager.callback.FWFFeaturesCallback;
import java.util.HashMap;
import java.util.Map;

public final /* synthetic */ class b implements FWFFeaturesCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map.Entry f57399a;

    public /* synthetic */ b(Map.Entry entry) {
        this.f57399a = entry;
    }

    public final void onFwfResponse(HashMap hashMap) {
        FunWithFlags.m9590subscribe$lambda24$lambda23$lambda22(this.f57399a, hashMap);
    }
}
