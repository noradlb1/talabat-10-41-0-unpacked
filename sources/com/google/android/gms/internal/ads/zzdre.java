package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class zzdre implements View.OnClickListener {
    @VisibleForTesting
    @Nullable
    String zza;
    @VisibleForTesting
    @Nullable
    Long zzb;
    @VisibleForTesting
    @Nullable
    WeakReference<View> zzc;
    private final zzduy zzd;
    private final Clock zze;
    @Nullable
    private zzbqc zzf;
    @Nullable
    private zzbrt<Object> zzg;

    public zzdre(zzduy zzduy, Clock clock) {
        this.zzd = zzduy;
        this.zze = clock;
    }

    private final void zzd() {
        View view;
        this.zza = null;
        this.zzb = null;
        WeakReference<View> weakReference = this.zzc;
        if (weakReference != null && (view = weakReference.get()) != null) {
            view.setClickable(false);
            view.setOnClickListener((View.OnClickListener) null);
            this.zzc = null;
        }
    }

    public final void onClick(View view) {
        WeakReference<View> weakReference = this.zzc;
        if (weakReference != null && weakReference.get() == view) {
            if (!(this.zza == null || this.zzb == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", this.zza);
                hashMap.put("time_interval", String.valueOf(this.zze.currentTimeMillis() - this.zzb.longValue()));
                hashMap.put("messageType", "onePointFiveClick");
                this.zzd.zzg("sendMessageToNativeJs", hashMap);
            }
            zzd();
        }
    }

    @Nullable
    public final zzbqc zza() {
        return this.zzf;
    }

    public final void zzb() {
        if (this.zzf != null && this.zzb != null) {
            zzd();
            try {
                this.zzf.zze();
            } catch (RemoteException e11) {
                zzciz.zzl("#007 Could not call remote method.", e11);
            }
        }
    }

    public final void zzc(zzbqc zzbqc) {
        this.zzf = zzbqc;
        zzbrt<Object> zzbrt = this.zzg;
        if (zzbrt != null) {
            this.zzd.zzk("/unconfirmedClick", zzbrt);
        }
        zzdrd zzdrd = new zzdrd(this, zzbqc);
        this.zzg = zzdrd;
        this.zzd.zzi("/unconfirmedClick", zzdrd);
    }
}
