package com.instabug.fatalhangs;

import com.instabug.library.Instabug;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class c extends Lambda implements Function1 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ d f46454g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(d dVar) {
        super(1);
        this.f46454g = dVar;
    }

    public final void a(@NotNull com.instabug.fatalhangs.model.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "fatalHang");
        com.instabug.fatalhangs.di.c.f46466a.b().a(cVar, Instabug.getApplicationContext());
        this.f46454g.l();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((com.instabug.fatalhangs.model.c) obj);
        return Unit.INSTANCE;
    }
}
