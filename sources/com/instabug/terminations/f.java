package com.instabug.terminations;

import android.content.Context;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final /* synthetic */ class f extends FunctionReferenceImpl implements Function2 {
    public f(Object obj) {
        super(2, obj, g.class, "getSnapshot", "getSnapshot(Landroid/content/Context;Ljava/lang/Object;)Lcom/instabug/terminations/TerminationSnapshot;", 0);
    }

    @NotNull
    /* renamed from: a */
    public final b0 invoke(@NotNull Context context, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(context, "p0");
        return ((g) this.receiver).a(context, obj);
    }
}
