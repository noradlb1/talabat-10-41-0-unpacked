package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import androidx.annotation.RequiresApi;

@RequiresApi(24)
final class zzcw {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb = new MediaCodec.CryptoInfo.Pattern(0, 0);

    public /* synthetic */ zzcw(MediaCodec.CryptoInfo cryptoInfo, zzcv zzcv) {
        this.zza = cryptoInfo;
    }

    public static /* bridge */ /* synthetic */ void zza(zzcw zzcw, int i11, int i12) {
        zzcw.zzb.set(i11, i12);
        zzcw.zza.setPattern(zzcw.zzb);
    }
}
