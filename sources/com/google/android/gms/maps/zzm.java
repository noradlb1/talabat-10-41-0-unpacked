package com.google.android.gms.maps;

import com.google.android.gms.internal.maps.zzr;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.GroundOverlay;

final class zzm extends zzy {
    final /* synthetic */ GoogleMap.OnGroundOverlayClickListener zza;

    public zzm(GoogleMap googleMap, GoogleMap.OnGroundOverlayClickListener onGroundOverlayClickListener) {
        this.zza = onGroundOverlayClickListener;
    }

    public final void zzb(zzr zzr) {
        this.zza.onGroundOverlayClick(new GroundOverlay(zzr));
    }
}
