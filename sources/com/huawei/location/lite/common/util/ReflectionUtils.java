package com.huawei.location.lite.common.util;

import android.text.TextUtils;
import com.huawei.location.lite.common.log.LogConsole;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtils {
    private static final String SPACE = " ";
    private static final String TAG = "ReflectionUtils";

    private ReflectionUtils() {
    }

    public static boolean checkCompatible(String str) {
        try {
            tryLoadClass(str);
            return true;
        } catch (Exception unused) {
            String str2 = TAG;
            LogConsole.w(str2, str + "ClassNotFoundException");
            return false;
        }
    }

    public static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            String str2 = TAG;
            LogConsole.e(str2, "className not found:" + str);
            return null;
        }
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            try {
                return cls.getMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
                LogConsole.e(TAG, "getMethod NoSuchMethodException");
            }
        }
        return null;
    }

    public static Object invoke(Object obj, Method method) {
        if (method != null) {
            try {
                return method.invoke(obj, new Object[0]);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                LogConsole.e(TAG, "invoke Exception");
                throw new UnsupportedOperationException();
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public static Object invoke(Object obj, Method method, Object... objArr) {
        if (method != null) {
            try {
                return method.invoke(obj, objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                LogConsole.e(TAG, "invoke Exception");
                throw new UnsupportedOperationException();
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public static boolean isSupportClass(String str) {
        return getClass(str) != null;
    }

    private static void tryLoadClass(String str) throws ClassNotFoundException {
        ClassLoader classLoader = ReflectionUtils.class.getClassLoader();
        if (classLoader != null) {
            classLoader.loadClass(str);
            return;
        }
        throw new ClassNotFoundException("not found classloader");
    }
}
