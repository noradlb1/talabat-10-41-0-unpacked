package com.huawei.location.nlp.logic;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.location.lite.common.config.ConfigManager;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.nlp.network.request.cell.CellSourceInfo;
import com.huawei.location.nlp.network.request.wifi.WifiInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class yn {
    private static volatile yn Vw;

    /* renamed from: yn  reason: collision with root package name */
    private static final byte[] f50183yn = new byte[0];
    private List<WifiInfo> E5 = new ArrayList();
    private long FB = 30000;
    private long LW = 30000;

    /* renamed from: d2  reason: collision with root package name */
    private long f50184d2 = 0;
    private List<CellSourceInfo> dC = new ArrayList();

    /* renamed from: zp  reason: collision with root package name */
    private long f50185zp = 0;

    private yn() {
        String config = ConfigManager.getInstance().getConfig("location", "valid_wifi_position_time");
        if (!TextUtils.isEmpty(config)) {
            LogConsole.d("NLPCacheManger", "get valid wifi time " + config);
            this.FB = TimeUnit.SECONDS.toMillis((long) Integer.parseInt(config));
        }
        String config2 = ConfigManager.getInstance().getConfig("location", "valid_cell_position_time");
        if (!TextUtils.isEmpty(config2)) {
            LogConsole.d("NLPCacheManger", "get valid cell time " + config2);
            this.LW = TimeUnit.SECONDS.toMillis((long) Integer.parseInt(config2));
        }
    }

    public static yn dC() {
        if (Vw == null) {
            synchronized (f50183yn) {
                if (Vw == null) {
                    Vw = new yn();
                }
            }
        }
        return Vw;
    }

    public List<WifiInfo> E5() {
        return this.E5;
    }

    public synchronized List<CellSourceInfo> FB() {
        return this.dC;
    }

    public synchronized long LW() {
        return this.f50185zp;
    }

    public void Vw(Pair<Long, List<WifiInfo>> pair) {
        this.f50184d2 = ((Long) pair.first).longValue();
        this.E5 = (List) pair.second;
    }

    public boolean Vw() {
        List<WifiInfo> list = this.E5;
        if (list != null && !list.isEmpty()) {
            return SystemClock.elapsedRealtime() - this.f50184d2 < this.FB;
        }
        LogConsole.e("NLPCacheManger", "wifiInfoList is empty");
        return false;
    }

    public long d2() {
        return TimeUnit.MILLISECONDS.toNanos(this.f50184d2);
    }

    public synchronized void yn(Pair<Long, List<CellSourceInfo>> pair) {
        this.f50185zp = ((Long) pair.first).longValue();
        this.dC = (List) pair.second;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean yn() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.List<com.huawei.location.nlp.network.request.cell.CellSourceInfo> r0 = r8.dC     // Catch:{ all -> 0x002a }
            r1 = 0
            if (r0 == 0) goto L_0x0021
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x000d
            goto L_0x0021
        L_0x000d:
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x002a }
            long r4 = r8.f50185zp     // Catch:{ all -> 0x002a }
            r6 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r4 / r6
            long r2 = r2 - r4
            long r4 = r8.LW     // Catch:{ all -> 0x002a }
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x001f
            r1 = 1
        L_0x001f:
            monitor-exit(r8)
            return r1
        L_0x0021:
            java.lang.String r0 = "NLPCacheManger"
            java.lang.String r2 = "cellInfoList is empty"
            com.huawei.location.lite.common.log.LogConsole.e(r0, r2)     // Catch:{ all -> 0x002a }
            monitor-exit(r8)
            return r1
        L_0x002a:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.nlp.logic.yn.yn():boolean");
    }
}
