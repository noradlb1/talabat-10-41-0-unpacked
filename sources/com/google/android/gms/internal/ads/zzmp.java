package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import androidx.annotation.NonNull;

final class zzmp extends AudioTrack.StreamEventCallback {
    final /* synthetic */ zzmr zza;
    final /* synthetic */ zzmq zzb;

    public zzmp(zzmq zzmq, zzmr zzmr) {
        this.zzb = zzmq;
        this.zza = zzmr;
    }

    public final void onDataRequest(AudioTrack audioTrack, int i11) {
        boolean z11;
        if (audioTrack == this.zzb.zza.zzn) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzf(z11);
        if (this.zzb.zza.zzk != null && this.zzb.zza.zzI) {
            this.zzb.zza.zzk.zzb();
        }
    }

    public final void onTearDown(@NonNull AudioTrack audioTrack) {
        boolean z11;
        if (audioTrack == this.zzb.zza.zzn) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzf(z11);
        if (this.zzb.zza.zzk != null && this.zzb.zza.zzI) {
            this.zzb.zza.zzk.zzb();
        }
    }
}
