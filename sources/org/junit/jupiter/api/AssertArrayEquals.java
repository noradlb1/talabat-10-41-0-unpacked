package org.junit.jupiter.api;

import j$.util.function.Supplier;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import org.junit.platform.commons.util.ReflectionUtils;

class AssertArrayEquals {
    private AssertArrayEquals() {
    }

    public static void A(Object[] objArr, Object[] objArr2, Supplier<String> supplier) {
        assertArrayEquals(objArr, objArr2, (Deque<Integer>) new ArrayDeque(), (Object) supplier);
    }

    public static void B(short[] sArr, short[] sArr2) {
        C(sArr, sArr2, (String) null);
    }

    public static void C(short[] sArr, short[] sArr2, String str) {
        assertArrayEquals(sArr, sArr2, (Deque<Integer>) null, (Object) str);
    }

    public static void D(short[] sArr, short[] sArr2, Supplier<String> supplier) {
        assertArrayEquals(sArr, sArr2, (Deque<Integer>) null, (Object) supplier);
    }

    public static void E(boolean[] zArr, boolean[] zArr2) {
        F(zArr, zArr2, (String) null);
    }

    public static void F(boolean[] zArr, boolean[] zArr2, String str) {
        assertArrayEquals(zArr, zArr2, (Deque<Integer>) null, (Object) str);
    }

    public static void G(boolean[] zArr, boolean[] zArr2, Supplier<String> supplier) {
        assertArrayEquals(zArr, zArr2, (Deque<Integer>) null, (Object) supplier);
    }

    public static void a(byte[] bArr, byte[] bArr2) {
        b(bArr, bArr2, (String) null);
    }

