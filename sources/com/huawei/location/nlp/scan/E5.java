package com.huawei.location.nlp.scan;

import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellInfo;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.C;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.LocationUtil;
import com.huawei.location.lite.common.util.NetworkUtil;
import com.huawei.location.nlp.network.request.wifi.WifiInfo;
import com.huawei.location.nlp.scan.cell.yn;
import com.huawei.location.nlp.scan.wifi.FB;
import java.util.List;

public class E5 extends LW implements yn {
    private com.huawei.location.nlp.scan.cell.yn E5 = new com.huawei.location.nlp.scan.cell.yn();
    /* access modifiers changed from: private */
    public Handler LW;
    private yn.Vw Ot = new Vw();

    /* renamed from: d2  reason: collision with root package name */
    private boolean f50186d2 = true;
    private com.huawei.location.nlp.scan.wifi.FB dC = new com.huawei.location.nlp.scan.wifi.FB();

    /* renamed from: oc  reason: collision with root package name */
    private FB.yn f50187oc = new yn();
    /* access modifiers changed from: private */

    /* renamed from: ut  reason: collision with root package name */
    public boolean f50188ut = true;

    /* renamed from: zp  reason: collision with root package name */
    private boolean f50189zp = true;

    public class FB extends Handler {
        public FB(Looper looper) {
            super(looper);
        }

        public void handleMessage(@NonNull Message message) {
            LogConsole.i("WifiAndCell", "msg.what=" + message.what);
            int i11 = message.what;
            if (i11 == -1) {
                E5.d(E5.this);
            } else if (i11 != 0) {
                if (i11 == 1 && E5.c(E5.this)) {
                    E5.b(E5.this);
                }
            } else if (E5.c(E5.this)) {
                E5.a(E5.this);
            }
        }
    }

    public class Vw implements yn.Vw {
        public Vw() {
        }

        public void yn(List<CellInfo> list) {
            if (list == null || list.isEmpty()) {
                LogConsole.e("WifiAndCell", "cellInfoList is empty");
                return;
            }
            LogConsole.i("WifiAndCell", "cell scan success, result size is " + list.size());
            com.huawei.location.nlp.logic.yn.dC().yn(E5.this.Vw(list));
            boolean unused = E5.this.f50188ut = false;
        }
    }

    public class yn implements FB.yn {
        public yn() {
        }

        public void onFail(int i11, String str) {
            LogConsole.i("WifiAndCell", "wifi scan fail, code is " + i11);
            if (E5.this.LW.hasMessages(-1)) {
                E5.this.LW.removeMessages(-1);
                E5.this.LW.sendEmptyMessage(-1);
            }
        }

        public void yn(List<ScanResult> list) {
            if (list.isEmpty()) {
                LogConsole.e("WifiAndCell", "wifi scan success, scanResultList is empty");
                return;
            }
            LogConsole.i("WifiAndCell", "wifi scan success, scanResultList size is " + list.size());
            E5.f(E5.this, list);
        }
    }

    public E5(com.huawei.location.nlp.api.Vw vw2) {
        super(vw2);
        FB();
    }

    private void FB() {
        HandlerThread handlerThread = new HandlerThread("FullSDK-onlineLocation-scan");
        handlerThread.start();
        this.LW = new FB(handlerThread.getLooper());
    }

    public static void a(E5 e52) {
        e52.LW.removeMessages(0);
        e52.LW.sendEmptyMessageDelayed(0, 30000);
        boolean Vw2 = com.huawei.location.nlp.logic.yn.dC().Vw();
        LogConsole.i("WifiAndCell", "isFirstScanWifi = " + e52.f50189zp + ",isWifiCacheValid = " + Vw2);
        if (!e52.f50189zp || !Vw2) {
            e52.dC.yn(e52.f50187oc);
        } else {
            e52.f50189zp = false;
        }
    }

    public static void b(E5 e52) {
        e52.LW.removeMessages(1);
        e52.LW.sendEmptyMessageDelayed(1, e52.f50194b);
        boolean yn2 = com.huawei.location.nlp.logic.yn.dC().yn();
        LogConsole.i("WifiAndCell", "isFirstScanCell = " + e52.f50188ut + ", isCellCacheValid = " + yn2);
        if (!e52.f50188ut || !yn2) {
            e52.E5.yn(e52.Ot);
        } else {
            e52.f50188ut = false;
        }
    }

    public static boolean c(E5 e52) {
        e52.getClass();
        if (!NetworkUtil.isNetworkAvailable(ContextUtil.getContext()) || !LocationUtil.isLocationEnabled(ContextUtil.getContext())) {
            LogConsole.i("WifiAndCell", "checkLocationAvailability false");
            return false;
        }
        LogConsole.i("WifiAndCell", "isNeed:" + e52.f50186d2);
        return e52.f50186d2;
    }

    public static void d(E5 e52) {
        e52.f50189zp = false;
        if (com.huawei.location.nlp.logic.yn.dC().yn() || com.huawei.location.nlp.logic.yn.dC().Vw()) {
            LogConsole.i("WifiAndCell", "handlerTimeout onScanResult");
            e52.f50193a.yn();
        }
    }

    public static void f(E5 e52, List list) {
        String str;
        Pair<Long, List<WifiInfo>> yn2 = e52.yn((List<ScanResult>) list);
        List list2 = (List) yn2.second;
        if (list2.size() < 1) {
            str = "handlerWifiScanResult, filterResult is empty";
        } else if (LW.yn(list2, com.huawei.location.nlp.logic.yn.dC().E5())) {
            str = "The Wi-Fi scanning result is the same as that in the cache.";
        } else {
            com.huawei.location.nlp.logic.yn.dC().Vw(yn2);
            if (e52.LW.hasMessages(-1)) {
                e52.LW.removeMessages(-1);
                e52.f50189zp = false;
                e52.f50193a.yn();
                return;
            }
            return;
        }
        LogConsole.e("WifiAndCell", str);
    }

    public void Vw() {
        LogConsole.i("WifiAndCell", "stopScan");
        if (this.LW.hasMessages(0)) {
            this.LW.removeMessages(0);
        }
        if (this.LW.hasMessages(1)) {
            this.LW.removeMessages(1);
        }
        if (this.LW.hasMessages(-1)) {
            this.LW.removeMessages(-1);
        }
        this.dC.yn();
        this.f50186d2 = false;
        this.f50188ut = true;
        this.f50189zp = true;
    }

    public void yn() {
        this.f50186d2 = true;
        if (this.LW.hasMessages(0)) {
            this.LW.removeMessages(0);
        }
        if (this.LW.hasMessages(1)) {
            this.LW.removeMessages(1);
        }
        if (this.LW.hasMessages(-1)) {
            this.LW.removeMessages(-1);
        }
        this.LW.sendEmptyMessage(0);
        this.LW.sendEmptyMessage(1);
        this.LW.sendEmptyMessageDelayed(-1, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    public void yn(long j11) {
        LogConsole.i("WifiAndCell", "setScanInterval:" + j11);
        this.f50194b = j11;
    }
}
