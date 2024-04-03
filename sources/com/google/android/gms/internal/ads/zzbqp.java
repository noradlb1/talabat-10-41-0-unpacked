package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzbqp extends zzbps {
    /* access modifiers changed from: private */
    public final OnAdManagerAdViewLoadedListener zza;

    public zzbqp(OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener) {
        this.zza = onAdManagerAdViewLoadedListener;
    }

    public final void zze(zzbhk zzbhk, IObjectWrapper iObjectWrapper) {
        AdListener adListener;
        if (zzbhk != null && iObjectWrapper != null) {
            AdManagerAdView adManagerAdView = new AdManagerAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
            AppEventListener appEventListener = null;
            try {
                if (zzbhk.zzi() instanceof zzbey) {
                    zzbey zzbey = (zzbey) zzbhk.zzi();
                    if (zzbey != null) {
                        adListener = zzbey.zzb();
                    } else {
                        adListener = null;
                    }
                    adManagerAdView.setAdListener(adListener);
                }
            } catch (RemoteException e11) {
                zzciz.zzh("", e11);
            }
            try {
                if (zzbhk.zzj() instanceof zzayo) {
                    zzayo zzayo = (zzayo) zzbhk.zzj();
                    if (zzayo != null) {
                        appEventListener = zzayo.zzb();
                    }
                    adManagerAdView.setAppEventListener(appEventListener);
                }
            } catch (RemoteException e12) {
                zzciz.zzh("", e12);
            }
            zzcis.zza.post(new zzbqo(this, adManagerAdView, zzbhk));
        }
    }
}
