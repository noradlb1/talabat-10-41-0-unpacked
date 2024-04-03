package ue;

import com.talabat.QuickOrderScreen;
import com.talabat.maps.domain.FrameworkMap;
import com.talabat.maps.domain.OnMapReadyCallback;

public final /* synthetic */ class ub implements OnMapReadyCallback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickOrderScreen f57781b;

    public /* synthetic */ ub(QuickOrderScreen quickOrderScreen) {
        this.f57781b = quickOrderScreen;
    }

    public final void onMapReady(FrameworkMap frameworkMap) {
        this.f57781b.lambda$onCreate$23(frameworkMap);
    }
}
