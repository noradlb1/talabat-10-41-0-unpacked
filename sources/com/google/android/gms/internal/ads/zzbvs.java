package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbf;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbvs extends zzcjy<zzbuo> {
    private final Object zza = new Object();
    private final zzbf<zzbuo> zzb;
    private boolean zzc;
    private int zzd;

    public zzbvs(zzbf<zzbuo> zzbf) {
        this.zzb = zzbf;
        this.zzc = false;
        this.zzd = 0;
    }

    public final zzbvn zza() {
        boolean z11;
        zzbvn zzbvn = new zzbvn(this);
        synchronized (this.zza) {
            zzi(new zzbvo(this, zzbvn), new zzbvp(this, zzbvn));
            if (this.zzd >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11);
            this.zzd++;
        }
        return zzbvn;
    }

    public final void zzb() {
        boolean z11;
        synchronized (this.zza) {
            if (this.zzd >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11);
            zze.zza("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzc = true;
            zzc();
        }
    }

    public final void zzc() {
        boolean z11;
        synchronized (this.zza) {
            if (this.zzd >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11);
            if (!this.zzc || this.zzd != 0) {
                zze.zza("There are still references to the engine. Not destroying.");
            } else {
                zze.zza("No reference is left (including root). Cleaning up engine.");
                zzi(new zzbvr(this), new zzcju());
            }
        }
    }

    public final void zzd() {
        boolean z11;
        synchronized (this.zza) {
            if (this.zzd > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11);
            zze.zza("Releasing 1 reference for JS Engine");
            this.zzd--;
            zzc();
        }
    }
}
