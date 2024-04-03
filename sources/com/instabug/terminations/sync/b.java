package com.instabug.terminations.sync;

import com.instabug.library.model.State;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class b extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final b f52652a = new b();

    public b() {
        super(1);
    }

    @NotNull
    /* renamed from: a */
    public final Boolean invoke(State.StateItem stateItem) {
        Intrinsics.checkNotNullExpressionValue(stateItem, "(key, _)");
        return Boolean.valueOf(Intrinsics.areEqual((Object) e.c(stateItem), (Object) State.KEY_CURRENT_ACTIVITY));
    }
}
