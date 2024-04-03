package com.huawei.agconnect.datastore.core;

import com.huawei.agconnect.datastore.annotation.DefaultCrypto;
import com.huawei.agconnect.datastore.annotation.ICrypto;
import java.lang.reflect.InvocationTargetException;

public class CryptoUtil {
    private static ICrypto createWhenProguard(Class<?> cls) {
        try {
            return (ICrypto) cls.newInstance();
        } catch (IllegalAccessException | InstantiationException unused) {
            return null;
        }
    }

    public static ICrypto getHelper(Class<?> cls) {
        Class<DefaultCrypto> cls2 = DefaultCrypto.class;
        try {
            if (!cls2.equals(cls)) {
                if (!cls2.isAssignableFrom(cls)) {
                    return (ICrypto) cls.getMethod("get", new Class[0]).invoke((Object) null, new Object[0]);
                }
            }
        } catch (NoSuchMethodException unused) {
            return createWhenProguard(cls);
        } catch (IllegalAccessException | InvocationTargetException unused2) {
        }
        return null;
    }
}
