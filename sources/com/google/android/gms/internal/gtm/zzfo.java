package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.content.IntentFilter;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

@ShowFirstParty
@VisibleForTesting
final class zzfo extends zzfn {
    /* access modifiers changed from: private */
    public static final Object zzakn = new Object();
    private static zzfo zzapl;
    /* access modifiers changed from: private */
    public boolean connected = true;
    /* access modifiers changed from: private */
    public Context zzako;
    /* access modifiers changed from: private */
    public int zzakr = Constants.THIRTY_MINUTES;
    private boolean zzaks = true;
    private boolean zzakt = false;
    private boolean zzaku = true;
    private boolean zzakx = false;
    private zzen zzaol = new zzfp(this);
    /* access modifiers changed from: private */
    public zzem zzapg;
    private volatile zzej zzaph;
    /* access modifiers changed from: private */
    public boolean zzapi = false;
    private zzfr zzapj;
    private zzex zzapk;

    private zzfo() {
    }

    /* access modifiers changed from: private */
    public final boolean isPowerSaveMode() {
        return this.zzakx || !this.connected || this.zzakr <= 0;
    }

    public static zzfo zzkv() {
        if (zzapl == null) {
            zzapl = new zzfo();
        }
        return zzapl;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void dispatch() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzakt     // Catch:{ all -> 0x0021 }
            r1 = 1
            if (r0 != 0) goto L_0x000f
            java.lang.String r0 = "Dispatch call queued. Dispatch will run once initialization is complete."
            com.google.android.gms.internal.gtm.zzev.zzab(r0)     // Catch:{ all -> 0x0021 }
            r2.zzaks = r1     // Catch:{ all -> 0x0021 }
            monitor-exit(r2)
            return
        L_0x000f:
            boolean r0 = r2.zzapi     // Catch:{ all -> 0x0021 }
            if (r0 != 0) goto L_0x001f
            r2.zzapi = r1     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.gtm.zzej r0 = r2.zzaph     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.gtm.zzfq r1 = new com.google.android.gms.internal.gtm.zzfq     // Catch:{ all -> 0x0021 }
            r1.<init>(r2)     // Catch:{ all -> 0x0021 }
            r0.zzc(r1)     // Catch:{ all -> 0x0021 }
        L_0x001f:
            monitor-exit(r2)
            return
        L_0x0021:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzfo.dispatch():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(android.content.Context r2, com.google.android.gms.internal.gtm.zzej r3) {
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
            com.google.android.gms.internal.gtm.zzej r2 = r1.zzaph     // Catch:{ all -> 0x0015 }
            if (r2 != 0) goto L_0x0013
            r1.zzaph = r3     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r1)
            return
        L_0x0015:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzfo.zza(android.content.Context, com.google.android.gms.internal.gtm.zzej):void");
    }

    public final synchronized void zzf(boolean z11) {
        zza(this.zzakx, z11);
    }

    public final synchronized void zzjp() {
        if (!isPowerSaveMode()) {
            this.zzapj.zzjt();
        }
    }

    public final synchronized zzem zzkw() {
        if (this.zzapg == null) {
            if (this.zzako != null) {
                this.zzapg = new zzey(this.zzaol, this.zzako);
            } else {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
        }
        if (this.zzapj == null) {
            zzfs zzfs = new zzfs(this, (zzfp) null);
            this.zzapj = zzfs;
            int i11 = this.zzakr;
            if (i11 > 0) {
                zzfs.zzh((long) i11);
            }
        }
        this.zzakt = true;
        if (this.zzaks) {
            dispatch();
            this.zzaks = false;
        }
        if (this.zzapk == null && this.zzaku) {
            zzex zzex = new zzex(this);
            this.zzapk = zzex;
            Context context = this.zzako;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            context.registerReceiver(zzex, intentFilter);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("com.google.analytics.RADIO_POWERED");
            intentFilter2.addCategory(context.getPackageName());
            context.registerReceiver(zzex, intentFilter2);
        }
        return this.zzapg;
    }

    @VisibleForTesting
    public final synchronized void zza(boolean z11, boolean z12) {
        boolean isPowerSaveMode = isPowerSaveMode();
        this.zzakx = z11;
        this.connected = z12;
        if (isPowerSaveMode() != isPowerSaveMode) {
            if (isPowerSaveMode()) {
                this.zzapj.cancel();
                zzev.zzab("PowerSaveMode initiated.");
                return;
            }
            this.zzapj.zzh((long) this.zzakr);
            zzev.zzab("PowerSaveMode terminated.");
        }
    }
}
