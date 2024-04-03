package org.mockito.internal.matchers.apachecommons;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.plugins.MemberAccessor;

class EqualsBuilder {
    private boolean isEquals = true;

    private static boolean reflectionAppend(Object obj, Object obj2, Class<?> cls, EqualsBuilder equalsBuilder, boolean z11, String[] strArr) {
        List list;
        Field[] declaredFields = cls.getDeclaredFields();
        if (strArr != null) {
            list = Arrays.asList(strArr);
        } else {
            list = Collections.emptyList();
        }
        MemberAccessor memberAccessor = Plugins.getMemberAccessor();
        for (int i11 = 0; i11 < declaredFields.length && equalsBuilder.isEquals; i11++) {
            Field field = declaredFields[i11];
            if (!list.contains(field.getName()) && field.getName().indexOf(36) == -1 && ((z11 || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                try {
                    equalsBuilder.append(memberAccessor.get(field, obj), memberAccessor.get(field, obj2));
                } catch (IllegalAccessException | RuntimeException unused) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean reflectionEquals(Object obj, Object obj2) {
        return reflectionEquals(obj, obj2, false, (Class<?>) null, (String[]) null);
    }

    public void a(boolean z11) {
        this.isEquals = z11;
    }

    public EqualsBuilder append(Object obj, Object obj2) {
        if (!this.isEquals || obj == obj2) {
            return this;
        }
        boolean z11 = false;
        if (obj == null || obj2 == null) {
            a(false);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (!(obj instanceof BigDecimal) || !(obj2 instanceof BigDecimal)) {
                this.isEquals = obj.equals(obj2);
            } else {
                if (((BigDecimal) obj).compareTo((BigDecimal) obj2) == 0) {
                    z11 = true;
                }
                this.isEquals = z11;
            }
        } else if (obj.getClass() != obj2.getClass()) {
            a(false);
        } else if (obj instanceof long[]) {
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
            append((Object[]) obj, (Object[]) obj2);
        }
        return this;
    }

    public EqualsBuilder appendSuper(boolean z11) {
        this.isEquals = z11 & this.isEquals;
        return this;
    }

    public boolean isEquals() {
        return this.isEquals;
    }

    public static boolean reflectionEquals(Object obj, Object obj2, String[] strArr) {
        return reflectionEquals(obj, obj2, false, (Class<?>) null, strArr);
    }

    public static boolean reflectionEquals(Object obj, Object obj2, boolean z11) {
        return reflectionEquals(obj, obj2, z11, (Class<?>) null, (String[]) null);
    }

    public static boolean reflectionEquals(Object obj, Object obj2, boolean z11, Class<?> cls) {
        return reflectionEquals(obj, obj2, z11, cls, (String[]) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        if (r1.isInstance(r12) == false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r2.isInstance(r11) == false) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean reflectionEquals(java.lang.Object r11, java.lang.Object r12, boolean r13, java.lang.Class<?> r14, java.lang.String[] r15) {
        /*
            if (r11 != r12) goto L_0x0004
            r11 = 1
            return r11
        L_0x0004:
            r0 = 0
            if (r11 == 0) goto L_0x005d
            if (r12 != 0) goto L_0x000a
            goto L_0x005d
        L_0x000a:
            java.lang.Class r1 = r11.getClass()
            java.lang.Class r2 = r12.getClass()
            boolean r3 = r1.isInstance(r12)
            if (r3 == 0) goto L_0x001f
            boolean r3 = r2.isInstance(r11)
            if (r3 != 0) goto L_0x002d
            goto L_0x002c
        L_0x001f:
            boolean r3 = r2.isInstance(r11)
            if (r3 == 0) goto L_0x005d
            boolean r3 = r1.isInstance(r12)
            if (r3 != 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r1 = r2
        L_0x002d:
            org.mockito.internal.matchers.apachecommons.EqualsBuilder r10 = new org.mockito.internal.matchers.apachecommons.EqualsBuilder
            r10.<init>()
            r4 = r11
            r5 = r12
            r6 = r1
            r7 = r10
            r8 = r13
            r9 = r15
            boolean r2 = reflectionAppend(r4, r5, r6, r7, r8, r9)
            if (r2 == 0) goto L_0x003f
            return r0
        L_0x003f:
            java.lang.Class r2 = r1.getSuperclass()
            if (r2 == 0) goto L_0x0058
            if (r1 == r14) goto L_0x0058
            java.lang.Class r1 = r1.getSuperclass()
            r2 = r11
            r3 = r12
            r4 = r1
            r5 = r10
            r6 = r13
            r7 = r15
            boolean r2 = reflectionAppend(r2, r3, r4, r5, r6, r7)
            if (r2 == 0) goto L_0x003f
            return r0
        L_0x0058:
            boolean r11 = r10.isEquals()
            return r11
        L_0x005d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mockito.internal.matchers.apachecommons.EqualsBuilder.reflectionEquals(java.lang.Object, java.lang.Object, boolean, java.lang.Class, java.lang.String[]):boolean");
    }

    public EqualsBuilder append(long j11, long j12) {
        this.isEquals = (j11 == j12) & this.isEquals;
        return this;
    }

    public EqualsBuilder append(int i11, int i12) {
        this.isEquals = (i11 == i12) & this.isEquals;
        return this;
    }

    public EqualsBuilder append(short s11, short s12) {
        this.isEquals = (s11 == s12) & this.isEquals;
        return this;
    }

    public EqualsBuilder append(char c11, char c12) {
        this.isEquals = (c11 == c12) & this.isEquals;
        return this;
    }

    public EqualsBuilder append(byte b11, byte b12) {
        this.isEquals = (b11 == b12) & this.isEquals;
        return this;
    }

    public EqualsBuilder append(double d11, double d12) {
        if (!this.isEquals) {
            return this;
        }
        return append(Double.doubleToLongBits(d11), Double.doubleToLongBits(d12));
    }

    public EqualsBuilder append(float f11, float f12) {
        if (!this.isEquals) {
            return this;
        }
        return append(Float.floatToIntBits(f11), Float.floatToIntBits(f12));
    }

    public EqualsBuilder append(boolean z11, boolean z12) {
        this.isEquals = (z11 == z12) & this.isEquals;
        return this;
    }

    public EqualsBuilder append(Object[] objArr, Object[] objArr2) {
        if (!this.isEquals || objArr == objArr2) {
            return this;
        }
        if (objArr == null || objArr2 == null) {
            a(false);
            return this;
        } else if (objArr.length != objArr2.length) {
            a(false);
            return this;
        } else {
            for (int i11 = 0; i11 < objArr.length && this.isEquals; i11++) {
                append(objArr[i11], objArr2[i11]);
            }
            return this;
        }
    }

    public EqualsBuilder append(long[] jArr, long[] jArr2) {
        if (!this.isEquals || jArr == jArr2) {
            return this;
        }
        if (jArr == null || jArr2 == null) {
            a(false);
            return this;
        } else if (jArr.length != jArr2.length) {
            a(false);
            return this;
        } else {
            for (int i11 = 0; i11 < jArr.length && this.isEquals; i11++) {
                append(jArr[i11], jArr2[i11]);
            }
            return this;
        }
    }

    public EqualsBuilder append(int[] iArr, int[] iArr2) {
        if (!this.isEquals || iArr == iArr2) {
            return this;
        }
        if (iArr == null || iArr2 == null) {
            a(false);
            return this;
        } else if (iArr.length != iArr2.length) {
            a(false);
            return this;
        } else {
            for (int i11 = 0; i11 < iArr.length && this.isEquals; i11++) {
                append(iArr[i11], iArr2[i11]);
            }
            return this;
        }
    }

    public EqualsBuilder append(short[] sArr, short[] sArr2) {
        if (!this.isEquals || sArr == sArr2) {
            return this;
        }
        if (sArr == null || sArr2 == null) {
            a(false);
            return this;
        } else if (sArr.length != sArr2.length) {
            a(false);
            return this;
        } else {
            for (int i11 = 0; i11 < sArr.length && this.isEquals; i11++) {
                append(sArr[i11], sArr2[i11]);
            }
            return this;
        }
    }

    public EqualsBuilder append(char[] cArr, char[] cArr2) {
        if (!this.isEquals || cArr == cArr2) {
            return this;
        }
        if (cArr == null || cArr2 == null) {
            a(false);
            return this;
        } else if (cArr.length != cArr2.length) {
            a(false);
            return this;
        } else {
            for (int i11 = 0; i11 < cArr.length && this.isEquals; i11++) {
                append(cArr[i11], cArr2[i11]);
            }
            return this;
        }
    }

    public EqualsBuilder append(byte[] bArr, byte[] bArr2) {
        if (!this.isEquals || bArr == bArr2) {
            return this;
        }
        if (bArr == null || bArr2 == null) {
            a(false);
            return this;
        } else if (bArr.length != bArr2.length) {
            a(false);
            return this;
        } else {
            for (int i11 = 0; i11 < bArr.length && this.isEquals; i11++) {
                append(bArr[i11], bArr2[i11]);
            }
            return this;
        }
    }

    public EqualsBuilder append(double[] dArr, double[] dArr2) {
        if (!this.isEquals || dArr == dArr2) {
            return this;
        }
        if (dArr == null || dArr2 == null) {
            a(false);
            return this;
        } else if (dArr.length != dArr2.length) {
            a(false);
            return this;
        } else {
            for (int i11 = 0; i11 < dArr.length && this.isEquals; i11++) {
                append(dArr[i11], dArr2[i11]);
            }
            return this;
        }
    }

    public EqualsBuilder append(float[] fArr, float[] fArr2) {
        if (!this.isEquals || fArr == fArr2) {
            return this;
        }
        if (fArr == null || fArr2 == null) {
            a(false);
            return this;
        } else if (fArr.length != fArr2.length) {
            a(false);
            return this;
        } else {
            for (int i11 = 0; i11 < fArr.length && this.isEquals; i11++) {
                append(fArr[i11], fArr2[i11]);
            }
            return this;
        }
    }

    public EqualsBuilder append(boolean[] zArr, boolean[] zArr2) {
        if (!this.isEquals || zArr == zArr2) {
            return this;
        }
        if (zArr == null || zArr2 == null) {
            a(false);
            return this;
        } else if (zArr.length != zArr2.length) {
            a(false);
            return this;
        } else {
            for (int i11 = 0; i11 < zArr.length && this.isEquals; i11++) {
                append(zArr[i11], zArr2[i11]);
            }
            return this;
        }
    }
}
