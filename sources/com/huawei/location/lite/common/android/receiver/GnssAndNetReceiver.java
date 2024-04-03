package com.huawei.location.lite.common.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.secure.android.common.intent.SafeIntent;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class GnssAndNetReceiver {
    private static final String TAG = "GnssAndNetReceiver";
    private SafeBroadcastReceiver gnssReceiver;
    /* access modifiers changed from: private */
    public boolean isFirstReceive = true;
    private AtomicInteger networkCnt;
    private SafeBroadcastReceiver networkReceiver;

    public GnssAndNetReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.location.MODE_CHANGED");
        this.gnssReceiver = new SafeBroadcastReceiver() {
            public void onSafeReceive(Intent intent) {
                if (TextUtils.equals(new SafeIntent(intent).getAction(), "android.location.MODE_CHANGED")) {
                    GnssAndNetReceiver.this.notifyListeners();
                }
            }

            public String receiveThreadName() {
                return "Loc-Receive-GNSS";
            }
        };
        ContextUtil.getContext().registerReceiver(this.gnssReceiver, intentFilter);
        LogConsole.i(TAG, "register gnss receiver ");
    }

    private void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            ContextUtil.getContext().unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException e11) {
            LogConsole.e(TAG, e11.getMessage());
        }
    }

    public abstract void notifyListeners();

    public void registerNetworkObserve() {
        if (this.networkCnt == null) {
            this.networkCnt = new AtomicInteger(0);
        }
        this.networkCnt.incrementAndGet();
        LogConsole.d(TAG, "network observe cnt incrementAndGet:" + this.networkCnt.get());
        if (this.networkReceiver == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            this.networkReceiver = new SafeBroadcastReceiver() {
                public void onSafeReceive(Intent intent) {
                    if (!TextUtils.equals(new SafeIntent(intent).getAction(), ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION)) {
                        return;
                    }
                    if (GnssAndNetReceiver.this.isFirstReceive) {
                        boolean unused = GnssAndNetReceiver.this.isFirstReceive = false;
                    } else {
                        GnssAndNetReceiver.this.notifyListeners();
                    }
                }

                public String receiveThreadName() {
                    return "Loc-Receive-Network";
                }
            };
            ContextUtil.getContext().registerReceiver(this.networkReceiver, intentFilter);
            LogConsole.i(TAG, "register network receiver");
        }
    }

    public void unRegisterAllObserve() {
        SafeBroadcastReceiver safeBroadcastReceiver = this.networkReceiver;
        if (safeBroadcastReceiver != null) {
            unregisterReceiver(safeBroadcastReceiver);
            this.networkReceiver = null;
            LogConsole.i(TAG, "unregister network receiver");
        }
        SafeBroadcastReceiver safeBroadcastReceiver2 = this.gnssReceiver;
        if (safeBroadcastReceiver2 != null) {
            unregisterReceiver(safeBroadcastReceiver2);
            this.gnssReceiver = null;
            LogConsole.i(TAG, "unregister gnss receiver");
        }
    }

    public void unRegisterNetworkObserve() {
        AtomicInteger atomicInteger = this.networkCnt;
        if (atomicInteger != null && this.networkReceiver != null) {
            atomicInteger.decrementAndGet();
            LogConsole.d(TAG, "network observe cnt decrementAndGet:" + this.networkCnt.get());
            if (this.networkCnt.get() <= 0) {
                unregisterReceiver(this.networkReceiver);
                this.isFirstReceive = true;
                this.networkReceiver = null;
                this.networkCnt = null;
                LogConsole.i(TAG, "unregister network receiver");
            }
        }
    }
}
