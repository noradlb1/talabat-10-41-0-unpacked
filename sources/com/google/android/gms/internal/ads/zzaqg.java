package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;

class zzaqg {
    protected AudioTrack zza;
    private boolean zzb;
    private int zzc;
    private long zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;

    private zzaqg() {
    }

    public /* synthetic */ zzaqg(zzaqf zzaqf) {
    }

    public final long zza() {
        if (this.zzg != C.TIME_UNSET) {
            return Math.min(this.zzi, this.zzh + ((((SystemClock.elapsedRealtime() * 1000) - this.zzg) * ((long) this.zzc)) / 1000000));
        }
        int playState = this.zza.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = ((long) this.zza.getPlaybackHeadPosition()) & 4294967295L;
        if (this.zzb) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.zzf = this.zzd;
            }
            playbackHeadPosition += this.zzf;
        }
        if (this.zzd > playbackHeadPosition) {
            this.zze++;
        }
        this.zzd = playbackHeadPosition;
        return playbackHeadPosition + (this.zze << 32);
    }

    public final long zzb() {
        return (zza() * 1000000) / ((long) this.zzc);
    }

    public long zzc() {
        throw new UnsupportedOperationException();
    }

    public long zzd() {
        throw new UnsupportedOperationException();
    }

    public final void zze(long j11) {
        this.zzh = zza();
        this.zzg = SystemClock.elapsedRealtime() * 1000;
        this.zzi = j11;
        this.zza.stop();
    }

    public final void zzf() {
        if (this.zzg == C.TIME_UNSET) {
            this.zza.pause();
        }
    }

    public void zzg(AudioTrack audioTrack, boolean z11) {
        this.zza = audioTrack;
        this.zzb = z11;
        this.zzg = C.TIME_UNSET;
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        if (audioTrack != null) {
            this.zzc = audioTrack.getSampleRate();
        }
    }

    public boolean zzh() {
        return false;
    }
}