    private static void assertArrayElementsEqual(Object obj, Object obj2, Deque<Integer> deque, Object obj3) {
        if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
            assertArrayEquals((Object[]) obj, (Object[]) obj2, deque, obj3);
        } else if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
            assertArrayEquals((byte[]) obj, (byte[]) obj2, deque, obj3);
        } else if ((obj instanceof short[]) && (obj2 instanceof short[])) {
            assertArrayEquals((short[]) obj, (short[]) obj2, deque, obj3);
        } else if ((obj instanceof int[]) && (obj2 instanceof int[])) {
            assertArrayEquals((int[]) obj, (int[]) obj2, deque, obj3);
        } else if ((obj instanceof long[]) && (obj2 instanceof long[])) {
            assertArrayEquals((long[]) obj, (long[]) obj2, deque, obj3);
        } else if ((obj instanceof char[]) && (obj2 instanceof char[])) {
            assertArrayEquals((char[]) obj, (char[]) obj2, deque, obj3);
        } else if ((obj instanceof float[]) && (obj2 instanceof float[])) {
            assertArrayEquals((float[]) obj, (float[]) obj2, deque, obj3);
        } else if ((obj instanceof double[]) && (obj2 instanceof double[])) {
            assertArrayEquals((double[]) obj, (double[]) obj2, deque, obj3);
        } else if ((obj instanceof boolean[]) && (obj2 instanceof boolean[])) {
            assertArrayEquals((boolean[]) obj, (boolean[]) obj2, deque, obj3);
        } else if (Objects.equals(obj, obj2)) {
        } else {
            if (obj == null && ReflectionUtils.isArray(obj2)) {
                failExpectedArrayIsNull(deque, obj3);
            } else if (!ReflectionUtils.isArray(obj) || obj2 != null) {
                failArraysNotEqual(obj, obj2, deque, obj3);
            } else {
                failActualArrayIsNull(deque, obj3);
            }
        }
    }

    private static void assertArrayEquals(boolean[] zArr, boolean[] zArr2, Deque<Integer> deque, Object obj) {
        if (zArr != zArr2) {
            assertArraysNotNull(zArr, zArr2, deque, obj);
            assertArraysHaveSameLength(zArr.length, zArr2.length, deque, obj);
            for (int i11 = 0; i11 < zArr.length; i11++) {
                boolean z11 = zArr[i11];
                if (z11 != zArr2[i11]) {
                    failArraysNotEqual(Boolean.valueOf(z11), Boolean.valueOf(zArr2[i11]), nullSafeIndexes(deque, i11), obj);
                }
            }
        }
    }

    private static void assertArraysHaveSameLength(int i11, int i12, Deque<Integer> deque, Object obj) {
        if (i11 != i12) {
            AssertionFailureBuilder message = AssertionFailureBuilder.assertionFailure().message(obj);
            message.reason("array lengths differ" + AssertionUtils.l(deque)).expected(Integer.valueOf(i11)).actual(Integer.valueOf(i12)).buildAndThrow();
        }
    }

    private static void assertArraysNotNull(Object obj, Object obj2, Deque<Integer> deque, Object obj3) {
        if (obj == null) {
            failExpectedArrayIsNull(deque, obj3);
        }
        if (obj2 == null) {
            failActualArrayIsNull(deque, obj3);
        }
    }

    public static void b(byte[] bArr, byte[] bArr2, String str) {
        assertArrayEquals(bArr, bArr2, (Deque<Integer>) null, (Object) str);
    }

    public static void c(byte[] bArr, byte[] bArr2, Supplier<String> supplier) {
        assertArrayEquals(bArr, bArr2, (Deque<Integer>) null, (Object) supplier);
    }

    public static void d(char[] cArr, char[] cArr2) {
        e(cArr, cArr2, (String) null);
    }

    public static void e(char[] cArr, char[] cArr2, String str) {
        assertArrayEquals(cArr, cArr2, (Deque<Integer>) null, (Object) str);
    }

    public static void f(char[] cArr, char[] cArr2, Supplier<String> supplier) {
        assertArrayEquals(cArr, cArr2, (Deque<Integer>) null, (Object) supplier);
    }

    private static void failActualArrayIsNull(Deque<Integer> deque, Object obj) {
        AssertionFailureBuilder message = AssertionFailureBuilder.assertionFailure().message(obj);
        message.reason("actual array was <null>" + AssertionUtils.l(deque)).buildAndThrow();
    }

    private static void failArraysNotEqual(Object obj, Object obj2, Deque<Integer> deque, Object obj3) {
        AssertionFailureBuilder message = AssertionFailureBuilder.assertionFailure().message(obj3);
        message.reason("array contents differ" + AssertionUtils.l(deque)).expected(obj).actual(obj2).buildAndThrow();
    }

    private static void failExpectedArrayIsNull(Deque<Integer> deque, Object obj) {
        AssertionFailureBuilder message = AssertionFailureBuilder.assertionFailure().message(obj);
        message.reason("expected array was <null>" + AssertionUtils.l(deque)).buildAndThrow();
    }

    public static void g(double[] dArr, double[] dArr2) {
        k(dArr, dArr2, (String) null);
    }

    public static void h(double[] dArr, double[] dArr2, double d11) {
        i(dArr, dArr2, d11, (String) null);
    }

    public static void i(double[] dArr, double[] dArr2, double d11, String str) {
        assertArrayEquals(dArr, dArr2, d11, (Deque<Integer>) null, (Object) str);
    }

    public static void j(double[] dArr, double[] dArr2, double d11, Supplier<String> supplier) {
        assertArrayEquals(dArr, dArr2, d11, (Deque<Integer>) null, (Object) supplier);
    }

    public static void k(double[] dArr, double[] dArr2, String str) {
        assertArrayEquals(dArr, dArr2, (Deque<Integer>) null, (Object) str);
    }

    public static void l(double[] dArr, double[] dArr2, Supplier<String> supplier) {
        assertArrayEquals(dArr, dArr2, (Deque<Integer>) null, (Object) supplier);
    }

    public static void m(float[] fArr, float[] fArr2) {
        q(fArr, fArr2, (String) null);
    }

    public static void n(float[] fArr, float[] fArr2, float f11) {
        o(fArr, fArr2, f11, (String) null);
    }

    private static Deque<Integer> nullSafeIndexes(Deque<Integer> deque, int i11) {
        if (deque == null) {
            deque = new ArrayDeque<>();
        }
        deque.addLast(Integer.valueOf(i11));
        return deque;
    }

    public static void o(float[] fArr, float[] fArr2, float f11, String str) {
        assertArrayEquals(fArr, fArr2, f11, (Deque<Integer>) null, (Object) str);
    }

    public static void p(float[] fArr, float[] fArr2, float f11, Supplier<String> supplier) {
        assertArrayEquals(fArr, fArr2, f11, (Deque<Integer>) null, (Object) supplier);
    }

    public static void q(float[] fArr, float[] fArr2, String str) {
        assertArrayEquals(fArr, fArr2, (Deque<Integer>) null, (Object) str);
    }

    public static void r(float[] fArr, float[] fArr2, Supplier<String> supplier) {
        assertArrayEquals(fArr, fArr2, (Deque<Integer>) null, (Object) supplier);
    }

    public static void s(int[] iArr, int[] iArr2) {
        t(iArr, iArr2, (String) null);
    }

    public static void t(int[] iArr, int[] iArr2, String str) {
        assertArrayEquals(iArr, iArr2, (Deque<Integer>) null, (Object) str);
    }

    public static void u(int[] iArr, int[] iArr2, Supplier<String> supplier) {
        assertArrayEquals(iArr, iArr2, (Deque<Integer>) null, (Object) supplier);
    }

    public static void v(long[] jArr, long[] jArr2) {
        w(jArr, jArr2, (String) null);
    }

    public static void w(long[] jArr, long[] jArr2, String str) {
        assertArrayEquals(jArr, jArr2, (Deque<Integer>) null, (Object) str);
    }

    public static void x(long[] jArr, long[] jArr2, Supplier<String> supplier) {
        assertArrayEquals(jArr, jArr2, (Deque<Integer>) null, (Object) supplier);
    }

    public static void y(Object[] objArr, Object[] objArr2) {
        z(objArr, objArr2, (String) null);
    }

    public static void z(Object[] objArr, Object[] objArr2, String str) {
        assertArrayEquals(objArr, objArr2, (Deque<Integer>) new ArrayDeque(), (Object) str);
    }

    private static void assertArrayEquals(char[] cArr, char[] cArr2, Deque<Integer> deque, Object obj) {
        if (cArr != cArr2) {
            assertArraysNotNull(cArr, cArr2, deque, obj);
            assertArraysHaveSameLength(cArr.length, cArr2.length, deque, obj);
            for (int i11 = 0; i11 < cArr.length; i11++) {
                char c11 = cArr[i11];
                if (c11 != cArr2[i11]) {
                    failArraysNotEqual(Character.valueOf(c11), Character.valueOf(cArr2[i11]), nullSafeIndexes(deque, i11), obj);
                }
            }
        }
    }

    private static void assertArrayEquals(byte[] bArr, byte[] bArr2, Deque<Integer> deque, Object obj) {
        if (bArr != bArr2) {
            assertArraysNotNull(bArr, bArr2, deque, obj);
            assertArraysHaveSameLength(bArr.length, bArr2.length, deque, obj);
            for (int i11 = 0; i11 < bArr.length; i11++) {
                byte b11 = bArr[i11];
                if (b11 != bArr2[i11]) {
                    failArraysNotEqual(Byte.valueOf(b11), Byte.valueOf(bArr2[i11]), nullSafeIndexes(deque, i11), obj);
                }
            }
        }
    }

    private static void assertArrayEquals(short[] sArr, short[] sArr2, Deque<Integer> deque, Object obj) {
        if (sArr != sArr2) {
            assertArraysNotNull(sArr, sArr2, deque, obj);
            assertArraysHaveSameLength(sArr.length, sArr2.length, deque, obj);
            for (int i11 = 0; i11 < sArr.length; i11++) {
                short s11 = sArr[i11];
                if (s11 != sArr2[i11]) {
                    failArraysNotEqual(Short.valueOf(s11), Short.valueOf(sArr2[i11]), nullSafeIndexes(deque, i11), obj);
                }
            }
        }
    }

    private static void assertArrayEquals(int[] iArr, int[] iArr2, Deque<Integer> deque, Object obj) {
        if (iArr != iArr2) {
            assertArraysNotNull(iArr, iArr2, deque, obj);
            assertArraysHaveSameLength(iArr.length, iArr2.length, deque, obj);
            for (int i11 = 0; i11 < iArr.length; i11++) {
                int i12 = iArr[i11];
                if (i12 != iArr2[i11]) {
                    failArraysNotEqual(Integer.valueOf(i12), Integer.valueOf(iArr2[i11]), nullSafeIndexes(deque, i11), obj);
                }
            }
        }
    }

    private static void assertArrayEquals(long[] jArr, long[] jArr2, Deque<Integer> deque, Object obj) {
        if (jArr != jArr2) {
            assertArraysNotNull(jArr, jArr2, deque, obj);
            assertArraysHaveSameLength(jArr.length, jArr2.length, deque, obj);
            for (int i11 = 0; i11 < jArr.length; i11++) {
                long j11 = jArr[i11];
                if (j11 != jArr2[i11]) {
                    failArraysNotEqual(Long.valueOf(j11), Long.valueOf(jArr2[i11]), nullSafeIndexes(deque, i11), obj);
                }
            }
        }
    }

    private static void assertArrayEquals(float[] fArr, float[] fArr2, Deque<Integer> deque, Object obj) {
        if (fArr != fArr2) {
            assertArraysNotNull(fArr, fArr2, deque, obj);
            assertArraysHaveSameLength(fArr.length, fArr2.length, deque, obj);
            for (int i11 = 0; i11 < fArr.length; i11++) {
                if (!AssertionUtils.j(fArr[i11], fArr2[i11])) {
                    failArraysNotEqual(Float.valueOf(fArr[i11]), Float.valueOf(fArr2[i11]), nullSafeIndexes(deque, i11), obj);
                }
            }
        }
    }

    private static void assertArrayEquals(float[] fArr, float[] fArr2, float f11, Deque<Integer> deque, Object obj) {
        AssertionUtils.b(f11);
        if (fArr != fArr2) {
            assertArraysNotNull(fArr, fArr2, deque, obj);
            assertArraysHaveSameLength(fArr.length, fArr2.length, deque, obj);
            for (int i11 = 0; i11 < fArr.length; i11++) {
                if (!AssertionUtils.k(fArr[i11], fArr2[i11], f11)) {
                    failArraysNotEqual(Float.valueOf(fArr[i11]), Float.valueOf(fArr2[i11]), nullSafeIndexes(deque, i11), obj);
                }
            }
        }
    }

    private static void assertArrayEquals(double[] dArr, double[] dArr2, Deque<Integer> deque, Object obj) {
        if (dArr != dArr2) {
            assertArraysNotNull(dArr, dArr2, deque, obj);
            assertArraysHaveSameLength(dArr.length, dArr2.length, deque, obj);
            for (int i11 = 0; i11 < dArr.length; i11++) {
                if (!AssertionUtils.c(dArr[i11], dArr2[i11])) {
                    failArraysNotEqual(Double.valueOf(dArr[i11]), Double.valueOf(dArr2[i11]), nullSafeIndexes(deque, i11), obj);
                }
            }
        }
    }

    private static void assertArrayEquals(double[] dArr, double[] dArr2, double d11, Deque<Integer> deque, Object obj) {
        AssertionUtils.a(d11);
        if (dArr != dArr2) {
            assertArraysNotNull(dArr, dArr2, deque, obj);
            assertArraysHaveSameLength(dArr.length, dArr2.length, deque, obj);
            for (int i11 = 0; i11 < dArr.length; i11++) {
                if (!AssertionUtils.d(dArr[i11], dArr2[i11], d11)) {
                    failArraysNotEqual(Double.valueOf(dArr[i11]), Double.valueOf(dArr2[i11]), nullSafeIndexes(deque, i11), obj);
                }
            }
        }
    }

    private static void assertArrayEquals(Object[] objArr, Object[] objArr2, Deque<Integer> deque, Object obj) {
        if (objArr != objArr2) {
            assertArraysNotNull(objArr, objArr2, deque, obj);
            assertArraysHaveSameLength(objArr.length, objArr2.length, deque, obj);
            for (int i11 = 0; i11 < objArr.length; i11++) {
                Object obj2 = objArr[i11];
                Object obj3 = objArr2[i11];
                if (obj2 != obj3) {
                    deque.addLast(Integer.valueOf(i11));
                    assertArrayElementsEqual(obj2, obj3, deque, obj);
                    deque.removeLast();
                }
            }
        }
    }
}
