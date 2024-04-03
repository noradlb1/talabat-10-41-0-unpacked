package com.apptimize;

import com.apptimize.bq;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import com.tekartik.sqflite.Constant;
import datamodels.TypesAliasesKt;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class fn {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42449a = "fn";

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        if (gn.w()) {
            try {
                return b(cls, str, clsArr);
            } catch (NoSuchMethodException e11) {
                String str2 = f42449a;
                bo.h(str2, str + " not found", e11);
            } finally {
                gn.x();
            }
        }
        return null;
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        if (cls != null) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
                return b(cls.getSuperclass(), str, clsArr);
            }
        } else {
            throw new NoSuchMethodException(str);
        }
    }

    public static long c(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        return b(obj.getClass(), str).getLong(obj);
    }

    public static Object d(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        return b(obj.getClass(), str).get(obj);
    }

    public static int b(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        return b(obj.getClass(), str).getInt(obj);
    }

    public static Field b(Class<?> cls, String str) throws NoSuchFieldException {
        try {
            Field a11 = a(cls, str, str);
            a11.setAccessible(true);
            return a11;
        } catch (NoSuchFieldException e11) {
            b(cls);
            throw e11;
        }
    }

    public static Method a(Class<?> cls, String str) throws NoSuchMethodException {
        if (cls != null) {
            for (Method method : cls.getDeclaredMethods()) {
                if (method.getName().equals(str)) {
                    return method;
                }
            }
            return a((Class<?>) cls.getSuperclass(), str);
        }
        throw new NoSuchMethodException(str);
    }

    private static void b(Class<?> cls) {
        if (av.f41240c && cls != null && cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                bo.k(f42449a, cls.getName() + "#" + field.getName());
            }
            b(cls.getSuperclass());
        }
    }

    public static String a(Class<?> cls) {
        return cls.getName().replace(RealDiscoveryConfigurationRepository.VERSION_DELIMETER, "/");
    }

    public static boolean a(Object obj, String str) {
        for (Class cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            if (cls.getName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String a(au auVar, Class<?> cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        if (declaredMethods.length <= 2) {
            for (int i11 = 0; i11 < declaredMethods.length; i11++) {
                String[] split = declaredMethods[i11].getName().split("\\.");
                if (split.length > 0 && split[split.length - 1] != "access$super") {
                    return declaredMethods[i11].getName();
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("class:");
        sb2.append(cls.getName());
        sb2.append(";methods:");
        for (Method method : declaredMethods) {
            sb2.append(method.toString());
            sb2.append(TypesAliasesKt.separator);
        }
        auVar.a().a(bq.b.A, (Map<String, Object>) new HashMap<String, Object>(sb2) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ StringBuilder f42450a;

            {
                this.f42450a = r3;
                put(Constant.PARAM_ERROR_CODE, "AN1026");
                put("attr", r3.toString());
            }
        });
        return null;
    }

    private static Field a(Class<?> cls, String str, String str2) throws NoSuchFieldException {
        if (cls == null || cls == Object.class) {
            throw new NoSuchFieldException("Object#" + str2);
        }
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Class<? super Object> superclass = cls.getSuperclass();
            return a((Class<?>) superclass, str, cls.getName() + "#" + str2);
        }
    }

    public static boolean a() {
        return !f42449a.startsWith("Ref");
    }
}
