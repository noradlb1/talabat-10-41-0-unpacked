package com.instabug.crash;

import com.google.android.exoplayer2.ExoPlayer;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;

public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f46376a = new a();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Pair f46377b = TuplesKt.to("crash_reporting_availability", Boolean.TRUE);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Pair f46378c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final Pair f46379d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final Pair f46380e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final Pair f46381f = TuplesKt.to("fatal_hangs_sensitivity", Long.valueOf(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS));
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final Pair f46382g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private static final Pair f46383h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private static final Pair f46384i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private static final Pair f46385j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private static final Pair f46386k = TuplesKt.to("terminations_threshold", 30000L);
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private static final Pair f46387l = TuplesKt.to("terminations_state_ratio", Float.valueOf(0.3f));

    static {
        Boolean bool = Boolean.FALSE;
        f46378c = TuplesKt.to("is_crash_reporting_migrated", bool);
        f46379d = TuplesKt.to("anr_availability", bool);
        f46380e = TuplesKt.to("fatal_hangs_availability", bool);
        f46382g = TuplesKt.to("is_anr_migrated", bool);
        f46383h = TuplesKt.to("is_fatal_hangs_migrated", bool);
        f46384i = TuplesKt.to("is_terminations_migrated", bool);
        f46385j = TuplesKt.to("terminations_availability", bool);
    }

    private a() {
    }

    @NotNull
    public final Pair a() {
        return f46379d;
    }

    @NotNull
    public final Pair b() {
        return f46377b;
    }

    @NotNull
    public final Pair c() {
        return f46380e;
    }

    @NotNull
    public final Pair d() {
        return f46381f;
    }

    @NotNull
    public final Pair e() {
        return f46382g;
    }

    @NotNull
    public final Pair f() {
        return f46378c;
    }

    @NotNull
    public final Pair g() {
        return f46383h;
    }

    @NotNull
    public final Pair h() {
        return f46384i;
    }

    @NotNull
    public final Pair i() {
        return f46385j;
    }

    @NotNull
    public final Pair j() {
        return f46387l;
    }

    @NotNull
    public final Pair k() {
        return f46386k;
    }
}
