package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

public final class zzaqz {
    public byte[] zza;
    public byte[] zzb;
    public int zzc;
    public int[] zzd;
    public int[] zze;
    public int zzf;
    private final MediaCodec.CryptoInfo zzg;
    private final zzaqy zzh;

    public zzaqz() {
        MediaCodec.CryptoInfo cryptoInfo;
        int i11 = zzaxb.zza;
        zzaqy zzaqy = null;
        if (i11 >= 16) {
            cryptoInfo = new MediaCodec.CryptoInfo();
        } else {
            cryptoInfo = null;
        }
        this.zzg = cryptoInfo;
        this.zzh = i11 >= 24 ? new zzaqy(cryptoInfo, (zzaqx) null) : zzaqy;
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo zza() {
        return this.zzg;
    }

    public final void zzb(int i11, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i12) {
        this.zzf = i11;
        this.zzd = iArr;
        this.zze = iArr2;
        this.zzb = bArr;
        this.zza = bArr2;
        this.zzc = 1;
        int i13 = zzaxb.zza;
        if (i13 >= 16) {
            MediaCodec.CryptoInfo cryptoInfo = this.zzg;
            cryptoInfo.numSubSamples = i11;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr;
            cryptoInfo.iv = bArr2;
            cryptoInfo.mode = 1;
            if (i13 >= 24) {
                zzaqy.zza(this.zzh, 0, 0);
            }
        }
    }
}
