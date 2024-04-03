package com.instabug.apm.cache.handler.experiment.mapping;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final /* synthetic */ class b extends FunctionReferenceImpl implements Function1 {
    public b(Object obj) {
        super(1, obj, c.class, "escapeSpecialCharacters", "escapeSpecialCharacters(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    @NotNull
    /* renamed from: a */
    public final String invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        return ((c) this.receiver).a(str);
    }
}
