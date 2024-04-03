package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

public final class zzck {
    @GuardedBy("this")
    private final BroadcastReceiver zza = new zzcj(this);
    @GuardedBy("this")
    private final Map<BroadcastReceiver, IntentFilter> zzb = new WeakHashMap();
    private boolean zzc = false;
    private boolean zzd;
    private Context zze;

    /* access modifiers changed from: private */
    public final synchronized void zze(Context context, Intent intent) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.zzb.entrySet()) {
            if (((IntentFilter) next.getValue()).hasAction(intent.getAction())) {
                arrayList.add((BroadcastReceiver) next.getKey());
            }
        }
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((BroadcastReceiver) arrayList.get(i11)).onReceive(context, intent);
        }
    }

    public final synchronized void zzb(Context context) {
        if (!this.zzc) {
            Context applicationContext = context.getApplicationContext();
            this.zze = applicationContext;
            if (applicationContext == null) {
                this.zze = context;
            }
            zzblj.zzc(this.zze);
            this.zzd = ((Boolean) zzbgq.zzc().zzb(zzblj.zzcu)).booleanValue();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zze.registerReceiver(this.zza, intentFilter);
            this.zzc = true;
        }
    }

    public final synchronized void zzc(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.zzd) {
            this.zzb.put(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public final synchronized void zzd(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.zzd) {
            this.zzb.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }
}
