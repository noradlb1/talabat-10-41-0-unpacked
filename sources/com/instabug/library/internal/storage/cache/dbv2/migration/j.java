package com.instabug.library.internal.storage.cache.dbv2.migration;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class j extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ k f51089g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(k kVar) {
        super(0);
        this.f51089g = kVar;
    }

    @NotNull
    /* renamed from: a */
    public final h invoke() {
        return new h(this.f51089g.d());
    }
}
