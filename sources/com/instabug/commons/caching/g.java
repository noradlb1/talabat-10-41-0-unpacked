package com.instabug.commons.caching;

import java.io.File;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class g extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final g f46289a = new g();

    public g() {
        super(1);
    }

    @NotNull
    /* renamed from: a */
    public final File invoke(@NotNull Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "$dstr$dir$_u24__u24");
        return (File) pair.component1();
    }
}
