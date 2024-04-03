package com.huawei.location.nlp.api;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.location.LocationProviderCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.config.ConfigManager;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.ExecutorUtil;
import com.huawei.location.lite.common.util.LocationUtil;
import com.huawei.location.lite.common.util.NetworkUtil;
import com.huawei.location.nlp.network.OnlineLocationService;
import com.huawei.location.nlp.network.request.OnlineLocationRequest;
import com.huawei.location.nlp.network.request.cell.CellSourceInfo;
import com.huawei.location.nlp.network.request.wifi.WifiInfo;
import com.huawei.location.nlp.scan.dC;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

public class yn {
    private static volatile yn Vw;

    /* renamed from: yn  reason: collision with root package name */
    private static final byte[] f50175yn = new byte[0];
    private OnlineLocationService E5 = new OnlineLocationService();
    public long FB = 2;
    /* access modifiers changed from: private */
    public boolean G3 = false;
    public long LW = 86400;
    private boolean Ot = true;
    private long Yx = -1;

    /* renamed from: d2  reason: collision with root package name */
    private LocationProviderCallback f50176d2;
    private Handler dC;

    /* renamed from: oc  reason: collision with root package name */
    private int f50177oc = dC.yn();

    /* renamed from: ut  reason: collision with root package name */
    private dC f50178ut = new dC(new C0084yn());

    /* renamed from: zp  reason: collision with root package name */
    private PriorityBlockingQueue<RequestLocationUpdatesRequest> f50179zp;

    public class FB extends Handler {
        public FB(Looper looper) {
            super(looper);
        }

        public void handleMessage(@NonNull Message message) {
            LogConsole.i("NLPClient", "msg.what=" + message.what);
            if (message.what == 0) {
                yn.a(yn.this, true);
            }
        }
    }

    public class Vw implements Comparator<RequestLocationUpdatesRequest> {
        public Vw(yn ynVar) {
        }

        public int compare(@NonNull Object obj, @NonNull Object obj2) {
            if (((RequestLocationUpdatesRequest) obj).getLocationRequest().getInterval() > ((RequestLocationUpdatesRequest) obj2).getLocationRequest().getInterval()) {
                return 1;
            }
            return 0;
        }
    }

    /* renamed from: com.huawei.location.nlp.api.yn$yn  reason: collision with other inner class name */
    public class C0084yn implements Vw {
        public C0084yn() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void Vw() {
            yn.a(yn.this, false);
        }

        public void yn() {
            if (!yn.this.G3) {
                LogConsole.i("NLPClient", "isCacheAvailable is false, do request");
                ExecutorUtil.getInstance().execute(new a(this));
            }
        }
    }

    private yn() {
        Vw();
        this.f50179zp = new PriorityBlockingQueue<>(11, new Vw(this));
        String config = ConfigManager.getInstance().getConfig("location", "position_min_interval");
        String config2 = ConfigManager.getInstance().getConfig("location", "position_max_interval");
        LogConsole.i("NLPClient", "minInterval is " + config + ", maxInterval is " + config2);
        try {
            if (!TextUtils.isEmpty(config)) {
                this.FB = Long.parseLong(config);
            }
            if (!TextUtils.isEmpty(config2)) {
                this.LW = Long.parseLong(config2);
            }
        } catch (NumberFormatException unused) {
            LogConsole.e("NLPClient", "parse interval fail ");
        }
    }

    private void Vw() {
        HandlerThread handlerThread = new HandlerThread("FullSDK-onlineLocation-request");
        handlerThread.start();
        this.dC = new FB(handlerThread.getLooper());
    }

