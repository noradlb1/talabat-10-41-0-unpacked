package com.huawei.location.vdr;

import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.RequiresApi;
import com.google.gson.Gson;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.ExecutorUtil;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.vdr.data.LW;
import com.huawei.location.vdr.listener.FB;
import com.huawei.location.vdr.listener.IVdrLocationListener;
import com.huawei.location.vdr.listener.Vw;
import com.huawei.riemann.gnsslocation.api.vdr.VdrLocationClient;
import com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris;
import com.huawei.riemann.gnsslocation.core.bean.eph.GpsEphemeris;
import com.huawei.riemann.gnsslocation.core.bean.obs.Pvt;
import com.huawei.secure.android.common.intent.SafeBundle;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.concurrent.atomic.AtomicBoolean;

@RequiresApi(api = 24)
@Instrumented
public class VdrManager implements Vw, FB {
    private static final String EPH_THREAD_NAME = "Loc-Vdr-EphUpdate";
    private static final long EPH_UPDATE_TIME = 30;
    private static final long SYNC_LOCATION_UPDATE_TIME = 200;
    private static final String TAG = "VdrManager";
    private static final byte[] VDR_SYNC_LOCK = new byte[0];
    private static volatile VdrManager instance;
    /* access modifiers changed from: private */
    public Ephemeris currentEphemeris;
    /* access modifiers changed from: private */
    public long ephExpiredTime = 0;
    /* access modifiers changed from: private */
    public com.huawei.location.vdr.data.ephemeris.yn ephProvider;
    private final AtomicBoolean isVdrStart;
    private volatile long lastSyncTime;
    /* access modifiers changed from: private */
    public final AtomicBoolean updateEphemeris;
    private LW vdrDataManager;
    private VdrLocationClient vdrLocationClient;

    public class yn implements Runnable {
        public yn() {
        }

        public void run() {
            Thread currentThread = Thread.currentThread();
            currentThread.setName(VdrManager.EPH_THREAD_NAME + hashCode());
            VdrManager vdrManager = VdrManager.this;
            Ephemeris unused = vdrManager.currentEphemeris = vdrManager.ephProvider.Vw();
            if (VdrManager.this.currentEphemeris != null) {
                VdrManager vdrManager2 = VdrManager.this;
                long unused2 = vdrManager2.ephExpiredTime = vdrManager2.ephProvider.FB();
                VdrManager.this.updateEphemeris.set(true);
            }
        }
    }

    private VdrManager() {
        LogConsole.i(TAG, "VdrManager init");
        this.isVdrStart = new AtomicBoolean(false);
        this.updateEphemeris = new AtomicBoolean(false);
    }

    private boolean checkAndUpdateEphemeris() {
        com.huawei.location.vdr.data.ephemeris.Vw vw2 = new com.huawei.location.vdr.data.ephemeris.Vw(System.currentTimeMillis());
        updateEphemeris(vw2.Vw());
        if (this.updateEphemeris.get() && this.currentEphemeris != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("updateEphemeris GpsEphemeris:");
            Gson instance2 = GsonUtil.getInstance();
            GpsEphemeris gpsEphemeris = this.currentEphemeris.getGpsEphemeris();
            sb2.append(!(instance2 instanceof Gson) ? instance2.toJson((Object) gpsEphemeris) : GsonInstrumentation.toJson(instance2, (Object) gpsEphemeris));
            LogConsole.i(TAG, sb2.toString());
            this.vdrLocationClient.updateEphemeris(this.currentEphemeris);
            this.updateEphemeris.set(false);
        }
        return vw2.Vw() < this.ephExpiredTime;
    }

    private boolean checkFirstRequestDataIsValid(com.huawei.location.vdr.data.FB fb2) {
        return (fb2.Vw() == null || fb2.yn() == null || fb2.FB() == null) ? false : true;
    }

    private void clearVdr() {
        LW lw2 = this.vdrDataManager;
        if (lw2 != null) {
            lw2.Vw();
            this.vdrDataManager = null;
        }
        VdrLocationClient vdrLocationClient2 = this.vdrLocationClient;
        if (vdrLocationClient2 != null) {
            vdrLocationClient2.stopLocation();
            this.vdrLocationClient = null;
        }
    }

