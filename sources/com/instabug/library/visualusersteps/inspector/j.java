package com.instabug.library.visualusersteps.inspector;

import androidx.annotation.NonNull;
import io.reactivex.Maybe;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Iterator;

abstract class j {
    /* access modifiers changed from: private */
    @NonNull
    public static Maybe b(Iterator it) {
        return Maybe.create(new i(it));
    }

    @NonNull
    public static Predicate c(float f11, float f12) {
        return new c(f11, f12);
    }

    @NonNull
    public static Function d() {
        return new f();
    }

    @NonNull
    public static Function e() {
        return new g();
    }

    @NonNull
    public static Function f() {
        return new e();
    }

    @NonNull
    public static Function g() {
        return new h();
    }

    @NonNull
    public static Predicate h() {
        return new b();
    }

    @NonNull
    public static Function b() {
        return new d();
    }
}
