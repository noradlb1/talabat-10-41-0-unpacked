package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

final class zzcke implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzckm zzb;

    public zzcke(zzckm zzckm, MediaPlayer mediaPlayer) {
        this.zzb = zzckm;
        this.zza = mediaPlayer;
    }

    public final void run() {
        zzckm.zzl(this.zzb, this.zza);
        if (this.zzb.zzs != null) {
            this.zzb.zzs.zzf();
        }
    }
}
