package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

@TargetApi(24)
final class zzaqy {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb = new MediaCodec.CryptoInfo.Pattern(0, 0);

    public /* synthetic */ zzaqy(MediaCodec.CryptoInfo cryptoInfo, zzaqx zzaqx) {
        this.zza = cryptoInfo;
    }

    public static /* bridge */ /* synthetic */ void zza(zzaqy zzaqy, int i11, int i12) {
        zzaqy.zzb.set(0, 0);
        zzaqy.zza.setPattern(zzaqy.zzb);
    }
}
