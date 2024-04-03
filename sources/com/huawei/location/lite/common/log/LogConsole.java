package com.huawei.location.lite.common.log;

import com.huawei.location.lite.common.log.logwrite.LogWriteApi;
import com.huawei.location.lite.common.util.SDKComponentType;
import java.util.List;

public class LogConsole {
    private static final yn LOG_ADAPTOR = new yn(true);
    private static boolean isDebug = false;

    private LogConsole() {
    }

    public static void d(String str, String str2) {
        if (isDebug) {
            LOG_ADAPTOR.yn(3, str, str2);
            if (SDKComponentType.getComponentType() == 100) {
                LogWriteApi.d(str, str2, (Throwable) null);
            }
        }
    }

    public static void d(String str, String str2, Throwable th2) {
        if (isDebug) {
            LOG_ADAPTOR.Vw(3, str, str2, th2);
            if (SDKComponentType.getComponentType() == 100) {
                LogWriteApi.d(str, str2, th2);
            }
        }
    }

    public static void d(String str, List<String> list, boolean z11) {
        if (isDebug) {
            LOG_ADAPTOR.yn(3, str, Vw.a(list));
        }
        if (z11) {
            Vw.b(str, Vw.d(str, list));
        }
    }

    public static void e(String str, String str2) {
        LOG_ADAPTOR.yn(6, str, str2);
        if (SDKComponentType.getComponentType() == 100) {
            LogWriteApi.e(str, str2, (Throwable) null);
        }
    }

    public static void e(String str, String str2, Throwable th2) {
        LOG_ADAPTOR.Vw(6, str, str2, th2);
        if (SDKComponentType.getComponentType() == 100) {
            LogWriteApi.e(str, str2, (Throwable) null);
        }
    }

    public static void e(String str, String str2, boolean z11) {
        LOG_ADAPTOR.yn(6, str, str2);
        if (z11) {
            Vw.b(str, Vw.c(str, str2));
        }
        if (SDKComponentType.getComponentType() == 100) {
            LogWriteApi.e(str, str2, (Throwable) null);
        }
    }

    public static void e(String str, List<String> list, boolean z11) {
        LOG_ADAPTOR.yn(6, str, Vw.a(list));
        if (z11) {
            Vw.b(str, Vw.d(str, list));
        }
    }

    public static void i(String str, String str2) {
        LOG_ADAPTOR.yn(4, str, str2);
        if (SDKComponentType.getComponentType() == 100) {
            LogWriteApi.i(str, str2, (Throwable) null);
        }
    }

    public static void i(String str, String str2, Throwable th2) {
        LOG_ADAPTOR.Vw(4, str, str2, th2);
        if (SDKComponentType.getComponentType() == 100) {
            LogWriteApi.i(str, str2, (Throwable) null);
        }
    }

    public static void i(String str, String str2, boolean z11) {
        LOG_ADAPTOR.yn(4, str, str2);
        if (z11) {
            Vw.b(str, Vw.c(str, str2));
        }
        if (SDKComponentType.getComponentType() == 100) {
            LogWriteApi.i(str, str2, (Throwable) null);
        }
    }

    public static void i(String str, List<String> list, boolean z11) {
        LOG_ADAPTOR.yn(4, str, Vw.a(list));
        if (z11) {
            Vw.b(str, Vw.d(str, list));
        }
    }

    public static void setDebug(boolean z11) {
        isDebug = z11;
    }

    public static void setProductPkg(boolean z11) {
        LOG_ADAPTOR.yn(z11);
    }

    public static void w(String str, String str2) {
        LOG_ADAPTOR.yn(5, str, str2);
        if (SDKComponentType.getComponentType() == 100) {
            LogWriteApi.w(str, str2, (Throwable) null);
        }
    }

    public static void w(String str, String str2, boolean z11) {
        LOG_ADAPTOR.yn(5, str, str2);
        if (z11) {
            Vw.b(str, Vw.c(str, str2));
        }
        if (SDKComponentType.getComponentType() == 100) {
            LogWriteApi.w(str, str2, (Throwable) null);
        }
    }

    public static void w(String str, List<String> list, boolean z11) {
        LOG_ADAPTOR.yn(5, str, Vw.a(list));
        if (z11) {
            Vw.b(str, Vw.d(str, list));
        }
    }
}
