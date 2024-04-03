package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

final class zzcad implements zzo {
    final /* synthetic */ zzcaf zza;

    public zzcad(zzcaf zzcaf) {
        this.zza = zzcaf;
    }

    public final void zzb() {
        zzciz.zze("Opening AdMobCustomTabsAdapter overlay.");
        this.zza.zzb.onAdOpened(this.zza);
    }

    public final void zzbK() {
        zzciz.zze("Delay close AdMobCustomTabsAdapter overlay.");
    }

    public final void zzbS() {
        zzciz.zze("AdMobCustomTabsAdapter overlay is resumed.");
    }

    public final void zzbz() {
        zzciz.zze("AdMobCustomTabsAdapter overlay is paused.");
    }

    public final void zze() {
    }

    public final void zzf(int i11) {
        zzciz.zze("AdMobCustomTabsAdapter overlay is closed.");
        this.zza.zzb.onAdClosed(this.zza);
    }
}
