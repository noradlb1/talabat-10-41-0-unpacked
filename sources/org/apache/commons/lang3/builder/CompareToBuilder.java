package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Comparator;
import org.apache.commons.lang3.ArrayUtils;

public class CompareToBuilder implements Builder<Integer> {
    private int comparison = 0;

    private static void reflectionAppend(Object obj, Object obj2, Class<?> cls, CompareToBuilder compareToBuilder, boolean z11, String[] strArr) {
        Field[] declaredFields = cls.getDeclaredFields();
        AccessibleObject.setAccessible(declaredFields, true);
        for (int i11 = 0; i11 < declaredFields.length && compareToBuilder.comparison == 0; i11++) {
            Field field = declaredFields[i11];
            if (!ArrayUtils.contains((Object[]) strArr, (Object) field.getName()) && field.getName().indexOf(36) == -1 && ((z11 || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                try {
                    compareToBuilder.append(field.get(obj), field.get(obj2));
                } catch (IllegalAccessException unused) {
                    throw new InternalError("Unexpected IllegalAccessException");
                }
            }
        }
    }

    public static int reflectionCompare(Object obj, Object obj2) {
        return reflectionCompare(obj, obj2, false, (Class<?>) null, new String[0]);
    }

    public CompareToBuilder append(Object obj, Object obj2) {
        return append(obj, obj2, (Comparator<?>) null);
    }

    public CompareToBuilder appendSuper(int i11) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = i11;
        return this;
    }

    public int toComparison() {
        return this.comparison;
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z11) {
        return reflectionCompare(obj, obj2, z11, (Class<?>) null, new String[0]);
    }

    public CompareToBuilder append(Object obj, Object obj2, Comparator<?> comparator) {
        if (this.comparison != 0 || obj == obj2) {
            return this;
        }
        if (obj == null) {
            this.comparison = -1;
            return this;
        } else if (obj2 == null) {
            this.comparison = 1;
            return this;
        } else {
            if (obj.getClass().isArray()) {
                if (obj instanceof long[]) {
                    append((long[]) obj, (long[]) obj2);
                } else if (obj instanceof int[]) {
                    append((int[]) obj, (int[]) obj2);
                } else if (obj instanceof short[]) {
                    append((short[]) obj, (short[]) obj2);
                } else if (obj instanceof char[]) {
                    append((char[]) obj, (char[]) obj2);
                } else if (obj instanceof byte[]) {
                    append((byte[]) obj, (byte[]) obj2);
                } else if (obj instanceof double[]) {
                    append((double[]) obj, (double[]) obj2);
                } else if (obj instanceof float[]) {
                    append((float[]) obj, (float[]) obj2);
                } else if (obj instanceof boolean[]) {
                    append((boolean[]) obj, (boolean[]) obj2);
                } else {
                    append((Object[]) obj, (Object[]) obj2, comparator);
                }
            } else if (comparator == null) {
                this.comparison = ((Comparable) obj).compareTo(obj2);
            } else {
                this.comparison = comparator.compare(obj, obj2);
            }
            return this;
        }
    }

    public Integer build() {
        return Integer.valueOf(toComparison());
    }

    public static int reflectionCompare(Object obj, Object obj2, Collection<String> collection) {
        return reflectionCompare(obj, obj2, ReflectionToStringBuilder.toNoNullStringArray(collection));
    }

    public static int reflectionCompare(Object obj, Object obj2, String... strArr) {
        return reflectionCompare(obj, obj2, false, (Class<?>) null, strArr);
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z11, Class<?> cls, String... strArr) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null || obj2 == null) {
            throw null;
        }
        Class cls2 = obj.getClass();
        if (cls2.isInstance(obj2)) {
            CompareToBuilder compareToBuilder = new CompareToBuilder();
            reflectionAppend(obj, obj2, cls2, compareToBuilder, z11, strArr);
            while (cls2.getSuperclass() != null && cls2 != cls) {
                cls2 = cls2.getSuperclass();
                reflectionAppend(obj, obj2, cls2, compareToBuilder, z11, strArr);
            }
            return compareToBuilder.toComparison();
        }
        throw new ClassCastException();
    }

    public CompareToBuilder append(long j11, long j12) {
        if (this.comparison != 0) {
            return this;
        }
        int i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
        this.comparison = i11 < 0 ? -1 : i11 > 0 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(int i11, int i12) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = i11 < i12 ? -1 : i11 > i12 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(short s11, short s12) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = s11 < s12 ? -1 : s11 > s12 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(char c11, char c12) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = c11 < c12 ? -1 : c11 > c12 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(byte b11, byte b12) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = b11 < b12 ? -1 : b11 > b12 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(double d11, double d12) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = Double.compare(d11, d12);
        return this;
    }

    public CompareToBuilder append(float f11, float f12) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = Float.compare(f11, f12);
        return this;
    }

    public CompareToBuilder append(boolean z11, boolean z12) {
        if (this.comparison != 0 || z11 == z12) {
            return this;
        }
        if (!z11) {
            this.comparison = -1;
        } else {
            this.comparison = 1;
        }
        return this;
    }

    public CompareToBuilder append(Object[] objArr, Object[] objArr2) {
        return append(objArr, objArr2, (Comparator<?>) null);
    }

    public CompareToBuilder append(Object[] objArr, Object[] objArr2, Comparator<?> comparator) {
        if (this.comparison != 0 || objArr == objArr2) {
            return this;
        }
        int i11 = -1;
        if (objArr == null) {
            this.comparison = -1;
            return this;
        } else if (objArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (objArr.length != objArr2.length) {
            if (objArr.length >= objArr2.length) {
                i11 = 1;
            }
            this.comparison = i11;
            return this;
        } else {
            for (int i12 = 0; i12 < objArr.length && this.comparison == 0; i12++) {
                append(objArr[i12], objArr2[i12], comparator);
            }
            return this;
        }
    }

    public CompareToBuilder append(long[] jArr, long[] jArr2) {
        if (this.comparison != 0 || jArr == jArr2) {
            return this;
        }
        int i11 = -1;
        if (jArr == null) {
            this.comparison = -1;
            return this;
        } else if (jArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (jArr.length != jArr2.length) {
            if (jArr.length >= jArr2.length) {
                i11 = 1;
            }
            this.comparison = i11;
            return this;
        } else {
            for (int i12 = 0; i12 < jArr.length && this.comparison == 0; i12++) {
                append(jArr[i12], jArr2[i12]);
            }
            return this;
        }
    }

    public CompareToBuilder append(int[] iArr, int[] iArr2) {
        if (this.comparison != 0 || iArr == iArr2) {
            return this;
        }
        int i11 = -1;
        if (iArr == null) {
            this.comparison = -1;
            return this;
        } else if (iArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (iArr.length != iArr2.length) {
            if (iArr.length >= iArr2.length) {
                i11 = 1;
            }
            this.comparison = i11;
            return this;
        } else {
            for (int i12 = 0; i12 < iArr.length && this.comparison == 0; i12++) {
                append(iArr[i12], iArr2[i12]);
            }
            return this;
        }
    }

    public CompareToBuilder append(short[] sArr, short[] sArr2) {
        if (this.comparison != 0 || sArr == sArr2) {
            return this;
        }
        int i11 = -1;
        if (sArr == null) {
            this.comparison = -1;
            return this;
        } else if (sArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (sArr.length != sArr2.length) {
            if (sArr.length >= sArr2.length) {
                i11 = 1;
            }
            this.comparison = i11;
            return this;
        } else {
            for (int i12 = 0; i12 < sArr.length && this.comparison == 0; i12++) {
                append(sArr[i12], sArr2[i12]);
            }
            return this;
        }
    }

    public CompareToBuilder append(char[] cArr, char[] cArr2) {
        if (this.comparison != 0 || cArr == cArr2) {
            return this;
        }
        int i11 = -1;
        if (cArr == null) {
            this.comparison = -1;
            return this;
        } else if (cArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (cArr.length != cArr2.length) {
            if (cArr.length >= cArr2.length) {
                i11 = 1;
            }
            this.comparison = i11;
            return this;
        } else {
            for (int i12 = 0; i12 < cArr.length && this.comparison == 0; i12++) {
                append(cArr[i12], cArr2[i12]);
            }
            return this;
        }
    }

    public CompareToBuilder append(byte[] bArr, byte[] bArr2) {
        if (this.comparison != 0 || bArr == bArr2) {
            return this;
        }
        int i11 = -1;
        if (bArr == null) {
            this.comparison = -1;
            return this;
        } else if (bArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (bArr.length != bArr2.length) {
            if (bArr.length >= bArr2.length) {
                i11 = 1;
            }
            this.comparison = i11;
            return this;
        } else {
            for (int i12 = 0; i12 < bArr.length && this.comparison == 0; i12++) {
                append(bArr[i12], bArr2[i12]);
            }
            return this;
        }
    }

    public CompareToBuilder append(double[] dArr, double[] dArr2) {
        if (this.comparison != 0 || dArr == dArr2) {
            return this;
        }
        int i11 = -1;
        if (dArr == null) {
            this.comparison = -1;
            return this;
        } else if (dArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (dArr.length != dArr2.length) {
            if (dArr.length >= dArr2.length) {
                i11 = 1;
            }
            this.comparison = i11;
            return this;
        } else {
            for (int i12 = 0; i12 < dArr.length && this.comparison == 0; i12++) {
                append(dArr[i12], dArr2[i12]);
            }
            return this;
        }
    }

    public CompareToBuilder append(float[] fArr, float[] fArr2) {
        if (this.comparison != 0 || fArr == fArr2) {
            return this;
        }
        int i11 = -1;
        if (fArr == null) {
            this.comparison = -1;
            return this;
        } else if (fArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (fArr.length != fArr2.length) {
            if (fArr.length >= fArr2.length) {
                i11 = 1;
            }
            this.comparison = i11;
            return this;
        } else {
            for (int i12 = 0; i12 < fArr.length && this.comparison == 0; i12++) {
                append(fArr[i12], fArr2[i12]);
            }
            return this;
        }
    }

    public CompareToBuilder append(boolean[] zArr, boolean[] zArr2) {
        if (this.comparison != 0 || zArr == zArr2) {
            return this;
        }
        int i11 = -1;
        if (zArr == null) {
            this.comparison = -1;
            return this;
        } else if (zArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (zArr.length != zArr2.length) {
            if (zArr.length >= zArr2.length) {
                i11 = 1;
            }
            this.comparison = i11;
            return this;
        } else {
            for (int i12 = 0; i12 < zArr.length && this.comparison == 0; i12++) {
                append(zArr[i12], zArr2[i12]);
            }
            return this;
        }
    }
}
