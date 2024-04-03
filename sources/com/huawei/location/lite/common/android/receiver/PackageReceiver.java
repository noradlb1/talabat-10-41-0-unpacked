package com.huawei.location.lite.common.android.receiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.secure.android.common.util.SafeString;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class PackageReceiver extends SafeBroadcastReceiver {
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final String TAG = "PackageReceiver";
    private static volatile PackageReceiver instance;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f50104a = new AtomicBoolean(false);
    private List<PackageOperateCallback> callbackList = new CopyOnWriteArrayList();

    public static PackageReceiver getInstance() {
        if (instance == null) {
            synchronized (SYNC_LOCK) {
                if (instance == null) {
                    instance = new PackageReceiver();
                }
            }
        }
        return instance;
    }

    private IntentFilter getPackageFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        return intentFilter;
    }

    public void onSafeReceive(Intent intent) {
        if (intent == null) {
            LogConsole.e(TAG, "PackageReceiver receive null intent");
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        String dataString = safeIntent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            dataString = "";
        }
        String replace = SafeString.replace(dataString, "package:", "");
        if ("android.intent.action.PACKAGE_REMOVED".equals(safeIntent.getAction())) {
            LogConsole.i(TAG, "package_remove:" + replace);
            for (PackageOperateCallback next : this.callbackList) {
                if (next != null) {
                    next.onRemoved(replace);
                }
            }
        } else if ("android.intent.action.PACKAGE_ADDED".equals(safeIntent.getAction())) {
            LogConsole.i(TAG, "package_add:" + replace);
            for (PackageOperateCallback next2 : this.callbackList) {
                if (next2 != null) {
                    next2.onAdded(replace);
                }
            }
        } else if ("android.intent.action.PACKAGE_REPLACED".equals(safeIntent.getAction())) {
            LogConsole.i(TAG, "package_replace:" + replace);
            for (PackageOperateCallback next3 : this.callbackList) {
                if (next3 != null) {
                    next3.onReplaced(replace);
                }
            }
        } else {
            LogConsole.i(TAG, "action ===:" + safeIntent.getAction());
        }
    }

    public String receiveThreadName() {
        return "Loc_Package_Listener";
    }

    public void registerCallback(PackageOperateCallback packageOperateCallback) {
        if (packageOperateCallback != null) {
            this.callbackList.add(packageOperateCallback);
        }
        if (!this.f50104a.get()) {
            ContextUtil.getContext().registerReceiver(getInstance(), getPackageFilter());
            this.f50104a.set(true);
        }
    }

    public int threadExitDelayTime() {
        return 0;
    }

    public void unregisterCallback(PackageOperateCallback packageOperateCallback) {
        if (packageOperateCallback != null) {
            this.callbackList.remove(packageOperateCallback);
        }
    }
}
