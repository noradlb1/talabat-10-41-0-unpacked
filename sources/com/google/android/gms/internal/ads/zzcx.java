package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import androidx.annotation.Nullable;

public final class zzcx {
    @Nullable
    public byte[] zza;
    @Nullable
    public byte[] zzb;
    public int zzc;
    @Nullable
    public int[] zzd;
    @Nullable
    public int[] zze;
    public int zzf;
    public int zzg;
    public int zzh;
    private final MediaCodec.CryptoInfo zzi;
    @Nullable
    private final zzcw zzj;

    public zzcx() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.zzi = cryptoInfo;
        this.zzj = zzfn.zza >= 24 ? new zzcw(cryptoInfo, (zzcv) null) : null;
    }

    public final MediaCodec.CryptoInfo zza() {
        return this.zzi;
    }

    public final void zzb(int i11) {
        if (i11 != 0) {
            if (this.zzd == null) {
                int[] iArr = new int[1];
                this.zzd = iArr;
                this.zzi.numBytesOfClearData = iArr;
            }
            int[] iArr2 = this.zzd;
            iArr2[0] = iArr2[0] + i11;
        }
    }

    public final void zzc(int i11, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i12, int i13, int i14) {
        this.zzf = i11;
        this.zzd = iArr;
        this.zze = iArr2;
        this.zzb = bArr;
        this.zza = bArr2;
        this.zzc = i12;
        this.zzg = i13;
        this.zzh = i14;
        MediaCodec.CryptoInfo cryptoInfo = this.zzi;
        cryptoInfo.numSubSamples = i11;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i12;
        if (zzfn.zza >= 24) {
            zzcw zzcw = this.zzj;
            zzcw.getClass();
            zzcw.zza(zzcw, i13, i14);
        }
    }
}
