package com.huawei.location.crowdsourcing.common.util;

import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.ReflectionUtils;
import com.huawei.location.lite.common.util.TelephonyUtil;
import java.util.LinkedList;
import java.util.List;

public class dC {

    /* renamed from: yn  reason: collision with root package name */
    private static final boolean f50050yn;

    static {
        boolean z11;
        if (ReflectionUtils.isSupportClass("android.telephony.TelephonyManager$CellInfoCallback")) {
            LogConsole.i("TelephonyService", "support CallBack");
            z11 = true;
        } else {
            LogConsole.w("TelephonyService", "not support CallBack");
            z11 = false;
        }
        f50050yn = z11;
    }

    @Nullable
    private static TelephonyManager FB(@NonNull Context context) {
        Object systemService = context.getSystemService("phone");
        if (systemService instanceof TelephonyManager) {
            return (TelephonyManager) systemService;
        }
        LogConsole.d("TelephonyService", "not get TELEPHONY_SERVICE");
        return null;
    }

    @NonNull
    public static String Vw(@NonNull Context context) {
        if (TelephonyUtil.isAirplaneModeOn()) {
            LogConsole.d("TelephonyService", "airplaneMode on, no mcc");
            return "";
        }
        TelephonyManager FB = FB(context);
        if (FB == null) {
            LogConsole.d("TelephonyService", "no TelephonyManager");
            return "";
        }
        String simOperator = FB.getPhoneType() == 2 ? (FB.getSimState() != 5 || FB.isNetworkRoaming()) ? null : FB.getSimOperator() : FB.getNetworkOperator();
        if (simOperator != null && simOperator.length() >= 3) {
            return simOperator.substring(0, 3);
        }
        LogConsole.e("TelephonyService", "mcc is Empty");
        return "";
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    @NonNull
    public static List<CellInfo> yn(@NonNull Context context) {
        TelephonyManager FB = FB(context);
        if (FB == null) {
            LogConsole.d("TelephonyService", "no TelephonyManager");
            return new LinkedList();
        }
        if (Build.VERSION.SDK_INT >= 29 && f50050yn) {
            LW.a(FB);
        }
        List<CellInfo> allCellInfo = FB.getAllCellInfo();
        if (allCellInfo != null) {
            return allCellInfo;
        }
        LogConsole.d("TelephonyService", "cell info null");
        return new LinkedList();
    }
}
