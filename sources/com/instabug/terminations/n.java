package com.instabug.terminations;

import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final /* synthetic */ class n extends AdaptedFunctionReference implements Function1 {
    public n(Object obj) {
        super(1, obj, p.class, "validateOldDetection", "validateOldDetection-CmtIpJM(Ljava/io/File;)Lkotlin/Result;", 8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((File) obj);
        return Unit.INSTANCE;
    }

    public final void a(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "p0");
        ((p) this.f23889b).g(file);
    }
}
