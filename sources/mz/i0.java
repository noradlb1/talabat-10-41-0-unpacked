package mz;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.uxcam.internals.hm;

public final /* synthetic */ class i0 implements OnMapReadyCallback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MapView f23972b;

    public /* synthetic */ i0(MapView mapView) {
        this.f23972b = mapView;
    }

    public final void onMapReady(GoogleMap googleMap) {
        hm.a(this.f23972b, googleMap);
    }
}
