package com.instabug.library.internal.storage.cache.dbv2.migration;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class g extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ h f51085g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(h hVar) {
        super(0);
        this.f51085g = hVar;
    }

    @NotNull
    /* renamed from: a */
    public final e invoke() {
        return new e(this.f51085g.d());
    }
}
