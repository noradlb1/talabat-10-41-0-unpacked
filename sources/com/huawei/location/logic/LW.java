package com.huawei.location.logic;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.location.LocationProviderCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.callback.Ot;
import com.huawei.location.callback.d2;
import com.huawei.location.callback.oc;
import com.huawei.location.callback.zp;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.LocationUtil;
import com.huawei.location.lite.common.util.NetworkUtil;
import com.huawei.location.lite.common.util.PermissionUtil;
import com.huawei.location.lite.common.util.ROMUtil;
import com.huawei.location.logic.d2;
import java.util.Iterator;
import java.util.Map;

public class LW {
    private static volatile LW FB;
    private static final byte[] Vw = new byte[0];

    /* renamed from: yn  reason: collision with root package name */
    private static final boolean f50161yn = ROMUtil.isGmsRom();
    private com.huawei.location.provider.yn E5 = new com.huawei.location.provider.yn();
    private dC LW;
    private Handler dC;

    public class Vw implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d2 f50162b;

        public Vw(LW lw2, d2 d2Var) {
            this.f50162b = d2Var;
        }

        public void run() {
            this.f50162b.yn(LocationUtil.isLocationEnabled(ContextUtil.getContext()), NetworkUtil.isNetworkAvailable(ContextUtil.getContext()));
        }
    }

    public class yn implements LocationProviderCallback {
        public yn() {
        }

        public void onLocationChanged(HwLocationResult hwLocationResult) {
            if (PermissionUtil.checkSelfPermission(ContextUtil.getContext(), "android.permission.ACCESS_FINE_LOCATION") || PermissionUtil.checkSelfPermission(ContextUtil.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                LW.a(LW.this, hwLocationResult);
            } else {
                LogConsole.i("HwLocationManager", "dispatchCallback fail, location permission is denied");
            }
        }
    }

    private LW() {
        com.huawei.location.nlp.api.yn.yn().yn((LocationProviderCallback) new yn());
        com.huawei.location.crowdsourcing.Vw.yn(ContextUtil.getContext());
    }

    private void Vw(@NonNull com.huawei.location.cache.Vw vw2) {
        if (vw2.dC() != null) {
            if (f50161yn) {
                this.E5.yn(vw2);
            } else {
                com.huawei.location.nlp.api.yn.yn().yn(vw2.dC());
            }
        }
    }

    public static void a(LW lw2, HwLocationResult hwLocationResult) {
        lw2.getClass();
        Iterator<Map.Entry<String, com.huawei.location.cache.Vw>> it = com.huawei.location.cache.yn.Vw().yn().entrySet().iterator();
        while (it.hasNext()) {
            com.huawei.location.cache.Vw vw2 = (com.huawei.location.cache.Vw) it.next().getValue();
            if (vw2 == null) {
                LogConsole.i("HwLocationManager", "dispatchCallback fail, wrapLocationRequest is null");
            } else if (vw2.yn() == null || TextUtils.isEmpty(vw2.d2()) || !com.huawei.location.activity.model.Vw.yn(vw2.dC())) {
                LogConsole.i("HwLocationManager", "dispatchCallback fail, request is invalid");
                it.remove();
                lw2.yn(vw2);
            } else {
                int FB2 = vw2.FB();
                if (FB2 == 102 || FB2 == 104 || FB2 == 300 || FB2 == 100) {
                    vw2.yn().LW(hwLocationResult);
                }
            }
        }
    }

    private d2 yn(com.huawei.location.cache.Vw vw2, oc ocVar) {
        if (f50161yn) {
            Ot ot2 = new Ot(vw2.dC(), ocVar);
            ot2.Vw(yn(vw2, (d2) ot2));
            vw2.yn(ot2);
            com.huawei.location.cache.yn.Vw().yn(vw2);
            this.E5.Vw(vw2);
            return ot2;
        }
        zp zpVar = new zp(vw2.dC(), ocVar);
        zpVar.Vw(yn(vw2, (d2) zpVar));
        vw2.yn(zpVar);
        com.huawei.location.cache.yn.Vw().yn(vw2);
        com.huawei.location.nlp.api.yn.yn().Vw(vw2.dC());
        return zpVar;
    }

    public static LW yn() {
        if (FB == null) {
            synchronized (Vw) {
                if (FB == null) {
                    FB = new LW();
                }
            }
        }
        return FB;
    }

    private void yn(d2 d2Var) {
        if (this.dC == null) {
            HandlerThread handlerThread = new HandlerThread("FullSDK-hwLocationManager-HwLocationManager");
            handlerThread.start();
            this.dC = new Handler(handlerThread.getLooper());
        }
        this.dC.postDelayed(new Vw(this, d2Var), 100);
    }

    private boolean yn(int i11) {
        return i11 == 300 || i11 == 102 || i11 == 104;
    }

    private boolean yn(com.huawei.location.cache.Vw vw2, d2 d2Var) {
        LocationRequest Vw2 = vw2.Vw();
        boolean z11 = false;
        if (Vw2 == null) {
            return false;
        }
        long maxWaitTime = Vw2.getMaxWaitTime();
        if (maxWaitTime != 0) {
            if (maxWaitTime >= Vw2.getInterval() * 2) {
                LogConsole.i("HwLocationManager", "maxWaitTime is enable , add to MaxWaitTimeQueue");
                d2.Vw.f50166yn.yn(d2Var, vw2.E5(), Vw2.getMaxWaitTime(), Vw2);
                z11 = true;
            }
            Vw2.setMaxWaitTime(0);
        }
        return z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void FB(com.huawei.location.cache.Vw r5, com.huawei.location.callback.oc r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.huawei.location.cache.yn r0 = com.huawei.location.cache.yn.Vw()     // Catch:{ all -> 0x0090 }
            java.lang.String r1 = r5.d2()     // Catch:{ all -> 0x0090 }
            boolean r0 = r0.yn((java.lang.String) r1)     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x001e
            java.lang.String r0 = r5.d2()     // Catch:{ LocationServiceException -> 0x0017 }
            r4.yn((java.lang.String) r0)     // Catch:{ LocationServiceException -> 0x0017 }
            goto L_0x001e
        L_0x0017:
            java.lang.String r0 = "HwLocationManager"
            java.lang.String r1 = "requestLocationUpdatesEx throw locationServiceException"
            com.huawei.location.lite.common.log.LogConsole.e(r0, r1)     // Catch:{ all -> 0x0090 }
        L_0x001e:
            int r0 = r5.FB()     // Catch:{ all -> 0x0090 }
            com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest r1 = r5.dC()     // Catch:{ all -> 0x0090 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            r2.<init>()     // Catch:{ all -> 0x0090 }
            java.lang.String r3 = "requestLocationUpdatesEx priority = "
            r2.append(r3)     // Catch:{ all -> 0x0090 }
            r2.append(r0)     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0090 }
            java.lang.String r3 = "HwLocationManager"
            com.huawei.location.lite.common.log.LogConsole.i(r3, r2)     // Catch:{ all -> 0x0090 }
            r2 = 300(0x12c, float:4.2E-43)
            if (r0 != r2) goto L_0x0045
            com.huawei.location.callback.d2 r6 = r4.yn((com.huawei.location.cache.Vw) r5, (com.huawei.location.callback.oc) r6)     // Catch:{ all -> 0x0090 }
            goto L_0x0067
        L_0x0045:
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 != r2) goto L_0x008b
            com.huawei.location.callback.E5 r0 = new com.huawei.location.callback.E5     // Catch:{ all -> 0x0090 }
            r0.<init>(r1, r6)     // Catch:{ all -> 0x0090 }
            boolean r6 = r4.yn((com.huawei.location.cache.Vw) r5, (com.huawei.location.callback.d2) r0)     // Catch:{ all -> 0x0090 }
            r0.Vw((boolean) r6)     // Catch:{ all -> 0x0090 }
            r5.yn(r0)     // Catch:{ all -> 0x0090 }
            com.huawei.location.cache.yn r6 = com.huawei.location.cache.yn.Vw()     // Catch:{ all -> 0x0090 }
            r6.yn((com.huawei.location.cache.Vw) r5)     // Catch:{ all -> 0x0090 }
            com.huawei.location.gnss.api.yn r6 = com.huawei.location.gnss.api.yn.yn()     // Catch:{ all -> 0x0090 }
            r6.yn(r1, r0)     // Catch:{ all -> 0x0090 }
            r6 = r0
        L_0x0067:
            com.huawei.location.callback.oc r0 = r6.f50014yn     // Catch:{ all -> 0x0090 }
            r0.yn()     // Catch:{ all -> 0x0090 }
            r4.yn((com.huawei.location.callback.d2) r6)     // Catch:{ all -> 0x0090 }
            int r5 = r5.FB()     // Catch:{ all -> 0x0090 }
            com.huawei.location.logic.dC r6 = r4.LW     // Catch:{ all -> 0x0090 }
            if (r6 != 0) goto L_0x007e
            com.huawei.location.logic.dC r6 = new com.huawei.location.logic.dC     // Catch:{ all -> 0x0090 }
            r6.<init>()     // Catch:{ all -> 0x0090 }
            r4.LW = r6     // Catch:{ all -> 0x0090 }
        L_0x007e:
            boolean r5 = r4.yn((int) r5)     // Catch:{ all -> 0x0090 }
            if (r5 == 0) goto L_0x0089
            com.huawei.location.logic.dC r5 = r4.LW     // Catch:{ all -> 0x0090 }
            r5.registerNetworkObserve()     // Catch:{ all -> 0x0090 }
        L_0x0089:
            monitor-exit(r4)
            return
        L_0x008b:
            r4.Vw(r5, r6)     // Catch:{ all -> 0x0090 }
            monitor-exit(r4)
            return
        L_0x0090:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.logic.LW.FB(com.huawei.location.cache.Vw, com.huawei.location.callback.oc):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x006b, code lost:
        if ((r4 - r6) > 60000000000L) goto L_0x006f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.location.Location Vw() {
        /*
            r13 = this;
            android.content.Context r0 = com.huawei.location.lite.common.android.context.ContextUtil.getContext()
            boolean r0 = com.huawei.location.lite.common.util.LocationUtil.isLocationEnabled(r0)
            java.lang.String r1 = "HwLocationManager"
            if (r0 != 0) goto L_0x0013
            java.lang.String r0 = "location unable"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r0)
            r0 = 0
            return r0
        L_0x0013:
            com.huawei.location.gnss.api.yn r0 = com.huawei.location.gnss.api.yn.yn()
            java.lang.String r2 = "gps"
            android.location.Location r0 = r0.yn((java.lang.String) r2)
            com.huawei.location.gnss.api.yn r2 = com.huawei.location.gnss.api.yn.yn()
            java.lang.String r3 = "network"
            android.location.Location r2 = r2.yn((java.lang.String) r3)
            com.huawei.location.cache.yn r3 = com.huawei.location.cache.yn.Vw()
            android.location.Location r3 = r3.FB()
            if (r2 != 0) goto L_0x0037
            java.lang.String r2 = "native network is null,use cache network"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r2)
            goto L_0x006e
        L_0x0037:
            if (r3 != 0) goto L_0x003f
            java.lang.String r3 = "cacheLocation loacation is null,use native network"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r3)
            goto L_0x006f
        L_0x003f:
            long r4 = r2.getElapsedRealtimeNanos()
            long r6 = r3.getElapsedRealtimeNanos()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "nativeLocTime:"
            r8.append(r9)
            r8.append(r4)
            java.lang.String r9 = ",cacheLocTime:"
            r8.append(r9)
            r8.append(r6)
            java.lang.String r8 = r8.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r1, r8)
            long r4 = r4 - r6
            r6 = 60000000000(0xdf8475800, double:2.96439387505E-313)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x006e
            goto L_0x006f
        L_0x006e:
            r2 = r3
        L_0x006f:
            java.lang.String r3 = "return netBestLoc"
            if (r0 != 0) goto L_0x0077
            com.huawei.location.lite.common.log.LogConsole.i(r1, r3)
            return r2
        L_0x0077:
            java.lang.String r4 = "return nativeGPSLoc"
            if (r2 != 0) goto L_0x007f
            com.huawei.location.lite.common.log.LogConsole.i(r1, r4)
            return r0
        L_0x007f:
            long r5 = r0.getElapsedRealtimeNanos()
            long r7 = r2.getElapsedRealtimeNanos()
            long r9 = r5 - r7
            long r9 = java.lang.Math.abs(r9)
            r11 = 11000000000(0x28fa6ae00, double:5.4347221043E-314)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L_0x00aa
            float r5 = r0.getAccuracy()
            float r6 = r2.getAccuracy()
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x00a6
            com.huawei.location.lite.common.log.LogConsole.i(r1, r4)
            return r0
        L_0x00a6:
            com.huawei.location.lite.common.log.LogConsole.i(r1, r3)
            return r2
        L_0x00aa:
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x00b2
            com.huawei.location.lite.common.log.LogConsole.i(r1, r4)
            return r0
        L_0x00b2:
            com.huawei.location.lite.common.log.LogConsole.i(r1, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.logic.LW.Vw():android.location.Location");
    }

    public void yn(String str) throws LocationServiceException {
        com.huawei.location.cache.Vw Vw2 = com.huawei.location.cache.yn.Vw().Vw(str);
        if (Vw2 == null || TextUtils.isEmpty(Vw2.LW())) {
            throw new LocationServiceException(LocationStatusCode.NO_MATCHED_CALLBACK, LocationStatusCode.getStatusCodeString(LocationStatusCode.NO_MATCHED_CALLBACK));
        }
        yn(Vw2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void yn(@androidx.annotation.NonNull com.huawei.location.cache.Vw r5) {
        /*
            r4 = this;
            com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest r0 = r5.dC()
            com.huawei.location.logic.d2 r1 = com.huawei.location.logic.d2.Vw.f50166yn
            java.lang.String r2 = r0.getTid()
            r1.yn((com.huawei.location.cache.Vw) r5, (java.lang.String) r2)
            java.lang.String r1 = r5.LW()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "handlerRemoveRequest, uuid is "
            r2.append(r3)
            java.lang.String r0 = r0.getUuid()
            r2.append(r0)
            java.lang.String r0 = ", provider is "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = "HwLocationManager"
            com.huawei.location.lite.common.log.LogConsole.i(r2, r0)
            java.lang.String r0 = "network"
            boolean r0 = android.text.TextUtils.equals(r1, r0)
            if (r0 == 0) goto L_0x0041
        L_0x003d:
            r4.Vw(r5)
            goto L_0x0077
        L_0x0041:
            java.lang.String r0 = "fused"
            boolean r0 = android.text.TextUtils.equals(r1, r0)
            if (r0 == 0) goto L_0x0055
            com.huawei.location.gnss.api.yn r0 = com.huawei.location.gnss.api.yn.yn()
            com.huawei.location.callback.d2 r1 = r5.yn()
            r0.yn((android.location.LocationListener) r1)
            goto L_0x003d
        L_0x0055:
            java.lang.String r0 = "passive"
            boolean r0 = android.text.TextUtils.equals(r1, r0)
            if (r0 != 0) goto L_0x006c
            java.lang.String r0 = "gps"
            boolean r0 = android.text.TextUtils.equals(r1, r0)
            if (r0 == 0) goto L_0x0066
            goto L_0x006c
        L_0x0066:
            java.lang.String r5 = "handlerRemoveRequest fail"
            com.huawei.location.lite.common.log.LogConsole.i(r2, r5)
            return
        L_0x006c:
            com.huawei.location.gnss.api.yn r0 = com.huawei.location.gnss.api.yn.yn()
            com.huawei.location.callback.d2 r1 = r5.yn()
            r0.yn((android.location.LocationListener) r1)
        L_0x0077:
            int r5 = r5.FB()
            com.huawei.location.logic.dC r0 = r4.LW
            if (r0 == 0) goto L_0x008a
            boolean r5 = r4.yn((int) r5)
            if (r5 == 0) goto L_0x008a
            com.huawei.location.logic.dC r5 = r4.LW
            r5.unRegisterNetworkObserve()
        L_0x008a:
            com.huawei.location.cache.yn r5 = com.huawei.location.cache.yn.Vw()
            j$.util.concurrent.ConcurrentHashMap r5 = r5.yn()
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x00a2
            com.huawei.location.logic.dC r5 = r4.LW
            if (r5 == 0) goto L_0x00a2
            r5.unRegisterAllObserve()
            r5 = 0
            r4.LW = r5
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.logic.LW.yn(com.huawei.location.cache.Vw):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e0, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void Vw(@androidx.annotation.NonNull com.huawei.location.cache.Vw r4, @androidx.annotation.NonNull com.huawei.location.callback.oc r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.huawei.location.cache.yn r0 = com.huawei.location.cache.yn.Vw()     // Catch:{ all -> 0x00ea }
            java.lang.String r1 = r4.d2()     // Catch:{ all -> 0x00ea }
            boolean r0 = r0.yn((java.lang.String) r1)     // Catch:{ all -> 0x00ea }
            if (r0 == 0) goto L_0x001e
            java.lang.String r0 = r4.d2()     // Catch:{ LocationServiceException -> 0x0017 }
            r3.yn((java.lang.String) r0)     // Catch:{ LocationServiceException -> 0x0017 }
            goto L_0x001e
        L_0x0017:
            java.lang.String r0 = "HwLocationManager"
            java.lang.String r1 = "requestLocationUpdates throw locationServiceException"
            com.huawei.location.lite.common.log.LogConsole.e(r0, r1)     // Catch:{ all -> 0x00ea }
        L_0x001e:
            com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest r0 = r4.dC()     // Catch:{ all -> 0x00ea }
            java.lang.String r1 = r4.LW()     // Catch:{ all -> 0x00ea }
            java.lang.String r2 = "network"
            boolean r1 = android.text.TextUtils.equals(r1, r2)     // Catch:{ all -> 0x00ea }
            if (r1 == 0) goto L_0x0034
            com.huawei.location.callback.d2 r0 = r3.yn((com.huawei.location.cache.Vw) r4, (com.huawei.location.callback.oc) r5)     // Catch:{ all -> 0x00ea }
            goto L_0x00bf
        L_0x0034:
            java.lang.String r1 = r4.LW()     // Catch:{ all -> 0x00ea }
            java.lang.String r2 = "fused"
            boolean r1 = android.text.TextUtils.equals(r1, r2)     // Catch:{ all -> 0x00ea }
            if (r1 == 0) goto L_0x0095
            boolean r0 = f50161yn     // Catch:{ all -> 0x00ea }
            if (r0 == 0) goto L_0x0064
            com.huawei.location.callback.dC r0 = new com.huawei.location.callback.dC     // Catch:{ all -> 0x00ea }
            com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest r1 = r4.dC()     // Catch:{ all -> 0x00ea }
            r0.<init>(r1, r5)     // Catch:{ all -> 0x00ea }
            boolean r1 = r3.yn((com.huawei.location.cache.Vw) r4, (com.huawei.location.callback.d2) r0)     // Catch:{ all -> 0x00ea }
            r0.Vw((boolean) r1)     // Catch:{ all -> 0x00ea }
            r4.yn(r0)     // Catch:{ all -> 0x00ea }
            com.huawei.location.cache.yn r1 = com.huawei.location.cache.yn.Vw()     // Catch:{ all -> 0x00ea }
            r1.yn((com.huawei.location.cache.Vw) r4)     // Catch:{ all -> 0x00ea }
            com.huawei.location.provider.yn r1 = r3.E5     // Catch:{ all -> 0x00ea }
            r1.Vw(r4)     // Catch:{ all -> 0x00ea }
            goto L_0x0089
        L_0x0064:
            com.huawei.location.callback.ut r0 = new com.huawei.location.callback.ut     // Catch:{ all -> 0x00ea }
            com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest r1 = r4.dC()     // Catch:{ all -> 0x00ea }
            r0.<init>(r1, r5)     // Catch:{ all -> 0x00ea }
            boolean r1 = r3.yn((com.huawei.location.cache.Vw) r4, (com.huawei.location.callback.d2) r0)     // Catch:{ all -> 0x00ea }
            r0.Vw((boolean) r1)     // Catch:{ all -> 0x00ea }
            r4.yn(r0)     // Catch:{ all -> 0x00ea }
            com.huawei.location.cache.yn r1 = com.huawei.location.cache.yn.Vw()     // Catch:{ all -> 0x00ea }
            r1.yn((com.huawei.location.cache.Vw) r4)     // Catch:{ all -> 0x00ea }
            com.huawei.location.nlp.api.yn r1 = com.huawei.location.nlp.api.yn.yn()     // Catch:{ all -> 0x00ea }
            com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest r2 = r4.dC()     // Catch:{ all -> 0x00ea }
            r1.Vw(r2)     // Catch:{ all -> 0x00ea }
        L_0x0089:
            com.huawei.location.gnss.api.yn r1 = com.huawei.location.gnss.api.yn.yn()     // Catch:{ all -> 0x00ea }
            com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest r2 = r4.dC()     // Catch:{ all -> 0x00ea }
            r1.yn(r2, r0)     // Catch:{ all -> 0x00ea }
            goto L_0x00bf
        L_0x0095:
            java.lang.String r1 = r4.LW()     // Catch:{ all -> 0x00ea }
            java.lang.String r2 = "passive"
            boolean r1 = android.text.TextUtils.equals(r1, r2)     // Catch:{ all -> 0x00ea }
            if (r1 == 0) goto L_0x00e1
            com.huawei.location.callback.zp r1 = new com.huawei.location.callback.zp     // Catch:{ all -> 0x00ea }
            r1.<init>(r0, r5)     // Catch:{ all -> 0x00ea }
            boolean r2 = r3.yn((com.huawei.location.cache.Vw) r4, (com.huawei.location.callback.d2) r1)     // Catch:{ all -> 0x00ea }
            r1.Vw((boolean) r2)     // Catch:{ all -> 0x00ea }
            r4.yn(r1)     // Catch:{ all -> 0x00ea }
            com.huawei.location.cache.yn r2 = com.huawei.location.cache.yn.Vw()     // Catch:{ all -> 0x00ea }
            r2.yn((com.huawei.location.cache.Vw) r4)     // Catch:{ all -> 0x00ea }
            com.huawei.location.gnss.api.yn r2 = com.huawei.location.gnss.api.yn.yn()     // Catch:{ all -> 0x00ea }
            r2.yn(r0, r1)     // Catch:{ all -> 0x00ea }
            r0 = r1
        L_0x00bf:
            r5.yn()     // Catch:{ all -> 0x00ea }
            r3.yn((com.huawei.location.callback.d2) r0)     // Catch:{ all -> 0x00ea }
            int r4 = r4.FB()     // Catch:{ all -> 0x00ea }
            com.huawei.location.logic.dC r5 = r3.LW     // Catch:{ all -> 0x00ea }
            if (r5 != 0) goto L_0x00d4
            com.huawei.location.logic.dC r5 = new com.huawei.location.logic.dC     // Catch:{ all -> 0x00ea }
            r5.<init>()     // Catch:{ all -> 0x00ea }
            r3.LW = r5     // Catch:{ all -> 0x00ea }
        L_0x00d4:
            boolean r4 = r3.yn((int) r4)     // Catch:{ all -> 0x00ea }
            if (r4 == 0) goto L_0x00df
            com.huawei.location.logic.dC r4 = r3.LW     // Catch:{ all -> 0x00ea }
            r4.registerNetworkObserve()     // Catch:{ all -> 0x00ea }
        L_0x00df:
            monitor-exit(r3)
            return
        L_0x00e1:
            java.lang.String r4 = "HwLocationManager"
            java.lang.String r5 = "end"
            com.huawei.location.lite.common.log.LogConsole.i(r4, r5)     // Catch:{ all -> 0x00ea }
            monitor-exit(r3)
            return
        L_0x00ea:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.logic.LW.Vw(com.huawei.location.cache.Vw, com.huawei.location.callback.oc):void");
    }
}
