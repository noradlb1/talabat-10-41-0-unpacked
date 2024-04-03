package com.instabug.terminations.sync;

import com.instabug.library.networkv2.limitation.RateLimiter;
import com.instabug.terminations.di.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class h extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public static final h f52656a = new h();

    public h() {
        super(0);
    }

    @NotNull
    /* renamed from: a */
    public final RateLimiter invoke() {
        return d.f52610a.a((Function1) g.f52655a);
    }
}
