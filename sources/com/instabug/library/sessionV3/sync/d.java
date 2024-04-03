package com.instabug.library.sessionV3.sync;

import com.instabug.library.sessionV3.cache.SessionCacheManager;
import com.instabug.library.sessionV3.di.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class d extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public static final d f51830a = new d();

    public d() {
        super(0);
    }

    @NotNull
    /* renamed from: a */
    public final SessionCacheManager invoke() {
        return c.k();
    }
}
