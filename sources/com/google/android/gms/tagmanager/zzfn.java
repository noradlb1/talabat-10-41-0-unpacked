package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.IntentFilter;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

@ShowFirstParty
@VisibleForTesting
final class zzfn extends zzfm {
    /* access modifiers changed from: private */
    public static final Object zzakn = new Object();
    private static zzfn zzaky;
    /* access modifiers changed from: private */
    public boolean connected = true;
    private zzcc zzaig = new zzfo(this);
    /* access modifiers changed from: private */
    public Context zzako;
    /* access modifiers changed from: private */
    public zzcb zzakp;
    private volatile zzby zzakq;
    /* access modifiers changed from: private */
    public int zzakr = Constants.THIRTY_MINUTES;
    private boolean zzaks = true;
    private boolean zzakt = false;
    private boolean zzaku = true;
    private zzfq zzakv;
    private zzdn zzakw;
    private boolean zzakx = false;

    private zzfn() {
    }

    /* access modifiers changed from: private */
    public final boolean isPowerSaveMode() {
        return this.zzakx || !this.connected || this.zzakr <= 0;
    }

    public static zzfn zzjq() {
        if (zzaky == null) {
            zzaky = new zzfn();
        }
        return zzaky;
    }

    public final synchronized void dispatch() {
        if (!this.zzakt) {
            zzdi.zzab("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.zzaks = true;
            return;
        }
        this.zzakq.zzc(new zzfp(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(android.content.Context r2, com.google.android.gms.tagmanager.zzby r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            android.content.Context r0 = r1.zzako     // Catch:{ all -> 0x0015 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x0015 }
            r1.zzako = r2     // Catch:{ all -> 0x0015 }
            com.google.android.gms.tagmanager.zzby r2 = r1.zzakq     // Catch:{ all -> 0x0015 }
            if (r2 != 0) goto L_0x0013
            r1.zzakq = r3     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r1)
            return
        L_0x0015:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzfn.zza(android.content.Context, com.google.android.gms.tagmanager.zzby):void");
    }

    public final synchronized void zzf(boolean z11) {
        zza(this.zzakx, z11);
    }

    public final synchronized void zzjp() {
        if (!isPowerSaveMode()) {
            this.zzakv.zzjt();
        }
    }

    public final synchronized zzcb zzjr() {
        if (this.zzakp == null) {
            if (this.zzako != null) {
                this.zzakp = new zzeb(this.zzaig, this.zzako);
            } else {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
        }
        if (this.zzakv == null) {
            zzfr zzfr = new zzfr(this, (zzfo) null);
            this.zzakv = zzfr;
            int i11 = this.zzakr;
            if (i11 > 0) {
                zzfr.zzh((long) i11);
            }
        }
        this.zzakt = true;
        if (this.zzaks) {
            dispatch();
            this.zzaks = false;
        }
        if (this.zzakw == null && this.zzaku) {
            zzdn zzdn = new zzdn(this);
            this.zzakw = zzdn;
            Context context = this.zzako;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            context.registerReceiver(zzdn, intentFilter);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("com.google.analytics.RADIO_POWERED");
            intentFilter2.addCategory(context.getPackageName());
            context.registerReceiver(zzdn, intentFilter2);
        }
        return this.zzakp;
    }

    @VisibleForTesting
    public final synchronized void zza(boolean z11, boolean z12) {
        boolean isPowerSaveMode = isPowerSaveMode();
        this.zzakx = z11;
        this.connected = z12;
        if (isPowerSaveMode() != isPowerSaveMode) {
            if (isPowerSaveMode()) {
                this.zzakv.cancel();
                zzdi.zzab("PowerSaveMode initiated.");
                return;
            }
            this.zzakv.zzh((long) this.zzakr);
            zzdi.zzab("PowerSaveMode terminated.");
        }
    }
}
