package com.huawei.hms.analytics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import java.io.File;
import java.util.Map;
import net.bytebuddy.utility.JavaConstant;

@SuppressLint({"ApplySharedPref"})
public final class dv {
    private static SharedPreferences hij(Context context, String str) {
        return context.getSharedPreferences(lmn(context, str), 0);
    }

    public static boolean ijk(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            HiLog.w("SharedPreToolsKit", "deleteSPFile(): spName is empty,or context is null");
            return false;
        }
        File filesDir = context.getFilesDir();
        File file = new File(filesDir, "../shared_prefs/" + str + ".xml");
        return file.exists() && file.delete();
    }

    public static long ikl(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            HiLog.w("SharedPreToolsKit", "deleteSPFile(): spName is empty,or context is null");
            return -1;
        }
        File filesDir = context.getFilesDir();
        return new File(filesDir, "../shared_prefs/" + str + ".xml").length();
    }

    public static int klm(Context context, String str, String str2, int i11) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            HiLog.w("SharedPreToolsKit", "context is null or spName empty or spkey is empty");
            return i11;
        }
        SharedPreferences hij = hij(context, str);
        return hij != null ? hij.getInt(str2, i11) : i11;
    }

    public static long klm(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            HiLog.e("SharedPreToolsKit", HiLog.ErrorCode.PE001, "context is null or spName empty or spkey is empty");
            return -1;
        }
        SharedPreferences hij = hij(context, str);
        if (hij != null) {
            return hij.getLong(str2, -1);
        }
        return -1;
    }

    public static String klm(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            HiLog.e("SharedPreToolsKit", HiLog.ErrorCode.PE001, "context is null or spName empty or spkey is empty");
            return str3;
        }
        SharedPreferences hij = hij(context, str);
        return hij != null ? hij.getString(str2, str3) : str3;
    }

    public static Map<String, ?> klm(Context context, String str) {
        return hij(context, str).getAll();
    }

    public static boolean klm(Context context, String str, String str2, boolean z11) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            HiLog.e("SharedPreToolsKit", HiLog.ErrorCode.PE001, "context is null or spName empty or spkey is empty");
            return z11;
        }
        SharedPreferences hij = hij(context, str);
        return hij != null ? hij.getBoolean(str2, z11) : z11;
    }

    public static String lmn(Context context, String str) {
        String packageName = context.getPackageName();
        return "openness_" + str + JavaConstant.Dynamic.DEFAULT_NAME + packageName;
    }

    public static void lmn(Context context, String str, String str2, int i11) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            HiLog.w("SharedPreToolsKit", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences hij = hij(context, str);
        if (hij != null) {
            SharedPreferences.Editor edit = hij.edit();
            edit.putInt(str2, i11);
            edit.commit();
        }
    }

    public static void lmn(Context context, String str, String str2, long j11) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            HiLog.e("SharedPreToolsKit", HiLog.ErrorCode.PE001, "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences hij = hij(context, str);
        if (hij != null) {
            SharedPreferences.Editor edit = hij.edit();
            edit.putLong(str2, j11);
            edit.commit();
        }
    }

    public static void lmn(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            HiLog.e("SharedPreToolsKit", HiLog.ErrorCode.PE001, "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences hij = hij(context, str);
        if (hij != null) {
            SharedPreferences.Editor edit = hij.edit();
            edit.putString(str2, str3);
            edit.commit();
        }
    }

    public static void lmn(Context context, String str, String str2, boolean z11) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            HiLog.e("SharedPreToolsKit", HiLog.ErrorCode.PE001, "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences hij = hij(context, str);
        if (hij != null) {
            SharedPreferences.Editor edit = hij.edit();
            edit.putBoolean(str2, z11);
            edit.commit();
        }
    }

    public static void lmn(Context context, String str, Object... objArr) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "context is null or spName empty";
        } else if (objArr.length == 0 || objArr.length % 2 == 1) {
            str2 = "putInfos: objects parameter error";
        } else {
            SharedPreferences hij = hij(context, str);
            if (hij != null) {
                SharedPreferences.Editor edit = hij.edit();
                int i11 = 0;
                while (i11 < objArr.length) {
                    String str3 = objArr[i11];
                    int i12 = i11 + 1;
                    if (str3 instanceof String) {
                        String str4 = objArr[i12];
                        if (str4 instanceof String) {
                            edit.putString(str3, str4);
                        } else if (str4 instanceof Integer) {
                            edit.putInt(str3, ((Integer) str4).intValue());
                        } else if (str4 instanceof Long) {
                            edit.putLong(str3, ((Long) str4).longValue());
                        } else if (str4 instanceof Boolean) {
                            edit.putBoolean(str3, ((Boolean) str4).booleanValue());
                        }
                    }
                    i11 = i12 + 1;
                }
                edit.commit();
                return;
            }
            return;
        }
        HiLog.w("SharedPreToolsKit", str2);
    }

    public static void lmn(Context context, String str, String... strArr) {
        if (context == null || TextUtils.isEmpty(str)) {
            HiLog.w("SharedPreToolsKit", "clearData(): parameter error.context,spname");
            return;
        }
        SharedPreferences hij = hij(context, str);
        if (hij != null) {
            SharedPreferences.Editor edit = hij.edit();
            if (strArr.length == 0) {
                edit.clear();
                edit.commit();
                return;
            }
            boolean z11 = false;
            for (String str2 : strArr) {
                if (hij.contains(str2)) {
                    edit.remove(str2);
                    z11 = true;
                }
            }
            if (z11) {
                edit.commit();
            }
        }
    }

    public static boolean lmn(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            HiLog.e("SharedPreToolsKit", HiLog.ErrorCode.PE001, "context is null or spName empty or spkey is empty");
            return false;
        }
        SharedPreferences hij = hij(context, str);
        if (hij != null) {
            return hij.contains(str2);
        }
        return false;
    }
}
