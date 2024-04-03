package com.instabug.anr.di;

import com.instabug.commons.b;
import com.instabug.commons.configurations.a;
import com.instabug.commons.di.CommonsLocator;
import kotlin.Lazy;
import org.jetbrains.annotations.NotNull;

public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final c f45056a = new c();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Lazy f45057b = LazyKt__LazyJVMKt.lazy(a.f45054a);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Lazy f45058c = LazyKt__LazyJVMKt.lazy(b.f45055a);

    private c() {
    }

    @NotNull
    public static final com.instabug.anr.configuration.c b() {
        return (com.instabug.anr.configuration.c) f45058c.getValue();
    }

    @NotNull
    public static final b c() {
        return CommonsLocator.INSTANCE.getDetectorsListenersRegistry();
    }

    @NotNull
    public final a a() {
        return (a) f45057b.getValue();
    }
}
