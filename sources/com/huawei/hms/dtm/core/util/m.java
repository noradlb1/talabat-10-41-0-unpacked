package com.huawei.hms.dtm.core.util;

import android.text.TextUtils;
import java.lang.reflect.Method;

public class m {
    private static Object a(Class<?> cls, String str, Object obj, Class<?>[] clsArr, Object... objArr) throws Exception {
        return cls.getMethod(str, clsArr).invoke(obj, objArr);
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) throws Exception {
        return a(obj.getClass(), str, obj, clsArr, objArr);
    }

    public static Object a(String str, String str2, Class<?>[] clsArr, Object... objArr) throws Exception {
        return a(Class.forName(str), str2, (Object) null, clsArr, objArr);
    }

    public static Method a(Object obj, String str, Class<?>... clsArr) {
        if (obj == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Class cls = obj.getClass();
        while (cls != null && cls != Object.class) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException e11) {
                Logger.warn("DTM-AutoTrace", "getDeclaredMethod#" + e11.getMessage());
                cls = cls.getSuperclass();
            }
        }
        return null;
    }
}
