package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.PlatformVersion;

public final class zzcaf implements MediationInterstitialAdapter {
    /* access modifiers changed from: private */
    public Activity zza;
    /* access modifiers changed from: private */
    public MediationInterstitialListener zzb;
    private Uri zzc;

    public final void onDestroy() {
        zzciz.zze("Destroying AdMobCustomTabsAdapter adapter.");
    }

    public final void onPause() {
        zzciz.zze("Pausing AdMobCustomTabsAdapter adapter.");
    }

    public final void onResume() {
        zzciz.zze("Resuming AdMobCustomTabsAdapter adapter.");
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzb = mediationInterstitialListener;
        if (mediationInterstitialListener == null) {
            zzciz.zzj("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            zzciz.zzj("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzb.onAdFailedToLoad((MediationInterstitialAdapter) this, 0);
        } else if (!PlatformVersion.isAtLeastIceCreamSandwichMR1() || !zzbmh.zzg(context)) {
            zzciz.zzj("Default browser does not support custom tabs. Bailing out.");
            this.zzb.onAdFailedToLoad((MediationInterstitialAdapter) this, 0);
        } else {
            String string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                zzciz.zzj("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.zzb.onAdFailedToLoad((MediationInterstitialAdapter) this, 0);
                return;
            }
            this.zza = (Activity) context;
            this.zzc = Uri.parse(string);
            this.zzb.onAdLoaded(this);
        }
    }

    public final void showInterstitial() {
        CustomTabsIntent build = new CustomTabsIntent.Builder().build();
        build.intent.setData(this.zzc);
        zzt.zza.post(new zzcae(this, new AdOverlayInfoParcel(new zzc(build.intent, (zzu) null), (zzbes) null, new zzcad(this), (zzw) null, new zzcjf(0, 0, false, false, false), (zzcop) null, (zzdmd) null)));
        com.google.android.gms.ads.internal.zzt.zzo().zzn();
    }
}
