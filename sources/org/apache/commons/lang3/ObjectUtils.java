package org.apache.commons.lang3;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.text.StrBuilder;

public class ObjectUtils {
    public static final Null NULL = new Null();

    public static class Null implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        private Object readResolve() {
            return ObjectUtils.NULL;
        }
    }

    public static byte CONST(byte b11) {
        return b11;
    }

    public static char CONST(char c11) {
        return c11;
    }

    public static double CONST(double d11) {
        return d11;
    }

    public static float CONST(float f11) {
        return f11;
    }

    public static int CONST(int i11) {
        return i11;
    }

    public static long CONST(long j11) {
        return j11;
    }

    public static <T> T CONST(T t11) {
        return t11;
    }

    public static short CONST(short s11) {
        return s11;
    }

    public static boolean CONST(boolean z11) {
        return z11;
    }

    public static byte CONST_BYTE(int i11) throws IllegalArgumentException {
        if (i11 >= -128 && i11 <= 127) {
            return (byte) i11;
        }
        throw new IllegalArgumentException("Supplied value must be a valid byte literal between -128 and 127: [" + i11 + "]");
    }

    public static short CONST_SHORT(int i11) throws IllegalArgumentException {
        if (i11 >= -32768 && i11 <= 32767) {
            return (short) i11;
        }
        throw new IllegalArgumentException("Supplied value must be a valid byte literal between -32768 and 32767: [" + i11 + "]");
    }

    public static <T> T clone(T t11) {
        if (!(t11 instanceof Cloneable)) {
            return null;
        }
        if (t11.getClass().isArray()) {
            Class<?> componentType = t11.getClass().getComponentType();
            if (!componentType.isPrimitive()) {
                return ((Object[]) t11).clone();
            }
            int length = Array.getLength(t11);
            T newInstance = Array.newInstance(componentType, length);
            while (true) {
                int i11 = length - 1;
                if (length <= 0) {
                    return newInstance;
                }
                Array.set(newInstance, i11, Array.get(t11, i11));
                length = i11;
            }
        } else {
            try {
                return t11.getClass().getMethod("clone", new Class[0]).invoke(t11, new Object[0]);
            } catch (NoSuchMethodException e11) {
                throw new CloneFailedException("Cloneable type " + t11.getClass().getName() + " has no clone method", e11);
            } catch (IllegalAccessException e12) {
                throw new CloneFailedException("Cannot clone Cloneable type " + t11.getClass().getName(), e12);
            } catch (InvocationTargetException e13) {
                throw new CloneFailedException("Exception cloning Cloneable type " + t11.getClass().getName(), e13.getCause());
            }
        }
    }

    public static <T> T cloneIfPossible(T t11) {
        T clone = clone(t11);
        return clone == null ? t11 : clone;
    }

    public static <T extends Comparable<? super T>> int compare(T t11, T t12) {
        return compare(t11, t12, false);
    }

    public static <T> T defaultIfNull(T t11, T t12) {
        return t11 != null ? t11 : t12;
    }

    @Deprecated
    public static boolean equals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static <T> T firstNonNull(T... tArr) {
        if (tArr == null) {
            return null;
        }
        for (T t11 : tArr) {
            if (t11 != null) {
                return t11;
            }
        }
        return null;
    }

    @Deprecated
    public static int hashCode(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Deprecated
    public static int hashCodeMulti(Object... objArr) {
        int i11 = 1;
        if (objArr != null) {
            for (Object hashCode : objArr) {
                i11 = (i11 * 31) + hashCode(hashCode);
            }
        }
        return i11;
    }

    public static String identityToString(Object obj) {
        if (obj == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        identityToString(sb2, obj);
        return sb2.toString();
    }

    public static <T extends Comparable<? super T>> T max(T... tArr) {
        T t11 = null;
        if (tArr != null) {
            for (T t12 : tArr) {
                if (compare(t12, t11, false) > 0) {
                    t11 = t12;
                }
            }
        }
        return t11;
    }

    public static <T extends Comparable<? super T>> T median(T... tArr) {
        Validate.notEmpty(tArr);
        Validate.noNullElements(tArr);
        TreeSet treeSet = new TreeSet();
        Collections.addAll(treeSet, tArr);
        return (Comparable) treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    public static <T extends Comparable<? super T>> T min(T... tArr) {
        T t11 = null;
        if (tArr != null) {
            for (T t12 : tArr) {
                if (compare(t12, t11, true) < 0) {
                    t11 = t12;
                }
            }
        }
        return t11;
    }

    public static <T> T mode(T... tArr) {
        if (!ArrayUtils.isNotEmpty(tArr)) {
            return null;
        }
        HashMap hashMap = new HashMap(tArr.length);
        int i11 = 0;
        for (T t11 : tArr) {
            MutableInt mutableInt = (MutableInt) hashMap.get(t11);
            if (mutableInt == null) {
                hashMap.put(t11, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        Iterator it = hashMap.entrySet().iterator();
        while (true) {
            T t12 = null;
            while (true) {
                if (!it.hasNext()) {
                    return t12;
                }
                Map.Entry entry = (Map.Entry) it.next();
                int intValue = ((MutableInt) entry.getValue()).intValue();
                if (intValue != i11) {
                    if (intValue > i11) {
                        t12 = entry.getKey();
                        i11 = intValue;
                    }
                }
            }
        }
    }

    public static boolean notEqual(Object obj, Object obj2) {
        return !equals(obj, obj2);
    }

    public String toString() {
        return super.toString();
    }

    public static <T extends Comparable<? super T>> int compare(T t11, T t12, boolean z11) {
        if (t11 == t12) {
            return 0;
        }
        if (t11 == null) {
            return z11 ? 1 : -1;
        }
        if (t12 == null) {
            return z11 ? -1 : 1;
        }
        return t11.compareTo(t12);
    }

    @Deprecated
    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    @Deprecated
    public static String toString(Object obj, String str) {
        return obj == null ? str : obj.toString();
    }

    public static void identityToString(Appendable appendable, Object obj) throws IOException {
        if (obj != null) {
            appendable.append(obj.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(obj)));
            return;
        }
        throw new NullPointerException("Cannot get the toString of a null identity");
    }

    public static void identityToString(StrBuilder strBuilder, Object obj) {
        if (obj != null) {
            strBuilder.append(obj.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(obj)));
            return;
        }
        throw new NullPointerException("Cannot get the toString of a null identity");
    }

    public static <T> T median(Comparator<T> comparator, T... tArr) {
        Validate.notEmpty(tArr, "null/empty items", new Object[0]);
        Validate.noNullElements(tArr);
        Validate.notNull(comparator, "null comparator", new Object[0]);
        TreeSet treeSet = new TreeSet(comparator);
        Collections.addAll(treeSet, tArr);
        return treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    public static void identityToString(StringBuffer stringBuffer, Object obj) {
        if (obj != null) {
            stringBuffer.append(obj.getClass().getName());
            stringBuffer.append('@');
            stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
            return;
        }
        throw new NullPointerException("Cannot get the toString of a null identity");
    }

    public static void identityToString(StringBuilder sb2, Object obj) {
        if (obj != null) {
            sb2.append(obj.getClass().getName());
            sb2.append('@');
            sb2.append(Integer.toHexString(System.identityHashCode(obj)));
            return;
        }
        throw new NullPointerException("Cannot get the toString of a null identity");
    }
}
