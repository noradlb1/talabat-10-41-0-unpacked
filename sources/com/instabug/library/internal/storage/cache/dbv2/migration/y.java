package com.instabug.library.internal.storage.cache.dbv2.migration;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class y extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ z f51109g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(z zVar) {
        super(0);
        this.f51109g = zVar;
    }

    @NotNull
    /* renamed from: a */
    public final w invoke() {
        return new w(this.f51109g.d());
    }
}
