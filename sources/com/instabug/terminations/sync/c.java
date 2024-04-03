package com.instabug.terminations.sync;

import com.instabug.library.model.State;
import com.instabug.library.networkv2.request.RequestParameter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class c extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final c f52653a = new c();

    public c() {
        super(1);
    }

    @NotNull
    /* renamed from: a */
    public final RequestParameter invoke(State.StateItem stateItem) {
        Intrinsics.checkNotNullExpressionValue(stateItem, "(key, value)");
        return new RequestParameter(e.c(stateItem), e.d(stateItem));
    }
}
