package com.instabug.crash.di;

import com.instabug.anr.d;
import com.instabug.terminations.i0;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class c extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public static final c f46398a = new c();

    public c() {
        super(0);
    }

    @NotNull
    /* renamed from: a */
    public final List invoke() {
        return CollectionsKt__CollectionsKt.listOf(new com.instabug.crash.c(), new d(), new com.instabug.fatalhangs.d(), new i0(), new com.instabug.commons.diagnostics.d());
    }
}
