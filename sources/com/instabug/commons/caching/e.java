package com.instabug.commons.caching;

import java.io.File;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class e extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final e f46287a = new e();

    public e() {
        super(1);
    }

    public final void a(@NotNull Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "$dstr$dir$starterFile");
        File file = (File) pair.component1();
        if (((File) pair.component2()) == null) {
            boolean unused = FilesKt__UtilsKt.deleteRecursively(file);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.INSTANCE;
    }
}
