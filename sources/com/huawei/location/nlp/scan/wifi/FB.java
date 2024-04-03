package com.huawei.location.nlp.scan.wifi;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.PermissionUtil;
import com.huawei.secure.android.common.intent.SafeBroadcastReceiver;
import java.util.List;

public class FB {
    private yn FB;
    private SafeBroadcastReceiver LW;
    private Context Vw;
    /* access modifiers changed from: private */
    public boolean dC = true;

    /* renamed from: yn  reason: collision with root package name */
    private WifiManager f50202yn;

    public interface yn {
        void onFail(int i11, String str);

        void yn(List<ScanResult> list);
    }

    public FB() {
        Context context = ContextUtil.getContext();
        this.Vw = context;
        Object systemService = context.getApplicationContext().getSystemService("wifi");
        if (systemService instanceof WifiManager) {
            this.f50202yn = (WifiManager) systemService;
            LogConsole.i("WifiScanManager", "WifiScanManager init");
        }
    }

    public static void a(FB fb2, Intent intent) {
        String str;
        String str2;
        if (fb2.FB == null) {
            str = "onReceiveWifi, wifiScanLister is null";
        } else {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || !"android.net.wifi.SCAN_RESULTS".equals(action)) {
                str = "onReceiveWifi, action is invalid";
            } else {
                fb2.dC = true;
                WifiManager wifiManager = fb2.f50202yn;
                if (wifiManager == null) {
                    str2 = "onReceiveWifi, WiFiManager is null";
                } else {
                    try {
                        List<ScanResult> scanResults = wifiManager.getScanResults();
                        if (scanResults.isEmpty()) {
                            str2 = "onReceiveWifi, wifi scan result is null";
                        } else {
                            fb2.FB.yn(scanResults);
                            return;
                        }
                    } catch (Exception unused) {
                        str2 = "onReceiveWifi, remoteException";
                    }
                }
                LogConsole.e("WifiScanManager", str2);
                fb2.FB.onFail(10000, com.huawei.location.nlp.constant.yn.yn(10000));
                return;
            }
        }
        LogConsole.e("WifiScanManager", str);
    }

    public void yn() {
        SafeBroadcastReceiver safeBroadcastReceiver;
        Context context = this.Vw;
        if (context != null && (safeBroadcastReceiver = this.LW) != null) {
            try {
                context.unregisterReceiver(safeBroadcastReceiver);
            } catch (Exception unused) {
                LogConsole.e("WifiScanManager", "unregisterReceiver error");
            }
            this.LW = null;
        }
    }

    public void yn(@NonNull yn ynVar) {
        if (!PermissionUtil.checkSelfPermission(this.Vw, "android.permission.ACCESS_WIFI_STATE") || !PermissionUtil.checkSelfPermission(this.Vw, "android.permission.CHANGE_WIFI_STATE")) {
            ynVar.onFail(10000, com.huawei.location.nlp.constant.yn.yn(10000));
            return;
        }
        this.FB = ynVar;
        if (this.LW == null) {
            LogConsole.i("WifiScanManager", "registeredWifiBroadcast");
            this.LW = new Vw(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            this.Vw.registerReceiver(this.LW, intentFilter);
        }
        WifiManager wifiManager = this.f50202yn;
        if (wifiManager == null) {
            LogConsole.e("WifiScanManager", "WifiScanManager is null");
            ynVar.onFail(10000, com.huawei.location.nlp.constant.yn.yn(10000));
            return;
        }
        try {
            wifiManager.startScan();
            this.dC = false;
        } catch (Exception unused) {
            LogConsole.e("WifiScanManager", "WifiScanManager throw Exception");
            ynVar.onFail(10000, com.huawei.location.nlp.constant.yn.yn(10000));
        }
    }
}
