package com.instabug.commons.caching;

import java.io.File;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

final class b extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ h f46285g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(h hVar) {
        super(0);
        this.f46285g = hVar;
    }

    @Nullable
    /* renamed from: a */
    public final File invoke() {
        return (File) this.f46285g.f46292b.invoke(this.f46285g.f46291a.invoke());
    }
}
