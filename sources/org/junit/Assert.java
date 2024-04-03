package org.junit;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.internal.ArrayComparisonFailure;
import org.junit.internal.ExactComparisonCriteria;
import org.junit.internal.InexactComparisonCriteria;

public class Assert {
    public static String a(String str, Object obj, Object obj2) {
        String str2 = "";
        if (str != null && !str.equals(str2)) {
            str2 = str + " ";
        }
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        if (valueOf.equals(valueOf2)) {
            return str2 + "expected: " + formatClassAndValue(obj, valueOf) + " but was: " + formatClassAndValue(obj2, valueOf2);
        }
        return str2 + "expected:<" + valueOf + "> but was:<" + valueOf2 + ">";
    }

    public static void assertArrayEquals(String str, Object[] objArr, Object[] objArr2) throws ArrayComparisonFailure {
        internalArrayEquals(str, objArr, objArr2);
    }

    public static void assertEquals(String str, Object obj, Object obj2) {
        if (!equalsRegardingNull(obj, obj2)) {
            if (!(obj instanceof String) || !(obj2 instanceof String)) {
                failNotEquals(str, obj, obj2);
                return;
            }
            if (str == null) {
                str = "";
            }
            throw new ComparisonFailure(str, (String) obj, (String) obj2);
        }
    }

    public static void assertFalse(String str, boolean z11) {
        assertTrue(str, !z11);
    }

    public static void assertNotEquals(String str, Object obj, Object obj2) {
        if (equalsRegardingNull(obj, obj2)) {
            failEquals(str, obj2);
        }
    }

    public static void assertNotNull(String str, Object obj) {
        assertTrue(str, obj != null);
    }

