package com.instabug.library.internal.storage.cache.dbv2.migration;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class s extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ t f51101g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(t tVar) {
        super(0);
        this.f51101g = tVar;
    }

    @NotNull
    /* renamed from: a */
    public final q invoke() {
        return new q(this.f51101g.d());
    }
}
