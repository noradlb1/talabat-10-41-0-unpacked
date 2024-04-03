package com.instabug.library.internal.storage.cache.dbv2.migration;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class p extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ q f51097g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(q qVar) {
        super(0);
        this.f51097g = qVar;
    }

    @NotNull
    /* renamed from: a */
    public final n invoke() {
        return new n(this.f51097g.d());
    }
}
