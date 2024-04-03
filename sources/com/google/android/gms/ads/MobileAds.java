package com.google.android.gms.ads;

import android.content.Context;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbjq;

public class MobileAds {
    @RecentlyNonNull
    public static final String ERROR_DOMAIN = "com.google.android.gms.ads";

    private MobileAds() {
    }

    public static void disableMediationAdapterInitialization(@RecentlyNonNull Context context) {
        zzbjq.zzf().zzk(context);
    }

    @RecentlyNullable
    public static InitializationStatus getInitializationStatus() {
        return zzbjq.zzf().zze();
    }

    @NonNull
    public static RequestConfiguration getRequestConfiguration() {
        return zzbjq.zzf().zzc();
    }

    @RecentlyNonNull
    public static String getVersionString() {
        return zzbjq.zzf().zzg();
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void initialize(@RecentlyNonNull Context context) {
        zzbjq.zzf().zzl(context, (String) null, (OnInitializationCompleteListener) null);
    }

    public static void openAdInspector(@RecentlyNonNull Context context, @RecentlyNonNull OnAdInspectorClosedListener onAdInspectorClosedListener) {
        zzbjq.zzf().zzn(context, onAdInspectorClosedListener);
    }

    public static void openDebugMenu(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        zzbjq.zzf().zzo(context, str);
    }

    @KeepForSdk
    public static void registerRtbAdapter(@RecentlyNonNull Class<? extends RtbAdapter> cls) {
        zzbjq.zzf().zzp(cls);
    }

    @RequiresApi(api = 21)
    @KeepForSdk
    public static void registerWebView(@RecentlyNonNull WebView webView) {
        zzbjq.zzf().zzq(webView);
    }

    public static void setAppMuted(boolean z11) {
        zzbjq.zzf().zzr(z11);
    }

    public static void setAppVolume(float f11) {
        zzbjq.zzf().zzs(f11);
    }

    public static void setRequestConfiguration(@RecentlyNonNull RequestConfiguration requestConfiguration) {
        zzbjq.zzf().zzt(requestConfiguration);
    }

    public static void initialize(@RecentlyNonNull Context context, @RecentlyNonNull OnInitializationCompleteListener onInitializationCompleteListener) {
        zzbjq.zzf().zzl(context, (String) null, onInitializationCompleteListener);
    }
}
