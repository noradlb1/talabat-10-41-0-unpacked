package com.instabug.terminations;

import com.instabug.terminations.di.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class g0 extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ i0 f52621g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g0(i0 i0Var) {
        super(0);
        this.f52621g = i0Var;
    }

    public final void a() {
        this.f52621g.a(true);
        d.f52610a.d().consentOnCleansing(2);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }
}
