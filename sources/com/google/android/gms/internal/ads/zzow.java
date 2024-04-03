package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@RequiresApi(21)
final class zzow implements zzot {
    private final int zza;
    @Nullable
    private MediaCodecInfo[] zzb;

    public zzow(boolean z11, boolean z12) {
        int i11 = 1;
        if (!z11 && !z12) {
            i11 = 0;
        }
        this.zza = i11;
    }

    @EnsuresNonNull({"mediaCodecInfos"})
    private final void zzf() {
        if (this.zzb == null) {
            this.zzb = new MediaCodecList(this.zza).getCodecInfos();
        }
    }

    public final int zza() {
        zzf();
        return this.zzb.length;
    }

    public final MediaCodecInfo zzb(int i11) {
        zzf();
        return this.zzb[i11];
    }

    public final boolean zzc(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }

    public final boolean zzd(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    public final boolean zze() {
        return true;
    }
}
