package com.instabug.library.internal.storage.cache.dbv2.migration;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class v extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ w f51105g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(w wVar) {
        super(0);
        this.f51105g = wVar;
    }

    @NotNull
    /* renamed from: a */
    public final t invoke() {
        return new t(this.f51105g.d());
    }
}
