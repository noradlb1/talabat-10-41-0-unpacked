package com.instabug.commons.threading;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

final class b extends Lambda implements Function1 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ c f46352g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(c cVar) {
        super(1);
        this.f46352g = cVar;
    }

    public final void a(@NotNull StringBuilder sb2) {
        Intrinsics.checkNotNullParameter(sb2, "$this$getFormattedStackTrace");
        String a11 = this.f46352g.f46354b;
        if (a11 != null) {
            sb2.append(a11);
            sb2.append(StringUtils.LF);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((StringBuilder) obj);
        return Unit.INSTANCE;
    }
}
