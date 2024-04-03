package androidx.core.telephony;

import android.os.Build;
import android.telephony.SubscriptionManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(22)
public class SubscriptionManagerCompat {
    private static Method sGetSlotIndexMethod;

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static int a(int i11) {
            return SubscriptionManager.getSlotIndex(i11);
        }
    }

    private SubscriptionManagerCompat() {
    }

    public static int getSlotIndex(int i11) {
        if (i11 == -1) {
            return -1;
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 29) {
            return Api29Impl.a(i11);
        }
        try {
            if (sGetSlotIndexMethod == null) {
                Class<SubscriptionManager> cls = SubscriptionManager.class;
                if (i12 >= 26) {
                    sGetSlotIndexMethod = cls.getDeclaredMethod("getSlotIndex", new Class[]{Integer.TYPE});
                } else {
                    sGetSlotIndexMethod = cls.getDeclaredMethod("getSlotId", new Class[]{Integer.TYPE});
                }
                sGetSlotIndexMethod.setAccessible(true);
            }
            Integer num = (Integer) sGetSlotIndexMethod.invoke((Object) null, new Object[]{Integer.valueOf(i11)});
            if (num != null) {
                return num.intValue();
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return -1;
    }
}
