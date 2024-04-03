package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.work.Logger;

public class PackageManagerHelper {
    private static final String TAG = Logger.tagWithPrefix("PackageManagerHelper");

    private PackageManagerHelper() {
    }

    public static boolean isComponentExplicitlyEnabled(Context context, Class<?> cls) {
        return isComponentExplicitlyEnabled(context, cls.getName());
    }

    public static void setComponentEnabled(@NonNull Context context, @NonNull Class<?> cls, boolean z11) {
        int i11;
        String str;
        String str2 = "enabled";
        try {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, cls.getName());
            if (z11) {
                i11 = 1;
            } else {
                i11 = 2;
            }
            packageManager.setComponentEnabledSetting(componentName, i11, 1);
            Logger logger = Logger.get();
            String str3 = TAG;
            Object[] objArr = new Object[2];
            objArr[0] = cls.getName();
            if (z11) {
                str = str2;
            } else {
                str = "disabled";
            }
            objArr[1] = str;
            logger.debug(str3, String.format("%s %s", objArr), new Throwable[0]);
        } catch (Exception e11) {
            Logger logger2 = Logger.get();
            String str4 = TAG;
            Object[] objArr2 = new Object[2];
            objArr2[0] = cls.getName();
            if (!z11) {
                str2 = "disabled";
            }
            objArr2[1] = str2;
            logger2.debug(str4, String.format("%s could not be %s", objArr2), e11);
        }
    }

    public static boolean isComponentExplicitlyEnabled(Context context, String str) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, str)) == 1;
    }
}
