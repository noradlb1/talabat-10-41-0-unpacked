package com.instabug.terminations.sync;

import android.content.Context;
import com.instabug.terminations.di.d;
import com.instabug.terminations.model.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class g extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final g f52655a = new g();

    public g() {
        super(1);
    }

    public final void a(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "termination");
        bVar.a();
        d dVar = d.f52610a;
        Context a11 = dVar.a();
        if (a11 != null) {
            dVar.b().a(a11, bVar);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((b) obj);
        return Unit.INSTANCE;
    }
}
