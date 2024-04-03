package org.junit.jupiter.api;

import j$.time.Duration;
import j$.util.function.BooleanSupplier;
import j$.util.function.Supplier;
import j$.util.stream.Stream;
import java.util.Collection;
import java.util.List;
import org.apiguardian.api.API;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.opentest4j.MultipleFailuresError;

@API(since = "5.0", status = API.Status.STABLE)
public class Assertions {

    @API(since = "5.9.1", status = API.Status.INTERNAL)
    public interface TimeoutFailureFactory<T extends Throwable> {
        T createTimeoutFailure(Duration duration, Supplier<String> supplier, Throwable th2);
    }

    public static void assertAll(Executable... executableArr) throws MultipleFailuresError {
        AssertAll.g(executableArr);
    }

    public static void assertArrayEquals(boolean[] zArr, boolean[] zArr2) {
        AssertArrayEquals.E(zArr, zArr2);
    }

    @API(since = "5.2", status = API.Status.STABLE)
    public static void assertDoesNotThrow(Executable executable) {
        AssertDoesNotThrow.d(executable);
    }

    public static void assertEquals(short s11, short s12) {
        AssertEquals.B(s11, s12);
    }

    public static void assertFalse(boolean z11) {
        AssertFalse.d(z11);
    }

    @API(since = "5.8", status = API.Status.EXPERIMENTAL)
    public static <T> T assertInstanceOf(Class<T> cls, Object obj) {
        return AssertInstanceOf.a(cls, obj);
    }

    public static void assertIterableEquals(Iterable<?> iterable, Iterable<?> iterable2) {
        AssertIterableEquals.c(iterable, iterable2);
    }

