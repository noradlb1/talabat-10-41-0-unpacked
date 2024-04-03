package com.instabug.commons;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class a implements c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List f46284a = new ArrayList();

    public void a(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f46284a.remove(bVar);
    }

    public void b(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f46284a.add(bVar);
    }

    public void a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "detection");
        for (b a11 : this.f46284a) {
            a11.a(str);
        }
    }
}
