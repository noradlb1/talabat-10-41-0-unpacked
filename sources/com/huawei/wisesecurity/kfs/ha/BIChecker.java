package com.huawei.wisesecurity.kfs.ha;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.wisesecurity.kfs.log.KfsLog;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

public class BIChecker {
    public static int IS_OOBE = -1;
    public static final String TAG = "BIChecker";
    public boolean isOobeCheck = true;
    public final KfsLog kfsLog;

    public BIChecker(KfsLog kfsLog2) {
        this.kfsLog = kfsLog2;
    }

    private String getLocalCountry() {
        return Locale.getDefault().getCountry();
    }

    private String getProductLocal() {
        return getSystemProperties("ro.product.locale", "");
    }

    private String getProductRegion() {
        return getSystemProperties("ro.product.locale.region", "");
    }

    private String getSystemProperties(String str, String str2) {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            return (String) cls2.getDeclaredMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{str, str2});
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            KfsLog kfsLog2 = this.kfsLog;
            kfsLog2.e(TAG, "An exception occurred while reading: getSystemProperties:" + str);
            return str2;
        }
    }

    private boolean isChinaROM() {
        String productRegion = getProductRegion();
        if (!TextUtils.isEmpty(productRegion)) {
            return "cn".equalsIgnoreCase(productRegion);
        }
        String productLocal = getProductLocal();
        if (!TextUtils.isEmpty(productLocal)) {
            return productLocal.toLowerCase(Locale.US).contains("cn");
        }
        String localCountry = getLocalCountry();
        if (!TextUtils.isEmpty(localCountry)) {
            return "cn".equalsIgnoreCase(localCountry);
        }
        return false;
    }

    private boolean isHuawei() {
        return "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static void setIsOobe(int i11) {
        IS_OOBE = i11;
    }

    public boolean hasError(Context context) {
        KfsLog kfsLog2;
        String str;
        if (!this.isOobeCheck) {
            kfsLog2 = this.kfsLog;
            str = "oobe check is off, report is on";
        } else if (!isHuawei()) {
            kfsLog2 = this.kfsLog;
            str = "not huawei device, report is on";
        } else if (context == null) {
            return true;
        } else {
            if (isChinaROM()) {
                return IS_OOBE == 0;
            }
            this.kfsLog.i(TAG, "not ChinaROM");
            try {
                setIsOobe(Settings.Secure.getInt(context.getContentResolver(), "hw_app_analytics_state"));
                KfsLog kfsLog3 = this.kfsLog;
                kfsLog3.i(TAG, "hw_app_analytics_state value is " + IS_OOBE);
                return IS_OOBE != 1;
            } catch (Settings.SettingNotFoundException unused) {
                this.kfsLog.i(TAG, "Get OOBE failed");
                return true;
            }
        }
        kfsLog2.i(TAG, str);
        return false;
    }

    public void setOobeCheckOff() {
        this.isOobeCheck = false;
    }

    public void setOobeCheckOn() {
        this.isOobeCheck = true;
    }
}
