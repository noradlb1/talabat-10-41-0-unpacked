package com.google.android.gms.internal.ads;

final class zzgiy extends zzgjb {
    private final int zzc;
    private final int zzd;

    public zzgiy(byte[] bArr, int i11, int i12) {
        super(bArr);
        zzgjf.zzq(i11, i11 + i12, bArr.length);
        this.zzc = i11;
        this.zzd = i12;
    }

    public final byte zza(int i11) {
        zzgjf.zzB(i11, this.zzd);
        return this.zza[this.zzc + i11];
    }

    public final byte zzb(int i11) {
        return this.zza[this.zzc + i11];
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzd;
    }

    public final void zze(byte[] bArr, int i11, int i12, int i13) {
        System.arraycopy(this.zza, this.zzc + i11, bArr, i12, i13);
    }
}
