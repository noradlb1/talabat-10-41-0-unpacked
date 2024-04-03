package com.google.android.gms.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.util.VisibleForTesting;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

class zzdn extends BroadcastReceiver {
    @VisibleForTesting
    private static final String zzabm = "com.google.android.gms.tagmanager.zzdn";
    private final zzfm zzaic;

    public zzdn(zzfm zzfm) {
        this.zzaic = zzfm;
    }

    public static void zzn(Context context) {
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(zzabm, true);
        context.sendBroadcast(intent);
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(action)) {
            Bundle extras = intent.getExtras();
            Boolean bool = Boolean.FALSE;
            if (extras != null) {
                bool = Boolean.valueOf(intent.getExtras().getBoolean("noConnectivity"));
            }
            this.zzaic.zzf(!bool.booleanValue());
        } else if ("com.google.analytics.RADIO_POWERED".equals(action) && !intent.hasExtra(zzabm)) {
            this.zzaic.zzjp();
        }
    }
}
