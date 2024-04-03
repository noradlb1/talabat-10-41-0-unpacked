package com.google.android.gms.internal.ads;

import android.media.AudioFormat;
import android.media.AudioTrack;

final class zzmh {
    public final zzab zza;
    public final int zzb;
    public final int zzc = 0;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final zzlh[] zzi;

    public zzmh(zzab zzab, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z11, zzlh[] zzlhArr) {
        this.zza = zzab;
        this.zzb = i11;
        boolean z12 = false;
        this.zzd = i13;
        this.zze = i14;
        this.zzf = i15;
        this.zzg = i16;
        this.zzi = zzlhArr;
        int minBufferSize = AudioTrack.getMinBufferSize(i14, i15, i16);
        zzdy.zzf(minBufferSize != -2 ? true : z12);
        this.zzh = zzfn.zzf(minBufferSize * 4, ((int) zza(250000)) * i13, Math.max(minBufferSize, ((int) zza(750000)) * i13));
    }

    public final long zza(long j11) {
        return (j11 * ((long) this.zze)) / 1000000;
    }

    public final long zzb(long j11) {
        return (j11 * 1000000) / ((long) this.zze);
    }

    public final AudioTrack zzc(boolean z11, zzg zzg2, int i11) throws zzlv {
        AudioTrack audioTrack;
        try {
            int i12 = zzfn.zza;
            if (i12 >= 29) {
                audioTrack = new AudioTrack.Builder().setAudioAttributes(zzg2.zza()).setAudioFormat(new AudioFormat.Builder().setSampleRate(this.zze).setChannelMask(this.zzf).setEncoding(this.zzg).build()).setTransferMode(1).setBufferSizeInBytes(this.zzh).setSessionId(i11).setOffloadedPlayback(false).build();
            } else if (i12 >= 21) {
                audioTrack = new AudioTrack(zzg2.zza(), new AudioFormat.Builder().setSampleRate(this.zze).setChannelMask(this.zzf).setEncoding(this.zzg).build(), this.zzh, 1, i11);
            } else {
                int i13 = zzg2.zzc;
                if (i11 == 0) {
                    audioTrack = new AudioTrack(3, this.zze, this.zzf, this.zzg, this.zzh, 1);
                } else {
                    audioTrack = new AudioTrack(3, this.zze, this.zzf, this.zzg, this.zzh, 1, i11);
                }
            }
            int state = audioTrack.getState();
            if (state == 1) {
                return audioTrack;
            }
            try {
                audioTrack.release();
            } catch (Exception unused) {
            }
            throw new zzlv(state, this.zze, this.zzf, this.zzh, this.zza, false, (Exception) null);
        } catch (IllegalArgumentException | UnsupportedOperationException e11) {
            throw new zzlv(0, this.zze, this.zzf, this.zzh, this.zza, false, e11);
        }
    }
}
