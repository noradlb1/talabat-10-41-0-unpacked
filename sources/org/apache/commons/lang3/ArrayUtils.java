package org.apache.commons.lang3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.mutable.MutableInt;

public class ArrayUtils {
    public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
    public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];
    public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];
    public static final char[] EMPTY_CHAR_ARRAY = new char[0];
    public static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];
    public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
    public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];
    public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
    public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];
    public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    public static final long[] EMPTY_LONG_ARRAY = new long[0];
    public static final Long[] EMPTY_LONG_OBJECT_ARRAY = new Long[0];
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    public static final short[] EMPTY_SHORT_ARRAY = new short[0];
    public static final Short[] EMPTY_SHORT_OBJECT_ARRAY = new Short[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int INDEX_NOT_FOUND = -1;

    public static <T> T[] add(T[] tArr, T t11) {
        Class<?> cls;
        if (tArr != null) {
            cls = tArr.getClass();
        } else if (t11 != null) {
            cls = t11.getClass();
        } else {
            throw new IllegalArgumentException("Arguments cannot both be null");
        }
        T[] tArr2 = (Object[]) copyArrayGrow1(tArr, cls);
        tArr2[tArr2.length - 1] = t11;
        return tArr2;
    }

    public static <T> T[] addAll(T[] tArr, T... tArr2) {
        if (tArr == null) {
            return clone(tArr2);
        }
        if (tArr2 == null) {
            return clone(tArr);
        }
        Class<?> componentType = tArr.getClass().getComponentType();
        T[] tArr3 = (Object[]) Array.newInstance(componentType, tArr.length + tArr2.length);
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        try {
            System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
            return tArr3;
        } catch (ArrayStoreException e11) {
            Class<?> componentType2 = tArr2.getClass().getComponentType();
            if (!componentType.isAssignableFrom(componentType2)) {
                throw new IllegalArgumentException("Cannot store " + componentType2.getName() + " in an array of " + componentType.getName(), e11);
            }
            throw e11;
        }
    }

    public static <T> T[] clone(T[] tArr) {
        if (tArr == null) {
            return null;
        }
        return (Object[]) tArr.clone();
    }

    public static boolean contains(Object[] objArr, Object obj) {
        return indexOf(objArr, obj) != -1;
    }

    private static Object copyArrayGrow1(Object obj, Class<?> cls) {
        if (obj == null) {
            return Array.newInstance(cls, 1);
        }
        int length = Array.getLength(obj);
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length + 1);
        System.arraycopy(obj, 0, newInstance, 0, length);
        return newInstance;
    }

    public static int getLength(Object obj) {
        if (obj == null) {
            return 0;
        }
        return Array.getLength(obj);
    }

    public static int hashCode(Object obj) {
        return new HashCodeBuilder().append(obj).toHashCode();
    }

    public static int indexOf(Object[] objArr, Object obj) {
        return indexOf(objArr, obj, 0);
    }

    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    @Deprecated
    public static boolean isEquals(Object obj, Object obj2) {
        return new EqualsBuilder().append(obj, obj2).isEquals();
    }

    public static <T> boolean isNotEmpty(T[] tArr) {
        return (tArr == null || tArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(Object[] objArr, Object[] objArr2) {
        if (objArr == null && objArr2 != null && objArr2.length > 0) {
            return false;
        }
        if (objArr2 != null || objArr == null || objArr.length <= 0) {
            return objArr == null || objArr2 == null || objArr.length == objArr2.length;
        }
        return false;
    }

    public static boolean isSameType(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            return obj.getClass().getName().equals(obj2.getClass().getName());
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static int lastIndexOf(Object[] objArr, Object obj) {
        return lastIndexOf(objArr, obj, Integer.MAX_VALUE);
    }

    public static Object[] nullToEmpty(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return EMPTY_OBJECT_ARRAY;
        }
        return objArr;
    }

    public static <T> T[] remove(T[] tArr, int i11) {
        return (Object[]) remove((Object) tArr, i11);
    }

    public static <T> T[] removeAll(T[] tArr, int... iArr) {
        return (Object[]) removeAll((Object) tArr, clone(iArr));
    }

    public static <T> T[] removeElement(T[] tArr, Object obj) {
        int indexOf = indexOf((Object[]) tArr, obj);
        if (indexOf == -1) {
            return clone(tArr);
        }
        return remove(tArr, indexOf);
    }

    public static <T> T[] removeElements(T[] tArr, T... tArr2) {
        if (isEmpty((Object[]) tArr) || isEmpty((Object[]) tArr2)) {
            return clone(tArr);
        }
        HashMap hashMap = new HashMap(tArr2.length);
        for (T t11 : tArr2) {
            MutableInt mutableInt = (MutableInt) hashMap.get(t11);
            if (mutableInt == null) {
                hashMap.put(t11, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        BitSet bitSet = new BitSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Object key = entry.getKey();
            int intValue = ((MutableInt) entry.getValue()).intValue();
            int i11 = 0;
            int i12 = 0;
            while (i11 < intValue) {
                int indexOf = indexOf((Object[]) tArr, key, i12);
                if (indexOf < 0) {
                    break;
                }
                bitSet.set(indexOf);
                i11++;
                i12 = indexOf + 1;
            }
        }
        return (Object[]) removeAll((Object) tArr, bitSet);
    }

    public static void reverse(Object[] objArr) {
        if (objArr != null) {
            reverse(objArr, 0, objArr.length);
        }
    }

    public static <T> T[] subarray(T[] tArr, int i11, int i12) {
        if (tArr == null) {
            return null;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        if (i12 > tArr.length) {
            i12 = tArr.length;
        }
        int i13 = i12 - i11;
        Class<?> componentType = tArr.getClass().getComponentType();
        if (i13 <= 0) {
            return (Object[]) Array.newInstance(componentType, 0);
        }
        T[] tArr2 = (Object[]) Array.newInstance(componentType, i13);
        System.arraycopy(tArr, i11, tArr2, 0, i13);
        return tArr2;
    }

    public static <T> T[] toArray(T... tArr) {
        return tArr;
    }

    public static Map<Object, Object> toMap(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        HashMap hashMap = new HashMap((int) (((double) objArr.length) * 1.5d));
        for (int i11 = 0; i11 < objArr.length; i11++) {
            Map.Entry entry = objArr[i11];
            if (entry instanceof Map.Entry) {
                Map.Entry entry2 = entry;
                hashMap.put(entry2.getKey(), entry2.getValue());
            } else if (entry instanceof Object[]) {
                Object[] objArr2 = (Object[]) entry;
                if (objArr2.length >= 2) {
                    hashMap.put(objArr2[0], objArr2[1]);
                } else {
                    throw new IllegalArgumentException("Array element " + i11 + ", '" + entry + "', has a length less than 2");
                }
            } else {
                throw new IllegalArgumentException("Array element " + i11 + ", '" + entry + "', is neither of type Map.Entry nor an Array");
            }
        }
        return hashMap;
    }

    public static Character[] toObject(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        if (cArr.length == 0) {
            return EMPTY_CHARACTER_OBJECT_ARRAY;
        }
        Character[] chArr = new Character[cArr.length];
        for (int i11 = 0; i11 < cArr.length; i11++) {
            chArr[i11] = Character.valueOf(cArr[i11]);
        }
        return chArr;
    }

    public static char[] toPrimitive(Character[] chArr) {
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[chArr.length];
        for (int i11 = 0; i11 < chArr.length; i11++) {
            cArr[i11] = chArr[i11].charValue();
        }
        return cArr;
    }

    public static String toString(Object obj) {
        return toString(obj, "{}");
    }

    public static long[] clone(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        return (long[]) jArr.clone();
    }

    public static boolean contains(long[] jArr, long j11) {
        return indexOf(jArr, j11) != -1;
    }

    public static int indexOf(Object[] objArr, Object obj, int i11) {
        if (objArr == null) {
            return -1;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        if (obj == null) {
            while (i11 < objArr.length) {
                if (objArr[i11] == null) {
                    return i11;
                }
                i11++;
            }
        } else if (objArr.getClass().getComponentType().isInstance(obj)) {
            while (i11 < objArr.length) {
                if (obj.equals(objArr[i11])) {
                    return i11;
                }
                i11++;
            }
        }
        return -1;
    }

    public static boolean isEmpty(long[] jArr) {
        return jArr == null || jArr.length == 0;
    }

    public static boolean isNotEmpty(long[] jArr) {
        return (jArr == null || jArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(long[] jArr, long[] jArr2) {
        if (jArr == null && jArr2 != null && jArr2.length > 0) {
            return false;
        }
        if (jArr2 != null || jArr == null || jArr.length <= 0) {
            return jArr == null || jArr2 == null || jArr.length == jArr2.length;
        }
        return false;
    }

    public static int lastIndexOf(Object[] objArr, Object obj, int i11) {
        if (objArr == null || i11 < 0) {
            return -1;
        }
        if (i11 >= objArr.length) {
            i11 = objArr.length - 1;
        }
        if (obj == null) {
            while (i11 >= 0) {
                if (objArr[i11] == null) {
                    return i11;
                }
                i11--;
            }
        } else if (objArr.getClass().getComponentType().isInstance(obj)) {
            while (i11 >= 0) {
                if (obj.equals(objArr[i11])) {
                    return i11;
                }
                i11--;
            }
        }
        return -1;
    }

    public static boolean[] remove(boolean[] zArr, int i11) {
        return (boolean[]) remove((Object) zArr, i11);
    }

    public static byte[] removeAll(byte[] bArr, int... iArr) {
        return (byte[]) removeAll((Object) bArr, clone(iArr));
    }

    public static void reverse(long[] jArr) {
        if (jArr != null) {
            reverse(jArr, 0, jArr.length);
        }
    }

    public static String toString(Object obj, String str) {
        return obj == null ? str : new ToStringBuilder(obj, ToStringStyle.SIMPLE_STYLE).append(obj).toString();
    }

    public static int[] clone(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        return (int[]) iArr.clone();
    }

    public static boolean contains(int[] iArr, int i11) {
        return indexOf(iArr, i11) != -1;
    }

    public static boolean isEmpty(int[] iArr) {
        return iArr == null || iArr.length == 0;
    }

    public static boolean isNotEmpty(int[] iArr) {
        return (iArr == null || iArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(int[] iArr, int[] iArr2) {
        if (iArr == null && iArr2 != null && iArr2.length > 0) {
            return false;
        }
        if (iArr2 != null || iArr == null || iArr.length <= 0) {
            return iArr == null || iArr2 == null || iArr.length == iArr2.length;
        }
        return false;
    }

    public static Class<?>[] nullToEmpty(Class<?>[] clsArr) {
        if (clsArr == null || clsArr.length == 0) {
            return EMPTY_CLASS_ARRAY;
        }
        return clsArr;
    }

    public static byte[] remove(byte[] bArr, int i11) {
        return (byte[]) remove((Object) bArr, i11);
    }

    public static short[] removeAll(short[] sArr, int... iArr) {
        return (short[]) removeAll((Object) sArr, clone(iArr));
    }

    public static void reverse(int[] iArr) {
        if (iArr != null) {
            reverse(iArr, 0, iArr.length);
        }
    }

    public static short[] clone(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        return (short[]) sArr.clone();
    }

    public static boolean contains(short[] sArr, short s11) {
        return indexOf(sArr, s11) != -1;
    }

    public static boolean isEmpty(short[] sArr) {
        return sArr == null || sArr.length == 0;
    }

    public static boolean isNotEmpty(short[] sArr) {
        return (sArr == null || sArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(short[] sArr, short[] sArr2) {
        if (sArr == null && sArr2 != null && sArr2.length > 0) {
            return false;
        }
        if (sArr2 != null || sArr == null || sArr.length <= 0) {
            return sArr == null || sArr2 == null || sArr.length == sArr2.length;
        }
        return false;
    }

    public static char[] remove(char[] cArr, int i11) {
        return (char[]) remove((Object) cArr, i11);
    }

    public static int[] removeAll(int[] iArr, int... iArr2) {
        return (int[]) removeAll((Object) iArr, clone(iArr2));
    }

    public static boolean[] removeElement(boolean[] zArr, boolean z11) {
        int indexOf = indexOf(zArr, z11);
        if (indexOf == -1) {
            return clone(zArr);
        }
        return remove(zArr, indexOf);
    }

    public static void reverse(short[] sArr) {
        if (sArr != null) {
            reverse(sArr, 0, sArr.length);
        }
    }

    public static char[] clone(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return (char[]) cArr.clone();
    }

    public static boolean contains(char[] cArr, char c11) {
        return indexOf(cArr, c11) != -1;
    }

    public static boolean isEmpty(char[] cArr) {
        return cArr == null || cArr.length == 0;
    }

    public static boolean isNotEmpty(char[] cArr) {
        return (cArr == null || cArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(char[] cArr, char[] cArr2) {
        if (cArr == null && cArr2 != null && cArr2.length > 0) {
            return false;
        }
        if (cArr2 != null || cArr == null || cArr.length <= 0) {
            return cArr == null || cArr2 == null || cArr.length == cArr2.length;
        }
        return false;
    }

    public static String[] nullToEmpty(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return EMPTY_STRING_ARRAY;
        }
        return strArr;
    }

    public static double[] remove(double[] dArr, int i11) {
        return (double[]) remove((Object) dArr, i11);
    }

    public static char[] removeAll(char[] cArr, int... iArr) {
        return (char[]) removeAll((Object) cArr, clone(iArr));
    }

    public static void reverse(char[] cArr) {
        if (cArr != null) {
            reverse(cArr, 0, cArr.length);
        }
    }

    public static boolean[] add(boolean[] zArr, boolean z11) {
        boolean[] zArr2 = (boolean[]) copyArrayGrow1(zArr, Boolean.TYPE);
        zArr2[zArr2.length - 1] = z11;
        return zArr2;
    }

    public static byte[] clone(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public static boolean contains(byte[] bArr, byte b11) {
        return indexOf(bArr, b11) != -1;
    }

    public static boolean isEmpty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static boolean isNotEmpty(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(byte[] bArr, byte[] bArr2) {
        if (bArr == null && bArr2 != null && bArr2.length > 0) {
            return false;
        }
        if (bArr2 != null || bArr == null || bArr.length <= 0) {
            return bArr == null || bArr2 == null || bArr.length == bArr2.length;
        }
        return false;
    }

    public static float[] remove(float[] fArr, int i11) {
        return (float[]) remove((Object) fArr, i11);
    }

    public static long[] removeAll(long[] jArr, int... iArr) {
        return (long[]) removeAll((Object) jArr, clone(iArr));
    }

    public static void reverse(byte[] bArr) {
        if (bArr != null) {
            reverse(bArr, 0, bArr.length);
        }
    }

    public static Long[] toObject(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        if (jArr.length == 0) {
            return EMPTY_LONG_OBJECT_ARRAY;
        }
        Long[] lArr = new Long[jArr.length];
        for (int i11 = 0; i11 < jArr.length; i11++) {
            lArr[i11] = Long.valueOf(jArr[i11]);
        }
        return lArr;
    }

    public static char[] toPrimitive(Character[] chArr, char c11) {
        char c12;
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[chArr.length];
        for (int i11 = 0; i11 < chArr.length; i11++) {
            Character ch2 = chArr[i11];
            if (ch2 == null) {
                c12 = c11;
            } else {
                c12 = ch2.charValue();
            }
            cArr[i11] = c12;
        }
        return cArr;
    }

    public static double[] clone(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        return (double[]) dArr.clone();
    }

    public static boolean contains(double[] dArr, double d11) {
        return indexOf(dArr, d11) != -1;
    }

    public static int indexOf(long[] jArr, long j11) {
        return indexOf(jArr, j11, 0);
    }

    public static boolean isEmpty(double[] dArr) {
        return dArr == null || dArr.length == 0;
    }

    public static boolean isNotEmpty(double[] dArr) {
        return (dArr == null || dArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(double[] dArr, double[] dArr2) {
        if (dArr == null && dArr2 != null && dArr2.length > 0) {
            return false;
        }
        if (dArr2 != null || dArr == null || dArr.length <= 0) {
            return dArr == null || dArr2 == null || dArr.length == dArr2.length;
        }
        return false;
    }

    public static int lastIndexOf(long[] jArr, long j11) {
        return lastIndexOf(jArr, j11, Integer.MAX_VALUE);
    }

    public static long[] nullToEmpty(long[] jArr) {
        if (jArr == null || jArr.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        return jArr;
    }

    public static int[] remove(int[] iArr, int i11) {
        return (int[]) remove((Object) iArr, i11);
    }

    public static float[] removeAll(float[] fArr, int... iArr) {
        return (float[]) removeAll((Object) fArr, clone(iArr));
    }

    public static byte[] removeElement(byte[] bArr, byte b11) {
        int indexOf = indexOf(bArr, b11);
        if (indexOf == -1) {
            return clone(bArr);
        }
        return remove(bArr, indexOf);
    }

    public static void reverse(double[] dArr) {
        if (dArr != null) {
            reverse(dArr, 0, dArr.length);
        }
    }

    public static long[] subarray(long[] jArr, int i11, int i12) {
        if (jArr == null) {
            return null;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        if (i12 > jArr.length) {
            i12 = jArr.length;
        }
        int i13 = i12 - i11;
        if (i13 <= 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] jArr2 = new long[i13];
        System.arraycopy(jArr, i11, jArr2, 0, i13);
        return jArr2;
    }

    public static byte[] add(byte[] bArr, byte b11) {
        byte[] bArr2 = (byte[]) copyArrayGrow1(bArr, Byte.TYPE);
        bArr2[bArr2.length - 1] = b11;
        return bArr2;
    }

    public static float[] clone(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        return (float[]) fArr.clone();
    }

    public static boolean contains(double[] dArr, double d11, double d12) {
        return indexOf(dArr, d11, 0, d12) != -1;
    }

    public static int indexOf(long[] jArr, long j11, int i11) {
        if (jArr == null) {
            return -1;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < jArr.length) {
            if (j11 == jArr[i11]) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static boolean isEmpty(float[] fArr) {
        return fArr == null || fArr.length == 0;
    }

    public static boolean isNotEmpty(float[] fArr) {
        return (fArr == null || fArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(float[] fArr, float[] fArr2) {
        if (fArr == null && fArr2 != null && fArr2.length > 0) {
            return false;
        }
        if (fArr2 != null || fArr == null || fArr.length <= 0) {
            return fArr == null || fArr2 == null || fArr.length == fArr2.length;
        }
        return false;
    }

    public static int lastIndexOf(long[] jArr, long j11, int i11) {
        if (jArr == null || i11 < 0) {
            return -1;
        }
        if (i11 >= jArr.length) {
            i11 = jArr.length - 1;
        }
        while (i11 >= 0) {
            if (j11 == jArr[i11]) {
                return i11;
            }
            i11--;
        }
        return -1;
    }

    public static long[] remove(long[] jArr, int i11) {
        return (long[]) remove((Object) jArr, i11);
    }

    public static double[] removeAll(double[] dArr, int... iArr) {
        return (double[]) removeAll((Object) dArr, clone(iArr));
    }

    public static void reverse(float[] fArr) {
        if (fArr != null) {
            reverse(fArr, 0, fArr.length);
        }
    }

    public static boolean[] clone(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        return (boolean[]) zArr.clone();
    }

    public static boolean contains(float[] fArr, float f11) {
        return indexOf(fArr, f11) != -1;
    }

    public static boolean isEmpty(boolean[] zArr) {
        return zArr == null || zArr.length == 0;
    }

    public static boolean isNotEmpty(boolean[] zArr) {
        return (zArr == null || zArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(boolean[] zArr, boolean[] zArr2) {
        if (zArr == null && zArr2 != null && zArr2.length > 0) {
            return false;
        }
        if (zArr2 != null || zArr == null || zArr.length <= 0) {
            return zArr == null || zArr2 == null || zArr.length == zArr2.length;
        }
        return false;
    }

    public static int[] nullToEmpty(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        return iArr;
    }

    public static short[] remove(short[] sArr, int i11) {
        return (short[]) remove((Object) sArr, i11);
    }

    public static boolean[] removeAll(boolean[] zArr, int... iArr) {
        return (boolean[]) removeAll((Object) zArr, clone(iArr));
    }

    public static void reverse(boolean[] zArr) {
        if (zArr != null) {
            reverse(zArr, 0, zArr.length);
        }
    }

    public static char[] add(char[] cArr, char c11) {
        char[] cArr2 = (char[]) copyArrayGrow1(cArr, Character.TYPE);
        cArr2[cArr2.length - 1] = c11;
        return cArr2;
    }

    public static boolean contains(boolean[] zArr, boolean z11) {
        return indexOf(zArr, z11) != -1;
    }

    public static int indexOf(int[] iArr, int i11) {
        return indexOf(iArr, i11, 0);
    }

    private static Object remove(Object obj, int i11) {
        int length = getLength(obj);
        if (i11 < 0 || i11 >= length) {
            throw new IndexOutOfBoundsException("Index: " + i11 + ", Length: " + length);
        }
        int i12 = length - 1;
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), i12);
        System.arraycopy(obj, 0, newInstance, 0, i11);
        if (i11 < i12) {
            System.arraycopy(obj, i11 + 1, newInstance, i11, (length - i11) - 1);
        }
        return newInstance;
    }

    public static Object removeAll(Object obj, int... iArr) {
        int i11;
        int i12;
        int length = getLength(obj);
        if (isNotEmpty(iArr)) {
            Arrays.sort(iArr);
            int length2 = iArr.length;
            int i13 = length;
            i11 = 0;
            while (true) {
                length2--;
                if (length2 < 0) {
                    break;
                }
                i12 = iArr[length2];
                if (i12 < 0 || i12 >= length) {
                } else if (i12 < i13) {
                    i11++;
                    i13 = i12;
                }
            }
            throw new IndexOutOfBoundsException("Index: " + i12 + ", Length: " + length);
        }
        i11 = 0;
        int i14 = length - i11;
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), i14);
        if (i11 < length) {
            int length3 = iArr.length - 1;
            while (length3 >= 0) {
                int i15 = iArr[length3];
                int i16 = length - i15;
                if (i16 > 1) {
                    int i17 = i16 - 1;
                    i14 -= i17;
                    System.arraycopy(obj, i15 + 1, newInstance, i14, i17);
                }
                length3--;
                length = i15;
            }
            if (length > 0) {
                System.arraycopy(obj, 0, newInstance, 0, length);
            }
        }
        return newInstance;
    }

    public static char[] removeElement(char[] cArr, char c11) {
        int indexOf = indexOf(cArr, c11);
        if (indexOf == -1) {
            return clone(cArr);
        }
        return remove(cArr, indexOf);
    }

    public static void reverse(boolean[] zArr, int i11, int i12) {
        if (zArr != null) {
            if (i11 < 0) {
                i11 = 0;
            }
            int min = Math.min(zArr.length, i12) - 1;
            while (min > i11) {
                boolean z11 = zArr[min];
                zArr[min] = zArr[i11];
                zArr[i11] = z11;
                min--;
                i11++;
            }
        }
    }

    public static boolean[] addAll(boolean[] zArr, boolean... zArr2) {
        if (zArr == null) {
            return clone(zArr2);
        }
        if (zArr2 == null) {
            return clone(zArr);
        }
        boolean[] zArr3 = new boolean[(zArr.length + zArr2.length)];
        System.arraycopy(zArr, 0, zArr3, 0, zArr.length);
        System.arraycopy(zArr2, 0, zArr3, zArr.length, zArr2.length);
        return zArr3;
    }

    public static int indexOf(int[] iArr, int i11, int i12) {
        if (iArr == null) {
            return -1;
        }
        if (i12 < 0) {
            i12 = 0;
        }
        while (i12 < iArr.length) {
            if (i11 == iArr[i12]) {
                return i12;
            }
            i12++;
        }
        return -1;
    }

    public static int lastIndexOf(int[] iArr, int i11) {
        return lastIndexOf(iArr, i11, Integer.MAX_VALUE);
    }

    public static short[] nullToEmpty(short[] sArr) {
        if (sArr == null || sArr.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        return sArr;
    }

    public static Integer[] toObject(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        if (iArr.length == 0) {
            return EMPTY_INTEGER_OBJECT_ARRAY;
        }
        Integer[] numArr = new Integer[iArr.length];
        for (int i11 = 0; i11 < iArr.length; i11++) {
            numArr[i11] = Integer.valueOf(iArr[i11]);
        }
        return numArr;
    }

    public static double[] add(double[] dArr, double d11) {
        double[] dArr2 = (double[]) copyArrayGrow1(dArr, Double.TYPE);
        dArr2[dArr2.length - 1] = d11;
        return dArr2;
    }

    public static int lastIndexOf(int[] iArr, int i11, int i12) {
        if (iArr == null || i12 < 0) {
            return -1;
        }
        if (i12 >= iArr.length) {
            i12 = iArr.length - 1;
        }
        while (i12 >= 0) {
            if (i11 == iArr[i12]) {
                return i12;
            }
            i12--;
        }
        return -1;
    }

    public static int[] subarray(int[] iArr, int i11, int i12) {
        if (iArr == null) {
            return null;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        if (i12 > iArr.length) {
            i12 = iArr.length;
        }
        int i13 = i12 - i11;
        if (i13 <= 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr2 = new int[i13];
        System.arraycopy(iArr, i11, iArr2, 0, i13);
        return iArr2;
    }

    public static long[] toPrimitive(Long[] lArr) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] jArr = new long[lArr.length];
        for (int i11 = 0; i11 < lArr.length; i11++) {
            jArr[i11] = lArr[i11].longValue();
        }
        return jArr;
    }

    public static int indexOf(short[] sArr, short s11) {
        return indexOf(sArr, s11, 0);
    }

    public static char[] nullToEmpty(char[] cArr) {
        if (cArr == null || cArr.length == 0) {
            return EMPTY_CHAR_ARRAY;
        }
        return cArr;
    }

    public static double[] removeElement(double[] dArr, double d11) {
        int indexOf = indexOf(dArr, d11);
        if (indexOf == -1) {
            return clone(dArr);
        }
        return remove(dArr, indexOf);
    }

    public static float[] add(float[] fArr, float f11) {
        float[] fArr2 = (float[]) copyArrayGrow1(fArr, Float.TYPE);
        fArr2[fArr2.length - 1] = f11;
        return fArr2;
    }

    public static int indexOf(short[] sArr, short s11, int i11) {
        if (sArr == null) {
            return -1;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < sArr.length) {
            if (s11 == sArr[i11]) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static void reverse(byte[] bArr, int i11, int i12) {
        if (bArr != null) {
            if (i11 < 0) {
                i11 = 0;
            }
            int min = Math.min(bArr.length, i12) - 1;
            while (min > i11) {
                byte b11 = bArr[min];
                bArr[min] = bArr[i11];
                bArr[i11] = b11;
                min--;
                i11++;
            }
        }
    }

    public static int lastIndexOf(short[] sArr, short s11) {
        return lastIndexOf(sArr, s11, Integer.MAX_VALUE);
    }

    public static byte[] nullToEmpty(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        return bArr;
    }

    public static byte[] removeElements(byte[] bArr, byte... bArr2) {
        if (isEmpty(bArr) || isEmpty(bArr2)) {
            return clone(bArr);
        }
        HashMap hashMap = new HashMap(bArr2.length);
        for (byte valueOf : bArr2) {
            Byte valueOf2 = Byte.valueOf(valueOf);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf2);
            if (mutableInt == null) {
                hashMap.put(valueOf2, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        BitSet bitSet = new BitSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Byte b11 = (Byte) entry.getKey();
            int intValue = ((MutableInt) entry.getValue()).intValue();
            int i11 = 0;
            int i12 = 0;
            while (i11 < intValue) {
                int indexOf = indexOf(bArr, b11.byteValue(), i12);
                if (indexOf < 0) {
                    break;
                }
                bitSet.set(indexOf);
                i11++;
                i12 = indexOf + 1;
            }
        }
        return (byte[]) removeAll((Object) bArr, bitSet);
    }

    public static int[] add(int[] iArr, int i11) {
        int[] iArr2 = (int[]) copyArrayGrow1(iArr, Integer.TYPE);
        iArr2[iArr2.length - 1] = i11;
        return iArr2;
    }

    public static char[] addAll(char[] cArr, char... cArr2) {
        if (cArr == null) {
            return clone(cArr2);
        }
        if (cArr2 == null) {
            return clone(cArr);
        }
        char[] cArr3 = new char[(cArr.length + cArr2.length)];
        System.arraycopy(cArr, 0, cArr3, 0, cArr.length);
        System.arraycopy(cArr2, 0, cArr3, cArr.length, cArr2.length);
        return cArr3;
    }

    public static int indexOf(char[] cArr, char c11) {
        return indexOf(cArr, c11, 0);
    }

    public static int lastIndexOf(short[] sArr, short s11, int i11) {
        if (sArr == null || i11 < 0) {
            return -1;
        }
        if (i11 >= sArr.length) {
            i11 = sArr.length - 1;
        }
        while (i11 >= 0) {
            if (s11 == sArr[i11]) {
                return i11;
            }
            i11--;
        }
        return -1;
    }

    public static float[] removeElement(float[] fArr, float f11) {
        int indexOf = indexOf(fArr, f11);
        if (indexOf == -1) {
            return clone(fArr);
        }
        return remove(fArr, indexOf);
    }

    public static Short[] toObject(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        if (sArr.length == 0) {
            return EMPTY_SHORT_OBJECT_ARRAY;
        }
        Short[] shArr = new Short[sArr.length];
        for (int i11 = 0; i11 < sArr.length; i11++) {
            shArr[i11] = Short.valueOf(sArr[i11]);
        }
        return shArr;
    }

    public static int indexOf(char[] cArr, char c11, int i11) {
        if (cArr == null) {
            return -1;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < cArr.length) {
            if (c11 == cArr[i11]) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static double[] nullToEmpty(double[] dArr) {
        if (dArr == null || dArr.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        return dArr;
    }

    public static short[] subarray(short[] sArr, int i11, int i12) {
        if (sArr == null) {
            return null;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        if (i12 > sArr.length) {
            i12 = sArr.length;
        }
        int i13 = i12 - i11;
        if (i13 <= 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArr2 = new short[i13];
        System.arraycopy(sArr, i11, sArr2, 0, i13);
        return sArr2;
    }

    public static long[] toPrimitive(Long[] lArr, long j11) {
        long j12;
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] jArr = new long[lArr.length];
        for (int i11 = 0; i11 < lArr.length; i11++) {
            Long l11 = lArr[i11];
            if (l11 == null) {
                j12 = j11;
            } else {
                j12 = l11.longValue();
            }
            jArr[i11] = j12;
        }
        return jArr;
    }

    public static long[] add(long[] jArr, long j11) {
        long[] jArr2 = (long[]) copyArrayGrow1(jArr, Long.TYPE);
        jArr2[jArr2.length - 1] = j11;
        return jArr2;
    }

    public static void reverse(char[] cArr, int i11, int i12) {
        if (cArr != null) {
            if (i11 < 0) {
                i11 = 0;
            }
            int min = Math.min(cArr.length, i12) - 1;
            while (min > i11) {
                char c11 = cArr[min];
                cArr[min] = cArr[i11];
                cArr[i11] = c11;
                min--;
                i11++;
            }
        }
    }

    public static int indexOf(byte[] bArr, byte b11) {
        return indexOf(bArr, b11, 0);
    }

    public static int lastIndexOf(char[] cArr, char c11) {
        return lastIndexOf(cArr, c11, Integer.MAX_VALUE);
    }

    public static float[] nullToEmpty(float[] fArr) {
        if (fArr == null || fArr.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        return fArr;
    }

    public static int[] removeElement(int[] iArr, int i11) {
        int indexOf = indexOf(iArr, i11);
        if (indexOf == -1) {
            return clone(iArr);
        }
        return remove(iArr, indexOf);
    }

    public static short[] add(short[] sArr, short s11) {
        short[] sArr2 = (short[]) copyArrayGrow1(sArr, Short.TYPE);
        sArr2[sArr2.length - 1] = s11;
        return sArr2;
    }

    public static int indexOf(byte[] bArr, byte b11, int i11) {
        if (bArr == null) {
            return -1;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < bArr.length) {
            if (b11 == bArr[i11]) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static int lastIndexOf(char[] cArr, char c11, int i11) {
        if (cArr == null || i11 < 0) {
            return -1;
        }
        if (i11 >= cArr.length) {
            i11 = cArr.length - 1;
        }
        while (i11 >= 0) {
            if (c11 == cArr[i11]) {
                return i11;
            }
            i11--;
        }
        return -1;
    }

    public static byte[] addAll(byte[] bArr, byte... bArr2) {
        if (bArr == null) {
            return clone(bArr2);
        }
        if (bArr2 == null) {
            return clone(bArr);
        }
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static boolean[] nullToEmpty(boolean[] zArr) {
        if (zArr == null || zArr.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        return zArr;
    }

    public static Object removeAll(Object obj, BitSet bitSet) {
        int length = getLength(obj);
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length - bitSet.cardinality());
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int nextSetBit = bitSet.nextSetBit(i11);
            if (nextSetBit == -1) {
                break;
            }
            int i13 = nextSetBit - i11;
            if (i13 > 0) {
                System.arraycopy(obj, i11, newInstance, i12, i13);
                i12 += i13;
            }
            i11 = bitSet.nextClearBit(nextSetBit);
        }
        int i14 = length - i11;
        if (i14 > 0) {
            System.arraycopy(obj, i11, newInstance, i12, i14);
        }
        return newInstance;
    }

    public static Byte[] toObject(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return EMPTY_BYTE_OBJECT_ARRAY;
        }
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i11 = 0; i11 < bArr.length; i11++) {
            bArr2[i11] = Byte.valueOf(bArr[i11]);
        }
        return bArr2;
    }

    public static <T> T[] add(T[] tArr, int i11, T t11) {
        Class<?> cls;
        if (tArr != null) {
            cls = tArr.getClass().getComponentType();
        } else if (t11 != null) {
            cls = t11.getClass();
        } else {
            throw new IllegalArgumentException("Array and element cannot both be null");
        }
        return (Object[]) add(tArr, i11, t11, cls);
    }

    public static int indexOf(double[] dArr, double d11) {
        return indexOf(dArr, d11, 0);
    }

    public static long[] removeElement(long[] jArr, long j11) {
        int indexOf = indexOf(jArr, j11);
        if (indexOf == -1) {
            return clone(jArr);
        }
        return remove(jArr, indexOf);
    }

    public static void reverse(double[] dArr, int i11, int i12) {
        if (dArr != null) {
            if (i11 < 0) {
                i11 = 0;
            }
            int min = Math.min(dArr.length, i12) - 1;
            while (min > i11) {
                double d11 = dArr[min];
                dArr[min] = dArr[i11];
                dArr[i11] = d11;
                min--;
                i11++;
            }
        }
    }

    public static char[] subarray(char[] cArr, int i11, int i12) {
        if (cArr == null) {
            return null;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        if (i12 > cArr.length) {
            i12 = cArr.length;
        }
        int i13 = i12 - i11;
        if (i13 <= 0) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] cArr2 = new char[i13];
        System.arraycopy(cArr, i11, cArr2, 0, i13);
        return cArr2;
    }

    public static int indexOf(double[] dArr, double d11, double d12) {
        return indexOf(dArr, d11, 0, d12);
    }

    public static int lastIndexOf(byte[] bArr, byte b11) {
        return lastIndexOf(bArr, b11, Integer.MAX_VALUE);
    }

    public static Long[] nullToEmpty(Long[] lArr) {
        if (lArr == null || lArr.length == 0) {
            return EMPTY_LONG_OBJECT_ARRAY;
        }
        return lArr;
    }

    public static int[] toPrimitive(Integer[] numArr) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr = new int[numArr.length];
        for (int i11 = 0; i11 < numArr.length; i11++) {
            iArr[i11] = numArr[i11].intValue();
        }
        return iArr;
    }

    public static int indexOf(double[] dArr, double d11, int i11) {
        if (isEmpty(dArr)) {
            return -1;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < dArr.length) {
            if (d11 == dArr[i11]) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static int lastIndexOf(byte[] bArr, byte b11, int i11) {
        if (bArr == null || i11 < 0) {
            return -1;
        }
        if (i11 >= bArr.length) {
            i11 = bArr.length - 1;
        }
        while (i11 >= 0) {
            if (b11 == bArr[i11]) {
                return i11;
            }
            i11--;
        }
        return -1;
    }

    public static Integer[] nullToEmpty(Integer[] numArr) {
        if (numArr == null || numArr.length == 0) {
            return EMPTY_INTEGER_OBJECT_ARRAY;
        }
        return numArr;
    }

    public static short[] removeElement(short[] sArr, short s11) {
        int indexOf = indexOf(sArr, s11);
        if (indexOf == -1) {
            return clone(sArr);
        }
        return remove(sArr, indexOf);
    }

    public static boolean[] add(boolean[] zArr, int i11, boolean z11) {
        return (boolean[]) add(zArr, i11, Boolean.valueOf(z11), Boolean.TYPE);
    }

    public static short[] addAll(short[] sArr, short... sArr2) {
        if (sArr == null) {
            return clone(sArr2);
        }
        if (sArr2 == null) {
            return clone(sArr);
        }
        short[] sArr3 = new short[(sArr.length + sArr2.length)];
        System.arraycopy(sArr, 0, sArr3, 0, sArr.length);
        System.arraycopy(sArr2, 0, sArr3, sArr.length, sArr2.length);
        return sArr3;
    }

    public static void reverse(float[] fArr, int i11, int i12) {
        if (fArr != null) {
            if (i11 < 0) {
                i11 = 0;
            }
            int min = Math.min(fArr.length, i12) - 1;
            while (min > i11) {
                float f11 = fArr[min];
                fArr[min] = fArr[i11];
                fArr[i11] = f11;
                min--;
                i11++;
            }
        }
    }

    public static Double[] toObject(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return EMPTY_DOUBLE_OBJECT_ARRAY;
        }
        Double[] dArr2 = new Double[dArr.length];
        for (int i11 = 0; i11 < dArr.length; i11++) {
            dArr2[i11] = Double.valueOf(dArr[i11]);
        }
        return dArr2;
    }

    public static char[] add(char[] cArr, int i11, char c11) {
        return (char[]) add(cArr, i11, Character.valueOf(c11), Character.TYPE);
    }

    public static int indexOf(double[] dArr, double d11, int i11, double d12) {
        if (isEmpty(dArr)) {
            return -1;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        double d13 = d11 - d12;
        double d14 = d11 + d12;
        while (i11 < dArr.length) {
            double d15 = dArr[i11];
            if (d15 >= d13 && d15 <= d14) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static int lastIndexOf(double[] dArr, double d11) {
        return lastIndexOf(dArr, d11, Integer.MAX_VALUE);
    }

    public static Short[] nullToEmpty(Short[] shArr) {
        if (shArr == null || shArr.length == 0) {
            return EMPTY_SHORT_OBJECT_ARRAY;
        }
        return shArr;
    }

    public static byte[] subarray(byte[] bArr, int i11, int i12) {
        if (bArr == null) {
            return null;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        if (i12 > bArr.length) {
            i12 = bArr.length;
        }
        int i13 = i12 - i11;
        if (i13 <= 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[i13];
        System.arraycopy(bArr, i11, bArr2, 0, i13);
        return bArr2;
    }

    public static byte[] add(byte[] bArr, int i11, byte b11) {
        return (byte[]) add(bArr, i11, Byte.valueOf(b11), Byte.TYPE);
    }

    public static int lastIndexOf(double[] dArr, double d11, double d12) {
        return lastIndexOf(dArr, d11, Integer.MAX_VALUE, d12);
    }

    public static int[] toPrimitive(Integer[] numArr, int i11) {
        int i12;
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr = new int[numArr.length];
        for (int i13 = 0; i13 < numArr.length; i13++) {
            Integer num = numArr[i13];
            if (num == null) {
                i12 = i11;
            } else {
                i12 = num.intValue();
            }
            iArr[i13] = i12;
        }
        return iArr;
    }

    public static short[] add(short[] sArr, int i11, short s11) {
        return (short[]) add(sArr, i11, Short.valueOf(s11), Short.TYPE);
    }

    public static int lastIndexOf(double[] dArr, double d11, int i11) {
        if (isEmpty(dArr) || i11 < 0) {
            return -1;
        }
        if (i11 >= dArr.length) {
            i11 = dArr.length - 1;
        }
        while (i11 >= 0) {
            if (d11 == dArr[i11]) {
                return i11;
            }
            i11--;
        }
        return -1;
    }

    public static Character[] nullToEmpty(Character[] chArr) {
        if (chArr == null || chArr.length == 0) {
            return EMPTY_CHARACTER_OBJECT_ARRAY;
        }
        return chArr;
    }

    public static int[] add(int[] iArr, int i11, int i12) {
        return (int[]) add(iArr, i11, Integer.valueOf(i12), Integer.TYPE);
    }

    public static int indexOf(float[] fArr, float f11) {
        return indexOf(fArr, f11, 0);
    }

    public static short[] removeElements(short[] sArr, short... sArr2) {
        if (isEmpty(sArr) || isEmpty(sArr2)) {
            return clone(sArr);
        }
        HashMap hashMap = new HashMap(sArr2.length);
        for (short valueOf : sArr2) {
            Short valueOf2 = Short.valueOf(valueOf);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf2);
            if (mutableInt == null) {
                hashMap.put(valueOf2, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        BitSet bitSet = new BitSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Short sh2 = (Short) entry.getKey();
            int intValue = ((MutableInt) entry.getValue()).intValue();
            int i11 = 0;
            int i12 = 0;
            while (i11 < intValue) {
                int indexOf = indexOf(sArr, sh2.shortValue(), i12);
                if (indexOf < 0) {
                    break;
                }
                bitSet.set(indexOf);
                i11++;
                i12 = indexOf + 1;
            }
        }
        return (short[]) removeAll((Object) sArr, bitSet);
    }

    public static void reverse(int[] iArr, int i11, int i12) {
        if (iArr != null) {
            if (i11 < 0) {
                i11 = 0;
            }
            int min = Math.min(iArr.length, i12) - 1;
            while (min > i11) {
                int i13 = iArr[min];
                iArr[min] = iArr[i11];
                iArr[i11] = i13;
                min--;
                i11++;
            }
        }
    }

    public static long[] add(long[] jArr, int i11, long j11) {
        return (long[]) add(jArr, i11, Long.valueOf(j11), Long.TYPE);
    }

    public static int[] addAll(int[] iArr, int... iArr2) {
        if (iArr == null) {
            return clone(iArr2);
        }
        if (iArr2 == null) {
            return clone(iArr);
        }
        int[] iArr3 = new int[(iArr.length + iArr2.length)];
        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
        return iArr3;
    }

    public static int indexOf(float[] fArr, float f11, int i11) {
        if (isEmpty(fArr)) {
            return -1;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < fArr.length) {
            if (f11 == fArr[i11]) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static Byte[] nullToEmpty(Byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return EMPTY_BYTE_OBJECT_ARRAY;
        }
        return bArr;
    }

    public static Float[] toObject(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return EMPTY_FLOAT_OBJECT_ARRAY;
        }
        Float[] fArr2 = new Float[fArr.length];
        for (int i11 = 0; i11 < fArr.length; i11++) {
            fArr2[i11] = Float.valueOf(fArr[i11]);
        }
        return fArr2;
    }

    public static float[] add(float[] fArr, int i11, float f11) {
        return (float[]) add(fArr, i11, Float.valueOf(f11), Float.TYPE);
    }

    public static double[] subarray(double[] dArr, int i11, int i12) {
        if (dArr == null) {
            return null;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        if (i12 > dArr.length) {
            i12 = dArr.length;
        }
        int i13 = i12 - i11;
        if (i13 <= 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] dArr2 = new double[i13];
        System.arraycopy(dArr, i11, dArr2, 0, i13);
        return dArr2;
    }

    public static double[] add(double[] dArr, int i11, double d11) {
        return (double[]) add(dArr, i11, Double.valueOf(d11), Double.TYPE);
    }

    public static int lastIndexOf(double[] dArr, double d11, int i11, double d12) {
        if (isEmpty(dArr) || i11 < 0) {
            return -1;
        }
        if (i11 >= dArr.length) {
            i11 = dArr.length - 1;
        }
        double d13 = d11 - d12;
        double d14 = d11 + d12;
        while (i11 >= 0) {
            double d15 = dArr[i11];
            if (d15 >= d13 && d15 <= d14) {
                return i11;
            }
            i11--;
        }
        return -1;
    }

    public static Double[] nullToEmpty(Double[] dArr) {
        if (dArr == null || dArr.length == 0) {
            return EMPTY_DOUBLE_OBJECT_ARRAY;
        }
        return dArr;
    }

    private static Object add(Object obj, int i11, Object obj2, Class<?> cls) {
        if (obj != null) {
            int length = Array.getLength(obj);
            if (i11 > length || i11 < 0) {
                throw new IndexOutOfBoundsException("Index: " + i11 + ", Length: " + length);
            }
            Object newInstance = Array.newInstance(cls, length + 1);
            System.arraycopy(obj, 0, newInstance, 0, i11);
            Array.set(newInstance, i11, obj2);
            if (i11 < length) {
                System.arraycopy(obj, i11, newInstance, i11 + 1, length - i11);
            }
            return newInstance;
        } else if (i11 == 0) {
            Object newInstance2 = Array.newInstance(cls, 1);
            Array.set(newInstance2, 0, obj2);
            return newInstance2;
        } else {
            throw new IndexOutOfBoundsException("Index: " + i11 + ", Length: 0");
        }
    }

    public static int indexOf(boolean[] zArr, boolean z11) {
        return indexOf(zArr, z11, 0);
    }

    public static void reverse(long[] jArr, int i11, int i12) {
        if (jArr != null) {
            if (i11 < 0) {
                i11 = 0;
            }
            int min = Math.min(jArr.length, i12) - 1;
            while (min > i11) {
                long j11 = jArr[min];
                jArr[min] = jArr[i11];
                jArr[i11] = j11;
                min--;
                i11++;
            }
        }
    }

    public static short[] toPrimitive(Short[] shArr) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArr = new short[shArr.length];
        for (int i11 = 0; i11 < shArr.length; i11++) {
            sArr[i11] = shArr[i11].shortValue();
        }
        return sArr;
    }

    public static int indexOf(boolean[] zArr, boolean z11, int i11) {
        if (isEmpty(zArr)) {
            return -1;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < zArr.length) {
            if (z11 == zArr[i11]) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static Float[] nullToEmpty(Float[] fArr) {
        if (fArr == null || fArr.length == 0) {
            return EMPTY_FLOAT_OBJECT_ARRAY;
        }
        return fArr;
    }

    public static long[] addAll(long[] jArr, long... jArr2) {
        if (jArr == null) {
            return clone(jArr2);
        }
        if (jArr2 == null) {
            return clone(jArr);
        }
        long[] jArr3 = new long[(jArr.length + jArr2.length)];
        System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
        System.arraycopy(jArr2, 0, jArr3, jArr.length, jArr2.length);
        return jArr3;
    }

    public static Boolean[] toObject(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        if (zArr.length == 0) {
            return EMPTY_BOOLEAN_OBJECT_ARRAY;
        }
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i11 = 0; i11 < zArr.length; i11++) {
            boolArr[i11] = zArr[i11] ? Boolean.TRUE : Boolean.FALSE;
        }
        return boolArr;
    }

    public static int lastIndexOf(float[] fArr, float f11) {
        return lastIndexOf(fArr, f11, Integer.MAX_VALUE);
    }

    public static Boolean[] nullToEmpty(Boolean[] boolArr) {
        if (boolArr == null || boolArr.length == 0) {
            return EMPTY_BOOLEAN_OBJECT_ARRAY;
        }
        return boolArr;
    }

    public static float[] subarray(float[] fArr, int i11, int i12) {
        if (fArr == null) {
            return null;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        if (i12 > fArr.length) {
            i12 = fArr.length;
        }
        int i13 = i12 - i11;
        if (i13 <= 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] fArr2 = new float[i13];
        System.arraycopy(fArr, i11, fArr2, 0, i13);
        return fArr2;
    }

    public static int lastIndexOf(float[] fArr, float f11, int i11) {
        if (isEmpty(fArr) || i11 < 0) {
            return -1;
        }
        if (i11 >= fArr.length) {
            i11 = fArr.length - 1;
        }
        while (i11 >= 0) {
            if (f11 == fArr[i11]) {
                return i11;
            }
            i11--;
        }
        return -1;
    }

    public static void reverse(Object[] objArr, int i11, int i12) {
        if (objArr != null) {
            if (i11 < 0) {
                i11 = 0;
            }
            int min = Math.min(objArr.length, i12) - 1;
            while (min > i11) {
                Object obj = objArr[min];
                objArr[min] = objArr[i11];
                objArr[i11] = obj;
                min--;
                i11++;
            }
        }
    }

    public static short[] toPrimitive(Short[] shArr, short s11) {
        short s12;
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArr = new short[shArr.length];
        for (int i11 = 0; i11 < shArr.length; i11++) {
            Short sh2 = shArr[i11];
            if (sh2 == null) {
                s12 = s11;
            } else {
                s12 = sh2.shortValue();
            }
            sArr[i11] = s12;
        }
        return sArr;
    }

    public static float[] addAll(float[] fArr, float... fArr2) {
        if (fArr == null) {
            return clone(fArr2);
        }
        if (fArr2 == null) {
            return clone(fArr);
        }
        float[] fArr3 = new float[(fArr.length + fArr2.length)];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        return fArr3;
    }

    public static int lastIndexOf(boolean[] zArr, boolean z11) {
        return lastIndexOf(zArr, z11, Integer.MAX_VALUE);
    }

    public static void reverse(short[] sArr, int i11, int i12) {
        if (sArr != null) {
            if (i11 < 0) {
                i11 = 0;
            }
            int min = Math.min(sArr.length, i12) - 1;
            while (min > i11) {
                short s11 = sArr[min];
                sArr[min] = sArr[i11];
                sArr[i11] = s11;
                min--;
                i11++;
            }
        }
    }

    public static boolean[] subarray(boolean[] zArr, int i11, int i12) {
        if (zArr == null) {
            return null;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        if (i12 > zArr.length) {
            i12 = zArr.length;
        }
        int i13 = i12 - i11;
        if (i13 <= 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] zArr2 = new boolean[i13];
        System.arraycopy(zArr, i11, zArr2, 0, i13);
        return zArr2;
    }

    public static int lastIndexOf(boolean[] zArr, boolean z11, int i11) {
        if (isEmpty(zArr) || i11 < 0) {
            return -1;
        }
        if (i11 >= zArr.length) {
            i11 = zArr.length - 1;
        }
        while (i11 >= 0) {
            if (z11 == zArr[i11]) {
                return i11;
            }
            i11--;
        }
        return -1;
    }

    public static int[] removeElements(int[] iArr, int... iArr2) {
        if (isEmpty(iArr) || isEmpty(iArr2)) {
            return clone(iArr);
        }
        HashMap hashMap = new HashMap(iArr2.length);
        for (int valueOf : iArr2) {
            Integer valueOf2 = Integer.valueOf(valueOf);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf2);
            if (mutableInt == null) {
                hashMap.put(valueOf2, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        BitSet bitSet = new BitSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Integer num = (Integer) entry.getKey();
            int intValue = ((MutableInt) entry.getValue()).intValue();
            int i11 = 0;
            int i12 = 0;
            while (i11 < intValue) {
                int indexOf = indexOf(iArr, num.intValue(), i12);
                if (indexOf < 0) {
                    break;
                }
                bitSet.set(indexOf);
                i11++;
                i12 = indexOf + 1;
            }
        }
        return (int[]) removeAll((Object) iArr, bitSet);
    }

    public static byte[] toPrimitive(Byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i11 = 0; i11 < bArr.length; i11++) {
            bArr2[i11] = bArr[i11].byteValue();
        }
        return bArr2;
    }

    public static double[] addAll(double[] dArr, double... dArr2) {
        if (dArr == null) {
            return clone(dArr2);
        }
        if (dArr2 == null) {
            return clone(dArr);
        }
        double[] dArr3 = new double[(dArr.length + dArr2.length)];
        System.arraycopy(dArr, 0, dArr3, 0, dArr.length);
        System.arraycopy(dArr2, 0, dArr3, dArr.length, dArr2.length);
        return dArr3;
    }

    public static byte[] toPrimitive(Byte[] bArr, byte b11) {
        byte b12;
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i11 = 0; i11 < bArr.length; i11++) {
            Byte b13 = bArr[i11];
            if (b13 == null) {
                b12 = b11;
            } else {
                b12 = b13.byteValue();
            }
            bArr2[i11] = b12;
        }
        return bArr2;
    }

    public static double[] toPrimitive(Double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] dArr2 = new double[dArr.length];
        for (int i11 = 0; i11 < dArr.length; i11++) {
            dArr2[i11] = dArr[i11].doubleValue();
        }
        return dArr2;
    }

    public static char[] removeElements(char[] cArr, char... cArr2) {
        if (isEmpty(cArr) || isEmpty(cArr2)) {
            return clone(cArr);
        }
        HashMap hashMap = new HashMap(cArr2.length);
        for (char valueOf : cArr2) {
            Character valueOf2 = Character.valueOf(valueOf);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf2);
            if (mutableInt == null) {
                hashMap.put(valueOf2, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        BitSet bitSet = new BitSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Character ch2 = (Character) entry.getKey();
            int intValue = ((MutableInt) entry.getValue()).intValue();
            int i11 = 0;
            int i12 = 0;
            while (i11 < intValue) {
                int indexOf = indexOf(cArr, ch2.charValue(), i12);
                if (indexOf < 0) {
                    break;
                }
                bitSet.set(indexOf);
                i11++;
                i12 = indexOf + 1;
            }
        }
        return (char[]) removeAll((Object) cArr, bitSet);
    }

    public static double[] toPrimitive(Double[] dArr, double d11) {
        double d12;
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] dArr2 = new double[dArr.length];
        for (int i11 = 0; i11 < dArr.length; i11++) {
            Double d13 = dArr[i11];
            if (d13 == null) {
                d12 = d11;
            } else {
                d12 = d13.doubleValue();
            }
            dArr2[i11] = d12;
        }
        return dArr2;
    }

    public static float[] toPrimitive(Float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] fArr2 = new float[fArr.length];
        for (int i11 = 0; i11 < fArr.length; i11++) {
            fArr2[i11] = fArr[i11].floatValue();
        }
        return fArr2;
    }

    public static float[] toPrimitive(Float[] fArr, float f11) {
        float f12;
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] fArr2 = new float[fArr.length];
        for (int i11 = 0; i11 < fArr.length; i11++) {
            Float f13 = fArr[i11];
            if (f13 == null) {
                f12 = f11;
            } else {
                f12 = f13.floatValue();
            }
            fArr2[i11] = f12;
        }
        return fArr2;
    }

    public static long[] removeElements(long[] jArr, long... jArr2) {
        if (isEmpty(jArr) || isEmpty(jArr2)) {
            return clone(jArr);
        }
        HashMap hashMap = new HashMap(jArr2.length);
        for (long valueOf : jArr2) {
            Long valueOf2 = Long.valueOf(valueOf);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf2);
            if (mutableInt == null) {
                hashMap.put(valueOf2, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        BitSet bitSet = new BitSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Long l11 = (Long) entry.getKey();
            int intValue = ((MutableInt) entry.getValue()).intValue();
            int i11 = 0;
            int i12 = 0;
            while (i11 < intValue) {
                int indexOf = indexOf(jArr, l11.longValue(), i12);
                if (indexOf < 0) {
                    break;
                }
                bitSet.set(indexOf);
                i11++;
                i12 = indexOf + 1;
            }
        }
        return (long[]) removeAll((Object) jArr, bitSet);
    }

    public static boolean[] toPrimitive(Boolean[] boolArr) {
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i11 = 0; i11 < boolArr.length; i11++) {
            zArr[i11] = boolArr[i11].booleanValue();
        }
        return zArr;
    }

    public static boolean[] toPrimitive(Boolean[] boolArr, boolean z11) {
        boolean z12;
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i11 = 0; i11 < boolArr.length; i11++) {
            Boolean bool = boolArr[i11];
            if (bool == null) {
                z12 = z11;
            } else {
                z12 = bool.booleanValue();
            }
            zArr[i11] = z12;
        }
        return zArr;
    }

    public static float[] removeElements(float[] fArr, float... fArr2) {
        if (isEmpty(fArr) || isEmpty(fArr2)) {
            return clone(fArr);
        }
        HashMap hashMap = new HashMap(fArr2.length);
        for (float valueOf : fArr2) {
            Float valueOf2 = Float.valueOf(valueOf);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf2);
            if (mutableInt == null) {
                hashMap.put(valueOf2, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        BitSet bitSet = new BitSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Float f11 = (Float) entry.getKey();
            int intValue = ((MutableInt) entry.getValue()).intValue();
            int i11 = 0;
            int i12 = 0;
            while (i11 < intValue) {
                int indexOf = indexOf(fArr, f11.floatValue(), i12);
                if (indexOf < 0) {
                    break;
                }
                bitSet.set(indexOf);
                i11++;
                i12 = indexOf + 1;
            }
        }
        return (float[]) removeAll((Object) fArr, bitSet);
    }

    public static double[] removeElements(double[] dArr, double... dArr2) {
        if (isEmpty(dArr) || isEmpty(dArr2)) {
            return clone(dArr);
        }
        HashMap hashMap = new HashMap(dArr2.length);
        for (double valueOf : dArr2) {
            Double valueOf2 = Double.valueOf(valueOf);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf2);
            if (mutableInt == null) {
                hashMap.put(valueOf2, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        BitSet bitSet = new BitSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Double d11 = (Double) entry.getKey();
            int intValue = ((MutableInt) entry.getValue()).intValue();
            int i11 = 0;
            int i12 = 0;
            while (i11 < intValue) {
                int indexOf = indexOf(dArr, d11.doubleValue(), i12);
                if (indexOf < 0) {
                    break;
                }
                bitSet.set(indexOf);
                i11++;
                i12 = indexOf + 1;
            }
        }
        return (double[]) removeAll((Object) dArr, bitSet);
    }

    public static boolean[] removeElements(boolean[] zArr, boolean... zArr2) {
        if (isEmpty(zArr) || isEmpty(zArr2)) {
            return clone(zArr);
        }
        HashMap hashMap = new HashMap(2);
        for (boolean valueOf : zArr2) {
            Boolean valueOf2 = Boolean.valueOf(valueOf);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf2);
            if (mutableInt == null) {
                hashMap.put(valueOf2, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        BitSet bitSet = new BitSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Boolean bool = (Boolean) entry.getKey();
            int intValue = ((MutableInt) entry.getValue()).intValue();
            int i11 = 0;
            int i12 = 0;
            while (i11 < intValue) {
                int indexOf = indexOf(zArr, bool.booleanValue(), i12);
                if (indexOf < 0) {
                    break;
                }
                bitSet.set(indexOf);
                i11++;
                i12 = indexOf + 1;
            }
        }
        return (boolean[]) removeAll((Object) zArr, bitSet);
    }
}
