package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.PowerManager;

public class PowerUtils {
    private static final String TAG = "PowerUtils";

    public static final class PowerMode {
        static final int POWER_MODE_DEFAULT_RETURN_VALUE = 0;
        static final int POWER_SAVER_MODE = 4;
        static final String SMART_MODE_STATUS = "SmartModeStatus";
    }

    public static boolean isAppIdleMode(Context context) {
        if (context != null) {
            String packageName = context.getPackageName();
            Object systemService = context.getSystemService("usagestats");
            if (systemService instanceof UsageStatsManager) {
                UsageStatsManager usageStatsManager = (UsageStatsManager) systemService;
                if (usageStatsManager != null) {
                    return usageStatsManager.isAppInactive(packageName);
                }
                Logger.i(TAG, "isAppIdleMode statsManager is null!");
            }
            return false;
        }
        Logger.i(TAG, "isAppIdleMode Context is null!");
        return false;
    }

    public static boolean isDozeIdleMode(Context context) {
        PowerManager powerManager;
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            if (systemService instanceof PowerManager) {
                powerManager = (PowerManager) systemService;
            } else {
                powerManager = null;
            }
            if (powerManager != null) {
                try {
                    return powerManager.isDeviceIdleMode();
                } catch (RuntimeException e11) {
                    Logger.e(TAG, "dealType rethrowFromSystemServer:", (Throwable) e11);
                    return false;
                }
            } else {
                Logger.i(TAG, "isDozeIdleMode powerManager is null!");
                return false;
            }
        } else {
            Logger.i(TAG, "isDozeIdleMode Context is null!");
            return false;
        }
    }

    public static boolean isInteractive(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            if (systemService instanceof PowerManager) {
                try {
                    return ((PowerManager) systemService).isInteractive();
                } catch (RuntimeException e11) {
                    Logger.i(TAG, "getActiveNetworkInfo failed, exception:" + e11.getClass().getSimpleName() + e11.getMessage());
                }
            }
        }
        return false;
    }

    public static boolean isWhilteList(Context context) {
        PowerManager powerManager;
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            if (systemService instanceof PowerManager) {
                powerManager = (PowerManager) systemService;
            } else {
                powerManager = null;
            }
            String packageName = context.getPackageName();
            if (powerManager != null) {
                try {
                    return powerManager.isIgnoringBatteryOptimizations(packageName);
                } catch (RuntimeException e11) {
                    Logger.e(TAG, "dealType rethrowFromSystemServer:", (Throwable) e11);
                }
            }
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static int readDataSaverMode(Context context) {
        ConnectivityManager connectivityManager;
        if (context != null) {
            Object systemService = context.getSystemService("connectivity");
            if (systemService instanceof ConnectivityManager) {
                connectivityManager = (ConnectivityManager) systemService;
            } else {
                connectivityManager = null;
            }
            if (connectivityManager != null) {
                int i11 = Build.VERSION.SDK_INT;
                if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    return 0;
                }
                if (!connectivityManager.isActiveNetworkMetered()) {
                    Logger.v(TAG, "ConnectType is not Mobile Network!");
                    return 0;
                } else if (i11 >= 24) {
                    return connectivityManager.getRestrictBackgroundStatus();
                } else {
                    return 0;
                }
            } else {
                Logger.i(TAG, "readDataSaverMode Context is null!");
                return 0;
            }
        } else {
            Logger.i(TAG, "readDataSaverMode manager is null!");
            return 0;
        }
    }

    public static int readPowerSaverMode(Context context) {
        PowerManager powerManager;
        if (context != null) {
            int systemInt = SettingUtil.getSystemInt(context.getContentResolver(), "SmartModeStatus", 0);
            if (systemInt == 0) {
                Object systemService = ContextCompat.getSystemService(context, "power");
                if (systemService instanceof PowerManager) {
                    powerManager = (PowerManager) systemService;
                } else {
                    powerManager = null;
                }
                if (powerManager != null) {
                    try {
                        if (powerManager.isPowerSaveMode()) {
                            return 4;
                        }
                        return 0;
                    } catch (RuntimeException e11) {
                        Logger.e(TAG, "dealType rethrowFromSystemServer:", (Throwable) e11);
                    }
                }
            }
            return systemInt;
        }
        Logger.i(TAG, "readPowerSaverMode Context is null!");
        return 0;
    }
}
