package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

@TargetApi(21)
final class zzatn implements zzatk {
    private final int zza;
    private MediaCodecInfo[] zzb;

    public zzatn(boolean z11) {
        this.zza = z11 ? 1 : 0;
    }

    private final void zze() {
        if (this.zzb == null) {
            this.zzb = new MediaCodecList(this.zza).getCodecInfos();
        }
    }

    public final int zza() {
        zze();
        return this.zzb.length;
    }

    public final MediaCodecInfo zzb(int i11) {
        zze();
        return this.zzb[i11];
    }

    public final boolean zzc(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public final boolean zzd() {
        return true;
    }
}
