package com.talabat;

import com.talabat.CheckOutScreen;
import com.talabat.maps.domain.OnMapClickListener;
import com.talabat.maps.domain.model.LatLng;

public final /* synthetic */ class a implements OnMapClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen.AnonymousClass40 f55085a;

    public /* synthetic */ a(CheckOutScreen.AnonymousClass40 r12) {
        this.f55085a = r12;
    }

    public final void onMapClick(LatLng latLng) {
        this.f55085a.lambda$onMapReady$0(latLng);
    }
}
