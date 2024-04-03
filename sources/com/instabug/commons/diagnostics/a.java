package com.instabug.commons.diagnostics;

import kotlin.Pair;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;

public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f46307a = new a();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Pair f46308b = TuplesKt.to("is_crash_diagnostics_available", Boolean.TRUE);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Pair f46309c = new Pair("os_exit_info_time_baseline", -1L);

    private a() {
    }

    @NotNull
    public final Pair a() {
        return f46308b;
    }

    @NotNull
    public final Pair b() {
        return f46309c;
    }
}
