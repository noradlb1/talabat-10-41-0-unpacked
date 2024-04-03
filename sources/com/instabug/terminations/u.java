package com.instabug.terminations;

import com.instabug.terminations.model.b;
import java.io.File;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final /* synthetic */ class u extends FunctionReferenceImpl implements Function1 {
    public u(Object obj) {
        super(1, obj, v.class, "migrate", "migrate(Ljava/io/File;)Lcom/instabug/terminations/model/Termination;", 0);
    }

    @Nullable
    /* renamed from: a */
    public final b invoke(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "p0");
        return ((v) this.receiver).f(file);
    }
}
