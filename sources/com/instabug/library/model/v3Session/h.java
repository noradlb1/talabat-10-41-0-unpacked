package com.instabug.library.model.v3Session;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class h {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Map f51608a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final List f51609b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final List f51610c;

    public h(@NotNull Map map, @NotNull List list, @NotNull List list2) {
        Intrinsics.checkNotNullParameter(map, "commonKeys");
        Intrinsics.checkNotNullParameter(list, "sessions");
        Intrinsics.checkNotNullParameter(list2, "sessionsIds");
        this.f51608a = map;
        this.f51609b = list;
        this.f51610c = list2;
    }

    @NotNull
    public final Map a() {
        return this.f51608a;
    }

    @NotNull
    public final List b() {
        return this.f51609b;
    }

    @NotNull
    public final List c() {
        return this.f51610c;
    }
}
