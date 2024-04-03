package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbes;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzcbr;
import com.google.android.gms.internal.ads.zzdmd;

public final class zzv extends zzcbr {
    private final AdOverlayInfoParcel zza;
    private final Activity zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public zzv(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zza = adOverlayInfoParcel;
        this.zzb = activity;
    }

    private final synchronized void zzb() {
        if (!this.zzd) {
            zzo zzo = this.zza.zzc;
            if (zzo != null) {
                zzo.zzf(4);
            }
            this.zzd = true;
        }
    }

    public final boolean zzE() throws RemoteException {
        return false;
    }

    public final void zzg(int i11, int i12, Intent intent) throws RemoteException {
    }

    public final void zzh() throws RemoteException {
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzk(@Nullable Bundle bundle) {
        zzo zzo;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgy)).booleanValue()) {
            this.zzb.requestWindowFeature(1);
        }
        boolean z11 = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z11 = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zza;
        if (adOverlayInfoParcel == null) {
            this.zzb.finish();
        } else if (z11) {
            this.zzb.finish();
        } else {
            if (bundle == null) {
                zzbes zzbes = adOverlayInfoParcel.zzb;
                if (zzbes != null) {
                    zzbes.onAdClicked();
                }
                zzdmd zzdmd = this.zza.zzy;
                if (zzdmd != null) {
                    zzdmd.zzq();
                }
                if (!(this.zzb.getIntent() == null || !this.zzb.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) || (zzo = this.zza.zzc) == null)) {
                    zzo.zzb();
                }
            }
            zzt.zzi();
            Activity activity = this.zzb;
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zza;
            zzc zzc2 = adOverlayInfoParcel2.zza;
            if (!zza.zzb(activity, zzc2, adOverlayInfoParcel2.zzi, zzc2.zzi)) {
                this.zzb.finish();
            }
        }
    }

    public final void zzl() throws RemoteException {
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzn() throws RemoteException {
        zzo zzo = this.zza.zzc;
        if (zzo != null) {
            zzo.zzbz();
        }
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzo() throws RemoteException {
    }

    public final void zzp() throws RemoteException {
        if (this.zzc) {
            this.zzb.finish();
            return;
        }
        this.zzc = true;
        zzo zzo = this.zza.zzc;
        if (zzo != null) {
            zzo.zzbS();
        }
    }

    public final void zzq(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzc);
    }

    public final void zzr() throws RemoteException {
    }

    public final void zzs() throws RemoteException {
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzt() throws RemoteException {
        zzo zzo = this.zza.zzc;
        if (zzo != null) {
            zzo.zze();
        }
    }

    public final void zzv() throws RemoteException {
    }
}
