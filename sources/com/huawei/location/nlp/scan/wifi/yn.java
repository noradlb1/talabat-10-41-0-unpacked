package com.huawei.location.nlp.scan.wifi;

import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.LocationUtil;
import com.huawei.location.lite.common.util.NetworkUtil;
import com.huawei.location.nlp.network.request.wifi.WifiInfo;
import com.huawei.location.nlp.scan.LW;
import com.huawei.location.nlp.scan.wifi.FB;
import java.util.List;

public class yn extends LW implements com.huawei.location.nlp.scan.yn {
    private boolean E5 = false;
    private Handler LW;

    /* renamed from: d2  reason: collision with root package name */
    private boolean f50204d2 = true;
    private FB dC = new FB();

    /* renamed from: zp  reason: collision with root package name */
    private FB.yn f50205zp = new C0087yn();

    public class Vw extends Handler {
        public Vw(Looper looper) {
            super(looper);
        }

        public void handleMessage(@NonNull Message message) {
            LogConsole.i("OnlyWifi", "msg.what=" + message.what);
            if (message.what == 0 && yn.c(yn.this)) {
                yn.a(yn.this);
            }
        }
    }

    /* renamed from: com.huawei.location.nlp.scan.wifi.yn$yn  reason: collision with other inner class name */
    public class C0087yn implements FB.yn {
        public C0087yn() {
        }

        public void onFail(int i11, String str) {
            LogConsole.i("OnlyWifi", "wifi scan fail, code is " + i11);
        }

        public void yn(List<ScanResult> list) {
            if (list.isEmpty()) {
                LogConsole.e("OnlyWifi", "scan wifi success, scanResultList is empty");
            } else {
                yn.b(yn.this, list);
            }
        }
    }

    public yn(com.huawei.location.nlp.api.Vw vw2) {
        super(vw2);
        FB();
    }

    private void FB() {
        HandlerThread handlerThread = new HandlerThread("FullSDK-onlineLocation-scan");
        handlerThread.start();
        this.LW = new Vw(handlerThread.getLooper());
    }

    public static void a(yn ynVar) {
        String str;
        ynVar.LW.removeMessages(0);
        ynVar.LW.sendEmptyMessageDelayed(0, 30000);
        if (!ynVar.f50204d2 || !com.huawei.location.nlp.logic.yn.dC().Vw()) {
            ynVar.dC.yn(ynVar.f50205zp);
            str = "requestScan wifi";
        } else {
            str = "first scan, cached wifi is valid";
        }
        LogConsole.i("OnlyWifi", str);
    }

    public static void b(yn ynVar, List list) {
        String str;
        Pair<Long, List<WifiInfo>> yn2 = ynVar.yn((List<ScanResult>) list);
        List list2 = (List) yn2.second;
        if (list2.size() < 1) {
            str = "handlerWifiScanFail, filterResult is empty";
        } else if (LW.yn(list2, com.huawei.location.nlp.logic.yn.dC().E5())) {
            str = "The Wi-Fi scanning result is the same as that in the cache.";
        } else {
            com.huawei.location.nlp.logic.yn.dC().Vw(yn2);
            ynVar.f50204d2 = false;
            ynVar.f50193a.yn();
            return;
        }
        LogConsole.e("OnlyWifi", str);
    }

    public static boolean c(yn ynVar) {
        ynVar.getClass();
        if (!NetworkUtil.isNetworkAvailable(ContextUtil.getContext()) || !LocationUtil.isLocationEnabled(ContextUtil.getContext())) {
            LogConsole.i("OnlyWifi", "gnssAndNet is false");
            return false;
        }
        LogConsole.e("OnlyWifi", "isNeedScan is " + ynVar.E5);
        return ynVar.E5;
    }

    public void Vw() {
        if (this.LW.hasMessages(0)) {
            this.LW.removeMessages(0);
        }
        this.E5 = false;
        this.f50204d2 = true;
        this.dC.yn();
    }

    public void yn() {
        this.E5 = true;
        if (this.LW.hasMessages(0)) {
            this.LW.removeMessages(0);
        }
        this.LW.sendEmptyMessage(0);
    }

    public void yn(long j11) {
        this.f50194b = j11;
    }
}
