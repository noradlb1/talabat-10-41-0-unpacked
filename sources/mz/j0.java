package mz;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.uxcam.internals.hm;

public final /* synthetic */ class j0 implements OnMapReadyCallback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MapFragment f23973b;

    public /* synthetic */ j0(MapFragment mapFragment) {
        this.f23973b = mapFragment;
    }

    public final void onMapReady(GoogleMap googleMap) {
        hm.a(this.f23973b, googleMap);
    }
}
