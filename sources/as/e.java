package as;

import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.model.LatLng;
import com.talabat.hms.maps.data.HuaweiFrameworkMap;
import com.talabat.maps.domain.OnMapClickListener;

public final /* synthetic */ class e implements HuaweiMap.OnMapClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OnMapClickListener f58132a;

    public /* synthetic */ e(OnMapClickListener onMapClickListener) {
        this.f58132a = onMapClickListener;
    }

    public final void onMapClick(LatLng latLng) {
        HuaweiFrameworkMap.m10635setOnMapClickListener$lambda4(this.f58132a, latLng);
    }
}
