package com.huawei.location.crowdsourcing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.location.crowdsourcing.Config;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class dC implements com.huawei.location.crowdsourcing.common.yn {
    private List<ScanResult> FB = new LinkedList();
    @Nullable
    private LW LW;
    /* access modifiers changed from: private */
    public final Vw Vw;

    /* renamed from: yn  reason: collision with root package name */
    private long f50051yn;

    public static class FB implements Comparator<ScanResult> {
        private FB() {
        }

        public int compare(Object obj, Object obj2) {
            ScanResult scanResult = (ScanResult) obj;
            ScanResult scanResult2 = (ScanResult) obj2;
            int i11 = ((scanResult.timestamp - scanResult2.timestamp) > 0 ? 1 : ((scanResult.timestamp - scanResult2.timestamp) == 0 ? 0 : -1));
            if (i11 == 0) {
                int i12 = scanResult.level - scanResult2.level;
                if (i12 == 0 && (i12 = scanResult.BSSID.compareTo(scanResult2.BSSID)) == 0) {
                    return scanResult.SSID.compareTo(scanResult2.SSID);
                }
                return i12;
            } else if (i11 > 0) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public class LW extends BroadcastReceiver {
        private LW() {
        }

        public void onReceive(Context context, Intent intent) {
            String str;
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            if (action == null) {
                str = "get null action";
            } else if (!action.equals("android.net.wifi.SCAN_RESULTS")) {
                str = "receive unknown action,action:" + action;
            } else {
                boolean booleanExtra = safeIntent.getBooleanExtra("resultsUpdated", false);
                LogConsole.d("WifiCollector", "onReceive action=" + action + " isUpdated=" + booleanExtra);
                if (booleanExtra) {
                    Vw e11 = dC.this.Vw;
                    e11.getClass();
                    e11.obtainMessage(0, Long.valueOf(System.currentTimeMillis())).sendToTarget();
                    return;
                }
                return;
            }
            LogConsole.e("WifiCollector", str);
        }
    }

    public class Vw extends Handler {
        public Vw(Looper looper) {
            super(looper);
        }

        public void handleMessage(@NonNull Message message) {
            if (message.what == 0) {
                Object obj = message.obj;
                if (!(obj instanceof Long)) {
                    LogConsole.e("WifiCollector", "handleMessage not location obj");
                } else {
                    dC.f(dC.this, ((Long) obj).longValue());
                }
            } else {
                LogConsole.e("WifiCollector", "unknown msg:" + message.what);
            }
        }
    }

    public dC(Looper looper) {
        this.Vw = new Vw(looper);
    }

    private boolean Vw(List<ScanResult> list) {
        boolean z11;
        List<ScanResult> list2 = this.FB;
        a aVar = new a();
        if (list2.size() == list.size()) {
            Iterator<ScanResult> it = list2.iterator();
            loop0:
            while (true) {
                if (!it.hasNext()) {
                    z11 = true;
                    break;
                }
                ScanResult next = it.next();
                Iterator<ScanResult> it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!aVar.compare(next, it2.next())) {
                            break loop0;
                        }
                    }
                }
            }
        } else {
            z11 = false;
        }
        if (z11) {
            return false;
        }
        this.FB = list;
        return true;
    }

    public static void f(dC dCVar, long j11) {
        dCVar.f50051yn = j11;
    }

    private void yn(List<ScanResult> list) {
        b bVar = new b(SystemClock.elapsedRealtimeNanos() / 1000, Config.FB.f50027yn.f());
        Iterator<ScanResult> it = list.iterator();
        while (it.hasNext()) {
            if (bVar.yn(it.next())) {
                it.remove();
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean yn(long j11, long j12, ScanResult scanResult) {
        long abs = Math.abs(scanResult.timestamp - j11);
        if (abs <= j12) {
            return false;
        }
        LogConsole.d("WifiCollector", "remove expired(μs). timeDiff:" + abs);
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean yn(ScanResult scanResult, ScanResult scanResult2) {
        return TextUtils.equals(scanResult.BSSID, scanResult2.BSSID) && scanResult.timestamp == scanResult2.timestamp;
    }

    public boolean c() {
        LW lw2 = new LW();
        this.LW = lw2;
        Vw.b().registerReceiver(lw2, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        LogConsole.i("WifiCollector", "wifi scan finish register success");
        return true;
    }

    @Nullable
    public List<ScanResult> d() {
        boolean z11;
        List list;
        Config a11 = Config.FB.f50027yn;
        if (!a11.m()) {
            LogConsole.d("WifiCollector", "no need get wifi");
            return null;
        }
        if (Math.abs(System.currentTimeMillis() - this.f50051yn) <= Config.FB.f50027yn.b()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            LogConsole.d("WifiCollector", "not fresh");
            return null;
        }
        Object systemService = Vw.b().getApplicationContext().getSystemService("wifi");
        if (!(systemService instanceof WifiManager)) {
            LogConsole.d("WifiCollector", "no wifi service");
            list = new ArrayList();
        } else {
            list = ((WifiManager) systemService).getScanResults();
        }
        yn(list);
        int k11 = Config.FB.f50027yn.k();
        int size = list.size();
        if (size > k11) {
            LogConsole.d("WifiCollector", "limit ap num from " + size + " to " + k11);
            Collections.sort(list, new FB());
            list.subList(0, size - k11).clear();
        }
        if (list.isEmpty()) {
            LogConsole.d("WifiCollector", "no available ap info");
            return null;
        } else if (!Vw(list)) {
            LogConsole.d("WifiCollector", "no update");
            return null;
        } else {
            LogConsole.d("WifiCollector", "ap list size." + list.size());
            a11.d();
            return this.FB;
        }
    }

    public void yn() {
        LogConsole.w("WifiCollector", "Stop");
        LW lw2 = this.LW;
        if (lw2 != null) {
            Vw.b().unregisterReceiver(lw2);
        }
    }
}
