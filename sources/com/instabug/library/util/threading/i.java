package com.instabug.library.util.threading;

import java.util.concurrent.ThreadFactory;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class i implements ThreadFactory {
    @Nullable
    private final String identifier;
    private int threadNum;

    public i(@Nullable String str) {
        this.identifier = str;
    }

    public static /* synthetic */ Thread createThread$default(i iVar, Runnable runnable, Function1 function1, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                function1 = f.f52108a;
            }
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            Intrinsics.checkNotNullParameter(function1, "onInterrupt");
            return new g(runnable, iVar, function1);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createThread");
    }

    @NotNull
    public final Thread createThread(@NotNull Runnable runnable, @NotNull Function1<? super Thread, Unit> function1) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Intrinsics.checkNotNullParameter(function1, "onInterrupt");
        return new g(runnable, this, function1);
    }

    @Nullable
    public final String getIdentifier() {
        return this.identifier;
    }

    public final int increment() {
        int i11 = this.threadNum;
        this.threadNum = i11 + 1;
        return i11;
    }

    @NotNull
    public Thread newThread(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        return new h(runnable, this);
    }

    @NotNull
    public final Thread rename(@NotNull Thread thread, @Nullable String str) {
        Intrinsics.checkNotNullParameter(thread, "<this>");
        thread.setName(j.a(str, this.threadNum));
        increment();
        return thread;
    }
}
