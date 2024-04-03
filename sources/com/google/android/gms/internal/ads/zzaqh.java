package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

@TargetApi(19)
final class zzaqh extends zzaqg {
    private final AudioTimestamp zzb = new AudioTimestamp();
    private long zzc;
    private long zzd;
    private long zze;

    public zzaqh() {
        super((zzaqf) null);
    }

    public final long zzc() {
        return this.zze;
    }

    public final long zzd() {
        return this.zzb.nanoTime;
    }

    public final void zzg(AudioTrack audioTrack, boolean z11) {
        super.zzg(audioTrack, z11);
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
    }

    public final boolean zzh() {
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
