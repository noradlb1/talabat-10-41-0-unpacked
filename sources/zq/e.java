package zq;

import com.google.android.gms.maps.GoogleMap;
import com.talabat.gms.maps.data.GoogleFrameworkMap;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class e implements GoogleMap.OnMapLoadedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0 f63096a;

    public /* synthetic */ e(Function0 function0) {
        this.f63096a = function0;
    }

    public final void onMapLoaded() {
        GoogleFrameworkMap.m10595setOnMapLoadedCallback$lambda5(this.f63096a);
    }
}
