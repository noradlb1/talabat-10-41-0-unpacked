package com.instabug.terminations;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class f0 extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ i0 f52619g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f0(i0 i0Var) {
        super(0);
        this.f52619g = i0Var;
    }

    public final void a() {
        this.f52619g.a(false);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }
}
