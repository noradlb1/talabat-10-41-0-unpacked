package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzdvb implements zzbes, zzbqt, zzo, zzbqv, zzw, zzdmd {
    private zzbes zza;
    private zzbqt zzb;
    private zzo zzc;
    private zzbqv zzd;
    private zzw zze;
    private zzdmd zzf;

    /* access modifiers changed from: private */
    public final synchronized void zzi(zzbes zzbes, zzbqt zzbqt, zzo zzo, zzbqv zzbqv, zzw zzw, zzdmd zzdmd) {
        this.zza = zzbes;
        this.zzb = zzbqt;
        this.zzc = zzo;
        this.zzd = zzbqv;
        this.zze = zzw;
        this.zzf = zzdmd;
    }

    public final synchronized void onAdClicked() {
        zzbes zzbes = this.zza;
        if (zzbes != null) {
            zzbes.onAdClicked();
        }
    }

    public final synchronized void zza(String str, Bundle bundle) {
        zzbqt zzbqt = this.zzb;
        if (zzbqt != null) {
            zzbqt.zza(str, bundle);
        }
    }

    public final synchronized void zzb() {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzb();
        }
    }

    public final synchronized void zzbK() {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzbK();
        }
    }

    public final synchronized void zzbL(String str, @Nullable String str2) {
        zzbqv zzbqv = this.zzd;
        if (zzbqv != null) {
            zzbqv.zzbL(str, str2);
        }
    }

    public final synchronized void zzbS() {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzbS();
        }
    }

    public final synchronized void zzbz() {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzbz();
        }
    }

    public final synchronized void zze() {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zze();
        }
    }

    public final synchronized void zzf(int i11) {
        zzo zzo = this.zzc;
        if (zzo != null) {
            zzo.zzf(i11);
        }
    }

    public final synchronized void zzg() {
        zzw zzw = this.zze;
        if (zzw != null) {
            ((zzdvc) zzw).zza.zzb();
        }
    }

    public final synchronized void zzq() {
        zzdmd zzdmd = this.zzf;
        if (zzdmd != null) {
            zzdmd.zzq();
        }
    }
}
