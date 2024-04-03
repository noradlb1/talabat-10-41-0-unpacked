package com.instabug.library.sessionV3.sync;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class k extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final k f51838a = new k();

    public k() {
        super(1);
    }

    public final void a(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "ids");
        n.f51841a.d().a(list);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.INSTANCE;
    }
}
