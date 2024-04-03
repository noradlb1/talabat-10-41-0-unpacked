package com.instabug.commons.caching;

import java.io.File;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class f extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final f f46288a = new f();

    public f() {
        super(1);
    }

    @NotNull
    /* renamed from: a */
    public final Boolean invoke(@NotNull Pair pair) {
        boolean z11;
        Intrinsics.checkNotNullParameter(pair, "$dstr$_u24__u24$starterFile");
        if (((File) pair.component2()) == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }
}
