package com.instabug.commons.caching;

import java.io.File;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class d extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final d f46286a = new d();

    public d() {
        super(1);
    }

    @NotNull
    /* renamed from: a */
    public final Pair invoke(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "it");
        return TuplesKt.to(file, h.f46290f.b(file));
    }
}
