package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzbbb {
    final /* synthetic */ zzbbc zza;
    private final byte[] zzb;
    private int zzc;

    public /* synthetic */ zzbbb(zzbbc zzbbc, byte[] bArr, zzbba zzbba) {
        this.zza = zzbbc;
        this.zzb = bArr;
    }

    public final zzbbb zza(int i11) {
        this.zzc = i11;
        return this;
    }

    public final synchronized void zzb() {
        try {
            zzbbc zzbbc = this.zza;
            if (zzbbc.zzb) {
                zzbbc.zza.zzj(this.zzb);
                this.zza.zza.zzi(0);
                this.zza.zza.zzg(this.zzc);
                this.zza.zza.zzh((int[]) null);
                this.zza.zza.zzf();
            }
        } catch (RemoteException e11) {
            zzciz.zzf("Clearcut log failed", e11);
        }
    }
}
