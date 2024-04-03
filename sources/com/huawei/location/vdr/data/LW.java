package com.huawei.location.vdr.data;

import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.RequiresApi;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.vdr.listener.Vw;
import com.huawei.location.vdr.listener.yn;
import com.huawei.riemann.gnsslocation.core.bean.obs.GnssRawObservation;
import gb.a;

@RequiresApi(api = 24)
public class LW implements yn {
    private Location E5;
    private final Vw FB;
    private Vw LW;
    private final yn Vw;

    /* renamed from: a  reason: collision with root package name */
    public GnssRawObservation[] f50274a;

    /* renamed from: b  reason: collision with root package name */
    public long f50275b;
    private Handler dC;

    /* renamed from: yn  reason: collision with root package name */
    private long f50276yn = -1;

    public LW() {
        yn ynVar = new yn();
        this.Vw = ynVar;
        ynVar.yn(this);
        ynVar.yn();
        this.FB = new Vw();
        HandlerThread handlerThread = new HandlerThread("Loc-vdr-data");
        handlerThread.start();
        this.dC = new Handler(handlerThread.getLooper(), new a(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void yn(com.huawei.riemann.gnsslocation.core.bean.obs.GnssRawObservation[] r6, long r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            android.os.Handler r0 = r5.dC     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x000e
            java.lang.String r6 = "VdrDataManager"
            java.lang.String r7 = "handler is null,can not handler data"
            com.huawei.location.lite.common.log.LogConsole.e(r6, r7)     // Catch:{ all -> 0x004b }
            monitor-exit(r5)
            return
        L_0x000e:
            r1 = 0
            r0.removeCallbacksAndMessages(r1)     // Catch:{ all -> 0x004b }
            r0 = 10
            if (r6 != 0) goto L_0x0022
            android.os.Handler r2 = r5.dC     // Catch:{ all -> 0x004b }
            android.os.Message r0 = r2.obtainMessage(r0)     // Catch:{ all -> 0x004b }
            r3 = 1000(0x3e8, double:4.94E-321)
            r2.sendMessageDelayed(r0, r3)     // Catch:{ all -> 0x004b }
            goto L_0x002d
        L_0x0022:
            android.os.Handler r2 = r5.dC     // Catch:{ all -> 0x004b }
            android.os.Message r0 = r2.obtainMessage(r0)     // Catch:{ all -> 0x004b }
            r3 = 1300(0x514, double:6.423E-321)
            r2.sendMessageDelayed(r0, r3)     // Catch:{ all -> 0x004b }
        L_0x002d:
            com.huawei.location.vdr.data.Vw r0 = r5.FB     // Catch:{ all -> 0x004b }
            long r2 = r5.f50276yn     // Catch:{ all -> 0x004b }
            com.huawei.riemann.gnsslocation.core.bean.sensor.MotionSensors r0 = r0.yn(r2, r7)     // Catch:{ all -> 0x004b }
            r5.f50276yn = r7     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x0049
            com.huawei.location.vdr.listener.Vw r7 = r5.LW     // Catch:{ all -> 0x004b }
            if (r7 == 0) goto L_0x0049
            com.huawei.location.vdr.data.FB r8 = new com.huawei.location.vdr.data.FB     // Catch:{ all -> 0x004b }
            android.location.Location r2 = r5.E5     // Catch:{ all -> 0x004b }
            r8.<init>(r6, r0, r2)     // Catch:{ all -> 0x004b }
            r7.onVdrDataReceived(r8)     // Catch:{ all -> 0x004b }
            r5.E5 = r1     // Catch:{ all -> 0x004b }
        L_0x0049:
            monitor-exit(r5)
            return
        L_0x004b:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.vdr.data.LW.yn(com.huawei.riemann.gnsslocation.core.bean.obs.GnssRawObservation[], long):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean yn(Message message) {
        int i11 = message.what;
        if (i11 == 10) {
            yn((GnssRawObservation[]) null, SystemClock.elapsedRealtimeNanos());
            return false;
        } else if (i11 != 11) {
            return false;
        } else {
            yn(this.f50274a, this.f50275b);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0016 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0018 A[SYNTHETIC, Splitter:B:13:0x0018] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void Vw() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.huawei.location.vdr.data.yn r0 = r2.Vw     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x000c
            com.huawei.location.vdr.data.Vw r0 = r2.FB     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x000a
            goto L_0x000c
        L_0x000a:
            r0 = 1
            goto L_0x0014
        L_0x000c:
            java.lang.String r0 = "VdrDataManager"
            java.lang.String r1 = "init fail, try to call start method"
            com.huawei.location.lite.common.log.LogConsole.e(r0, r1)     // Catch:{ all -> 0x003c }
            r0 = 0
        L_0x0014:
            if (r0 != 0) goto L_0x0018
            monitor-exit(r2)
            return
        L_0x0018:
            com.huawei.location.vdr.data.yn r0 = r2.Vw     // Catch:{ all -> 0x003c }
            r0.Vw()     // Catch:{ all -> 0x003c }
            com.huawei.location.vdr.data.Vw r0 = r2.FB     // Catch:{ all -> 0x003c }
            r0.Vw()     // Catch:{ all -> 0x003c }
            android.os.Handler r0 = r2.dC     // Catch:{ all -> 0x003c }
            r1 = 0
            r0.removeCallbacksAndMessages(r1)     // Catch:{ all -> 0x003c }
            android.os.Handler r0 = r2.dC     // Catch:{ all -> 0x003c }
            android.os.Looper r0 = r0.getLooper()     // Catch:{ all -> 0x003c }
            r0.quitSafely()     // Catch:{ all -> 0x003c }
            r2.dC = r1     // Catch:{ all -> 0x003c }
            java.lang.String r0 = "VdrDataManager"
            java.lang.String r1 = "stop vdr data"
            com.huawei.location.lite.common.log.LogConsole.i(r0, r1)     // Catch:{ all -> 0x003c }
            monitor-exit(r2)
            return
        L_0x003c:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.vdr.data.LW.Vw():void");
    }

    public void Vw(GnssRawObservation[] gnssRawObservationArr, long j11) {
        Handler handler = this.dC;
        if (handler == null) {
            LogConsole.e("VdrDataManager", "handler is null, drop gnss data here.");
            return;
        }
        handler.removeCallbacksAndMessages((Object) null);
        if (this.E5 == null) {
            this.f50274a = gnssRawObservationArr;
            this.f50275b = j11;
            Handler handler2 = this.dC;
            handler2.sendMessageDelayed(handler2.obtainMessage(11), 40);
            return;
        }
        yn(gnssRawObservationArr, j11);
    }

    public Location yn() {
        return this.E5;
    }

    public void yn(Location location) {
        this.E5 = location;
    }

    public synchronized void yn(Vw vw2) {
        Handler handler = this.dC;
        if (handler == null) {
            LogConsole.e("VdrDataManager", "handler is null, setVdrDataListener failed.");
            return;
        }
        this.LW = vw2;
        handler.removeCallbacksAndMessages((Object) null);
        Handler handler2 = this.dC;
        handler2.sendMessage(handler2.obtainMessage(10));
    }
}
