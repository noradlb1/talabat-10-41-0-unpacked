package zq;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.talabat.gms.maps.data.DefaultSupportMapFragment;

public final /* synthetic */ class a implements OnMapReadyCallback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.talabat.maps.domain.OnMapReadyCallback f63092b;

    public /* synthetic */ a(com.talabat.maps.domain.OnMapReadyCallback onMapReadyCallback) {
        this.f63092b = onMapReadyCallback;
    }

    public final void onMapReady(GoogleMap googleMap) {
        DefaultSupportMapFragment.m10589getMapAsync$lambda0(this.f63092b, googleMap);
    }
}
