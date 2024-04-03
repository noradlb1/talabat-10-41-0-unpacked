package com.instabug.terminations;

import com.instabug.commons.snapshot.Captor;
import com.instabug.commons.utils.a;
import com.instabug.terminations.di.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class e {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final e f52618a = new e();

    private e() {
    }

    public static /* synthetic */ Captor a(e eVar, Function0 function0, Function0 function02, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function0 = new b(d.f52610a);
        }
        if ((i11 & 2) != 0) {
            function02 = new c(d.f52610a.q());
        }
        if ((i11 & 4) != 0) {
            function1 = new d(d.f52610a);
        }
        return eVar.a(function0, function02, function1);
    }

    @NotNull
    public final Captor a(@NotNull Function0 function0, @NotNull Function0 function02, @NotNull Function1 function1) {
        Intrinsics.checkNotNullParameter(function0, "ctxGetter");
        Intrinsics.checkNotNullParameter(function02, "savingDirectoryGetter");
        Intrinsics.checkNotNullParameter(function1, "executorFactory");
        com.instabug.commons.snapshot.e eVar = new com.instabug.commons.snapshot.e(function0, function02, function1);
        if (a.a()) {
            return new s(eVar);
        }
        return new z(eVar, d.f52610a.f());
    }
}