    public static void a(yn ynVar, boolean z11) {
        boolean z12;
        ynVar.getClass();
        if (!NetworkUtil.isNetworkAvailable(ContextUtil.getContext()) || !LocationUtil.isLocationEnabled(ContextUtil.getContext())) {
            LogConsole.e("NLPClient", "doRequest fail, Network or LocationEnabled is not available");
            return;
        }
        if (z11) {
            ynVar.dC.removeMessages(0);
            ynVar.dC.sendEmptyMessageDelayed(0, ynVar.Yx);
        }
        OnlineLocationRequest onlineLocationRequest = new OnlineLocationRequest();
        int i11 = ynVar.f50177oc;
        if (i11 == 1) {
            onlineLocationRequest.setWifiScanResult(com.huawei.location.nlp.logic.yn.dC().E5());
            z12 = com.huawei.location.nlp.logic.yn.dC().Vw();
        } else if (i11 == 2) {
            onlineLocationRequest.setCellInfos(com.huawei.location.nlp.logic.yn.dC().FB());
            z12 = com.huawei.location.nlp.logic.yn.dC().yn();
        } else {
            z12 = ynVar.yn(onlineLocationRequest);
        }
        if (!z12) {
            ynVar.G3 = false;
            LogConsole.e("NLPClient", "doRequest, cache is invalid");
            ynVar.f50176d2.onLocationChanged(new HwLocationResult(10100, com.huawei.location.nlp.constant.yn.yn(10100)));
            return;
        }
        ynVar.G3 = true;
        ynVar.f50176d2.onLocationChanged(ynVar.E5.getLocationFromCloud(onlineLocationRequest));
    }

    private void dC() {
        LocationRequest locationRequest;
        RequestLocationUpdatesRequest peek = this.f50179zp.peek();
        if (peek != null && (locationRequest = peek.getLocationRequest()) != null) {
            long interval = locationRequest.getInterval();
            if (interval != this.Yx) {
                this.Yx = Math.min(Math.max(interval, this.FB * 1000), this.LW * 1000);
                LogConsole.i("NLPClient", "currentInterval is " + this.Yx);
                this.f50178ut.yn(this.Yx);
            }
        }
    }

    public static yn yn() {
        if (Vw == null) {
            synchronized (f50175yn) {
                if (Vw == null) {
                    Vw = new yn();
                }
            }
        }
        return Vw;
    }

    private boolean yn(OnlineLocationRequest onlineLocationRequest) {
        List<WifiInfo> E52 = com.huawei.location.nlp.logic.yn.dC().E5();
        boolean Vw2 = com.huawei.location.nlp.logic.yn.dC().Vw();
        if (Vw2) {
            onlineLocationRequest.setWifiScanResult(E52);
        }
        List<CellSourceInfo> FB2 = com.huawei.location.nlp.logic.yn.dC().FB();
        boolean yn2 = com.huawei.location.nlp.logic.yn.dC().yn();
        if (yn2) {
            onlineLocationRequest.setCellInfos(FB2);
        }
        if (!this.Ot) {
            return Vw2 || yn2;
        }
        LogConsole.i("NLPClient", "The first online location request verifies only Wi-Fi availability.");
        this.Ot = false;
        return Vw2;
    }

    public void FB() {
        if (!this.f50179zp.isEmpty()) {
            LogConsole.i("NLPClient", "startRequest");
            if (this.dC.hasMessages(0)) {
                this.dC.removeMessages(0);
            }
            this.dC.sendEmptyMessage(0);
            this.f50178ut.Vw();
        }
    }

    public void LW() {
        LogConsole.i("NLPClient", "stopRequest");
        if (this.dC.hasMessages(0)) {
            this.dC.removeMessages(0);
        }
        this.f50178ut.FB();
    }

    public void Vw(@NonNull RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        if (requestLocationUpdatesRequest.getLocationRequest() != null) {
            this.f50179zp.add(requestLocationUpdatesRequest);
            LogConsole.i("NLPClient", "requestLocationUpdates, nlpCache size is " + this.f50179zp.size());
            int i11 = (this.Yx > 0 ? 1 : (this.Yx == 0 ? 0 : -1));
            dC();
            if (i11 <= 0) {
                FB();
            }
        }
    }

    public void yn(LocationProviderCallback locationProviderCallback) {
        this.f50176d2 = locationProviderCallback;
    }

    public void yn(@NonNull RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        this.f50179zp.remove(requestLocationUpdatesRequest);
        LogConsole.i("NLPClient", "removeLocationUpdates, nlpCache size is " + this.f50179zp.size());
        if (this.f50179zp.isEmpty()) {
            LW();
            this.Yx = -1;
            this.Ot = true;
            return;
        }
        dC();
    }
}
