package com.instabug.library.model.v3Session;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final /* synthetic */ class a extends FunctionReferenceImpl implements Function1 {
    public a(Object obj) {
        super(1, obj, b.class, "escapeSpecialCharacters", "escapeSpecialCharacters(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    @NotNull
    /* renamed from: a */
    public final String invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        return ((b) this.receiver).a(str);
    }
}
