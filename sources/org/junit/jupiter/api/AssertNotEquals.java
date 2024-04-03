package org.junit.jupiter.api;

import j$.util.function.Supplier;

class AssertNotEquals {
    private AssertNotEquals() {
    }

    public static void A(Object obj, Object obj2, Supplier<String> supplier) {
        if (AssertionUtils.o(obj, obj2)) {
            failEqual(obj2, supplier);
        }
    }

    public static void B(short s11, short s12) {
        C(s11, s12, (String) null);
    }

    public static void C(short s11, short s12, String str) {
        if (s11 == s12) {
            failEqual(Short.valueOf(s12), str);
        }
    }

    public static void D(short s11, short s12, Supplier<String> supplier) {
        if (s11 == s12) {
            failEqual(Short.valueOf(s12), supplier);
        }
    }

    public static void a(byte b11, byte b12) {
        b(b11, b12, (String) null);
    }

    public static void b(byte b11, byte b12, String str) {
        if (b11 == b12) {
            failEqual(Byte.valueOf(b12), str);
        }
    }

    public static void c(byte b11, byte b12, Supplier<String> supplier) {
        if (b11 == b12) {
            failEqual(Byte.valueOf(b12), supplier);
        }
    }

    public static void d(char c11, char c12) {
        e(c11, c12, (String) null);
    }

    public static void e(char c11, char c12, String str) {
        if (c11 == c12) {
            failEqual(Character.valueOf(c12), str);
        }
    }

    public static void f(char c11, char c12, Supplier<String> supplier) {
        if (c11 == c12) {
            failEqual(Character.valueOf(c12), supplier);
        }
    }

    private static void failEqual(Object obj, Object obj2) {
        AssertionFailureBuilder message = AssertionFailureBuilder.assertionFailure().message(obj2);
        message.reason("expected: not equal but was: <" + obj + ">").buildAndThrow();
    }

    public static void g(double d11, double d12) {
        k(d11, d12, (String) null);
    }

    public static void h(double d11, double d12, double d13) {
        i(d11, d12, d13, (String) null);
    }

    public static void i(double d11, double d12, double d13, String str) {
        if (AssertionUtils.d(d11, d12, d13)) {
            failEqual(Double.valueOf(d12), str);
        }
    }

    public static void j(double d11, double d12, double d13, Supplier<String> supplier) {
        if (AssertionUtils.d(d11, d12, d13)) {
            failEqual(Double.valueOf(d12), supplier);
        }
    }

    public static void k(double d11, double d12, String str) {
        if (AssertionUtils.c(d11, d12)) {
            failEqual(Double.valueOf(d12), str);
        }
    }

    public static void l(double d11, double d12, Supplier<String> supplier) {
        if (AssertionUtils.c(d11, d12)) {
            failEqual(Double.valueOf(d12), supplier);
        }
    }

    public static void m(float f11, float f12) {
        q(f11, f12, (String) null);
    }

    public static void n(float f11, float f12, float f13) {
        o(f11, f12, f13, (String) null);
    }

    public static void o(float f11, float f12, float f13, String str) {
        if (AssertionUtils.k(f11, f12, f13)) {
            failEqual(Float.valueOf(f12), str);
        }
    }

    public static void p(float f11, float f12, float f13, Supplier<String> supplier) {
        if (AssertionUtils.k(f11, f12, f13)) {
            failEqual(Float.valueOf(f12), supplier);
        }
    }

    public static void q(float f11, float f12, String str) {
        if (AssertionUtils.j(f11, f12)) {
            failEqual(Float.valueOf(f12), str);
        }
    }

    public static void r(float f11, float f12, Supplier<String> supplier) {
        if (AssertionUtils.j(f11, f12)) {
            failEqual(Float.valueOf(f12), supplier);
        }
    }

    public static void s(int i11, int i12) {
        t(i11, i12, (String) null);
    }

    public static void t(int i11, int i12, String str) {
        if (i11 == i12) {
            failEqual(Integer.valueOf(i12), str);
        }
    }

    public static void u(int i11, int i12, Supplier<String> supplier) {
        if (i11 == i12) {
            failEqual(Integer.valueOf(i12), supplier);
        }
    }

    public static void v(long j11, long j12) {
        w(j11, j12, (String) null);
    }

    public static void w(long j11, long j12, String str) {
        if (j11 == j12) {
            failEqual(Long.valueOf(j12), str);
        }
    }

    public static void x(long j11, long j12, Supplier<String> supplier) {
        if (j11 == j12) {
            failEqual(Long.valueOf(j12), supplier);
        }
    }

    public static void y(Object obj, Object obj2) {
        z(obj, obj2, (String) null);
    }

    public static void z(Object obj, Object obj2, String str) {
        if (AssertionUtils.o(obj, obj2)) {
            failEqual(obj2, str);
        }
    }
}
