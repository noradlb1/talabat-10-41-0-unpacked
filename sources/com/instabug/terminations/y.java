package com.instabug.terminations;

import android.content.Context;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class y extends Lambda implements Function2 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f52675g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(String str) {
        super(2);
        this.f52675g = str;
    }

    @NotNull
    /* renamed from: a */
    public final x invoke(@NotNull Context context, @Nullable Object obj) {
        x xVar;
        Intrinsics.checkNotNullParameter(context, "ctx");
        if (obj instanceof x) {
            xVar = (x) obj;
        } else {
            xVar = null;
        }
        return w.f52670a.a(context, xVar, this.f52675g);
    }
}
