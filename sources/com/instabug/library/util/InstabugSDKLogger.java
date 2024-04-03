package com.instabug.library.util;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.logging.disklogs.f;
import com.instabug.library.model.g;

public final class InstabugSDKLogger {
    private static final String LOG_TAG = "IB-";
    private static volatile f instabugSDKDiskLogger;

    private InstabugSDKLogger() {
    }

    public static void d(@NonNull String str, @NonNull String str2) {
        String str3;
        if (str2 != null) {
            try {
                if (InstabugCore.canPrintLog(2) && str2.length() > 4000) {
                    int length = str2.length() / 4000;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("logMessage length = ");
                    sb2.append(str2.length());
                    sb2.append(" divided to ");
                    int i11 = length + 1;
                    sb2.append(i11);
                    sb2.append(" chunks");
                    int i12 = 0;
                    while (i12 <= length) {
                        int i13 = i12 + 1;
                        int i14 = i13 * 4000;
                        if (i14 >= str2.length()) {
                            str3 = str2.substring(i12 * 4000);
                        } else {
                            str3 = str2.substring(i12 * 4000, i14);
                        }
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("chunk ");
                        sb3.append(i13);
                        sb3.append(" of ");
                        sb3.append(i11);
                        sb3.append(":\n");
                        sb3.append(str3);
                        i12 = i13;
                    }
                }
                p(str, str2);
            } catch (Exception e11) {
                e("IB-InstabugSDKLogger", e11.getMessage(), e11);
            }
        }
    }

    public static void e(@NonNull String str, @NonNull String str2) {
        if (str2 != null) {
            try {
                if (InstabugCore.canPrintLog(1)) {
                    Log.e(str, str2);
                }
                p(str, str2);
            } catch (Exception e11) {
                Log.e("IBG-Core", e11.getMessage(), e11);
            }
        }
    }

    public static void i(@NonNull String str, @NonNull String str2) {
        if (str2 != null) {
            try {
                if (InstabugCore.canPrintLog(2)) {
                    Log.i(str, str2);
                }
                p(str, str2);
            } catch (Exception e11) {
                e("IB-InstabugSDKLogger", e11.getMessage(), e11);
            }
        }
    }

    public static void initLogger(@NonNull Context context) {
        if (instabugSDKDiskLogger == null) {
            instabugSDKDiskLogger = new f(context);
        }
    }

    public static void logEndSession(long j11) {
        try {
            if (instabugSDKDiskLogger != null) {
                instabugSDKDiskLogger.a(j11);
            }
        } catch (Exception e11) {
            Log.e("IBG-Core", e11.getMessage(), e11);
        }
    }

    public static void logSessionDetails(g gVar) {
        try {
            if (instabugSDKDiskLogger != null) {
                instabugSDKDiskLogger.a(gVar);
            }
        } catch (Exception e11) {
            Log.e("IBG-Core", e11.getMessage(), e11);
        }
    }

    public static void onDiskLoggingLevelChanged(int i11) {
        if (instabugSDKDiskLogger != null) {
            instabugSDKDiskLogger.a(i11);
        }
    }

    public static void p(@NonNull String str, @NonNull String str2) {
        if (str2 != null && instabugSDKDiskLogger != null) {
            instabugSDKDiskLogger.a(str, str2, Thread.currentThread().getName(), System.currentTimeMillis());
        }
    }

    public static void privateVerbose(String str, String str2) {
        if (instabugSDKDiskLogger != null) {
            instabugSDKDiskLogger.b(str, str2, Thread.currentThread().getName(), TimeUtils.currentTimeMillis());
        }
    }

    public static void v(@NonNull String str, @NonNull String str2) {
        String str3;
        if (str2 != null) {
            try {
                if (InstabugCore.canPrintLog(3) && str2.length() > 4000) {
                    int length = str2.length() / 4000;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("logMessage length = ");
                    sb2.append(str2.length());
                    sb2.append(" divided to ");
                    int i11 = length + 1;
                    sb2.append(i11);
                    sb2.append(" chunks");
                    int i12 = 0;
                    while (i12 <= length) {
                        int i13 = i12 + 1;
                        int i14 = i13 * 4000;
                        if (i14 >= str2.length()) {
                            str3 = str2.substring(i12 * 4000);
                        } else {
                            str3 = str2.substring(i12 * 4000, i14);
                        }
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("chunk ");
                        sb3.append(i13);
                        sb3.append(" of ");
                        sb3.append(i11);
                        sb3.append(":\n");
                        sb3.append(str3);
                        i12 = i13;
                    }
                }
                if (instabugSDKDiskLogger != null) {
                    instabugSDKDiskLogger.b(str, str2, Thread.currentThread().getName(), System.currentTimeMillis());
                }
            } catch (Exception e11) {
                e("IB-InstabugSDKLogger", e11.getMessage(), e11);
            }
        }
    }

    public static void w(@NonNull String str, @NonNull String str2) {
        if (str2 != null) {
            try {
                if (InstabugCore.canPrintLog(1)) {
                    Log.w(str, str2);
                }
                p(str, str2);
            } catch (Exception e11) {
                e("IB-InstabugSDKLogger", e11.getMessage(), e11);
            }
        }
    }

    public static void wtf(@NonNull String str, @NonNull String str2) {
        if (str2 != null) {
            try {
                if (InstabugCore.canPrintLog(1)) {
                    Log.wtf(str, str2);
                }
                p(str, str2);
            } catch (Exception e11) {
                Log.e("IBG-Core", e11.getMessage(), e11);
            }
        }
    }

    public static void e(@NonNull String str, @NonNull String str2, @NonNull Throwable th2) {
        if (str2 != null) {
            try {
                if (InstabugCore.canPrintLog(1)) {
                    Log.e(str, str2, th2);
                }
                p(str, str2);
            } catch (Exception e11) {
                Log.e("IBG-Core", e11.getMessage(), e11);
            }
        }
    }

    public static void wtf(@NonNull String str, @NonNull String str2, @NonNull Throwable th2) {
        if (str2 != null) {
            try {
                if (InstabugCore.canPrintLog(1)) {
                    Log.wtf(str, str2, th2);
                }
                p(str, str2);
            } catch (Exception e11) {
                Log.e("IBG-Core", e11.getMessage(), e11);
            }
        }
    }
}
