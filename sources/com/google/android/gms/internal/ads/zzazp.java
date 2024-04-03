package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzazp extends AppOpenAd {
    @Nullable
    FullScreenContentCallback zza;
    private final zzazt zzb;
    @NonNull
    private final String zzc;
    private final zzazq zzd = new zzazq();
    @Nullable
    private OnPaidEventListener zze;

    public zzazp(zzazt zzazt, String str) {
        this.zzb = zzazt;
        this.zzc = str;
    }

    public final String getAdUnitId() {
        return this.zzc;
    }

    @Nullable
    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zza;
    }

    @Nullable
    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zze;
    }

    @NonNull
    public final ResponseInfo getResponseInfo() {
        zzbiw zzbiw;
        try {
            zzbiw = this.zzb.zzf();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
            zzbiw = null;
        }
        return ResponseInfo.zzb(zzbiw);
    }

    public final void setFullScreenContentCallback(@Nullable FullScreenContentCallback fullScreenContentCallback) {
        this.zza = fullScreenContentCallback;
        this.zzd.zzg(fullScreenContentCallback);
    }

    public final void setImmersiveMode(boolean z11) {
        try {
            this.zzb.zzg(z11);
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        this.zze = onPaidEventListener;
        try {
            this.zzb.zzh(new zzbkj(onPaidEventListener));
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void show(@NonNull Activity activity) {
        try {
            this.zzb.zzi(ObjectWrapper.wrap(activity), this.zzd);
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }
}
