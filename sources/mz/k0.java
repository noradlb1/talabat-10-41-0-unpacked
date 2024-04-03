package mz;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.uxcam.internals.hm;

public final /* synthetic */ class k0 implements OnMapReadyCallback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SupportMapFragment f23977b;

    public /* synthetic */ k0(SupportMapFragment supportMapFragment) {
        this.f23977b = supportMapFragment;
    }

    public final void onMapReady(GoogleMap googleMap) {
        hm.a(this.f23977b, googleMap);
    }
}
