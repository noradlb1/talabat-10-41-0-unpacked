package com.instabug.library.diagnostics.diagnostics_db;

import android.provider.BaseColumns;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

public final class o implements BaseColumns {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final o f34283a = new o();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Pair f34284b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Pair f34285c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final String f34286d;

    static {
        Boolean bool = Boolean.TRUE;
        Pair pair = new Pair("key", bool);
        f34284b = pair;
        Pair pair2 = new Pair("count", bool);
        f34285c = pair2;
        f34286d = "CREATE TABLE IF NOT EXISTS sdk_events ( " + ((String) pair.component1()) + " TEXT PRIMARY KEY , " + ((String) pair2.component1()) + " INTEGER ) ";
    }

    private o() {
    }

    @NotNull
    public final Pair a() {
        return f34285c;
    }

    @NotNull
    public final Pair b() {
        return f34284b;
    }

    @NotNull
    public final String c() {
        return f34286d;
    }
}
