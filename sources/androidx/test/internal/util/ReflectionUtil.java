package androidx.test.internal.util;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtil {
    private static final String TAG = "ReflectionUtil";

    public static void reflectivelyInvokeRemoteMethod(String str, String str2) {
        String str3;
        Checks.checkNotNull(str);
        Checks.checkNotNull(str2);
        String valueOf = String.valueOf(str2);
        if (valueOf.length() != 0) {
            str3 = "Attempting to reflectively call: ".concat(valueOf);
        } else {
            str3 = new String("Attempting to reflectively call: ");
        }
        Log.i(TAG, str3);
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke((Object) null, new Object[0]);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
            Log.e(TAG, "Reflective call failed: ", e11);
        }
    }
}