    public static void assertLinesMatch(List<String> list, List<String> list2) {
        AssertLinesMatch.b(list, list2);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(byte b11, byte b12) {
        AssertNotEquals.a(b11, b12);
    }

    public static void assertNotNull(Object obj) {
        AssertNotNull.a(obj);
    }

    public static void assertNotSame(Object obj, Object obj2) {
        AssertNotSame.a(obj, obj2);
    }

    public static void assertNull(Object obj) {
        AssertNull.a(obj);
    }

    public static void assertSame(Object obj, Object obj2) {
        AssertSame.a(obj, obj2);
    }

    public static <T extends Throwable> T assertThrows(Class<T> cls, Executable executable) {
        return AssertThrows.a(cls, executable);
    }

    @API(since = "5.8", status = API.Status.EXPERIMENTAL)
    public static <T extends Throwable> T assertThrowsExactly(Class<T> cls, Executable executable) {
        return AssertThrowsExactly.a(cls, executable);
    }

    public static void assertTimeout(Duration duration, Executable executable) {
        AssertTimeout.f(duration, executable);
    }

    public static void assertTimeoutPreemptively(Duration duration, Executable executable) {
        AssertTimeoutPreemptively.j(duration, executable);
    }

    public static void assertTrue(boolean z11) {
        AssertTrue.d(z11);
    }

    public static <V> V fail() {
        AssertionUtils.e();
        return null;
    }

    public static void assertAll(String str, Executable... executableArr) throws MultipleFailuresError {
        AssertAll.d(str, executableArr);
    }

    public static void assertArrayEquals(boolean[] zArr, boolean[] zArr2, String str) {
        AssertArrayEquals.F(zArr, zArr2, str);
    }

    @API(since = "5.2", status = API.Status.STABLE)
    public static void assertDoesNotThrow(Executable executable, String str) {
        AssertDoesNotThrow.e(executable, str);
    }

    public static void assertEquals(short s11, Short sh2) {
        AssertEquals.y(Short.valueOf(s11), sh2);
    }

    public static void assertFalse(boolean z11, String str) {
        AssertFalse.e(z11, str);
    }

    @API(since = "5.8", status = API.Status.EXPERIMENTAL)
    public static <T> T assertInstanceOf(Class<T> cls, Object obj, String str) {
        return AssertInstanceOf.b(cls, obj, str);
    }

    public static void assertIterableEquals(Iterable<?> iterable, Iterable<?> iterable2, String str) {
        AssertIterableEquals.d(iterable, iterable2, str);
    }

    public static void assertLinesMatch(List<String> list, List<String> list2, String str) {
        AssertLinesMatch.d(list, list2, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(byte b11, Byte b12) {
        AssertNotEquals.y(Byte.valueOf(b11), b12);
    }

    public static void assertNotNull(Object obj, String str) {
        AssertNotNull.b(obj, str);
    }

    public static void assertNotSame(Object obj, Object obj2, String str) {
        AssertNotSame.b(obj, obj2, str);
    }

    public static void assertNull(Object obj, String str) {
        AssertNull.b(obj, str);
    }

    public static void assertSame(Object obj, Object obj2, String str) {
        AssertSame.b(obj, obj2, str);
    }

    public static <T extends Throwable> T assertThrows(Class<T> cls, Executable executable, String str) {
        return AssertThrows.b(cls, executable, str);
    }

    @API(since = "5.8", status = API.Status.EXPERIMENTAL)
    public static <T extends Throwable> T assertThrowsExactly(Class<T> cls, Executable executable, String str) {
        return AssertThrowsExactly.b(cls, executable, str);
    }

    public static void assertTimeout(Duration duration, Executable executable, String str) {
        AssertTimeout.g(duration, executable, str);
    }

    public static void assertTimeoutPreemptively(Duration duration, Executable executable, String str) {
        AssertTimeoutPreemptively.k(duration, executable, str);
    }

    public static void assertTrue(boolean z11, Supplier<String> supplier) {
        AssertTrue.f(z11, supplier);
    }

    public static <V> V fail(String str) {
        AssertionUtils.f(str);
        return null;
    }

    public static void assertAll(Collection<Executable> collection) throws MultipleFailuresError {
        AssertAll.e(collection);
    }

    public static void assertArrayEquals(boolean[] zArr, boolean[] zArr2, Supplier<String> supplier) {
        AssertArrayEquals.G(zArr, zArr2, supplier);
    }

    @API(since = "5.2", status = API.Status.STABLE)
    public static void assertDoesNotThrow(Executable executable, Supplier<String> supplier) {
        AssertDoesNotThrow.f(executable, supplier);
    }

    public static void assertEquals(Short sh2, short s11) {
        AssertEquals.y(sh2, Short.valueOf(s11));
    }

    public static void assertFalse(boolean z11, Supplier<String> supplier) {
        AssertFalse.f(z11, supplier);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [j$.util.function.Supplier, j$.util.function.Supplier<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.apiguardian.api.API(since = "5.8", status = org.apiguardian.api.API.Status.EXPERIMENTAL)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T assertInstanceOf(java.lang.Class<T> r0, java.lang.Object r1, j$.util.function.Supplier<java.lang.String> r2) {
        /*
            java.lang.Object r0 = org.junit.jupiter.api.AssertInstanceOf.c(r0, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.api.Assertions.assertInstanceOf(java.lang.Class, java.lang.Object, j$.util.function.Supplier):java.lang.Object");
    }

    public static void assertIterableEquals(Iterable<?> iterable, Iterable<?> iterable2, Supplier<String> supplier) {
        AssertIterableEquals.e(iterable, iterable2, supplier);
    }

    public static void assertLinesMatch(List<String> list, List<String> list2, Supplier<String> supplier) {
        AssertLinesMatch.c(list, list2, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Byte b11, byte b12) {
        AssertNotEquals.y(b11, Byte.valueOf(b12));
    }

    public static void assertNotNull(Object obj, Supplier<String> supplier) {
        AssertNotNull.c(obj, supplier);
    }

    public static void assertNotSame(Object obj, Object obj2, Supplier<String> supplier) {
        AssertNotSame.c(obj, obj2, supplier);
    }

    public static void assertNull(Object obj, Supplier<String> supplier) {
        AssertNull.c(obj, supplier);
    }

    public static void assertSame(Object obj, Object obj2, Supplier<String> supplier) {
        AssertSame.c(obj, obj2, supplier);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [j$.util.function.Supplier, j$.util.function.Supplier<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends java.lang.Throwable> T assertThrows(java.lang.Class<T> r0, org.junit.jupiter.api.function.Executable r1, j$.util.function.Supplier<java.lang.String> r2) {
        /*
            java.lang.Throwable r0 = org.junit.jupiter.api.AssertThrows.c(r0, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.api.Assertions.assertThrows(java.lang.Class, org.junit.jupiter.api.function.Executable, j$.util.function.Supplier):java.lang.Throwable");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [j$.util.function.Supplier, j$.util.function.Supplier<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.apiguardian.api.API(since = "5.8", status = org.apiguardian.api.API.Status.EXPERIMENTAL)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends java.lang.Throwable> T assertThrowsExactly(java.lang.Class<T> r0, org.junit.jupiter.api.function.Executable r1, j$.util.function.Supplier<java.lang.String> r2) {
        /*
            java.lang.Throwable r0 = org.junit.jupiter.api.AssertThrowsExactly.c(r0, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.api.Assertions.assertThrowsExactly(java.lang.Class, org.junit.jupiter.api.function.Executable, j$.util.function.Supplier):java.lang.Throwable");
    }

    public static void assertTimeout(Duration duration, Executable executable, Supplier<String> supplier) {
        AssertTimeout.h(duration, executable, supplier);
    }

    public static void assertTimeoutPreemptively(Duration duration, Executable executable, Supplier<String> supplier) {
        AssertTimeoutPreemptively.l(duration, executable, supplier);
    }

    public static void assertTrue(BooleanSupplier booleanSupplier) {
        AssertTrue.a(booleanSupplier);
    }

    public static <V> V fail(String str, Throwable th2) {
        AssertionUtils.g(str, th2);
        return null;
    }

    public static void assertAll(String str, Collection<Executable> collection) throws MultipleFailuresError {
        AssertAll.b(str, collection);
    }

    public static void assertArrayEquals(char[] cArr, char[] cArr2) {
        AssertArrayEquals.d(cArr, cArr2);
    }

    @API(since = "5.2", status = API.Status.STABLE)
    public static <T> T assertDoesNotThrow(ThrowingSupplier<T> throwingSupplier) {
        return AssertDoesNotThrow.a(throwingSupplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Short sh2, Short sh3) {
        AssertEquals.y(sh2, sh3);
    }

    public static void assertFalse(BooleanSupplier booleanSupplier) {
        AssertFalse.a(booleanSupplier);
    }

    public static void assertLinesMatch(Stream<String> stream, Stream<String> stream2) {
        AssertLinesMatch.e(stream, stream2);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Byte b11, Byte b12) {
        AssertNotEquals.y(b11, b12);
    }

    public static <T> T assertTimeout(Duration duration, ThrowingSupplier<T> throwingSupplier) {
        return AssertTimeout.c(duration, throwingSupplier);
    }

    public static <T> T assertTimeoutPreemptively(Duration duration, ThrowingSupplier<T> throwingSupplier) {
        return AssertTimeoutPreemptively.f(duration, throwingSupplier);
    }

    public static void assertTrue(BooleanSupplier booleanSupplier, String str) {
        AssertTrue.b(booleanSupplier, str);
    }

    public static <V> V fail(Throwable th2) {
        AssertionUtils.h(th2);
        return null;
    }

    public static void assertAll(Stream<Executable> stream) throws MultipleFailuresError {
        AssertAll.f(stream);
    }

    public static void assertArrayEquals(char[] cArr, char[] cArr2, String str) {
        AssertArrayEquals.e(cArr, cArr2, str);
    }

    @API(since = "5.2", status = API.Status.STABLE)
    public static <T> T assertDoesNotThrow(ThrowingSupplier<T> throwingSupplier, String str) {
        return AssertDoesNotThrow.b(throwingSupplier, str);
    }

    public static void assertEquals(short s11, short s12, String str) {
        AssertEquals.C(s11, s12, str);
    }

    public static void assertFalse(BooleanSupplier booleanSupplier, String str) {
        AssertFalse.b(booleanSupplier, str);
    }

    public static void assertLinesMatch(Stream<String> stream, Stream<String> stream2, String str) {
        AssertLinesMatch.g(stream, stream2, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(byte b11, byte b12, String str) {
        AssertNotEquals.b(b11, b12, str);
    }

    public static <T> T assertTimeout(Duration duration, ThrowingSupplier<T> throwingSupplier, String str) {
        return AssertTimeout.d(duration, throwingSupplier, str);
    }

    public static <T> T assertTimeoutPreemptively(Duration duration, ThrowingSupplier<T> throwingSupplier, String str) {
        return AssertTimeoutPreemptively.g(duration, throwingSupplier, str);
    }

    public static void assertTrue(boolean z11, String str) {
        AssertTrue.e(z11, str);
    }

    public static <V> V fail(Supplier<String> supplier) {
        AssertionUtils.i(supplier);
        return null;
    }

    public static void assertAll(String str, Stream<Executable> stream) throws MultipleFailuresError {
        AssertAll.c(str, stream);
    }

    public static void assertArrayEquals(char[] cArr, char[] cArr2, Supplier<String> supplier) {
        AssertArrayEquals.f(cArr, cArr2, supplier);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [j$.util.function.Supplier, j$.util.function.Supplier<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.apiguardian.api.API(since = "5.2", status = org.apiguardian.api.API.Status.STABLE)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T assertDoesNotThrow(org.junit.jupiter.api.function.ThrowingSupplier<T> r0, j$.util.function.Supplier<java.lang.String> r1) {
        /*
            java.lang.Object r0 = org.junit.jupiter.api.AssertDoesNotThrow.c(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.api.Assertions.assertDoesNotThrow(org.junit.jupiter.api.function.ThrowingSupplier, j$.util.function.Supplier):java.lang.Object");
    }

    public static void assertEquals(short s11, Short sh2, String str) {
        AssertEquals.z(Short.valueOf(s11), sh2, str);
    }

    public static void assertFalse(BooleanSupplier booleanSupplier, Supplier<String> supplier) {
        AssertFalse.c(booleanSupplier, supplier);
    }

    public static void assertLinesMatch(Stream<String> stream, Stream<String> stream2, Supplier<String> supplier) {
        AssertLinesMatch.f(stream, stream2, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(byte b11, Byte b12, String str) {
        AssertNotEquals.z(Byte.valueOf(b11), b12, str);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [j$.util.function.Supplier, j$.util.function.Supplier<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T assertTimeout(j$.time.Duration r0, org.junit.jupiter.api.function.ThrowingSupplier<T> r1, j$.util.function.Supplier<java.lang.String> r2) {
        /*
            java.lang.Object r0 = org.junit.jupiter.api.AssertTimeout.e(r0, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.api.Assertions.assertTimeout(j$.time.Duration, org.junit.jupiter.api.function.ThrowingSupplier, j$.util.function.Supplier):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [j$.util.function.Supplier, j$.util.function.Supplier<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T assertTimeoutPreemptively(j$.time.Duration r0, org.junit.jupiter.api.function.ThrowingSupplier<T> r1, j$.util.function.Supplier<java.lang.String> r2) {
        /*
            java.lang.Object r0 = org.junit.jupiter.api.AssertTimeoutPreemptively.h(r0, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.api.Assertions.assertTimeoutPreemptively(j$.time.Duration, org.junit.jupiter.api.function.ThrowingSupplier, j$.util.function.Supplier):java.lang.Object");
    }

    public static void assertTrue(BooleanSupplier booleanSupplier, Supplier<String> supplier) {
        AssertTrue.c(booleanSupplier, supplier);
    }

    public static void assertArrayEquals(byte[] bArr, byte[] bArr2) {
        AssertArrayEquals.a(bArr, bArr2);
    }

    public static void assertEquals(Short sh2, short s11, String str) {
        AssertEquals.z(sh2, Short.valueOf(s11), str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Byte b11, byte b12, String str) {
        AssertNotEquals.z(b11, Byte.valueOf(b12), str);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [j$.util.function.Supplier, j$.util.function.Supplier<java.lang.String>] */
    /* JADX WARNING: type inference failed for: r3v0, types: [org.junit.jupiter.api.Assertions$TimeoutFailureFactory, org.junit.jupiter.api.Assertions$TimeoutFailureFactory<E>] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @org.apiguardian.api.API(since = "5.9.1", status = org.apiguardian.api.API.Status.INTERNAL)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T, E extends java.lang.Throwable> T assertTimeoutPreemptively(j$.time.Duration r0, org.junit.jupiter.api.function.ThrowingSupplier<T> r1, j$.util.function.Supplier<java.lang.String> r2, org.junit.jupiter.api.Assertions.TimeoutFailureFactory<E> r3) throws java.lang.Throwable {
        /*
            java.lang.Object r0 = org.junit.jupiter.api.AssertTimeoutPreemptively.i(r0, r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.api.Assertions.assertTimeoutPreemptively(j$.time.Duration, org.junit.jupiter.api.function.ThrowingSupplier, j$.util.function.Supplier, org.junit.jupiter.api.Assertions$TimeoutFailureFactory):java.lang.Object");
    }

    public static void assertArrayEquals(byte[] bArr, byte[] bArr2, String str) {
        AssertArrayEquals.b(bArr, bArr2, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Short sh2, Short sh3, String str) {
        AssertEquals.z(sh2, sh3, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Byte b11, Byte b12, String str) {
        AssertNotEquals.z(b11, b12, str);
    }

    public static void assertArrayEquals(byte[] bArr, byte[] bArr2, Supplier<String> supplier) {
        AssertArrayEquals.c(bArr, bArr2, supplier);
    }

    public static void assertEquals(short s11, short s12, Supplier<String> supplier) {
        AssertEquals.D(s11, s12, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(byte b11, byte b12, Supplier<String> supplier) {
        AssertNotEquals.c(b11, b12, supplier);
    }

    public static void assertArrayEquals(short[] sArr, short[] sArr2) {
        AssertArrayEquals.B(sArr, sArr2);
    }

    public static void assertEquals(short s11, Short sh2, Supplier<String> supplier) {
        AssertEquals.A(Short.valueOf(s11), sh2, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(byte b11, Byte b12, Supplier<String> supplier) {
        AssertNotEquals.A(Byte.valueOf(b11), b12, supplier);
    }

    public static void assertArrayEquals(short[] sArr, short[] sArr2, String str) {
        AssertArrayEquals.C(sArr, sArr2, str);
    }

    public static void assertEquals(Short sh2, short s11, Supplier<String> supplier) {
        AssertEquals.A(sh2, Short.valueOf(s11), supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Byte b11, byte b12, Supplier<String> supplier) {
        AssertNotEquals.A(b11, Byte.valueOf(b12), supplier);
    }

    public static void assertArrayEquals(short[] sArr, short[] sArr2, Supplier<String> supplier) {
        AssertArrayEquals.D(sArr, sArr2, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Short sh2, Short sh3, Supplier<String> supplier) {
        AssertEquals.A(sh2, sh3, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Byte b11, Byte b12, Supplier<String> supplier) {
        AssertNotEquals.A(b11, b12, supplier);
    }

    public static void assertArrayEquals(int[] iArr, int[] iArr2) {
        AssertArrayEquals.s(iArr, iArr2);
    }

    public static void assertEquals(byte b11, byte b12) {
        AssertEquals.a(b11, b12);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(short s11, short s12) {
        AssertNotEquals.B(s11, s12);
    }

    public static void assertArrayEquals(int[] iArr, int[] iArr2, String str) {
        AssertArrayEquals.t(iArr, iArr2, str);
    }

    public static void assertEquals(byte b11, Byte b12) {
        AssertEquals.y(Byte.valueOf(b11), b12);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(short s11, Short sh2) {
        AssertNotEquals.y(Short.valueOf(s11), sh2);
    }

    public static void assertArrayEquals(int[] iArr, int[] iArr2, Supplier<String> supplier) {
        AssertArrayEquals.u(iArr, iArr2, supplier);
    }

    public static void assertEquals(Byte b11, byte b12) {
        AssertEquals.y(b11, Byte.valueOf(b12));
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Short sh2, short s11) {
        AssertNotEquals.y(sh2, Short.valueOf(s11));
    }

    public static void assertArrayEquals(long[] jArr, long[] jArr2) {
        AssertArrayEquals.v(jArr, jArr2);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Byte b11, Byte b12) {
        AssertEquals.y(b11, b12);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Short sh2, Short sh3) {
        AssertNotEquals.y(sh2, sh3);
    }

    public static void assertArrayEquals(long[] jArr, long[] jArr2, String str) {
        AssertArrayEquals.w(jArr, jArr2, str);
    }

    public static void assertEquals(byte b11, byte b12, String str) {
        AssertEquals.b(b11, b12, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(short s11, short s12, String str) {
        AssertNotEquals.C(s11, s12, str);
    }

    public static void assertArrayEquals(long[] jArr, long[] jArr2, Supplier<String> supplier) {
        AssertArrayEquals.x(jArr, jArr2, supplier);
    }

    public static void assertEquals(byte b11, Byte b12, String str) {
        AssertEquals.z(Byte.valueOf(b11), b12, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(short s11, Short sh2, String str) {
        AssertNotEquals.z(Short.valueOf(s11), sh2, str);
    }

    public static void assertArrayEquals(float[] fArr, float[] fArr2) {
        AssertArrayEquals.m(fArr, fArr2);
    }

    public static void assertEquals(Byte b11, byte b12, String str) {
        AssertEquals.z(b11, Byte.valueOf(b12), str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Short sh2, short s11, String str) {
        AssertNotEquals.z(sh2, Short.valueOf(s11), str);
    }

    public static void assertArrayEquals(float[] fArr, float[] fArr2, String str) {
        AssertArrayEquals.q(fArr, fArr2, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Byte b11, Byte b12, String str) {
        AssertEquals.z(b11, b12, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Short sh2, Short sh3, String str) {
        AssertNotEquals.z(sh2, sh3, str);
    }

    public static void assertArrayEquals(float[] fArr, float[] fArr2, Supplier<String> supplier) {
        AssertArrayEquals.r(fArr, fArr2, supplier);
    }

    public static void assertEquals(byte b11, byte b12, Supplier<String> supplier) {
        AssertEquals.c(b11, b12, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(short s11, short s12, Supplier<String> supplier) {
        AssertNotEquals.D(s11, s12, supplier);
    }

    public static void assertArrayEquals(float[] fArr, float[] fArr2, float f11) {
        AssertArrayEquals.n(fArr, fArr2, f11);
    }

    public static void assertEquals(byte b11, Byte b12, Supplier<String> supplier) {
        AssertEquals.A(Byte.valueOf(b11), b12, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(short s11, Short sh2, Supplier<String> supplier) {
        AssertNotEquals.A(Short.valueOf(s11), sh2, supplier);
    }

    public static void assertArrayEquals(float[] fArr, float[] fArr2, float f11, String str) {
        AssertArrayEquals.o(fArr, fArr2, f11, str);
    }

    public static void assertEquals(Byte b11, byte b12, Supplier<String> supplier) {
        AssertEquals.A(b11, Byte.valueOf(b12), supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Short sh2, short s11, Supplier<String> supplier) {
        AssertNotEquals.A(sh2, Short.valueOf(s11), supplier);
    }

    public static void assertArrayEquals(float[] fArr, float[] fArr2, float f11, Supplier<String> supplier) {
        AssertArrayEquals.p(fArr, fArr2, f11, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Byte b11, Byte b12, Supplier<String> supplier) {
        AssertEquals.A(b11, b12, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Short sh2, Short sh3, Supplier<String> supplier) {
        AssertNotEquals.A(sh2, sh3, supplier);
    }

    public static void assertArrayEquals(double[] dArr, double[] dArr2) {
        AssertArrayEquals.g(dArr, dArr2);
    }

    public static void assertEquals(int i11, int i12) {
        AssertEquals.s(i11, i12);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(int i11, int i12) {
        AssertNotEquals.s(i11, i12);
    }

    public static void assertArrayEquals(double[] dArr, double[] dArr2, String str) {
        AssertArrayEquals.k(dArr, dArr2, str);
    }

    public static void assertEquals(int i11, Integer num) {
        AssertEquals.y(Integer.valueOf(i11), num);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(int i11, Integer num) {
        AssertNotEquals.y(Integer.valueOf(i11), num);
    }

    public static void assertArrayEquals(double[] dArr, double[] dArr2, Supplier<String> supplier) {
        AssertArrayEquals.l(dArr, dArr2, supplier);
    }

    public static void assertEquals(Integer num, int i11) {
        AssertEquals.y(num, Integer.valueOf(i11));
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Integer num, int i11) {
        AssertNotEquals.y(num, Integer.valueOf(i11));
    }

    public static void assertArrayEquals(double[] dArr, double[] dArr2, double d11) {
        AssertArrayEquals.h(dArr, dArr2, d11);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Integer num, Integer num2) {
        AssertEquals.y(num, num2);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Integer num, Integer num2) {
        AssertNotEquals.y(num, num2);
    }

    public static void assertArrayEquals(double[] dArr, double[] dArr2, double d11, String str) {
        AssertArrayEquals.i(dArr, dArr2, d11, str);
    }

    public static void assertEquals(int i11, int i12, String str) {
        AssertEquals.t(i11, i12, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(int i11, int i12, String str) {
        AssertNotEquals.t(i11, i12, str);
    }

    public static void assertArrayEquals(double[] dArr, double[] dArr2, double d11, Supplier<String> supplier) {
        AssertArrayEquals.j(dArr, dArr2, d11, supplier);
    }

    public static void assertEquals(int i11, Integer num, String str) {
        AssertEquals.z(Integer.valueOf(i11), num, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(int i11, Integer num, String str) {
        AssertNotEquals.z(Integer.valueOf(i11), num, str);
    }

    public static void assertArrayEquals(Object[] objArr, Object[] objArr2) {
        AssertArrayEquals.y(objArr, objArr2);
    }

    public static void assertEquals(Integer num, int i11, String str) {
        AssertEquals.z(num, Integer.valueOf(i11), str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Integer num, int i11, String str) {
        AssertNotEquals.z(num, Integer.valueOf(i11), str);
    }

    public static void assertArrayEquals(Object[] objArr, Object[] objArr2, String str) {
        AssertArrayEquals.z(objArr, objArr2, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Integer num, Integer num2, String str) {
        AssertEquals.z(num, num2, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Integer num, Integer num2, String str) {
        AssertNotEquals.z(num, num2, str);
    }

    public static void assertArrayEquals(Object[] objArr, Object[] objArr2, Supplier<String> supplier) {
        AssertArrayEquals.A(objArr, objArr2, supplier);
    }

    public static void assertEquals(int i11, int i12, Supplier<String> supplier) {
        AssertEquals.u(i11, i12, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(int i11, int i12, Supplier<String> supplier) {
        AssertNotEquals.u(i11, i12, supplier);
    }

    public static void assertEquals(int i11, Integer num, Supplier<String> supplier) {
        AssertEquals.A(Integer.valueOf(i11), num, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(int i11, Integer num, Supplier<String> supplier) {
        AssertNotEquals.A(Integer.valueOf(i11), num, supplier);
    }

    public static void assertEquals(Integer num, int i11, Supplier<String> supplier) {
        AssertEquals.A(num, Integer.valueOf(i11), supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Integer num, int i11, Supplier<String> supplier) {
        AssertNotEquals.A(num, Integer.valueOf(i11), supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Integer num, Integer num2, Supplier<String> supplier) {
        AssertEquals.A(num, num2, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Integer num, Integer num2, Supplier<String> supplier) {
        AssertNotEquals.A(num, num2, supplier);
    }

    public static void assertEquals(long j11, long j12) {
        AssertEquals.v(j11, j12);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(long j11, long j12) {
        AssertNotEquals.v(j11, j12);
    }

    public static void assertEquals(long j11, Long l11) {
        AssertEquals.y(Long.valueOf(j11), l11);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(long j11, Long l11) {
        AssertNotEquals.y(Long.valueOf(j11), l11);
    }

    public static void assertEquals(Long l11, long j11) {
        AssertEquals.y(l11, Long.valueOf(j11));
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Long l11, long j11) {
        AssertNotEquals.y(l11, Long.valueOf(j11));
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Long l11, Long l12) {
        AssertEquals.y(l11, l12);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Long l11, Long l12) {
        AssertNotEquals.y(l11, l12);
    }

    public static void assertEquals(long j11, long j12, String str) {
        AssertEquals.w(j11, j12, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(long j11, long j12, String str) {
        AssertNotEquals.w(j11, j12, str);
    }

    public static void assertEquals(long j11, Long l11, String str) {
        AssertEquals.z(Long.valueOf(j11), l11, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(long j11, Long l11, String str) {
        AssertNotEquals.z(Long.valueOf(j11), l11, str);
    }

    public static void assertEquals(Long l11, long j11, String str) {
        AssertEquals.z(l11, Long.valueOf(j11), str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Long l11, long j11, String str) {
        AssertNotEquals.z(l11, Long.valueOf(j11), str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Long l11, Long l12, String str) {
        AssertEquals.z(l11, l12, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Long l11, Long l12, String str) {
        AssertNotEquals.z(l11, l12, str);
    }

    public static void assertEquals(long j11, long j12, Supplier<String> supplier) {
        AssertEquals.x(j11, j12, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(long j11, long j12, Supplier<String> supplier) {
        AssertNotEquals.x(j11, j12, supplier);
    }

    public static void assertEquals(long j11, Long l11, Supplier<String> supplier) {
        AssertEquals.A(Long.valueOf(j11), l11, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(long j11, Long l11, Supplier<String> supplier) {
        AssertNotEquals.A(Long.valueOf(j11), l11, supplier);
    }

    public static void assertEquals(Long l11, long j11, Supplier<String> supplier) {
        AssertEquals.A(l11, Long.valueOf(j11), supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Long l11, long j11, Supplier<String> supplier) {
        AssertNotEquals.A(l11, Long.valueOf(j11), supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Long l11, Long l12, Supplier<String> supplier) {
        AssertEquals.A(l11, l12, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Long l11, Long l12, Supplier<String> supplier) {
        AssertNotEquals.A(l11, l12, supplier);
    }

    public static void assertEquals(float f11, float f12) {
        AssertEquals.m(f11, f12);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(float f11, float f12) {
        AssertNotEquals.m(f11, f12);
    }

    public static void assertEquals(float f11, Float f12) {
        AssertEquals.y(Float.valueOf(f11), f12);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(float f11, Float f12) {
        AssertNotEquals.y(Float.valueOf(f11), f12);
    }

    public static void assertEquals(Float f11, float f12) {
        AssertEquals.y(f11, Float.valueOf(f12));
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Float f11, float f12) {
        AssertNotEquals.y(f11, Float.valueOf(f12));
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Float f11, Float f12) {
        AssertEquals.y(f11, f12);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Float f11, Float f12) {
        AssertNotEquals.y(f11, f12);
    }

    public static void assertEquals(float f11, float f12, String str) {
        AssertEquals.q(f11, f12, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(float f11, float f12, String str) {
        AssertNotEquals.q(f11, f12, str);
    }

    public static void assertEquals(float f11, Float f12, String str) {
        AssertEquals.z(Float.valueOf(f11), f12, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(float f11, Float f12, String str) {
        AssertNotEquals.z(Float.valueOf(f11), f12, str);
    }

    public static void assertEquals(Float f11, float f12, String str) {
        AssertEquals.z(f11, Float.valueOf(f12), str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Float f11, float f12, String str) {
        AssertNotEquals.z(f11, Float.valueOf(f12), str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Float f11, Float f12, String str) {
        AssertEquals.z(f11, f12, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Float f11, Float f12, String str) {
        AssertNotEquals.z(f11, f12, str);
    }

    public static void assertEquals(float f11, float f12, Supplier<String> supplier) {
        AssertEquals.r(f11, f12, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(float f11, float f12, Supplier<String> supplier) {
        AssertNotEquals.r(f11, f12, supplier);
    }

    public static void assertEquals(float f11, Float f12, Supplier<String> supplier) {
        AssertEquals.A(Float.valueOf(f11), f12, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(float f11, Float f12, Supplier<String> supplier) {
        AssertNotEquals.A(Float.valueOf(f11), f12, supplier);
    }

    public static void assertEquals(Float f11, float f12, Supplier<String> supplier) {
        AssertEquals.A(f11, Float.valueOf(f12), supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Float f11, float f12, Supplier<String> supplier) {
        AssertNotEquals.A(f11, Float.valueOf(f12), supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Float f11, Float f12, Supplier<String> supplier) {
        AssertEquals.A(f11, f12, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Float f11, Float f12, Supplier<String> supplier) {
        AssertNotEquals.A(f11, f12, supplier);
    }

    public static void assertEquals(float f11, float f12, float f13) {
        AssertEquals.n(f11, f12, f13);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(float f11, float f12, float f13) {
        AssertNotEquals.n(f11, f12, f13);
    }

    public static void assertEquals(float f11, float f12, float f13, String str) {
        AssertEquals.o(f11, f12, f13, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(float f11, float f12, float f13, String str) {
        AssertNotEquals.o(f11, f12, f13, str);
    }

    public static void assertEquals(float f11, float f12, float f13, Supplier<String> supplier) {
        AssertEquals.p(f11, f12, f13, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(float f11, float f12, float f13, Supplier<String> supplier) {
        AssertNotEquals.p(f11, f12, f13, supplier);
    }

    public static void assertEquals(double d11, double d12) {
        AssertEquals.g(d11, d12);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(double d11, double d12) {
        AssertNotEquals.g(d11, d12);
    }

    public static void assertEquals(double d11, Double d12) {
        AssertEquals.y(Double.valueOf(d11), d12);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(double d11, Double d12) {
        AssertNotEquals.y(Double.valueOf(d11), d12);
    }

    public static void assertEquals(Double d11, double d12) {
        AssertEquals.y(d11, Double.valueOf(d12));
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Double d11, double d12) {
        AssertNotEquals.y(d11, Double.valueOf(d12));
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Double d11, Double d12) {
        AssertEquals.y(d11, d12);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Double d11, Double d12) {
        AssertNotEquals.y(d11, d12);
    }

    public static void assertEquals(double d11, double d12, String str) {
        AssertEquals.k(d11, d12, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(double d11, double d12, String str) {
        AssertNotEquals.k(d11, d12, str);
    }

    public static void assertEquals(double d11, Double d12, String str) {
        AssertEquals.z(Double.valueOf(d11), d12, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(double d11, Double d12, String str) {
        AssertNotEquals.z(Double.valueOf(d11), d12, str);
    }

    public static void assertEquals(Double d11, double d12, String str) {
        AssertEquals.z(d11, Double.valueOf(d12), str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Double d11, double d12, String str) {
        AssertNotEquals.z(d11, Double.valueOf(d12), str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Double d11, Double d12, String str) {
        AssertEquals.z(d11, d12, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Double d11, Double d12, String str) {
        AssertNotEquals.z(d11, d12, str);
    }

    public static void assertEquals(double d11, double d12, Supplier<String> supplier) {
        AssertEquals.l(d11, d12, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(double d11, double d12, Supplier<String> supplier) {
        AssertNotEquals.l(d11, d12, supplier);
    }

    public static void assertEquals(double d11, Double d12, Supplier<String> supplier) {
        AssertEquals.A(Double.valueOf(d11), d12, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(double d11, Double d12, Supplier<String> supplier) {
        AssertNotEquals.A(Double.valueOf(d11), d12, supplier);
    }

    public static void assertEquals(Double d11, double d12, Supplier<String> supplier) {
        AssertEquals.A(d11, Double.valueOf(d12), supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Double d11, double d12, Supplier<String> supplier) {
        AssertNotEquals.A(d11, Double.valueOf(d12), supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Double d11, Double d12, Supplier<String> supplier) {
        AssertEquals.A(d11, d12, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Double d11, Double d12, Supplier<String> supplier) {
        AssertNotEquals.A(d11, d12, supplier);
    }

    public static void assertEquals(double d11, double d12, double d13) {
        AssertEquals.h(d11, d12, d13);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(double d11, double d12, double d13) {
        AssertNotEquals.h(d11, d12, d13);
    }

    public static void assertEquals(double d11, double d12, double d13, String str) {
        AssertEquals.i(d11, d12, d13, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(double d11, double d12, double d13, String str) {
        AssertNotEquals.i(d11, d12, d13, str);
    }

    public static void assertEquals(double d11, double d12, double d13, Supplier<String> supplier) {
        AssertEquals.j(d11, d12, d13, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(double d11, double d12, double d13, Supplier<String> supplier) {
        AssertNotEquals.j(d11, d12, d13, supplier);
    }

    public static void assertEquals(char c11, char c12) {
        AssertEquals.d(c11, c12);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(char c11, char c12) {
        AssertNotEquals.d(c11, c12);
    }

    public static void assertEquals(char c11, Character ch2) {
        AssertEquals.y(Character.valueOf(c11), ch2);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(char c11, Character ch2) {
        AssertNotEquals.y(Character.valueOf(c11), ch2);
    }

    public static void assertEquals(Character ch2, char c11) {
        AssertEquals.y(ch2, Character.valueOf(c11));
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Character ch2, char c11) {
        AssertNotEquals.y(ch2, Character.valueOf(c11));
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Character ch2, Character ch3) {
        AssertEquals.y(ch2, ch3);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Character ch2, Character ch3) {
        AssertNotEquals.y(ch2, ch3);
    }

    public static void assertEquals(char c11, char c12, String str) {
        AssertEquals.e(c11, c12, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(char c11, char c12, String str) {
        AssertNotEquals.e(c11, c12, str);
    }

    public static void assertEquals(char c11, Character ch2, String str) {
        AssertEquals.z(Character.valueOf(c11), ch2, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(char c11, Character ch2, String str) {
        AssertNotEquals.z(Character.valueOf(c11), ch2, str);
    }

    public static void assertEquals(Character ch2, char c11, String str) {
        AssertEquals.z(ch2, Character.valueOf(c11), str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Character ch2, char c11, String str) {
        AssertNotEquals.z(ch2, Character.valueOf(c11), str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Character ch2, Character ch3, String str) {
        AssertEquals.z(ch2, ch3, str);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Character ch2, Character ch3, String str) {
        AssertNotEquals.z(ch2, ch3, str);
    }

    public static void assertEquals(char c11, char c12, Supplier<String> supplier) {
        AssertEquals.f(c11, c12, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(char c11, char c12, Supplier<String> supplier) {
        AssertNotEquals.f(c11, c12, supplier);
    }

    public static void assertEquals(char c11, Character ch2, Supplier<String> supplier) {
        AssertEquals.A(Character.valueOf(c11), ch2, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(char c11, Character ch2, Supplier<String> supplier) {
        AssertNotEquals.A(Character.valueOf(c11), ch2, supplier);
    }

    public static void assertEquals(Character ch2, char c11, Supplier<String> supplier) {
        AssertEquals.A(ch2, Character.valueOf(c11), supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Character ch2, char c11, Supplier<String> supplier) {
        AssertNotEquals.A(ch2, Character.valueOf(c11), supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertEquals(Character ch2, Character ch3, Supplier<String> supplier) {
        AssertEquals.A(ch2, ch3, supplier);
    }

    @API(since = "5.4", status = API.Status.STABLE)
    public static void assertNotEquals(Character ch2, Character ch3, Supplier<String> supplier) {
        AssertNotEquals.A(ch2, ch3, supplier);
    }

    public static void assertEquals(Object obj, Object obj2) {
        AssertEquals.y(obj, obj2);
    }

    public static void assertNotEquals(Object obj, Object obj2) {
        AssertNotEquals.y(obj, obj2);
    }

    public static void assertEquals(Object obj, Object obj2, String str) {
        AssertEquals.z(obj, obj2, str);
    }

    public static void assertNotEquals(Object obj, Object obj2, String str) {
        AssertNotEquals.z(obj, obj2, str);
    }

    public static void assertEquals(Object obj, Object obj2, Supplier<String> supplier) {
        AssertEquals.A(obj, obj2, supplier);
    }

    public static void assertNotEquals(Object obj, Object obj2, Supplier<String> supplier) {
        AssertNotEquals.A(obj, obj2, supplier);
    }
}
