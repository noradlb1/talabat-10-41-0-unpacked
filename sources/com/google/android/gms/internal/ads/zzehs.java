package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzehs implements zzcbm {
    private final zzcbm zza;
    private final zzcbm zzb;

    public zzehs(zzcbm zzcbm, zzcbm zzcbm2) {
        this.zza = zzcbm;
        this.zzb = zzcbm2;
    }

    private final zzcbm zzf() {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdD)).booleanValue()) {
            return this.zza;
        }
        return this.zzb;
    }

    @Nullable
    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, @Nullable String str4, zzcbo zzcbo, zzcbn zzcbn, @Nullable String str5) {
        return zzf().zza(str, webView, "", "javascript", str4, zzcbo, zzcbn, str5);
    }

    @Nullable
    public final IObjectWrapper zzb(String str, WebView webView, String str2, String str3, @Nullable String str4, String str5, zzcbo zzcbo, zzcbn zzcbn, @Nullable String str6) {
        return zzf().zzb(str, webView, "", "javascript", str4, str5, zzcbo, zzcbn, str6);
    }

    @Nullable
    public final String zzc(Context context) {
        return zzf().zzc(context);
    }

    public final void zzd(IObjectWrapper iObjectWrapper, View view) {
        zzf().zzd(iObjectWrapper, view);
    }

    public final void zze(IObjectWrapper iObjectWrapper) {
        zzf().zze(iObjectWrapper);
    }

    public final void zzg(IObjectWrapper iObjectWrapper, View view) {
        zzf().zzg(iObjectWrapper, view);
    }

    public final void zzh(IObjectWrapper iObjectWrapper) {
        zzf().zzh(iObjectWrapper);
    }

    public final boolean zzi(Context context) {
        return zzf().zzi(context);
    }
}
