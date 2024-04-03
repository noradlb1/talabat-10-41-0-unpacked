package com.instabug.terminations;

import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final /* synthetic */ class t extends FunctionReferenceImpl implements Function1 {
    public t(Object obj) {
        super(1, obj, v.class, "validate", "validate(Ljava/io/File;)V", 0);
    }

    public final void a(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "p0");
        ((v) this.receiver).g(file);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((File) obj);
        return Unit.INSTANCE;
    }
}
