package com.huawei.location.lite.common.util;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Process;
import android.os.UserHandle;
import android.provider.Settings;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.android.receiver.ScreenStatusBroadcastReceiver;
import com.huawei.location.lite.common.log.LogConsole;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicBoolean;

public class LocationUtil {
    private static final String TAG = "LocationUtil";
    private static AtomicBoolean isRegister = new AtomicBoolean(false);
    private static volatile int locatorSDKVersion = 0;

    public static int getLocatorSDKVersion() {
        return locatorSDKVersion;
    }

    public static boolean isBlePresent(Context context) {
        if (context == null) {
            LogConsole.e(TAG, "isBlePresent Context is null");
            return false;
        }
        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        LogConsole.i(TAG, "isBlePresent isBlePresent is " + hasSystemFeature);
        return hasSystemFeature;
    }

    public static boolean isBlueBoothEnabled(Context context) {
        boolean z11 = false;
        if (context == null) {
            LogConsole.e(TAG, "isBlueBoothEnabled Context is null");
            return false;
        }
        int i11 = Settings.Global.getInt(context.getContentResolver(), "bluetooth_on", -1);
        if (i11 == 1) {
            z11 = true;
        }
        LogConsole.i(TAG, "isBlueBoothEnabled locationMode is " + i11);
        return z11;
    }

    public static boolean isLocationEnabled(Context context) {
        String str;
        if (context == null) {
            str = "isLocationEnabled Context is null";
        } else {
            try {
                int i11 = Settings.Secure.getInt(context.getContentResolver(), "location_mode");
                LogConsole.i(TAG, "isLocationEnabled locationMode is " + i11);
                return i11 == 3;
            } catch (Settings.SettingNotFoundException unused) {
                str = "isLocationEnabled SettingNotFoundException";
            }
        }
        LogConsole.e(TAG, str);
        return false;
    }

    public static boolean isScanBleEnabled(Context context) {
        boolean z11 = false;
        if (context == null) {
            LogConsole.e(TAG, "isScanBleEnabled Context is null");
            return false;
        }
        try {
            int i11 = Settings.Global.getInt(context.getContentResolver(), "ble_scan_always_enabled");
            if (i11 == 1) {
                z11 = true;
            }
            LogConsole.i(TAG, "isScanBleEnabled locationMode is " + i11);
        } catch (Settings.SettingNotFoundException unused) {
            LogConsole.e(TAG, "isScanBleEnabled SettingNotFoundException");
        }
        return z11;
    }

    public static boolean isSystemUser() {
        String str;
        try {
            UserHandle myUserHandle = Process.myUserHandle();
            Object invoke = myUserHandle.getClass().getDeclaredMethod("isSystem", new Class[0]).invoke(myUserHandle, new Object[0]);
            if (invoke instanceof Boolean) {
                return ((Boolean) invoke).booleanValue();
            }
            return false;
        } catch (NoSuchMethodException unused) {
            str = "NoSuchMethodException";
            LogConsole.e(TAG, str);
            return false;
        } catch (IllegalAccessException unused2) {
            str = "IllegalAccessException";
            LogConsole.e(TAG, str);
            return false;
        } catch (InvocationTargetException unused3) {
            str = "InvocationTargetException";
            LogConsole.e(TAG, str);
            return false;
        } catch (Exception unused4) {
            str = "unknow exception";
            LogConsole.e(TAG, str);
            return false;
        }
    }

    public static synchronized void registerScreenStatusBroadcast() {
        synchronized (LocationUtil.class) {
            LogConsole.i(TAG, "registerScreenStatusBroadcast start");
            if (isRegister.get()) {
                LogConsole.i(TAG, "registerScreenStatusBroadcast is Register");
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            ContextUtil.getContext().registerReceiver(new ScreenStatusBroadcastReceiver(), intentFilter);
            LogConsole.i(TAG, "registerScreenStatusBroadcast end");
            isRegister.set(true);
        }
    }

    public static void setLocatorSDKVersion(int i11) {
        locatorSDKVersion = i11;
    }
}
