package com.google.android.gms.internal.gtm;

import android.content.Context;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import org.apache.commons.lang3.time.DateUtils;

@VisibleForTesting
public final class zzdl {
    private static Object zzadq = new Object();
    private static zzdl zzamp;
    private volatile boolean closed;
    private volatile long zzadj;
    private volatile long zzadk;
    private volatile long zzadl;
    private volatile long zzadm;
    private final Thread zzadn;
    private final Object zzado;
    /* access modifiers changed from: private */
    public volatile boolean zzamn;
    private zzdo zzamo;
    /* access modifiers changed from: private */
    public final Context zzrm;
    private final Clock zzsd;
    private volatile AdvertisingIdClient.Info zzvp;

    private zzdl(Context context) {
        this(context, (zzdo) null, DefaultClock.getInstance());
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzgr() {
        /*
            r2 = this;
            monitor-enter(r2)
            r2.zzgs()     // Catch:{ InterruptedException -> 0x000c }
            r0 = 500(0x1f4, double:2.47E-321)
            r2.wait(r0)     // Catch:{ InterruptedException -> 0x000c }
            goto L_0x000c
        L_0x000a:
            r0 = move-exception
            goto L_0x000e
        L_0x000c:
            monitor-exit(r2)     // Catch:{ all -> 0x000a }
            return
        L_0x000e:
            monitor-exit(r2)     // Catch:{ all -> 0x000a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzdl.zzgr():void");
    }

    private final void zzgs() {
        if (this.zzsd.currentTimeMillis() - this.zzadl > this.zzadk) {
            synchronized (this.zzado) {
                this.zzado.notify();
            }
            this.zzadl = this.zzsd.currentTimeMillis();
        }
    }

    private final void zzgt() {
        if (this.zzsd.currentTimeMillis() - this.zzadm > DateUtils.MILLIS_PER_HOUR) {
            this.zzvp = null;
        }
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final void zzgu() {
        /*
            r4 = this;
            r0 = 10
            android.os.Process.setThreadPriority(r0)
        L_0x0005:
            boolean r0 = r4.zzamn
            if (r0 == 0) goto L_0x0010
            com.google.android.gms.internal.gtm.zzdo r0 = r4.zzamo
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r0 = r0.zzgv()
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            if (r0 == 0) goto L_0x0022
            r4.zzvp = r0
            com.google.android.gms.common.util.Clock r0 = r4.zzsd
            long r0 = r0.currentTimeMillis()
            r4.zzadm = r0
            java.lang.String r0 = "Obtained fresh AdvertisingId info from GmsCore."
            com.google.android.gms.internal.gtm.zzev.zzaw(r0)
        L_0x0022:
            monitor-enter(r4)
            r4.notifyAll()     // Catch:{ all -> 0x003c }
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            java.lang.Object r0 = r4.zzado     // Catch:{ InterruptedException -> 0x0036 }
            monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0036 }
            java.lang.Object r1 = r4.zzado     // Catch:{ all -> 0x0033 }
            long r2 = r4.zzadj     // Catch:{ all -> 0x0033 }
            r1.wait(r2)     // Catch:{ all -> 0x0033 }
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            goto L_0x0005
        L_0x0033:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            throw r1     // Catch:{ InterruptedException -> 0x0036 }
        L_0x0036:
            java.lang.String r0 = "sleep interrupted in AdvertiserDataPoller thread; continuing"
            com.google.android.gms.internal.gtm.zzev.zzaw(r0)
            goto L_0x0005
        L_0x003c:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzdl.zzgu():void");
    }

    public static zzdl zzo(Context context) {
        if (zzamp == null) {
            synchronized (zzadq) {
                if (zzamp == null) {
                    zzdl zzdl = new zzdl(context);
                    zzamp = zzdl;
                    zzdl.zzadn.start();
                }
            }
        }
        return zzamp;
    }

    public final boolean isLimitAdTrackingEnabled() {
        if (this.zzvp == null) {
            zzgr();
        } else {
            zzgs();
        }
        zzgt();
        if (this.zzvp == null) {
            return true;
        }
        return this.zzvp.isLimitAdTrackingEnabled();
    }

    public final String zzgq() {
        if (this.zzvp == null) {
            zzgr();
        } else {
            zzgs();
        }
        zzgt();
        if (this.zzvp == null) {
            return null;
        }
        return this.zzvp.getId();
    }

    @VisibleForTesting
    private zzdl(Context context, zzdo zzdo, Clock clock) {
        this.zzadj = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;
        this.zzadk = 30000;
        this.zzamn = true;
        this.closed = false;
        this.zzado = new Object();
        this.zzamo = new zzdm(this);
        this.zzsd = clock;
        if (context != null) {
            this.zzrm = context.getApplicationContext();
        } else {
            this.zzrm = context;
        }
        this.zzadl = clock.currentTimeMillis();
        this.zzadn = new Thread(new zzdn(this));
    }
}
