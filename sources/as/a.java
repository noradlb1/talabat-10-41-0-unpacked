package as;

import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.OnMapReadyCallback;
import com.talabat.hms.maps.data.DefaultHmsSupportMapFragment;

public final /* synthetic */ class a implements OnMapReadyCallback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultHmsSupportMapFragment f58127b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ com.talabat.maps.domain.OnMapReadyCallback f58128c;

    public /* synthetic */ a(DefaultHmsSupportMapFragment defaultHmsSupportMapFragment, com.talabat.maps.domain.OnMapReadyCallback onMapReadyCallback) {
        this.f58127b = defaultHmsSupportMapFragment;
        this.f58128c = onMapReadyCallback;
    }

    public final void onMapReady(HuaweiMap huaweiMap) {
        DefaultHmsSupportMapFragment.m10630getMapAsync$lambda0(this.f58127b, this.f58128c, huaweiMap);
    }
}
