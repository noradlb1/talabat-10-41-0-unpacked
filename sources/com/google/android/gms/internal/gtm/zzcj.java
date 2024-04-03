package com.google.android.gms.internal.gtm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

class zzcj extends BroadcastReceiver {
    @VisibleForTesting
    private static final String zzabm = "com.google.android.gms.internal.gtm.zzcj";
    private boolean zzabn;
    private boolean zzabo;
    private final zzap zzwc;

    public zzcj(zzap zzap) {
        Preconditions.checkNotNull(zzap);
        this.zzwc = zzap;
    }

    private final void zzfp() {
        this.zzwc.zzco();
        this.zzwc.zzcs();
    }

    @VisibleForTesting
    private final boolean zzfr() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.zzwc.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (SecurityException unused) {
        }
    }

    public final boolean isConnected() {
        if (!this.zzabn) {
            this.zzwc.zzco().zzt("Connectivity unknown. Receiver not registered");
        }
        return this.zzabo;
    }

    public void onReceive(Context context, Intent intent) {
        zzfp();
        String action = intent.getAction();
        this.zzwc.zzco().zza("NetworkBroadcastReceiver received action", action);
        if (ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(action)) {
            boolean zzfr = zzfr();
            if (this.zzabo != zzfr) {
                this.zzabo = zzfr;
                zzae zzcs = this.zzwc.zzcs();
                zzcs.zza("Network connectivity status changed", Boolean.valueOf(zzfr));
                zzcs.zzcq().zza((Runnable) new zzag(zzcs, zzfr));
            }
        } else if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.zzwc.zzco().zzd("NetworkBroadcastReceiver received unknown action", action);
        } else if (!intent.hasExtra(zzabm)) {
            zzae zzcs2 = this.zzwc.zzcs();
            zzcs2.zzq("Radio powered up");
            zzcs2.zzci();
        }
    }

    public final void unregister() {
        if (this.zzabn) {
            this.zzwc.zzco().zzq("Unregistering connectivity change receiver");
            this.zzabn = false;
            this.zzabo = false;
            try {
                this.zzwc.getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e11) {
                this.zzwc.zzco().zze("Failed to unregister the network broadcast receiver", e11);
            }
        }
    }

    public final void zzfo() {
        zzfp();
        if (!this.zzabn) {
            Context context = this.zzwc.getContext();
            context.registerReceiver(this, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
            IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
            intentFilter.addCategory(context.getPackageName());
            context.registerReceiver(this, intentFilter);
            this.zzabo = zzfr();
            this.zzwc.zzco().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzabo));
            this.zzabn = true;
        }
    }

    @VisibleForTesting
    public final void zzfq() {
        Context context = this.zzwc.getContext();
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(zzabm, true);
        context.sendOrderedBroadcast(intent, (String) null);
    }
}
