package com.instabug.fatalhangs;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class f extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Looper f46471g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Looper looper) {
        super(0);
        this.f46471g = looper;
    }

    @NotNull
    /* renamed from: a */
    public final Handler invoke() {
        return new Handler(this.f46471g);
    }
}
