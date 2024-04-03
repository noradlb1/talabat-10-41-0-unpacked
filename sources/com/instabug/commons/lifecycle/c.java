package com.instabug.commons.lifecycle;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Set f46330a = new LinkedHashSet();

    static {
        new a((DefaultConstructorMarker) null);
    }

    public c(@NotNull ScheduledExecutorService scheduledExecutorService) {
        Intrinsics.checkNotNullParameter(scheduledExecutorService, "notificationExecutor");
    }

    public final void a(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "observer");
        this.f46330a.add(bVar);
    }

    public final void b(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "observer");
        this.f46330a.remove(bVar);
    }
}
