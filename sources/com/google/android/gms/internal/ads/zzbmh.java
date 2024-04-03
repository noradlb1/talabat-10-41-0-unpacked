package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzbmh {
    @Nullable
    private CustomTabsSession zza;
    @Nullable
    private CustomTabsClient zzb;
    @Nullable
    private CustomTabsServiceConnection zzc;
    @Nullable
    private zzbmf zzd;

    public static boolean zzg(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (!(queryIntentActivities == null || resolveActivity == null)) {
            for (int i11 = 0; i11 < queryIntentActivities.size(); i11++) {
                if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i11).activityInfo.name)) {
                    return resolveActivity.activityInfo.packageName.equals(zzgqf.zza(context));
                }
            }
        }
        return false;
    }

    @Nullable
    public final CustomTabsSession zza() {
        CustomTabsClient customTabsClient = this.zzb;
        if (customTabsClient == null) {
            this.zza = null;
        } else if (this.zza == null) {
            this.zza = customTabsClient.newSession((CustomTabsCallback) null);
        }
        return this.zza;
    }

    public final void zzb(Activity activity) {
        String zza2;
        if (this.zzb == null && (zza2 = zzgqf.zza(activity)) != null) {
            zzgqg zzgqg = new zzgqg(this, (byte[]) null);
            this.zzc = zzgqg;
            CustomTabsClient.bindCustomTabsService(activity, zza2, zzgqg);
        }
    }

    public final void zzc(CustomTabsClient customTabsClient) {
        this.zzb = customTabsClient;
        customTabsClient.warmup(0);
        zzbmf zzbmf = this.zzd;
        if (zzbmf != null) {
            zzbmf.zza();
        }
    }

    public final void zzd() {
        this.zzb = null;
        this.zza = null;
    }

    public final void zze(zzbmf zzbmf) {
        this.zzd = zzbmf;
    }

    public final void zzf(Activity activity) {
        CustomTabsServiceConnection customTabsServiceConnection = this.zzc;
        if (customTabsServiceConnection != null) {
            activity.unbindService(customTabsServiceConnection);
            this.zzb = null;
            this.zza = null;
            this.zzc = null;
        }
    }
}
