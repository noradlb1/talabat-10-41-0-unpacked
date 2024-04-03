package com.instabug.library.sessionV3.sync;

import java.util.Collection;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class w extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final w f51857a = new w();

    public w() {
        super(1);
    }

    @NotNull
    /* renamed from: a */
    public final Collection invoke(@NotNull Map map) {
        Intrinsics.checkNotNullParameter(map, "it");
        return map.values();
    }
}