    public static VdrManager getInstance() {
        if (instance == null) {
            synchronized (VDR_SYNC_LOCK) {
                if (instance == null) {
                    instance = new VdrManager();
                }
            }
        }
        return instance;
    }

    private void handlerNativeLocationToVdr() {
        LogConsole.i(TAG, "vdr process fail, return native location here");
        LW lw2 = this.vdrDataManager;
        if (lw2 != null && lw2.yn() != null) {
            com.huawei.location.vdr.listener.LW.yn().yn(this.vdrDataManager.yn());
        }
    }

    private void handlerVdrLocation(com.huawei.location.vdr.data.FB fb2) {
        Pvt pvt;
        Location Vw = fb2.Vw();
        if (Vw != null) {
            pvt = Pvt.Builder.aPvt().withAccuracy(Vw.getAccuracy()).withAltitude(Vw.getAltitude()).withLatitude(Vw.getLatitude()).withLongitude(Vw.getLongitude()).withBearing(Vw.getBearing()).withSpeed(Vw.getSpeed()).withTime(Vw.getTime()).build();
        } else {
            pvt = null;
        }
        LogConsole.d(TAG, "process vdr start");
        Pvt process = this.vdrLocationClient.process(pvt, fb2.yn(), fb2.FB(), (Pvt) null);
        if (process == null || process.getLatitude() == 0.0d || process.getLongitude() == 0.0d) {
            handlerNativeLocationToVdr();
            return;
        }
        LogConsole.i(TAG, "process vdr end, errorCode is: " + process.getErrCode());
        com.huawei.location.vdr.listener.LW yn2 = com.huawei.location.vdr.listener.LW.yn();
        if (Vw == null) {
            Vw = new Location("GPS");
        }
        Vw.setTime(System.currentTimeMillis());
        Vw.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());
        Vw.setLongitude(process.getLongitude());
        Vw.setLatitude(process.getLatitude());
        Vw.setAltitude(process.getAltitude());
        Vw.setAccuracy(process.getAccuracy());
        Vw.setBearing(process.getBearing());
        Vw.setSpeed(process.getSpeed());
        Bundle extras = Vw.getExtras();
        SafeBundle safeBundle = new SafeBundle(extras);
        if (process.getErrCode() == 1) {
            if (safeBundle.containsKey("LocationSource")) {
                safeBundle.putInt("LocationSource", extras.getInt("LocationSource") | 2);
            } else {
                safeBundle.putInt("LocationSource", 2);
            }
        }
        Vw.setExtras(safeBundle.getBundle());
        yn2.yn(Vw);
    }

    private void initVdrDataManager() {
        LW lw2 = new LW();
        this.vdrDataManager = lw2;
        lw2.yn((Vw) this);
        this.ephProvider = new com.huawei.location.vdr.data.ephemeris.yn();
    }

    private void loadVdrFile() {
        new com.huawei.location.vdr.file.yn().yn((FB) this);
    }

    private synchronized void processVdrData(com.huawei.location.vdr.data.FB fb2) {
        if (com.huawei.location.vdr.listener.LW.yn().Vw()) {
            LogConsole.e(TAG, "vdr listener is null");
        } else if (this.vdrLocationClient == null) {
            LogConsole.e(TAG, "vdrLocationClient init failed");
            handlerNativeLocationToVdr();
        } else if (fb2 == null) {
            LogConsole.e(TAG, "vdr data is null");
            handlerNativeLocationToVdr();
        } else if (!checkAndUpdateEphemeris()) {
            LogConsole.i(TAG, "checkAndUpdateEphemeris failed,stop algo");
            if (this.isVdrStart.get()) {
                this.vdrLocationClient.stopLocation();
            }
            this.isVdrStart.set(false);
            handlerNativeLocationToVdr();
        } else {
            if (!this.isVdrStart.get()) {
                if (!checkFirstRequestDataIsValid(fb2)) {
                    LogConsole.d(TAG, "first requestData is not valid,dropping it!");
                    handlerNativeLocationToVdr();
                    return;
                }
                int startLocation = this.vdrLocationClient.startLocation(com.huawei.location.activity.model.Vw.Vw());
                LogConsole.i(TAG, "processGnssLocation startLocation status:" + startLocation);
                if (startLocation == 0) {
                    this.isVdrStart.set(true);
                } else {
                    this.isVdrStart.set(false);
                    handlerNativeLocationToVdr();
                    return;
                }
            }
            handlerVdrLocation(fb2);
        }
    }

    private void startVdrAlgo() {
        VdrLocationClient vdrLocationClient2 = new VdrLocationClient(ContextUtil.getContext(), com.huawei.location.vdr.util.FB.Vw);
        this.vdrLocationClient = vdrLocationClient2;
        this.isVdrStart.set(vdrLocationClient2.startLocation(com.huawei.location.activity.model.Vw.Vw()) == 0);
        Ephemeris yn2 = this.ephProvider.yn();
        if (yn2 != null) {
            this.ephExpiredTime = this.ephProvider.FB();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("updateEphemeris GpsEphemeris:");
            Gson instance2 = GsonUtil.getInstance();
            GpsEphemeris gpsEphemeris = yn2.getGpsEphemeris();
            sb2.append(!(instance2 instanceof Gson) ? instance2.toJson((Object) gpsEphemeris) : GsonInstrumentation.toJson(instance2, (Object) gpsEphemeris));
            LogConsole.i(TAG, sb2.toString());
            this.vdrLocationClient.updateEphemeris(yn2);
        }
    }

    private void updateEphemeris(long j11) {
        LogConsole.i(TAG, "currentGpsTime is : " + j11 + ", ephExpiredTime is : " + this.ephExpiredTime);
        if (j11 + EPH_UPDATE_TIME >= this.ephExpiredTime) {
            ExecutorUtil.getInstance().execute(new yn());
        }
    }

    public synchronized void handleLoadResult(boolean z11) {
        if (z11) {
            initVdrDataManager();
            startVdrAlgo();
        }
    }

    public boolean isVdrIntervalStart() {
        return this.vdrDataManager != null;
    }

    public synchronized void onVdrDataReceived(com.huawei.location.vdr.data.FB fb2) {
        processVdrData(fb2);
    }

    public synchronized void registerVdrLocationLis(IVdrLocationListener iVdrLocationListener) {
        com.huawei.location.vdr.listener.LW.yn().Vw(iVdrLocationListener);
        if (!isVdrIntervalStart()) {
            loadVdrFile();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void syncLocation(android.location.Location r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            r0.<init>()     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = "ElapsedRealtimeNanos time is: "
            r0.append(r1)     // Catch:{ all -> 0x0043 }
            long r1 = r5.getElapsedRealtimeNanos()     // Catch:{ all -> 0x0043 }
            r0.append(r1)     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = ", lastSyncTime is: "
            r0.append(r1)     // Catch:{ all -> 0x0043 }
            long r1 = r4.lastSyncTime     // Catch:{ all -> 0x0043 }
            r0.append(r1)     // Catch:{ all -> 0x0043 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = "VdrManager"
            com.huawei.location.lite.common.log.LogConsole.d(r1, r0)     // Catch:{ all -> 0x0043 }
            long r0 = r5.getElapsedRealtimeNanos()     // Catch:{ all -> 0x0043 }
            long r2 = r4.lastSyncTime     // Catch:{ all -> 0x0043 }
            long r0 = r0 - r2
            r2 = 200(0xc8, double:9.9E-322)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0034
            monitor-exit(r4)
            return
        L_0x0034:
            com.huawei.location.vdr.data.LW r0 = r4.vdrDataManager     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0041
            r0.yn((android.location.Location) r5)     // Catch:{ all -> 0x0043 }
            long r0 = r5.getElapsedRealtimeNanos()     // Catch:{ all -> 0x0043 }
            r4.lastSyncTime = r0     // Catch:{ all -> 0x0043 }
        L_0x0041:
            monitor-exit(r4)
            return
        L_0x0043:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.vdr.VdrManager.syncLocation(android.location.Location):void");
    }

    public synchronized void unRegisterVdrLocationLis(String str) {
        com.huawei.location.vdr.listener.LW.yn().yn(str);
        if (com.huawei.location.vdr.listener.LW.yn().Vw()) {
            clearVdr();
            LogConsole.i(TAG, "stop vdr manager");
        }
    }
}
