package com.huawei.location.support;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.huawei.hms.location.entity.activity.ActivityRecognitionResult;
import com.huawei.hms.location.entity.activity.DetectedActivity;
import com.huawei.location.base.activity.ISoftARManager;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.router.LocationNaming;
import com.huawei.location.router.RouterTaskHandler;
import com.huawei.location.router.entity.IRouterResponse;
import com.huawei.location.router.entity.RouterRequest;
import com.huawei.location.router.interfaces.IRouterCallback;
import com.huawei.location.sdm.Config;
import com.huawei.location.tiles.store.dC;
import java.util.UUID;

public class yn {
    private Vw[] E5;
    private boolean FB;
    private Config G3;
    private Vw[] LW;
    private dC Ot;
    private long Vw = 0;
    private ARCallback Yx = new C0090yn();

    /* renamed from: d2  reason: collision with root package name */
    private Vw[] f50232d2;
    private Vw[] dC;

    /* renamed from: oc  reason: collision with root package name */
    private FB f50233oc;

    /* renamed from: ut  reason: collision with root package name */
    private com.huawei.location.ephemeris.yn f50234ut;
    /* access modifiers changed from: private */

    /* renamed from: yn  reason: collision with root package name */
    public int f50235yn = -1;

    /* renamed from: zp  reason: collision with root package name */
    private ISoftARManager f50236zp;

    public class FB extends Handler {
        public FB(Looper looper) {
            super(looper);
        }

        public void handleMessage(@NonNull Message message) {
            if (message.what == 11) {
                yn.this.yn();
            }
        }
    }

    public static class Vw {

        /* renamed from: a  reason: collision with root package name */
        public boolean f50238a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f50239b = true;

        /* renamed from: c  reason: collision with root package name */
        public int f50240c;
    }

    /* renamed from: com.huawei.location.support.yn$yn  reason: collision with other inner class name */
    public class C0090yn implements ARCallback {
        public C0090yn() {
        }

