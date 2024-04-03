package j$.util;

import com.apptimize.c;
import j$.util.Collection;
import j$.util.function.Predicate;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class DesugarCollections {

    /* renamed from: a  reason: collision with root package name */
    public static final Class f28542a;

    /* renamed from: b  reason: collision with root package name */
    private static final Field f28543b;

    /* renamed from: c  reason: collision with root package name */
    private static final Field f28544c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final Constructor f28545d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final Constructor f28546e;

    static {
        Field field;
        Field field2;
        Constructor<?> constructor;
        Class<?> cls = Collections.synchronizedCollection(new ArrayList()).getClass();
        f28542a = cls;
        Collections.synchronizedList(new LinkedList()).getClass();
        Constructor<?> constructor2 = null;
        try {
            field = cls.getDeclaredField("mutex");
        } catch (NoSuchFieldException unused) {
            field = null;
        }
        f28543b = field;
        if (field != null) {
            field.setAccessible(true);
        }
        try {
            field2 = cls.getDeclaredField(c.f41585a);
        } catch (NoSuchFieldException unused2) {
            field2 = null;
        }
        f28544c = field2;
        if (field2 != null) {
            field2.setAccessible(true);
        }
        Class<Object> cls2 = Object.class;
        try {
            constructor = Collections.synchronizedSet(new HashSet()).getClass().getDeclaredConstructor(new Class[]{Set.class, cls2});
        } catch (NoSuchMethodException unused3) {
            constructor = null;
        }
        f28546e = constructor;
        if (constructor != null) {
            constructor.setAccessible(true);
        }
        try {
            constructor2 = cls.getDeclaredConstructor(new Class[]{Collection.class, cls2});
        } catch (NoSuchMethodException unused4) {
        }
        f28545d = constructor2;
        if (constructor2 != null) {
            constructor2.setAccessible(true);
        }
    }

    static boolean c(Collection collection, Predicate predicate) {
        boolean removeIf;
        Field field = f28543b;
        if (field == null) {
            try {
                Collection collection2 = (Collection) f28544c.get(collection);
                return collection2 instanceof Collection ? ((Collection) collection2).removeIf(predicate) : Collection.CC.$default$removeIf(collection2, predicate);
            } catch (IllegalAccessException e11) {
                throw new Error("Runtime illegal access in synchronized collection removeIf fall-back.", e11);
            }
        } else {
            try {
                synchronized (field.get(collection)) {
                    java.util.Collection collection3 = (java.util.Collection) f28544c.get(collection);
                    removeIf = collection3 instanceof Collection ? ((Collection) collection3).removeIf(predicate) : Collection.CC.$default$removeIf(collection3, predicate);
                }
                return removeIf;
            } catch (IllegalAccessException e12) {
                throw new Error("Runtime illegal access in synchronized collection removeIf.", e12);
            }
        }
    }

    public static <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        return new C0139e(map);
    }
}
