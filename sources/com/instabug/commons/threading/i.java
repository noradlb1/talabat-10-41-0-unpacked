package com.instabug.commons.threading;

import java.lang.Thread;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class i extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final i f46358a = new i();

    public i() {
        super(1);
    }

    @NotNull
    /* renamed from: a */
    public final Boolean invoke(@NotNull Thread thread) {
        boolean z11;
        Intrinsics.checkNotNullParameter(thread, "it");
        if (thread.getState() == Thread.State.TERMINATED) {
            z11 = true;
        } else {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }
}