        public void onActivityRecognition(ActivityRecognitionResult activityRecognitionResult) {
            LogConsole.i("SDMSupportManager", "onActivityRecognition");
            if (activityRecognitionResult != null && activityRecognitionResult.getProbableActivities() != null && activityRecognitionResult.getProbableActivities().size() > 0) {
                DetectedActivity detectedActivity = activityRecognitionResult.getProbableActivities().get(0);
                if (detectedActivity != null) {
                    int unused = yn.this.f50235yn = detectedActivity.getType();
                }
                if (yn.this.f50235yn == 2 && activityRecognitionResult.getProbableActivities().size() > 1) {
                    DetectedActivity detectedActivity2 = activityRecognitionResult.getProbableActivities().get(1);
                    if (detectedActivity != null) {
                        int unused2 = yn.this.f50235yn = detectedActivity2.getType();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void yn() {
        IRouterResponse execute = RouterTaskHandler.getInstance().execute(new RouterRequest(LocationNaming.REQUEST_ADAPTER_SDM, "", UUID.randomUUID().toString(), (IRouterCallback) null));
        if (execute instanceof ISoftARManager) {
            this.f50236zp = (ISoftARManager) execute;
        }
        ISoftARManager iSoftARManager = this.f50236zp;
        if (iSoftARManager != null) {
            iSoftARManager.requestActivityUpdates(1000, this.Yx);
        }
        this.LW = new Vw[2];
        this.dC = new Vw[2];
        this.E5 = new Vw[2];
        this.f50232d2 = new Vw[2];
        this.Ot = new dC(25, 30);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        if (r9 != false) goto L_0x005d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean yn(com.huawei.location.support.yn.Vw[] r8, boolean r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x008a
            int r1 = r8.length
            r2 = 2
            if (r1 >= r2) goto L_0x0009
            goto L_0x008a
        L_0x0009:
            r1 = r8[r0]
            java.lang.String r2 = "SDMSupportManager"
            r3 = 1
            if (r1 != 0) goto L_0x0024
            java.lang.String r1 = "sdm record status[0] first time"
            com.huawei.location.lite.common.log.LogConsole.i(r2, r1)
            com.huawei.location.support.yn$Vw r1 = new com.huawei.location.support.yn$Vw
            r1.<init>()
            r8[r0] = r1
            r1.f50238a = r9
            int r8 = r1.f50240c
            int r8 = r8 + r3
            r1.f50240c = r8
            return r9
        L_0x0024:
            boolean r4 = r1.f50238a
            r5 = 0
            if (r4 == r9) goto L_0x0075
            r4 = r8[r3]
            if (r4 != 0) goto L_0x0041
            java.lang.String r1 = "sdm record status[1] first time"
            com.huawei.location.lite.common.log.LogConsole.i(r2, r1)
            com.huawei.location.support.yn$Vw r1 = new com.huawei.location.support.yn$Vw
            r1.<init>()
            r8[r3] = r1
            r1.f50238a = r9
            int r9 = r1.f50240c
            int r9 = r9 + r3
            r1.f50240c = r9
            goto L_0x0085
        L_0x0041:
            int r6 = r4.f50240c
            int r6 = r6 + r3
            r4.f50240c = r6
            com.huawei.location.sdm.Config r4 = r7.G3
            boolean r1 = r1.f50239b
            r9 = r9 | r1
            if (r4 == 0) goto L_0x005a
            int r1 = r4.yn()
            com.huawei.location.sdm.Config r4 = r7.G3
            int r4 = r4.Vw()
            if (r9 == 0) goto L_0x0061
            goto L_0x005d
        L_0x005a:
            if (r9 == 0) goto L_0x005f
            r1 = 3
        L_0x005d:
            r4 = r1
            goto L_0x0061
        L_0x005f:
            r4 = 10
        L_0x0061:
            r9 = r8[r3]
            int r9 = r9.f50240c
            if (r9 < r4) goto L_0x0085
            java.lang.String r9 = "sdm status changed"
            com.huawei.location.lite.common.log.LogConsole.i(r2, r9)
            r9 = r8[r3]
            r8[r0] = r9
            r9.f50239b = r0
            r8[r3] = r5
            goto L_0x0085
        L_0x0075:
            int r9 = r1.f50240c
            int r9 = r9 + r3
            r1.f50240c = r9
            r9 = r8[r3]
            if (r9 == 0) goto L_0x0085
            java.lang.String r9 = "sdm destroy status[1]"
            com.huawei.location.lite.common.log.LogConsole.i(r2, r9)
            r8[r3] = r5
        L_0x0085:
            r8 = r8[r0]
            boolean r8 = r8.f50238a
            return r8
        L_0x008a:
            r7.yn()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.support.yn.yn(com.huawei.location.support.yn$Vw[], boolean):boolean");
    }

    public void Vw() {
        ISoftARManager iSoftARManager = this.f50236zp;
        if (iSoftARManager != null) {
            iSoftARManager.removeActivityUpdates(this.Yx);
            this.f50235yn = -1;
        }
        this.f50233oc = null;
    }

    public void yn(Looper looper, com.huawei.location.ephemeris.yn ynVar, Config config) {
        this.G3 = config;
        this.f50234ut = ynVar;
        if (this.f50233oc == null) {
            this.f50233oc = new FB(looper);
        }
        if (this.f50233oc.hasMessages(11)) {
            LogConsole.i("SDMSupportManager", "init failed,caz has msg");
        } else {
            this.f50233oc.sendEmptyMessage(11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009d, code lost:
        if (r13 >= ((float) r6.dC())) goto L_0x00a0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean yn(double r9, double r11, float r13) {
        /*
            r8 = this;
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = r8.Vw
            long r2 = r0 - r2
            r4 = 1000(0x3e8, double:4.94E-321)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r3 = 1
            r4 = 0
            if (r2 <= 0) goto L_0x0014
            r8.Vw = r0
            r0 = r3
            goto L_0x0015
        L_0x0014:
            r0 = r4
        L_0x0015:
            java.lang.String r1 = "SDMSupportManager"
            if (r0 != 0) goto L_0x0032
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "sdm check time support: "
            r9.append(r10)
            boolean r10 = r8.FB
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r1, r9)
            boolean r9 = r8.FB
            return r9
        L_0x0032:
            com.huawei.location.support.yn$Vw[] r0 = r8.LW
            boolean r2 = com.huawei.location.lite.common.android.receiver.ScreenStatusBroadcastReceiver.isScreenOn()
            boolean r0 = r8.yn(r0, r2)
            com.huawei.location.support.yn$Vw[] r2 = r8.dC
            android.content.Context r5 = com.huawei.location.lite.common.android.context.ContextUtil.getContext()
            java.lang.String r5 = r5.getPackageName()
            boolean r5 = com.huawei.location.lite.common.util.PermissionUtil.isAppIsInBackground((java.lang.String) r5)
            r5 = r5 ^ r3
            boolean r2 = r8.yn(r2, r5)
            com.huawei.location.support.yn$Vw[] r5 = r8.E5
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "currentARType: "
            r6.append(r7)
            int r7 = r8.f50235yn
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r1, r6)
            int r6 = r8.f50235yn
            r7 = 3
            if (r6 == r7) goto L_0x0092
            r7 = 7
            if (r6 != r7) goto L_0x0070
            goto L_0x0092
        L_0x0070:
            com.huawei.location.sdm.Config r6 = r8.G3
            if (r6 == 0) goto L_0x00a0
            int r6 = r6.dC()
            float r6 = (float) r6
            int r6 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r6 >= 0) goto L_0x00a0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "speed: "
            r6.append(r7)
            r6.append(r13)
            java.lang.String r13 = r6.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r1, r13)
            goto L_0x00a2
        L_0x0092:
            com.huawei.location.sdm.Config r6 = r8.G3
            if (r6 == 0) goto L_0x00a2
            int r6 = r6.dC()
            float r6 = (float) r6
            int r13 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r13 >= 0) goto L_0x00a0
            goto L_0x00a2
        L_0x00a0:
            r13 = r4
            goto L_0x00a3
        L_0x00a2:
            r13 = r3
        L_0x00a3:
            boolean r13 = r8.yn(r5, r13)
            com.huawei.location.support.yn$Vw[] r5 = r8.f50232d2
            com.huawei.location.tiles.store.dC r6 = r8.Ot
            if (r6 == 0) goto L_0x00b2
            boolean r9 = r6.yn((double) r9, (double) r11)
            goto L_0x00b3
        L_0x00b2:
            r9 = r4
        L_0x00b3:
            boolean r9 = r8.yn(r5, r9)
            if (r0 == 0) goto L_0x00c0
            if (r2 == 0) goto L_0x00c0
            if (r13 == 0) goto L_0x00c0
            if (r9 == 0) goto L_0x00c0
            goto L_0x00c1
        L_0x00c0:
            r3 = r4
        L_0x00c1:
            r8.FB = r3
            if (r3 == 0) goto L_0x00dd
            com.huawei.location.ephemeris.yn r9 = r8.f50234ut
            if (r9 != 0) goto L_0x00ca
            return r4
        L_0x00ca:
            boolean r9 = r9.yn()
            r8.FB = r9
            if (r9 == 0) goto L_0x00d5
            java.lang.String r9 = "sdm is ok"
            goto L_0x00d7
        L_0x00d5:
            java.lang.String r9 = "sdm is bad caz EphModule not available"
        L_0x00d7:
            com.huawei.location.lite.common.log.LogConsole.i(r1, r9)
            boolean r9 = r8.FB
            return r9
        L_0x00dd:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "sdm is bad caz after smooth:   screen["
            r10.append(r11)
            r10.append(r0)
            java.lang.String r11 = "]; isForeground["
            r10.append(r11)
            r10.append(r2)
            java.lang.String r11 = "]; ar["
            r10.append(r11)
            r10.append(r13)
            java.lang.String r11 = "]; tile["
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = "]"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r1, r9)
            boolean r9 = r8.FB
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.support.yn.yn(double, double, float):boolean");
    }
}
