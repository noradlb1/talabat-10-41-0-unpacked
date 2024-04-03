package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzap;
import com.google.android.gms.internal.gtm.zzbq;
import com.google.android.gms.internal.gtm.zzci;
import com.google.android.gms.internal.gtm.zzcz;

@VisibleForTesting
public class CampaignTrackingReceiver extends BroadcastReceiver {
    private static Boolean zzri;

    public static boolean zza(Context context) {
        Preconditions.checkNotNull(context);
        Boolean bool = zzri;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zza = zzcz.zza(context, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
        zzri = Boolean.valueOf(zza);
        return zza;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onReceive(Context context, Intent intent) {
        zzap zzc = zzap.zzc(context);
        zzci zzco = zzc.zzco();
        if (intent == null) {
            zzco.zzt("CampaignTrackingReceiver received null intent");
            return;
        }
        String stringExtra = intent.getStringExtra(Constants.REFERRER);
        String action = intent.getAction();
        zzco.zza("CampaignTrackingReceiver received", action);
        if (!"com.android.vending.INSTALL_REFERRER".equals(action) || TextUtils.isEmpty(stringExtra)) {
            zzco.zzt("CampaignTrackingReceiver received unexpected intent without referrer extra");
            return;
        }
        zza(context, stringExtra);
        int zzeo = zzbq.zzeo();
        if (stringExtra.length() > zzeo) {
            zzco.zzc("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(stringExtra.length()), Integer.valueOf(zzeo));
            stringExtra = stringExtra.substring(0, zzeo);
        }
        zzc.zzcs().zza(stringExtra, new zzc(this, goAsync()));
    }

    public void zza(Context context, String str) {
    }
}