    public static void assertNotSame(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            failSame(str);
        }
    }

    public static void assertNull(String str, Object obj) {
        if (obj != null) {
            failNotNull(str, obj);
        }
    }

    public static void assertSame(String str, Object obj, Object obj2) {
        if (obj != obj2) {
            failNotSame(str, obj, obj2);
        }
    }

    public static <T> void assertThat(T t11, Matcher<? super T> matcher) {
        assertThat("", t11, matcher);
    }

    public static void assertTrue(String str, boolean z11) {
        if (!z11) {
            fail(str);
        }
    }

    private static boolean doubleIsDifferent(double d11, double d12, double d13) {
        if (Double.compare(d11, d12) != 0 && Math.abs(d11 - d12) > d13) {
            return true;
        }
        return false;
    }

    private static boolean equalsRegardingNull(Object obj, Object obj2) {
        return obj == null ? obj2 == null : isEquals(obj, obj2);
    }

    public static void fail(String str) {
        if (str == null) {
            throw new AssertionError();
        }
        throw new AssertionError(str);
    }

    private static void failEquals(String str, Object obj) {
        String str2;
        if (str != null) {
            str2 = str + ". ";
        } else {
            str2 = "Values should be different. ";
        }
        fail(str2 + "Actual: " + obj);
    }

    private static void failNotEquals(String str, Object obj, Object obj2) {
        fail(a(str, obj, obj2));
    }

    private static void failNotNull(String str, Object obj) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        fail(str2 + "expected null, but was:<" + obj + ">");
    }

    private static void failNotSame(String str, Object obj, Object obj2) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        fail(str2 + "expected same:<" + obj + "> was not:<" + obj2 + ">");
    }

    private static void failSame(String str) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        fail(str2 + "expected not same");
    }

    private static boolean floatIsDifferent(float f11, float f12, float f13) {
        if (Float.compare(f11, f12) != 0 && Math.abs(f11 - f12) > f13) {
            return true;
        }
        return false;
    }

    private static String formatClassAndValue(Object obj, String str) {
        String str2;
        if (obj == null) {
            str2 = "null";
        } else {
            str2 = obj.getClass().getName();
        }
        return str2 + "<" + str + ">";
    }

    private static void internalArrayEquals(String str, Object obj, Object obj2) throws ArrayComparisonFailure {
        new ExactComparisonCriteria().arrayEquals(str, obj, obj2);
    }

    private static boolean isEquals(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    public static void assertArrayEquals(Object[] objArr, Object[] objArr2) {
        assertArrayEquals((String) null, objArr, objArr2);
    }

    public static void assertFalse(boolean z11) {
        assertFalse((String) null, z11);
    }

    public static void assertNotNull(Object obj) {
        assertNotNull((String) null, obj);
    }

    public static void assertNotSame(Object obj, Object obj2) {
        assertNotSame((String) null, obj, obj2);
    }

    public static void assertNull(Object obj) {
        assertNull((String) null, obj);
    }

    public static void assertSame(Object obj, Object obj2) {
        assertSame((String) null, obj, obj2);
    }

    public static <T> void assertThat(String str, T t11, Matcher<? super T> matcher) {
        MatcherAssert.assertThat(str, t11, matcher);
    }

    public static void assertTrue(boolean z11) {
        assertTrue((String) null, z11);
    }

    public static void assertArrayEquals(String str, boolean[] zArr, boolean[] zArr2) throws ArrayComparisonFailure {
        internalArrayEquals(str, zArr, zArr2);
    }

    public static void assertNotEquals(Object obj, Object obj2) {
        assertNotEquals((String) null, obj, obj2);
    }

    public static void fail() {
        fail((String) null);
    }

    public static void assertArrayEquals(boolean[] zArr, boolean[] zArr2) {
        assertArrayEquals((String) null, zArr, zArr2);
    }

    public static void assertNotEquals(String str, long j11, long j12) {
        if (j11 == j12) {
            failEquals(str, Long.valueOf(j12));
        }
    }

    public static void assertArrayEquals(String str, byte[] bArr, byte[] bArr2) throws ArrayComparisonFailure {
        internalArrayEquals(str, bArr, bArr2);
    }

    public static void assertEquals(Object obj, Object obj2) {
        assertEquals((String) null, obj, obj2);
    }

    public static void assertNotEquals(long j11, long j12) {
        assertNotEquals((String) null, j11, j12);
    }

    public static void assertArrayEquals(byte[] bArr, byte[] bArr2) {
        assertArrayEquals((String) null, bArr, bArr2);
    }

    public static void assertEquals(String str, double d11, double d12, double d13) {
        if (doubleIsDifferent(d11, d12, d13)) {
            failNotEquals(str, Double.valueOf(d11), Double.valueOf(d12));
        }
    }

    public static void assertNotEquals(String str, double d11, double d12, double d13) {
        if (!doubleIsDifferent(d11, d12, d13)) {
            failEquals(str, Double.valueOf(d12));
        }
    }

    public static void assertArrayEquals(String str, char[] cArr, char[] cArr2) throws ArrayComparisonFailure {
        internalArrayEquals(str, cArr, cArr2);
    }

    public static void assertArrayEquals(char[] cArr, char[] cArr2) {
        assertArrayEquals((String) null, cArr, cArr2);
    }

    public static void assertEquals(String str, float f11, float f12, float f13) {
        if (floatIsDifferent(f11, f12, f13)) {
            failNotEquals(str, Float.valueOf(f11), Float.valueOf(f12));
        }
    }

    public static void assertNotEquals(double d11, double d12, double d13) {
        assertNotEquals((String) null, d11, d12, d13);
    }

    public static void assertArrayEquals(String str, short[] sArr, short[] sArr2) throws ArrayComparisonFailure {
        internalArrayEquals(str, sArr, sArr2);
    }

    public static void assertNotEquals(float f11, float f12, float f13) {
        assertNotEquals((String) null, f11, f12, f13);
    }

    public static void assertArrayEquals(short[] sArr, short[] sArr2) {
        assertArrayEquals((String) null, sArr, sArr2);
    }

    public static void assertEquals(long j11, long j12) {
        assertEquals((String) null, j11, j12);
    }

    public static void assertNotEquals(String str, float f11, float f12, float f13) {
        if (!floatIsDifferent(f11, f12, f13)) {
            failEquals(str, Float.valueOf(f12));
        }
    }

    public static void assertArrayEquals(String str, int[] iArr, int[] iArr2) throws ArrayComparisonFailure {
        internalArrayEquals(str, iArr, iArr2);
    }

    public static void assertEquals(String str, long j11, long j12) {
        if (j11 != j12) {
            failNotEquals(str, Long.valueOf(j11), Long.valueOf(j12));
        }
    }

    public static void assertArrayEquals(int[] iArr, int[] iArr2) {
        assertArrayEquals((String) null, iArr, iArr2);
    }

    @Deprecated
    public static void assertEquals(double d11, double d12) {
        assertEquals((String) null, d11, d12);
    }

    public static void assertArrayEquals(String str, long[] jArr, long[] jArr2) throws ArrayComparisonFailure {
        internalArrayEquals(str, jArr, jArr2);
    }

    @Deprecated
    public static void assertEquals(String str, double d11, double d12) {
        fail("Use assertEquals(expected, actual, delta) to compare floating-point numbers");
    }

    public static void assertArrayEquals(long[] jArr, long[] jArr2) {
        assertArrayEquals((String) null, jArr, jArr2);
    }

    public static void assertEquals(double d11, double d12, double d13) {
        assertEquals((String) null, d11, d12, d13);
    }

    public static void assertArrayEquals(String str, double[] dArr, double[] dArr2, double d11) throws ArrayComparisonFailure {
        new InexactComparisonCriteria(d11).arrayEquals(str, dArr, dArr2);
    }

    public static void assertEquals(float f11, float f12, float f13) {
        assertEquals((String) null, f11, f12, f13);
    }

    public static void assertArrayEquals(double[] dArr, double[] dArr2, double d11) {
        assertArrayEquals((String) null, dArr, dArr2, d11);
    }

    @Deprecated
    public static void assertEquals(String str, Object[] objArr, Object[] objArr2) {
        assertArrayEquals(str, objArr, objArr2);
    }

    public static void assertArrayEquals(String str, float[] fArr, float[] fArr2, float f11) throws ArrayComparisonFailure {
        new InexactComparisonCriteria(f11).arrayEquals(str, fArr, fArr2);
    }

    @Deprecated
    public static void assertEquals(Object[] objArr, Object[] objArr2) {
        assertArrayEquals(objArr, objArr2);
    }

    public static void assertArrayEquals(float[] fArr, float[] fArr2, float f11) {
        assertArrayEquals((String) null, fArr, fArr2, f11);
    }
}
