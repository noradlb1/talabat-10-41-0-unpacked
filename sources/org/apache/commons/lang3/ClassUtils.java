package org.apache.commons.lang3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.adjust.sdk.Constants;
import datamodels.TypesAliasesKt;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.HttpUrl;
import org.apache.commons.lang3.mutable.MutableObject;

public class ClassUtils {
    public static final String INNER_CLASS_SEPARATOR = String.valueOf('$');
    public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
    public static final String PACKAGE_SEPARATOR = String.valueOf('.');
    public static final char PACKAGE_SEPARATOR_CHAR = '.';
    private static final Map<String, String> abbreviationMap;
    private static final Map<Class<?>, Class<?>> primitiveWrapperMap;
    private static final Map<String, String> reverseAbbreviationMap;
    private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap = new HashMap();

    public enum Interfaces {
        INCLUDE,
        EXCLUDE
    }

    static {
        HashMap hashMap = new HashMap();
        primitiveWrapperMap = hashMap;
        hashMap.put(Boolean.TYPE, Boolean.class);
        hashMap.put(Byte.TYPE, Byte.class);
        hashMap.put(Character.TYPE, Character.class);
        hashMap.put(Short.TYPE, Short.class);
        hashMap.put(Integer.TYPE, Integer.class);
        hashMap.put(Long.TYPE, Long.class);
        hashMap.put(Double.TYPE, Double.class);
        hashMap.put(Float.TYPE, Float.class);
        Class cls = Void.TYPE;
        hashMap.put(cls, cls);
        for (Class cls2 : hashMap.keySet()) {
            Class cls3 = primitiveWrapperMap.get(cls2);
            if (!cls2.equals(cls3)) {
                wrapperPrimitiveMap.put(cls3, cls2);
            }
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("int", "I");
        hashMap2.put(TypedValues.Custom.S_BOOLEAN, "Z");
        hashMap2.put(TypedValues.Custom.S_FLOAT, "F");
        hashMap2.put(Constants.LONG, "J");
        hashMap2.put("short", ExifInterface.LATITUDE_SOUTH);
        hashMap2.put("byte", "B");
        hashMap2.put("double", "D");
        hashMap2.put("char", "C");
        hashMap2.put("void", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        HashMap hashMap3 = new HashMap();
        for (Map.Entry entry : hashMap2.entrySet()) {
            hashMap3.put(entry.getValue(), entry.getKey());
        }
        abbreviationMap = Collections.unmodifiableMap(hashMap2);
        reverseAbbreviationMap = Collections.unmodifiableMap(hashMap3);
    }

    public static List<Class<?>> convertClassNamesToClasses(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String cls : list) {
            try {
                arrayList.add(Class.forName(cls));
            } catch (Exception unused) {
                arrayList.add((Object) null);
            }
        }
        return arrayList;
    }

    public static List<String> convertClassesToClassNames(List<Class<?>> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Class next : list) {
            if (next == null) {
                arrayList.add((Object) null);
            } else {
                arrayList.add(next.getName());
            }
        }
        return arrayList;
    }

    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        getAllInterfaces(cls, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.Class<?>> getAllSuperclasses(java.lang.Class<?> r1) {
        /*
            if (r1 != 0) goto L_0x0004
            r1 = 0
            return r1
        L_0x0004:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Class r1 = r1.getSuperclass()
        L_0x000d:
            if (r1 == 0) goto L_0x0017
            r0.add(r1)
            java.lang.Class r1 = r1.getSuperclass()
            goto L_0x000d
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.ClassUtils.getAllSuperclasses(java.lang.Class):java.util.List");
    }

    private static String getCanonicalName(String str) {
        int i11;
        String deleteWhitespace = StringUtils.deleteWhitespace(str);
        if (deleteWhitespace == null) {
            return null;
        }
        int i12 = 0;
        while (deleteWhitespace.startsWith("[")) {
            i12++;
            deleteWhitespace = deleteWhitespace.substring(1);
        }
        if (i12 < 1) {
            return deleteWhitespace;
        }
        if (deleteWhitespace.startsWith("L")) {
            if (deleteWhitespace.endsWith(TypesAliasesKt.separator)) {
                i11 = deleteWhitespace.length() - 1;
            } else {
                i11 = deleteWhitespace.length();
            }
            deleteWhitespace = deleteWhitespace.substring(1, i11);
        } else if (deleteWhitespace.length() > 0) {
            deleteWhitespace = reverseAbbreviationMap.get(deleteWhitespace.substring(0, 1));
        }
        StringBuilder sb2 = new StringBuilder(deleteWhitespace);
        for (int i13 = 0; i13 < i12; i13++) {
            sb2.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        return sb2.toString();
    }

    public static Class<?> getClass(ClassLoader classLoader, String str, boolean z11) throws ClassNotFoundException {
        try {
            Map<String, String> map = abbreviationMap;
            if (!map.containsKey(str)) {
                return Class.forName(toCanonicalName(str), z11, classLoader);
            }
            return Class.forName("[" + map.get(str), z11, classLoader).getComponentType();
        } catch (ClassNotFoundException e11) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf != -1) {
                try {
                    return getClass(classLoader, str.substring(0, lastIndexOf) + '$' + str.substring(lastIndexOf + 1), z11);
                } catch (ClassNotFoundException unused) {
                    throw e11;
                }
            }
            throw e11;
        }
    }

    public static String getPackageCanonicalName(Object obj, String str) {
        return obj == null ? str : getPackageCanonicalName(obj.getClass().getName());
    }

    public static String getPackageName(Object obj, String str) {
        return obj == null ? str : getPackageName(obj.getClass());
    }

    public static Method getPublicMethod(Class<?> cls, String str, Class<?>... clsArr) throws SecurityException, NoSuchMethodException {
        Method method = cls.getMethod(str, clsArr);
        if (Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
            return method;
        }
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.addAll(getAllInterfaces(cls));
        arrayList.addAll(getAllSuperclasses(cls));
        for (Class cls2 : arrayList) {
            if (Modifier.isPublic(cls2.getModifiers())) {
                try {
                    Method method2 = cls2.getMethod(str, clsArr);
                    if (Modifier.isPublic(method2.getDeclaringClass().getModifiers())) {
                        return method2;
                    }
                } catch (NoSuchMethodException unused) {
                    continue;
                }
            }
        }
        throw new NoSuchMethodException("Can't find a public method for " + str + " " + ArrayUtils.toString(clsArr));
    }

    public static String getShortCanonicalName(Object obj, String str) {
        return obj == null ? str : getShortCanonicalName(obj.getClass().getName());
    }

    public static String getShortClassName(Object obj, String str) {
        return obj == null ? str : getShortClassName(obj.getClass());
    }

    public static String getSimpleName(Class<?> cls) {
        return cls == null ? "" : cls.getSimpleName();
    }

    public static Iterable<Class<?>> hierarchy(Class<?> cls) {
        return hierarchy(cls, Interfaces.EXCLUDE);
    }

    public static boolean isAssignable(Class<?>[] clsArr, Class<?>... clsArr2) {
        return isAssignable(clsArr, clsArr2, SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_5));
    }

    public static boolean isInnerClass(Class<?> cls) {
        return (cls == null || cls.getEnclosingClass() == null) ? false : true;
    }

    public static boolean isPrimitiveOrWrapper(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        return cls.isPrimitive() || isPrimitiveWrapper(cls);
    }

    public static boolean isPrimitiveWrapper(Class<?> cls) {
        return wrapperPrimitiveMap.containsKey(cls);
    }

    public static Class<?> primitiveToWrapper(Class<?> cls) {
        if (cls == null || !cls.isPrimitive()) {
            return cls;
        }
        return primitiveWrapperMap.get(cls);
    }

    public static Class<?>[] primitivesToWrappers(Class<?>... clsArr) {
        if (clsArr == null) {
            return null;
        }
        if (clsArr.length == 0) {
            return clsArr;
        }
        Class<?>[] clsArr2 = new Class[clsArr.length];
        for (int i11 = 0; i11 < clsArr.length; i11++) {
            clsArr2[i11] = primitiveToWrapper(clsArr[i11]);
        }
        return clsArr2;
    }

    private static String toCanonicalName(String str) {
        String deleteWhitespace = StringUtils.deleteWhitespace(str);
        if (deleteWhitespace == null) {
            throw new NullPointerException("className must not be null.");
        } else if (!deleteWhitespace.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return deleteWhitespace;
        } else {
            StringBuilder sb2 = new StringBuilder();
            while (deleteWhitespace.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                deleteWhitespace = deleteWhitespace.substring(0, deleteWhitespace.length() - 2);
                sb2.append("[");
            }
            String str2 = abbreviationMap.get(deleteWhitespace);
            if (str2 != null) {
                sb2.append(str2);
            } else {
                sb2.append("L");
                sb2.append(deleteWhitespace);
                sb2.append(TypesAliasesKt.separator);
            }
            return sb2.toString();
        }
    }

    public static Class<?>[] toClass(Object... objArr) {
        Class<?> cls;
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i11 = 0; i11 < objArr.length; i11++) {
            Object obj = objArr[i11];
            if (obj == null) {
                cls = null;
            } else {
                cls = obj.getClass();
            }
            clsArr[i11] = cls;
        }
        return clsArr;
    }

    public static Class<?> wrapperToPrimitive(Class<?> cls) {
        return wrapperPrimitiveMap.get(cls);
    }

    public static Class<?>[] wrappersToPrimitives(Class<?>... clsArr) {
        if (clsArr == null) {
            return null;
        }
        if (clsArr.length == 0) {
            return clsArr;
        }
        Class<?>[] clsArr2 = new Class[clsArr.length];
        for (int i11 = 0; i11 < clsArr.length; i11++) {
            clsArr2[i11] = wrapperToPrimitive(clsArr[i11]);
        }
        return clsArr2;
    }

    public static String getPackageCanonicalName(Class<?> cls) {
        return cls == null ? "" : getPackageCanonicalName(cls.getName());
    }

    public static String getPackageName(Class<?> cls) {
        return cls == null ? "" : getPackageName(cls.getName());
    }

    public static String getShortCanonicalName(Class<?> cls) {
        return cls == null ? "" : getShortCanonicalName(cls.getName());
    }

    public static String getShortClassName(Class<?> cls) {
        return cls == null ? "" : getShortClassName(cls.getName());
    }

    public static String getSimpleName(Object obj, String str) {
        return obj == null ? str : getSimpleName(obj.getClass());
    }

    public static Iterable<Class<?>> hierarchy(final Class<?> cls, Interfaces interfaces) {
        final AnonymousClass1 r02 = new Iterable<Class<?>>() {
            public Iterator<Class<?>> iterator() {
                final MutableObject mutableObject = new MutableObject(cls);
                return new Object() {
                    public /* synthetic */ void forEachRemaining(Consumer consumer) {
                        Iterator.CC.$default$forEachRemaining(this, consumer);
                    }

                    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
                    }

                    public boolean hasNext() {
                        return mutableObject.getValue() != null;
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    public Class<?> next() {
                        Class<?> cls = (Class) mutableObject.getValue();
                        mutableObject.setValue(cls.getSuperclass());
                        return cls;
                    }
                };
            }
        };
        if (interfaces != Interfaces.INCLUDE) {
            return r02;
        }
        return new Iterable<Class<?>>() {
            public java.util.Iterator<Class<?>> iterator() {
                final HashSet hashSet = new HashSet();
                final java.util.Iterator it = r02.iterator();
                return new Object() {

                    /* renamed from: b  reason: collision with root package name */
                    public java.util.Iterator<Class<?>> f27781b = Collections.emptySet().iterator();

                    private void walkInterfaces(Set<Class<?>> set, Class<?> cls) {
                        for (Class cls2 : cls.getInterfaces()) {
                            if (!hashSet.contains(cls2)) {
                                set.add(cls2);
                            }
                            walkInterfaces(set, cls2);
                        }
                    }

                    public /* synthetic */ void forEachRemaining(Consumer consumer) {
                        Iterator.CC.$default$forEachRemaining(this, consumer);
                    }

                    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
                    }

                    public boolean hasNext() {
                        return this.f27781b.hasNext() || it.hasNext();
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    public Class<?> next() {
                        if (this.f27781b.hasNext()) {
                            Class<?> next = this.f27781b.next();
                            hashSet.add(next);
                            return next;
                        }
                        Class<?> cls = (Class) it.next();
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        walkInterfaces(linkedHashSet, cls);
                        this.f27781b = linkedHashSet.iterator();
                        return cls;
                    }
                };
            }
        };
    }

    public static boolean isAssignable(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z11) {
        if (!ArrayUtils.isSameLength((Object[]) clsArr, (Object[]) clsArr2)) {
            return false;
        }
        if (clsArr == null) {
            clsArr = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        if (clsArr2 == null) {
            clsArr2 = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        for (int i11 = 0; i11 < clsArr.length; i11++) {
            if (!isAssignable(clsArr[i11], clsArr2[i11], z11)) {
                return false;
            }
        }
        return true;
    }

    public static String getPackageCanonicalName(String str) {
        return getPackageName(getCanonicalName(str));
    }

    public static String getPackageName(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        while (str.charAt(0) == '[') {
            str = str.substring(1);
        }
        if (str.charAt(0) == 'L' && str.charAt(str.length() - 1) == ';') {
            str = str.substring(1);
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return "";
        }
        return str.substring(0, lastIndexOf);
    }

    public static String getShortCanonicalName(String str) {
        return getShortClassName(getCanonicalName(str));
    }

    public static String getShortClassName(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        if (str.startsWith("[")) {
            while (str.charAt(0) == '[') {
                str = str.substring(1);
                sb2.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            if (str.charAt(0) == 'L' && str.charAt(str.length() - 1) == ';') {
                str = str.substring(1, str.length() - 1);
            }
            Map<String, String> map = reverseAbbreviationMap;
            if (map.containsKey(str)) {
                str = map.get(str);
            }
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            i11 = lastIndexOf + 1;
        }
        int indexOf = str.indexOf(36, i11);
        String substring = str.substring(lastIndexOf + 1);
        if (indexOf != -1) {
            substring = substring.replace('$', '.');
        }
        return substring + sb2;
    }

    private static void getAllInterfaces(Class<?> cls, HashSet<Class<?>> hashSet) {
        Class<? super Object> cls2;
        while (cls2 != null) {
            for (Class cls3 : cls2.getInterfaces()) {
                if (hashSet.add(cls3)) {
                    getAllInterfaces(cls3, hashSet);
                }
            }
            Class<? super Object> superclass = cls2.getSuperclass();
            cls2 = cls;
            cls2 = superclass;
        }
    }

    public static boolean isAssignable(Class<?> cls, Class<?> cls2) {
        return isAssignable(cls, cls2, SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_5));
    }

    public static Class<?> getClass(ClassLoader classLoader, String str) throws ClassNotFoundException {
        return getClass(classLoader, str, true);
    }

    public static boolean isAssignable(Class<?> cls, Class<?> cls2, boolean z11) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (z11) {
            if (cls.isPrimitive() && !cls2.isPrimitive() && (cls = primitiveToWrapper(cls)) == null) {
                return false;
            }
            if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = wrapperToPrimitive(cls)) == null) {
                return false;
            }
        }
        if (cls.equals(cls2)) {
            return true;
        }
        if (!cls.isPrimitive()) {
            return cls2.isAssignableFrom(cls);
        }
        if (!cls2.isPrimitive()) {
            return false;
        }
        Class cls3 = Integer.TYPE;
        if (!cls3.equals(cls)) {
            Class cls4 = Long.TYPE;
            if (cls4.equals(cls)) {
                if (Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
                    return true;
                }
                return false;
            } else if (Boolean.TYPE.equals(cls) || Double.TYPE.equals(cls)) {
                return false;
            } else {
                Class cls5 = Float.TYPE;
                if (cls5.equals(cls)) {
                    return Double.TYPE.equals(cls2);
                }
                if (Character.TYPE.equals(cls)) {
                    if (cls3.equals(cls2) || cls4.equals(cls2) || cls5.equals(cls2) || Double.TYPE.equals(cls2)) {
                        return true;
                    }
                    return false;
                } else if (Short.TYPE.equals(cls)) {
                    if (cls3.equals(cls2) || cls4.equals(cls2) || cls5.equals(cls2) || Double.TYPE.equals(cls2)) {
                        return true;
                    }
                    return false;
                } else if (!Byte.TYPE.equals(cls)) {
                    return false;
                } else {
                    if (Short.TYPE.equals(cls2) || cls3.equals(cls2) || cls4.equals(cls2) || cls5.equals(cls2) || Double.TYPE.equals(cls2)) {
                        return true;
                    }
                    return false;
                }
            }
        } else if (Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
            return true;
        } else {
            return false;
        }
    }

    public static Class<?> getClass(String str) throws ClassNotFoundException {
        return getClass(str, true);
    }

    public static Class<?> getClass(String str, boolean z11) throws ClassNotFoundException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = ClassUtils.class.getClassLoader();
        }
        return getClass(contextClassLoader, str, z11);
    }
}
