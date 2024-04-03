package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import java.util.HashMap;

public final class zzbgm {
    /* access modifiers changed from: private */
    public final zzbfc zza;
    /* access modifiers changed from: private */
    public final zzbfa zzb;
    /* access modifiers changed from: private */
    public final zzbjv zzc;
    /* access modifiers changed from: private */
    public final zzbqh zzd;
    private final zzcfl zze;
    /* access modifiers changed from: private */
    public final zzcbp zzf;
    /* access modifiers changed from: private */
    public final zzbqi zzg;
    /* access modifiers changed from: private */
    public zzccv zzh;

    public zzbgm(zzbfc zzbfc, zzbfa zzbfa, zzbjv zzbjv, zzbqh zzbqh, zzcfl zzcfl, zzcbp zzcbp, zzbqi zzbqi) {
        this.zza = zzbfc;
        this.zzb = zzbfa;
        this.zzc = zzbjv;
        this.zzd = zzbqh;
        this.zze = zzcfl;
        this.zzf = zzcbp;
        this.zzg = zzbqi;
    }

    public static /* bridge */ /* synthetic */ void zzs(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "no_ads_fallback");
        bundle.putString("flow", str);
        zzbgo.zzb().zzi(context, zzbgo.zzc().zza, "gmob-apps", bundle, true);
    }

    public final zzbhg zzc(Context context, String str, zzbxh zzbxh) {
        return (zzbhg) new zzbge(this, context, str, zzbxh).zzd(context, false);
    }

    public final zzbhk zzd(Context context, zzbfi zzbfi, String str, zzbxh zzbxh) {
        return (zzbhk) new zzbga(this, context, zzbfi, str, zzbxh).zzd(context, false);
    }

    public final zzbhk zze(Context context, zzbfi zzbfi, String str, zzbxh zzbxh) {
        return (zzbhk) new zzbgc(this, context, zzbfi, str, zzbxh).zzd(context, false);
    }

    public final zzbom zzg(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzbom) new zzbgi(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzbos zzh(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        return (zzbos) new zzbgk(this, view, hashMap, hashMap2).zzd(view.getContext(), false);
    }

    @RequiresApi(api = 21)
    public final zzbsr zzk(Context context, zzbxh zzbxh, OnH5AdsEventListener onH5AdsEventListener) {
        return (zzbsr) new zzbfy(this, context, zzbxh, onH5AdsEventListener).zzd(context, false);
    }

    @Nullable
    public final zzcbg zzl(Context context, zzbxh zzbxh) {
        return (zzcbg) new zzbfw(this, context, zzbxh).zzd(context, false);
    }

    @Nullable
    public final zzcbs zzn(Activity activity) {
        zzbfs zzbfs = new zzbfs(this, activity);
        Intent intent = activity.getIntent();
        boolean z11 = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzciz.zzg("useClientJar flag not found in activity intent extras.");
        } else {
            z11 = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return (zzcbs) zzbfs.zzd(activity, z11);
    }

    public final zzcez zzp(Context context, String str, zzbxh zzbxh) {
        return (zzcez) new zzbgl(this, context, str, zzbxh).zzd(context, false);
    }

    @Nullable
    public final zzcht zzq(Context context, zzbxh zzbxh) {
        return (zzcht) new zzbfu(this, context, zzbxh).zzd(context, false);
    }
}
