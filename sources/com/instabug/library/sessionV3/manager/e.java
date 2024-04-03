package com.instabug.library.sessionV3.manager;

import com.instabug.library.sessionV3.di.c;
import java.util.concurrent.Executor;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class e extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public static final e f51796a = new e();

    public e() {
        super(0);
    }

    @NotNull
    /* renamed from: a */
    public final Executor invoke() {
        return c.f51790a.g();
    }
}
