package com.instabug.library.internal.storage.cache.dbv2.migration;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class m extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ n f51093g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(n nVar) {
        super(0);
        this.f51093g = nVar;
    }

    @NotNull
    /* renamed from: a */
    public final k invoke() {
        return new k(this.f51093g.d());
    }
}
