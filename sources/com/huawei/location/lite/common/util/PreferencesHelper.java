package com.huawei.location.lite.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import java.util.HashMap;
import java.util.Map;

public class PreferencesHelper {
    private static final boolean DEFAULT_BOOLEAN_VALUE = false;
    private static final int DEFAULT_INT_VALUE = -1;
    private static final long DEFAULT_LONG_VALUE = -1;
    private static final String DEFAULT_STRING_VALUE = "";
    private static final Map<String, ?> DEF_MAP_VALUE = new HashMap();
    private static final String TAG = "LocationPreferences";
    private SharedPreferences sharedPreferences;

    public PreferencesHelper(String str) {
        this(str, 0);
    }

    public PreferencesHelper(String str, int i11) {
        Context hMSContext = SDKComponentType.getComponentType() == 200 ? ContextUtil.getHMSContext() : ContextUtil.getContext();
        try {
            this.sharedPreferences = (Build.VERSION.SDK_INT >= 24 ? hMSContext.createDeviceProtectedStorageContext() : hMSContext).getSharedPreferences(str, i11);
        } catch (Exception e11) {
            LogConsole.e(TAG, "init getSharedPreferences fail:" + e11.getMessage());
        }
    }

    public Map<String, ?> getAll() {
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        if (sharedPreferences2 == null) {
            return DEF_MAP_VALUE;
        }
        try {
            return sharedPreferences2.getAll();
        } catch (Exception unused) {
            LogConsole.e(TAG, "getAll fail", true);
            return DEF_MAP_VALUE;
        }
    }

    public boolean getBoolean(String str) {
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        if (sharedPreferences2 == null) {
            return false;
        }
        try {
            return sharedPreferences2.getBoolean(str, false);
        } catch (Exception unused) {
            LogConsole.e(TAG, "getBoolean fail");
            return false;
        }
    }

    public boolean getBoolean(String str, boolean z11) {
        SharedPreferences sharedPreferences2;
        if (TextUtils.isEmpty(str) || (sharedPreferences2 = this.sharedPreferences) == null) {
            return z11;
        }
        try {
            return sharedPreferences2.getBoolean(str, z11);
        } catch (Exception unused) {
            LogConsole.e(TAG, "getBoolean fail", true);
            return z11;
        }
    }

    public int getInt(String str) {
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        if (sharedPreferences2 == null) {
            return -1;
        }
        try {
            return sharedPreferences2.getInt(str, -1);
        } catch (Exception unused) {
            LogConsole.e(TAG, "getInt fail");
            return -1;
        }
    }

    public int getInt(String str, int i11) {
        SharedPreferences sharedPreferences2;
        if (TextUtils.isEmpty(str) || (sharedPreferences2 = this.sharedPreferences) == null) {
            return i11;
        }
        try {
            return sharedPreferences2.getInt(str, i11);
        } catch (Exception unused) {
            LogConsole.e(TAG, "getLong fail", true);
            return i11;
        }
    }

    public long getLong(String str) {
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        if (sharedPreferences2 == null) {
            return -1;
        }
        try {
            return sharedPreferences2.getLong(str, -1);
        } catch (Exception unused) {
            LogConsole.e(TAG, "getLong fail");
            return -1;
        }
    }

    public String getString(String str) {
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        if (sharedPreferences2 == null) {
            return "";
        }
        try {
            return sharedPreferences2.getString(str, "");
        } catch (Exception unused) {
            LogConsole.e(TAG, "getString fail");
            return "";
        }
    }

    public boolean remove(String str) {
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        if (sharedPreferences2 == null) {
            return false;
        }
        try {
            return sharedPreferences2.edit().remove(str).commit();
        } catch (Exception unused) {
            LogConsole.e(TAG, "remove fail");
            return false;
        }
    }

    public boolean removeString(String str) {
        if (this.sharedPreferences == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            SharedPreferences.Editor edit = this.sharedPreferences.edit();
            if (edit != null) {
                return edit.remove(str).commit();
            }
        } catch (Exception unused) {
            LogConsole.e(TAG, "removeString fail", true);
        }
        return false;
    }

    public boolean saveBoolean(String str, boolean z11) {
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        if (sharedPreferences2 == null) {
            return false;
        }
        try {
            SharedPreferences.Editor edit = sharedPreferences2.edit();
            if (edit != null) {
                return edit.putBoolean(str, z11).commit();
            }
        } catch (Exception unused) {
            LogConsole.e(TAG, "saveBoolean fail", true);
        }
        return false;
    }

    public boolean saveInt(String str, int i11) {
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        if (sharedPreferences2 == null) {
            return false;
        }
        try {
            return sharedPreferences2.edit().putInt(str, i11).commit();
        } catch (Exception unused) {
            LogConsole.e(TAG, "setInt fail");
            return false;
        }
    }

    public boolean saveLong(String str, long j11) {
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        if (sharedPreferences2 == null) {
            return false;
        }
        try {
            return sharedPreferences2.edit().putLong(str, j11).commit();
        } catch (Exception unused) {
            LogConsole.e(TAG, "saveLong fail");
            return false;
        }
    }

    public boolean saveString(String str, String str2) {
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        if (sharedPreferences2 == null) {
            return false;
        }
        try {
            SharedPreferences.Editor edit = sharedPreferences2.edit();
            if (edit != null) {
                edit.putString(str, str2);
                return edit.commit();
            }
        } catch (Exception unused) {
            LogConsole.e(TAG, "saveString fail");
        }
        return false;
    }
}
