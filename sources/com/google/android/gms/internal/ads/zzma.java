package com.google.android.gms.internal.ads;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.annotation.RequiresApi;

@RequiresApi(19)
final class zzma {
    private final AudioTrack zza;
    private final AudioTimestamp zzb = new AudioTimestamp();
    private long zzc;
    private long zzd;
    private long zze;

    public zzma(AudioTrack audioTrack) {
        this.zza = audioTrack;
    }

    public final long zza() {
        return this.zze;
    }

    public final long zzb() {
        return this.zzb.nanoTime / 1000;
    }

    public final boolean zzc() {
        boolean timestamp = this.zza.getTimestamp(this.zzb);
        if (timestamp) {
            long j11 = this.zzb.framePosition;
            if (this.zzd > j11) {
                this.zzc++;
            }
            this.zzd = j11;
            this.zze = j11 + (this.zzc << 32);
        }
        return timestamp;
    }
}
