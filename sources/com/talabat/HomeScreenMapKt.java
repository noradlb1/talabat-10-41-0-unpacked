package com.talabat;

import com.google.android.gms.maps.model.LatLng;
import com.talabat.maps.domain.LatLngFactory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"toGoogle", "Lcom/google/android/gms/maps/model/LatLng;", "Lcom/talabat/maps/domain/model/LatLng;", "toOur", "adapter", "Lcom/talabat/maps/domain/LatLngFactory;", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenMapKt {
    /* access modifiers changed from: private */
    public static final LatLng toGoogle(com.talabat.maps.domain.model.LatLng latLng) {
        return new LatLng(latLng.getLatitude(), latLng.getLongitude());
    }

    /* access modifiers changed from: private */
    public static final com.talabat.maps.domain.model.LatLng toOur(LatLng latLng, LatLngFactory latLngFactory) {
        return latLngFactory.createLatLng(latLng.latitude, latLng.longitude);
    }
}
