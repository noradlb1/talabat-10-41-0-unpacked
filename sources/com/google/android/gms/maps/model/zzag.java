package com.google.android.gms.maps.model;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.maps.zzao;

final class zzag extends zzao {
    final /* synthetic */ TileProvider zza;

    public zzag(TileOverlayOptions tileOverlayOptions, TileProvider tileProvider) {
        this.zza = tileProvider;
    }

    @Nullable
    public final Tile zzb(int i11, int i12, int i13) {
        return this.zza.getTile(i11, i12, i13);
    }
}
