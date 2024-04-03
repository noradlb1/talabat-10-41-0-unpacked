package org.mockito;

import org.mockito.internal.matchers.ArrayEquals;
import org.mockito.internal.matchers.CompareEqual;
import org.mockito.internal.matchers.EqualsWithDelta;
import org.mockito.internal.matchers.Find;
import org.mockito.internal.matchers.GreaterOrEqual;
import org.mockito.internal.matchers.GreaterThan;
import org.mockito.internal.matchers.LessOrEqual;
import org.mockito.internal.matchers.LessThan;
import org.mockito.internal.progress.ThreadSafeMockingProgress;

public final class AdditionalMatchers {
    private AdditionalMatchers() {
    }

    public static boolean and(boolean z11, boolean z12) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportAnd();
        return false;
    }

    public static <T> T[] aryEq(T[] tArr) {
        reportMatcher(new ArrayEquals(tArr));
        return null;
    }

    public static <T extends Comparable<T>> T cmpEq(T t11) {
        reportMatcher(new CompareEqual(t11));
        return null;
    }

    public static double eq(double d11, double d12) {
        reportMatcher(new EqualsWithDelta(Double.valueOf(d11), Double.valueOf(d12)));
        return 0.0d;
    }

    public static String find(String str) {
        reportMatcher(new Find(str));
        return null;
    }

    public static <T extends Comparable<T>> T geq(T t11) {
        reportMatcher(new GreaterOrEqual(t11));
        return null;
    }

    public static <T extends Comparable<T>> T gt(T t11) {
        reportMatcher(new GreaterThan(t11));
        return null;
    }

    public static <T extends Comparable<T>> T leq(T t11) {
        reportMatcher(new LessOrEqual(t11));
        return null;
    }

    public static <T extends Comparable<T>> T lt(T t11) {
        reportMatcher(new LessThan(t11));
        return null;
    }

    public static <T> T not(T t11) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportNot();
        return null;
    }

    public static boolean or(boolean z11, boolean z12) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportOr();
        return false;
    }

    private static void reportMatcher(ArgumentMatcher<?> argumentMatcher) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportMatcher(argumentMatcher);
    }

    public static byte and(byte b11, byte b12) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportAnd();
        return 0;
    }

    public static short[] aryEq(short[] sArr) {
        reportMatcher(new ArrayEquals(sArr));
        return null;
    }

    public static float eq(float f11, float f12) {
        reportMatcher(new EqualsWithDelta(Float.valueOf(f11), Float.valueOf(f12)));
        return 0.0f;
    }

    public static byte geq(byte b11) {
        reportMatcher(new GreaterOrEqual(Byte.valueOf(b11)));
        return 0;
    }

    public static byte gt(byte b11) {
        reportMatcher(new GreaterThan(Byte.valueOf(b11)));
        return 0;
    }

    public static byte leq(byte b11) {
        reportMatcher(new LessOrEqual(Byte.valueOf(b11)));
        return 0;
    }

    public static byte lt(byte b11) {
        reportMatcher(new LessThan(Byte.valueOf(b11)));
        return 0;
    }

    public static short not(short s11) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportNot();
        return 0;
    }

    public static <T> T or(T t11, T t12) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportOr();
        return null;
    }

    public static char and(char c11, char c12) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportAnd();
        return 0;
    }

    public static long[] aryEq(long[] jArr) {
        reportMatcher(new ArrayEquals(jArr));
        return null;
    }

    public static double geq(double d11) {
        reportMatcher(new GreaterOrEqual(Double.valueOf(d11)));
        return 0.0d;
    }

    public static double gt(double d11) {
        reportMatcher(new GreaterThan(Double.valueOf(d11)));
        return 0.0d;
    }

    public static double leq(double d11) {
        reportMatcher(new LessOrEqual(Double.valueOf(d11)));
        return 0.0d;
    }

    public static double lt(double d11) {
        reportMatcher(new LessThan(Double.valueOf(d11)));
        return 0.0d;
    }

    public static int not(int i11) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportNot();
        return 0;
    }

    public static short or(short s11, short s12) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportOr();
        return 0;
    }

    public static double and(double d11, double d12) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportAnd();
        return 0.0d;
    }

    public static int[] aryEq(int[] iArr) {
        reportMatcher(new ArrayEquals(iArr));
        return null;
    }

    public static float geq(float f11) {
        reportMatcher(new GreaterOrEqual(Float.valueOf(f11)));
        return 0.0f;
    }

    public static float gt(float f11) {
        reportMatcher(new GreaterThan(Float.valueOf(f11)));
        return 0.0f;
    }

    public static float leq(float f11) {
        reportMatcher(new LessOrEqual(Float.valueOf(f11)));
        return 0.0f;
    }

    public static float lt(float f11) {
        reportMatcher(new LessThan(Float.valueOf(f11)));
        return 0.0f;
    }

    public static long not(long j11) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportNot();
        return 0;
    }

    public static long or(long j11, long j12) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportOr();
        return 0;
    }

    public static float and(float f11, float f12) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportAnd();
        return 0.0f;
    }

    public static float[] aryEq(float[] fArr) {
        reportMatcher(new ArrayEquals(fArr));
        return null;
    }

    public static int geq(int i11) {
        reportMatcher(new GreaterOrEqual(Integer.valueOf(i11)));
        return 0;
    }

    public static int gt(int i11) {
        reportMatcher(new GreaterThan(Integer.valueOf(i11)));
        return 0;
    }

    public static int leq(int i11) {
        reportMatcher(new LessOrEqual(Integer.valueOf(i11)));
        return 0;
    }

    public static int lt(int i11) {
        reportMatcher(new LessThan(Integer.valueOf(i11)));
        return 0;
    }

    public static float not(float f11) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportNot();
        return 0.0f;
    }

    public static int or(int i11, int i12) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportOr();
        return 0;
    }

    public static int and(int i11, int i12) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportAnd();
        return 0;
    }

    public static double[] aryEq(double[] dArr) {
        reportMatcher(new ArrayEquals(dArr));
        return null;
    }

    public static long geq(long j11) {
        reportMatcher(new GreaterOrEqual(Long.valueOf(j11)));
        return 0;
    }

    public static long gt(long j11) {
        reportMatcher(new GreaterThan(Long.valueOf(j11)));
        return 0;
    }

    public static long leq(long j11) {
        reportMatcher(new LessOrEqual(Long.valueOf(j11)));
        return 0;
    }

    public static long lt(long j11) {
        reportMatcher(new LessThan(Long.valueOf(j11)));
        return 0;
    }

    public static double not(double d11) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportNot();
        return 0.0d;
    }

    public static float or(float f11, float f12) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportOr();
        return 0.0f;
    }

    public static long and(long j11, long j12) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportAnd();
        return 0;
    }

    public static char[] aryEq(char[] cArr) {
        reportMatcher(new ArrayEquals(cArr));
        return null;
    }

    public static short geq(short s11) {
        reportMatcher(new GreaterOrEqual(Short.valueOf(s11)));
        return 0;
    }

    public static short gt(short s11) {
        reportMatcher(new GreaterThan(Short.valueOf(s11)));
        return 0;
    }

    public static short leq(short s11) {
        reportMatcher(new LessOrEqual(Short.valueOf(s11)));
        return 0;
    }

    public static short lt(short s11) {
        reportMatcher(new LessThan(Short.valueOf(s11)));
        return 0;
    }

    public static char not(char c11) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportNot();
        return 0;
    }

    public static double or(double d11, double d12) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportOr();
        return 0.0d;
    }

    public static short and(short s11, short s12) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportAnd();
        return 0;
    }

    public static byte[] aryEq(byte[] bArr) {
        reportMatcher(new ArrayEquals(bArr));
        return null;
    }

    public static boolean not(boolean z11) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportNot();
        return false;
    }

    public static char or(char c11, char c12) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportOr();
        return 0;
    }

    public static <T> T and(T t11, T t12) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportAnd();
        return null;
    }

    public static boolean[] aryEq(boolean[] zArr) {
        reportMatcher(new ArrayEquals(zArr));
        return null;
    }

    public static byte not(byte b11) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportNot();
        return 0;
    }

    public static byte or(byte b11, byte b12) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportOr();
        return 0;
    }
}
