package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.maps.zzap;

final class zzaf implements TileProvider {
    final /* synthetic */ TileOverlayOptions zza;
    private final zzap zzb;

    public zzaf(TileOverlayOptions tileOverlayOptions) {
        this.zza = tileOverlayOptions;
        this.zzb = tileOverlayOptions.zza;
    }

    @Nullable
    public final Tile getTile(int i11, int i12, int i13) {
        try {
            return this.zzb.zzb(i11, i12, i13);
        } catch (RemoteException unused) {
            return null;
        }
    }
}
