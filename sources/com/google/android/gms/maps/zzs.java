package com.google.android.gms.maps;

import com.google.android.gms.internal.maps.zzaa;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzak;
import com.google.android.gms.maps.model.MapCapabilities;

final class zzs extends zzak {
    final /* synthetic */ GoogleMap.OnMapCapabilitiesChangedListener zza;

    public zzs(GoogleMap googleMap, GoogleMap.OnMapCapabilitiesChangedListener onMapCapabilitiesChangedListener) {
        this.zza = onMapCapabilitiesChangedListener;
    }

    public final void zzb(zzaa zzaa) {
        this.zza.onMapCapabilitiesChanged(new MapCapabilities(zzaa));
    }
}
