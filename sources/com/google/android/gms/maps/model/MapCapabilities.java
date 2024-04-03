package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zzaa;

public final class MapCapabilities {
    private final zzaa zza;

    public MapCapabilities(zzaa zzaa) {
        this.zza = (zzaa) Preconditions.checkNotNull(zzaa);
    }

    public boolean isAdvancedMarkersAvailable() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }
}
