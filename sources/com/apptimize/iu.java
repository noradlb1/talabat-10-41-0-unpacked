package com.apptimize;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class iu<T, V> implements iw<T, V> {

    /* renamed from: a  reason: collision with root package name */
    private Class<V> f43078a;

    /* renamed from: b  reason: collision with root package name */
    private Class<T> f43079b;

    /* renamed from: c  reason: collision with root package name */
    private String f43080c;

    /* renamed from: d  reason: collision with root package name */
    private String f43081d;

    /* renamed from: e  reason: collision with root package name */
    private String f43082e;

    public iu(Class<V> cls, Class<T> cls2, String str) {
        this(cls, cls2, str, a(cls2, str), b(str));
    }

    private static String a(String str) {
        if (str.equals("")) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static <T> String b(String str) {
        return "set" + a(str);
    }

    public iu(Class<V> cls, Class<T> cls2, String str, String str2, String str3) {
        this.f43078a = cls;
        this.f43079b = cls2;
        this.f43080c = str;
        this.f43081d = str2;
        this.f43082e = str3;
    }

    public Class<V> b() {
        return this.f43078a;
    }

    private static <T> String a(Class<T> cls, String str) {
        if (cls == Boolean.class || cls == Boolean.TYPE) {
            return "is" + a(str);
        }
        return "get" + a(str);
    }

    private Method b(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod(this.f43082e, new Class[]{this.f43079b});
    }

    public static <T, V> iu<T, V> a(Class<V> cls, Class<T> cls2, String str, String str2, String str3) {
        return new iu(cls, cls2, str, str2, str3);
    }

    public static <T, V> iu<T, V> a(Class<V> cls, Class<T> cls2, String str) {
        return new iu<>(cls, cls2, str);
    }

    public Method a() throws NoSuchMethodException {
        return b((Class<?>) b());
    }

    public void a(V v11, T t11) {
        try {
            b(v11.getClass()).invoke(v11, new Object[]{t11});
        } catch (NoSuchMethodException e11) {
            bo.f(hl.f42949a, String.format("Failed to set property %s on object %s", new Object[]{this.f43080c, v11.toString()}), e11);
        } catch (IllegalAccessException e12) {
            bo.f(hl.f42949a, String.format("Failed to set property %s on object %s", new Object[]{this.f43080c, v11.toString()}), e12);
        } catch (InvocationTargetException e13) {
            bo.f(hl.f42949a, String.format("Failed to set property %s on object %s", new Object[]{this.f43080c, v11.toString()}), e13);
        }
    }

    public T a(V v11) {
        try {
            return a(v11.getClass()).invoke(v11, new Object[0]);
        } catch (NoSuchMethodException e11) {
            bo.f(hl.f42949a, String.format("Failed to get property %s on object %s", new Object[]{this.f43080c, v11.toString()}), e11);
            return null;
        } catch (IllegalAccessException e12) {
            bo.f(hl.f42949a, String.format("Failed to get property %s on object %s", new Object[]{this.f43080c, v11.toString()}), e12);
            return null;
        } catch (InvocationTargetException e13) {
            bo.f(hl.f42949a, String.format("Failed to get property %s on object %s", new Object[]{this.f43080c, v11.toString()}), e13);
            return null;
        }
    }

    private Method a(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod(this.f43081d, new Class[0]);
    }
}
