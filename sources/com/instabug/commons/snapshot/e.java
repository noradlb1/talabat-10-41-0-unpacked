package com.instabug.commons.snapshot;

import android.content.Context;
import java.io.File;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class e {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Function0 f46343a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Function0 f46344b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Function1 f46345c;

    public e(@NotNull Function0 function0, @NotNull Function0 function02, @NotNull Function1 function1) {
        Intrinsics.checkNotNullParameter(function0, "ctxGetter");
        Intrinsics.checkNotNullParameter(function02, "savingDirectoryGetter");
        Intrinsics.checkNotNullParameter(function1, "executorFactory");
        this.f46343a = function0;
        this.f46344b = function02;
        this.f46345c = function1;
    }

    @Nullable
    public final Context a() {
        return (Context) this.f46343a.invoke();
    }

    @NotNull
    public final Function1 b() {
        return this.f46345c;
    }

    @Nullable
    public final File c() {
        return (File) this.f46344b.invoke();
    }
}
