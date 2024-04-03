package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

final class zzaqe extends Thread {
    final /* synthetic */ AudioTrack zza;
    final /* synthetic */ zzaqo zzb;

    public zzaqe(zzaqo zzaqo, AudioTrack audioTrack) {
        this.zzb = zzaqo;
        this.zza = audioTrack;
    }

    public final void run() {
        try {
            this.zza.flush();
            this.zza.release();
        } finally {
            this.zzb.zze.open();
        }
    }
}
