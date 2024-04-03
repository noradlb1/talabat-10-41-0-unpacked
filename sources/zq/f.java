package zq;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.gms.maps.data.GoogleFrameworkMap;
import com.talabat.maps.domain.OnMapClickListener;

public final /* synthetic */ class f implements GoogleMap.OnMapClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnMapClickListener f63097b;

    public /* synthetic */ f(OnMapClickListener onMapClickListener) {
        this.f63097b = onMapClickListener;
    }

    public final void onMapClick(LatLng latLng) {
        GoogleFrameworkMap.m10594setOnMapClickListener$lambda4(this.f63097b, latLng);
    }
}
