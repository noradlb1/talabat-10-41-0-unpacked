package com.instabug.library.sessionV3.sync;

import com.instabug.library.networkv2.limitation.RateLimiter;
import com.instabug.library.sessionV3.di.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class l extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public static final l f51839a = new l();

    public l() {
        super(0);
    }

    @NotNull
    /* renamed from: a */
    public final RateLimiter invoke() {
        return c.f51790a.a((Function1) k.f51838a);
    }
}
