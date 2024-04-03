package com.instabug.terminations.sync;

import com.instabug.library.model.State;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class a extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final a f52651a = new a();

    public a() {
        super(1);
    }

    @NotNull
    /* renamed from: a */
    public final Boolean invoke(State.StateItem stateItem) {
        boolean z11;
        Intrinsics.checkNotNullExpressionValue(stateItem, "(key, value)");
        String a11 = e.c(stateItem);
        Object b11 = e.d(stateItem);
        if (a11 == null || b11 == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }
}
