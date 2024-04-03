package androidx.core.telephony;

import android.annotation.SuppressLint;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TelephonyManagerCompat {
    private static Method sGetDeviceIdMethod;
    private static Method sGetSubIdMethod;

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        @SuppressLint({"MissingPermission"})
        @Nullable
        @RequiresPermission("android.permission.READ_PHONE_STATE")
        public static String a(TelephonyManager telephonyManager, int i11) {
            return telephonyManager.getDeviceId(i11);
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        @SuppressLint({"MissingPermission"})
        @Nullable
        @RequiresPermission("android.permission.READ_PHONE_STATE")
        public static String a(TelephonyManager telephonyManager) {
            return telephonyManager.getImei();
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static int a(TelephonyManager telephonyManager) {
            return telephonyManager.getSubscriptionId();
        }
    }

    private TelephonyManagerCompat() {
    }

    @RequiresPermission("android.permission.READ_PHONE_STATE")
    @SuppressLint({"MissingPermission"})
    @Nullable
    public static String getImei(@NonNull TelephonyManager telephonyManager) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.a(telephonyManager);
        }
        int subscriptionId = getSubscriptionId(telephonyManager);
        if (subscriptionId == Integer.MAX_VALUE || subscriptionId == -1) {
            return telephonyManager.getDeviceId();
        }
        return Api23Impl.a(telephonyManager, SubscriptionManagerCompat.getSlotIndex(subscriptionId));
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static int getSubscriptionId(@NonNull TelephonyManager telephonyManager) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.a(telephonyManager);
        }
        try {
            if (sGetSubIdMethod == null) {
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubId", new Class[0]);
                sGetSubIdMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Integer num = (Integer) sGetSubIdMethod.invoke(telephonyManager, new Object[0]);
            if (num == null || num.intValue() == -1) {
                return Integer.MAX_VALUE;
            }
            return num.intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return Integer.MAX_VALUE;
        }
    }
}
