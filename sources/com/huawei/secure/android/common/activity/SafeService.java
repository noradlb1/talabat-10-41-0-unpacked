package com.huawei.secure.android.common.activity;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import com.huawei.secure.android.common.intent.IntentUtils;
import com.huawei.secure.android.common.intent.SafeIntent;

public abstract class SafeService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33678a = "SafeService";

    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i11) {
        try {
            return super.bindService(intent, serviceConnection, i11);
        } catch (Exception e11) {
            String str = f33678a;
            a.a(str, "bindService: " + e11.getMessage(), true);
            return false;
        }
    }

    public void onCreate() {
        try {
            super.onCreate();
        } catch (Exception e11) {
            String str = f33678a;
            a.a(str, "onCreate: " + e11.getMessage(), true);
        }
    }

    public void onDestroy() {
        try {
            super.onDestroy();
        } catch (Exception e11) {
            String str = f33678a;
            a.a(str, "onDestroy: " + e11.getMessage(), true);
        }
    }

    public void onRebind(Intent intent) {
        try {
            super.onRebind(new SafeIntent(intent));
        } catch (Exception e11) {
            String str = f33678a;
            a.a(str, "onRebind: " + e11.getMessage(), true);
        }
    }

    @Deprecated
    public void onStart(Intent intent, int i11) {
        if (IntentUtils.hasIntentBomb(intent)) {
            a.a(f33678a, "onStart : hasIntentBomb");
        }
        try {
            super.onStart(new SafeIntent(intent), i11);
        } catch (Exception e11) {
            String str = f33678a;
            a.a(str, "onStart: " + e11.getMessage(), true);
        }
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        if (IntentUtils.hasIntentBomb(intent)) {
            a.a(f33678a, "onStartCommand : hasIntentBomb");
        }
        try {
            return super.onStartCommand(new SafeIntent(intent), i11, i12);
        } catch (Exception e11) {
            String str = f33678a;
            a.a(str, "onStartCommand: " + e11.getMessage(), true);
            return 0;
        }
    }

    public boolean onUnbind(Intent intent) {
        try {
            return super.onUnbind(new SafeIntent(intent));
        } catch (Exception e11) {
            String str = f33678a;
            a.a(str, "onUnbind: " + e11.getMessage(), true);
            return false;
        }
    }

    public void startActivities(Intent[] intentArr) {
        try {
            super.startActivities(intentArr);
        } catch (Exception e11) {
            String str = f33678a;
            a.a(str, "startActivities: " + e11.getMessage(), true);
        }
    }

    public void startActivity(Intent intent) {
        try {
            super.startActivity(new SafeIntent(intent));
        } catch (Exception e11) {
            String str = f33678a;
            a.a(str, "startActivity: " + e11.getMessage(), true);
        }
    }

    public ComponentName startForegroundService(Intent intent) {
        try {
            return super.startForegroundService(new SafeIntent(intent));
        } catch (Exception e11) {
            String str = f33678a;
            a.a(str, "startForegroundService: " + e11.getMessage(), true);
            return null;
        }
    }

    public ComponentName startService(Intent intent) {
        try {
            return super.startService(intent);
        } catch (Exception e11) {
            String str = f33678a;
            a.a(str, "startService: " + e11.getMessage(), true);
            return null;
        }
    }

    public boolean stopService(Intent intent) {
        try {
            return super.stopService(intent);
        } catch (Exception e11) {
            String str = f33678a;
            a.a(str, "stopService: " + e11.getMessage(), true);
            return false;
        }
    }

    public void unbindService(ServiceConnection serviceConnection) {
        try {
            super.unbindService(serviceConnection);
        } catch (Exception e11) {
            String str = f33678a;
            a.a(str, "unbindService: " + e11.getMessage(), true);
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            super.unregisterReceiver(broadcastReceiver);
        } catch (Exception e11) {
            String str = f33678a;
            a.a(str, "unregisterReceiver: " + e11.getMessage(), true);
        }
    }
}
